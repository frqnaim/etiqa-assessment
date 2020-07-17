<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

<h1>Add New Student</h1>
<form:form method="post" action="savestudent">  
    <table >  
        <tr>  
            <td>Name : </td> 
            <td><form:input path="stuName"  /></td>
        </tr>  
        <tr>  
            <td>Age :</td>  
            <td><form:input path="stuAge" /></td>
        </tr> 
        <tr>  
            <td>Gender :</td>  
            <td><form:input path="stuGender" /></td>
        </tr>
        <tr>  
            <td>Email :</td>  
            <td><form:input path="stuEmail" /></td>
        </tr> 
        <tr>  
            <td> </td>  
            <td><input type="submit" value="Save" /></td>  
        </tr>  
    </table>  
</form:form>  
