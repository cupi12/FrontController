package front.co.yedam.app.member.model;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import front.co.yedam.app.common.ConnectionManager;

public class MemberService {
	// 싱글톤
	private static MemberService instance = new MemberService();

	public static MemberService getInstance() {
		return instance;
	}// end of singleton

	// 회원가입
	public void memberInsert(MemberVO member) {

		Connection conn = null;
		try {
			conn = ConnectionManager.getConnnect();
			conn.setAutoCommit(false);
			// 회원테이블에 등록
			MemberDAO.getInstance().memberInsert(conn, member);
			// 로그인 테이블에 등록

			// 권한 테이블에 등록
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

		} finally {
			ConnectionManager.close(conn);
		}
	}// end of memberInsert()
	
	public void memberDelete(MemberVO member) {

		Connection conn = null;
		try {
			conn = ConnectionManager.getConnnect();
			conn.setAutoCommit(false);
			// 회원테이블에 등록
			MemberDAO.getInstance().memberDelete(conn, member);
			// 로그인 테이블에 등록

			// 권한 테이블에 등록
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

		} finally {
			ConnectionManager.close(conn);
		}
	}// end of memberDelete()

	public ArrayList<MemberVO> getMemberList() {
		Connection conn = null;
		try {
			conn = ConnectionManager.getConnnect();
			return MemberDAO.getInstance().getMemberList(conn);
		} finally {
			ConnectionManager.close(conn);
		}
	}// end of getMemberList

	public MemberVO getMember(String id) {
		Connection conn = null;
		try {
			conn = ConnectionManager.getConnnect();
			return MemberDAO.getInstance().getMember(conn, id);
		} finally {
			ConnectionManager.close(conn);
		}
	}// end of getMember
	
	public void UpdateMember(MemberVO member) {
		Connection conn = null;
		try {
			conn = ConnectionManager.getConnnect();
			conn.setAutoCommit(false);
			// 회원테이블에 등록
			MemberDAO.getInstance().memberUpdate(conn, member);
			// 로그인 테이블에 등록

			// 권한 테이블에 등록
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

		} finally {
			ConnectionManager.close(conn);
		}
	}
}