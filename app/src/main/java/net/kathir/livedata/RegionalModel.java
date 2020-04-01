package net.kathir.livedata;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class RegionalModel implements Parcelable {

    @SerializedName("loc")
    private String loc;

    @SerializedName("confirmedCasesIndian")
    private int confirmedCasesIndian;

    @SerializedName("discharged")
    private int discharged;

    @SerializedName("deaths")
    private int deaths;

    @SerializedName("confirmedCasesForeign")
    private int confirmedCasesForeign;

    protected RegionalModel(Parcel in) {
        loc = in.readString();
        confirmedCasesIndian = in.readInt();
        discharged = in.readInt();
        deaths = in.readInt();
        confirmedCasesForeign = in.readInt();
    }

    public static final Creator<RegionalModel> CREATOR = new Creator<RegionalModel>() {
        @Override
        public RegionalModel createFromParcel(Parcel in) {
            return new RegionalModel(in);
        }

        @Override
        public RegionalModel[] newArray(int size) {
            return new RegionalModel[size];
        }
    };

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public int getConfirmedCasesIndian() {
        return confirmedCasesIndian;
    }

    public void setConfirmedCasesIndian(int confirmedCasesIndian) {
        this.confirmedCasesIndian = confirmedCasesIndian;
    }

    public int getDischarged() {
        return discharged;
    }

    public void setDischarged(int discharged) {
        this.discharged = discharged;
    }

    public int getDeaths() {
        return deaths;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    public int getConfirmedCasesForeign() {
        return confirmedCasesForeign;
    }

    public void setConfirmedCasesForeign(int confirmedCasesForeign) {
        this.confirmedCasesForeign = confirmedCasesForeign;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(loc);
        parcel.writeInt(confirmedCasesIndian);
        parcel.writeInt(discharged);
        parcel.writeInt(deaths);
        parcel.writeInt(confirmedCasesForeign);
    }
}
