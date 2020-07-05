<!DOCTYPE html>
<html lang="en">
    <head>
        <#include "partials/head.ftlh">
        <title>Home</title>
    </head>

    <body>
    <#include "partials/navbar.ftlh">

        <div class="container-fluid">
            <div class="row">
                <div class="col-sm-3 col-md-2 sidebar">
                    <#include "partials/sidebar.ftlh">
                </div>
                <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
                    Hello ${username}!!

                    <#if _authorities?seq_contains("ROLE_ADMIN")>
                        ${username} you are an <a href="/admin/users/">Admin</a>
                    </#if>

                </div>
            </div>
        </div>

        <#include "partials/scripts.ftlh">

    </body>
</html>
