import { BrowserRouter, Routes, Route } from "react-router";
import { useState } from "react";
import NavBar from "./components/navbar/NavBar";
import Login from "./pages/login/Login";
import Dashboard from "./pages/dashboard/Dashboard";
import Claims from "./pages/claims/Claims";
import ClaimsList from "./components/claims/claims-list/ClaimsList";
import ClaimDetails from "./components/claims/claim-details/ClaimDetails";
import ProtectedRoutes from "./utils/ProtectedRoutes";
export default function App() {
  const [name, setName] = useState("");
  const [picture, setPicture] = useState("");

  function onLogIn(claims) {
    console.log("--In onLogIn--");
    setPicture(() => claims.picture);
    setName(() => claims.name);
  }

  return (
    <BrowserRouter>
      <NavBar name={name} picture={picture} />
      <Routes>
        <Route path="/" element={<Login onLogIn={onLogIn} />} />
        <Route element={<ProtectedRoutes />}>
          <Route path="dashboard" element={<Dashboard />} />
          <Route path="claims" element={<Claims />}>
            <Route index element={<ClaimsList />} />
            <Route path="claim-details" element={<ClaimDetails />} />
          </Route>
        </Route>
      </Routes>
    </BrowserRouter>
  );
}
