package tickets;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import resources.Factory;


public class TicketsService {
	
	private SqlSessionFactory sqlSessionFactory;
	
	public TicketsService() {
		sqlSessionFactory = Factory.getSqlSessionFactory();
	}
	
	public void addTickets(Tickets t){
		SqlSession session = sqlSessionFactory.openSession();//session open
		TicketsMapper mapper = (TicketsMapper) session.getMapper(TicketsMapper.class);//session
		mapper.addTickets(t);
		session.commit();
		session.close();
	}
	
	public Tickets getTicket(String flight_num){
		SqlSession session = sqlSessionFactory.openSession();
		TicketsMapper mapper = (TicketsMapper) session.getMapper(TicketsMapper.class);
		Tickets m = mapper.getTicket(flight_num);
		session.close();
		
		return m;
	}
	
/*	@Select("select * from encore_tickets limit 0, 5")
	ArrayList<Tickets> printTickets();*/
	
	public ArrayList<Tickets> printTickets(){
		SqlSession session = sqlSessionFactory.openSession();
		TicketsMapper mapper = (TicketsMapper) session.getMapper(TicketsMapper.class);
		ArrayList<Tickets> list = mapper.printTickets();
		session.close();
		
		return list;
	}
	
	public ArrayList<Tickets> getTikcets(){
		SqlSession session = sqlSessionFactory.openSession();
		TicketsMapper mapper = (TicketsMapper) session.getMapper(TicketsMapper.class);
		ArrayList<Tickets> list = mapper.getTickets();
		session.close();
		
		return list;
	}
	
	public void editTicket(Tickets t){
		SqlSession session = sqlSessionFactory.openSession();
		TicketsMapper mapper = (TicketsMapper) session.getMapper(TicketsMapper.class);
		mapper.editTicket(t);
		session.commit();
		session.close();
	}
	
	public void delTicket(String ticket_num){
		SqlSession session = sqlSessionFactory.openSession();
		TicketsMapper mapper = (TicketsMapper) session.getMapper(TicketsMapper.class);
		mapper.delTicket(ticket_num);
		session.commit();
		session.close();
	}
	
	
	public ArrayList<Tickets> selectByDepartCityTickets(String depart_city){
		SqlSession session = sqlSessionFactory.openSession();
		TicketsMapper mapper = (TicketsMapper) session.getMapper(TicketsMapper.class);
		ArrayList<Tickets> list = mapper.selectByDepartCityTickets("%"+depart_city+"%");
		session.close();
		
		return list;
	}
	
	public ArrayList<Tickets> selectByDepartDateTickets(String start_date, String end_date){
		SqlSession session = sqlSessionFactory.openSession();
		TicketsMapper mapper = (TicketsMapper) session.getMapper(TicketsMapper.class);
		ArrayList<Tickets> list = mapper.selectByDepartDateTickets(start_date, end_date);
		session.close();
		
		return list;
	}
	
	public ArrayList<Tickets> selectByArriveCityTickets(String arrive_city){
		SqlSession session = sqlSessionFactory.openSession();
		TicketsMapper mapper = (TicketsMapper) session.getMapper(TicketsMapper.class);
		ArrayList<Tickets> list = mapper.selectByArriveCityTickets("%"+arrive_city+"%");
		session.close();
		
		return list;
	}
	
	public ArrayList<Tickets> selectByArriveDateTickets(String start_date, String end_date){
		SqlSession session = sqlSessionFactory.openSession();
		TicketsMapper mapper = (TicketsMapper) session.getMapper(TicketsMapper.class);
		ArrayList<Tickets> list = mapper.selectByArriveDateTickets(start_date, end_date);
		session.close();
		
		return list;
	}
	
	
	
	
	
}

