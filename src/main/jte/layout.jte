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

    <!-- Primary Meta Tags -->
    <meta name="title" content="My GitHub Projects Stats">
    <meta name="description" content="Web App to show my main projects stats from GitHub API.">
    <meta name="keywords" content="GitHub, projects, stats, web app, portfolio">
    <meta name="author" content="Pedro Barcellos dos Reis (barcellos-pedro)">

    <!-- Open Graph / Facebook -->
    <meta property="og:type" content="website">
    <meta property="og:url" content="https://www.pedroreis.dev">
    <meta property="og:title" content="My GitHub Projects Stats">
    <meta property="og:description" content="Web App to show my main projects stats from GitHub API.">
    <meta property="og:image" content="https://www.pedroreis.dev/social-preview.png">

    <!-- Twitter -->
    <meta name="twitter:card" content="summary_large_image">
    <meta name="twitter:url" content="https://www.yourwebsite.com/">
    <meta name="twitter:title" content="My GitHub Projects Stats">
    <meta name="twitter:description" content="Web App to show my main projects stats from GitHub API.">
    <meta name="twitter:image" content="https://www.pedroreis.dev/social-preview.png">

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