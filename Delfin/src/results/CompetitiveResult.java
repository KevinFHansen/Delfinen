package results;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class CompetitiveResult extends Result{
    private String competitionName;
    private int competitionPlacement;
    ArrayList<Result> cR = new ArrayList<>();
    Scanner scn = new Scanner(System.in);

    public CompetitiveResult(String memberName, String gender, double time, double distance, String discipline, int rankInClub, String date, String competitionName, int competitionPlacement) {
        super(memberName, gender, time, distance, discipline, rankInClub, date);
        this.competitionName = competitionName;
        this.competitionPlacement = competitionPlacement;
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

    public void registerResult(){
        System.out.println("Write members name: ");
        String memberName = scn.nextLine();

        System.out.println("Write gender of competitor: ");
        String gender = scn.nextLine();

        System.out.println("Type in time: ");
        double time = scn.nextDouble();

        System.out.println("Type distance: ");
        double distance = scn.nextDouble();

        System.out.println("Type in disciplin: ");
        String disciplin = scn.nextLine();

        System.out.println("Write rank in club: ");
        int rankInClub = scn.nextInt();

        System.out.println("Write the date: ");
        String date = scn.nextLine();

        System.out.println("Write the name of the competition: ");
        String competitionName = scn.nextLine();

        System.out.println("Write the placement at the competition: ");
        int competitionPlacement = scn.nextInt();

        CompetitiveResult register = new CompetitiveResult(memberName, gender, time, distance, disciplin, rankInClub, date, competitionName, competitionPlacement);
    }

    public void printResults(ArrayList<Result> results) throws IOException {
        File f = new File("Delfin/Ressources/Competitive.csv");

        FileWriter writer = new FileWriter(f, true);

    }
}
