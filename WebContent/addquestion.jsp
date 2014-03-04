<%@taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
<title>Qustion Submission Page
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"></title>
<sx:head />
<h3>Question Form ::-</h3>
<s:form action="addquesprocess.action">
	<s:select list="{'C','C++','JAVA','PHP'}" name="language"
		label="Language" />
	<s:textarea name="question" label="Question" />
	<s:textfield name="ans1" label="Answer1" />
	<s:textfield name="ans2" label="Answer2" />
	<s:textfield name="ans3" label="Answer3" />
	<s:textfield name="ans4" label="Answer4" />
	<s:textfield name="rightAns" label="Right Answer" />
	<s:submit label="Add Question" />
</s:form>
</body>
</html>