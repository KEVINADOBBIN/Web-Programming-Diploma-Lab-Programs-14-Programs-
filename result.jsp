<!DOCTYPE html>
<html>
<body>

<h2>DISPLAYING FORM DATA</h2>

<b>User Name:</b> <%= request.getParameter("UserName") %>
<br/><br/>

<%
int item1 = 0, item2 = 0, item3 = 0, item4 = 0;
int price1 = 20, price2 = 40, price3 = 30, price4 = 70;

if (request.getParameter("option1") != null)
    item1 = Integer.parseInt(request.getParameter("val1"));

if (request.getParameter("option2") != null)
    item2 = Integer.parseInt(request.getParameter("val2"));

if (request.getParameter("option3") != null)
    item3 = Integer.parseInt(request.getParameter("val3"));

if (request.getParameter("option4") != null)
    item4 = Integer.parseInt(request.getParameter("val4"));

int total1 = item1 * price1;
int total2 = item2 * price2;
int total3 = item3 * price3;
int total4 = item4 * price4;

double total = total1 + total2 + total3 + total4;
total = total + (total * 2.0 / 100);   // 2% sales tax
%>

<h3>You have ordered following items</h3>

<table border="1">
<tr>
    <th>Qty</th>
    <th>Price</th>
    <th>Total</th>
</tr>

<tr>
    <td><%=item1%></td>
    <td><%=price1%></td>
    <td><%=total1%></td>
</tr>

<tr>
    <td><%=item2%></td>
    <td><%=price2%></td>
    <td><%=total2%></td>
</tr>

<tr>
    <td><%=item3%></td>
    <td><%=price3%></td>
    <td><%=total3%></td>
</tr>

<tr>
    <td><%=item4%></td>
    <td><%=price4%></td>
    <td><%=total4%></td>
</tr>
</table>

<br/>
<i>Total Bill (Including 2% Sales Tax): <b><%=total%></b></i>

</body>
</html>
