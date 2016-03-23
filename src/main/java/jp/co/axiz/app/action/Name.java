package jp.co.axiz.app.action;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.StringLengthFieldValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;

import db.DbAccessor1;
import db.UserInfo;

/*@Results({ @Result(name = "success", location = "/menu.jsp"),
 @Result(name = "input", location = "/login.jsp") })
 */
public class Name extends ActionSupport {
	private String Name;
	private String pass;
	private ArrayList<UserInfo> list;

	public String getUserId() {
		return Name;
	}

	public void setUserId(String Name) {
		this.Name = Name;
	}

	public void setList(ArrayList<UserInfo> list) {
		this.list = list;
	}

	public ArrayList<UserInfo> getList() {
		return list;
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
		userinfo.setUserName(Name);

		DbAccessor1 db = new DbAccessor1();
		boolean handan;
		handan = db.name(userinfo);

		if (handan) {
			list = db.getName();
			return "ok";
		} else {
			return "ng";
		}
	}


	/*
	 * @Action("start") public String doLogin() throws Exception { return
	 * ("success"); }
	 */
}