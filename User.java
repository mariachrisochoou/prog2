import java.util.Calendar;
import java.util.ArrayList;

public class User {
	
	private String username;
    private int password;
    private Calendar dateOfBirth;
    private String email;
    private static ArrayList<String> users = new ArrayList<String> ();
    
    public User(String name, int pw, Calendar dof, String mail) {
    	
    	//method which checks whether the name exists
    	username = name;
    	
    	//method which checks whether the password has >= 8 numbers
    	password = pw;
    	
    	//If we want we can check whether a user is older than a certain age
    	dateOfBirth = dof;
    	
    	//If we want we can check whether there are same emails
    	email = mail;
    	
    	//If the above requirements are met, then we add the user to our list
    	
    }

    public String getUsername(){
        return username;
    }
    
    //method that checks whether a username is verified
    public boolean checkUsername (String name) {
    	return true;
    }
    
    
    //method that checks whether a pw is longer than 8 numbers
    public boolean checkPassword (int pw) {
    	return true;
    }
    
    //method that finds if there is another user with the same username
    public boolean findUser (String name) {
    	return true ;
    }

    //This method checks if user is registered
    public static boolean isUserRegistered(User user){
        if(!users.contains(user.username)){
            return false;
        }
        return true;
    }

    //This method is used to register users
    public static void userRegistration(User user){
        if(!isUserRegistered(user)){
            users.add(user.username);
        } else {
            System.out.println ("User already exists");
        }       
    }
    
    //test

    
}

