package advent2022;

import java.io.IOException;
import java.util.Scanner;

import advent2022.utils.IOUtils;

public final class Dec1 {
    private Dec1() {
    }

 
    public static void main(String[] args) throws IOException {
        try( Scanner scanner = IOUtils.getScanner("Dec1.input", Dec1.class)){
            int max = 0;
            int curr = 0;
            while(scanner.hasNext()){
                String line = scanner.nextLine();
                if(line.length() == 0){
                    curr = 0;
                    continue;
                }
                int calories = Integer.parseInt(line);
                curr += calories;
                if( curr > max){
                    max = curr;
                }
            }
            System.out.println(max);
        }
    }
}
