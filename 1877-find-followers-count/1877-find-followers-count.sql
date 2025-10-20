SELECT
    u.user_id,
    COUNT(u.follower_id) AS followers_count
FROM
    Followers u
GROUP BY
    u.user_id
ORDER BY u.user_id