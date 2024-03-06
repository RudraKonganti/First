<%@ taglib prefix="c" uri="http://www.springframework.org/tags/form" %>
<h3>CONFIRM YOUR RECIVER ACCOUNT HOLDER NAME: ${bank1.name}</h3>
<body>
<c:form modelAttribute="bank" action="/trs">
<c:hidden path="Accountnumber"/><p></p>
<c:hidden path="Name"/><p></p>
<c:hidden path="password"/><p></p>
<c:hidden path="targetaccount"/><p></p>
<c:hidden path="Amount"/><p></p>
<input type="submit" value="YES">&nbsp;&nbsp;&nbsp;&nbsp;
</c:form>
<a href="/home"><button>NO</button></a>

</body>
</html>

