//제로베이스백엔드스쿨12기 유도경
package revision.question6;
import java.util.Random;



public class Question6 {
    public static void main(String[] args) {

        Random randomVote = new Random();
        double[] voteResult ={0,0,0,0};
        String[] candidate={"이재명","윤석열","심상정","안철수"};


        for(int i=1; i<=10000; i++){
            int vote =randomVote.nextInt(4);
            voteResult[vote]++;
            System.out.printf("[투표진행율]: %6.2f%%, %d명 투표 => %s\n",(double)i/10000*100,i,candidate[vote]);

            for(int j=0; j<4; j++){
                System.out.printf("[기호:%d] %s: %6.2f%%, (투표수: %d)\n",j,candidate[j],voteResult[j]/10000*100,(int)voteResult[j]);
            }
            System.out.println();
        }


    if(voteResult[0]>voteResult[1] && voteResult[0]>voteResult[2] && voteResult[0]>voteResult[3]){
        System.out.println("[투표결과] 당선인:" + candidate[0]);
    }else if(voteResult[1]>voteResult[0] && voteResult[1]>voteResult[2] && voteResult[1]>voteResult[3] ){
        System.out.println("[투표결과] 당선인:" + candidate[1]);
    } else if (voteResult[2]>voteResult[0] && voteResult[2]>voteResult[1] && voteResult[2]>voteResult[3]) {
        System.out.println("[투표결과] 당선인:" + candidate[0]);
    } else if (voteResult[3]>voteResult[0] && voteResult[3]>voteResult[1] && voteResult[3]>voteResult[2]) {
        System.out.println("[투표결과] 당선인:" + candidate[3]);
    }else {
        System.out.println("[투표결과] 당선인: 당선인이 없습니다.");
        }
    }
}







