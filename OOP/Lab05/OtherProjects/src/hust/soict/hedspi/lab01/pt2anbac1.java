import javax.swing.JOptionPane;
public class pt2anbac1 {
    public static void main(String[] args) {
        String strNum1, strNum2, strNum3, strNum4, strNum5, strNum6;
        String S = "";
        double num1, num2, num3, num4, num5, num6, x1, x2, D, D1, D2;
        JOptionPane.showMessageDialog(null, "Phuong trinh 2 an bac 1 co dang :\n" + "a11x1 + a12x2 = b1" + "\n" + "a21x1 + a22x1 = b2");
        strNum1 = JOptionPane.showInputDialog(null,"a11 = " ,"Input", JOptionPane.INFORMATION_MESSAGE);
        strNum2 = JOptionPane.showInputDialog(null,"a12 = " ,"Input", JOptionPane.INFORMATION_MESSAGE);
        strNum3 = JOptionPane.showInputDialog(null,"b1 = " ,"Input", JOptionPane.INFORMATION_MESSAGE);
        strNum4 = JOptionPane.showInputDialog(null,"a21 = " ,"Input", JOptionPane.INFORMATION_MESSAGE);
        strNum5 = JOptionPane.showInputDialog(null,"a22 = " ,"Input", JOptionPane.INFORMATION_MESSAGE);
        strNum6 = JOptionPane.showInputDialog(null,"b2 = " ,"Input", JOptionPane.INFORMATION_MESSAGE);
        num1 = Double.parseDouble(strNum1);
        num2 = Double.parseDouble(strNum2);
        num3 = Double.parseDouble(strNum3);
        num4 = Double.parseDouble(strNum4);
        num5 = Double.parseDouble(strNum5);
        num6 = Double.parseDouble(strNum6);
        D = num1*num5 - num4*num2;
        D1 = num3*num5 - num6*num2;
        D2 = num1*num6 - num4*num3;
        if (D !=0 )
        {
            x1 = D1/D;
            x2 = D2/D;
            S = "(x1,x2) = " + "(" + x1 + "," + x2 + " )";
        }
        else
        {
            if ( D1 == 0 && D2 == 0 )
            {
                S = "He co vo so nghiem";
            }
            else
            {
                S = " He vo nghiem";
            }
        }
        JOptionPane.showMessageDialog(null, S, "Ket Qua : ",JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
    
}
