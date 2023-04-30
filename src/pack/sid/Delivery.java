package pack.sid;
class Delivery {
    private  int INDEX_DELIVERY_MATCH_ID =0, INDEX_BATTING_TEAM =2, INDEX_EXTRA_RUNS =16, INDEX_BOWLER =8, INDEX_TOTAL_RUNS =17, INDEX_FIELDER =20;
    private String deliveryId, deliveryInning, deliveryBattingTeam, deliveryBowlingTeam, deliveryOver, deliveryBall, deliveryBatsman, deliveryNonStriker, deliveryBowler,
            deliveryIsSuperOver, deliveryWideRuns, deliveryByeRuns, deliveryLegByeRuns, deliveryNoBallRuns, deliveryPenaltyRuns, deliveryBatsmanRuns, deliveryExtraRuns,
            deliveryTotalRuns, deliveryPlayerDismissed, deliveryDismissalKind, deliveryFielder;

    public Delivery(String[] deliveries_array){
        this.deliveryId = deliveries_array[INDEX_DELIVERY_MATCH_ID];
        this.deliveryBattingTeam = deliveries_array[INDEX_BATTING_TEAM];
        this.deliveryExtraRuns = deliveries_array[INDEX_EXTRA_RUNS];
        this.deliveryBowler = deliveries_array[INDEX_BOWLER];
        this.deliveryTotalRuns = deliveries_array[INDEX_TOTAL_RUNS];
        this.deliveryFielder = deliveries_array[INDEX_FIELDER];
    }
    //--------------------------------Getter----------------------------------
    public String getDeliveryId() {
        return deliveryId;
    }
    public String getDeliveryBattingTeam() {
        return deliveryBattingTeam;
    }
    public String getDeliveryExtraRuns() {
        return deliveryExtraRuns;
    }
    public String getDeliveryBowler() {return deliveryBowler;}
    public String getDeliveryTotalRuns() {return deliveryTotalRuns;}
}

