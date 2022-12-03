package advent2022;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public final class Dec1 {
    private Dec1() {
    }

 
    public static void main(String[] args) throws IOException {
        try(InputStream inputStream = Dec1.class.getResourceAsStream("Dec1.input"); Scanner scanner =  new Scanner(new BufferedInputStream(inputStream), StandardCharsets.UTF_8); ){
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
