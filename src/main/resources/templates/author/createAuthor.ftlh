<#import "/spring.ftl" as spring />
<!DOCTYPE html>
<html lang="en">
<head>
    <#include "../partials/head.ftlh">

    <title>Authors Create</title>
</head>

<body>
<#include "../partials/navbar.ftlh">
<div class="container-fluid">
    <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
            <#include "../partials/sidebar.ftlh">
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <form class="form-horizontal" action="/authors" method="POST">
                <h1 class="page-header">Create Author</h1>

                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <div class="form-group">
                        <label for="firstName">Όνομα</label>
                        <@spring.formInput path="authorForm.firstName" attributes="class='form-control'" />
                        <@spring.showErrors "<br>"/>
                    </div>
                    <div class="form-group">
                        <label for="lastName">Έπίθετο</label>
                        <@spring.formInput path="authorForm.lastName" attributes="class='form-control'"/>
                        <@spring.showErrors "<br>"/>
                    </div>
                </div>

                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 pull-right">
                    <button type="submit" class="btn btn-success">Αποθήκευση</button>
                    <button type="reset" id="btn-clear" class="btn btn-danger">Καθαρισμός</button>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
