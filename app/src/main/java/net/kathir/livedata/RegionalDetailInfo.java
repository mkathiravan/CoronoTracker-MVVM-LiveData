package net.kathir.livedata;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class RegionalDetailInfo extends Activity {

    private static final String TAG = RegionalDetailInfo.class.getSimpleName();

    TextView confirmIndian,confirmForeign,noOfDeaths,noOfDischarged;

    RegionalModel regionalModel;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.regional_detail);

        try
        {
            regionalModel = (RegionalModel) getIntent().getParcelableExtra("region_mode");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }




        confirmIndian = (TextView)findViewById(R.id.confirmed_cases_indian);
        confirmForeign = (TextView)findViewById(R.id.confirmed_cases_foreign);
        noOfDeaths = (TextView)findViewById(R.id.no_of_deaths);
        noOfDischarged = (TextView)findViewById(R.id.no_of_discharged);

        confirmIndian.setText("No.of Indians : " + regionalModel.getConfirmedCasesIndian());
        confirmForeign.setText("No.of Foregins : " + regionalModel.getConfirmedCasesForeign());
        noOfDeaths.setText("No.of Deaths so far : " + regionalModel.getDeaths());
        noOfDischarged.setText("No.of Dischared " + regionalModel.getDischarged());


    }
}
