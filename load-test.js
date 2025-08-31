// Load Testing using K6
import http from "k6/http"
import { sleep } from "k6"

export const options = {
  iterations: 10,
}

export default function () {
  http.get("https://pedroreis.dev")
  sleep(1)
}
