SELECT d.name, SUM(e.salary) as total_salary
FROM department d
         JOIN employee e ON d.id = e.department_id
GROUP BY d.name
ORDER BY total_salary DESC
    LIMIT 1;