import { auth } from "./auth";

export async function apiFetch(path, options = {}) {
  const headers = new Headers(options.headers || {});
  const token = auth.token;
  if (token) headers.set("Authorization", `Bearer ${token}`);
  headers.set("Content-Type", "application/json");
  const res = await fetch(`/api${path}`, { ...options, headers });
  if (res.status === 401) throw new Error("Unauthorized");
  const response = await res.json();
  return response;
}
