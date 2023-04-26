
class Matches{
    private static final int index_id=0, index_season=1, index_winner=10, index_toss_winner=6;

    final static String csvFile="matches.csv";
    String id, season, city, date, team1, team2, toss_winner, toss_decision, result, dl_applied, winner, win_by_runs,
            Win_by_wickets, player_of_match, venue, umpire1, umpire2, Umpire3;
   public Matches(String[] match_array){
       this.id = match_array[index_id];
       this.season = match_array[index_season];
       this.winner = match_array[index_winner];
       this.toss_winner = match_array[index_toss_winner];
   }

    public String getId() {
        return id;
    }

    public String getSeason() {
        return season;
    }

    public String getWinner() {
        return winner;
    }

    public String getToss_winner() {
        return toss_winner;
    }
}



