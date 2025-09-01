@param String title = null
@param gg.jte.Content content

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="icon" type="image/x-icon" href="/favicon.ico"> 
    
    <title>
        @if (title == null)
            pedroreis.dev
        @else
            ${title}
        @endif
    </title>

    <!-- HTML Meta Tags -->
    <!-- Generated via https://www.opengraph.xyz -->
    <meta name="description" content="Web App to show my main projects stats from GitHub API.">

    <!-- Facebook Meta Tags -->
    <meta property="og:type" content="website">
    <meta property="og:url" content="https://pedroreis.dev/">
    <meta property="og:title" content="My GitHub Projects Stats">
    <meta property="og:description" content="Web App to show my main projects stats from GitHub API.">
    <meta property="og:image" content="https://pedroreis.dev/social-preview.jpg">

    <!-- Twitter Meta Tags -->
    <meta name="twitter:card" content="summary_large_image">
    <meta property="twitter:domain" content="pedroreis.dev">
    <meta name="twitter:title" content="My GitHub Projects Stats">
    <meta property="twitter:url" content="https://pedroreis.dev/">
    <meta name="twitter:description" content="Web App to show my main projects stats from GitHub API.">
    <meta name="twitter:image" content="https://pedroreis.dev/social-preview.jpg">

    <!-- Scripts -->
    <link rel="stylesheet" href="/simple.css">
    <link rel="stylesheet" href="/style.css">
    <script src="/script.js" defer></script>
</head>
<body>
<main>
    ${content}
</main>
</body>
</html>