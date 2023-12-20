package Controller;

import java.util.Scanner;

public class Login_main {                                       
    public static void main(String[] args) {
        String UserName ;
        String Password ;
        
        while(true){
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter UserName :- ");
            UserName = sc.nextLine();
            System.out.print("Enter Password :- ");
            Password = sc.nextLine();
//            System.out.prorintln(UserName + " " + Password);
            if (UserName.equals("root") && Password.equals("root123")) {
                System.out.println("Login Successfully");
                Booking.display();
                break;
            } else {
                System.out.println("Wrong Password try Again");
            }
        }
    }
}
