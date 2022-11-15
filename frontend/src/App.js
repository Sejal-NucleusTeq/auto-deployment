import './App.css';
import { BrowserRouter as Router,Route,Routes} from 'react-router-dom';
import Login1 from './pages/Login1';
import Register from './pages/Register';
import AddEmployee from './pages/AddEmployee';
import AddItem from './pages/AddItem';
import AssignItem from './pages/AssignItem';
import Dashboard from './pages/Dashboard';
import AdminHome from './pages/AdminHome';
import UpdateEmp from './pages/UpdateEmpl';
import UpdateItem from './pages/UpdateItem';
import User from './pages/User';
import ResetPassword from './pages/ResetPassword';
import AssignNew from './pages/AssignNew';

function App() {
  return (
    <div className="App">
    {(
      <Router>
        <Routes>
            <Route exact path='/'          element={<Login1/>}     ></Route>
            <Route exact path='/register'    element={<Register/>}   ></Route>
            <Route exact path='/add-employee'    element={<AddEmployee/>}   ></Route>
            <Route exact path='/add-item'    element={<AddItem/>}   ></Route>
            <Route exact path='/assignItems'    element={<AssignItem/>}   ></Route>
            <Route exact path='/dashboard'    element={<Dashboard/>}   ></Route>
            <Route exact path='/adminHome'    element={<AdminHome/>}   ></Route>
            <Route exact path='dashboard/updateEmp'    element={<UpdateEmp/>}   ></Route>
            <Route exact path='dashboard/updateItem'    element={<UpdateItem/>}   ></Route>
            <Route exact path='/userDashboard'    element={<User/>}   ></Route>
            <Route exact path='/resetPassword'    element={<ResetPassword/>}   ></Route>
            <Route exact path='/assignNew'    element={<AssignNew/>}   ></Route>
        </Routes>
      </Router> 
    )}
  </div>    
 
  );
}

export default App;
