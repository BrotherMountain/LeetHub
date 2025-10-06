# 문제 해석: Tree table을 바탕으로 type을 적기
# 문제 접근: null이면 Root, 양쪽에 하나라도 있으면 Inner, 양쪽에 아무것도 없으면 Leaf
SELECT
    id,
    CASE
        WHEN p_id IS NULL THEN 'Root'
        WHEN id IN (SELECT DISTINCT p_id FROM Tree) THEN 'Inner'
        ELSE 'Leaf'
    END AS type
FROM
    Tree