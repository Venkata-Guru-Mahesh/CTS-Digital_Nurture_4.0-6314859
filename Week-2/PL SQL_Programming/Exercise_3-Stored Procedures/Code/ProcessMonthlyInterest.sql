
--SCENARIO-1

SET SERVEROUTPUT ON;

CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest AS
BEGIN
    UPDATE Accounts
    SET Balance = Balance + (Balance * 0.01)
    WHERE AccountType = 'Savings';
    DBMS_OUTPUT.PUT_LINE('1%  interest applied to all Savings accounts.');
    
    UPDATE Customers C
    SET C.Balance = (
        SELECT A.Balance
        FROM Accounts A
        WHERE A.CustomerID = C.CustomerID);

    DBMS_OUTPUT.PUT_LINE('Customer balances updated based on Savings accounts.');
END;
/

EXEC ProcessMonthlyInterest;

