# 문제 해석 
# 판매된 다양한 제품의 수와 이름을 찾는 솔루션,
# 판매된 제품 이름을 사전순으로 정렬
# 문제 접근
# 그룹 : Group By sell_date
# Order By sell_date

SELECT sell_date,
    COUNT(DISTINCT product) as num_sold,
    GROUP_CONCAT(DISTINCT product ORDER BY product) as products
FROM Activities
GROUP BY sell_date
ORDER BY sell_date