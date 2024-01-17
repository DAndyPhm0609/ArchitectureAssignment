import React, {useState} from 'react';
import "./Home.css"

import { GoogleLogin, GoogleLoginResponse, GoogleLoginResponseOffline } from 'react-google-login';
import FacebookLogin, { ReactFacebookLoginInfo, ReactFacebookFailureResponse } from 'react-facebook-login';

const Home: React.FC = () => {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
  const handleGoogleLogin = (response: GoogleLoginResponse | GoogleLoginResponseOffline) => {
    console.log('Google login response:', response);
    const profile = 'profileObj' in response ? response.profileObj : null;
    if (profile) {
      console.log('User Profile:', profile);
    }
  };

  const handleFacebookLogin = (userInfo: ReactFacebookLoginInfo | ReactFacebookFailureResponse) => {
    // Handle the Facebook login response here
    console.log('Facebook login response:', userInfo);
    if ('id' in userInfo) {
      // Successful Facebook login
      console.log('User ID:', userInfo.id);
      console.log('Name:', userInfo.name);
      console.log('Email:', userInfo.email);
    } else if ('errorMessage' in userInfo) {
      // Facebook login failed
      console.error('Facebook login failed:', userInfo.errorMessage);
    }
  };
    const handleSubmit = async (e: React.FormEvent) => {
        e.preventDefault();

        try {
            const response = await fetch('http://localhost:8081/auth/login', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify({ username, password }),
            });

            if (!response.ok) {
                throw new Error(`HTTP error! Status: ${response.status}`);
            }

            const data = await response.json();
            console.log('Login successful', data);
            // Handle successful login, e.g., redirect to dashboard
        } catch (error) {
            console.error('Login failed');
            // Handle login failure, e.g., show error message
        }
    };
  

  return (
    <div className="home-container">
      <h1>Welcome to E-grammar</h1>
      <p>Improve your writing skills with our advanced tools.</p>

      <GoogleLogin
        clientId="YOUR_GOOGLE_CLIENT_ID"
        buttonText="Login with Google"
        onSuccess={handleGoogleLogin}
        onFailure={handleGoogleLogin}
        cookiePolicy={'single_host_origin'}
      />
      <FacebookLogin
          appId="YOUR_FACEBOOK_APP_ID"
          fields="name,email,picture"
          callback={handleFacebookLogin}
          textButton="Login with Facebook"
        />

      <p>Or use your E-grammar account</p>
      <form onSubmit={handleSubmit}>
          <label>
              Username:<input type="text" value={username} onChange={(e) => setUsername(e.target.value)} required/>
          </label>
          <br />
          <label>
              Password:<input type="password" value={password} onChange={(e) => setPassword(e.target.value)} required/>
          </label>
        {/*<input type="text" placeholder="Username" required />*/}
        {/*<input type="password" placeholder="Password" required />*/}
        <div className="password-options">
          <button type="submit">Login</button>
        </div>
      </form>

      <a href="/signup">Don't have an account? Sign Up</a>
    </div>
  );
};

export default Home;
