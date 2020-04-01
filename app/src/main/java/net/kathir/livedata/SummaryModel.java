package net.kathir.livedata;

import com.google.gson.annotations.SerializedName;

public class SummaryModel {

    @SerializedName("total")
    private String total;
    @SerializedName("confirmedCasesIndian")
    private String confirmedCasesIndian;
    @SerializedName("confirmedCasesForeign")
    private String confirmedCasesForeign;
    @SerializedName("discharged")
    private String discharged;
    @SerializedName("deaths")
    private String deaths;
    @SerializedName("confirmedButLocationUnidentified")
    private String confirmedButLocationUnidentified;


    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getConfirmedCasesIndian() {
        return confirmedCasesIndian;
    }

    public void setConfirmedCasesIndian(String confirmedCasesIndian) {
        this.confirmedCasesIndian = confirmedCasesIndian;
    }

    public String getConfirmedCasesForeign() {
        return confirmedCasesForeign;
    }

    public void setConfirmedCasesForeign(String confirmedCasesForeign) {
        this.confirmedCasesForeign = confirmedCasesForeign;
    }

    public String getDischarged() {
        return discharged;
    }

    public void setDischarged(String discharged) {
        this.discharged = discharged;
    }

    public String getDeaths() {
        return deaths;
    }

    public void setDeaths(String deaths) {
        this.deaths = deaths;
    }

    public String getConfirmedButLocationUnidentified() {
        return confirmedButLocationUnidentified;
    }

    public void setConfirmedButLocationUnidentified(String confirmedButLocationUnidentified) {
        this.confirmedButLocationUnidentified = confirmedButLocationUnidentified;
    }


}
