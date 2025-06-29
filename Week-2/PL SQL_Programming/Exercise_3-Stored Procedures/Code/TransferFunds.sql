--SCENARIO-3

SET SERVEROUTPUT ON;

CREATE OR REPLACE PROCEDURE TransferFunds (
    p_source_account_id IN NUMBER,
    p_destination_account_id IN NUMBER,
    p_amount IN NUMBER
)
AS
    v_source_balance NUMBER;
    v_new_transaction_id NUMBER;
    v_dest_balance NUMBER;
    v_source_customer_id NUMBER;
    v_dest_customer_id NUMBER;
    v_source_account_exists BOOLEAN := FALSE;
    v_dest_account_exists BOOLEAN := FALSE;
BEGIN

    BEGIN
        SELECT Balance,CustomerID INTO v_source_balance,v_source_customer_id FROM Accounts WHERE AccountID = p_source_account_id;

        v_source_account_exists := TRUE;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            DBMS_OUTPUT.PUT_LINE('Error: Source AccountID ' || p_source_account_id || ' does not exist.');
            ROLLBACK;
            RETURN;
    END;

    BEGIN
        SELECT Balance,CustomerID INTO v_dest_balance,v_dest_customer_id FROM Accounts WHERE AccountID = p_destination_account_id;

        v_dest_account_exists := TRUE;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            DBMS_OUTPUT.PUT_LINE('Error: Destination AccountID ' || p_destination_account_id || ' does not exist.');
            ROLLBACK;
            RETURN;
    END;

    IF p_amount <= 0 THEN
        DBMS_OUTPUT.PUT_LINE('Error: Transfer amount must be positive.');
        ROLLBACK;
        RETURN;
    END IF;

    IF v_source_balance >= p_amount THEN
    
        UPDATE Accounts SET Balance = Balance - p_amount,LastModified = SYSDATE WHERE AccountID = p_source_account_id;
        UPDATE Customers SET Balance = Balance - p_amount,LastModified = SYSDATE WHERE CustomerID = v_source_customer_id;
        
        UPDATE Accounts SET Balance = Balance + p_amount,LastModified = SYSDATE WHERE AccountID = p_destination_account_id;
        UPDATE Customers SET Balance = Balance + p_amount,LastModified = SYSDATE WHERE CustomerID = v_dest_customer_id;
        

        SELECT NVL(MAX(TransactionID), 0) + 1 INTO v_new_transaction_id FROM Transactions;

        INSERT INTO Transactions (TransactionID,AccountID,TransactionDate,Amount,TransactionType)
        VALUES (v_new_transaction_id,p_source_account_id,SYSDATE,p_amount,'Debit');

        v_new_transaction_id := v_new_transaction_id + 1;

        INSERT INTO Transactions (TransactionID,AccountID,TransactionDate,Amount,TransactionType) 
        VALUES (v_new_transaction_id,p_destination_account_id,SYSDATE,p_amount,'Credit');
    COMMIT;
        DBMS_OUTPUT.PUT_LINE('Transfer of ' || p_amount || ' from Account ' || p_source_account_id || ' to Account ' || p_destination_account_id || ' successful.');

    ELSE
        DBMS_OUTPUT.PUT_LINE('Error: Insufficient balance in source account ' || p_source_account_id || '. Available balance: ' || v_source_balance);
        ROLLBACK;
    END IF;

EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('An unexpected error occurred: ' || SQLERRM);
        ROLLBACK;
END;
/
EXEC TransferFunds(10, 12, 8000);
EXEC TransferFunds(10, 13, 5000);
EXEC Transferfunds(101,5,100);
EXEC Transferfunds(10,125,100);
EXEC Transferfunds(10,5,-100);

