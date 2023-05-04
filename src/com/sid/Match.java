package com.sid;

class Match {
    private String matchId, matchSeason, matchTossWinner, matchWinner;

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
    //----------------------------Setter------------------------------------------
    public void setMatchId(String matchId) {
        this.matchId = matchId;
    }
    public void setMatchSeason(String matchSeason) {
        this.matchSeason = matchSeason;
    }
    public void setMatchTossWinner(String matchTossWinner) {
        this.matchTossWinner = matchTossWinner;
    }
    public void setMatchWinner(String matchWinner) {
        this.matchWinner = matchWinner;
    }
}



