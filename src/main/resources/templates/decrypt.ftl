<!DOCTYPE html>

<html lang="en">
<head>
    <title>jQuery pagination</title>
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
</head>
<body>

<div class="navbar navbar-inverse">
    <ul class="nav navbar-nav">
        <li><a href="/encrypt">Encrypt</a></li>
        <li><a href="/decrypt">Decrypt</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
        <li><a href="/options">Options</a></li>
        <li><a href="http://drill.apache.org/docs/">Documentation</a>
        </li>
    </ul>
</div>
<form class="form-inline" role="form" action="/decrypt" method="POST">
    <div class="form-group">
        <label for="encryptedValue">Decrypted Value</label>
        <input name="encryptedValue" type="text" class="form-control" id="encryptedValue" placeholder="encrypted value">
    </div>
    <button type="submit" class="btn btn-default">Submit</button>
</form>
<#if decryptedValue??>
Result: ${decryptedValue}
<#else>
Init
</#if>

</body>

</html>
