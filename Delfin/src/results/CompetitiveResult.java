package results;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class CompetitiveResult extends Result{

    ArrayList<Result> cR = new ArrayList<>();
    Scanner scn = new Scanner(System.in);
    File f = new File("Delfin/Ressources/Competitive.csv");

    public CompetitiveResult(String memberName, String gender, double time, double distance, String discipline, int rankInClub, String date, String competitionName, int competitionPlacement) {
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
        double distance = scn.nextDouble();

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

    public void printResults(ArrayList<Result> results) throws FileNotFoundException {
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

            if(discilpline == "crawl" && gender == "male" && distance == 50 && time > time){

            }
        }
    }

    public static void main(String[] args) throws IOException {
        CompetitiveResult n = new CompetitiveResult(null, null, 0.0, 0.0, null, 1, null, null, 1);
        System.out.println(n.readResults());
        n.registerResult(n.cR);

    }
}
