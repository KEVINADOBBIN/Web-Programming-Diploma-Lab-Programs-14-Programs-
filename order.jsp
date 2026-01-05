<!DOCTYPE html>
<html>
<head>
    <title>Order Form</title>
</head>
<body>

<form action="result.jsp" method="get">

<h3>Enter the Data</h3>

<table border="1">
<tr>
    <td>User Name:</td>
    <td><input type="text" name="UserName"></td>
</tr>

<tr>
    <td><input type="checkbox" name="option1">Four 100 Watt bulbs (Rs.20)</td>
    <td><input type="text" name="val1" size="2"></td>
</tr>

<tr>
    <td><input type="checkbox" name="option2">Eight 100 Watt bulbs (Rs.40)</td>
    <td><input type="text" name="val2" size="2"></td>
</tr>

<tr>
    <td><input type="checkbox" name="option3">Four long life bulbs (Rs.30)</td>
    <td><input type="text" name="val3" size="2"></td>
</tr>

<tr>
    <td><input type="checkbox" name="option4">Eight long life bulbs (Rs.70)</td>
    <td><input type="text" name="val4" size="2"></td>
</tr>

<tr>
    <td><input type="submit" value="Submit"></td>
</tr>
</table>

</form>
</body>
</html>
