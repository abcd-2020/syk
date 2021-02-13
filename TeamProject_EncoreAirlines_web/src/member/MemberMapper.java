package member;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface MemberMapper {
	@Insert("insert into encore_member values(#{id}, #{password}, #{name}, #{passportNum},#{type}, SYSDATE)")
	void addMember(Member m);
	
	@Select("select * from encore_member where id=#{id}")
	Member getMember(@Param("id") String id);
	
	@Select("select * from encore_member")
	ArrayList<Member> getMembers();
	
	@Update("update encore_member set password=#{password}, passportNum=#{passportNum} where id=#{id}")
	void editMember(Member m);
	
	@Delete("delete from encore_member where id=#{id}")
	void delete(@Param("id") String id);
	
	@Select("select id from encore_member where months_between(sysdate, login_time)>24")
	ArrayList <String> unusedId();
	
	@Select("select * from encore_member where id=#{id}")
	Member selectById(@Param("id")String id);
}
