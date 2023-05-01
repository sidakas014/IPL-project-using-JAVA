package com.sid;

class Match {
    private int INDEX_ID =0, INDEX_SEASON =1, INDEX_WINNER =10, INDEX_TOSS_WINNER =6, INDEX_VENUE =14;

    private String matchId, matchSeason, matchCity, matchDate, matchTeam1, matchTeam2, matchTossWinner, matchTossDecision, matchResult, matchDlApplied, matchWinner, matchWinByRuns,
            matchWinByWickets, matchPlayerOfMatch, matchVenue, matchUmpire1, matchUmpire2, matchUmpire3;
   public Match(String[] matchData){
       this.matchId = matchData[INDEX_ID];
       this.matchSeason = matchData[INDEX_SEASON];
       this.matchWinner = matchData[INDEX_WINNER];
       this.matchTossWinner = matchData[INDEX_TOSS_WINNER];
       this.matchVenue = matchData[INDEX_VENUE];
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



