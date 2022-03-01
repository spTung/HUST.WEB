import java.util.Scanner;
public class add_two_samesize_matrices {
    public static void main(String[] args) {
        int a,b;
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Input number of rows of matrix : ");
        a = keyboard.nextInt();
        System.out.print("Input number of columns of matrix : ");
        b = keyboard.nextInt();
        
        int arr1[][] = new int[a][b];
        int arr2[][] = new int[a][b];
        int arr3[][] = new int[a][b];

        //input first matrix
        System.out.println("Input first matrix(arr1)");
        for ( int i = 0 ; i < a ; i++)
        {
            for (int j = 0 ; j < b ; j++)
            {
                System.out.print("arr1[" + i + "][" + j + "] = ");
                arr1[i][j] = keyboard.nextInt();
            }
        }
        //input second matrix
        System.out.println("Input second matrix(arr2)");
        for ( int e = 0 ; e < a ; e++)
        {
            for (int f = 0 ; f < b ; f++)
            {
                System.out.print("arr2[" + e + "][" + f + "] = ");
                arr2[e][f] = keyboard.nextInt();
            }
        }
        // add two matrix
        for (int i = 0 ; i < a ; i++)
        {
            for ( int j = 0 ; j < b ; j++)
            {
                arr3[i][j] = arr1[i][j] + arr2[i][j];
            }
        }
        //print
        System.out.println("First matix :");
        for ( int i = 0 ; i < a ; i++)
        {
            for (int j = 0 ; j < b ; j++)
            {
                System.out.print(arr1[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("Second matix : ");
        for ( int e = 0 ; e < a ; e++)
        {
            for (int f = 0 ; f < b ; f++)
            {
                System.out.print(arr2[e][f] + " ");
            }
            System.out.println();
        }
        System.out.println("Sum of two matrix : ");
        for ( int i = 0 ; i < a ; i++)
        {
            for (int j = 0 ; j < b ; j++)
            {
                System.out.print(arr3[i][j] + " ");
            }
            System.out.println();
        }

        System.exit(0);
    }
    
}
