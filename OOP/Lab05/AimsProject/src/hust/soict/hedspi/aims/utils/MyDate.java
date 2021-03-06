package hust.soict.hedspi.aims.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Scanner;

public class MyDate {
    private int day;
    private int month;
    private int year;

    //week4
    private static HashMap<String,Integer> s_map_i = new HashMap<String,Integer>(); 
    private static HashMap<Integer,String> i_map_s = new HashMap<Integer,String>();
    //week4
    static{
    
        String[] str_day = {"first", "second", "third", "fourth", "fifth", "sixth", "seventh", "eighth", "ninth", "tenth",
        "eleventh", "twelfth", "thirdteenth", "fourteenth", "fifteenth", "sixteenth", "seventeenth", "eighteenth",
        "nineteenth", "twenty", "twenty-first", "twenty-second", "twenty-third", "twenty-fourth", "twenty-fifth",
        "twenty-sixth", "twenty-seventh", "twenty-eighth", "twenty-ninth", "thirty", "thirty-first"};

        String[] str_month = {"January", "February", "March", "April", "May", "June", "July", "August", "September", 
        "October", "November", "December"};

        String[] str_year = {"twenty-one", "twenty-two", "twenty-three", "twenty-four", "twenty-five", "twenty-six",
        "twenty-seven", "twenty-eight", "twenty-nine"};

        for(int i = 0 ; i < 31 ; i++)
        {
            s_map_i.put(str_day[i].toLowerCase(), i+1); // cho vao mang (first 1)
        }

        for(int i = 0 ; i < 12 ; i++)
        {
            s_map_i.put(str_month[i].toLowerCase(), i+1);
            i_map_s.put(i+1, str_month[i]); 
        }

        for(int i = 0 ; i < str_year.length ; i++)
        {
            s_map_i.put(str_year[i].toLowerCase(), i+21);
        }

    }

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

    //week4

    public MyDate(String day, String month, String year){
        try{
            int intDay = s_map_i.get(day.toLowerCase()); //lay day tu trong map , tra ve int
            int intMonth = s_map_i.get(month.toLowerCase());
            String[] split_year = year.split(" "); // tach 2 tu
            String strYear = s_map_i.get(split_year[0]).toString() + s_map_i.get(split_year[1]).toString();
            int intYear = Integer.parseInt(strYear);

            System.out.println("" + intDay + "_" + intMonth + "_" + intYear);
            LocalDate date = LocalDate.parse(intDay + "/" + intMonth + "/" + intYear, DateTimeFormatter.ofPattern("d/M/yyyy")); // neu nhap sai dua ve ngay mac dinh
            this.day = date.getDayOfMonth();
            this.month = date.getMonthValue();
            this.year = date.getYear();
        }
        catch(Exception e){
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

    public void print_int() {
        System.out.println("" + this.day + "-" + this.month + "-" + this.year);
    }
    
    //week4

    public void print() {
        String output = i_map_s.get(month) + " " + day;
        switch(day)
        {
            case 1:
            output += "st"; //1st
            break;
            case 2:
            output += "nd"; //2nd
            break;
            case 3:
            output += "rd"; //3rd
            break;
            default:
            output += "th";
            break;
        }
        output += " " + year; 
        System.out.println("Date : " + output);
    }
    
}
