package user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.DriverManager;

public class UserDAO {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public UserDAO() {//mySQL�� �����ϰ� ���ִ� �κ�
		try {
			//String dbURL = "jdbc:mysql://localhost:3306/BBS?serverTimezone=UTC";
			//String dbURL = "jdbc:mysql://localhost:3306/BBS";//3306��Ʈ BBS? ����ǻ�Ϳ� ��ġ�� MYSQL ���� ��ü�� �ǹ�
			//String dbID = "root";
			//String dbPassword = "920902";
			//Class.forName("com.mysql.jdbc.Driver");//����̹��� MYSQL�� ������ �� �ֵ��� �Ű�ü ������ �ϴ� ���̺귯�� 
			//String dbURL = "jdbc:mysql://localhost:3306/BBS&characterEncoding=UTF-8&serverTimezone=UTC";
			String dbURL = "jdbc:mysql://localhost:3306/BBS?serverTimezone=UTC";
			String dbID = "root";
			String dbPassword = "920902";
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			
			

			
			conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
		} catch (Exception e) { //conn ��ü �ȿ� ���ӵ� ������ ���Ե�.
			e.printStackTrace(); //������ �������� ���
		}
	}
	
	//�α����� �õ��ϴ� �ϳ��� �Լ��� ����� ����
	public int login(String userID, String userPassword) {
		String SQL = "SELECT userPassword FROM USER WHERE userID = ?";//SQL�� �Է��� ��ɾ�
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1,  userID); 
			rs = pstmt.executeQuery();
			if (rs.next()) {
				if(rs.getString(1).equals(userPassword)) {
					return 1; //�α��� ����
				}
				else
					return 0; //��й�ȣ ����ġ
			}
			return -1; // ���̵� ����
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -2; // �����ͺ��̽� ����
	}
}
