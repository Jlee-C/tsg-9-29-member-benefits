import { Link } from "react-router";

export default function ClaimsList() {
  return (
    <>
      <h1>Claims List</h1>
      <Link to={"claim-details"}>Claim Details</Link>
    </>
  );
}
