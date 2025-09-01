@param String title = null
@param gg.jte.Content content

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="/simple.css">
    <link rel="stylesheet" href="/style.css">
    <link rel="icon" type="image/x-icon" href="/favicon.ico"> 
    <script src="/script.js" defer></script>
    <title>
        @if (title == null)
            pedroreis.dev
        @else
            ${title}
        @endif
    </title>
</head>
<body>
<main>
    ${content}
</main>
</body>
</html>