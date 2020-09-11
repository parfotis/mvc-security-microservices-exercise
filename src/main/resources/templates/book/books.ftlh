<#assign security=JspTaglibs["http://www.springframework.org/security/tags"]/>
<!DOCTYPE html>
<html lang="en">
    <head>
        <#include "../partials/head.ftlh">

        <title>Books</title>
    </head>

    <body>

        <#include "../partials/navbar.ftlh">
        <div class="container-fluid">
            <div class="row">
                <div class="col-sm-3 col-md-2 sidebar">
                <#include "../partials/sidebar.ftlh">
                </div>
                <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
                    <#if books??>
                        <h1 class="page-header">Books</h1>

                        <table class="table table-striped">
                            <thead>
                                <tr>
                                    <th>Title</th>
                                    <th>Year</th>
                                    <@security.authorize access="hasRole('ROLE_ADMIN')">
                                    <th></th>
                                    <th></th>
                                    </@security.authorize>
                                </tr>
                            </thead>

                            <tbody>
                                <#list books as book>
                                    <tr>
                                        <td> ${book.title}</td>
                                        <td> ${book.year}</td>
                                        <@security.authorize access="hasRole('ROLE_ADMIN')">
                                        <td class="text-right">
                                            <a class="btn" href="/books/${book.id}/edit">Edit</a>
                                        </td>
                                        <td class="text-right">
                                            <a class="btn" href="/books/${book.id}/delete">Delete</a>
                                        </td>
                                        </@security.authorize>
                                    </tr>
                                </#list>
                            </tbody>
                        </table>

                        <@security.authorize access="hasRole('ROLE_ADMIN')">
                        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                            <a class="btn pull-right" href="/books/create">Δημιουργεία Νέου</a>
                        </div>
                        </@security.authorize>
                    <#else>
                        <p>Δεν βρέθηκαν books</p>
                    </#if>
                </div>
            </div>
        </div>
    </body>
</html>
