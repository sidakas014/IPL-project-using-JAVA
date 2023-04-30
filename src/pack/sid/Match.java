package pack.sid;

class Match {
    private int INDEX_ID =0, INDEX_SEASON =1, INDEX_WINNER =10, INDEX_TOSS_WINNER =6, INDEX_VENUE =14;

    private String matchId, matchSeason, matchCity, matchDate, matchTeam1, matchTeam2, matchTossWinner, matchTossDecision, matchResult, matchDlApplied, matchWinner, matchWinByRuns,
            matchWinByWickets, matchPlayerOfMatch, matchVenue, matchUmpire1, matchUmpire2, matchUmpire3;
   public Match(String[] match_array){
       this.matchId = match_array[INDEX_ID];
       this.matchSeason = match_array[INDEX_SEASON];
       this.matchWinner = match_array[INDEX_WINNER];
       this.matchTossWinner = match_array[INDEX_TOSS_WINNER];
       this.matchVenue = match_array[INDEX_VENUE];
   }
    //-------------------------Getter-----------------------------------------
    public String getMatchId() {
        return matchId;
    }
    public String getMatchSeason() {
        return matchSeason;
    }
    public String getMatchWinner() {
        return matchWinner;
    }
    public String getMatchTossWinner() {
        return matchTossWinner;
    }
}



