package net.kathir.livedata;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class InfoModel {

    @SerializedName("summary")
    private SummaryModel summary;

    @SerializedName("regional")
    private List<RegionalModel> regional;


    public SummaryModel getSummary() {
        return summary;
    }

    public void setSummary(SummaryModel summary) {
        this.summary = summary;
    }

    public List<RegionalModel> getRegional() {
        return regional;
    }

    public void setRegional(List<RegionalModel> regional) {
        this.regional = regional;
    }
}
