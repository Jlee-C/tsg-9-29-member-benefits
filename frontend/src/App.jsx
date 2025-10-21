import { BrowserRouter, Routes, Route } from "react-router";
import NavBar from "./components/navbar/NavBar";
import Login from "./pages/login/Login";
import Dashboard from "./pages/dashboard/Dashboard";
import Claims from "./pages/claims/Claims";
import ClaimsList from "./components/claims/claims-list/ClaimsList";
import ClaimDetails from "./components/claims/claim-details/ClaimDetails";
export default function App() {
  return (
    <BrowserRouter>
      <NavBar />
      <Routes>
        <Route path="/" element={<Login />} />
        <Route path="dashboard" element={<Dashboard />} />
        <Route path="claims" element={<Claims />}>
          <Route index element={<ClaimsList />} />
          <Route path="claim-details" element={<ClaimDetails />} />
        </Route>
      </Routes>
    </BrowserRouter>
  );
}
