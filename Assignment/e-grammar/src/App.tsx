import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import './App.css'
import Home from './Pages/Home'
import Signup from './Pages/Signup';
import SubscriptionPage from './Pages/Subscribe';

function App() {

  return (
    <Router>
      <Routes>
        <Route path='/' element={<Home />}/>
        <Route path='/signup' element={<Signup/>}/>
        <Route path='/subscribe' element={<SubscriptionPage/>}/>
      </Routes>
    </Router>
  )
}

export default App
