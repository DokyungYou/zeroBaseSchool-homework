//제로베이스백엔드스쿨12기 유도경
package revision.question8;
import java.util.Scanner;



public class Question8 {
    public static void main(String[] args) {
        Scanner taxableAmount = new Scanner(System.in);
        long annualIncome;
        long taxDeductionCalculation;
        int taxBaseNumber;
        int taxRateResult=0;



        System.out.println("[과세금액 계산 프로그램]");
        System.out.print("연소득을 입력해 주세요.: ");
        annualIncome= taxableAmount.nextLong();


        double[] taxRate ={0.06, 0.15, 0.24, 0.35, 0.38, 0.40, 0.42, 0.45};
        int[] subTax ={12000000,34000000,42000000,62000000,150000000,200000000,500000000,1000000000};


        //적용된 과세표준계산  &누진공제계산 의한 세금
        if(annualIncome<=12000000){
            taxBaseNumber=0;
            taxDeductionCalculation=(long)(annualIncome*0.06);

        }else if(annualIncome<=46000000){
            taxBaseNumber=1;
            taxDeductionCalculation=(long)(annualIncome*0.15)-1080000;
        }
        else if (annualIncome<=88000000) {
            taxBaseNumber=2;
            taxDeductionCalculation= (long)(annualIncome*0.24)-5220000;
        }
        else if (annualIncome<=150000000) {
            taxBaseNumber=3;
            taxDeductionCalculation= (long)(annualIncome*0.35)-14900000;
        }
        else if(annualIncome<=300000000){
            taxBaseNumber=4;
            taxDeductionCalculation= (long)(annualIncome*0.38)-19400000;
        }
        else if(annualIncome<=500000000){
            taxBaseNumber=5;
            taxDeductionCalculation= (long)(annualIncome*0.40)-25400000;
        }
        else if (annualIncome<=1000000000) {
            taxBaseNumber=6;
            taxDeductionCalculation=(long)(annualIncome*0.42)-35400000;
        }
        else{
            taxBaseNumber=7;
            taxDeductionCalculation= (long)(annualIncome*0.45)-65400000;
        }

        //세금계산
        for(int i=0; i<=taxBaseNumber; i++){
            if(annualIncome<=subTax[i]){
                System.out.printf("%10d * %2d%% =\t%10d\n", annualIncome, (int)(taxRate[i]*100), (int)(annualIncome*taxRate[i]));

                taxRateResult+=(int)(annualIncome*taxRate[i]);
            }else{
                System.out.printf("%10d * %2d%% =\t%10d\n", subTax[i], (int)(taxRate[i]*100), (int)(subTax[i] * taxRate[i]));
                annualIncome-=subTax[i];
                taxRateResult+=(int)(subTax[i] * taxRate[i]);
            }
        }

        System.out.println();
        System.out.printf("[세율에 의한 세금]:\t\t%10d\n",taxRateResult);


        System.out.printf("[누진공제 계산에 의한 세금]:\t%10d", taxDeductionCalculation);
        taxableAmount.close();
    }
}

















