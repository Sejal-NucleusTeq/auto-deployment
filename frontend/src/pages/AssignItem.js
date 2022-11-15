import React from 'react'
import "../styles/assign.css";
import { useState, useEffect} from "react";
import { useNavigate } from 'react-router-dom';
import axios from 'axios';
import { BASE_URL } from '../components/constants/apiConstants';

function AssignItem() {
  const [empId, setempId] = useState("");
  const [empIdERR, setempIdERR] = useState("");
  const [emp,setemp]= useState({});
  const [itemListData, setItemListData] = useState([]);
  let i=1;
  const navigate = useNavigate(); 
  const AssignItem = () =>{  
    navigate("/assignNew");
  }
   useEffect(()=>{
    deleteItem();
  },[])
  const deleteItem =(id)=>{
    axios.delete(BASE_URL+`/inventory/deleteAssignedItem?id=${id}`,
    {
    })
    .then((res) => {
      console.log(res);
      deleteItem();

    })
  }

  const validateEmployeeId = (empId)=>{
    if (empId.length == 0) {
      setempIdERR("*employee Id is Required.");
     }
     else {
     getDetails();
    }

  }
 
  const getDetails =()=>{
    document.getElementById("div1").style.display="block";
    document.getElementById("div2").style.display="none";
    axios
    .get(`http://localhost:8080/inventory/employeeDetails?employeeId=${empId}` ,
   {
     empId : empId,
    })
    .then((res) => {
      setemp(res.data.employeeData);
      setItemListData(res.data.assignedAssets);
      console.log(res);
      console.log(res.data.employeeData.firstName);
    })
    .catch((error) => {
      console.log("error");
    }); 
  }
  console.log("list of item", itemListData);


  return (
    <div>
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
      <div className='assign-main-page' style={{paddingTop:"300px"}}>
      
      <div className='assign-page' >
      <h1 className="assignHead" >Search for Employee's details</h1>
           <div className='assign-flex'>
              <div className='float-child'>
               
                <input
                id="empId"
                  className="assign-inputs"
                  type="text"
                  name="empId"
                  placeholder="Employee ID"
                  onChange={(e) => {
                    setempId(e.target.value);
                  }}
                  value={empId}
                />
                <span style={{ color: "red" ,fontSize:"13px"}}>{}</span>
                <br />
              </div>
              <div className='float-child'>
              <input
              className="getButton"
              type="submit"
              name="get_submit"
              value="Get Employee"
              onClick={validateEmployeeId}
              style={{marginBottom:"1rem",marginLeft:"35rem"}}
            />
            
              </div>
           </div>

           <div id = "div1" style={{display:"none"}}>
           <div className='assign-details'>
            <p className='para-style'>
            <div className='float-child'>
              Name: {emp.firstName}
             </div>
             <div className='float-child' >
              Employee ID: {emp.employeeId}
             </div>
             <div className='float-child'>
               E-mail: {emp.email}
             </div>
             <div className='float-child'>
              PhoneNo.: {emp.phoneNo}
             </div>
            </p>
           </div>
           <h1 className="assignHead" >Assigned Items</h1>
           <div style={{paddingLeft:"5rem",paddingRight:"5rem"}}>
           <table >
            <thead>
              <tr>
                <th>Id</th>
                <th>Item Serial No.</th>
                <th>Item Name</th>
                <th>Date Of Assign</th>
                <th>Item Condition</th>
                <th>Incidents</th>
                
                <th> </th>
               
                
              </tr>
            </thead>
            <tbody>
              {itemListData.map((itemData)=>(
                  <tr >
                  <td>{i++}</td>
                  <td>{itemData.assetNo}</td>
                  <td>{itemData.assetName}</td>
                  <td>{itemData.dateOfAssigned}</td>
                  <td>working</td>
                  <td>Null</td>
                  
                  <td>
                  <button style={{color:"white",backgroundColor:"black"}}onClick={() =>deleteItem(itemData.id)} >
                      DELETE
                    </button>
                  </td>
                  
                  
                  </tr>
              ))}
               
                
            </tbody>
          </table>
           </div>
           <button style={{color:"white",backgroundColor:"black",marginTop:"20px"}} onClick={AssignItem} >
                      Assign New Item
                      
                    </button>
           </div>
           <div id= "div2" style={{display:'block'}}>
            <img src='https://t4.ftcdn.net/jpg/04/21/45/51/360_F_421455125_uq2szZSTeL8LoFZ6QJPBt95Hz8xDgECQ.jpg ' height={400} width={600}/>

           </div>
      </div>
      </div>
      </div>
    </div>
  )
}

export default AssignItem
