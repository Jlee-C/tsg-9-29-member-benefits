import { GoogleLogin } from "@react-oauth/google";
import { useState } from "react";
import { useNavigate } from "react-router";
import { auth } from "@/utils/auth";
import { jwtDecode } from "jwt-decode";
import "./Login.css";

export default function Login({ onLogIn }) {
  const [errorMesg, setErrorMesg] = useState("");
  const navigate = useNavigate();
  return (
    <section className="page">
      <div className="login-page">
        <h1>Log in</h1>
        <GoogleLogin
          ux_mode="popup"
          onSuccess={(credentialResponse) => {
            const idToken = credentialResponse.credential;
            const claims = jwtDecode(idToken);
            auth.token = idToken;
            console.log("Credentials: ok! Claims: ", claims);
            setErrorMesg("");
            onLogIn?.(claims);
            navigate("/dashboard");
          }}
          onError={() => {
            console.log("Error: Authentication Failed");
            setErrorMesg("Error: Authentication Failed");
          }}
        />
        {errorMesg ? <span>{errorMesg}</span> : null}
      </div>
    </section>
  );
}
