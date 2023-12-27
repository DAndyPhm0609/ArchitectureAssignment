import React, { useState } from "react";
import userIcon from "../../assets/user.png";

const Profile: React.FC = () => {
  const [isHovered, setIsHovered] = useState(false);

  const handleMouseEnter = () => {
    setIsHovered(true);
  };

  const handleMouseLeave = () => {
    setIsHovered(false);
  };

  return (
    <div className="container">
      <div
        className={`profile-avatar-button ${isHovered ? "hovered" : ""}`}
        onMouseEnter={handleMouseEnter}
        onMouseLeave={handleMouseLeave}
      >
        <input type="file" accept="image/*" style={{ display: "none" }} />
        <img src={userIcon} alt="Upload Avatar" className={`avatar ${isHovered ? "hovered" : ""}`} />
        {isHovered && <span className="text">Change Avatar</span>}
      </div>
    </div>
  );
};

export default Profile;
