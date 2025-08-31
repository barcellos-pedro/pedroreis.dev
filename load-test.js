// Load Testing using K6
// https://grafana.com/docs/k6/latest/

import http from "k6/http"
import { sleep, check } from "k6"

export const options = {
  stages: [
    { duration: "10s", target: 5 },
    { duration: "1m15s", target: 10 },
    { duration: "30s", target: 30 },
  ],
}

export default function () {
  const res = http.get("https://pedroreis.dev")
  check(res, { "status was 200": (r) => r.status == 200 })
  sleep(0.3)
}
