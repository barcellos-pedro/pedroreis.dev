CREATE TABLE IF NOT EXISTS visits (
    -- The `id` column serves as the primary key and will auto-increment.
    -- This ensures each visit has a unique identifier.
    id INTEGER PRIMARY KEY AUTOINCREMENT,

    -- The `timestamp` records the exact time the visit occurred.
    -- This is crucial for chronological tracking and analysis.
    visit_timestamp TEXT DEFAULT CURRENT_TIMESTAMP,

    -- `ip_address` stores the visitor's IP address.
    -- This can be used to count unique visitors or analyze geographic data.
    ip_address TEXT,

    -- `user_agent` stores information about the user's browser and operating system.
    -- Useful for understanding the types of devices and software used by visitors.
    user_agent TEXT,

    -- `page_path` records the specific page the user visited.
    -- This allows for per-page visit counts and popularity tracking.
    page_path TEXT NOT NULL
);
