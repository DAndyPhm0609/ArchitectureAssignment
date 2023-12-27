import React from "react";
import { GoogleLogin, GoogleLoginResponse } from 'react-google-login';

type GoogleResponse = GoogleLoginResponse | { code: string };

const handleSubmit = () => {

}

const Signup : React.FC = () => {
  const handleGoogleLogin = (response: GoogleResponse) => {
    // Handle the Google login response here
    console.log('Google login response:', response);

    // You can access the user's profile information using response.profileObj
    const profile = 'profileObj' in response ? response.profileObj : null;
    if (profile) {
      console.log('User Profile:', profile);
    }
  };
  return (
    <div className="container">
      <h1>Sign Up</h1>
      <GoogleLogin
        clientId="YOUR_GOOGLE_CLIENT_ID"
        buttonText="Login with Google"
        onSuccess={handleGoogleLogin}
        onFailure={handleGoogleLogin} // Handle failure
        cookiePolicy={'single_host_origin'}
      />
      <form onSubmit={handleSubmit}>
        <div>
        <div>
          <input type="text" placeholder="PLease enter username" required />
        </div>
        <div>
          <input type="text" placeholder="Please enter password" required />
        </div>
          <input type="text" placeholder="Please enter password again" required />
        </div>
        <div>
          <button type="submit">Sign Up</button>
        </div>
      </form>
    </div>
  )
}

export default Signup