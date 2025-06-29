
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

--SCENARIO-3

SET SERVEROUTPUT ON;

DECLARE
    C_id Customers.CustomerID%TYPE;
BEGIN
    FOR loan_rec IN (
        SELECT LoanID, CustomerID, EndDate FROM Loans WHERE EndDate BETWEEN SYSDATE AND SYSDATE + 30
    )
    LOOP
        C_id := loan_rec.CustomerID;
        
        DBMS_OUTPUT.PUT_LINE('Reminder: LoanID ' || loan_rec.LoanID ||' for CustomerID: ' || C_id ||' is due on ' || TO_CHAR(loan_rec.EndDate, 'DD-MON-YYYY'));
    END LOOP;
END;
/

COMMIT;