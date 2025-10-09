# 문제 해석: primary_flag가 Y인 부서를 제출해야 함.
# 문제 접근: employee_id 별로 그룹화 진행하기
# primary_flag가 'Y'인 경우 모두 선택하기
# 두 결과 합치기
SELECT 
    employee_id, 
    department_id 
FROM 
    Employee 
WHERE 
    primary_flag = 'Y'

UNION ALL

SELECT 
    employee_id, 
    department_id 
FROM 
    Employee 
GROUP BY 
    employee_id 
HAVING 
    COUNT(department_id) = 1;