package jp.co.axiz.app.action;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.StringLengthFieldValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;

import db.DbAccessor;
import db.UserInfo;

/*@Results({ @Result(name = "success", location = "/menu.jsp"),
 @Result(name = "input", location = "/login.jsp") })
 */
public class LoginAction extends ActionSupport {
	private String userId;
	private String pass;
	private ArrayList<UserInfo> list;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}



	/*
	 * @Override public void validate() { if (userId == null || userId.length()
	 * == 0) { addActionError("ユーザーIDは入力必修です。"); } else if (userId.length()>10)
	 * { addActionError("ユーザーIDは10文字までです。"); }
	 *
	 * if (pass == null || pass.length() == 0) {
	 * addActionError("パスワードは入力必修です。"); } else if (pass.length()>15) {
	 * addActionError("パスワードは10文字までです。"); } }
	 */

	@Validations(requiredStrings = {
			@RequiredStringValidator(fieldName = "userId", message = "ユーザIDは入力必修です。"),
			@RequiredStringValidator(fieldName = "pass", message = "パスワードは入力必修です。") }, stringLengthFields = { @StringLengthFieldValidator(fieldName = "pass", maxLength = "15", minLength = "0", message = "パスワードは15文字以内です。"), })
	public String execute() throws Exception {
		// ビジネスロジックの処理

		UserInfo userinfo = new UserInfo();
		userinfo.setUserId(userId);
		userinfo.setPassword(pass);

		DbAccessor db = new DbAccessor();
		boolean handan;
		handan = db.canLogin(userinfo);

		if (handan) {

			list = db.getUserInfo();
			return "ok";
		} else {
			return "input";
		}
	}


	/*
	 * @Action("start") public String doLogin() throws Exception { return
	 * ("success"); }
	 */
}