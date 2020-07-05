<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Hello!</title>
</head>
<body>
<h2>
    ${greeting} ${username}!
</h2>

<#if _authorities?seq_contains("ROLE_ADMIN")>
    ${username} you are an <a href="/admin/users/">Admin</a>
</#if>

</body>
</html>