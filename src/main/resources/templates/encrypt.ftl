<!DOCTYPE html>

<html lang="en">
<head>
    <title>Encryption</title>
<#include "helper/headImport.ftl">
</head>
<body>
<#include "helper/navbar.ftl">

<div class="container-fluid">
<#if encryptedValue??>
    <#include "helper/resultTable.ftl">
<#else>
    <form class="form-inline" role="form" action="/encrypt" method="POST">
        <div class="form-group">
            <label for="decryptedValue">Encrypt</label>
            <input name="decryptedValue" type="text" class="form-control" id="decryptedValue"
                   placeholder="Example: temp123">
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
    </form>
</#if>
    <div>
</body>

</html>
