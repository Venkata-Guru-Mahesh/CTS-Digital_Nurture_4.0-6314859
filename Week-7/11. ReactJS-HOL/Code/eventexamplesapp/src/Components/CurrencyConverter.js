import React, { useState } from "react";

function CurrencyConverter() {
    const [amount, setAmount] = useState("");
    const [convertedAmount, setConvertedAmount] = useState("");

    const convertCurrency = () => {
        const rate = 0.01; // rupees to euro
        const numericAmount = parseFloat(amount);
        if (!isNaN(numericAmount)) {
            setConvertedAmount((numericAmount * rate).toFixed(2));
        } else {
            setConvertedAmount("Invalid input");
        }
    };

    const textColor = { color: "green" };

    return (
        <div>
            <h1 style={textColor}>Currency Converter!!!</h1>
            Amount (Rupees) : {" "}
            <input 
                type="number" 
                value={amount} 
                onChange={(e) => setAmount(e.target.value)}  
            />
            <br/><br/>
            Converted (Euros) : {" "}
            <input
                type="text"
                value={convertedAmount}
                readOnly
            />
            <br/><br/>
            <button onClick={convertCurrency}>Convert</button>
        </div>
    );
}

export default CurrencyConverter;