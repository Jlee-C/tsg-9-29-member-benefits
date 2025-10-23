export default function Login() {
  function handleLogin() {
    window.location.href = "http://localhost:8080/oauth2/authorization/google";
  }

  return (
    <div className="login-page">
      <h1>Sign in</h1>
      <button onClick={handleLogin}>Sign in with Google</button>
    </div>
  );
}
