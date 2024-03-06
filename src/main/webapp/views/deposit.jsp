<%@ taglib prefix="c" uri="http://www.springframework.org/tags/form"%>
<html>
<body>
<fieldset>
<h1>Deposit FORM</h1>
<c:form modelAttribute="bank" action="/dep">
AccountNo:<c:input path="Accountnumber"/><p></p>
Name:<c:input path="Name"/><p></p>
Password<c:password path="password"/><p></p>
Amount<c:input path="Amount"/><p></p>
<input type="submit" value="submit"><p></p>
<center>
<a href="/home">Home</a>
</center>
</fieldset>
</c:form>
</body>
</html>