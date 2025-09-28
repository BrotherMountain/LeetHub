SELECT
    v.article_id as id
FROM
    View v
WHERE
    v.author_id = v.viewer_id
ORDER BY
    v.article_id ASC