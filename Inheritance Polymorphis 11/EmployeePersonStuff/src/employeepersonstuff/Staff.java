
package employeepersonstuff;

public class Staff extends Employee{
    private String title;
    public Staff(String name, String address, String phone, String email, 
            int office, double salary, String title) {
        super(name, address, phone, email, office, salary);
        this.title = title;
    }
    
    public String getTitle() {
		return title;
	}

	/** Set new title */
	public void setTitle(String title) {
		this.title = title;
	}

	/** Return a string discription of the class */
	public String toString() {
		return super.toString() + "\nTitle: " + title;
	}
    
}
