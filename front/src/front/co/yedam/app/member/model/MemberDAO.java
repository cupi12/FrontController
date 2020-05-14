package front.co.yedam.app.member.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import front.co.yedam.app.common.ConnectionManager;

public class MemberDAO {

	//싱글톤
	private static MemberDAO instance = new MemberDAO();
	public static MemberDAO getInstance() {
		return instance;		
	}//end of singleton
	
	public int memberInsert(Connection conn, MemberVO member) {
		int r = 0;
		
		PreparedStatement psmt = null;
		try {
			// 1. DB 연결
		

			// 2. sql구문 준비
			String sql = "insert into member (id, pwd, name, hobby, gender, religion, introduction, regdt)"
					+ " values ( ?, ?, ?, ?, ?, ?, ?, sysdate)";

			psmt = conn.prepareStatement(sql);

			// 3. 실행
			psmt.setString(1, member.getId());
			psmt.setString(2, member.getPwd());
			psmt.setString(3, member.getName());
			psmt.setString(4, member.getHobby());
			psmt.setString(5, member.getGender());
			psmt.setString(6, member.getReligion());
			psmt.setString(7, member.getIntroduction());

			r = psmt.executeUpdate();

			// 4. 결과처리
			System.out.println(r + " 건이 등록됨.");

		} catch (Exception e) {
			e.printStackTrace();
		}

		return r;
	}// end of insert

	public int memberDelete(Connection conn, MemberVO member) {
		int r = 0;
		
		PreparedStatement psmt = null;
		try {
			// 1. DB 연결
		

			// 2. sql구문 준비
			String sql = "delete from member where id=?";

			psmt = conn.prepareStatement(sql);

			// 3. 실행
			psmt.setString(1, member.getId());

			r = psmt.executeUpdate();

			// 4. 결과처리
			System.out.println(r + " 건이 삭제됨.");

		} catch (Exception e) {
			e.printStackTrace();
		}

		return r;
	}// end of insert
	
	
	public ArrayList<MemberVO> getMemberList(Connection conn) {
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		try {
			// 1. DB연결
			PreparedStatement psmt = null;
			// 2. 쿼리 준비
			String sql = "select * FROM member order by id";
			psmt = conn.prepareStatement(sql);
			// 3. statement 실행
			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {
				MemberVO vo = new MemberVO();
				vo.setId(rs.getString("id"));
				vo.setPwd(rs.getString("pwd"));
				vo.setName(rs.getString("name"));
				vo.setHobby(rs.getString("hobby"));
				vo.setGender(rs.getString("gender"));
				vo.setReligion(rs.getString("religion"));
				vo.setIntroduction(rs.getString("introduction"));
				vo.setRegdt(rs.getString("regdt"));
				list.add(vo);
			}
			// 4. 결과 저장
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 5. 연결 해제
		}
		return list;
	}

	public MemberVO getMember(Connection conn,String id) {// 단건조회
		MemberVO vo = new MemberVO();
		try {
			// 1. DB연결
			PreparedStatement psmt = null;
			// 2. 쿼리 준비
			String sql = "select * FROM member where id=?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			// 3. statement 실행
			ResultSet rs = psmt.executeQuery();
			if (rs.next()) {
				vo.setId(rs.getString("id"));
				vo.setPwd(rs.getString("pwd"));
				vo.setName(rs.getString("name"));
				vo.setHobby(rs.getString("hobby"));
				vo.setGender(rs.getString("gender"));
				vo.setReligion(rs.getString("religion"));
				vo.setIntroduction(rs.getString("introduction"));
				vo.setRegdt(rs.getString("regdt"));
			} else {

			}
			// 4. 결과 저장
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 5. 연결 해제
		}
		return vo;
	}

	public int memberUpdate(Connection conn,MemberVO member) {
		int r = 0;
		PreparedStatement psmt = null;
		try {
			// 1. DB 연결

			// 2. sql구문 준비
			String sql = "update member set pwd =?, name =?, hobby=?, gender =?, religion=?, introduction=? where id =? ";

			psmt = conn.prepareStatement(sql);

			// 3. 실행
			psmt.setString(1, member.getPwd());
			psmt.setString(2, member.getName());
			psmt.setString(3, member.getHobby());
			psmt.setString(4, member.getGender());
			psmt.setString(5, member.getReligion());
			psmt.setString(6, member.getIntroduction());
			psmt.setString(7, member.getId());

			r = psmt.executeUpdate();

			// 4. 결과처리
			System.out.println(r + " 건이 등록됨.");

		} catch (Exception e) {
			e.printStackTrace();
		} 

		return r;
	}

}// end of class
