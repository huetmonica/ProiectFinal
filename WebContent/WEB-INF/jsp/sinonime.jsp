<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  
    pageEncoding="ISO-8859-1"%>  
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<html>
<head>
    <title>Spring MVC Form Handling</title>
</head>
<body>

<h2>Sinonime Information</h2>


<form:form method="POST" action="/ProiectFinal/adaugaS">
<table> 
 <tr>
        <td><form:label path="cuvant">Cuvant</form:label></td>
        <td><form:input path="cuvant" /></td>
 </tr>
 <tr>
        <td><form:label path="cuvant">Sinonim1</form:label></td>
        <td><form:input path="cuvant" /></td>
 </tr>
 <tr>
        <td><form:label path="cuvant">Sinonim2</form:label></td>
        <td><form:input path="cuvant" /></td>
 </tr>
  <tr>
        <td><form:label path="cuvant">Sinonim3</form:label></td>
        <td><form:input path="cuvant" /></td>
 </tr>

 <td colspan="2">
    <input type="submit" value="AdaugaS"/>
   </td>
 </tr>
    </table> 
</form:form>


<form:form method="POST" action="/ProiectFinal/SalvareCsv">
<table> 
 <td colspan="2">
    <input type="submit" value="SalvareCsv"/>
   </td>
   </tr> 
    </table> 
</form:form>
<form:form method="POST" action="/ProiectFinal/SalvareJson">
<table> 
 <td colspan="2">
    <input type="submit" value="SalvareJson"/>
   </td>
   </tr> 
    </table> 
</form:form>

<form:form method="POST" action="/ProiectFinal/VizualizareS">
<table> 
 <td colspan="2">
    <input type="submit" value="VizualizareS"/>
   </td>
   </tr> 
    </table> 
</form:form>
<form:form method="POST" action="/ProiectFinal/consistenta">
<table> 
 <tr>
        <td><form:label path="cuvant">Cuvant</form:label></td>
        <td><form:input path="cuvant" /></td>
 </tr>
 <tr>
        <td><form:label path="cuvant">Sinonim1</form:label></td>
        <td><form:input path="cuvant" /></td>
 </tr>
 <tr>
        <td><form:label path="cuvant">Sinonim2</form:label></td>
        <td><form:input path="cuvant" /></td>
 </tr>
  <tr>
        <td><form:label path="cuvant">Sinonim3</form:label></td>
        <td><form:input path="cuvant" /></td>
 </tr>

 <td colspan="2">
    <input type="submit" value="Verifica Consistenta"/>
   </td>
 </tr>
    </table> 
</form:form>

</body>
</html>