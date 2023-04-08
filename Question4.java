//제로베이스백엔드스쿨12기 유도경
package revision.question4;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Question4 {
    public static void main(String[] args) {
        Scanner residentRegistrationNumber = new Scanner(System.in);
        int yearOfBirth = 0, monthOfBirth=0, dateOfBirth=0,genderNumber=0;
        String gender;
        boolean wrongInput=false;
        StringBuilder totalNumber = new StringBuilder();



        System.out.println("[주민등록번호 계산]");

        System.out.print("출생년도를 입력해 주세요.(yyyy): ");
           try{yearOfBirth = residentRegistrationNumber.nextInt();
               if(Integer.toString(yearOfBirth).length()!= 4){
                   wrongInput=true;
                   System.out.println("==== 잘못 된 입력입니다.====");
               }
           }catch (InputMismatchException e){
               wrongInput=true;
               System.out.println("==== 잘못 된 입력입니다.====");
           }




        System.out.print("출생월을 입력해 주세요.(mm): ");  //두자리 형식 만들기
        try{ monthOfBirth = residentRegistrationNumber.nextInt();
            if(monthOfBirth<0||monthOfBirth>12){
                wrongInput=true;
                System.out.println("==== 잘못 된 입력입니다.====");
            }
        }catch (InputMismatchException e){
            wrongInput=true;
            System.out.println("==== 잘못 된 입력입니다.====");
        }






        System.out.print("출생일을 입력해 주세요.(dd): ");
        try{ dateOfBirth =residentRegistrationNumber.nextInt();
            if(dateOfBirth<0||dateOfBirth>31){
                wrongInput=true;
                System.out.println("==== 잘못 된 입력입니다.====");
            }
        }catch (InputMismatchException e){
            wrongInput=true;
            System.out.println("==== 잘못 된 입력입니다.====");
        }




        System.out.print("성별을 입력해 주세요.(m/f): ");
        try{ gender=residentRegistrationNumber.next();
            if(!(gender.equals("m") || gender.equals("f"))){
                wrongInput=true;
                System.out.println("==== 잘못 된 입력입니다.====");
            }else if(gender.equals("m")){
                genderNumber=3;
            }else genderNumber = 4;
        }catch (InputMismatchException e){
            wrongInput=true;
            System.out.println("==== 잘못 된 입력입니다.====");
        }




        Random random= new Random();

        StringBuilder backDigits= new StringBuilder();

        for(int i=0; i<6;i++){
            backDigits.append(random.nextInt(9));
        }



       if(wrongInput){
           System.out.println("주민번호를 생성할 수 없습니다.\n잘못된 입력이 있는지 확인하십시오.");
       }else{
           totalNumber.append(Integer.toString(yearOfBirth).substring(2));
           totalNumber.append(String.format("%02d",monthOfBirth));
           totalNumber.append(String.format("%02d",dateOfBirth));
           totalNumber.append("-");
           totalNumber.append(genderNumber);
           totalNumber.append(backDigits);
       }

        System.out.println(totalNumber);

        residentRegistrationNumber.close();
    }


}
