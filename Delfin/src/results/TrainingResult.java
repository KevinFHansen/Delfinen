package results;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

// skal ikke have competition x2 med
public class TrainingResult extends Result{

    ArrayList<Result> tR = new ArrayList<>();
    Scanner scn = new Scanner(System.in);
    File f = new File("Delfin/Ressources/Competitive.csv");
    public TrainingResult(String memberName, String gender, double time, int distance, String discipline, int rankInClub, String date, String competitionName, int competitionPlacement) {
        super(memberName, gender, time, distance, discipline, rankInClub, date, competitionName, competitionPlacement);
    }

    @Override
    public int compareTo(Result o) {
        return 0;
    }
}
