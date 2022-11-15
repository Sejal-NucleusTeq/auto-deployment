import React, { useState } from "react";
import "./header1.css";
import { GiHamburgerMenu } from "react-icons/gi";
import nucleuslogo from "../../images/nucleuslogo.png";

const Header = () => {
  const Brand = "C E M K";
  const [showIcons, setShowIcons] = useState(false);
  return (
    <div>
      <header>
        <div
          style={{
            width: "fit-content",
            borderRadius: "73px",
            paddingLeft: "5px",
          }}
        >
          <span>
            <img src={nucleuslogo} height="80" width="80" />
          </span>
        </div>
      </header>
    </div>
  );
};

export default Header;
