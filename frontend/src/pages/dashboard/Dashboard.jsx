import { apiFetch } from "@/utils/api";
import { jwtDecode } from "jwt-decode";
import {useEffect, useState} from "react"
import { auth } from "@/utils/auth";

export default function Dashboard() {

  const [claims, setClaims] = useState([])
  const sub = jwtDecode(auth.token).sub
  useEffect(()=> {setClaims(() => apiFetch(`/claims/${sub}`))
  console.log(claims)}
  )

  return(
    <>
    <h1>Dashboard</h1>
    <span>{claims}</span>
    </>
  );

}
