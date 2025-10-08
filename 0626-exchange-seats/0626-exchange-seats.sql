# 문제 해석: 연속된 두 학생의 좌석 번호를 바꾸기, 학생 수가 홀수이면 마지막 학생 좌석 번호 바꾸지 말기
# 문제 조건: 연속된 두 학생 좌석 번호 바꿈, id를 오름차순으로 정렬
# 문제 접근
# 오름차순 : Order By id ASC
# 연속된 두 학생 좌석 번호 바꾸기 = CASW WHEN id % 2 = 0 THEN SELECT student FROM Seat s2 WHERE s2.id = id+1

SELECT
    s1.id,
    COALESCE(
        CASE
            WHEN s1.id % 2 = 0
            THEN 
                (SELECT student FROM Seat s2 WHERE s2.id = s1.id-1)
            ELSE
                (SELECT student FROM Seat s2 WHERE s2.id = s1.id+1)
            END, 
        s1.student) as student
FROM
    Seat s1
Order By s1.id ASC