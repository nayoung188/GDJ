
/*

    PL/SQL
    1. 오라클의 프로그래밍 처리가 가능한 SQL
    2. 프로그래밍 형식
        [DECLARE]
            [변수 선언]
        BEGIN
            수행할 PL/SQL
        END;
        
     3. PL/SQL의 데이터( 변수, 상수) 는 서버메시지로 출력   
     4. 서버메시지 출력을 위해서 최초 1회 설정이 필요 (디폴트 SET SERVEROUTPUT OFF)
        SET SERVEROUTPUT ON;


*/


-- 기초 데이터 준비

-- HR 계정의 EMPLOYEES 테이블을 SCOTT 계정으로 복사해 오기

CREATE TABLE EMPLOYEES
    AS (SELECT *
          FROM HR.EMPLOYEES);

-- 기본키 다시 생성
ALTER TABLE EMPLOYEES
    ADD CONSTRAINT PK_EMPLOYEES PRIMARY KEY(EMPLOYEE_ID);





