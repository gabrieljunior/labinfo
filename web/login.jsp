<%-- 
    Document   : login
    Created on : 27/09/2018, 19:27:04
    Author     : Gabriel Júnior
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login | LabInfo</title>
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/css/Login-Form-Clean.css">
    <link rel="stylesheet" href="assets/css/styles.css">
	<link rel="shortcut icon" href="assets/img/favicon.ico" />
</head>

<body>
    <div class="login-clean">
        <form action="Pagina" method="post" style="background-color:#00a3dd;">
            <input type="hidden" name="page" value="Autentica">
            <div class="illustration"><img src="assets/img/logo.png" style="margin-bottom:20px;"></div>
            <div class="form-group"><input class="form-control" type="number" name="codigo" placeholder="Siape" autofocus=""></div>
            <div class="form-group"><input class="form-control" type="password" name="senha" placeholder="Senha"></div>
            <div class="form-group"><input class="btn btn-danger btn-block" type="submit" value="Entrar"></div>
        </form>
    </div>
    <script src="assets/js/jquery.min.js"></script>
    <script src="assets/bootstrap/js/bootstrap.min.js"></script>
</body>

</html>