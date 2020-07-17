<%-- 
    Document   : moduleform
    Created on : Jul 17, 2020, 2:20:47 AM
    Author     : Naim
--%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

<h1>Add Module to Student</h1>
<form:form method="POST" action="/schsys/savemoduletostudent/${classStuId}">  
    <table>  
        <tr>  
            <td>Module : </td> 
            <td><form:input path="classModName"  /></td>
        </tr>
        <tr>  
            <td> </td>  
            <td><input type="submit" value="Save" /></td>  
        </tr>  
    </table>  
</form:form>  
