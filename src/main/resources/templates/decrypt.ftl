<!DOCTYPE html>

<html lang="en">
<head>
    <title>Decryption</title>
<#include "helper/headImport.ftl">
</head>
<body>
<#include "helper/navbar.ftl">

<div class="container-fluid">
<#if decryptedValue??>
    <#include "helper/resultTable.ftl">
<#else>
    <form class="form-inline" role="form" action="/decrypt" method="POST">
        <div class="form-group">
            <label for="encryptedValue">Decrypt</label>
            <input name="encryptedValue" type="text" class="form-control" id="encryptedValue"
                   placeholder="Example: aXlXMEUMlzY=">
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
    </form>
</#if>
    <div>
</body>

</html>
