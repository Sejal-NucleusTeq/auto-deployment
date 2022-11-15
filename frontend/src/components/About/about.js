import React from 'react';
import {CardGroup,Card,Button} from 'react-bootstrap';
import about from '../images/about.jpg';
import './about.css';

function About()
{
	return(
<>
  <h1 id="ss" style={{color:'#00b4db',fontSize:'55px'}} className="text-center">Nucleus Teq Inventory Portal</h1>
  <center><hr className="text-center" style={{ width:'50%'}}/>
	</center>
  <div  className="row">

    <div className="col-lg-6 ">
      <div className="container">
        <img src={about} className="about-img"/>
      </div>
    </div>
    <div className="col-lg-6 mb-6">
      
    </div>
  </div>

</>

		);
}



export default About;