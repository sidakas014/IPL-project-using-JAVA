import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args){

        //Reading matches.csv file.

        ArrayList<String> whole_arr = new ArrayList();
        whole_arr = CSVReaderTest.read("matches.csv");

        ArrayList<Matches> sep_C = new ArrayList();                //sep_C is ArrayList of an class called Matches
        for(int i=0; i<whole_arr.size(); i++){
            String[] temp_row_arr;
            temp_row_arr = whole_arr.get(i).split(",");
            sep_C.add(new Matches(temp_row_arr));                  // on each itration this will make new object of Matches
        }

        //Reading deliveries.csv file.

        ArrayList<String> whole_arr1 = new ArrayList();
        whole_arr1 = CSVReaderTest.read("deliveries.csv");

        ArrayList<Deliveries> sep_C1 = new ArrayList();
        for(int i=0; i<whole_arr1.size(); i++){
            String[] temp_row_arr;
            temp_row_arr = whole_arr1.get(i).split(",");
            sep_C1.add(new Deliveries(temp_row_arr));
        }


        // Q_Answers method call.

        System.out.println("---------------------Matches_played_per_Year_by_each_team------------------------------------------------------");
        Q_Answers.Matches_played_per_Year(sep_C);
        System.out.println("----------------------No_of_matches_won_by_each_team-----------------------------------------------------");
        Q_Answers.No_of_matches_won_by_each_team(sep_C);
        System.out.println("--------------------------------extra_runs_per_team_in_2016-------------------------------------------");
        Q_Answers.extra_runs_per_team(sep_C, sep_C1);
        System.out.println("--------------------------top_economical_bowler_in_2015-------------------------------------------------");
        Q_Answers.top_economical_bowler(sep_C, sep_C1);
        System.out.println("------------------toss_win_by_each_team_in _all_years---------------------------------------------------------");
        Q_Answers.toss_winner_team(sep_C);

    }
}