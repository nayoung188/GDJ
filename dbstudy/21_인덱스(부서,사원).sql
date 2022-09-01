/*

    인덱스
    
    1. INDEX
    2. 빠른 검색을 위해서 특정 칼럼에 인덱스를 등록함
    3. 인덱스가 등록된 칼럼은 검색이 빠름
    4. 인덱스가 자동으로 등록되는 경우
        1) PK로 지정한 칼럼
        2) UNIQUE 제약조건을 가진 칼럼
    5. 수정(갱신)이 자주 발생하는 칼럼에 인덱스를 부여하면 도리어 성능이 떨어짐    
    6. 인덱스 생성
        1) 비고유 인덱스(칼럼 내용에 중복이 있는 경우)
          CREATE INDEX 인덱스_이름 ON 테이블_이름(칼럼_이름);
        2) 고유 인덱스 (칼럼 내용에 중복이 없는 경우)

*/


-- 인덱스 조회
-- 사용자가 작성한 인덱스는 USER_INDEXES 데이터 사전에서 확인
DESC USER_INDEXES;
SELECT INDEX_NAME, TABLE_NAME
    FROM USER_INDEXES;
    
-- 인덱스 생성
CREATE INDEX IDX_NAME ON EMPLOYEE(NAME);
    
-- 인덱스 삭제
DROP INDEX IDX_NAME;
    
    
    
    