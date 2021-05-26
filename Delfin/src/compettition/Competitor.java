package compettition;

import members.Member;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Competitor extends Member{
    private String ageGroup;
    private int crawlScore;
    private int backCrawlScore;
    private int butterflyScore;
    private int breaststrokeScore;
    ArrayList<Discipline> disciplines = new ArrayList<>();

    public Competitor(String name, int age, String gender, ArrayList<Discipline> disciplines) {
        super(name, age, gender);

        if(age < 18){
            this.ageGroup = "Junior";
        }
        else{
            this.ageGroup = "Senior";
        }
    }

    public void setScore(){
        this.crawlScore = (int)(disciplines.get(0).getRank() * 100);
        this.backCrawlScore = (int)(disciplines.get(1).getRank() * 100);
        this.butterflyScore = (int)(disciplines.get(2).getRank() * 100);
        this.breaststrokeScore = (int)(disciplines.get(3).getRank() * 100);
    }

    public static class rankCrawl implements Comparator<Competitor>{
        public int compare(Competitor a, Competitor b){
            return a.crawlScore - b.crawlScore;
        }
    }

    public static class rankBackCrawl implements Comparator<Competitor>{
        public int compare(Competitor a, Competitor b){
            return a.backCrawlScore - b.backCrawlScore;
        }
    }

    public static class rankButterfly implements Comparator<Competitor>{
        public int compare(Competitor a, Competitor b){
            return a.butterflyScore - b.butterflyScore;
        }
    }

    public static class rankBreaststroke implements Comparator<Competitor>{
        public int compare(Competitor a, Competitor b){
            return a.breaststrokeScore - b.breaststrokeScore;
        }
    }

    public int getCrawlScore() {
        return crawlScore;
    }

    public int getBackCrawlScore() {
        return backCrawlScore;
    }

    public int getButterflyScore() {
        return butterflyScore;
    }

    public int getBreaststrokeScore() {
        return breaststrokeScore;
    }

    public Competitor createCompetitorFromMember(Member member){

        Discipline discipline0 = new Discipline("crawl", 0, 0.0);
        Discipline discipline1 = new Discipline("backcrawl", 0, 0.0);
        Discipline discipline2 = new Discipline("butterfly", 0, 0.0);
        Discipline discipline3 = new Discipline("breaststroke", 0, 0.0);
        ArrayList<Discipline> disciplines = new ArrayList<>();
        disciplines.add(discipline0);
        disciplines.add(discipline1);
        disciplines.add(discipline2);
        disciplines.add(discipline3);

        Competitor competitor = new Competitor(member.getName(), member.getAge(), member.getGender(), disciplines);


        return competitor;
    }

    // create competitor csv
    public void createCompFile(Competitor comp) throws IOException {

        if(comp.getAge() < 18){
            ageGroup = "Junior";
        }
        else{
            ageGroup = "Senior";
        }

        PrintWriter writer = new PrintWriter(new FileWriter("Delfin/Ressources/Team/" + ageGroup + "/" + comp.getGender() + "/" + comp.getName() + ".csv"));

        writer.print("");

        writer.println("Age;Gender;Type;Distance;BestTrainingTime;CompetitionName;Placement;Time");

        for (int i = 0; i < disciplines.size(); i++){
            for(int j = 0; j < disciplines.get(i).getResults().size(); i++){

                writer.print(comp.getAge() + ";" + comp.getGender() + ";");
                writer.print(disciplines.get(i).getType() + ";" + disciplines.get(i).getDistance() + ";" + disciplines.get(i).getBestTraining() + ";");

                writer.print(disciplines.get(i).getResults().get(j).getCompName() + ";");
                writer.print(disciplines.get(i).getResults().get(j).getPlacement() + ";");
                writer.println(disciplines.get(i).getResults().get(j).getCompTime());
            }
        }
        writer.close();
    }

    // read comp csv
    public Competitor readCompFile(String gender, String ageGroup, String fileName) throws FileNotFoundException {
        File compFile = new File("Delfin/Ressources/Team/" + ageGroup + "/" + gender + "/" + fileName);
        Scanner scFile = new Scanner(compFile);

        ArrayList<String[]> competitorArrays = new ArrayList<>();

        scFile.nextLine();

        while (scFile.hasNext()){

            String thisLine = scFile.nextLine();
            String[] lineAsArray = thisLine.split(";");
            competitorArrays.add(lineAsArray);
        }



        Discipline discipline0 = new Discipline("crawl", 0, 0.0);
        Discipline discipline1 = new Discipline("backcrawl", 0, 0.0);
        Discipline discipline2 = new Discipline("butterfly", 0, 0.0);
        Discipline discipline3 = new Discipline("breaststroke", 0, 0.0);
        ArrayList<Discipline> disciplines = new ArrayList<>();
        disciplines.add(discipline0);
        disciplines.add(discipline1);
        disciplines.add(discipline2);
        disciplines.add(discipline3);

        String memberName = fileName.substring(0, fileName.lastIndexOf('.'));

        Competitor competitor = new Competitor(memberName, parseInt(competitorArrays.get(0)[0]), competitorArrays.get(0)[1], disciplines);

        int count0 = 0;
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;

        for(int i = 0; i < competitorArrays.size(); i++){

            if(competitorArrays.get(i)[2].equals("crawl")){
                disciplines.get(0).setType(competitorArrays.get(i)[2].trim());
                disciplines.get(0).setDistance(Integer.parseInt(competitorArrays.get(i)[3].trim()));
                disciplines.get(0).setBestTraining(Double.parseDouble(competitorArrays.get(i)[4].trim()));

                Result2 tempResult = new Result2(null, 0, 0.0);

                disciplines.get(0).results.add(tempResult);

                disciplines.get(0).getResults().get(count0).setCompName(competitorArrays.get(i)[5].trim());
                disciplines.get(0).getResults().get(count0).setPlacement(Integer.parseInt(competitorArrays.get(i)[6].trim()));
                disciplines.get(0).getResults().get(count0).setCompTime(Double.parseDouble(competitorArrays.get(i)[7].trim()));

                count0++;

            }

            else if(competitorArrays.get(i)[2].equals("backcrawl")){
                disciplines.get(1).setType(competitorArrays.get(i)[2].trim());
                disciplines.get(1).setDistance(Integer.parseInt(competitorArrays.get(i)[3].trim()));
                disciplines.get(1).setBestTraining(Double.parseDouble(competitorArrays.get(i)[4].trim()));

                Result2 tempResult = new Result2(null, 0, 0.0);

                disciplines.get(1).getResults().add(tempResult);

                disciplines.get(1).getResults().get(count1).setCompName(competitorArrays.get(i)[5].trim());
                disciplines.get(1).getResults().get(count1).setPlacement(Integer.parseInt(competitorArrays.get(i)[6].trim()));
                disciplines.get(1).getResults().get(count1).setCompTime(Double.parseDouble(competitorArrays.get(i)[7].trim()));

                count1++;
            }

            else if(competitorArrays.get(i)[2].equals("butterfly")){
                disciplines.get(2).setType(competitorArrays.get(i)[2].trim());
                disciplines.get(2).setDistance(Integer.parseInt(competitorArrays.get(i)[3].trim()));
                disciplines.get(2).setBestTraining(Double.parseDouble(competitorArrays.get(i)[4].trim()));

                Result2 tempResult = new Result2(null, 0, 0.0);

                disciplines.get(2).getResults().add(tempResult);

                disciplines.get(2).getResults().get(count2).setCompName(competitorArrays.get(i)[5].trim());
                disciplines.get(2).getResults().get(count2).setPlacement(Integer.parseInt(competitorArrays.get(i)[6].trim()));
                disciplines.get(2).getResults().get(count2).setCompTime(Double.parseDouble(competitorArrays.get(i)[7].trim()));

                count2++;
            }

            else{ // breaststroke //
                disciplines.get(3).setType(competitorArrays.get(i)[2].trim());
                disciplines.get(3).setDistance(Integer.parseInt(competitorArrays.get(i)[3].trim()));
                disciplines.get(3).setBestTraining(Double.parseDouble(competitorArrays.get(i)[4].trim()));

                Result2 tempResult = new Result2(null, 0, 0.0);

                disciplines.get(3).getResults().add(tempResult);

                disciplines.get(3).getResults().get(count3).setCompName(competitorArrays.get(i)[5].trim());
                disciplines.get(3).getResults().get(count3).setPlacement(Integer.parseInt(competitorArrays.get(i)[6].trim()));
                disciplines.get(3).getResults().get(count3).setCompTime(Double.parseDouble(competitorArrays.get(i)[7].trim()));

                count3++;
            }
        }


        disciplines.get(0).setRank();
        disciplines.get(1).setRank();
        disciplines.get(2).setRank();
        disciplines.get(3).setRank();

        return competitor;
    }

    @Override
    public String toString(){
        return getName();
    }
}
