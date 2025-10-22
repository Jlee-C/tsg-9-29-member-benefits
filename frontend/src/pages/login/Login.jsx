
import { GoogleLogin } from "@react-oauth/google";

export default function Login() {
  return (
  <>
  <h1>Login</h1>
  <main>
    <div className="login-box">

      <GoogleLogin
      ux_mode="popup"
      onSuccess={(credentialResponse) => {
       console.log(credentialResponse);
        }}
      onError={() => {
        console.log('Login Failed');
      }}    
      />
    </div>
  </main>
  </>
  );
}
