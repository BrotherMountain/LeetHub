WITH CTE AS(
    SELECT
        count(*) AS total
    FROM
        Users
)

SELECT
    r.contest_id,
    ROUND(COUNT(r.user_id)/c.total*100,2) AS percentage
FROM
    Register AS r
CROSS JOIN
    CTE AS c
GROUP BY
    r.contest_id
ORDER BY percentage DESC, r.contest_id ASC