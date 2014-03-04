<%@taglib uri="/struts-tags" prefix="s"%>
<%
if("".equals(session.getAttribute("username"))){
%>
<jsp:forward page="signin.jsp"/>
<%	
}else{
%>
<html>
<head>
<title></title>
<s:head />
</head>
<body>
<hr />
<h3>Please select a Subject</h3>
<s:actionerror />
<s:form action="questionPaper">
	<s:select list="{'C','C++','JAVA','PHP'}" name="subject"
		headerKey="null" headerValue="Select Subject"></s:select>
	<s:submit key="Paper Subject" />
</s:form>
<%
}
%>
</body>
</html>