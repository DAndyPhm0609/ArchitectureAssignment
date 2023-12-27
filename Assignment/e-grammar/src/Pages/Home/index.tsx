import React from 'react';
import { GoogleLogin, GoogleLoginResponse } from 'react-google-login';

type GoogleResponse = GoogleLoginResponse | { code: string };

const Home : React.FC = () => {

  const handleGoogleLogin = (response: GoogleResponse) => {
    // Handle the Google login response here
    console.log('Google login response:', response);

    // You can access the user's profile information using response.profileObj
    const profile = 'profileObj' in response ? response.profileObj : null;
    if (profile) {
      console.log('User Profile:', profile);
    }
  };

  const handleSubmit = () => {

  } 
  return (
    <div className="container">
      <h1>Log in to your E-grammar</h1>

      <GoogleLogin
        clientId="YOUR_GOOGLE_CLIENT_ID"
        buttonText="Login with Google"
        onSuccess={handleGoogleLogin}
        onFailure={handleGoogleLogin} // Handle failure
        cookiePolicy={'single_host_origin'}
      />
      
      <form onSubmit={handleSubmit}>
        <div>
          <input type="text" placeholder="Username" required />
        </div>
        <div>
          <input type="text" placeholder='Password'required />
        </div>
        <div>
          <button type="submit">Login</button>
        </div>
      </form>
      <a href="/signup">Don't have an account?</a>
    </div>
  )
}

export default Home