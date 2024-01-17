import React, { useState } from 'react';
import './Signup.css';
import { GoogleLogin, GoogleLoginResponse, GoogleLoginResponseOffline } from 'react-google-login';

const Signup: React.FC = () => {
  const [formData, setFormData] = useState({
    username: '',
    password: '',
    confirmPassword: '',
  });

  const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    setFormData({
      ...formData,
      [e.target.name]: e.target.value,
    });
  };

  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault();
    // Check if the form all has details
    if (!formData.username || !formData.password) {
      alert('Please fill in all fields.');
      return; // Exit the function if any field is empty
    }

    if (formData.password.length < 8) {
      alert('Password must be at least 8 characters long.');
      return; // Exit the function if the password is too short
    }

    if(formData.password != formData.confirmPassword){
      alert('Confirm password does not match with the password');
      return;
    }

    try {
      //Using the api to post the formData to the database after turning it into json.
      const response = await fetch( 'http://localhost:8081/auth/add_user', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(formData),
      });

      if (response.ok) {
        // Alert the user when they successfuly create a new account
        window.location.href = '/'
        alert('User registered successfully!');
      } else {
        // Alert the user when they failed to create a new account
        alert('User registration failed.');
      }
    } catch (error) {
      console.error('Error registering user:', error);
    }
  };
  
  const handleGoogleLogin = (response: GoogleLoginResponse | GoogleLoginResponseOffline) => {
    console.log('Google login response:', response);
    const profile = 'profileObj' in response ? response.profileObj : null;
    if (profile) {
      console.log('User Profile:', profile);
    }
  };

  
  return (
    <div className="signup-container">
      <div className="signup-form">
        <h1>Create an Account</h1>
        <form onSubmit={handleSubmit}>
          <div className="input-group"><label htmlFor="username">Username</label><input type="text" id="username" name="username" value={formData.username} onChange={handleChange} required/>
          </div>
          <div className="input-group"><label htmlFor="password">Password</label><input type="password" id="password" name="password" value={formData.password} onChange={handleChange} required/>
          </div>
          <div className="input-group"><label htmlFor="confirmPassword">Confirm Password</label><input type="password" id="confirmPassword" name="confirmPassword" value={formData.confirmPassword} onChange={handleChange} required/>
          </div>
          <button type="submit">Sign Up</button>
        </form>
        <p>
          Already have an account? <a href="/">Login</a>
        </p>
      </div>
      <div className="social-login">
        {/* Login with Google button */}
        <GoogleLogin
          clientId="YOUR_GOOGLE_CLIENT_ID"
          buttonText="Login with Google"
          onSuccess={handleGoogleLogin}
          onFailure={handleGoogleLogin}
          cookiePolicy={'single_host_origin'}
        />
      </div>

    </div>
  );
};

export default Signup;
