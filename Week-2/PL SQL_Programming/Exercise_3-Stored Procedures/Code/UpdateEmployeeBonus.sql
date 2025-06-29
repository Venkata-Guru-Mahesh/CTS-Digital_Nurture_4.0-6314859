
--SCENARIO-2

SET SERVEROUTPUT ON;

CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(
    dept_name IN VARCHAR2,
    bonus_percent IN NUMBER
) IS
BEGIN
    UPDATE Employees SET Salary = Salary + (Salary * bonus_percent / 100) WHERE Department = dept_name;
    
    DBMS_OUTPUT.PUT_LINE('All Employees in ' || dept_name ||' department have received a bonus of ' ||bonus_percent || '%.');

    COMMIT;
END;
/

EXEC UpdateEmployeeBonus('Finance', 5); 
EXEC UpdateEmployeeBonus('IT', 10); 
EXEC UpdateEmployeeBonus('HR', 15);
