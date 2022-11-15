import React from "react";
import "../styles/login1.css";
import Footer from '../components/footer/index';
import { Link } from "react-router-dom";
import axios from "axios";
import { useState } from "react";
import { ToastContainer, toast } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";
import { Base64 } from "js-base64";
import { useNavigate } from 'react-router-dom';
import { BASE_URL } from "../components/constants/apiConstants";
const Login1 = () => {
  const [email, setemail] = useState("");
  const [emailERR, setemailERR] = useState("");
  const [pwd, setpwd] = useState("");
  const [pwdERR, setpwdERR] = useState("");
  const navigate = useNavigate();
 


  const newSignin = () => {
    var encodePassword = Base64.encode(pwd);
    
    
    axios
      .post(BASE_URL+"/user/login", {
        email: email,
        password: encodePassword,
      })
      
      .then((data) => {
       
        toast.success("Login Successfull", {
          position: toast.POSITION.TOP_RIGHT,
          
        });
        localStorage.setItem("userLogin", JSON.stringify(data.data));
        navigate("/dashboard");
        // if (data.data.role === "admin") {
        //   navigate("/dashboard");
        // } else {
        //   localStorage.setItem("employeeLogin", JSON.stringify(data.data));
        //   if (data.data.firstLogin === true) {
        //     navigate("/resetPassword");
        //   } else {
        //     navigate("/employeeDashboard");
        //   }
        // }
        setemail("");
        setpwd("");
      })
      .catch((error) => {
        toast.error("Login Unsuccessfull", {
          position: toast.POSITION.TOP_RIGHT,
        });
      });
  };
  const signup = () => {
    const container = document.getElementById("container");
    container.classList.add("right-panel-active");
  };

  const validation = () => {
    if (email.length == 0) {
      setemailERR("*Email is required");
    }
    if (pwd.length == 0) {
      setpwdERR("*Password is required");
    } else {
      newSignin();
    }
  };
  return (
    <>
      <div>
      <h1 style={{marginBottom:"2rem"}}>Nucleus Teq Inventory Management</h1>
        <div class="login_container" id="container">
          
          <div class="form-container sign-in-container">
            <div className="loginForm">
              <h3 className="mainHeading">Login </h3>

              <div className="input-style">
                <label for="emailId" className="labelStyle">
                  E-mail
                </label>

                <input
                  className="inputEmail"
                  id="emailId"
                  type="email"
                  name="email"
                  placeholder="E-mail"
                  onChange={(e) => {
                    setemail(e.target.value);
                    setemailERR("");
                  }}
                  value={email}
                />
              </div>
              <span style={{ color: "red" ,width:"150px",marginTop:"-1.5rem",float:"left",marginLeft:"-7rem",marginBottom:"1rem",fontSize:"13px"} }>{emailERR}</span>
                

              <div className="input-style">
                <label for="passwrd" className="labelStyle">
                  Password
                </label>
                <input
                  className="inputEmail"
                  id="passwrd"
                  type="password"
                  name="password"
                  placeholder="Password"
                  onChange={(e) => {
                    setpwd(e.target.value);
                    setpwdERR("");
                  }}
                  value={pwd}
                />
              </div>
              <span style={{ color: "red" ,width:"150px",marginTop:"-1.5rem",float:"left",marginLeft:"-5.7rem",fontSize:"13px"} }>{pwdERR}</span>

              <div className="input-style" style={{marginTop:"2rem"}}>
                <button type="submit"  onClick={validation}>
                  Login
                </button>
              </div>
            </div>
            
          <br />
          </div>
          <div class="overlay-container">
            <div class="overlay">
              <div class="overlay-panel overlay-right">
                <h1>Hello </h1>
                <p>Enter your personal details ..</p>
                <Link to="/register">
                  <a>
                    <button className="ghost"  onClick={signup}>
                      Sign Up
                    </button>
                  </a>
                </Link>
              </div>
            </div>
          </div>
        </div>
      </div>
      <Footer/>
    </>
  );
};
export default Login1;
