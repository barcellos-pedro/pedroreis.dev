-- Creat-Drop Tables --
DROP TABLE IF EXISTS visits;
DROP TABLE IF EXISTS links;

-- Create Tables --
CREATE TABLE IF NOT EXISTS visits (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    visit_timestamp TEXT DEFAULT CURRENT_TIMESTAMP,
    page_path TEXT NOT NULL,
    ip_address TEXT,
    user_agent TEXT
);

CREATE TABLE IF NOT EXISTS links (
	id INTEGER PRIMARY KEY AUTOINCREMENT,
	title TEXT NOT NULL,
	url TEXT NOT NULL
);
