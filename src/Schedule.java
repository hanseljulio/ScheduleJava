import java.util.*;
import java.io.*;

public class Schedule {

    public static void main(String[] args) throws IOException{
        Scanner console = new Scanner(System.in);
        int choice = 1;

        List<String> first = new ArrayList<>();
        List<String> second = new ArrayList<>();
        List<String> third = new ArrayList<>();
        List<String> fourth = new ArrayList<>();
        List<String> fifth = new ArrayList<>();

        first.add("-");
        first.add("-");
        first.add("-");
        first.add("-");
        first.add("-");

        second.add("-");
        second.add("-");
        second.add("-");
        second.add("-");
        second.add("-");

        third.add("-");
        third.add("-");
        third.add("-");
        third.add("-");
        third.add("-");

        fourth.add("-");
        fourth.add("-");
        fourth.add("-");
        fourth.add("-");
        fourth.add("-");

        fifth.add("-");
        fifth.add("-");
        fifth.add("-");
        fifth.add("-");
        fifth.add("-");

        while(choice != 4) {
            Scanner in = new Scanner(System.in);
            System.out.println("YOUR SCHEDULE:");
            System.out.println("|No|   Monday   |   Tuesday   |   Wednesday   |   Thursday   |   Friday   |");
            for (int i = 0; i < first.size(); i++){
                System.out.printf("|%-2d|%-8s    |%-8s     |%-8s       |%-8s      |%-7s     |  ", (i + 1), first.get(i), second.get(i), third.get(i), fourth.get(i), fifth.get(i));
                System.out.println();
            }

            System.out.println("[1] Add/replace class " + "[2] Remove class " + "[3] Clear all " + "[4] Export Data " + "[5] Exit");
            System.out.print("Input number > ");
            choice = console.nextInt();

            if (choice == 1) {
                System.out.print("Day > ");
                String replaceDay = console.next();
                System.out.print("Input subject > ");
                String subjectName = in.nextLine();
                System.out.print("Column number > ");
                int replaceCol = console.nextInt();
                replace(first, second, third, fourth, fifth, replaceDay, subjectName, replaceCol);
            } else if (choice == 2) {
                System.out.print("Day > ");
                String replaceDay = console.next();
                System.out.print("Input subject > ");
                String subjectName = in.nextLine();
                delete(first, second, third, fourth, fifth, replaceDay, subjectName);
            } else if (choice == 3){
                clearAll(first, second, third, fourth, fifth);
            } else if (choice == 4) {
                fileWriter(first, second, third, fourth, fifth);
            } else if (choice > 5 || choice < 1){
                System.out.println("INVALID - PLEASE RETRY");
            }
            clrscr();
        }
    }

    public static void fileWriter(List<String> first, List<String> second, List<String> third, List<String> fourth, List<String> fifth) throws IOException {
        File file = new File("Schedule.txt");
        PrintStream fileWriter = new PrintStream(file);
        fileWriter.println("|No|   Monday   |   Tuesday   |   Wednesday   |   Thursday   |   Friday   |");
        for (int i = 0; i < first.size(); i++){
            fileWriter.printf("|%-2d|%-8s    |%-8s     |%-8s       |%-8s      |%-7s     |  ", (i + 1), first.get(i), second.get(i), third.get(i), fourth.get(i), fifth.get(i));
            fileWriter.println();
        }
    }

    public static void clrscr(){
        //Clears Screen in java
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ex) {}
    }

    public static void replace(List<String> first, List<String> second, List<String> third, List<String> fourth, List<String> fifth, String replaceDay, String subjectName, int replaceCol) {
        if (replaceDay.toLowerCase().equals("monday")) {
            first.set(replaceCol - 1, subjectName);
        } else if (replaceDay.toLowerCase().equals("tuesday")) {
            second.set(replaceCol - 1, subjectName);
        } else if (replaceDay.toLowerCase().equals("wednesday")){
            third.set(replaceCol - 1, subjectName);
        } else if (replaceDay.toLowerCase().equals("thursday")){
            fourth.set(replaceCol - 1, subjectName);
        } else if (replaceDay.toLowerCase().equals("friday")){
            fifth.set(replaceCol - 1, subjectName);
        } else {
            System.out.println("INVALID - PLEASE RETRY");
        }
    }

    public static void delete(List<String> first, List<String> second, List<String> third, List<String> fourth, List<String> fifth, String replaceDay, String subjectName) {
        if (replaceDay.toLowerCase().equals("monday")) {
            first.set(first.indexOf(subjectName), "-");
        } else if (replaceDay.toLowerCase().equals("tuesday")) {
            second.set(second.indexOf(subjectName), "-");
        } else if (replaceDay.toLowerCase().equals("wednesday")){
            third.set(third.indexOf(subjectName), "-");
        } else if (replaceDay.toLowerCase().equals("thursday")){
            fourth.set(fourth.indexOf(subjectName), "-");
        } else if (replaceDay.toLowerCase().equals("friday")){
            fifth.set(fifth.indexOf(subjectName), "-");
        } else {
            System.out.println("INVALID - PLEASE RETRY");
        }
    }

    public static void clearAll(List<String> first, List<String> second, List<String> third, List<String> fourth, List<String> fifth) {
        for (int i = 0; i < first.size(); i++) {
            first.set(i, "-");
            second.set(i, "-");
            third.set(i, "-");
            fourth.set(i, "-");
            fifth.set(i, "-");
        }
    }
}
