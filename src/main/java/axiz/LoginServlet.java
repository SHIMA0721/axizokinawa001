package axiz;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.DbAccessor1;
import db.UserInfo;

public class LoginServlet extends HttpServlet{
protected void service(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        // 文字化け対策
        req.setCharacterEncoding("UTF-8");

        // ログインID、パスワードを取得
        String id = req.getParameter("id");
        String pass = req.getParameter("pass");

        // 入力値のチェック
        if(( "".equals(id)) || ( "".equals(pass)) ) {

            // メッセージ設定
            req.setAttribute("msg",  "ログインできませんでした。");

            // id、passを設定
            req.setAttribute("id",   id);
            req.setAttribute("pass", pass);

            // 次画面指定
            req.getRequestDispatcher("index.jsp").forward(req,res);

            return;
        }

        // DTOに値を設定
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(id);
        userInfo.setPassword(pass);

        // データベース問い合わせ
        DbAccessor1 dba = new DbAccessor1();
        boolean loginFlg = dba.canLogin(userInfo);

        // 表示メッセージの受け渡し
        if(loginFlg) {

            // ユーザ情報を設定
            ArrayList<UserInfo> list = dba.getUserInfo();
            req.setAttribute("list", list);

            // 次画面指定
            req.getRequestDispatcher("result.jsp").forward(req,res);
        } else {

            // メッセージ設定
            req.setAttribute("msg", "ログインできませんでした。");

            // id、passを設定
            req.setAttribute("id",   id);
            req.setAttribute("pass", pass);

            // 次画面指定
            req.getRequestDispatcher("index.jsp").forward(req,res);
        }
    }
}