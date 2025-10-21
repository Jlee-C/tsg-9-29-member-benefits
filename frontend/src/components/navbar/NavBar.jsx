import { Link } from "react-router";
import "./Navbar.css";

export default function NavBar() {
  return (
    <header className="banner">
      <h1>Member Benefits</h1>
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
      </nav>
    </header>
  );
}
