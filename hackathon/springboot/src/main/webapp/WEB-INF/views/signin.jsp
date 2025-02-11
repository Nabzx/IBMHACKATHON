<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign In</title>
</head>
<body>
<h2>Sign In</h2>

<form action="http://localhost:8080/auth/register" method="post">
    <label>Email:</label>
    <input type="email" name="email" required><br>

    <label>Name:</label>
    <input type="text" name="name" required><br>

    <label>Password:</label>
    <input type="password" name="password" required><br>

    <button type="submit">Register</button>
</form>

<h3>Or Sign in with Google</h3>
<a href="/auth/oauth2/authorize/google">
    <button>Sign in with Google</button>
</a>

<c:if test="${not empty error}">
    <p style="color: red;">${error}</p>
</c:if>
</body>
</html>
