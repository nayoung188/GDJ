-- HR 계정 접속


-- 1. DEPARTMENT_NAME의 오름차순 정렬 기준으로 전체 사원들의 EMPLOYEE_ID, FIRST_NAME, DEPARTMENT_ID를 조회하시오.

-- 조인
-- DEPARTMENTS 테이블  ->  DEPARTMENT_NAME
-- EMPLOYEES   테이블  ->  EMPLOYEE_ID, FIRST_NAME, DEPARTMENT_ID
SELECT E.EMPLOYEE_ID, E.FIRST_NAME, E.DEPARTMENT_ID, D.DEPARTMENT_NAME
    FROM DEPARTMENTS D INNER JOIN EMPLOYEES E
     ON D.DEPARTMENT_ID = E.DEPARTMENT_ID
 ORDER BY D.DEPARTMENT_NAME ASC;   

-- 타입이 섞여 있는 경우의 오름차순 정렬
-- 문자 -> 숫자 -> 날짜 -> NULL


-- 2. DEPARTMENT_ID가 20인 사원중에서 전체 평균 연봉(SALARY) 이상을 받는 사원의 EMPLOYEE_ID, FIRST_NAME, DEPARTMENT_ID, SALARY를 조회하시오.

-- 테이블 하나에 있으므로 조인이 아님
-- 서브쿼리 : 전체 평균 연봉
-- 메인쿼리 : SELECT 칼럼 FROM 테이블 WHERE 부서번호 = 20 AND 연봉 >= (전체평균연봉)
SELECT EMPLOYEE_ID, FIRST_NAME, DEPARTMENT_ID, SALARY
    FROM EMPLOYEES
    WHERE DEPARTMENT_ID = 20
    AND SALARY >= (SELECT AVG(SALARY)
                     FROM EMPLOYEES);


-- 3. JOB_ID가 'IT_PROG'인 사원중에서 가장 높은 연봉(SALARY)을 받는 사원의 연봉보다 더 많은 연봉을 받는 사원들의 EMPLOYEE_ID, FIRST_NAME, JOB_ID, SALARY를 조회하시오.

-- 서브쿼리 : 최대연본
-- 메인쿼리 : SELECT 칼럼 FROM 테이블 WHERE 연봉 > (직업 = 'IT_PROG' 의 최대연봉)

SELECT EMPLOYEE_ID, FIRST_NAME, JOB_ID, SALARY
    FROM EMPLOYEES
    WHERE SALARY > (SELECT MAX(SALARY)
                    FROM EMPLOYEES
                    WHERE JOB_ID = 'IT_PROG');


-- 4. EMPLOYEE_ID가 115인 사원과 동일한 JOB_ID와 DEPARTMENT_ID를 가진 사원의 EMPLOYEE_ID, FIRST_NAME, JOB_ID, DEPARTMENT_ID를 조회하시오.

-- 서브쿼리 : 사원번호가 115인 사원의 JOB_ID와 DEPARTMENT_ID를 가져오기   (단일 행 서브쿼리)
-- 메인쿼리 : SELECT 칼럼 FROM 테이블 WHERE (JOB_ID, DEPARTMENT_ID) = (서브쿼리)     : 단일 행
-- 메인쿼리 : SELECT 칼럼 FROM 테이블 WHERE (JOB_ID, DEPARTMENT_ID) IN (서브쿼리)    : 다중 행    

SELECT EMPLOYEE_ID, FIRST_NAME, JOB_ID, DEPARTMENT_ID
    FROM EMPLOYEES
    WHERE (JOB_ID, DEPARTMENT_ID) = ( SELECT JOB_ID, DEPARTMENT_ID
                                        FROM EMPLOYEES
                                        WHERE EMPLOYEE_ID = 115);

-- 5. LOCATION_ID가 1000~1500 사이인 국가들의 COUNTRY_ID, COUNTRY_NAME을 조회하시오.

-- 부모 (PK)               -   자식 (FK)
-- COUNTRIES(COUNTRY_ID)    -   LOCATIONS(COUNTRY_ID)

-- 1) 조인
SELECT DISTINCT C.COUNTRY_ID, C.COUNTRY_NAME
    FROM COUNTRIES C INNER JOIN LOCATIONS L 
      ON C.COUNTRY_ID = L.COUNTRY_ID
  WHERE L.LOCATION_ID BETWEEN 1000 AND 1500;
  
