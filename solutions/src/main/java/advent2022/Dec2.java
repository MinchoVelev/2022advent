package advent2022;

import java.io.IOException;
import java.util.Scanner;

import advent2022.utils.IOUtils;

public class Dec2 {
    private Dec2() {
    }

    public static void main(String[] args) throws IOException {
        try (Scanner scanner = IOUtils.getScanner("Dec2.input", Dec2.class)) {
            int[] maxes = new int[3];
            int curr = 0;

            while (scanner.hasNext()) {
                String line = scanner.nextLine();

                // sum intil new line or end is encountered
                if (scanner.hasNext() && line.length() > 0) {
                    int calories = Integer.parseInt(line);
                    curr += calories;
                    continue;
                }

                for (int i = 0; i < maxes.length; i++) {

                    // if current sum is greater than the max values, find the smallest max and
                    // replace it
                    if (curr > maxes[i]) {
                        int min = maxes[0];
                        int minIndex = 0;
                        for (int j = 1; j < maxes.length; j++) {
                            if (maxes[j] < min) {
                                minIndex = j;
                                min = maxes[j];
                            }
                        }
                        maxes[minIndex] = curr;
                        break;
                    }
                }

                curr = 0;

            }

            int sum = 0;
            for (int c : maxes) {
                System.out.println(c);
                sum += c;
            }
            System.out.println("Total " + sum);
        }
    }
}
