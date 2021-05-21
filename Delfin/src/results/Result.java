package results;

import java.io.File;
import java.util.ArrayList;

public class Result {
    private String memberName;
    private String gender;
    private double time;
    private int distance;
    private String discipline;
    private int rankInClub;
    private String date;
    private String competitionName;
    private int competitionPlacement;


    public Result(String memberName, String gender, double time, int distance, String discipline, int rankInClub, String date, String competitionName, int competitionPlacement) {
        this.memberName = memberName;
        this.gender = gender;
        this.time = time;
        this.distance = distance;
        this.discipline = discipline;
        this.rankInClub = rankInClub;
        this.date = date;
        this.competitionName = competitionName;
        this.competitionPlacement = competitionPlacement;
    }

    public String getMemberName() {
        return memberName;
    }

    public String getGender() {
        return gender;
    }

    public double getTime() {
        return time;
    }

    public int getDistance() {
        return distance;
    }

    public String getDiscipline() {
        return discipline;
    }

    public int getRankInClub() {
        return rankInClub;
    }

    public String getDate() {
        return date;
    }

    public String getCompetitionName() {
        return competitionName;
    }

    public int getCompetitionPlacement() {
        return competitionPlacement;
    }

    @Override
    public String toString() {
        return "Result{" +
                "memberName='" + memberName + '\'' +
                ", gender='" + gender + '\'' +
                ", time=" + time +
                ", distance=" + distance +
                ", discipline='" + discipline + '\'' +
                ", rankInClub=" + rankInClub +
                ", date='" + date + '\'' +
                ", competitionName='" + competitionName + '\'' +
                ", competitionPlacement=" + competitionPlacement +
                '}';
    }


}
