package net.kathir.livedata;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements RegionalAdapter.DataFromAdapterToActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    RecyclerView mRecyclerView;
    SwipeRefreshLayout swipeRefresh;
    private MainViewModel mainViewModel;
    RegionalAdapter regionalAdapter;
    TextView totalCount,noOfIndians,noOfForeign,deaths,discharged,noOfUnidentified;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializationViews();
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        getRegionalData();

        swipeRefresh.setOnRefreshListener(() -> {
            getRegionalData();
        });
    }

    public void getRegionalData() {
        swipeRefresh.setRefreshing(true);

        mainViewModel.getAllRegional().observe(this, new Observer<ResponseModel>() {
            @Override
            public void onChanged(ResponseModel responseModel) {

                swipeRefresh.setRefreshing(false);
                prepareRecycelrView(responseModel);


                totalCount.setText("Total Victims : " +responseModel.getmData().getSummary().getTotal());
                noOfIndians.setText("No.of Indians : " + responseModel.getmData().getSummary().getConfirmedCasesIndian());
                noOfForeign.setText("No.of Foreigns : " + responseModel.getmData().getSummary().getConfirmedCasesForeign());
                deaths.setText("Death count : " + responseModel.getmData().getSummary().getDeaths());
                discharged.setText("Discharged people so far : " + responseModel.getmData().getSummary().getDischarged());
                noOfUnidentified.setText("No.of Unidentified : " + responseModel.getmData().getSummary().getConfirmedButLocationUnidentified());


            }
        });

//
//        mainViewModel.getAllRegional().observe(this, new Observer<List<RegionalModel>>() {
//            @Override
//            public void onChanged(List<RegionalModel> regionalModelsList) {
//
//                Log.d(TAG,"REGIONMODEL_LIST " + regionalModelsList);
//
//                swipeRefresh.setRefreshing(false);
//                prepareRecycelrView(regionalModelsList);
//            }
//        });


    }

    private void prepareRecycelrView(ResponseModel responseModel) {


        List<RegionalModel> regionalModelsList = responseModel.getmData().getRegional();

        regionalAdapter = new RegionalAdapter(this,regionalModelsList,this);
        if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        } else {
            mRecyclerView.setLayoutManager(new GridLayoutManager(this, 4));
        }
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(regionalAdapter);
        regionalAdapter.notifyDataSetChanged();

    }

    private void initializationViews() {
        swipeRefresh = findViewById(R.id.swiperefresh);
        totalCount = findViewById(R.id.total_count);
        noOfIndians = findViewById(R.id.no_indian);
        noOfForeign = findViewById(R.id.no_foreign);
        deaths = findViewById(R.id.no_deaths);
        discharged = findViewById(R.id.discharged);
        noOfUnidentified = findViewById(R.id.no_unidentified);
        mRecyclerView = findViewById(R.id.blogRecyclerView);
    }

    @Override
    public void getRegionalInfo(RegionalModel regionalModel) {

        Intent intent = new Intent(MainActivity.this,RegionalDetailInfo.class);
        intent.putExtra("region_mode",regionalModel);
        startActivity(intent);

    }
}
