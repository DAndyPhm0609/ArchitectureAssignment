import React from "react";
import uploadIcon from "../../assets/upload.png";
import profileIcon from "../../assets/profile-user.png"
import "./Main.css"; // Assuming you have a CSS file for styling

const Main: React.FC = () => {
  return (
    <div className="container">
      <label className="custom-upload-button">
        <input type="file" accept=".doc" style={{ display: "none" }} />
        <img src={uploadIcon} alt="Upload Icon" className="upload-icon" />
        <span className="upload-text">Upload File</span>
      </label>
      <div className="profile-container">
        <a href="/profile" className="profile-button">
          <img src={profileIcon} alt="Profile" className="profile-icon" />
        </a>
      </div>
    </div>
  );
};

export default Main;
