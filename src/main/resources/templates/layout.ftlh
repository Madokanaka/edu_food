<#import "spring.ftl" as spring>
<#macro layout>
    <!doctype html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport"
              content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
              crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
                crossorigin="anonymous"></script>
        <script src="../static/scripts/main.js"></script>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
        <title>JavaShareHub</title>
    </head>
    <body>

    <style>
        .navbar {
            top: 0;
        }
    </style>

    <#assign known = SPRING_SECURITY_CONTEXT?? >
    <#if known>
        <#assign
        userPr = SPRING_SECURITY_CONTEXT.authentication.principal
        name = userPr.getUsername()
        >
    </#if>

    <nav class="navbar navbar-expand-lg navbar-dark bg-dark mb-5">
        <div class="container-fluid">
            <a class="navbar-brand" href="/restaurants">EduFood</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                    data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                    aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="nav-link" href="/restaurants">Рестораны</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/cart">
                            Корзина
                            <#if totalItems?? && totalItems gt 0>
                                <span class="badge bg-primary ms-1">${totalItems}</span>
                            </#if>
                        </a>
                    </li>
                </ul>

                <#if userPr??>
                    <a href="/profile" class="text-light m-2 m-sm-0">
                        Hello, ${name}:
                    </a>
                    <#if _csrf??>
                        <form action="/logout" method="post">
                            <input type="hidden" name="${(_csrf.parameterName)!'csrf'}"
                                   value="${(_csrf.token)!'--no-token--'}"/>
                            <button type="submit" class="btn btn-outline-info m-2"
                                    id="logout">Logout
                            </button>
                        </form>
                    <#else>
                        <a href="/logout" class="btn btn-outline-info m-2"
                           id="logout">Logout</a>
                    </#if>
                <#else>
                    <a href="/auth/login"
                       class="btn btn-outline-info m-2">Login</a>
                    <a href="/auth/register"
                       class="btn btn-outline-info m-2">Register</a>
                </#if>
            </div>
        </div>
    </nav>

    <div class="container min-vh-100 align-items-center justify-content-center mt-5">
        <#nested spring>
    </div>

    </body>
    </html>
</#macro>