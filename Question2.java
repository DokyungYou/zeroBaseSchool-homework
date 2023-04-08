//제로베이스백엔드스쿨12기 유도경
package revision.question2;

import java.util.InputMismatchException;
import java.util.Scanner;



public class Question2 {
    public static void main(String[] args) {
        Scanner cashbackCalculation= new Scanner(System.in);
        int payment;
        int cashback;

        System.out.println("[캐시백 계산]"); 
        System.out.print("결제 금액을 입력해 주세요.(금액):");

        try{payment = cashbackCalculation.nextInt();

            if(payment<0) {
                System.out.println("잘못된 입력입니다.");
            }else{
                cashback =(int)(payment*0.1);
                if(cashback>300){cashback=300;}
                System.out.println("결제 금액은 "+ payment +"이고, 캐시백은 "+ cashback +"원 입니다.");
            }

         }catch (InputMismatchException e){
        System.out.println("잘못 된 입력입니다.");
        }



        cashbackCalculation.close();

















    }
}
