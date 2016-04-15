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
        <li><a href="/query">Query</a></li>
        <li><a href="/profiles">Profiles</a></li>
        <li><a href="/storage">Storage</a></li>
        <li><a href="/metrics">Metrics</a></li>
        <li><a href="/threads">Threads</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
        <li><a href="/options">Options</a></li>
        <li><a href="http://drill.apache.org/docs/">Documentation</a>
        </li>
    </ul>
</div>
<h3>FileName.log4</h3>

<div class="table-responsive">
    <table class="table table-hover">
        <tbody>
        <tr>
            <td align="left" style="border:none;">
                <form class="form-inline" role="form" action="/pagination" method="POST">
                    <label for="sel1">Display rows</label>
                <#if showRows??>
                <#else>
                    <#assign showRows = "All">
                </#if>
                    <select class="form-control" name="showRows">
                        <option <#if showRows == "1">selected</#if>>1</option>
                        <option <#if showRows == "2">selected</#if>>2</option>
                        <option <#if showRows == "3">selected</#if>>3</option>
                        <option <#if showRows == "10">selected</#if>>10</option>
                        <option <#if showRows == "All">selected</#if>>All</option>
                    </select>
                    <button type="submit" class="btn btn-default">Update</button>
                </form>
            </td>
            <td align="right" style="border:none;"><a
                    href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js">Download Full Log</a></td>
        </tr>
        </tbody>
    </table>
</div>

<p>Date: ${time?date}</p>
<p>Time: ${time?time}</p>
<p>Message: ${message}</p>
<p>Number of messages  <span class="label <#if showRows == "1">label-success<#else>label-danger</#if>">${showRows}</span></p>

    <pre id='content'>
    <#list map?keys as key>
        <label>${key} = ${map[key]}</label>
    </#list>
    </pre>

</body>

</html>
