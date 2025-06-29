
--SCENARIO-2

ALTER TABLE Customers ADD (IsVIP VARCHAR2(3));

SET SERVEROUTPUT ON;

BEGIN
    FOR cust IN (SELECT CustomerID, Balance FROM Customers) LOOP
        IF cust.Balance > 10000 THEN
            UPDATE Customers SET IsVIP = 'YES' WHERE CustomerID = cust.CustomerID;
            DBMS_OUTPUT.PUT_LINE('CustomerID ' || cust.CustomerID || ' is now a VIP.');
        ELSE
            UPDATE Customers SET IsVIP = 'NO' WHERE CustomerID = cust.CustomerID;
        END IF;
    END LOOP;
    
    COMMIT;
END;
/
