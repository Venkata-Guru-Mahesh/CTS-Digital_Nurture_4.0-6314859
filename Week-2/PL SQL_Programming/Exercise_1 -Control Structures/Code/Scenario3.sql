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