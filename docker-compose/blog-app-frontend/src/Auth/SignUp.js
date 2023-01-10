import React, { useState } from "react";
import { BASE_URL } from "../config";
import "./login.css";

const SignUp = () => {

    const [credentials, setCredentials] = useState({});

    const handleChange = (event) =>{
        const newValue = event.target.value;
        const inputName = event.target.name;
        setCredentials((prevState)=> {
            return({
              ...prevState,
              [inputName]: newValue
            });
          });
    };

    const signUp = async () =>{
        try {

            const response = await fetch(`${BASE_URL}/users`, {
                                method: 'POST',
                                body: JSON.stringify(credentials),
                                headers: { 'Content-Type': 'application/json' },
                            });
            const jsonData = await response.json();
            if(jsonData.id && jsonData.id != null){
                alert('User successfully registered.');
                window.location.href="/login";
            }else{
                if(jsonData.message)
                    alert(jsonData.message);
                else
                    alert(jsonData);
            }
                
        } catch (error) {
            console.log(error);
        }
    };

    const handleSubmit= (event) =>{
        event.preventDefault();
        signUp();
    };

    return (
        <div className="login-container">
            <form method="POST" onSubmit={handleSubmit}>
                <div className="container">
                    <label htmlFor="first_name"><b>First Name</b></label>
                    <input type="text" placeholder="Enter First Name" name="first_name" id="first_name" onChange={handleChange}/>

                    <label htmlFor="last_name"><b>Last Name</b></label>
                    <input type="text" placeholder="Enter Last Name" name="last_name" id="last_name" onChange={handleChange}/>

                    <label htmlFor="email"><b>Email</b></label>
                    <input type="text" placeholder="Enter Email" name="email" id="email" onChange={handleChange}/>

                    <label htmlFor="username"><b>Username</b></label>
                    <input type="text" placeholder="Enter Username" name="username" onChange={handleChange}/>

                    <label htmlFor="password"><b>Password</b></label>
                    <input type="password" placeholder="Enter Password" name="password" id="password" onChange={handleChange}/>

                    <button type="submit">Login</button>
                </div>
            </form>
        </div>
    );
};

export default SignUp;