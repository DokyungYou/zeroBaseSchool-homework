//제로베이스백엔드스쿨12기 유도경
package revision.question7;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;



public class Question7 {
    public static void main(String[] args) {
        Scanner lotoo = new Scanner(System.in);
        int numberOfPurchases = 0;
        char abc = 'A';
        Random number = new Random();
        int[][] purchasedLotto = new int[0][];


        System.out.println("[로또 당첨 프로그램]\n");
        System.out.print("로또 개수를 입력해 주세요.(숫자 1~ 10): ");
        try {numberOfPurchases = lotoo.nextInt();
            if(numberOfPurchases>10){
            numberOfPurchases=10;
                System.out.println("10개까지만 구매가능합니다.");
            } else if (numberOfPurchases<=0) {
                System.out.println("구매한 로또가 없습니다.");
            }
        }catch (InputMismatchException e){
            System.out.println("잘못 된 입력입니다.");
        }


        try {
            purchasedLotto = new int[numberOfPurchases][6];
        }catch (NegativeArraySizeException e){
            System.out.println();
        }


        for (int i = 0; i < purchasedLotto.length; i++) {
            System.out.print((char) (abc + i) + "\t");
            for (int j = 0; j < 6; j++) {
               int rNumber= number.nextInt(45) + 1;
                for(int k=0; k<j; k++){
                   while(purchasedLotto[i][k]==rNumber){
                       rNumber= number.nextInt(45) + 1;
                   }
                    purchasedLotto[i][j] = rNumber;
               }



                if (j == 6 - 1) {
                    System.out.printf("%02d\n", purchasedLotto[i][j]);
                } else
                    System.out.printf("%02d,", purchasedLotto[i][j]);
            }

        }


        System.out.println();
        System.out.println("[로또 발표]");
        int[] lottoWinningNumbers = new int[6];

        System.out.print("\t");
        for (int i = 0; i < lottoWinningNumbers.length; i++) {
            lottoWinningNumbers[i] = number.nextInt(45) + 1;

            if (i == lottoWinningNumbers.length - 1) {
                System.out.printf("%02d\n", lottoWinningNumbers[i]);
            } else
                System.out.printf("%02d,", lottoWinningNumbers[i]);
        }


        System.out.println();
        System.out.println("[내 로또 결과]");

        int numberOfWinnings = 0;


        for (int i = 0; i < purchasedLotto.length; i++) {
            System.out.print((char) (abc + i) + "\t");
            for (int j = 0; j < purchasedLotto[i].length; j++) {

                if (purchasedLotto[i][j] == lottoWinningNumbers[j]) {
                    numberOfWinnings++;
                } System.out.printf("%02d,", purchasedLotto[i][j]);
            }
            System.out.println(" => " + numberOfWinnings + "개 일치");
            numberOfWinnings =0;

        }
        lotoo.close();
    }
}













