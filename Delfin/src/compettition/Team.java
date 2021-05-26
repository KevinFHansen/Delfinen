package compettition;

import java.util.ArrayList;

public class Team {
    private String ageGroup, gender;
    ArrayList<Competitor> competitors = new ArrayList<>();

    public Team(String ageGroup) {
        this.ageGroup = ageGroup;
    }

    public String getAgeGroup() {
        return ageGroup;
    }

    public void setAgeGroup(String ageGroup) {
        this.ageGroup = ageGroup;
    }
}
