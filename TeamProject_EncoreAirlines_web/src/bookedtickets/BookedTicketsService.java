package bookedtickets;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import resources.Factory;


public class BookedTicketsService {
	
	private SqlSessionFactory sqlSessionFactory;
	
	public BookedTicketsService() {
		sqlSessionFactory = Factory.getSqlSessionFactory();
	}
	
	public void addBookedTicket(BookedTickets b){
		SqlSession session = sqlSessionFactory.openSession();//session open
		BookedTicketsMapper mapper = (BookedTicketsMapper) session.getMapper(BookedTicketsMapper.class);//session
		mapper.addBooekdTicket(b);
		session.commit();
		session.close();
	}
	
	public BookedTickets getBookedTicket(String booked_num){
		SqlSession session = sqlSessionFactory.openSession();
		BookedTicketsMapper mapper = (BookedTicketsMapper) session.getMapper(BookedTicketsMapper.class);
		BookedTickets m = mapper.getBookedTicket(booked_num);
		session.close();
		
		return m;
	}
	/*
	@Select("select * from encore_booked where id=#{id}")
	ArrayList<BookedTickets> getAllBookedTickets();*/
	
	public ArrayList<BookedTickets> getBookedTicketById(String id){
		SqlSession session = sqlSessionFactory.openSession();
		BookedTicketsMapper mapper = (BookedTicketsMapper) session.getMapper(BookedTicketsMapper.class);
		ArrayList<BookedTickets> m = mapper.getBookedTicketById(id);
		session.close();
		
		return m;
	}
	

	
	public ArrayList<BookedTickets> getBookedTickets(){
		SqlSession session = sqlSessionFactory.openSession();
		BookedTicketsMapper mapper = (BookedTicketsMapper) session.getMapper(BookedTicketsMapper.class);
		ArrayList<BookedTickets> list = mapper.getBookedTickets();
		session.close();
		
		return list;
	}
	
	public void selfCheckIn(BookedTickets b){
		SqlSession session = sqlSessionFactory.openSession();
		BookedTicketsMapper mapper = (BookedTicketsMapper) session.getMapper(BookedTicketsMapper.class);
		mapper.selfCheckIn(b);
		session.commit();
		session.close();
	}
	
	public void delBookedTicket(String booked_num){
		SqlSession session = sqlSessionFactory.openSession();
		BookedTicketsMapper mapper = (BookedTicketsMapper) session.getMapper(BookedTicketsMapper.class);
		mapper.delBookedTicket(booked_num);
		session.commit();
		session.close();
	}
	
/*	@Update("update encore_booked set state='Y' where id=#{id} and flight_num=#{flight_num}")
	BookedTickets checkIn(@Param("id") String id, @Param("flight_num") String flight_num);*/
	
	public void checkIn(String id, String flight_num) {
		SqlSession session = sqlSessionFactory.openSession();
		BookedTicketsMapper mapper = (BookedTicketsMapper) session.getMapper(BookedTicketsMapper.class);
		mapper.checkIn(id, flight_num);
		session.commit();
		session.close();
	}
}

