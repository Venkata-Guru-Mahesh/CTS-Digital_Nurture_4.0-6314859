
import React, { useState } from "react";

function Events() {
    const [num,setNum]=useState(0);

    function increment(){
        const newNum = num+1;
        setNum(newNum);
        window.alert("Hello, number incremented to: " + newNum); 
    }
    
    function decrement(){
        const newNum = num-1;
        setNum(newNum);
    }

    function sayWelcome(str){
        window.alert(str);
    }

    const clicked = ()=>{
        window.alert("I was clicked");
    }

    return(
        <div>
            <h1>{num}</h1>
            <button onClick={increment}>Increment</button><br/>
            <button onClick={decrement}>Decrement</button><br/>
            <button onClick={() => sayWelcome("welcome")}>Say welcome</button><br/>
            <button onClick={clicked}>CLick on me</button><br/>
        </div>
    );
}

export default Events;
