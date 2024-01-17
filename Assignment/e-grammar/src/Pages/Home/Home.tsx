import React, {useState} from 'react';
import "./Home.css"

import { GoogleLogin, GoogleLoginResponse, GoogleLoginResponseOffline } from 'react-google-login';

const Home: React.FC = () => {
  const handleGoogleLogin = (response: GoogleLoginResponse | GoogleLoginResponseOffline) => {
    console.log('Google login response:', response);
    const profile = 'profileObj' in response ? response.profileObj : null;
    if (profile) {
      console.log('User Profile:', profile);
    }
  };

    const [formData, setFormData] = useState({
        username: '',
        password: '',
    });

    const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
        setFormData({
            ...formData,
            [e.target.name]: e.target.value,
        });
    };

    const handleFormLogin = async (e: React.FormEvent) => {
        e.preventDefault();
        // Check if the form all has details
        if (!formData.username || !formData.password) {
            alert('Please fill in all fields.');
            return; // Exit the function if any field is empty
        }
        try {
            //Using the api to post the formData to the database after turning it into json.
            const response = await fetch( 'http://localhost:8081/auth/login', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(formData),
            });
            console.log(response);
            response.json().then((data) => {
                if (data.ok) {
                    // Alert the user when they successfuly create a new account
                    window.location.href = '/Main'
                    alert('User login successfully!');
                } else {
                    // Alert the user when they failed to create a new account
                    alert('User login failed.');
                }
            })
0

        } catch (error) {
            console.error('Error login user:', error);
        }
    };

    // const handleFormLogin = async (e: React.FormEvent) => {
    //     e.preventDefault();
    //
    //     try {
    //         const response = await fetch('http://localhost:8081/auth/users');
    //         if (!response.ok) {
    //             throw new Error('Failed to fetch user data');
    //         }
    //
    //         const users = await response.json();
    //
    //         const { username, password } = formData;
    //         const user = users.find((u: any) => u.username === username && u.password === password);
    //
    //         if (user) {
    //             // Load the user's id, username on successful authentication
    //             window.location.href = '/Main';
    //         } else {
    //             // Return null for failed authentication
    //             alert('login failed');
    //             return null;
    //         }
    //     } catch (error) {
    //         console.error('Error authenticating user:', error);
    //         return null;
    //     }
    // };

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
      <p>Or use your E-grammar account</p>

      <form onSubmit={handleFormLogin}>
          <div className="input-group"><label htmlFor="username">Username</label><input type="text" id="username" name="username" value={formData.username} onChange={handleChange} required/>
          </div>
          <div className="input-group"><label htmlFor="password">Password</label><input type="password" id="password" name="password" value={formData.password} onChange={handleChange} required/>
          </div>
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
