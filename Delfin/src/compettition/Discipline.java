package compettition;
//@author Joachim Malmstrøm

import java.util.ArrayList;
import java.util.Scanner;

public class Discipline {
    private String type;
    private int distance;
    private double bestTraining;
    private double rank;
    private ArrayList<Result2> results;

    public Discipline(String type, int distance, double bestTraining, ArrayList<Result2> results) {
        this.type = type;
        this.distance = distance;
        this.bestTraining = bestTraining;
        this.results = results;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public ArrayList<Result2> getResults() {
        return results;
    }

    public void setResults(ArrayList<Result2> results) {
        this.results = results;
    }

    public double getBestTraining() {
        return bestTraining;
    }

    public void setBestTraining(double bestTraining) {
        this.bestTraining = bestTraining;
    }

    public void registerDiscipline(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Type in the distance:");
        setDistance(Integer.parseInt(sc.nextLine()));

        System.out.println("Type in best training time");
        setBestTraining(Double.parseDouble(sc.nextLine()));
    }

    public double getRank(){
        return rank;
    }

    public void setRank(){

        double calcRank;
        double training = distance / bestTraining;
        double compTotal = 0.0;
        int count = 0;

        for(int i = 0; i < results.size(); i++){

            double time = results.get(i).getCompTime() * 0.75;

            double placment = results.get(i).getPlacement() * 0.25;

            compTotal = compTotal + time + placment;

            count++;
        }

        calcRank = training + (compTotal / count);

        this.rank = calcRank;
    }
}

