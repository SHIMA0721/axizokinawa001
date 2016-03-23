package jp.co.axiz.app.action;
import java.util.ArrayList;

import db.UserInfoKojin;

public class karenda {

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
