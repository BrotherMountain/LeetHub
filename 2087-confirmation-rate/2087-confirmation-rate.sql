WITH RATE AS(
    SELECT
        user_id,
        COUNT(*) AS total_count,
        SUM(
            CASE    
                WHEN action = 'confirmed'
                THEN 1
                ELSE 0
            END
        ) AS confirmed_count
    FROM
        Confirmations
    GROUP BY
        user_id
    
)

SELECT
    s.user_id,
    IFNULL(ROUND(r.confirmed_count / r.total_count,2),0) AS confirmation_rate 
FROM
    Signups s
LEFT JOIN
    RATE r
ON
    s.user_id = r.user_id