<%@taglib uri="/struts-tags" prefix="s"%>
<%@page import="java.util.*"%>
<%@page import="questions.Question"%>
<%@page import="questions.QuestionAction"%>
<%	String username = (String) session.getAttribute("username");
	String[] answer;
	String[] quesNum;
	int i = 1;
	ArrayList questpaper = (ArrayList) request.getAttribute("questPaper");
	Iterator iter = questpaper.iterator();
	Question paperQues = new Question();

	if("".equals(session.getAttribute("username"))){
		%>
			<jsp:forward page="signin.jsp"/>
		<%
	}
	else{
		
%>
<html>
<head>
<title>Question Paper</title>
 <script src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</head>
<body>
<h2></h2>
<hr />
<h3 style="color: gray">Question Paper</h3>
<s:form action='ResultAction' method="post">
	<%
		while (iter.hasNext()) {
	%>
	<s:bean name="questions.Test" var="paper">
		<s:param name="quesno"><%=iter.next()%></s:param>
		<s:param name="question"><%=iter.next()%></s:param>
		<s:param name="ans1"><%=iter.next()%>,</s:param>
		<s:param name="ans2"><%=iter.next()%></s:param>
		<s:param name="ans3"><%=iter.next()%></s:param>
		<s:param name="ans4"><%=iter.next()%></s:param>
		<s:param name="radioId"><%=i%></s:param>
	</s:bean>
	<s:hidden value="%{#paper.quesno}" name="totalQues" />
	<s:hidden value="%{#paper.quesno}" name="quesNum['%{#paper.radioId}']" />
	<s:label value="%{#paper.radioId}..%{#paper.question}" />
	<s:radio list="%{#paper.ans1}" name="answer['%{#paper.radioId}']"></s:radio>
	<s:radio list="%{#paper.ans2}" name="answer['%{#paper.radioId}']"></s:radio>
	<s:radio list="%{#paper.ans3}" name="answer['%{#paper.radioId}']"></s:radio>
	<s:radio list="%{#paper.ans4}" name="answer['%{#paper.radioId}']"></s:radio>
	<%
		i = i + 1;
			}
	%>
	<s:submit></s:submit>
</s:form>
	
	
<%
	}
%>
</body>
</html>