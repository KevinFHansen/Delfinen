package results;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class CompetitiveResult extends Result{
    double time;
    ArrayList<Result> cR = new ArrayList<>();
    Scanner scn = new Scanner(System.in);
    File f = new File("Delfin/Ressources/Competitive.csv");

    public CompetitiveResult(String memberName, String gender, double time, int distance, String discipline, int rankInClub, String date, String competitionName, int competitionPlacement) {
        super(memberName, gender, time, distance, discipline, rankInClub, date, competitionName, competitionPlacement);
    }


    public ArrayList<Result> readResults() throws FileNotFoundException {
        File f = new File("Delfin/Ressources/Competitive.csv");
        Scanner readCsv = new Scanner(f);


        ArrayList<Result> results = new ArrayList<>();

        readCsv.nextLine();

        while (readCsv.hasNext()){
            String currentLine = readCsv.nextLine();

            String[] lineAsArray = currentLine.split(";");

            String membername = lineAsArray[0];
            String gender = lineAsArray[1];
            double time = Double.parseDouble(lineAsArray[2]);
            double distance = Double.parseDouble(lineAsArray[3]);
            String discipline = lineAsArray[4];
            int rankInClub = Integer.parseInt(lineAsArray[5]);
            String date = lineAsArray[6];
            String competitionName = lineAsArray[7];
            int competitionPlacement = Integer.parseInt(lineAsArray[8]);

            CompetitiveResult tmpCompetitiveResult = new CompetitiveResult(membername, gender, time, distance, discipline, rankInClub, date, competitionName, competitionPlacement);
            cR.add(tmpCompetitiveResult);
        }
        return cR;
    }

    public void registerResult(ArrayList<Result> cR) throws IOException {
        System.out.println("Write members name: ");
        String memberName = scn.next();

        System.out.println("Write gender of competitor: ");
        String gender = scn.next();

        System.out.println("Type in time: ");
        double time = scn.nextDouble();

        System.out.println("Type distance: ");
        int distance = scn.nextInt();

        System.out.println("Type in disciplin: ");
        String disciplin = scn.next();

        System.out.println("Write rank in club: ");
        int rankInClub = scn.nextInt();

        System.out.println("Write the date: ");
        String date = scn.next();

        System.out.println("Write the name of the competition: ");
        String competitionName = scn.next();

        System.out.println("Write the placement at the competition: ");
        int competitionPlacement = scn.nextInt();

        CompetitiveResult register = new CompetitiveResult(memberName, gender, time, distance, disciplin, rankInClub, date, competitionName, competitionPlacement);
        cR.add(register);
        printResults(cR);
    }

    public void printResults(ArrayList<Result> results) throws IOException {
        File f = new File("Delfin/Ressources/Competitive.csv");
        PrintWriter writer = new PrintWriter(f);
        writer.print("");
        writer.println("memberName;gender;time;distance;disciplin;rankInClub;date;competitionName;competitionPlacement");
        for(int i = 0; i < cR.size(); i++){
            writer.print(cR.get(i).getMemberName() + ";");
            writer.print(cR.get(i).getGender() + ";");
            writer.print(cR.get(i).getTime() + ";");
            writer.print(cR.get(i).getDistance() + ";");
            writer.print(cR.get(i).getDiscipline() + ";");
            writer.print(cR.get(i).getRankInClub() + ";");
            writer.print(cR.get(i).getDate() + ";");
            writer.print(cR.get(i).getCompetitionName() + ";");
            writer.println(cR.get(i).getCompetitionPlacement() + "");

        }
        writer.close();
    }

    public void top5Menu(){
        System.out.println("Choose Top5 list");
        System.out.println("1. Crawl/Men/100 Meters");
        System.out.println("2. Crawl/Men/200 Meters");
        System.out.println("3. Crawl/Female/100 Meters");
        System.out.println("4. Crawl/Female/200 Meters");
        System.out.println("5. BreastStroke/Men/100 Meters");
        System.out.println("6. BreastStroke/Men/200 Meters");
        System.out.println("7. BreastStroke/Female/100 Meters");
        System.out.println("8. BreastStroke/Female/200 Meters");
        System.out.println("9. BackCrawl/Men/100 Meters");
        System.out.println("10. BackCrawl/Men/200 Meters");
        System.out.println("11. BackCrawl/Female/100 Meters");
        System.out.println("12. BackCrawl/Female/200 Meters");
        System.out.println("0. Back");
    }

    public void viewTop5() throws FileNotFoundException {
        Scanner readCsv = new Scanner(f);

        while(readCsv.hasNext()){
            String currentLine = readCsv.nextLine();

            String[] csvAsArray = currentLine.split(";");

            String memberName = csvAsArray[0];
            String gender = csvAsArray[1];
            double time = Double.parseDouble(csvAsArray[2]);
            double distance = Double.parseDouble(csvAsArray[3]);
            String discilpline = csvAsArray[4];

            int userInput = scn.nextInt();

            top5Menu();
    public void viewTop5() throws FileNotFoundException {
        Scanner readCsv = new Scanner(f);
        readCsv.nextLine();
        System.out.println(cR);

        while(readCsv.hasNext()){
            String currentLine = readCsv.nextLine();

            String[] csvAsArray = currentLine.split(";");

            String membername = csvAsArray[0];
            String gender = csvAsArray[1];
            double time = Double.parseDouble(csvAsArray[2]);
            int distance = Integer.parseInt(csvAsArray[3]);
            String discipline = csvAsArray[4];
            int rankInClub = Integer.parseInt(csvAsArray[5]);
            String date = csvAsArray[6];
            String competitionName = csvAsArray[7];
            int competitionPlacement = Integer.parseInt(csvAsArray[8]);

            if(discipline == "crawl" && gender == "male" && distance == 100){
                Collections.sort(cR);
            }

            /*

            int userInput = scn.nextInt();

            System.out.println("Choose Top5 list");
            System.out.println("1. Crawl/Men/100 Meters");
            System.out.println("2. Crawl/Men/200 Meters");
            System.out.println("3. Crawl/Female/100 Meters");
            System.out.println("4. Crawl/Female/200 Meters");
            System.out.println("5. BreastStroke/Men/100 Meters");
            System.out.println("6. BreastStroke/Men/200 Meters");
            System.out.println("7. BreastStroke/Female/100 Meters");
            System.out.println("8. BreastStroke/Female/200 Meters");
            System.out.println("9. BackCrawl/Men/100 Meters");
            System.out.println("10. BackCrawl/Men/200 Meters");
            System.out.println("11. BackCrawl/Female/100 Meters");
            System.out.println("12. BackCrawl/Female/200 Meters");
            System.out.println("0. Back");

            switch (userInput){

                case 1:
                    System.out.println("Top 5 - Crawl/Men/100 Meters");
                    //PRINT TOP5
                    break;

                case 2:
                    System.out.println("Top 5 - Crawl/Men/200 Meters");
                    //PRINT TOP5
                    break;

                case 3:
                    System.out.println("Top 5 - Crawl/Female/100 Meters");
                    //PRINT TOP5
                    break;

                case 4:
                    System.out.println("Top 5 - Crawl/Female/200 Meters");
                    //PRINT TOP5
                    break;

                case 5:
                    System.out.println("Top 5 - BreastStroke/Men/100 Meters");
                    //PRINT TOP5
                    break;

                case 6:
                    System.out.println("Top 5 - BreastStroke/Men/200 Meters");
                    //PRINT TOP5
                    break;

                case 7:
                    System.out.println("Top 5 - BreastStroke/Female/100 Meters");
                    //PRINT TOP5
                    break;

                case 8:
                    System.out.println("Top 5 - BreastStroke/Female/200 Meters");
                    //PRINT TOP5
                    break;

                case 9:
                    System.out.println("Top 5 - BackCrawl/Men/100 Meters");
                    //PRINT TOP5
                    break;

                case 10:
                    System.out.println("Top 5 - BackCrawl/Men/200 Meters");
                    //PRINT TOP5
                    break;

                case 11:
                    System.out.println("Top 5 - BackCrawl/Female/100 Meters");
                    //PRINT TOP5
                    break;

                case 12:
                    System.out.println("Top 5 -  BackCrawl/Female/200 Meters");
                    //PRINT TOP5
                    break;







            }


            String choice = scn.next();
            double choice1 = scn.nextDouble();

            switch (userInput){

                case 1:
                    System.out.println("Crawl");
                    System.out.println("Choose Male or Female");

                    if (choice == "Male" && choice1 == 100){
                        //DO STUFF
                        //DO STUFF
                    }
                    else if (choice == "Male" && choice1 == 100){
                        //DO STUFF
                        //DO STUFF
                    }
                    else if (choice == "Female" && choice1 == 100){
                        //DO STUFF
                        //DO STUFF
                    }
                    else if (choice == "Female" && choice1 == 200){
                        //DO STUFF
                        //DO STUFF
                    }
                    else {
                        System.out.println("Wrong input");
                    }
                    break;

                case 2:
                    System.out.println("Breaststroke");
                    System.out.println("Choose Male or Female");

                    if (choice == "Male" && choice1 == 100){
                        //DO STUFF
                        //DO STUFF
                    }
                    else if (userInput == 2 && choice == "Male" && choice1 == 100){
                        //DO STUFF
                        //DO STUFF
                    }
                    else if (choice == "Female" && choice1 == 100){
                        //DO STUFF
                        //DO STUFF
                    }
                    else if (choice == "Female" && choice1 == 200){
                        //DO STUFF
                        //DO STUFF
                    }
                    else {
                        System.out.println("Wrong input");
                    }

                case 3:
                    System.out.println("Back");
                    break;
            }
*/
        }


    }

    public static void main(String[] args) throws IOException {
        CompetitiveResult n = new CompetitiveResult(null, null, 0.0, 0, null, 1, null, null, 1);
        //System.out.println(n.readResults());
        //n.registerResult(n.cR);
        n.readResults();
        n.viewTop5();
        System.out.println(n.cR);

    }
    @Override
    public int compareTo(Result other) {

        if (this.time > other.getTime()){
            return 1;
        }
        else if(this.time < other.getTime()){
            return -1;
        }
        else
            return 0;
    }

}
