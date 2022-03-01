import java.util.Scanner;
public class triangle {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Nhap n = ");
        int n = keyboard.nextInt();
        for ( int i = 0; i < n ; i++)
        {
            for ( int j = 0; j < n -i -1 ; j++)
            {
                System.out.print(" ");         
            }
            for ( int j = 0; j <  (i*2+1) ; j++)
            {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    
}
