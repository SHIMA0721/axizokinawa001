package jp.co.axiz.app.action;

import java.util.ArrayList;

import db.UserInfoKojin;

public class Calculation {

	int i = 0;
	int Start_Time;
	int End_Time;
	int Work_Time;
	int Jikyu;
	String Henkan;

	UserInfoKojin userinfokojin = new UserInfoKojin();



	// 労働時間の計算
	public int get(ArrayList<UserInfoKojin> list) {

		UserInfoKojin user = list.get(i);
		int Goukei_Start_Time = 0;
		int Goukei_End_Time = 0;

		for (this.i = 0; i < user.getDay(); i++) {
			Start_Time = user.getStart_Time();
			End_Time = user.getEnd_Time();

			Goukei_Start_Time = +Start_Time;
			Goukei_End_Time = +End_Time;
		}
		Work_Time = Goukei_Start_Time - Goukei_End_Time;
		return Work_Time;
	}

	// 1日からログイン日付まで働いた給料の計算
	public int work(ArrayList<UserInfoKojin> list) {
		int Goukei_Money = 0;
		int Goukei_Jikyu = 0;
		UserInfoKojin user = list.get(i);

		for (this.i = 0; i > 1; i++) {
			Jikyu = user.getJikyu();
			Work_Time = user.getWork_Time();
			Work_Time = +Work_Time;
		}
		Goukei_Money = Work_Time * Jikyu;
		return Goukei_Money;
	}

	// 労働時間の
	public int work_Time(ArrayList<UserInfoKojin> list) {

		UserInfoKojin user = list.get(i);
		int Goukei_Start_Time = 0;
		int Goukei_End_Time = 0;

		for (this.i = 0; i < list.size(); i++) {
			Start_Time = user.getStart_Time();
			End_Time = user.getEnd_Time();
			Goukei_Start_Time = +Start_Time;
			Goukei_End_Time = +End_Time;
		}
		Work_Time = Goukei_Start_Time - Goukei_End_Time;
		return Work_Time;
	}

	String Keikoku;
	//税警告
	public String zeiTaisaku(ArrayList<UserInfoKojin> list) {

		UserInfoKojin user = list.get(i);
		for (this.i = 0; i < list.size(); i++) {
			Jikyu = user.getJikyu();
			Work_Time = user.getWork_Time();

			Work_Time = +Work_Time;
		}
		int Goukei_Jikyu = +Jikyu;

		if (Goukei_Jikyu >= 14) {
			Keikoku = "所得税が発生します！";
		} else {
			Keikoku = "";
		}

		return Keikoku;
	}

	//目標までの残りの時間と日数の計算
	public int Mokuhyo1(int mokuhyo, int jikyu) {
		int jikan = 0;
		jikan = mokuhyo / jikyu;
		return jikan;
	}

	public int Mokuhyo2(int Goal_Time) {
		int day = 0;
		day = Goal_Time / 8;
		return day;
	}



	//カレンダー一覧取得
	private static ArrayList<UserInfoKojin> list;

	public ArrayList<UserInfoKojin> Karenda() {
		int count = 0;
		String Space=null;
		list = null;

		for (int tuki = 1; tuki <= 12; tuki++) {

			if (tuki == 3) {
				System.out.println();
				System.out.println("        " + tuki + "月");
				System.out.println(" 日 月 火 水 木 金 土");

				if (tuki == 1 || tuki == 4 || tuki == 7) {
					Space = "               ";
					System.out.print(Space);
					count = 5;
				} else if (tuki == 2 || tuki == 8) {
					Space = "   ";
					System.out.print(Space);
					count = 1;
				} else if (tuki == 3 || tuki == 11) {
					Space = "      ";
					System.out.print(Space);
					count = 2;
				} else if (tuki == 6) {
					Space = "         ";
					System.out.print(Space);
					count = 3;
				} else if (tuki == 10) {
					Space = "                  ";
					System.out.print(Space);
					count = 6;
				} else if (tuki == 9 || tuki == 12) {
					Space = "            ";
					System.out.print(Space);
					count = 4;
				}

				for (int day = 1; day <= 31; day++) {

					if (day < 10) {
						System.out.print(" ");
					}
					System.out.print(" " + day);
					count++;
					if (count == 7 || count > 7) {
						System.out.println();
						count = 0;
					}

					if (tuki == 2) {
						if (day == 29) {
							break;
						}
					} else if (tuki == 4 || tuki == 9 || tuki == 11) {
						if (day == 30) {
							break;
						}
					}

					UserInfoKojin userInfoKojin = new UserInfoKojin();
					userInfoKojin.setKarendaday(day);
					userInfoKojin.setSpace(Space);
					list.add(userInfoKojin);
				}
				System.out.println();
			}

		}
		return list;
	}




}
