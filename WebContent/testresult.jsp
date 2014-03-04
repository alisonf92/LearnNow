<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="questions.FinalResultModel"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%
	FinalResultModel result = (FinalResultModel) session.getAttribute("FinalResultModel");
	ArrayList rightQuesAns = result.getRightQuesNans();
	Iterator obIter = rightQuesAns.iterator();
%>
<html>
<head>
<title>Final Result</title>
</head>
<body>
<h2></h2>
<hr />
<h3>Paper result</h3>

<table>
	<%
		while (obIter.hasNext()) {
	%>
	<tr>
		<td style="color: gray;">Ques :</td>
		<td><%=obIter.next()%></td>
	</tr>
	<tr>
		<td style="color: green;">Right :</td>
		<td><%=obIter.next()%></td>
	</tr>
	<%
		}
	%>
</table>
<table>
	<tr>
		<td style="color: green;">Result Marks :</td>
		<td><%=result.getCount()%><br />
		<tr>
			<td style="color: gray;">Number of wrong answer :</td>
			<td><%=result.getWrongAns()%><br />
			<tr>
				<td style="color: green;">Number of right answer :</td>
				<td><%=result.getRightAns()%>
</table>
</body>
</html>