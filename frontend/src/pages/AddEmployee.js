import React, { useEffect } from "react";
import "../styles/addemp.css";
import axios from "axios";
import { useState } from "react";
import { Base64 } from "js-base64";
import { ToastContainer, toast } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";
import Footer from "../components/footer";
import Header from "../components/Header";
import { BASE_URL } from "../components/constants/apiConstants";
const AddEmployee = () => {
  const [firstname, setfirstname] = useState("");
  const [firstnameERR, setfirstnameERR] = useState("");
  const [lastname, setlastname] = useState("");
  const [lastnameERR, setlastnameERR] = useState("");
  const [email, setemail] = useState("");
  const [emailERR, setemailERR] = useState("");
 const [dateOfBirth, setdateOfBirth] = useState("");
  const [dateOfBirthERR, setdateOfBirthERR] = useState("");
  const [phoneNo, setphoneNo] = useState("");
  const [phoneNoERR, setphoneNoERR] = useState("");
  const [desiganation, setdesiganation] = useState("Employee");
  const [desiganationERR, setdesiganationERR] = useState("");
  const [dateOfJoining, setdateofJoining] = useState("");
  const [dateOfJoiningERR, setdateofJoiningErr] = useState("");
  const [location, setlocation] = useState("");
  const [locationERR, setlocationErr] = useState("");
  const [empId, setempId] = useState("");
  const [empIdERR, setempIdERR] = useState("");
  const newSignup = () => {
       axios
      .post(BASE_URL+"/inventory/employee", {
        email: email,
        firstName: firstname,
        lastName: lastname,
        dateOfBirth: dateOfBirth,
        phoneNo: phoneNo,
        dateOfJoining: dateOfJoining,
        location: location,
        employeeId:empId,
        desiganation:"Employee",
      })
      .then((data) => {
        toast.success("Employee Addedd Successfully", {
          position: toast.POSITION.BOTTOM_LEFT,
        });
        setemail("");
        setfirstname("");
        setlastname("");
        setdateOfBirth("");
        setphoneNo("");
        setdateofJoining("");
        setlocation("");
        setempId("");
      })
      .catch((error) => {
        toast.error("Failed..", {
          position: toast.POSITION.TOP_RIGHT,
        });
      });
  };
  useEffect(()=>{
  })
  const validation = (values) => {
    const regex = /^[A-Za-z0-9._%+-]+@nucleusteq.com$/i;
    const contactRegularExp = /[0-9]{10}/;
    const regexddmmyyyy = /^\d{4}\-(0[1-9]|1[012])\-(0[1-9]|[12][0-9]|3[01])$/;
    let data = {
      email: email,
      firstName: firstname,
      lastName: lastname,
      dateOfBirth: dateOfBirth,
      phoneNo: phoneNo,
      desiganation:"employee",
      dateOfJoining: dateOfJoining,
      location: location,
      employeeId:empId,
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
      setphoneNoERR("*PhoneNo is required.");
    }
    if (desiganation.length == 0) {
      setdesiganationERR("*Designation is required.");
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
       setempIdERR("*Employee Id is Required.");
      }
      else {
      newSignup();
     }
  };
  return (
    <>
    <div id="sidebar" className="sidenav">
          <p>
            <h2>Inventory Management</h2>
          </p>
          <a href="/dashboard" >
            <i className="fa fa-table">
              <span>Dashboard</span>
            </i>
          </a>

          <a href="/add-employee">
            <i className="fa fa-table">
              <span>Add Employee</span>
            </i>
          </a>
          <a href="/add-item">
            <i className="fa fa-table">
              <span>Add Item</span>
            </i>
          </a>
          <a href="/assignItems">
            <i className="fa fa-table">
              <span>Assign Items</span>
            </i>
          </a>
          <a href="/">
            <i className="fa fa-table">
              <span>Logout</span>
            </i>
          </a>
        </div>
        <div id="rightSideWrapper">
    <div className="addemp-container"  >
    <h2 className="mainHeading" style={{marhinLeft:"3rem" }}>Add new Employee</h2>
          <form className="form-add-emp" >
            <div>
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
              <span style={{ color: "red",fontSize:"13px" }}>{firstnameERR}</span>
              <br />
            </div>
            <div>
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
              <span style={{ color: "red",fontSize:"13px"}}>{emailERR}</span>
              <br />
            </div>
            <div>
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
            <div>
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
              <span style={{ color: "red" ,fontSize:"13px"}}>{dateOfBirthERR}</span>
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
           
            <div>
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
            <div>
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
                placeholder="PhoneNo"
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
           
            <div>
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
                    
          </form>
          <input
            className="submitButton"
            type="submit"
            name="signup_submit"
            value="Add"
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
export default AddEmployee;