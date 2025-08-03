// App.js
import './App.css';
import { ListofPlayers } from './Components/ListofPlayers';
import { Scorebelow70} from './Components/ListofPlayers';
import {EvenPlayers} from './Components/IndianPlayers';
import { OddPlayers } from './Components/IndianPlayers';
import { IndianPlayers} from './Components/IndianPlayers';
import { ListofIndianPlayers } from './Components/IndianPlayers';

function App() {
    var flag = true;//change flag value to false to see another output
    
    const IndianTeam = ['Sachin1', 'Dhoni2', 'Virat3', 'Rohit4', 'Fifth Player', 'Yuvaraj5'];

    if(flag === true) {
        return (
            <div>
                <h1>List of Players</h1>
                <ListofPlayers />
                <hr/>
                <h1>List of Players having Scores Less than 70</h1>
                <Scorebelow70 />
            </div>
        );
    } else {
        return (
            <div>
                <div>
                    <h1>Indian Team</h1>
                    <h1>Odd Players</h1>
                    {OddPlayers(IndianTeam)}
                    <hr/>
                    <h1>Even Players</h1>
                    {EvenPlayers(IndianTeam)}
                </div>
                <hr/>
                <div>
                    <h1>List of Indian Players Merged:</h1>
                    <ListofIndianPlayers IndianPlayers={IndianPlayers}/>
                </div>
            </div>
        );
    };
}

export default App;