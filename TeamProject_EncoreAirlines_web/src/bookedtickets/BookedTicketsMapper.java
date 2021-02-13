package bookedtickets;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface BookedTicketsMapper {
	@Insert("insert into encore_booked values(booked_seq.nextval, #{state}, #{flight_num}, #{id}, #{seat_count})")
	void addBooekdTicket(BookedTickets b);
	
	@Select("select * from encore_booked where booked_num=#{booked_num}")
	BookedTickets getBookedTicket(@Param("booked_num") String booked_num);
	
	@Select("select * from encore_booked where id=#{id}")
	ArrayList<BookedTickets> getBookedTicketById(@Param("id") String id);

	
	@Select("select * from encore_booked")
	ArrayList<BookedTickets> getBookedTickets();
	
	
	@Update("update encore_booked set state=#{state} where booked_num=#{booked_num}")
	void selfCheckIn(BookedTickets b);
	
	@Delete("delete from encore_booked where booked_num=#{booked_num}")
	void delBookedTicket(@Param("booked_num") String booked_num);
	
	@Update("update encore_booked set state='Y' where id=#{id} and flight_num=#{flight_num}")
	void checkIn(@Param("id") String id, @Param("flight_num") String flight_num);
	
}
