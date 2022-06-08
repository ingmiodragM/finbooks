<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<%@page isELIgnored="false"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>Nalozi:</h2>
<table>
<tr>
<th>RBr</th>
<th>KontoDug</th>
<th>KontoPot</th>
<th>Datum</th>
<th>DatumValute</th>
<th>BrNaloga</th>
<th>Opis</th>
<th>Sadrzaj</th>
<th>Duguje</th>
<th>Potrazuje</th>
<th>Konto</th>
</tr>

<c:forEach items="${dnevniks}" var="dnevnik">
<tr>
<td>${dnevnik.RBr}</td>
<td>${dnevnik.konto_dug}</td>
<td>${dnevnik.konto_pot}</td>
<td><fmt:formatDate pattern="dd-MM-yyyy" value="${dnevnik.datum}"/></td>
<td><fmt:formatDate pattern="dd-MM-yyyy" value="${dnevnik.datum_valute}"/></td>
<td>${dnevnik.br_naloga}</td>
<td>${dnevnik.opis}</td>
<td>${dnevnik.sadrzaj}</td>
<td>${dnevnik.duguje}</td>
<td>${dnevnik.potrazuje}</td>
<td>${dnevnik.konto}</td>
<td><a href="deleteDnevnik?RBr=${dnevnik.RBr}">delete</a></td>
<td><a href="showUpdate?RBr=${dnevnik.RBr}">edit</a></td>
</tr>
</c:forEach>
</table>
<a href="showCreate">Add Location</a>
</body>
</html>