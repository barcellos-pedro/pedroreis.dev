-- This SQL script provides example INSERT statements for the 'visits' table.
-- Use these to populate the table with sample data.

-- Example 1: A visit to the homepage from a desktop browser.
INSERT INTO visits (ip_address, user_agent, page_path)
VALUES ('203.0.113.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/100.0.4896.75 Safari/537.36', '/');

-- Example 2: A visit to an 'about' page from a mobile device.
INSERT INTO visits (ip_address, user_agent, page_path)
VALUES ('198.51.100.10', 'Mozilla/5.0 (iPhone; CPU iPhone OS 15_0 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/15.0 Mobile/15E148 Safari/604.1', '/about.html');

-- Example 3: Another visit to the homepage, perhaps from the same user.
INSERT INTO visits (ip_address, user_agent, page_path)
VALUES ('203.0.113.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/100.0.4896.75 Safari/537.36', '/');

-- Example 4: A visit from a different IP address to a product page.
INSERT INTO visits (ip_address, user_agent, page_path)
VALUES ('192.0.2.5', 'Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/90.0.4430.212 Safari/537.36', '/products/item_123');

-- Example 5: A user visiting a contact page.
INSERT INTO visits (ip_address, user_agent, page_path)
VALUES ('198.51.100.10', 'Mozilla/5.0 (iPhone; CPU iPhone OS 15_0 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/15.0 Mobile/15E148 Safari/604.1', '/contact');
