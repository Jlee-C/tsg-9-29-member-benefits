import { Navigate, Outlet } from "react-router";
import { auth } from "./auth";

export default function ProtectedRoutes() {
  return auth.token ? <Outlet /> : <Navigate to="/" replace />;
}
