import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args){

        //Reading matches.csv file.

        ArrayList<String> arr_row = new ArrayList();
        arr_row = CSVReaderTest.read("matches.csv");

        ArrayList<Matches> sep_C = new ArrayList();
        for(int i=0; i<arr_row.size(); i++){
            String[] temp_arr;
            temp_arr = arr_row.get(i).split(",");
            sep_C.add(new Matches(temp_arr));
        }

        //Reading deliveries.csv file.

        ArrayList<String> arr_row1 = new ArrayList();
        arr_row1 = CSVReaderTest.read("deliveries.csv");

        ArrayList<Deliveries> sep_C1 = new ArrayList();
        for(int i=0; i<arr_row1.size(); i++){
            String[] temp_arr;
            temp_arr = arr_row1.get(i).split(",");
            sep_C1.add(new Deliveries(temp_arr));
        }


        // Q_Answers method call.

        Q_Answers.Matches_played_per_Year(sep_C);
        System.out.println("---------------------------------------------------------------------------");
        Q_Answers.No_of_matches_won_by_each_team(sep_C);
        System.out.println("---------------------------------------------------------------------------");
        Q_Answers.extra_runs_per_team(sep_C, sep_C1);
        System.out.println("---------------------------------------------------------------------------");
        Q_Answers.top_economical_bowler(sep_C, sep_C1);
        System.out.println("---------------------------------------------------------------------------");
        Q_Answers.toss_winner_team(sep_C);

    }
}