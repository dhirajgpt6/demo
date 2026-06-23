//SELECT e1.name, e1.salary, e2.name AS manager_name, e2.salary AS manager_salary
//FROM employee e1
//JOIN employee e2 ON e1.manager_id = e2.id
//WHERE e1.salary > e2.salary;