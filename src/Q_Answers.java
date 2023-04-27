import java.io.*;
import java.util.*;
public class Q_Answers {

    //1st start
    static void Matches_played_per_Year(ArrayList<Matches> sep_C) {
        HashMap<String, Integer> no_of_matches_played = new HashMap();
        for (int j = 1; j < sep_C.size(); j++) {
            no_of_matches_played.put(sep_C.get(j).getSeason(), no_of_matches_played.getOrDefault(sep_C.get(j).getSeason(), 0) + 1);
        }
        //Map Traversing
        for (Map.Entry<String, Integer> itrate : no_of_matches_played.entrySet()) {
            System.out.println(itrate.getKey() + " -> " + itrate.getValue());
        }
    }
    // 2th start
    static void No_of_matches_won_by_each_team(ArrayList<Matches> sep_C) {
        HashMap<String, Integer> no_of_matches_won = new HashMap();
        for (int k = 1; k < sep_C.size(); k++) {
            no_of_matches_won.put(sep_C.get(k).getWinner(), no_of_matches_won.getOrDefault(sep_C.get(k).getWinner(), 0) + 1);
        }
        for (Map.Entry<String, Integer> itrate : no_of_matches_won.entrySet()) {
            System.out.println(itrate.getKey() + " -> " + itrate.getValue());
        }
    }

    //3th start
    static void extra_runs_per_team(ArrayList<Matches> sep_C, ArrayList<Deliveries> sep_C1) {
        HashMap<String, Integer> extra_runs_perTeam = new HashMap();
        for (int i = 1; i < sep_C.size(); i++) {
            if (sep_C.get(i).getSeason().equals("2016")) {
                String temp_str = sep_C.get(i).getId();
                for (int j = 1; j < sep_C1.size(); j++) {
                    if (sep_C1.get(j).getMatch_id().equals(temp_str)) {
                        extra_runs_perTeam.put(sep_C1.get(j).getBatting_team(), extra_runs_perTeam.getOrDefault(sep_C1.get(j).getBatting_team(), 0) +
                                Integer.valueOf(sep_C1.get(j).getExtra_runs()));
                    }
                }
            }
        }
        for (Map.Entry<String, Integer> itrate : extra_runs_perTeam.entrySet()) {
            System.out.println(itrate.getKey() + " -> " + itrate.getValue());
        }
    }
    //5th start
    static void toss_winner_team(ArrayList<Matches> sep_C) {
        HashMap<String, Integer> toss_winner_Map = new HashMap();
        for (int k = 1; k < sep_C.size(); k++) {
            toss_winner_Map.put(sep_C.get(k).getToss_winner(), toss_winner_Map.getOrDefault(sep_C.get(k).getToss_winner(), 0) + 1);
        }
        for (Map.Entry<String, Integer> itrate : toss_winner_Map.entrySet()) {
            System.out.println(itrate.getKey() + " -> " + itrate.getValue());
        }
    }
    //04 start
    static void top_economical_bowler(ArrayList<Matches> sep_C, ArrayList<Deliveries> sep_C1){
        HashMap<String, Integer> Economic_Bowler_total_bowl = new HashMap();
        HashMap<String, Integer> Economic_Bowler_total_runs = new HashMap();
        for (int i = 1; i < sep_C.size(); i++){
            if (sep_C.get(i).getSeason().equals("2015")) {
                String temp_str = sep_C.get(i).getId();
                for (int j = 1; j < sep_C1.size(); j++) {
                    if (sep_C1.get(j).getMatch_id().equals(temp_str)) {
                        Economic_Bowler_total_bowl.put(sep_C1.get(j).getBowler(), Economic_Bowler_total_bowl.getOrDefault(sep_C1.get(j).getBowler(), 0) + 1);
                    }
                }
                for (int k = 1; k < sep_C1.size(); k++){
                    if (sep_C1.get(k).getMatch_id().equals(temp_str)){
                        Economic_Bowler_total_runs.put(sep_C1.get(k).getBowler(), Economic_Bowler_total_runs.getOrDefault(sep_C1.get(k).getBowler(), 0) +
                                Integer.valueOf(sep_C1.get(k).getTotal_runs()));
                    }
                }
            }
        }

        HashMap<String, Double> Economy_rate_Map = new HashMap();
        for (Map.Entry<String, Integer> itrate : Economic_Bowler_total_bowl.entrySet()){
            double Economy_rate = ((double) Economic_Bowler_total_runs.get(itrate.getKey())*6.0)/(double) Economic_Bowler_total_bowl.get(itrate.getKey());
            Economy_rate_Map.put(itrate.getKey(), Economy_rate);

        }
        double min = Double.MAX_VALUE;
        String str = "";
        for (Map.Entry<String, Double> itrate : Economy_rate_Map.entrySet()){
            if (min> itrate.getValue()  ){
                min = itrate.getValue();
                str = itrate.getKey();
            }
        }
        System.out.println(str+" -> "+min);
    }
}
