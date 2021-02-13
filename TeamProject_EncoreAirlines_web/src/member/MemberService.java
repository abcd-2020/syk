package member;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import resources.Factory;


public class MemberService {
	
	private SqlSessionFactory sqlSessionFactory;
	
	public MemberService() {
		sqlSessionFactory = Factory.getSqlSessionFactory();
	}
	
	public void addMember(Member m){
		SqlSession session = sqlSessionFactory.openSession();//session open
		MemberMapper mapper = (MemberMapper) session.getMapper(MemberMapper.class);//session
		mapper.addMember(m);
		session.commit();
		session.close();
	}
	
	public Member getMember(String id){
		SqlSession session = sqlSessionFactory.openSession();
		MemberMapper mapper = (MemberMapper) session.getMapper(MemberMapper.class);
		Member m = mapper.getMember(id);
		session.close();
		
		return m;
	}
	
	public ArrayList<Member> getMembers(){
		SqlSession session = sqlSessionFactory.openSession();
		MemberMapper mapper = (MemberMapper) session.getMapper(MemberMapper.class);
		ArrayList<Member> list = mapper.getMembers();
		session.close();
		
		return list;
	}
	
	public void editMember(Member m){
		SqlSession session = sqlSessionFactory.openSession();
		MemberMapper mapper = (MemberMapper) session.getMapper(MemberMapper.class);
		mapper.editMember(m);
		session.commit();
		session.close();
	}
	
	public void delete(String id){
		SqlSession session = sqlSessionFactory.openSession();
		MemberMapper mapper = (MemberMapper) session.getMapper(MemberMapper.class);
		mapper.delete(id);
		session.commit();
		session.close();
	}
	
	
	public ArrayList <String> unusedId(){
		SqlSession session = sqlSessionFactory.openSession();
		MemberMapper mapper = (MemberMapper) session.getMapper(MemberMapper.class);
		ArrayList<String> list = mapper.unusedId();
		session.close();
		return list;
	}
	
	public Member selectById(String id){
		SqlSession session = sqlSessionFactory.openSession();
		MemberMapper mapper = (MemberMapper) session.getMapper(MemberMapper.class);
		Member m = mapper.selectById(id);
		session.close();
		return m;
	}
}

