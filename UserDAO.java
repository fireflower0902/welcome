package user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.DriverManager;

public class UserDAO {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public UserDAO() {//mySQL에 접속하게 해주는 부분
		try {
			//String dbURL = "jdbc:mysql://localhost:3306/BBS?serverTimezone=UTC";
			//String dbURL = "jdbc:mysql://localhost:3306/BBS";//3306포트 BBS? 내컴퓨터에 설치된 MYSQL 서버 자체를 의미
			//String dbID = "root";
			//String dbPassword = "920902";
			//Class.forName("com.mysql.jdbc.Driver");//드라이버는 MYSQL에 접속할 수 있도록 매개체 역할을 하는 라이브러리 
			//String dbURL = "jdbc:mysql://localhost:3306/BBS&characterEncoding=UTF-8&serverTimezone=UTC";
			String dbURL = "jdbc:mysql://localhost:3306/BBS?serverTimezone=UTC";
			String dbID = "root";
			String dbPassword = "920902";
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			
			

			
			conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
		} catch (Exception e) { //conn 객체 안에 접속된 정보가 들어가게됨.
			e.printStackTrace(); //오류가 무엇인지 출력
		}
	}
	
	//로그인을 시도하는 하나의 함수를 만드는 과정
	public int login(String userID, String userPassword) {
		String SQL = "SELECT userPassword FROM USER WHERE userID = ?";//SQL에 입력할 명령어
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1,  userID); 
			rs = pstmt.executeQuery();
			if (rs.next()) {
				if(rs.getString(1).equals(userPassword)) {
					return 1; //로그인 성공
				}
				else
					return 0; //비밀번호 불일치
			}
			return -1; // 아이디가 없음
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -2; // 데이터베이스 오류
	}
}
