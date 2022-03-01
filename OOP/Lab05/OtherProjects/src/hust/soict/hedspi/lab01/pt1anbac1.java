import javax.swing.JOptionPane;
public class pt1anbac1 {
    public static void main(String[] args) {
        String strNum1, strNum2;
        String S = "";
        double num1, num2, x;
        JOptionPane.showMessageDialog(null, "Phuong trinh co dang ax + b = 0");
        strNum1 = JOptionPane.showInputDialog(null," a = ", "Input", JOptionPane.INFORMATION_MESSAGE);
        strNum2 = JOptionPane.showInputDialog(null," b = ", "Input", JOptionPane.INFORMATION_MESSAGE);
        num1 = Double.parseDouble(strNum1);
        num2 = Double.parseDouble(strNum2);
        if (num1 != 0 )
        {
            x = -num2/num1;
            S = "x =  " + x;
        }
        else
        {
            if(num2 == 0) S = "Luon dung voi moi x";
            else
            S = " Khong ton tai x thoa man";
        }
        JOptionPane.showMessageDialog(null, S, "Ket Qua : ",JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);

    }
}
