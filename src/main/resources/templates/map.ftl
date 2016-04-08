<!DOCTYPE html>

<html lang="en">

<body>
	Date: ${time?date}
	<br>
	Time: ${time?time}
	<br>
	Message: ${message}
	<br>
	Text:
	<#--<#list list as s>-->
    <#--<p>-->
		<#--<a href="#">${s}</a>-->
	<#--</p>-->
	<#--</#list>-->
	<#list map?keys as key>
	<p>${key} = ${map[key]}</p>
	</#list>
</body>

</html>
