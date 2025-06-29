
--SCENARIO-1
SET SERVEROUTPUT ON;

DECLARE
    C_age NUMBER;
BEGIN
    FOR cust_rec IN (SELECT CustomerID, DOB FROM Customers) 
    LOOP
        C_age := FLOOR(MONTHS_BETWEEN(SYSDATE, cust_rec.DOB) / 12);
        IF C_age > 60 THEN
            UPDATE Loans SET InterestRate = InterestRate - 1 WHERE CustomerID = cust_rec.CustomerID;
            DBMS_OUTPUT.PUT_LINE('Applied 1% interest discount to CustomerID ' || cust_rec.CustomerID);
        END IF;
    END LOOP;
END;
/

COMMIT;
