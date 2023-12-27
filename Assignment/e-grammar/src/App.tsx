import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import './App.css'
import Home from './Pages/Home'
import Signup from './Pages/Signup';
import SubscriptionPage from './Pages/Subscribe';
import Main from './Pages/Main';
import Profile from './Pages/Profile';

function App() {

  return (
    <Router>
      <Routes>
        <Route path='/' element={<Home />}/>
        <Route path='/signup' element={<Signup/>}/>
        <Route path='/subscribe' element={<SubscriptionPage/>}/>
        <Route path='/main' element={<Main/>}/>
        <Route path='/profile' element={<Profile/>}/>
      </Routes>
    </Router>
  )
}

export default App
