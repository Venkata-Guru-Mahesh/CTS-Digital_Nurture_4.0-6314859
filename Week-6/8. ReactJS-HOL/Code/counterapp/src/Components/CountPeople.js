import React,{Component} from 'react';
import '../Styles/CountPeople.css';

class CountPeople extends Component{
    constructor(){
        super();
        this.state={
            entrycount:0,
            exitcount:0,
            c:0
        };
    }

    UpdateEntry=()=>{
        this.setState((prevState,props)=>{
            return {entrycount: prevState.entrycount+1}
        });
    }
    UpdateExit =() => {
        this.setState((prevState,props)=>{
            return {exitcount: prevState.exitcount+1}
        });
    }

    render(){
        return(
            <div className="count-people-container">
                <div className="button-section">
                <button onClick={this.UpdateEntry} className="count-button">Login</button>
                <span>{this.state.entrycount} People Entered!!!</span>
                </div>
                <div className="button-section">
                <button onClick={this.UpdateExit} className="count-button">Exit</button>
                <span>{this.state.exitcount} People Left!!!</span>
                </div>
            </div>
        )
    }
}

export default CountPeople;