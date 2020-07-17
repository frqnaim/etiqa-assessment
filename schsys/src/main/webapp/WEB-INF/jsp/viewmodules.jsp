<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

<h1>Class List</h1>
<table border="2" width="70%" cellpadding="2">
    <tr><th>Name</th><th>Subject</th></tr>
            <c:forEach var="cls" items="${clsList}"> 
        <tr>
            <td>${cls.classStuName}</td>
            <td>${cls.classModName}</td>
        </tr>
    </c:forEach>
</table>
<br/>
<a href="/schsys/moduleform/${stuId}">Add Module</a>