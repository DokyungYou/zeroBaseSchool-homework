//제로베이스백엔드스쿨12기 유도경
package revision.question3;

import java.util.InputMismatchException;
import java.util.Scanner;
//AmusementParkEntryTime
class AmusementParkTicketOffice {
    private int age;
    private int time;
    private boolean nationalMerit = false;
    private boolean welfareCard = false;
    private boolean wrongInput= false;
    private int basicAdmissionFee = 10000;

    public void setAge(int age) {
        if (age < 0) {
            System.out.println("잘못 된 입력입니다.");
            wrongInput=true;
            return;
        }
        this.age = age;
    }

    public void setTime(int time) {
        if (!(time > 9 && time < 20)) {
            System.out.println("입장시간이 아닙니다.");
            wrongInput=true;
            return;
        }
        this.time = time;
    }

    public void setNationalMerit(String nationalMerit) {
        if (!(nationalMerit.equals("y") || nationalMerit .equals("n"))) {
            System.out.println("잘못 된 입력입니다.");
            wrongInput=true;

        } else if (nationalMerit.equals("y")) {
            this.nationalMerit = true;
        }
    }


    public void setWelfareCard(String welfareCard) {
        if (!(welfareCard.equals("y") || welfareCard.equals("n"))) {
            System.out.println("잘못 된 입력입니다.");
            wrongInput=true;

        } else if (welfareCard.equals("y")) {
            this.welfareCard = true;
        }
    }


    public void ticketCalculation(){

       if(wrongInput) {
           System.out.println("잘못된 입력이 있는지 확인해주십시오.");
           return;
       }

           if(age<3){
               basicAdmissionFee=0;
               System.out.println("3세 미만이므로 무료 입장입니다~ ^^");
           }else{
                if(age<13){
                    basicAdmissionFee-=6000;
               }
                if(time>=17)
                    basicAdmissionFee-=6000;

                if(nationalMerit){
                    basicAdmissionFee-=2000;
                }
                if(welfareCard){
                   basicAdmissionFee-=2000;
               }

                if(basicAdmissionFee<0){
                    basicAdmissionFee=0;
                }

               System.out.println(basicAdmissionFee);

           }

       }

    }


    public class Question3 {
        public static void main(String[] args) {
            Scanner ticketCalculation = new Scanner(System.in);
            AmusementParkTicketOffice ticket = new AmusementParkTicketOffice();


            System.out.println("[입장권 계산]");
            System.out.print("나이를 입력해 주세요.(숫자): ");

           try{ticket.setAge(ticketCalculation.nextInt());
           }catch (InputMismatchException e){
               System.out.println("잘못 된 입력입니다.");
           }


            System.out.print("입장시간을 입력해 주세요.(숫자입력): ");
            try{ticket.setTime(ticketCalculation.nextInt());
            }catch (InputMismatchException e){
                System.out.println("잘못 된 입력입니다.");
            }


            System.out.print("국가유공자 여부를 입력해 주세요.(y/n): ");
            ticket.setNationalMerit(ticketCalculation.next());


            System.out.print("복지카드 여부를 입력해 주세요.(y/n): ");
            ticket.setWelfareCard(ticketCalculation.next());


            System.out.print("입장료: ");
            ticket.ticketCalculation();


            ticketCalculation.close();
        }
    }

















