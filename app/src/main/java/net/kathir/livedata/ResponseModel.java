package net.kathir.livedata;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseModel {

    @SerializedName("data")
    private InfoModel mData;

    @SerializedName("lastRefreshed")
    private String lastRefreshed;

    @SerializedName("lastOriginUpdate")
    private String lastOriginUpdate;


    public InfoModel getmData() {
        return mData;
    }

    public void setmData(InfoModel mData) {
        this.mData = mData;
    }

    public String getLastRefreshed() {
        return lastRefreshed;
    }

    public void setLastRefreshed(String lastRefreshed) {
        this.lastRefreshed = lastRefreshed;
    }

    public String getLastOriginUpdate() {
        return lastOriginUpdate;
    }

    public void setLastOriginUpdate(String lastOriginUpdate) {
        this.lastOriginUpdate = lastOriginUpdate;
    }



}
