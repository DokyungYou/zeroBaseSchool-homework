//제로베이스백엔드스쿨12기 유도경
package revision.question5;


import java.time.DateTimeException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Question5 {
    public static void main(String[] args) {
        Scanner myCalendar = new Scanner(System.in);

        int year=-1;
        int month=-1;
        DayOfWeek start = null;
        int totalDay = 0;
        boolean wrongInput=false;


        System.out.println("[달력 출력 프로그램]");
        System.out.print("달력의 년도를 입력해 주세요.(yyyy): ");

       try{year= myCalendar.nextInt();
           if(year<0 || Integer.toString(year).length()>4)
               wrongInput=true;
       }catch(InputMismatchException e){
           wrongInput=true;
           System.out.println("==== 잘못 된 입력입니다.====");
       }

        System.out.print("달력의 월을 입력해 주세요.(mm): ");
        try{month= myCalendar.nextInt();
        }catch(InputMismatchException e){
            wrongInput=true;
            System.out.println("\n==== 잘못 된 입력입니다.====");
        }


        try{LocalDate calender = LocalDate.of(year,month,1);
            totalDay= calender.lengthOfMonth();
            start =calender.getDayOfWeek();
        }catch(DateTimeException | NullPointerException e){
            wrongInput=true;

        }



        int tab=-1;
        try {
            switch (start){
                case SUNDAY: tab=0; break;
                case MONDAY: tab=1; break;
                case TUESDAY: tab=2; break;
                case WEDNESDAY: tab=3; break;
                case THURSDAY: tab=4; break;
                case FRIDAY: tab=5; break;
                case SATURDAY: tab=6;
            }
        }catch (NullPointerException e){
            wrongInput=true;

        }



        if(!wrongInput){
            String monthFormat = String.format("%02d",month);
            System.out.println("["+  year  +"년 "+ monthFormat  + "월]");
            System.out.printf("%s\t%s\t%s\t%s\t%s\t%s\t%s\t\n","일","월","화","수","목","금","토");

            for(int i=1; i<=totalDay+tab; i++ ){
                if(i<1+tab){
                    System.out.print("\t");
                }else{
                    System.out.printf("%02d\t",i-tab);

                    if(i%7==0)
                        System.out.println();
                }

            }
        }else
            System.out.println("==== 달력을 불러올 수 없습니다.====");

        myCalendar.close();
    }
}


























