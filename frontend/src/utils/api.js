import { auth } from "./auth";

export async function apiFetch(path, options = {}) {
  console.log("inside api.js");
  const headers = new Headers(options.headers || {});
  const token = auth.token;
  if (token) headers.set("Authorization", `Bearer ${token}`);
  headers.set("Content-Type", "application/json");
  const res = await fetch(`http://localhost:8080/api${path}`, {
    ...options,
    headers,
  });
  if (res.status === 401) throw new Error("Unauthorized");
  if (res.status === 404) return [];
  console.log("This is in the fetch, response: ", res);
  const response = await res.json();
  console.log("This is in the .json, response: ", response);
  return response;
}
