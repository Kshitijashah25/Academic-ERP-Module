import React from 'react'

/*
  This component is used for rendering the Nav Bar which contains the following,
  - Welcome message for the logged in user
  - Logout Button
  - In more complex webpages you can include routes here with the help of React-Router
*/
const NavBar = ({ user, setUser }) => {
  // If the Logout button has been clicked then clear the loggedInUser object from localStorage and
  // update "user" state to null, in order to logout, otherwise on the next reload, the Effect hook will again read the user
  // from the localStorage and relogin without showing the login form
  const logout = () => {
    window.localStorage.removeItem('loggedInUser')
    setUser(null)
  }

  // Prevents Key Exception errors if "user" state hasn't loaded yet
  if (!user)
    return null

  // Fully styled Navbar using Bootstrap (it can be a big pain to style Navbars)
  return (
    <div className='regular-shadow mb-1'>
      <nav className='navbar navbar-expand-lg navbar-dark' id='menu'>
        {/* UPDATE user.name PROPERTY IF IT DOESN'T EXIST */}
        <label>Welcome, {user.firstName}</label>
        
        {/* Bootstrap element for hamburger menu on collapse */}
          <span className='navbar-toggler-icon'></span>        
        {/* This menu will be collapsed under Hamburger Menu if screen size becomes small enough */}
        <div className='collapse navbar-collapse' id='navbarSupportedContent'>
      
          
          {/* Logout button */}
          <div className='inline my-2 my-lg-0'><button className='btn btn-primary' onClick={logout}>Logout</button></div>
        </div>
      </nav>
    </div>
  )
}

export default NavBar