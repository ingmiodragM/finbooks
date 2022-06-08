<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<%@page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Create Location</title>
</head>
<body>

<form action="updateDnevnik" method="post">
<pre>
Id: <input type="text" name="RBr" value="${dnevnik.RBr}" />
Konto Duguje: <input type="text" name="konto_dug"value="${dnevnik.konto_dug}"/>
Konto Potrazuje: <input type="text" name="konto_pot"value="${dnevnik.konto_pot}"/>
BrNaloga: <input type="number" name="br_naloga"value="${dnevnik.br_naloga}"/>
Opis <input type="text" name="opis"value="${dnevnik.opis}"/>
Sadrzaj <input type="text" name="sadrzaj"value="${dnevnik.sadrzaj}"/>
Duguje <input type="number" name="duguje"value="${dnevnik.duguje}"/>
Potrazuje <input type="number" name="Potrazuje"value="${dnevnik.potrazuje}"/>
Konto <input type="text" name="konto"value="${dnevnik.konto}"/>
Datum<input type="text"  name="datum"value=<fmt:formatDate value="${dnevnik.datum}" pattern="dd-MM-yyyy"/>>
DatumValute<input type="text"  name="datum_valute"value=<fmt:formatDate value="${dnevnik.datum_valute}" pattern="dd-MM-yyyy"/>>
<input type="submit" value="save"/>
</pre>
</form>

</body>
</html>