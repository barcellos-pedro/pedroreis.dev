// Load Testing using K6
// https://grafana.com/docs/k6/latest/

import http from "k6/http"
import { sleep } from "k6"

export const options = {
  gracefulRampDown: "5s",
  stages: [
    { duration: "30s", target: 20 },
    { duration: "1m30s", target: 10 },
    { duration: "20s", target: 0 },
  ],
  summaryTrendStats: [
    "avg",
    "min",
    "med",
    "max",
    "p(90)",
    "p(95)",
    "p(99.99)",
    "count",
  ],
}

export default function () {
  http.get("https://pedroreis.dev")
  check(res, { "status was 200": (r) => r.status == 200 })
  sleep(1)
}
