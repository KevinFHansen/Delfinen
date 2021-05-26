package compettition;

import java.util.Comparator;

public class SortByRank implements Comparator<Competitor> {

    @Override
    public int compare(Competitor a, Competitor b){

        return Double.compare(a.disciplines.get(0).getRank(), a.disciplines.get(0).getRank());
    }
}
