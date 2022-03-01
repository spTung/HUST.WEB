import java.util.Scanner;
public class dayofmonth {
    public static void main(String[] args) {
        int i = 1;
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter month : ");
        int month = keyboard.nextInt();
        System.out.println("Enter year : ");
        int year = keyboard.nextInt();
        if(year % 4 == 0 && year % 100 ==0)
        {
            if(year % 400 != 0)
            {
                i = 1; //ko nhuan
            }
            else i = 0;
        }


        switch(month)
        {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
            System.out.println("Number of day is : 31");
            break;
            case 4:
            case 6:
            case 9:
            case 11:
            System.out.println("Number of day is : 30");
            break;
            case 2:
            if(i == 1)
            {
                System.out.println("Number of day is : 28");
                break;
            }
            else 
            {
                System.out.println("Number of day is : 29");
                break;
            }
            default:
            System.out.println("Month must be between 1 and 12!!!");
            break;
        }
        System.exit(0);
    }
                
}