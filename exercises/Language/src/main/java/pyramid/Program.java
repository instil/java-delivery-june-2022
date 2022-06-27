package pyramid;

import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the size of the pyramid");
        int size = 0;
        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                size = scanner.nextInt();
                break;
            } else {
                System.out.println(scanner.next() + " " + " is invalid - try again");
            }
        }
        System.out.println("Here is a pyramid of size " + size);
        printPyramid(size);
    }

    private static void printPyramid(int height) {
        for (int rowNum = 1; rowNum <= height; rowNum++) {
            printRow(height, rowNum);
        }
    }

    private static void printRow(int height, int rowNum) {
        final int spaces = height - rowNum;
        final int hashes = (rowNum * 2) - 1;

        printSpaces(spaces);
        printHashes(hashes);
        takeNewLine();
    }

    private static void takeNewLine() {
        System.out.println();
    }

    private static void printHashes(int hashes) {
        printRepeatedly(hashes, "#");
    }

    private static void printSpaces(int spaces) {
        printRepeatedly(spaces, " ");
    }

    private static void printRepeatedly(int spaces, String value) {
        for (int j = 0; j < spaces; j++) {
            System.out.print(value);
        }
    }

}
