import React from 'react'
import "../styles/reset.css";
import { useState, useEffect } from "react";
import Axios from "axios";
import { Base64 } from "js-base64";
import { useNavigate, Link, useLocation } from "react-router-dom";
import { ToastContainer, toast } from "react-toastify";
import { BASE_URL } from '../components/constants/apiConstants';

const ResetPassword = () => {
  const initialValues = { password: "", resetPassword: "" };
  const [formValues, setFormValues] = useState(initialValues);
  const [formErrors, setFormErrors] = useState({});
  const [isSubmit, setIsSubmit] = useState(false);
  const navigate = useNavigate();
  let isValid = false;
  let userEmail = JSON.parse(localStorage.getItem("userEmail"));
  console.log("incoming >>", userEmail);
  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormValues({ ...formValues, [name]: value });
    setFormErrors(validate(formValues));
  };
  const handleSubmit = (e) => {
    e.preventDefault();
    setFormErrors(validate(formValues));
    if (isValid) {
      setIsSubmit(true);
      var encodePassword = Base64.encode(formValues.resetPassword);
      Axios.put(BASE_URL+`/user/reset`, {
        email: userEmail,
        password: encodePassword,
      })
        .then((res) => {
          if (res.status === 200) {
            console.log(">>>>>>>>>>>>>>>>>> login");
            localStorage.setItem("userLogin", JSON.stringify(res.data));
            if (res.status === 200) {
              navigate("/");
            }
          }
          console.log(res.data);
        })
        .catch((err) => {
          console.log("what err in catch", err);
          if (err.response.status === 401) {
            toast.error("Invalid Credentials!", {
              draggable: true,
              position: toast.POSITION.TOP_CENTER,
            });
          } else if (err.response.status === 400)
            toast.error("Reset Password failed", {
              draggable: true,
              position: toast.POSITION.TOP_CENTER,
            });
        });
      setFormValues(initialValues);
    }
  };
  useEffect(() => {
    console.log(formErrors);
    if (Object.keys(formErrors).length === 0 && isSubmit) {
      console.log(formValues);
    }
  }, [formErrors]);
  const validate = (values) => {
    const errors = {};
    if (!values.password) {
      errors.password = "Password is required";
    }
    if (!values.resetPassword) {
      errors.resetPassword = "Reset Password is required!";
    }
    if (Object.keys(errors).length === 0) {
      isValid = true;
    }
    return errors;
  };

  return (
    <div className="update-item-container"  >
    <h2 className="mainHeading" style={{marginLeft:"-12rem"}}>Reset Password</h2>
          <form className="form-item" >
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
                autocomplete="on"
                value={formValues.password}
                onChange={handleChange}
              />
             
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
                placeholder=" Confirm Password"
                value={formValues.resetPassword}
                onChange={handleChange}
              />
             
              <br />
            </div>
         
         
                 
          </form>
          <input
            className="submitButton"
            type="submit"
            name="signup_submit"
            value="Reset Password"
            onClick={handleSubmit}
            style={{marginBottom:"3rem",borderRadius:"2px",width:"200px"}}
          />
          <br />
      
      </div>
   
  )
}

export default ResetPassword


 