-- 2) 서브쿼리
-- 서브쿼리 : LOCATION_ID가 1000~1500인 지역의 COUTRY_ID 가져오기 (다중 행 서브쿼리)
-- 메인쿼리 : SELECT 칼럼 FROM COUNTRY WHERE COUNTRY_ID = (서브쿼리)
SELECT COUNTRY_ID, COUNTRY_NAME
 FROM COUNTRIES
 WHERE COUNTRY_ID IN ( SELECT COUNTRY_ID
                        FROM LOCATIONS
                        WHERE LOCATION_ID BETWEEN 1000 AND 1500);


-- 6. MANAGER가 아닌 사원들의 EMPLOYEE_ID, FIRST_NAME을 조회하시오.
-- MANAGER가 아닌 사원 : EMPLOYEE_ID가 MANAGER_ID에 없는 사원
-- 서브쿼리 : MANAGER_ID의 중복 제거 결과 (MANAGER의 번호 모아두기)
-- 메인쿼리 : SELECT 칼럼 FROM 테이블 WHERE EMPLOYEE_ID NOT IN (서브쿼리)

-- 서브쿼리의 결과가 NULL을 포함하면 메인쿼리가 동작하지 않는다.

SELECT EMPLOYEE_ID, FIRST_NAME
  FROM EMPLOYEES
  WHERE EMPLOYEE_ID NOT IN (SELECT DISTINCT MANAGER_ID
                                FROM EMPLOYEES
                                WHERE MANAGER_ID IS NOT NULL);

-- 7. 근무하는 CITY가 'Southlake'인 사원들의 EMPLOYEE_ID, FIRST_NAME를 조회하시오.

-- 1) 조인
-- 관계
-- LOCATIONS            - DEPARTMENTS                   - EMPLOYEES
-- CITY, LOCATION_ID    - LOCATION_ID, DEPARTMENT_ID    - DEPARTMENT_ID,EMPLOYEE_ID, FIRST_NAME
--        (PK)               (FK)        (PK)               (FK)                    

SELECT E.EMPLOYEE_ID, E.FIRST_NAME, L.CITY
 FROM LOCATIONS L, DEPARTMENTS D, EMPLOYEES E
 WHERE L.LOCATION_ID = D.LOCATION_ID
 AND D.DEPARTMENT_ID = E.DEPARTMENT_ID
 AND L.CITY = 'Southlake';

-- 2) 서브쿼리



-- 8. 가장 많은 사원이 근무 중인 부서의 DEPARTMENT_ID와 근무 인원 수를 조회하시오.

-- 가장 많은 사원이 근무 중인 부서 : 부서별 사원수를 구해야 알 수 있음  ->  GROUP BY

-- 조건 : 근무중인사원수 = 최대사원수
-- HAVING절, 집계함수를 이용한 조건은 HAVING절만 가능함


SELECT DEPARTMENT_ID, COUNT(*)
    FROM EMPLOYEES
    WHERE DEPARTMENT_ID IS NOT NULL
    GROUP BY DEPARTMENT_ID
    HAVING COUNT(*) = ( SELECT MAX(COUNT(*))
                            FROM EMPLOYEES
                            GROUP BY DEPARTMENT_ID);

-- PARTITION BY 를 활용


-- 9. 전체 사원 중 최대 연봉을 받는 사원의 EMPLOYEE_ID, FIRST_NAME, SALARY를 조회하시오.

-- 인라인뷰 A : 최대 연봉이 맨 위에 있는 테이블
-- 인라인뷰 B : 연봉순으로 정렬된 테이블에 행 번호(RN)를 부착시켜 둔 테이블
-- 최종결과 : 인라인뷰 B에서 행 번호 (RN)가 1인 행 조회

SELECT B.EMPLOYEE_ID, B.FIRST_NAME, B.SALARY
    FROM (SELECT ROWNUM AS RN, A.EMPLOYEE_ID, A.FIRST_NAME, A.SALARY
            FROM ( SELECT EMPLOYEE_ID, FIRST_NAME, SALARY
                    FROM EMPLOYEES
                    ORDER BY SALARY DESC) A ) B
    WHERE B.RN = 1;                



-- 10. 연봉 TOP 11 ~ 20 사원의 EMPLOYEE_ID, FIRST_NAME, SALARY를 조회하시오.

-- 인라인뷰 A : 연봉순으로 정렬된 뒤 행 번호(RN)가 부착된 테이블

SELECT A.EMPLOYEE_ID, A.FIRST_NAME, A.SALARY
    FROM ( SELECT ROW_NUMBER() OVER(ORDER BY SALARY DESC) AS RN, EMPLOYEE_ID, FIRST_NAME, SALARY
            FROM EMPLOYEES) A
  WHERE A.RN BETWEEN 11 AND 20;          
            
            
            
            