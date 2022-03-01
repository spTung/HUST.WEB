import javax.swing.JOptionPane;

public class pt1anbac2 {
    public static void main(String[] args) {
        String strNum1, strNum2, strNum3;
        Double num1, num2, num3, delta, x, x1, x2;
        String S = "";
        JOptionPane.showMessageDialog(null, "Phuong trinh 1 an bac 2 co dang :\t" + "ax^2 + bx + c = 0 (a != 0)");
        strNum1 = JOptionPane.showInputDialog(null,"a = " ,"Input", JOptionPane.INFORMATION_MESSAGE);
        num1 = Double.parseDouble(strNum1);
        while (num1 == 0)
        {
            JOptionPane.showMessageDialog(null, "Co so a phai khac 0, nhap lai a");
            strNum1 = JOptionPane.showInputDialog(null,"a = " ,"Input", JOptionPane.INFORMATION_MESSAGE);
            num1 = Double.parseDouble(strNum1);
        }
            strNum2 = JOptionPane.showInputDialog(null,"b = " ,"Input", JOptionPane.INFORMATION_MESSAGE);
            strNum3 = JOptionPane.showInputDialog(null,"c = " ,"Input", JOptionPane.INFORMATION_MESSAGE);
            num2 = Double.parseDouble(strNum2);
            num3 = Double.parseDouble(strNum3);
            delta = num2*num2 - 4*num1*num3;
            if (delta == 0)
            {   
                x = -num2/(2*num1);
                S = "Phuong trinh co nghiem kep:  " + "x1 = x2 = " + x;
            }
            else 
            {
                if (delta > 0)
                {
                    delta  = Math.sqrt(delta);
                    x1 = (-num2 + delta) / (2*num1);
                    x2 = (-num2 - delta) / (2*num1);
                    S = "Phuong trinh co 2 nghiem phan biet: " + "x1 = " + x1 + ", x2 = " + x2;
                    
                }
                else
                {
                    S = "Phuong trinh vo nghiem";
                }
            }
        JOptionPane.showMessageDialog(null, S, "Ket Qua : ",JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}