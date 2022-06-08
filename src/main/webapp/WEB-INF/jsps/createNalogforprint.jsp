<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Kreiraj Nalog</title>
</head>
<body>

<form action="print" method="post">
<pre>
Id: <input type="number" name="RBr"/>
Konto Duguje: <input type="text" name="konto_dug"/>
Konto Potrazuje: <input type="text" name="konto_pot"/>
BrNaloga: <input type="text" name="br_naloga"/>
Opis <input type="text" name="Opis"/>
Sadrzaj <input type="text" name="sadrzaj"/>
Duguje <input type="text" name="duguje"/>
Potrazuje <input type="text" name="potrazuje"/>
Konto <input type="text" name="konto"/>
Datum<input type="text"  name="datum"value="01-01-2022"/>
DatumValute<input type="text"  name="datum_valute"value="01-01-2022"/>

<input type="submit" value="save"/>
</pre>
</form>
${msg}
<a href="showUpdate?RBr=2">prvi</a>
${msg}
<a href="displayDnevniks">View All</a>
</body>
</html>