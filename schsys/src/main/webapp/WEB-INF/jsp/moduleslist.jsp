<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

<h1>Modules List</h1>
<table border="2" width="70%" cellpadding="2">
    <tr><th>ID</th><th>Name</th></tr>
            <c:forEach var="modules" items="${modList}"> 
        <tr>
            <td>${modules.modId}</td>
            <td>${modules.modName}</td>
        </tr>
    </c:forEach>
</table>
<br/>