import React from 'react'
import "../styles/view.css";
function ViewEmployee() {
  return (
    <>
   <div className='view-container'>
   <div className='view-heading'>
   <h1>All Employees</h1>
   </div>
    <table style={{width:"100vw"}}>
                    <thead>
                        <tr>

                            <th className=' p-2 pt-1'>Completed</th>
                            <th className=' p-2 pt-1' scope="col">Title</th>
                            <th className=' p-2 pt-1' scope='col'>Task</th>
                            <th className=' p-2 pt-1' scope='col'>Deadline</th>
                            <th className=' p-2 pt-1' scope='col'>Active</th>
                            <th className=' p-2 pt-1'>Completed</th>
                            <th className=' p-2 pt-1' scope="col">Title</th>
                            <th className=' p-2 pt-1' scope='col'>Task</th>
                            <th className=' p-2 pt-1' scope='col'>Deadline</th>
                            <th className=' p-2 pt-1' scope='col'>Active</th>
                        </tr>
                    </thead>
                    <tbody>
                                    <tr >
                                        <td>1111</td>
                                        <td>1111</td>
                                        <td>1111</td>
                                        <td>1111</td>
                                        <td>1111</td>
                                        <td>1111</td>
                                        <td>1111</td>
                                        <td>1111</td>
                                        <td>1111</td>
                                        <td>1111</td>
                                        
                                       
                                    </tr>
                                    <tr >
                                        <td>1111</td>
                                        <td>1111</td>
                                        <td>1111</td>
                                        <td>1111</td>
                                        <td>1111</td>
                                        <td>1111</td>
                                        <td>1111</td>
                                        <td>1111</td>
                                        <td>1111</td>
                                        <td>1111</td>
                                        
                                       
                                    </tr>
              
                    </tbody>
                </table>
   </div>
    </>
  )
}

export default ViewEmployee
