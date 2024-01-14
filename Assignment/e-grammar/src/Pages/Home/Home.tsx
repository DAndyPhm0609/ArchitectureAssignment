import React from 'react';
import "./Home.css"

import { GoogleLogin, GoogleLoginResponse, GoogleLoginResponseOffline } from 'react-google-login';
import FacebookLogin, { ReactFacebookLoginInfo, ReactFacebookFailureResponse } from 'react-facebook-login';

const Home: React.FC = () => {
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

      <form>
        <input type="text" placeholder="Username" required />
        <input type="password" placeholder="Password" required />
        <div className="password-options">
          <button type="submit">Login</button>
          <a href="/forgot-password">Forgot Password?</a>
        </div>
      </form>

      <a href="/signup">Don't have an account? Sign Up</a>
    </div>
  );
};

export default Home;
