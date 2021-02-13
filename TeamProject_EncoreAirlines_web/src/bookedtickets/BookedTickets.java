package bookedtickets;

public class BookedTickets {
	
	private String booked_num;//sequence
	private String state;//booked ticket state 
	private String flight_num;
	private String id;
	private int seat_count;
	
	public BookedTickets() {
		
	}
	
	public BookedTickets(String booked_num, String state, String flight_num, String id, int seat_count) {
		super();
		this.booked_num = booked_num;
		this.flight_num = flight_num;
		this.id = id;
		this.state = state;
		this.seat_count = seat_count;
	}

	public String getbooked_num() {
		return booked_num;
	}

	public void setbooked_num(String booked_num) {
		this.booked_num = booked_num;
	}

	public String getflight_num() {
		return flight_num;
	}

	public void setflight_num(String flight_num) {
		this.flight_num = flight_num;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	

	public int getSeat_count() {
		return seat_count;
	}

	public void setSeat_count(int seat_count) {
		this.seat_count = seat_count;
	}


	@Override
	public String toString() {
		return "BookedTickets [booked_num=" + booked_num + ", flight_num=" + flight_num + ", id=" + id + ", state="
				+ state + ", seat_count=" + seat_count + "]";
	}

	@Override
	public boolean equals(Object arg0) {
		
		if(arg0 != null && arg0 instanceof BookedTickets) {
			if(((BookedTickets)arg0).getbooked_num() == booked_num) {
				return true;
			}
		}
		return false;
	}
}
