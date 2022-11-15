import React, { useEffect } from "react";
import "../styles/updateItem.css";
import axios from "axios";
import { useState } from "react";
import { ToastContainer, toast } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";
import Footer from "../components/footer";
import { useLocation } from "react-router-dom";
import { useNavigate } from 'react-router-dom';
import { BASE_URL } from "../components/constants/apiConstants";
const UpdateItem = (props) => {
  const itemProps = useLocation();
  const itemdata = itemProps.state;
  console.log("what data in prop", itemdata.dateOfPurchase);
  const [itemId, setitemId] = useState(itemdata.itemId ? itemdata.itemId : "");
  const [assetName, setassetName] = useState(itemdata.assetName ? itemdata.assetName : "");
  const [assetNameERR, setassetNameERR] = useState("");
  const [assetNo, setassetNo] = useState(itemdata.assetNo ? itemdata.assetNo : "");
  const [assetNoERR, setassetNoERR] = useState("");
  const [assetType, setassetType] = useState(itemdata.assetType ? itemdata.assetType : "");
  const [assetTypeERR, setassetTypeERR] = useState("");
  const [dop, setDop] = useState(itemdata.dateOfPurchase ? itemdata.dateOfPurchase : "");
  const [dateOfPurchaseERR, setdateOfPurchaseERR] = useState("");
  const [warrantyPeriod, setwarrantyPeriod] = useState(itemdata.warrantyPeriod ? itemdata.warrantyPeriod : "");
  const [warrantyPeriodERR, setwarrantyPeriodERR] = useState("");
  const [assetLocation, setassetLocation] = useState(itemdata.assetLocation ? itemdata.assetLocation : "");
  const [assetLocationERR, setassetLocationERR] = useState("");
  const[workingStatus,setWorkingStatus]= useState("working");
  const[incidents,setIncidents]= useState("NULL");
  const updateItem  = () => {
    axios
      .put(BASE_URL+"/inventory/item", {
        itemId:itemId,
        assetName: assetName,
        assetNo: assetNo,
        assetType: assetType,
        dop: dop,
        warrantyPeriod: warrantyPeriod,
        assetLocation:assetLocation,
        workingStatus:workingStatus,
        incidents:incidents,
      
      })
      .then((data) => {
        toast.success("ITEM Updated Successfully", {
          position: toast.POSITION.BOTTOM_LEFT,
        });
        setitemId("");
        setassetName("");
        setassetNo("");
        setassetType("");
        setDop("");
        setwarrantyPeriod("");
        setassetLocation("");
        
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
    let data = {
     
        assetName: assetName,
        assetNo: assetNo,
        assetType: assetType,
        dop: dop,
        warrantyPeriod: warrantyPeriod,
        assetLocation:assetLocation,
    };
    console.log("what data >>>>", data.dop);
   
    if (assetName.length == 0) {
      setassetNameERR("*Item Name is required.");
    }
    if (assetNo.length == 0) {
      setassetNoERR("*Asset No. is required.");
    }
    if (assetType.length == 0) {
      setassetTypeERR("*Asset Type is required.");
    }
    if (dop.length == 0) {
      setdateOfPurchaseERR("*DateOfPurchase is required.");
    }
    if(warrantyPeriod.length ==0){
      setwarrantyPeriodERR("*Warranty is required.");
    }
    
    if (assetLocation.length == 0) {
      setassetLocationERR("*Asset Location is Required.");
    }
      else {
      updateItem();
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
    <div className="update-item-container"  >
    <h2 className="mainHeading" style={{marginLeft:"-6rem"}}>Update new Item</h2>
          <form className="form-item" >
         
            <div>
              <label for="assetNo" className="input-heading">
                <b>
                  <h3>Asset No.</h3>
                </b>
              </label>
              <input
              id="assetNo"
                className="signupinput"
                type="text"
                name="assetNo"
                placeholder="Asset No"
                onChange={(e) => {
                  setassetNo(e.target.value);
                  setassetNoERR("");
                }}
                value={assetNo}
                disabled
              />
              <span style={{ color: "red" }}>{assetNoERR}</span>
              <br />
            </div>
               
          
            <div>
              <label for="assetName" className="input-heading">
                <b>
                  <h3>Item Name</h3>
                </b>
              </label>
              <select className=  "selectordesignation" name="assetName" id="assetName"
                onChange={(e) => {
                    setassetName(e.target.value);
                    setassetNameERR("");
                }}  value={assetName}>
                  <option value="">Item Name</option>
                  <option value="Laptop">Laptop</option>
                  <option value="Mouse">Mouse</option>
                  <option value="Monitor">Monitor</option>
                  <option value="Cables">Cables</option>
                </select><br></br>             
              <span style={{ color: "red" }}>{assetNameERR}</span>
              <br />
            </div>
                      
          
            
            <div>
              <label for="dateOfPurchase" className="input-heading">
                <b>
                  <h3>Date of Purchase</h3>
                </b>
              </label>
              <input
              id="dateOfPurchase"
                className="signupinput"
                type="date"
                name="dateOfPurchase"
                placeholder="Date of birth"
                onChange={(e) => {
                  setDop(e.target.value);
                  setdateOfPurchaseERR("");
                }}
                value={dop}
              />
              <span style={{ color: "red" }}>{dateOfPurchaseERR}</span>
              <br />
            </div>
            <div>
              <label for="warrantyPeriod" className="input-heading">
                <b>
                  <h3>Warranty period</h3>
                </b>
              </label>
              <input
              id="warrantyPeriod"
                className="signupinput"
                type="warrantyPeriod"
                name="warrantyPeriod"
                placeholder="Warranty period"
                onChange={(e) => {
                  setwarrantyPeriod(e.target.value);
                  setwarrantyPeriodERR("");
                }}
                value={warrantyPeriod}
              />
              <span style={{ color: "red" }}>{warrantyPeriodERR}</span>
              <br />
            </div>

         
            <div>
              <div className="div">
                <label for="assetType" className="input-heading">
                  <b>
                    <h3>Asset Type</h3>
                  </b>
                </label>
                <select className=  "selectordesignation" name="assetType" id="assetType"
                onChange={(e) => {
                  setassetType(e.target.value);
                  setassetTypeERR("");
                }} value={assetType}>
                  <option value="">Asset Type</option>
                  <option value="Hardware">Hardware</option>
                  <option value="Software">Software</option>
                  <option value="Other">Other</option>
                        </select><br></br>
              <span style={{ color: "red" }}>{assetTypeERR}</span>
              </div>
            </div>
            
            
            <div>
              <label for="assetLocation" className="input-heading">
                <b>
                  <h3>Asset Location</h3>
                </b>
              </label>
              <select className=  "selectordesignation" name="assetLocation" id="assetLocation"
                onChange={(e) => {
                    setassetLocation(e.target.value);
                    setassetLocationERR("");
                }}  value={assetLocation}>
                  <option value="">Asset Location</option>
                  <option value="Indore">Indore</option>
                  <option value="Raipur">Raipur</option>
                  <option value="Bengluru">Bengluru</option>
                  <option value="US">US</option>
                </select><br></br>             
              <span style={{ color: "red" }}>{assetLocationERR}</span>
              <br />
            </div>         
          </form>
          <input
            className="submitButton"
            type="submit"
            name="signup_submit"
            value="Update"
            onClick={validation}
            style={{marginBottom:"3rem"}}
          />
          <br />
      
      <ToastContainer />
      </div>
      </div>
      <Footer/>
    </>
  );
};
export default UpdateItem;