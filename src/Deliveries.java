class Deliveries {
     static int index_match_id=0, index_batting_team=2, index_extra_runs=16, index_bowler=7, index_total_runs=17 ;
    final static String csvFile="deliveries.csv";
    String match_id, inning, batting_team, over, ball, batsman, non_striker, bowler, is_super_over, wide_runs,
           bye_runs, legbye_runs, noball_runs, penalty_runs, batsman_runs, extra_runs, total_runs, player_dissmissed,
           dismissal_kind, fielder;

    public Deliveries(String[] deliveries_array){
        this.match_id = deliveries_array[index_match_id];
        this.batting_team = deliveries_array[index_batting_team];
        this.extra_runs = deliveries_array[index_extra_runs];
        this.bowler = deliveries_array[index_bowler];
        this.total_runs = deliveries_array[index_total_runs];
    }

    public String getMatch_id() {
        return match_id;
    }

    public String getBatting_team() {
        return batting_team;
    }

    public String getExtra_runs() {
        return extra_runs;
    }

    public static int getIndex_total_runs() {return index_total_runs;}

    public String getBowler() {return bowler;}

    public String getTotal_runs() {return total_runs;}
}

