package Hospital;

public class user {
	    private String id;
	    private String name;
	    private String password;

	    public user(String id, String name, String password) {
	        this.id = id;
	        this.name = name;
	        this.password = password;
	    }

	    public String getId() {
	        return id;
	    }

	    public String getName() {
	        return name;
	    }

	    public String getPassword() {
	        return password;
	    }

	    public void displayDetails() {
	        System.out.println("ID: " + id + ", Name: " + name);
	    }
	}
