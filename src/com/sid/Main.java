package com.sid;

import java.util.*;
import java.io.*;

public class Main {

    static int INDEX_DELIVERY_MATCH_ID = 0;
    static int INDEX_BATTING_TEAM = 2;
    static int INDEX_EXTRA_RUNS = 16;
    static int INDEX_BOWLER = 8;
    static int INDEX_TOTAL_RUNS = 17;
    static int INDEX_ID = 0;
    static int INDEX_SEASON = 1;
    static int INDEX_WINNER = 10;
    static int INDEX_TOSS_WINNER = 6;

    public static ArrayList<String> readCsvFile(String csvFile) {
        try {
            File originalFile = new File(csvFile);
            FileReader fileReader = new FileReader(originalFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;

            ArrayList<String> temporaryWholeData = new ArrayList<>();
            while ((line = bufferedReader.readLine()) != null) {
                temporaryWholeData.add(line);
            }
            return temporaryWholeData;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //----------------------------------Queries---------------------------------------------
    public static void matchesPlayedPerYear(ArrayList<Match> finalDataOfMatches) {
        HashMap<String, Integer> numberOfMatchesPlayedPerYear = new HashMap<>();
        for (int j = 1; j < finalDataOfMatches.size(); j++) {
            numberOfMatchesPlayedPerYear.put(finalDataOfMatches.get(j).getMatchSeason(),
                    numberOfMatchesPlayedPerYear.getOrDefault(finalDataOfMatches.get(j).getMatchSeason(), 0) + 1);
        }
        //Map Traversing
        for (Map.Entry<String, Integer> numberOfMatchesPlayedIterator : numberOfMatchesPlayedPerYear.entrySet()) {
            System.out.println(numberOfMatchesPlayedIterator.getKey() + " -> " + numberOfMatchesPlayedIterator.getValue());
        }
    }

    public static void matchesWonByEachTeam(ArrayList<Match> finalDataOfMatches) {
        HashMap<String, Integer> numberOfMatchesWonPerTeam = new HashMap<>();
        for (int k = 1; k < finalDataOfMatches.size(); k++) {

            numberOfMatchesWonPerTeam.put(finalDataOfMatches.get(k).getMatchWinner(),
                    numberOfMatchesWonPerTeam.getOrDefault(finalDataOfMatches.get(k).getMatchWinner(), 0) + 1);
        }
        for (Map.Entry<String, Integer> numberOfMatchesWonIterator : numberOfMatchesWonPerTeam.entrySet()) {
            if (numberOfMatchesWonIterator.getKey().equals("")) {
                continue;
            }

            System.out.println(numberOfMatchesWonIterator.getKey() + " -> " + numberOfMatchesWonIterator.getValue());
        }
    }

    public static void extraRunsPerTeamIn2016(ArrayList<Match> finalDataOfMatches, ArrayList<Delivery> finalDataOfDeliveries) {
        HashMap<String, Integer> numberOfExtraRunsPerTeam = new HashMap<>();
        for (int i = 1; i < finalDataOfMatches.size(); i++) {
            if (finalDataOfMatches.get(i).getMatchSeason().equals("2016")) {
                String tempStr = finalDataOfMatches.get(i).getMatchId();
                for (int j = 1; j < finalDataOfDeliveries.size(); j++) {
                    if (finalDataOfDeliveries.get(j).getDeliveryId().equals(tempStr)) {
                        numberOfExtraRunsPerTeam.put(finalDataOfDeliveries.get(j).getDeliveryBattingTeam(),
                                numberOfExtraRunsPerTeam.getOrDefault(finalDataOfDeliveries.get(j).getDeliveryBattingTeam(), 0) +
                                        Integer.parseInt(finalDataOfDeliveries.get(j).getDeliveryExtraRuns()));
                    }
                }
            }
        }
        for (Map.Entry<String, Integer> numberOfExtraRunsIterator : numberOfExtraRunsPerTeam.entrySet()) {
            System.out.println(numberOfExtraRunsIterator.getKey() + " -> " + numberOfExtraRunsIterator.getValue());
        }
    }

    //04 start
    public static void topEconomicalBowlerIn2015(ArrayList<Match> finalDataOfMatches, ArrayList<Delivery> finalDataOfDeliveries) {
        HashMap<String, Integer> bowlerTotalBowl = new HashMap<>();
        HashMap<String, Integer> bowlerTotalRuns = new HashMap<>();
        for (int i = 1; i < finalDataOfMatches.size(); i++) {
            if (finalDataOfMatches.get(i).getMatchSeason().equals("2015")) {
                String tempString = finalDataOfMatches.get(i).getMatchId();
                for (int j = 1; j < finalDataOfDeliveries.size(); j++) {
                    if (finalDataOfDeliveries.get(j).getDeliveryId().equals(tempString)) {
                        bowlerTotalBowl.put(finalDataOfDeliveries.get(j).getDeliveryBowler(),
                                bowlerTotalBowl.getOrDefault(finalDataOfDeliveries.get(j).getDeliveryBowler(), 0) + 1);
                        bowlerTotalRuns.put(finalDataOfDeliveries.get(j).getDeliveryBowler(),
                                bowlerTotalRuns.getOrDefault(finalDataOfDeliveries.get(j).getDeliveryBowler(), 0) +
                                        Integer.parseInt(finalDataOfDeliveries.get(j).getDeliveryTotalRuns()));
                    }
                }
            }
        }
        HashMap<String, Double> economyRateOfAllPlayers = new HashMap<>();
        for (Map.Entry<String, Integer> bowlerTotalBowlIterator : bowlerTotalBowl.entrySet()) {
            double economyRateOfBowler = ((double) bowlerTotalRuns.get(bowlerTotalBowlIterator.getKey()) * 6.0) /
                    (double) bowlerTotalBowl.get(bowlerTotalBowlIterator.getKey());
            economyRateOfAllPlayers.put(bowlerTotalBowlIterator.getKey(), economyRateOfBowler);
        }
        double minimumEconomy = Double.MAX_VALUE;
        String bestEconomyBowlerName = "";
        for (Map.Entry<String, Double> economyRateOfAllPlayersIterator : economyRateOfAllPlayers.entrySet()) {
            if (minimumEconomy > economyRateOfAllPlayersIterator.getValue()) {
                minimumEconomy = economyRateOfAllPlayersIterator.getValue();
                bestEconomyBowlerName = economyRateOfAllPlayersIterator.getKey();
            }
        }
        System.out.println(bestEconomyBowlerName + " -> " + minimumEconomy);
    }

    //5th start
    public static void tossWinnerTeam(ArrayList<Match> finalDataOfMatches) {
        HashMap<String, Integer> allTossWinnerTeam = new HashMap<>();
        for (int k = 1; k < finalDataOfMatches.size(); k++) {
            allTossWinnerTeam.put(finalDataOfMatches.get(k).getMatchTossWinner(),
                    allTossWinnerTeam.getOrDefault(finalDataOfMatches.get(k).getMatchTossWinner(), 0) + 1);
        }
        for (Map.Entry<String, Integer> allTossWinnerTeamIterator : allTossWinnerTeam.entrySet()) {
            System.out.println(allTossWinnerTeamIterator.getKey() + " -> " + allTossWinnerTeamIterator.getValue());
        }
    }
    //-----------------------------MainMethod-------------------------------------------------
    public static void main(String[] args) {

        ArrayList<String> wholeFileDataForMatches;
        wholeFileDataForMatches = readCsvFile("/home/striker/Downloads/Experiment/IPL project using Java/DataSource/matches.csv");
        ArrayList<Match> finalDataOfMatches = new ArrayList<>();

        assert wholeFileDataForMatches != null;
        for (String wholeFileDataForMatch : wholeFileDataForMatches) {
            Match match;
            match = new Match();
            String[] temporaryRowDataForMatches;
            temporaryRowDataForMatches = wholeFileDataForMatch.split(",", -1);
            match.setMatchId(temporaryRowDataForMatches[INDEX_ID]);
            match.setMatchSeason(temporaryRowDataForMatches[INDEX_SEASON]);
            match.setMatchWinner(temporaryRowDataForMatches[INDEX_WINNER]);
            match.setMatchTossWinner(temporaryRowDataForMatches[INDEX_TOSS_WINNER]);
            finalDataOfMatches.add(match);
        }

        ArrayList<String> wholeFileDataForDeliveries;
        wholeFileDataForDeliveries = readCsvFile("/home/striker/Downloads/Experiment/IPL project using Java/DataSource/deliveries.csv");
        ArrayList<Delivery> finalDataOfDeliveries = new ArrayList<>();

        assert wholeFileDataForDeliveries != null;
        for (String wholeFileDataForDelivery : wholeFileDataForDeliveries) {
            Delivery delivery;
            delivery = new Delivery();
            String[] temporaryRowDataForDeliveries;
            temporaryRowDataForDeliveries = wholeFileDataForDelivery.split(",", -1);

            delivery.setDeliveryId(temporaryRowDataForDeliveries[INDEX_DELIVERY_MATCH_ID]);
            delivery.setDeliveryBattingTeam(temporaryRowDataForDeliveries[INDEX_BATTING_TEAM]);
            delivery.setDeliveryExtraRuns(temporaryRowDataForDeliveries[INDEX_EXTRA_RUNS]);
            delivery.setDeliveryBowler(temporaryRowDataForDeliveries[INDEX_BOWLER]);
            delivery.setDeliveryTotalRuns(temporaryRowDataForDeliveries[INDEX_TOTAL_RUNS]);
            finalDataOfDeliveries.add(delivery);
        }

        //----------------------------------QueriesAnswers method call-------------------------------------------------

        System.out.println("---------------------Matches_played_per_Year_by_each_team------------------------------------------------");
        matchesPlayedPerYear(finalDataOfMatches);
        System.out.println("----------------------No_of_matches_won_by_each_team-----------------------------------------------------");
        matchesWonByEachTeam(finalDataOfMatches);
        System.out.println("--------------------------------extra_runs_per_team_in_2016----------------------------------------------");
        extraRunsPerTeamIn2016(finalDataOfMatches, finalDataOfDeliveries);
        System.out.println("--------------------------top_economical_bowler_in_2015--------------------------------------------------");
        topEconomicalBowlerIn2015(finalDataOfMatches, finalDataOfDeliveries);
        System.out.println("------------------toss_win_by_each_team_in _all_years----------------------------------------------------");
        tossWinnerTeam(finalDataOfMatches);

    }
}