import { Link, Outlet } from "react-router";

export default function Claims() {
  return (
    <div>
      <h1>Claims</h1>
      {/* will either be <ClaimsList/> or <ClaimDetails/> */}
      <Link to="claim-details" />
      <Outlet />
    </div>
  );
}
