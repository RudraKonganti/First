<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<table border="1">
<tr>
 <th>Account No</th>
 <th>Name</th>
 <th>Amount</th>
</tr>

<tr>
<td>${bank.accountnumber}</td>
<td>${bank.name}</td>
<td>${bank.amount}</td>
</tr>
</table>