-- 1. 새 데이터베이스 생성
CREATE DATABASE scheduleApp2;

-- 2. 사용할 데이터베이스 선택
USE scheduleApp2;

-- 3. 테이블 생성
CREATE TABLE schedule (
    schedule_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    title VARCHAR(100) NOT NULL,
    content VARCHAR(200) NOT NULL,
    create_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    update_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    password VARCHAR(100) NOT NULL
);

-- 4. 초기 데이터 저장 (INSERT)
INSERT INTO schedule (username, title, content, password)
VALUES 
('김철수', '코드카타'', '오전 9시 진행', 'abcd123'),
('안상아', '강의 수강', '실습 및 TIL 작성', 'efgh1234');

-- 5. 전체 테이블 목록 조회
SHOW tables;

-- 6. 테이블 구성 보기 
DESC schedule;

-- 7. 전체 데이터 조회
SELECT * FROM schedule;

-- 8. 조건 조회 예시
SELECT username, title FROM schedule WHERE schedule_id = 1; 
SELECT * FROM schedule WHERE username = '김철수';
SELECT * FROM schedule WHERE title = '강의';

-- 9. 데이터 수정 예시
UPDATE schedule
SET title = '수정된 일정 제목', content = '내용 수정'
WHERE schedule_id = 1;

-- 10. 데이터 삭제 예시
DELETE FROM schedule WHERE schedule_id = 2;

-- 11. 테이블 제거
DROP TABLE schedule;

-- 12. 데이터베이스 제거
DROP DATABASE scheduleApp2;