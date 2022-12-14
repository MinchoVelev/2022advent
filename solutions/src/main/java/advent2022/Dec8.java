package advent2022;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import advent2022.utils.IOUtils;

public class Dec8 {
    public static void main(String[] args) {
        System.out.println("Part 1:");
        part1();

        System.out.println("-------------------");

        // System.out.println("Part 2:");
        // part2();
    }

    private static void part1() {
        List<Tree[]> maze = readInput();

        int visible = maze.size() * 2 + (maze.get(0).length - 2) * 2;
        System.out.println(visible);
        System.out.println(Arrays.asList(maze.get(0)));

        asd: for (int i = 1; i < maze.size() - 1; i++) {
            for (int j = 1; j < maze.get(0).length - 1; j++) {
                Tree currTree = maze.get(i)[j];

                // check left
                currTree.visible = true; 
                for (int x = j - 1; x >= 0; x--) {
                    System.out.printf("Checking %s and comparing %d:%d to %d:%d%n", "LEFT", i, j, i, x);
                    if (maze.get(i)[x].hight >= currTree.hight) {
                        currTree.visible = false;
                        break;
                    }
                }
                if (currTree.visible) {
                    visible += 1;
                    continue asd;
                }

                currTree.visible = true;
                // check right
                for (int x = j + 1; x < maze.get(0).length; x++) {
                    System.out.printf("Checking %s and comparing %d:%d to %d:%d%n", "RIGHT", i, j, i, x);
                    if (maze.get(i)[x].hight >= currTree.hight) {
                        currTree.visible = false;
                        break;
                    }
                }
                if (currTree.visible) {
                    visible += 1;
                    continue asd;
                }

                

                currTree.visible = true;
                // check up
                for (int y = i - 1; y >= 0; y--) {
                    System.out.printf("Checking %s and comparing %d:%d to %d:%d%n", "UP", i, j, y, j);
                    if (maze.get(y)[j].hight >= currTree.hight) {
                        currTree.visible = false;
                        break;
                    }
                }
                if (currTree.visible) {
                    visible += 1;
                    continue asd;
                }
                
                currTree.visible = true;
                // check down
                
                for (int y = i + 1; y < maze.size(); y++) {
                    System.out.printf("Checking %s and comparing %d:%d to %d:%d%n", "DOWN", i, j, y, j);
                    if (maze.get(y)[j].hight >= currTree.hight) {
                        currTree.visible = false;
                        break;
                    }
                }
                if (currTree.visible) {
                    visible += 1;
                    continue asd;
                }
            }
        }

        System.out.println("Visible tress: " + visible);
    }

    private static List<Tree[]> readInput() {
        List<Tree[]> rows = new ArrayList<>(100);
        try (Scanner scanner = IOUtils.getScanner("Dec8.input", Dec8.class)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                Tree[] row = new Tree[line.length()];
                for (int i = 0; i < line.length(); i++) {
                    row[i] = new Tree(line.charAt(i) - '0');
                }
                rows.add(row);
            }
        }
        return rows;
    }

    static class Tree {
        boolean visible = true;
        int hight;

        Tree(int hight) {
            this.hight = hight;
        }

        @Override
        public String toString() {
            return hight + "";
        }
    }
}
