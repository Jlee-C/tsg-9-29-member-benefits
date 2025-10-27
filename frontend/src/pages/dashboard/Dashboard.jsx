import { apiFetch } from "@/utils/api";
import { jwtDecode } from "jwt-decode";
import { useEffect, useState } from "react";
import { auth } from "@/utils/auth";

export default function Dashboard() {
  const [claims, setClaims] = useState([]);
  const [error, setError] = useState(null);
  const [loading, setLoading] = useState(true);
  const sub = jwtDecode(auth.token).sub ?? "";

  useEffect(() => {
    let mounted = true;
    console.log("Inside useEffect...");
    (async () => {
      try {
        const data = await apiFetch(`/claims/${sub}`);
        if (mounted) {
          setClaims(Array.isArray(data) ? data : []);
          setLoading(false);
        }
      } catch (e) {
        if (!mounted) return;
        const msg = String(e?.message || "");
        if (msg.includes("404")) {
          setClaims([]);
          setLoading(false);
        } else {
          setError(msg || "Failed to load claims");
          setLoading(false);
        }
      }
    })();

    return () => {
      mounted = false;
    };
  }, [sub]);

  if (loading) return <p>Loading…</p>;
  if (error) return <p role="alert">Error: {error}</p>;
  return (
    <main>
      <h1>Dashboard</h1>

      {claims.length === 0 ? (
        <p>No claims yet.</p>
      ) : (
        <table>
          <thead>
            <tr>
              <th>Claim #</th>
              <th>Status</th>
              <th>Service Start</th>
              <th>Service End</th>
              <th>Received</th>
              <th>Total Billed</th>
              <th>Allowed</th>
              <th>Plan Paid</th>
              <th>Member Resp.</th>
            </tr>
          </thead>
          <tbody>
            {claims.map((c) => (
              <tr key={c.id ?? c.claimNumber}>
                <td>{c.claimNumber}</td>
                <td>{c.status}</td>
                <td>{c.serviceStartDate}</td>
                <td>{c.serviceEndDate}</td>
                <td>{c.receivedDate}</td>
                <td>{c.totalBilled}</td>
                <td>{c.totalAllowed}</td>
                <td>{c.totalPlanPaid}</td>
                <td>{c.totalMemberResponsibility}</td>
              </tr>
            ))}
          </tbody>
        </table>
      )}
    </main>
  );
}
