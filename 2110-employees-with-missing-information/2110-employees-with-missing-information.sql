# 문제 해석: 이름 또는 급여가 누락된 테이블 반환하기
# 문제 접근: 두 테이블을 LEFT JOIN하기
SELECT
    e.employee_id
FROM
    Employees e
LEFT JOIN
    Salaries s
ON e.employee_id = s.employee_id
WHERE  s.employee_id IS NULL

UNION ALL

SELECT
    s.employee_id
FROM
    Salaries s
LEFT JOIN
    Employees e
ON e.employee_id = s.employee_id
WHERE  e.employee_id IS NULL

ORDER BY employee_id ASC