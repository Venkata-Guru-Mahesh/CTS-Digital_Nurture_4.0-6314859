import React from 'react';

const players = [
    {name: 'Jack', score: 50},
    {name: 'Michael', score: 70},
    {name: 'John', score: 40},
    {name: 'Ann', score: 61},
    {name: 'Elisabeth', score: 61},
    {name: 'Sachin', score: 95},
    {name: 'Dhoni', score: 100},
    {name: 'Virat', score: 84},
    {name: 'Jadeja', score: 64},
    {name: 'Bumrah', score: 75},
    {name: 'Rohit', score: 80},
];

export function ListofPlayers(){
    return(
        <div>
            {players.map((item) => {
                return (
                    <div>
                        <li>Mr. {item.name} <span>{item.score}</span></li>
                    </div>
                );
            })}
        </div>
    );
}

export function Scorebelow70(){
    const players70 = [];
    return(
        <div>
            {players.map((item) => {
                if(item.score <= 70) {
                    players70.push(item);
                    return (
                        <div>
                            <li>Mr. {item.name} <span>{item.score}</span></li>
                        </div>
                    );
                }
                return null;
            })}
        </div>
    );
}