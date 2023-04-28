package pack.sid;
class Delivery {
    private  int index_match_id=0, index_batting_team=2, index_extra_runs=16, index_bowler=8, index_total_runs=17 ;
    private String match_id, inning, batting_team, bowling_team, over, ball, batsman, non_striker, bowler, is_super_over, wide_runs,
           bye_runs, legbye_runs, noball_runs, penalty_runs, batsman_runs, extra_runs, total_runs, player_dissmissed,
           dismissal_kind, fielder;

    public Delivery(String[] deliveries_array){
        this.match_id = deliveries_array[index_match_id];
        this.batting_team = deliveries_array[index_batting_team];
        this.extra_runs = deliveries_array[index_extra_runs];
        this.bowler = deliveries_array[index_bowler];
        this.total_runs = deliveries_array[index_total_runs];
    }
    //--------------------------------Getter----------------------------------
    public String getMatchId() {
        return match_id;
    }
    public String getBattingTeam() {
        return batting_team;
    }
    public String getExtraRuns() {
        return extra_runs;
    }
    public String getBowler() {return bowler;}
    public String getTotal_runs() {return total_runs;}
}

