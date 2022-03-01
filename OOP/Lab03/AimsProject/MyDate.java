import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class MyDate {
    private int day;
    private int month;
    private int year;

    public MyDate(){
        LocalDate now = LocalDate.now();
        this.day = now.getDayOfMonth();
        this.month = now.getMonthValue();
        this.year = now.getYear();
    }

    public MyDate(int day, int month, int year ){
        try {
            LocalDate now = LocalDate.parse(day + "/" + month + "/" + year, DateTimeFormatter.ofPattern("d/M/yyyy"));
            this.day = now.getDayOfMonth();
            this.month = now.getMonthValue();
            this.year = now.getYear();
            } catch (Exception e) {
            System.out.println("Loi!");
            this.day = 01;
            this.month = 01;
            this.year = 2001;
        }
    }
    
    public MyDate(String strDate){
        accept(strDate);
    }

    public int getDay() {
        return this.day;
    }

    public void setDay(int day) {
        switch(day)
        {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            this.day = 31;
            break;
            case 4:
            case 6:
            case 9:
            case 11:
            this.day = 30;
            break;
            case 2:
            if(this.year % 4 == 0 && this.year % 100 ==0)
            {
                if(this.year % 400 != 0)
                {
                    this.day = 28; // ko nhuan
                }
                else this.day = 29;
            }
            default:
            System.out.println("Loi ngay");
        }
    }

    public int getMonth() {
        return this.month;
    }

    public void setMonth(int month) {
        if (month >= 1 && month <=12)
        {
            this.month = month;
        }
        else
        {
            System.out.println("Loi thang!");
        }
    }

    public int getYear() {
        return this.year;
    }

    public void setYear(int year) {
        if(year > 0 )
        {
            this.year = year;
        }
        else
        {
            System.out.println("Loi nam!");
        }
    }

    public void accept() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter date :" );
        String strDate = keyboard.nextLine();
        accept(strDate);
        }

    public void accept(String strDate) {
        //
        try {
            String date = "[d[-][/][.][ ]M[-][/][.][ ]yyyy]"; //01-01-2001 01/01/2001 01.01.2001 01 01 2001
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(date);
            LocalDate now = LocalDate.parse(strDate, formatter);
            this.day = now.getDayOfMonth();
            this.month = now.getMonthValue();
            this.year = now.getYear();
        } catch (Exception e) {
            System.out.println("Loi!");
            this.day = 01;
            this.month = 01;
            this.year = 2001;
        }
    }

    public void print() {
        System.out.println("Date : " + this.day + "-" + this.month + "-" + this.year);
    }
    
}
