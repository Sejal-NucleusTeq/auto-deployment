import React from 'react'
import "../styles/assign.css";
import axios from "axios";
import {useState, useEffect } from "react";
import { useParams } from "react-router-dom";
import Header from '../components/Header';
import { BASE_URL } from '../components/constants/apiConstants';
const AssignNew = () => {
  const defaultAssignedData = {
    itemName: "",
    assignedDate: "",
  };
  const [itemData, setItemData] = useState([]);
  const [tableData, setTableData] = useState([defaultAssignedData]);
  const { employeeId, employeeTableId } = useParams();
  const [row, setRow] = useState([
    {
      assetTableId: "",
      dateOfAssigned: "",
      employeeTableId: parseInt(employeeTableId),
      employeeId: employeeId,
      assetNo:"",
      assetName:"",
      assetReceivedBy: "Office",
    },
  ]);
  const handleChange = (type, index, value) => {
    console.log("type index value", type, index, value);
    let temp = row;
    temp[index][type] = value;
    console.log("Temp data", temp);
    setRow(temp);
  };
  const handleItemDelete = (idx) => {
    const list = [...row];
    list.splice(idx, 1);
    setRow(list);
  };
  const addMoreRow = () => {
    setRow([
      ...row,
      {
        assetTableId: "",
      dateOfAssigned: "",
      employeeTableId: parseInt(employeeTableId),
      employeeId: employeeId,
      assetNo:"",
      assetName:"",
      assetReceivedBy: "Office",
      },
    ]);
  };
  const fetchData = async () => {
    try {
      const { data } = await axios.get("http://localhost:8080/inventory/getUnassignedItems");
      console.log(data);
      setItemData(data);
      console.log(tableData);
    } catch (error) {
      console.log(error);
    }
  };
  useEffect(() => {
    fetchData();
  }, []);
  const handleItemAdd = async (item) => {
    let newArray = row.map((item) => ({
      ...item,
      itemtableId: Number(item.itemtableId.split("+")[0]),
    }));
    console.log("new array", newArray);
    try {
      await axios
        .post(BASE_URL+"/inventory/assignItem+", newArray)
        .then((res) => {
          console.log("response data", res);
          fetchData();
          console.log("Success...");
        });
    } catch (error) {
      console.log(error);
    }
  };
  return (
    <div>
      <div className="table-container" style={{marginLeft:"4rem",marginTop:"2rem",backgroundColor:"#E27D60"}}>
        <table>
          <thead>
            <tr>
              <th>Id</th>
              <th>Item No. with Name</th>
              <th>Date of assigned</th>
              <th></th>
            </tr>
          </thead>
          <tbody>
            {row.map((item, idx) => (
              <tr key={item.itemId}>
                <td>{idx + 1}</td>
                {console.log("item name is", item.assetName)}
                <td>
                  <select
                    value={item.itemId}
                    onChange={(e, key) => {
                      console.log("hiii ", e.target.value, idx);
                      let itemId = e.target.value.split("+");
                      console.log("item id is", itemId[0]);
                      handleChange("itemtableId", idx, e.target.value);
                      console.log("item id onchange id", e.target.value);
                    }}
                  >
                    <option value="">Select an Item</option>
                    {itemData.map((item) => (
                      <option
                        value={item.itemId}
                        key={item.itemId}
                      >
                        {item.assetName}
                      </option>
                    ))}
                  </select>
                </td>
                <td>
                  
                  <input
              id="dateOfAssign"
                type="date"
                name="dateOfAssign"
                value={item.dateOfAssigned}
                onChange={(e) => {
                  handleChange("assignedDate", idx, e.target.value);
                }}
                
              />
                </td>
                <td>
                  <button onClick={() => handleItemDelete(idx)} style={{marginRight:"2rem"}}>Delete</button>
                  <button className="add" onClick={() => addMoreRow()}> Add More</button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
       
      </div>
      <br/>
        <button className="assign-item" onClick={() => handleItemAdd()}>
          Assign Item
        </button>
    </div>
  );
};
export default AssignNew;









