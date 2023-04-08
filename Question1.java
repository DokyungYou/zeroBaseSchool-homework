//제로베이스백엔드스쿨12기 유도경
package revision.question1;

public class Question1 {
    public static void main(String[] args) {
        System.out.println("[구구단 출력]");
        for(int i=1; i<10; i++){
            for(int times=1; times<10; times++){
                System.out.printf("%02d x %02d = %02d \t",times, i,times*i);
             }
                System.out.println();
          }
        }
    }
