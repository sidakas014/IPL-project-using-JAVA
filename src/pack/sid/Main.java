package pack.sid;

import java.util.*;
import java.io.*;

public class Main{
    public static ArrayList<String> read(String csvFile) {
        try {
            File file = new File(csvFile);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = "";

            ArrayList<String> tmpWholeArr = new ArrayList();
            while ((line = br.readLine()) != null) {
                tmpWholeArr.add(line);
            }
            return tmpWholeArr;
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //----------------Queries----------------
    //1st start
    public static void matchesPlayedPerYear(ArrayList<Match> sep_C) {
        HashMap<String, Integer> NoOfMatchesPlayed = new HashMap();
        for (int j = 1; j < sep_C.size(); j++) {
            NoOfMatchesPlayed.put(sep_C.get(j).getSeason(), NoOfMatchesPlayed.getOrDefault(sep_C.get(j).getSeason(), 0) + 1);
        }
        //Map Traversing
        for (Map.Entry<String, Integer> itrate : NoOfMatchesPlayed.entrySet()) {
            System.out.println(itrate.getKey() + " -> " + itrate.getValue());
        }
    }
    // 2th start
    public static void noOfMatchesWonByEachTeam(ArrayList<Match> sep_C) {
        HashMap<String, Integer> noOfMatchesWon = new HashMap();
        for (int k = 1; k < sep_C.size(); k++) {
            noOfMatchesWon.put(sep_C.get(k).getWinner(), noOfMatchesWon.getOrDefault(sep_C.get(k).getWinner(), 0) + 1);
        }
        for (Map.Entry<String, Integer> itrate : noOfMatchesWon.entrySet()) {
            System.out.println(itrate.getKey() + " -> " + itrate.getValue());
        }
    }
    //3th start
    public  static void extraRunsPerTeam(ArrayList<Match> sep_C, ArrayList<Delivery> sep_C1) {
        HashMap<String, Integer> extraRuns = new HashMap();
        for (int i = 1; i < sep_C.size(); i++) {
            if (sep_C.get(i).getSeason().equals("2016")) {
                String temp_str = sep_C.get(i).getId();
                for (int j = 1; j < sep_C1.size(); j++) {
                    if (sep_C1.get(j).getMatchId().equals(temp_str)) {
                        extraRuns.put(sep_C1.get(j).getBattingTeam(), extraRuns.getOrDefault(sep_C1.get(j).getBattingTeam(), 0) +
                                Integer.valueOf(sep_C1.get(j).getExtraRuns()));
                    }
                }
            }
        }
        for (Map.Entry<String, Integer> itrate : extraRuns.entrySet()) {
            System.out.println(itrate.getKey() + " -> " + itrate.getValue());
        }
    }
    //04 start
    public static void topEconomicalBowler(ArrayList<Match> sep_C, ArrayList<Delivery> FinaleArrayListOfDeliveries){
        HashMap<String, Integer> economicBowlerTotalBowl = new HashMap();
        HashMap<String, Integer> economicBowlerTotalRuns = new HashMap();
        for (int i = 1; i < sep_C.size(); i++){
            if (sep_C.get(i).getSeason().equals("2015")) {
                String temp_str = sep_C.get(i).getId();
                for (int j = 1; j < FinaleArrayListOfDeliveries.size(); j++) {
                    if (FinaleArrayListOfDeliveries.get(j).getMatchId().equals(temp_str)) {
                        economicBowlerTotalBowl.put(FinaleArrayListOfDeliveries.get(j).getBowler(), economicBowlerTotalBowl.getOrDefault(FinaleArrayListOfDeliveries.get(j).getBowler(), 0) + 1);
                        economicBowlerTotalRuns.put(FinaleArrayListOfDeliveries.get(j).getBowler(), economicBowlerTotalRuns.getOrDefault(FinaleArrayListOfDeliveries.get(j).getBowler(), 0) +
                                Integer.valueOf(FinaleArrayListOfDeliveries.get(j).getTotal_runs()));
                    }
                }

            }
        }
        HashMap<String, Double> economyRateMap = new HashMap();
        for (Map.Entry<String, Integer> itrate : economicBowlerTotalBowl.entrySet()){
            double economyRate = ((double) economicBowlerTotalRuns.get(itrate.getKey())*6.0)/(double) economicBowlerTotalBowl.get(itrate.getKey());
            economyRateMap.put(itrate.getKey(), economyRate);
        }
        double min = Double.MAX_VALUE;
        String str = "";
        for (Map.Entry<String, Double> itrate : economyRateMap.entrySet()){
            if (min> itrate.getValue()  ){
                min = itrate.getValue();
                str = itrate.getKey();
            }
        }
        System.out.println(str+" -> "+min);
    }
    //5th start
    public static void tossWinnerTeam(ArrayList<Match> FinaleArrayListOfMatch) {
        HashMap<String, Integer> tossWinnerMap = new HashMap();
        for (int k = 1; k < FinaleArrayListOfMatch.size(); k++) {
            tossWinnerMap.put(FinaleArrayListOfMatch.get(k).getToss_winner(), tossWinnerMap.getOrDefault(FinaleArrayListOfMatch.get(k).getToss_winner(), 0) + 1);
        }
        for (Map.Entry<String, Integer> itrate : tossWinnerMap.entrySet()) {
            System.out.println(itrate.getKey() + " -> " + itrate.getValue());
        }
    }
    //-----------------------------MainMethod-------------------------------------------------
    public static void main(String[] args){
        //Reading matches.csv file.
        ArrayList<String> wholeArr = new ArrayList();
        wholeArr = read("/home/striker/Downloads/Experiment/IPL project using Java/DataSource/matches.csv");
        ArrayList<Match> FinalArrayListOfMatch = new ArrayList();                //FinalArrayListOfMatch is ArrayList of a class called Match

        for(int i=0; i<wholeArr.size(); i++){
            String[] tempRowArr;
            tempRowArr = wholeArr.get(i).split(",");
            FinalArrayListOfMatch.add(new Match(tempRowArr));                  // on each itration this will make new object of Match
        }
        //Reading deliveries.csv file.
        ArrayList<String> wholeArr1 = new ArrayList();
        wholeArr1 = read("/home/striker/Downloads/Experiment/IPL project using Java/DataSource/deliveries.csv");
        ArrayList<Delivery> FinalArrayListOfDileviry = new ArrayList();

        for(int i=0; i<wholeArr1.size(); i++){
            String[] tempRowArr1;
            tempRowArr1 = wholeArr1.get(i).split(",");
            FinalArrayListOfDileviry.add(new Delivery(tempRowArr1));
        }

        //----------------------------------QueriesAnswers method call-------------------------------------------------

        System.out.println("---------------------Matches_played_per_Year_by_each_team------------------------------------------------");
        matchesPlayedPerYear(FinalArrayListOfMatch);
        System.out.println("----------------------No_of_matches_won_by_each_team-----------------------------------------------------");
        noOfMatchesWonByEachTeam(FinalArrayListOfMatch);
        System.out.println("--------------------------------extra_runs_per_team_in_2016----------------------------------------------");
        extraRunsPerTeam(FinalArrayListOfMatch, FinalArrayListOfDileviry);
        System.out.println("--------------------------top_economical_bowler_in_2015--------------------------------------------------");
        topEconomicalBowler(FinalArrayListOfMatch, FinalArrayListOfDileviry);
        System.out.println("------------------toss_win_by_each_team_in _all_years----------------------------------------------------");
        tossWinnerTeam(FinalArrayListOfMatch);
    }
}