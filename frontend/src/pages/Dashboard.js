import React from "react";
import "../styles/dashboard.css";
import Header from "../components/Header";
import axios from "axios";
import { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import "../styles/adminHome.css";
import { BASE_URL } from "../components/constants/apiConstants";

function Dashboard(props) {
  const urls = [
    BASE_URL+"/inventory/employees",
    BASE_URL+"/inventory/items",
  ];
  const [employees, setEmployees] = useState([]);
  const [items, setItems] = useState([]);
  let i=1,j=1;
  const [isEmp, setIsEmp] = useState(true);
  const navigate = useNavigate();
  const UpdateItem = (itemdata) => {
    let path = "updateItem";
    navigate(path, { state: itemdata });
  };
  const UpdateEmp = (userdata) => {
    let path = "updateEmp";
    navigate(path, { state: userdata });
  };
  const fetchData = async (url) => {
    try {
      const { data } = await axios.get(url);
      console.log(data);
      return data;
    } catch (error) {}
  };
  useEffect(() => {
    const getData = async () => {
      const url = isEmp ? urls[0] : urls[1];
      const data = await fetchData(url);
      console.log(data);
      setEmployees(data);
    };
    getData();
  }, [isEmp]);
  return (
    <div>
      <body>
        <div id="sidebar" className="sidenav">
          <p>
            <h2>Inventory Management</h2>
          </p>
          <a href="/dashboard" style={{backgroundColor:"white"}}>
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
          <Header />

          <div className="ContentBox">
            <main>
              <div>
                <div className="btn-group">
                  <button
                    onClick={() => setIsEmp(true)}
                    className={isEmp ? "active" : ""}
                  >
                    View All Employees
                  </button>
                  <button
                    onClick={() => setIsEmp(false)}
                    className={!isEmp ? "active" : ""}
                  >
                    View All Assets
                  
                  </button>
                </div>
                {isEmp && (
                  <table>
                    <thead>
                      <tr>
                        <th>Id</th>
                        <th>Emp Id</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Email</th>
                        <th>Date of Birth</th>
                        <th>Date of Joining</th>
                        <th>Date Of Exit</th>
                        <th>Location</th>
                        <th>Designation</th>
                        <th>Phone Number</th>
                        <th> </th>
                      </tr>
                    </thead>
                    <tbody>
                      {employees.map((emp) => (
                        <tr key={emp.employeeId}>
                          <td>{i++}</td>
                          <td>{emp.employeeId}</td>
                          <td>{emp.firstName}</td>
                          <td>{emp.lastName}</td>
                          <td>{emp.email}</td>
                          <td>{emp.dateOfBirth}</td>
                          <td>{emp.dateOfJoining}</td>
                          <td>---</td>
                          <td>{emp.location}</td>
                          <td>{emp.desiganation}</td>
                          <td>{emp.phoneNo}</td>
                          <td>
                            <button
                              style={{
                                color: "white",
                                backgroundColor: "black",
                              }}
                              onClick={() => UpdateEmp(emp)}
                            >
                              UPDATE
                            </button>
                          </td>
                        </tr>
                      ))}
                    </tbody>
                  </table>
                )}
                {!isEmp && (
                  <table>
                    <thead>
                      <tr>
                        <th>Item Id</th>
                        <th>Item Number</th>
                        <th>Item Name</th>
                        <th>Item Type</th>
                        <th>Item Location</th>
                        <th>Date of Purchase</th>
                        <th> Working Status</th>
                        <th>Assigned Status </th>
                        <th>Incedents IF ANY ?</th>
                        <th></th>
                      </tr>
                    </thead>
                    <tbody>
                      {employees.map((item) => (
                        <tr key={item.itemId}>
                          <td>{j++}</td>
                          <td>{item.assetNo}</td>
                          <td>{item.assetName}</td>
                          <td>{item.assetType}</td>
                          <td>{item.assetLocation}</td>
                          <td>{item.dateOfPurchase}</td>
                          <td>{item.workingStatus}</td>
                          <td>
                            {item.assign_status ? "Assigned" : "Unassigned"}
                          </td>
                          <td>
                            {item.incidents == null ? "NULL" : item.incidents}
                          </td>
                          <td>
                            <button
                              style={{
                                color: "white",
                                backgroundColor: "black",
                              }}
                              onClick={() => UpdateItem(item)}
                            >
                              UPDATE
                            </button>
                          </td>
                        </tr>
                      ))}
                    </tbody>
                  </table>
                )}
              </div>
            </main>
          </div>
        </div>
      </body>
    </div>
  );
}

export default Dashboard;
