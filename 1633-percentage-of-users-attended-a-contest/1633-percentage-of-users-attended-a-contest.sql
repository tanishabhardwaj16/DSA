# Write your MySQL query statement below
SELECT
    contest_id,
    ROUND(COUNT(user_id) * 100.0 / (SELECT COUNT(*) FROM Users), 2) AS percentage
FROM Register
GROUP BY contest_id
ORDER BY percentage DESC, contest_id; 

-- SELECT r.contest_id,
--     ROUND(COUNT(r.user_id) * 100.0 / u.total_users, 2) AS percentage
-- FROM Register r
-- JOIN (
--     SELECT COUNT(*) AS total_users
--     FROM Users
-- ) u
-- GROUP BY r.contest_id, u.total_users
-- ORDER BY percentage DESC, r.contest_id;