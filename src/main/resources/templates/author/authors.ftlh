<!DOCTYPE html>
<html lang="en">
    <head>
        <#include "../partials/head.ftlh">

        <title>Authors</title>
    </head>

    <body>

        <#include "../partials/navbar.ftlh">
        <div class="container-fluid">
            <div class="row">
                <div class="col-sm-3 col-md-2 sidebar">
                <#include "../partials/sidebar.ftlh">
                </div>
                <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
                    <#if authors??>
                        <h1 class="page-header">Authors</h1>

                        <table class="table table-striped">
                            <thead>
                                <tr>
                                    <th>First Name</th>
                                    <th>Last Name</th>
                                    <th></th>
                                </tr>
                            </thead>

                            <tbody>
                                <#list authors as author>
                                    <tr>
                                        <td> ${author.firstName}</td>
                                        <td> ${author.lastName}</td>
                                        <td class="text-right">
                                            <a class="btn" href="/authors/${author.id}/delete">Delete</a>
                                        </td>
                                    </tr>
                                </#list>
                            </tbody>
                        </table>

                        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                            <a class="btn pull-right" href="/authors/create">Δημιουργία Νέου</a>
                        </div>
                    <#else>
                        <p>Δεν βρέθηκαν books</p>
                    </#if>
                </div>
            </div>
        </div>
    </body>
</html>
