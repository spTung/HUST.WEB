import java.util.Arrays;
import java.util.Scanner;
public class sort {
    public static void main(String[] args) {
        double sum = 0;
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter number of element in array : ");
        int n = keyboard.nextInt();
        double[] a = new double[n];
        for ( int i = 0 ; i < n ; i++)
        {
            System.out.print("a[" + i +"] = ");
            a[i] = keyboard.nextDouble();
            sum = sum + a[i];
        }
        double avg = sum/n;
        Arrays.sort(a);
        System.out.println("Array sort ASC : " + Arrays.toString(a) + "\n" + "Sum of array is : " + sum + "\n" + "Average of array is : " + avg); 
        System.exit(0);
    }
    
}
