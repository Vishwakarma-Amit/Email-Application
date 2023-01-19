import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int mailboxCapacity=500;
    private String alternateEmail;

    private String companySuffix = "company.com";

    private int defaultLength = 10;

    // Constructor to receive the firstName & lastName
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = setDepartment();
        // Combine element to generate email
        email = firstName.toLowerCase()+"."+lastName.toLowerCase()+"@"+department.toLowerCase()+"."+companySuffix;
        this.password = randomPassword(defaultLength);
        System.out.println("Your password is: "+password);

    }

    // Ask for the department
    private String setDepartment(){
        System.out.println("Enter the department\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter department code: ");
        Scanner scanner = new Scanner(System.in);
        int depChoice = scanner.nextInt();
        String department = (depChoice==1)?"Sales":(depChoice==2)?"Development":(depChoice==3)?"Accounting":"none";
        return department;
    }

    // Generate A random Password
    private String randomPassword(int length){
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcbefghijklmnopqrstuvwxyz1234567890@#!$%";
        char[] password = new char[length];
        for(int i=0; i<length; i++){
            int random = (int) (Math.random()*passwordSet.length());
            password[i] = passwordSet.charAt(random);
        }
        return new String(password);
    }

    // Set mailbox capacity
    public void setMailboxCapacity(int capacity){
        this.mailboxCapacity = capacity;
    }

    // Set alternate email
    public void setAlternateEmail(String alternateEmail){
        this.alternateEmail = alternateEmail;
    }

    // Change password
    public void changePassword(String password){
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public int getMailboxCapacity() {
        return mailboxCapacity;
    }

    public String getAlternateEmail() {
        return alternateEmail;
    }

    public String showInfo(){
        return "Name: "+ firstName+" "+lastName+"\n"+
                "Email: "+ email+"\n"+
                "Mailbox Capacity: "+ mailboxCapacity;
    }
}
