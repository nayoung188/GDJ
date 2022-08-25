DROP TABLE EMPLOYEE;
DROP TABLE DEPARTMENT;

CREATE TABLE DEPARTMENT(
    DEPT_NO     NUMBER              NOT NULL,
    DEPT_NAME   VARCHAR2(15 BYTE)   NOT NULL,
    LOCATION    VARCHAR2(15 BYTE)   NOT NULL
);

CREATE TABLE EMPLOYEE(
    EMP_NO  NUMBER              NOT NULL,
    NAME    VARCHAR2(20 BYTE)   NOT NULL,
    DEPART  NUMBER              NOT NULL,
    POSITION    VARCHAR2(20 BYTE)   NULL,
    GENDER  CHAR(2)                 NULL,
    HIRE_DATE   DATE                NULL,
    SALARY      NUMBER              NULL
);

ALTER TABLE DEPARTMENT
    ADD CONSTRAINT PK_DEPARTMENT PRIMARY KEY (DEPT_NO);
ALTER TABLE EMPLOYEE
    ADD CONSTRAINT PK_EMPLOYEE PRIMARY KEY (EMP_NO);

ALTER TABLE EMPLOYEE 
    ADD CONSTRAINT FK_EMPLOYEE_DEPARTMENT FOREIGN KEY (DEPART)
        REFERENCES DEPARTMENT (DEPT_NO)
            ON DELETE SET NULL;
            
            
            
            
/*********
/*
    DML
    1. Date Manipulation Language
    2. 데이터 조작어
    3. 행(Row, Record, Tuple) 단위 삽입, 수정, 삭제
    4. 트랜잭션(작업) 완료를 위해 COMMIT이 필요
    5. 트랜잭션(작업) 취소를 위해 ROLLBACK 사용 가능
    6. 종류
        1) INSERT INTO VALUES
        2) UPDATE SET WHERE
        3) DELETE FROM WHERE
*/

/*
     행 삽입
     1. 지정한 칼럼에 삽입
         INSERT INTO 테이블(칼럼1, 칼럼2) VALUES(값1, 값2);
    2. 모든 칼럼에 데이터 삽입 (칼럼 리스트 생략
         INSERT INTO 테이블 VALUES (값1, 값2)

*/
-- 부서 테이블에 행(Row) 삽입
-- 부모테이블(관계에서 PK를 가진 테이블)에 먼저 삽입을 해야 함
INSERT INTO DEPARTMENT
    (DEPT_NO, DEPT_NAME, LOCATION)
VALUES
    (1, '영업부', '대구');
INSERT INTO DEPARTMENT
    (DEPT_NO, DEPT_NAME, LOCATION)
VALUES
    (2, '인사부', '서울');
INSERT INTO DEPARTMENT
    (DEPT_NO, DEPT_NAME, LOCATION)
VALUES
    (3, '총무부', '대구');
INSERT INTO DEPARTMENT
    (DEPT_NO, DEPT_NAME, LOCATION)
VALUES
    (4, '기획부', '서울');

-- 작업의 완료
COMMIT;