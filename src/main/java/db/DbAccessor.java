package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DbAccessor {

    Connection con  = null; // コネクション
    PreparedStatement  stmt = null; // ステートメント

    public boolean canLogin(UserInfo user) {

        try {
            // SQL作成
            String sql = "SELECT * FROM user_table WHERE user_id = ? AND password = ?;";

            // データベースへの接続
            setStatement(sql);

            // 検索条件を設定
            stmt.setString(1, user.getUserId());
            stmt.setString(2, user.getPassword());

            // SQL実行（データ取得）
            ResultSet rs = stmt.executeQuery();

            // 検索結果の件数をカウント
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

    public ArrayList<UserInfo>
    getUserInfo() {

        ArrayList<UserInfo> list = null;

        try {

            // SQL作成
            String sql = "SELECT * FROM user_table";

            // データベースへの接続
            setStatement(sql);

            // SQL実行（データ取得）
            ResultSet rs = stmt.executeQuery();

            // 検索結果をArrayListに格納
            list = new ArrayList<UserInfo>();
            while(rs.next()) {
                UserInfo userInfo = new UserInfo();
                userInfo.setUserId( rs.getString("user_id"));
                userInfo.setUserName( rs.getString("user_name"));
                userInfo.setPassword( rs.getString("password"));
                list.add(userInfo);
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

    public void insertUserInfo( UserInfo userInfo ) {

        try {
            // SQL作成
            String sql = "INSERT INTO user_table VALUES ( ?, ?, ?)";
            // データベースへの接続
            setStatement(sql);

            // 検索条件を設定

            stmt.setString(1, userInfo.getUserId());
            stmt.setString(2, userInfo.getUserName());
            stmt.setString(3, userInfo.getPassword());

            // SQL実行（データ取得）
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeStatement();
        }
    }
    public void deleteUserInfo(UserInfo userInfo){

    	try {
            // SQL作成
            String sql = "DELETE FROM user_table WHERE user_id = (?)";
            // データベースへの接続
            setStatement(sql);

            // 検索条件を設定
            stmt.setString(1, userInfo.getUserId());

            // SQL実行（データ取得）
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeStatement();
        }
    }

    int i = 0;
    public boolean Logincan1(UserInfo userInfo){

    	try {

            // SQL作成
            String sql = "SELECT * FROM user_table WHERE user_id = ?";
            // データベースへの接続
            setStatement(sql);

            // 検索条件を設定
            stmt.setString(1, userInfo.getUserId());

            // SQL実行（データ取得）
            ResultSet rs = stmt.executeQuery();

            // 検索結果の件数をカウント
            if(rs.next()) {
                return true;
            }

//            UPDETA user_table SET user_name = ? AND password = ?
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeStatement();
        }
    	return false;
    }

    public void updetaUserInfo(UserInfo userInfo){
    	try {

            // SQL作成
            String sql = "UPDATE user_table SET user_name = ?,password = ? WHERE user_id = ?";
            // データベースへの接続
            setStatement(sql);

            // 検索条件を設定
            stmt.setString(1, userInfo.getUserName());
            stmt.setString(2, userInfo.getPassword());
            stmt.setString(3, userInfo.getUserId());

            ResultSet rs = stmt.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeStatement();
        }
    }


    private void setStatement(String sql) throws ClassNotFoundException, SQLException{

        // JDBCドライバをロード
        Class.forName("org.postgresql.Driver");

        // データベースへの接続
        con = DriverManager.getConnection("jdbc:postgresql:axizdb_web","axizuser","axiz");

        // ステートメントの作成（SQL実行用）
        stmt = con.prepareStatement(sql);
    }

    private void closeStatement() {

        // ステートメントのクローズ
        if( stmt != null ) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        // コネクションのクローズ
        if( con != null ) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

	public  ArrayList<UserInfoKojin> kyuryoGoukei(
			UserInfoKojin userinfokojin) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

}
