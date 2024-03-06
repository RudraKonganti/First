<%@ taglib prefix="c" uri="http://www.springframework.org/tags/form"%>
<html>
<body>
<h1>Fill The Details</h1>
<c:form modelAttribute="bank" action="/register">
AccountNumber:<c:input path="Accountnumber"/><br><br>
Name:<c:input path="Name"/><br><br>
Password:<c:password path="password"/><br><br>
ConformPassword:<c:password path="conformpassword"/><br><br>
Amount:<c:input path="Amount"/><br><br>
Address:<c:input path="Address"/><br><br>
MobileNumber:<c:input path="mobilenumber"/><br><br>
<input type="submit" value="Add">
</c:form>
</body>
</html>