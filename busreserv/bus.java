package busreserv;

abstract class bus {
	protected int busno;
	protected boolean ac;
	protected int capacity;

	public bus(int busno, boolean ac, int capacity) {
		this.busno = busno;
		this.ac = ac;
		this.capacity = capacity;

	}
	
	public bus() {
		
	}
	
	abstract public void busdetails();
	
	public int getCapacity() {
		return capacity;
	}
	
	public void setAc(boolean ac) {
		this.ac = ac;
	}
	
	public boolean isAc() {
		return ac;
	}
	
	public int getBusno() {
		return busno;
	}
	
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	public void displaybusinfo(){
		System.out.println("busno :"+busno+" "+"AC :"+ac+" "+"capacity :"+capacity);
	}
	

}
