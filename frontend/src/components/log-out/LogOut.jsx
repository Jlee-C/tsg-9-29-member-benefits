import "./LogOut.css";

export default function LogOut({ logout }) {
  return (
    <button onClick={logout} className="logout">
      Sign out
    </button>
  );
}
