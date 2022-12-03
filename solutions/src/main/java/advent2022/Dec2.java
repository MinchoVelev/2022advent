package advent2022;

import java.io.IOException;
import java.util.Scanner;

import advent2022.utils.IOUtils;

public class Dec2 {
    private Dec2() {
    }

    public static void main(String[] args) throws IOException {
        try (Scanner scanner = IOUtils.getScanner("Dec2.input", Dec2.class)) {
            int oponent;
            int me;
            int score = 0;
            while(scanner.hasNext()){
                String line = scanner.nextLine();
                oponent = line.charAt(0) - 'A' + 1;
                me = line.charAt(2) - 'X' + 1;
                
                int outcome = me - oponent;
                score += me;

                if(outcome == 0){
                    score += 3;
                }else if(outcome == -2 || outcome == 1){
                    score += 6;
                }
            }
            System.out.println(score);


            //   2 3 1
            //   1 2 3
            //   1 1 -2 
        }
    }
    
}
