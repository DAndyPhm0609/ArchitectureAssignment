import React, { useState } from "react";
import userIcon from "../../assets/user-profile.png";
import "./Profile.css";

const Profile: React.FC = () => {
  const [isHovered, setIsHovered] = useState(false);

  const handleMouseEnter = () => {
    setIsHovered(true);
  };

  const handleMouseLeave = () => {
    setIsHovered(false);
  };

  const username = "Nguyen Ngo";
  const email = "nguyenngo@gmail.com";
  const subDetail = "Premium";

  return (
    <div className="container">
        <h1>Profile</h1> 
        <div className="profile-avatar-button">
            <label
                className={`avatar-button ${isHovered ? "hovered" : ""}`}
                onMouseEnter={handleMouseEnter}
                onMouseLeave={handleMouseLeave}
            >
            <input type="file" accept="image/*" style={{ display: "none" }} />
            <img
                src={userIcon}
                alt="Upload Avatar"
                className="avatar"
                style={{ width: "200px", height: "auto" }}
            />
            {isHovered && <span className="text">Change Avatar</span>}
            </label>
      </div>
      <div className="user-details">
        <div className="username">Name: {username}</div>
        <div className="email">Email: {email}</div>
        <div className="subDetail">
          Subscription: <span className="subDetail-text">{subDetail}</span>
        </div>
      </div>
    </div>
  );
};

export default Profile;
