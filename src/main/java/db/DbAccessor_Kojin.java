package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DbAccessor_Kojin {

	Connection con = null; // コネクション
	PreparedStatement stmt = null; // ステートメント

	public boolean canLogin(UserInfoKojin userinfo) {

		try {
			// SQL作成
			String sql = "SELECT * FROM user_table WHERE user_id = ? AND password = ?;";

			// データベースへの接続
			setStatement(sql);

			// 検索条件を設定
			stmt.setString(1, userinfo.getUser_Id());
			stmt.setString(2, userinfo.getPass());

			// SQL実行（データ取得）
			ResultSet rs = stmt.executeQuery();

			// 検索結果の件数をカウント
			int count = 0;
			while (rs.next()) {
				count++;
			}

			if (count == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			closeStatement();
		}

		return false;
	}

	public ArrayList<UserInfoKojin> getWorkZenken() {

		ArrayList<UserInfoKojin> list = null;

		try {

			// アルバイトテーブルとシフトテーブルを全検索
			String sql = "SELECT S.sift_name,S.work_month,S.work_day,S.Start_Time,S.End_Time,S.work_time"
					+ "P.Part_Name,P.jikyu,P.Kotu,P.siny,P.soutyo,FROM Part_table P"
					+ " JOIN Shift_Table S ON P.User_Id = S.User_Id WHERE User_Id = ? AND work_month = ?;";

			setStatement(sql);

			ResultSet rs = stmt.executeQuery();

			list = new ArrayList<UserInfoKojin>();
			while (rs.next()) {
				UserInfoKojin userInfoKojin = new UserInfoKojin();
				userInfoKojin.setSift_Name(rs.getString("sift_name"));
				userInfoKojin.setWork_Month(rs.getInt("work_month"));
				userInfoKojin.setWork_Day(rs.getInt("work_day"));
				userInfoKojin.setStart_Time(rs.getInt("start_time"));
				userInfoKojin.setEnd_Time(rs.getInt("Start_Time"));

				userInfoKojin.setPart_Name(rs.getString("part_name"));
				userInfoKojin.setJikyu(rs.getInt("Jikyu"));
				userInfoKojin.setKotuhi(rs.getInt("Kotuhi"));
				userInfoKojin.setYakin(rs.getInt("Yakin"));
				userInfoKojin.setSoutyo(rs.getInt("soutyo"));
				;
				list.add(userInfoKojin);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			closeStatement();
		}
		return list;
	}

	// 時給と労働時間だけを取得
	public ArrayList<UserInfoKojin> kyuryoGoukei(UserInfoKojin userinfokojin) {
		ArrayList<UserInfoKojin> list = null;
		try {
			String sql = "SELECT P.Jkyu, S.work_Time, FROM Part_table P"
					+ "JOIN Shift_table S ON P.UseId = S.UseId WHERE "
					+ "(work_day BETWEEN 1 AND ? ) AND User_Id = ? work_month = ?";
			setStatement(sql);

			//条件　1からどの数字まで？
			stmt.setInt(1, userinfokojin.getDay());
			//条件　IDは？
			stmt.setString(2, userinfokojin.getUser_Id());
			//条件　何月のデータを取得するか
			stmt.setInt(3, userinfokojin.getMonth());

			ResultSet rs = stmt.executeQuery();

			list = new ArrayList<UserInfoKojin>();

			while (rs.next()) {
				UserInfoKojin userInfoKojin = new UserInfoKojin();
				userInfoKojin.setWork_Time(rs.getInt("work_Time"));
				userInfoKojin.setJikyu(rs.getInt("Jikyu"));
				list.add(userInfoKojin);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			closeStatement();
		}
		return list;
	}

	//アカウント登録
	public boolean inserAccountIdPass(UserInfoKojin userinfokojin){

		try {
			String sql ="INSERT INTO User_table VALUES ( ?, ? ,1 ,1 ,1)";
			setStatement(sql);
			stmt.setString(1, userinfokojin.getUser_Id());
			stmt.setString(2, userinfokojin.getPass());
			ResultSet rs = stmt.executeQuery();

			int count = 0;
            while(rs.next()) {
                count++;
            }

            if( count == 1 ) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeStatement();
        }

        return false;
    }
	//アカウント削除
	public boolean deleteAccount(UserInfoKojin userinfokojin){

		try {
			String sql ="DELETE FROM User_table WHERE User_Id = (?)";
			setStatement(sql);
			stmt.setString(1, userinfokojin.getUser_Id());
			ResultSet rs = stmt.executeQuery();

			int count = 0;
            while(rs.next()) {
                count++;
            }

            if( count == 1 ) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeStatement();
        }

        return false;
    }

	//アカウントのパスワードを更新
	public boolean updateAccountIdPass(UserInfoKojin userinfokojin){

		try {
			String sql ="UPDATE User_table SET password = ? WHERE  User_Id = ?";
			setStatement(sql);
			stmt.setString(1, userinfokojin.getPass());
			stmt.setString(2, userinfokojin.getUser_Id());
			ResultSet rs = stmt.executeQuery();

			int count = 0;
            while(rs.next()) {
                count++;
            }

            if( count == 1 ) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeStatement();
        }

        return false;
    }

	//メッセージの更新
	public boolean updateAccount(UserInfoKojin userinfokojin){

		try {
			String sql ="UPDATE User_table SET tax_view_status = ? , month_total_view_status = ? , goal_view_status = ? WHERE User_Id = ? ";
			setStatement(sql);
			stmt.setString(1, userinfokojin.getPass());
			stmt.setString(2, userinfokojin.getUser_Id());
			ResultSet rs = stmt.executeQuery();

			int count = 0;
            while(rs.next()) {
                count++;
            }

            if( count == 1 ) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeStatement();
        }

        return false;
    }

	//アカウント検索
	public  ArrayList<UserInfoKojin> SearchAccount(UserInfoKojin userinfokojin){
		ArrayList<UserInfoKojin> list = null;
		try {
			String sql ="SELECT user_id,Passworrd,tax_view_status,month_total_view_status,goal_view_status FROM user_table WHERE User_Id = ?";
			setStatement(sql);
			stmt.setString(1, userinfokojin.getUser_Id());
			ResultSet rs = stmt.executeQuery();

			list = new ArrayList<UserInfoKojin>();
			while (rs.next()) {
				UserInfoKojin userInfoKojin = new UserInfoKojin();
				userInfoKojin.setUser_Id(rs.getString("user_id"));
				userInfoKojin.setPass(rs.getString("Passworrd"));
				userInfoKojin.setTax_view_status(rs.getInt("tax_view_status"));
				userInfoKojin.setMonth_total_view_status(rs.getInt("month_total_view_status"));
				userInfoKojin.setGoal_view_status(rs.getInt("goal_view_status"));
				list.add(userInfoKojin);

			}
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeStatement();
        }
        return list;
    }

	public boolean insertSift(UserInfoKojin userinfokojin){

		try {
			String sql ="INSERT INTO Shift_table VALUES ( ?, ?, ?, ?, ?, ?, ?)";
			setStatement(sql);
			stmt.setString(1, userinfokojin.getUser_Id());
			stmt.setInt(2, userinfokojin.getMonth());
			stmt.setInt(3, userinfokojin.getDay());
			stmt.setInt(4, userinfokojin.getStart_Time());
			stmt.setInt(5, userinfokojin.getEnd_Time());
			stmt.setString(6, userinfokojin.getSift_Name());
			stmt.setInt(7, userinfokojin.getWork_Time());

			ResultSet rs = stmt.executeQuery();

			int count = 0;
            while(rs.next()) {
                count++;
            }

            if( count == 1 ) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeStatement();
        }

        return false;

	}


	public boolean deleteSift(UserInfoKojin userinfokojin){

		try {
			String sql ="DELETE FROM Shift_table WHERE Shift_No = (?) ";

			setStatement(sql);

			stmt.setInt(1, userinfokojin.getShift_No());

			ResultSet rs = stmt.executeQuery();

			int count = 0;
            while(rs.next()) {
                count++;
            }

            if( count == 1 ) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeStatement();
        }
        return false;
	}

	public boolean updateSift(UserInfoKojin userinfokojin){

		try {
			String sql ="UPDATE Shift_table SET Month = ?, Day = ?, Start_time = ? End_Time = ? Shifut_Name = ? WHERE Sift_No = ?";

			setStatement(sql);

			stmt.setInt(1, userinfokojin.getDay());
			stmt.setInt(2, userinfokojin.getStart_Time());
			stmt.setInt(3, userinfokojin.getEnd_Time());
			stmt.setString(4, userinfokojin.getSift_Name());
			stmt.setInt(5, userinfokojin.getShift_No());

			ResultSet rs = stmt.executeQuery();

			int count = 0;
            while(rs.next()) {
                count++;
            }

            if( count == 1 ) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeStatement();
        }
        return false;
	}

	//アルバイト登録
	public boolean insertPart(UserInfoKojin userinfokojin){

		try {
			String sql ="INSERT INTO Part_table VALUES (?, ?, ?, ?, ?, ?)";

			setStatement(sql);

			stmt.setString(1, userinfokojin.getUser_Id());
			stmt.setString(2, userinfokojin.getArubaito_name());
			stmt.setInt(3, userinfokojin.getJikyu());
			stmt.setInt(4, userinfokojin.getKotuhi());
			stmt.setInt(5, userinfokojin.getYakin());
			stmt.setInt(6, userinfokojin.getSoutyo());

			ResultSet rs = stmt.executeQuery();

			int count = 0;
            while(rs.next()) {
                count++;
            }

            if( count == 1 ) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeStatement();
        }
        return false;
	}

	//アルバイト更新
	public boolean updatePart(UserInfoKojin userinfokojin){

		try {
			String sql ="UPDATE Part_table SET tenmei = ? , Jikyu = ? , Kotu_Hi = ? , Sinya = ? , Soutyo = ? WHERE Part_No = ?";

			setStatement(sql);

			stmt.setString(1, userinfokojin.getArubaito_name());
			stmt.setInt(2, userinfokojin.getJikyu());
			stmt.setInt(3, userinfokojin.getKotuhi());
			stmt.setInt(4, userinfokojin.getYakin());
			stmt.setInt(5, userinfokojin.getSoutyo());
			stmt.setString(6, userinfokojin.getUser_Id());

			ResultSet rs = stmt.executeQuery();

			int count = 0;
            while(rs.next()) {
                count++;
            }

            if( count == 1 ) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeStatement();
        }
        return false;
	}

	//アルバイトバイト削除
	public boolean deletePart(UserInfoKojin userinfokojin){

		try {
			String sql ="DELETE FROM Part_table WHERE Part_No = (?)";

			setStatement(sql);

			stmt.setInt(1, userinfokojin.getPart_No());

			ResultSet rs = stmt.executeQuery();

			int count = 0;
            while(rs.next()) {
                count++;
            }

            if( count == 1 ) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeStatement();
        }
        return false;
	}


	//アルバイト検索
	public ArrayList<UserInfoKojin> SearchPart(UserInfoKojin userinfokojin){
		ArrayList<UserInfoKojin> list = null;
		try {
			String sql ="SELECT * FROM Part_table WHERE Part_No = ?";

			setStatement(sql);

			stmt.setInt(1, userinfokojin.getPart_No());

			ResultSet rs = stmt.executeQuery();

			list = new ArrayList<UserInfoKojin>();
			while (rs.next()) {
				UserInfoKojin userInfoKojin = new UserInfoKojin();
				userInfoKojin.setPart_Name(rs.getString("Part_Name"));
				userInfoKojin.setJikyu(rs.getInt("Jikyu"));
				userInfoKojin.setKotuhi(rs.getInt("Kotuhi"));
				userInfoKojin.setYakin(rs.getInt("Yakin"));
				userInfoKojin.setSoutyo(rs.getInt("Soutyo"));
				list.add(userInfoKojin);

			}
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeStatement();
        }
        return list;
	}



	private void setStatement(String sql) throws ClassNotFoundException,
			SQLException {

		// JDBCドライバをロード
		Class.forName("org.postgresql.Driver");

		// データベースへの接続
		con = DriverManager.getConnection("jdbc:postgresql:axizdb_web",
				"axizuser", "axiz");

		// ステートメントの作成（SQL実行用）
		stmt = con.prepareStatement(sql);
	}

	private void closeStatement() {

		// ステートメントのクローズ
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		// コネクションのクローズ
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
