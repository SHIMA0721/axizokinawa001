package jp.co.axiz.app.action;

import java.util.ArrayList;
import java.util.Calendar;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.StringLengthFieldValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;

import db.DbAccessor_Kojin;
import db.UserInfoKojin;

/*@Results({ @Result(name = "success", location = "/menu.jsp"),
 @Result(name = "input", location = "/login.jsp") })
 */
public class LogAction extends ActionSupport {
	private String User_Id;
	private String Pass;
	private String Part_Name;
	private int Month;
	private int Day;
	private int Start_Time;
	private int End_Time;
	private int Jikyu;
	private int Kotuhi;
	private int Yakin;
	private int Soutyo;
	private int Goal_Money;
	private int Goal_Time;
	private int Goal_Day;
	private int ProcessStatus;
	private int Work_Time;
	private String Keikoku;
	private ArrayList<UserInfoKojin> Work_Zenken;
	private ArrayList<UserInfoKojin> list;
	private int Goukei_Money;
	private String Sift_Name;
	private int Work_Month;
	private int Work_Day;
	private int tax_view_status;
	private int month_total_view_status;
	private int goal_view_status;
	private String Arubaito_name;
	private int Shift_No;
	private int Part_No;
	boolean handan;

	public int getShift_No() {
		return Shift_No;
	}

	public void setShift_No(int shift_No) {
		Shift_No = shift_No;
	}

	public int getPart_No() {
		return Part_No;
	}

	public void setPart_No(int part_No) {
		Part_No = part_No;
	}

	public String getArubaito_name() {
		return Arubaito_name;
	}

	public void setArubaito_name(String arubaito_name) {
		Arubaito_name = arubaito_name;
	}

	public int getTax_view_status() {
		return tax_view_status;
	}

	public void setTax_view_status(int tax_view_status) {
		this.tax_view_status = tax_view_status;
	}

	public int getMonth_total_view_status() {
		return month_total_view_status;
	}

	public void setMonth_total_view_status(int month_total_view_status) {
		this.month_total_view_status = month_total_view_status;
	}

	public int getGoal_view_status() {
		return goal_view_status;
	}

	public void setGoal_view_status(int goal_view_status) {
		this.goal_view_status = goal_view_status;
	}

	public int getWork_Day() {
		return Work_Day;
	}

	public void setWork_Day(int work_Day) {
		Work_Day = work_Day;
	}

	UserInfoKojin userinfokojin = new UserInfoKojin();
	Calculation calculation = new Calculation();
	DbAccessor_Kojin db = new DbAccessor_Kojin();

	public int getWork_Month() {
		return Work_Month;
	}

	public void setWork_Month(int work_Month) {
		Work_Month = work_Month;
	}

	public String getSift_Name() {
		return Sift_Name;
	}

	public void setSift_Name(String sift_Name) {
		Sift_Name = sift_Name;
	}

	public String getUser_Id() {
		return User_Id;
	}

	public void setUser_Id(String user_Id) {
		User_Id = user_Id;
	}

	public String getPass() {
		return Pass;
	}

	public void setPass(String pass) {
		User_Id = pass;
	}
	public String getPart_Name() {
		return Part_Name;
	}

	public void setPart_Name(String part_Name) {
		Part_Name = part_Name;
	}

	public int getMonth() {
		return Month;
	}

	public void setMonth(int month) {
		Month = month;
	}

	public int getDay() {
		return Day;
	}

	public void setDay(int day) {
		Day = day;
	}

	public int getStart_Time() {
		return Start_Time;
	}

	public void setStart_Time(int start_Time) {
		Start_Time = start_Time;
	}

	public int getEnd_Time() {
		return End_Time;
	}

	public void setEnd_Time(int end_Time) {
		End_Time = end_Time;
	}

	public int getKotuhi() {
		return Kotuhi;
	}

	public void setKotuhi(int kotuhi) {
		Kotuhi = kotuhi;
	}

	public int getYakin() {
		return Yakin;
	}

	public void setYakin(int yakin) {
		Yakin = yakin;
	}

	public int getSoutyo() {
		return Soutyo;
	}

	public void setSoutyo(int soutyo) {
		Soutyo = soutyo;
	}

	public int getGoal_Money() {
		return Goal_Money;
	}

	public void setGoal_Money(int goal_Money) {
		Goal_Money = goal_Money;
	}

	public int getGoal_Time() {
		return Goal_Time;
	}

	public void setGoal_Time(int goal_Time) {
		Goal_Time = goal_Time;
	}

	public int getGoal_Day() {
		return Goal_Day;
	}

	public void setGoal_Day(int goal_Day) {
		Goal_Day = goal_Day;
	}

	public int getProcessStatus() {
		return ProcessStatus;
	}

	public void setProcessStatus(int processStatus) {
		ProcessStatus = processStatus;
	}

	public int getWork_Time() {
		return Work_Time;
	}

	public void setWork_Time(int work_Time) {
		Work_Time = work_Time;
	}

	public String getKeikoku() {
		return Keikoku;
	}

	public void setKeikoku(String keikoku) {
		Keikoku = keikoku;
	}

	public ArrayList<UserInfoKojin> getWork_Zenken() {
		return Work_Zenken;
	}

