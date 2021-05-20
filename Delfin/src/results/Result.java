package results;

import java.io.File;
import java.util.ArrayList;

public abstract class Result {
    private String memberName;
    private String gender;
    private double time;
    private double distance;
    private String discipline;
    private int rankInClub;
    String date;


    public Result(String memberName, String gender, double time, double distance, String discipline, int rankInClub, String date) {
        this.memberName = memberName;
        this.gender = gender;
        this.time = time;
        this.distance = distance;
        this.discipline = discipline;
        this.rankInClub = rankInClub;
        this.date = date;
    }

}
