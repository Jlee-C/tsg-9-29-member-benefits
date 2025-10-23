import { auth } from "@/utils/auth";

export default function LogOut() {
  return (
    <button
      onClick={() => {
        auth.clear();
        console.log("Logging Out");
      }}
    >
      Log Out
    </button>
  );
}