	public void setWork_Zenken(ArrayList<UserInfoKojin> work_Zenken) {
		Work_Zenken = work_Zenken;
	}

	public ArrayList<UserInfoKojin> getList() {
		return list;
	}

	public void setList(ArrayList<UserInfoKojin> list) {
		this.list = list;
	}

	public ArrayList<UserInfoKojin> getlist() {
		return list;
	}

	public int getGoukei_Money() {
		return Goukei_Money;
	}

	public void setGoukei_Money(int goukei_Money) {
		Goukei_Money = goukei_Money;
	}

	public int getJikyu() {
		return Jikyu;
	}

	public void setJikyu(int jikyu) {
		Jikyu = jikyu;
	}

	public void Input() {
		userinfokojin.setUser_Id(User_Id);
		userinfokojin.setPass(Pass);
		userinfokojin.setPart_Name(Part_Name);
		userinfokojin.setMonth(Month);
		userinfokojin.setDay(Day);
		userinfokojin.setStart_Time(Start_Time);
		userinfokojin.setEnd_Time(End_Time);
		userinfokojin.setKotuhi(Kotuhi);
		userinfokojin.setYakin(Yakin);
		userinfokojin.setSoutyo(Soutyo);
		userinfokojin.setGoal_Money(Goal_Money);
		userinfokojin.setGoal_Time(Goal_Time);
		userinfokojin.setGoal_Day(Goal_Day);
		userinfokojin.setJikyu(Jikyu);
	}

	@Validations(
			requiredStrings = {
			@RequiredStringValidator(fieldName = "User_Id", message = "ユーザIDは入力必修です。"),
			@RequiredStringValidator(fieldName = "pass", message = "パスワードは入力必修です。") },
		stringLengthFields = {
			@StringLengthFieldValidator(fieldName = "pass", maxLength = "15", minLength = "0",
			message = "パスワードは15文字以内です。"), })

	public String execute() throws Exception {
		// ビジネスロジックの処理

		Calendar calendar = Calendar.getInstance();
		Calculation karenda = new Calculation();

		if (1 == ProcessStatus) {

			//ログインできたか確認
			handan = db.canLogin(userinfokojin);

			if (handan) {

				// ログイン日の日付を取得
				Day = calendar.get(Calendar.DATE);

				Month = calendar.get(Calendar.MONTH) + 1;

				// アルバイトテーブル＆シフトテーブルのデータを全て取得
				ArrayList<UserInfoKojin> Zenken = db.getWorkZenken();

				// ログイン日付までの時給と労働時間を取得
				ArrayList<UserInfoKojin> LoginGOUKEi = db.kyuryoGoukei(userinfokojin);

				// 一日からログイン日付までの時間を参考に合計金額を計算
				Goukei_Money = calculation.work(LoginGOUKEi);

				// 税警告
				Keikoku = calculation.zeiTaisaku(Zenken);

				// 目標までの残りの時間と日数計算
				Goal_Time = calculation.Mokuhyo1(Goal_Money, Jikyu);


				Goal_Day = calculation.Mokuhyo2(Goal_Time);

				// カレンダー一覧を取得
				list = karenda.Karenda();

				return "Ok";
			} else {
				return "No";
			}
		}
		//アカウント登録
		if (2 == ProcessStatus) {
			db.inserAccountIdPass(userinfokojin);
			return "Ok";

		//アカウント削除
		}else if (3 == ProcessStatus) {
			db.deleteAccount(userinfokojin);
			return "Ok";

		//アカウント更新
		}else if (4 == ProcessStatus) {
			db.updateAccountIdPass(userinfokojin);
			return "Ok";

		//アカウント検索
		}else if (5 == ProcessStatus) {
			list = db.SearchAccount(userinfokojin);
			return "Ok";

			//アルバイトの登録
		}else if (6 == ProcessStatus) {
			db.insertPart(userinfokojin);
			//入力された労働時間の計算
			Work_Time = calculation.get(list);
			//所得税発生するか確認
			Keikoku = calculation.zeiTaisaku(list);
			//目標までの時間
			Goal_Time = calculation.Mokuhyo1(Goal_Money,Jikyu);
			//目標までの日数
			Goal_Day = calculation.Mokuhyo2(Goal_Time);
			return "Ok";

		//アルバイト削除
		}else if (7 == ProcessStatus) {
			db.deletePart(userinfokojin);
			//所得税発生するか確認
			Keikoku = calculation.zeiTaisaku(list);
			//目標までの時間
			Goal_Time = calculation.Mokuhyo1(Goal_Money,Jikyu);
			//目標までの日数
			Goal_Day = calculation.Mokuhyo2(Goal_Time);
			return "Ok";

		//
		}else if (8 == ProcessStatus) {
		db.updatePart(userinfokojin);
		//所得税発生するか確認
		Keikoku = calculation.zeiTaisaku(list);
		//目標までの時間
		Goal_Time = calculation.Mokuhyo1(Goal_Money,Jikyu);
		//目標までの日数
		Goal_Day = calculation.Mokuhyo2(Goal_Time);
		return "Ok";

		}else if (9 == ProcessStatus) {
			list = db.SearchPart(userinfokojin);
			return "Ok";
		}
		return "No";

	}

}
