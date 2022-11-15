import React, { useEffect } from "react";
import "../styles/register.css";
import axios from "axios";
import { useState } from "react";
import { Base64 } from "js-base64";
import { ToastContainer, toast } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";
import { useNavigate } from 'react-router-dom';
import { BASE_URL } from "../components/constants/apiConstants";
const Register = () => {
  const [firstname, setfirstname] = useState("");
  const [firstnameERR, setfirstnameERR] = useState("");
  const [lastname, setlastname] = useState("");
  const [lastnameERR, setlastnameERR] = useState("");
  const [email, setemail] = useState("");
  const [emailERR, setemailERR] = useState("");
  const [pwd, setpwd] = useState("");
  const [pwdERR, setpwdERR] = useState("");
  const [reenter_password, setreenter_password] = useState("");
  const [passwordERR, setpasswordERR] = useState("");
  const [dateOfBirth, setdateOfBirth] = useState("");
  const [dateOfBirthERR, setdateOfBirthERR] = useState("");
  const [phoneNo, setphoneNo] = useState("");
  const [phoneNoERR, setphoneNoERR] = useState("");
  const [desiganation, setdesiganation] = useState("");
  const [desiganationERR, setdesiganationERR] = useState("");
  const [dateOfJoining, setdateofJoining] = useState("");
  const [dateOfJoiningERR, setdateofJoiningErr] = useState("");
  const [location, setlocation] = useState("");
  const [locationERR, setlocationErr] = useState("");
  const [empId, setempId] = useState("");
  const [empIdERR, setempIdERR] = useState("");
  const [firstLogin, setfirstLogin] = useState("");
  const navigate = useNavigate();
  const newSignup = () => {
    var encodePassword = Base64.encode(pwd);
    axios
      .post(BASE_URL+"/user/register", {
        email: email,
        password: encodePassword,
        firstName: firstname,
        lastName: lastname,
        dateOfBirth: dateOfBirth,
        phoneNo: phoneNo,
        desiganation: desiganation,
        dateOfJoining: dateOfJoining,
        location: location,
        employeeId:empId,
        role: "Admin",
        firstLogin:true,
      })
      .then((data) => {
        toast.success("Signup Successfull", {
          position: toast.POSITION.BOTTOM_LEFT,
        });
        navigate("/");
        setemail("");
        setpwd("");
        setfirstname("");
        setlastname("");
        setreenter_password("");
        setdateOfBirth("");
        setphoneNo("");
        setdateofJoining("");
        setlocation("");
        setdesiganation("");
        setempId("");
        setfirstLogin("");
      })
      .catch((error) => {
        toast.error("Signup Unsuccessfull", {
          position: toast.POSITION.TOP_RIGHT,
        });
      });
  };
  const validation = (values) => {
    const regex = /^[A-Za-z0-9._%+-]+@nucleusteq.com$/i;
    const minLengthRegExp = /.{8,}/;
    const contactRegularExp = /[0-9]{10}/;
    const regexddmmyyyy = /^\d{4}\-(0[1-9]|1[012])\-(0[1-9]|[12][0-9]|3[01])$/;
    let encodePassword = Base64.encode(pwd);
    console.log("encodePassword",encodePassword);
    let data = {
      email: email,
      password: encodePassword,
      firstName: firstname,
      lastName: lastname,
      dateOfBirth: dateOfBirth,
      phoneNo: phoneNo,
      desiganation: desiganation,
      dateOfJoining: dateOfJoining,
      location: location,
      employeeId:empId,
      role: "Admin",
    };
    console.log("what data >>>>", data);
    if (firstname.length == 0) {
      setfirstnameERR("*First name is required.");
    }
    if (lastname.length == 0) {
      setlastnameERR("*Last name is required.");
    }
    if (email.length == 0) {
      setemailERR("*Email is required.");
    }
    if (!regex.test(email)) {
      setemailERR("*Email is Not valid.");
    }
    if (!contactRegularExp.test(phoneNo)) {
      setphoneNoERR("*Contact is required.");
    }
    if (desiganation.length == 0) {
      setdesiganationERR("*Desiganation is required.");
    }
    if (pwd.length == 0) {
      setpwdERR("*Password is required.");
    }
    if (!minLengthRegExp.test(pwd)) {
      setpwdERR("*Minimum 8 characters required.");
    }
    if (reenter_password !== pwd ) {
      setpasswordERR("*Password doesnt match.");
    }
    if(reenter_password.length ==0){
      setpasswordERR("*Password is required.");
    }
    if (!regexddmmyyyy.test(dateOfJoining)) {
      setdateofJoiningErr("*Date of Joining is Required.");
    }
    if (location.length == 0) {
      setlocationErr("*Location is Required.");
    }
    if (dateOfBirth.length == 0) {
      setdateOfBirthERR("*Date of Birth is Required.");
    }
    if (empId.length == 0) {
       setempIdERR("*employee Id is Required.");
      }
      else {
      newSignup();
     }
  };
  return (
    <>
    <div>
    <div class="register-container" >
    <h3 className="mainHeading" style={{marhinLeft:"3rem"}}>Sign-Up</h3>
          <form className="form-main">
            <div className="registre-input">
              <label for="firstname" className="input-heading">
                <h3>First name</h3>
              </label>
              <input
              id="firstname"
                className="signupinput"
                type="text"
                name="firstname"
                placeholder="First name"
                onChange={(e) => {
                  setfirstname(e.target.value);
                  setfirstnameERR("");
                }}
                value={firstname}
              />
              <span style={{ color: "red" ,fontSize:"13px"}}>{firstnameERR}</span>
              <br />
            </div>
            <div className="registre-input">
              <label for="email" className="input-heading">
                <b>
                  <h3>E-mail</h3>
                </b>
              </label>
              <input
              id="email"
                className="signupinput"
                type="text"
                name="email"
                placeholder="E-mail"
                onChange={(e) => {
                  setemail(e.target.value);
                  setemailERR("");
                 }}
                value={email}
              />
              <span style={{ color: "red" ,fontSize:"13px"}}>{emailERR}</span>
              <br />
            </div>
            <div className="registre-input">
              <label for="empId" className="input-heading">
                <b>
                  <h3>Employee ID</h3>
                </b>
              </label>
              <input
              id="empId"
                className="signupinput"
                type="text"
                name="empId"
                placeholder="Employee ID"
                onChange={(e) => {
                  setempId(e.target.value);
                  setempIdERR("");
                }}
                value={empId}
              />
              <span style={{ color: "red",fontSize:"13px" }}>{empIdERR}</span>
              <br />
            </div>
            <div className="registre-input">
              <label for="dateOfBirth" className="input-heading">
                <b>
                  <h3>Date of birth</h3>
                </b>
              </label>
              <input
              id="dateOfBirth"
                className="signupinput"
                type="date"
                max="2004-01-01"
                name="dateOfBirth"
                placeholder="Date of birth"
                onChange={(e) => {
                  setdateOfBirth(e.target.value);
                  setdateOfBirthERR("");
                }}
                value={dateOfBirth}
              />
              <span style={{ color: "red",fontSize:"13px" }}>{dateOfBirthERR}</span>
              <br />
            </div>
            <div className="registre-input">
              <label for="password" className="input-heading">
                <b>
                  <h3>Password</h3>
                </b>
              </label>
              <input
              id="password"
                className="signupinput"
                type="password"
                name="password"
                placeholder="Password"
                onChange={(e) => {
                  setpwd(e.target.value);
                  setpwdERR("");
                }}
                value={pwd}
              />
              <span style={{ color: "red" ,fontSize:"13px"}}>{pwdERR}</span>
              <br />
            </div>
            <div className="registre-input">
              <label for="location" className="input-heading">
                <b>
                  <h3>Location</h3>
                </b>
              </label>
              <select className=  "selectordesignation" name="location" id="location"
                onChange={(e) => {
                    setlocation(e.target.value);
                    setlocationErr("");
                }}  value={location}>
                  <option value="">Location</option>
                  <option value="Phoenix">Phoenix</option>
                  <option value="Canada">Canada</option>
                  <option value="Indore">Indore</option>
                  <option value="Raipur">Raipur</option>
                  <option value="Banglore">Banglore</option>
                  
                </select><br></br>             
              <span style={{ color: "red" ,fontSize:"13px"}}>{locationERR}</span>
              <br />
            </div>
            <div className="registre-input">
              <label for="lastname" className="input-heading">
                <b>
                  <h3>Last name</h3>
                </b>
              </label>
              <input
              id="lastname"
                className="signupinput"
                type="text"
                name="lastname"
                placeholder="Last name"
                onChange={(e) => {
                  setlastname(e.target.value);
                  setlastnameERR("");
                }}
                value={lastname}
              />
              <span style={{ color: "red" ,fontSize:"13px"}}>{lastnameERR}</span>
              <br />
            </div>
            <div className="registre-input">
              <label for="phoneNo" className="input-heading">
                <b>
                  <h3>Contact</h3>
                </b>
              </label>
              <input
              id="phoneNo"
                className="signupinput"
                type="text"
                name="phoneNo"
                placeholder="Contact"
                onChange={(e) => {
                  setphoneNo(e.target.value);
                  setphoneNoERR("");
                }}
                value={phoneNo}
              />
              <span style={{ color: "red" ,fontSize:"13px"}}>{phoneNoERR}</span>
              <br />
            </div>           
            <div className="registre-input">
              <div className="div" style={{marginTop:"1rem",marginBottom:"1rem"}}>
                <label for="desiganation" className="input-heading">
                  <b>
                    <h3>Desiganation</h3>
                  </b>
                </label>
                <select className=  "selectordesignaation" name="desiganation" id="desiganation" 
                onChange={(e) => {
                  setdesiganation(e.target.value);
                  setdesiganationERR("");
                }} value={desiganation}>
                  <option value="">Desiganation</option>
                  <option value="Intern">Intern</option>
                  <option value="Engineer">Engineer</option>
                  <option value="SeniorEngineer">Senior Engineer</option>
                  <option value="Operations">Operations</option>
                  <option value="Recruiter">Recruiter</option>
                  <option value="SeniorRecruiter">Senior Recruiter</option>
                </select><br></br>
              <span style={{ color: "red",fontSize:"13px" }}>{desiganationERR}</span>
              </div>
            </div>
            <div className="registre-input">
              <label for="dateOfJoining" className="input-heading">
                <b>
                  <h3>Date of Joining</h3>
                </b>
              </label>
              <input
              id="dateOfJoining"
                className="signupinput"
                type="date"
                min="2018-01-01"
                name="dateOfJoining"
                placeholder="Date of Joining"
                onChange={(e) => {
                  setdateofJoining(e.target.value);
                  setdateofJoiningErr("");
                }}
                value={dateOfJoining}
              />
              <span style={{ color: "red",fontSize:"13px" }}>{dateOfJoiningERR}</span>
              <br />
            </div>
            <div className="registre-input">
              <label for="re-password" className="input-heading">
                <b>
                  <h3>Re-enter Password</h3>
                </b>
              </label>
              <input
              id="re-password"
                className="signupinput"
                type="password"
                name="re-enter_password"
                placeholder="Re-enter Password"
                onChange={(e) => {
                  setreenter_password(e.target.value);
                  setpasswordERR("");
                }}
                value={reenter_password}
              />
              <span style={{ color: "red" ,fontSize:"13px"}}>{passwordERR}</span>
              <br />
            </div>            
          </form>
          <input
            className="submitButton"
            type="submit"
            name="signup_submit"
            value="Sign Up"
            onClick={validation}
            style={{marginBottom:"1rem"}}
          />
          <br />
       
      <ToastContainer />
      </div>
      </div>
    </>
  );
};
export default Register;