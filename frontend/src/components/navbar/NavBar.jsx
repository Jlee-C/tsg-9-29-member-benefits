import { Link } from "react-router-dom";
import "./Navbar.css";
import LogOut from "../log-out/LogOut";
import { auth } from "@/utils/auth";

export default function NavBar(props) {
  const user = { ...props.claims };
  const logout = props.logout;
  return (
    <header className="banner">
      <h1>Member Benefits</h1>
      {user.name ? <span>{user.name}</span> : null}
      <nav className="nav">
        {auth.token ? null : (
          <Link to={"/"} className="nav-link">
            Home
          </Link>
        )}
        {auth.token ? (
          <section>
            <Link to={"dashboard"} className="nav-link">
              Dashboard
            </Link>
            <Link to={"claims"} className="nav-link">
              Claims
            </Link>
            <LogOut logout={logout} />
            <img
              className="profile-picture"
              src={user.picture}
              alt="Profile picture"
            />
          </section>
        ) : null}
      </nav>
    </header>
  );
}
