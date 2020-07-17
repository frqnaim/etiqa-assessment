<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

<h1>Students List</h1>
<table border="2" width="70%" cellpadding="2">
    <tr><th>Id</th><th>Name</th><th>Age</th><th>gender</th><th>Email</th><th>View</th><th>Edit</th><th>Delete</th></tr>
            <c:forEach var="std" items="${stdList}"> 
        <tr>
            <td>${std.stuId}</td>
            <td>${std.stuName}</td>
            <td>${std.stuAge}</td>
            <td>${std.stuGender}</td>
            <td>${std.stuEmail}</td>
            <td><a href="viewmodules/${std.stuId}">View</a></td>
            <td><a href="editstd/${std.stuId}">Edit</a></td>
            <td><a href="deletestd/${std.stuId}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
<br/>
<a href="studentform">Add Student</a>