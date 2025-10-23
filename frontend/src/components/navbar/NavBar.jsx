import { Link } from "react-router";
import "./Navbar.css";
import LogOut from "../log-out/LogOut";
import { auth } from "@/utils/auth";

export default function NavBar(claims) {
  return (
    <header className="banner">
      <h1>Member Benefits</h1>
      {claims.name ? <span>{claims.name}</span> : null}
      <nav className="nav">
        <Link to={"/"} className="nav-link">
          Home
        </Link>
        <Link to={"dashboard"} className="nav-link">
          Dashboard
        </Link>
        <Link to={"claims"} className="nav-link">
          Claims
        </Link>
        {auth.token ? <LogOut /> : null}
        {claims.picture ? (
          <img
            className="profile-picture"
            src={claims.picture}
            alt="Profile picture"
          />
        ) : null}
      </nav>
    </header>
  );
}
