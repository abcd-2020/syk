package tickets;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface TicketsMapper {
	@Insert("insert into encore_tickets values(#{flight_num}, #{depart_city}, #{depart_time}, #{arrive_city},#{arrive_time}, #{working_date}, #{seat_count}, #{price}, #{state})")
	void addTickets(Tickets t);
	
	@Select("select * from encore_tickets where flight_num=#{flight_num}")
	Tickets getTicket(@Param("flight_num") String flight_num);
	
	@Select("select * from encore_tickets")
	ArrayList<Tickets> getTickets();
	
	@Select("select * from encore_tickets where rownum <= 10")
	ArrayList<Tickets> printTickets();
	
	@Update("update encore_tickets set depart_city=#{depart_city}, depart_time=#{depart_time}, arrive_city=#{arrive_city}, arrive_time=#{arrive_time}, working_date=#{working_date}, seat_count=#{seat_count}, price=#{price}, state=#{state} where flight_num=#{flight_num}")
	void editTicket(Tickets t);
	
	@Delete("delete from encore_tickets where ticket_num=#{ticket_num}")
	void delTicket(@Param("id") String id);
	
	
	
	@Select("select * from encore_tickets where depart_city like #{depart_city} order by price")
	ArrayList<Tickets> selectByDepartCityTickets(@Param("depart_city") String depart_city);
	
	@Select("select * from encore_tickets where depart_time between #{start_date} and #{end_date} order by price")
	ArrayList<Tickets> selectByDepartDateTickets(@Param("start_date") String start_date, @Param("end_date") String end_date);
	
	//sublet
	//int num = Integer.parsInt(request.getParameter("price")):
	//service.selectByDepartDateTickets(num,num+1)
	//reponse
	
	@Select("select * from encore_tickets where arrive_city like #{arrive_city} order by price")
	ArrayList<Tickets> selectByArriveCityTickets(@Param("arrive_city") String arrive_city);
	
	@Select("select * from encore_tickets where arrive_time between #{start_date} and #{end_date} order by price'")
	ArrayList<Tickets> selectByArriveDateTickets(@Param("start_date") String start_date, @Param("end_date") String end_date);
}
