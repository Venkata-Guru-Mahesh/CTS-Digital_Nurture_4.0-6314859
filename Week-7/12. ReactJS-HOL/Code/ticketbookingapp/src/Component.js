import React,{useState} from 'react';

function LoginButton(props){
  return (
    <button onClick={props.onClick}>
      Login
    </button>
  );
}

function LogoutButton(props){
  return (
    <button onClick={props.onClick}>
      Logout
    </button>
  );
}


function UserGreeting(){
  return <h1>Welcome back</h1>;
}

function GuestGreeting(){
  return <h1>Please sign up.</h1>;
}

function Greeting(props) {
  const isLoggedIn=props.isLoggedIn;
  if(isLoggedIn){
    return <UserGreeting />;
  }
  return <GuestGreeting />;
}

function Component(){
  const [isLoggedIn, setIsLoggedIn]=useState(false);

  function handleLoginClick(){
    setIsLoggedIn(true);
  }

  function handleLogoutClick(){
    setIsLoggedIn(false);
  }

  return(
    <div>
        <Greeting isLoggedIn={isLoggedIn} />
        <div>
            {isLoggedIn ? (
          <LogoutButton onClick={handleLogoutClick} />
        ) : (
          <LoginButton onClick={handleLoginClick} />
        )}
        </div>
    </div>
  );
}

export default Component;
