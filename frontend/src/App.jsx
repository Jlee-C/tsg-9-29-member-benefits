import { Routes, Route, useNavigate } from "react-router-dom";
import { useState } from "react";
import NavBar from "./components/navbar/NavBar";
import Login from "./pages/login/Login";
import Dashboard from "./pages/dashboard/Dashboard";
import Claims from "./pages/claims/Claims";
import ClaimsList from "./components/claims/claims-list/ClaimsList";
import ClaimDetails from "./components/claims/claim-details/ClaimDetails";
import ProtectedRoutes from "./utils/ProtectedRoutes";
import NotFound from "./pages/not-found/NotFound";
import { googleLogout } from "@react-oauth/google";
import { auth } from "@/utils/auth";
import { useEffect } from "react";
import { jwtDecode } from "jwt-decode";

export default function App() {
  const [user, setUser] = useState(null);
  const navigate = useNavigate();

  useEffect(() => {
    setUser(auth.token ? jwtDecode(auth.token) : null);
  }, []);

  function onLogIn(claims) {
    setUser(claims);
  }

  function logout() {
    auth.clear();
    googleLogout();
    setUser(null);
    navigate("/", { replace: true });
  }

  return (
    <>
      <NavBar claims={user} logout={logout} />
      <Routes>
        <Route path="/" element={<Login onLogIn={onLogIn} />} />
        <Route element={<ProtectedRoutes />}>
          <Route path="dashboard" element={<Dashboard />} />
          <Route path="claims" element={<Claims />}>
            <Route index element={<ClaimsList />} />
            <Route path="claim-details" element={<ClaimDetails />} />
          </Route>
        </Route>
        <Route path="*" element={<NotFound />} />
      </Routes>
    </>
  );
}
