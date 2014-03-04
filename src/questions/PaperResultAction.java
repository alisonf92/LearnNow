package questions;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class PaperResultAction extends ActionSupport implements
		ModelDriven<PaperResultModel>, SessionAware {
	ResultAction obFinalResultDAO = new ResultAction();
	PaperResultModel obPaperSubmitModel;
	Map session;
	String loginUser, subject;
	String questionNumber = null;
	String selectedAns = null;
	ActionContext context = ActionContext.getContext();
	HttpServletRequest request = (HttpServletRequest) context
			.get(ServletActionContext.HTTP_REQUEST);

	@Override
	public String execute() throws Exception {
		loginUser = (String) session.get("username");
		subject = (String) session.get("subject");
		String[] totalQues = request.getParameterValues("totalQues");
		for (int i = 1; i <= totalQues.length; i++) {
			questionNumber = request.getParameter("quesNum['" + i + "']");
			selectedAns = request.getParameter("answer['" + i + "']");
			obPaperSubmitModel.setQuesno(questionNumber);
			obPaperSubmitModel.setAnswer(selectedAns);
			obPaperSubmitModel.setUsername(loginUser);
			obPaperSubmitModel.setSubject(subject);
			obFinalResultDAO.selectedAns(obPaperSubmitModel, subject);
		}
		FinalResultModel obFinalResultModel = new FinalResultModel();
		obFinalResultModel = obFinalResultDAO.finalResult(obPaperSubmitModel,
				loginUser, subject);
		if (obFinalResultModel.getCount() == 0) {
			return ERROR;
		} else {
			session.put("FinalResultModel", obFinalResultModel);
			return SUCCESS;
		}
	}

	@Override
	public PaperResultModel getModel() {
		// TODO Auto-generated method stub
		obPaperSubmitModel = new PaperResultModel();
		return obPaperSubmitModel;
	}

	public Map getSession() {
		return session;
	}

	public void setSession(Map session) {
		this.session = session;
	}
}
