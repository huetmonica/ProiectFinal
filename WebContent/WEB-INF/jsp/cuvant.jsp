<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  
    pageEncoding="ISO-8859-1"%>  

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<html>
<head>
    <title>Spring MVC Form Handling</title>
</head>
<body>

<h2>Cuvant Information</h2>


<form:form method="POST" action="/ProiectFinal/adaugaC">
<table> 
 <tr>
        <td><form:label path="cuvant">Cuvant</form:label></td>
        <td><form:input path="cuvant" /></td>
 </tr>

 <td colspan="2">
    <input type="submit" value="AdaugaCuv"/>
   </td>
    </tr>
    </table> 
</form:form>


 <form:form method="POST" action="/ProiectFinal/VizualizareC"> 
 <td colspan="2">
    <input type="submit" value="VizualizareCuvinte"/>
   </td>
   </form:form>
    <form:form method="POST" action="/ProiectFinal/cauta"> 
 <table> 
 <tr>
        <td><form:label path="cuvant">Cuvant cautat</form:label></td>
        <td><form:input path="cuvant" /></td>
 </tr>

 <td colspan="2">
    <input type="submit" value="CautaCuvant"/>
   </td>
 </tr>
    </table> 
   </form:form>
</body>
</html>