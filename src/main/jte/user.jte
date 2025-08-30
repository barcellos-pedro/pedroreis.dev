@param String avatarUrl
@param String visits
@param String userName

@template.layout(title = "User info",
content = @`
    <h1></h1>
    <p>Total visits: ${visits}</p>
    <p>${userName}</p>
    <img src="${avatarUrl}" width="100" alt="user profile image">
`)
