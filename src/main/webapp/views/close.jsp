<%@ taglib prefix="c" uri="http://www.springframework.org/tags/form"%>
<html>
<body>
<h1>CLOSE ACCOUNT</h1>
<c:form modelAttribute="bank" action="/delete">
AccountNo:<c:input path="Accountnumber"/><p></p>
Name:<c:input path="Name"/><p></p>
Password<c:password path="password"/><p></p>
<input type="submit" value="submit"><p></p>
<center>
<a href="/home">Home</a>
</center>
</c:form>
</body>
</html>