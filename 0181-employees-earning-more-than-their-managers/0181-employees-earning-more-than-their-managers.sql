# 문제 해석: 매니저보다 돈을 많이 번 노동자를 출력하기
# 문제 접근: 셀프 조인하기 : Why? 내부 참조
# 매니저가 아닌 일반 노동자 중에서 더 돈을 많이 번 사람 출력하기
SELECT
    e.name AS Employee
FROM
    Employee e
INNER JOIN
    Employee m
ON e.managerId = m.id
WHERE
    e.salary > m.salary