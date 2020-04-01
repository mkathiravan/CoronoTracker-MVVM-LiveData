package net.kathir.livedata;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import net.kathir.livedata.service.RestApiService;
import net.kathir.livedata.service.RetrofitInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StateRepository {

    private static final String TAG = StateRepository.class.getSimpleName();

    private ArrayList<RegionalModel> regional = new ArrayList<>();

   // private MutableLiveData<List<RegionalModel>> mutableLiveData = new MutableLiveData<>();

    private MutableLiveData<ResponseModel> mutableLiveData = new MutableLiveData<>();

    private Application application;

    public StateRepository(Application application)
    {
        this.application = application;
    }



    public MutableLiveData<ResponseModel> getMutableLiveData()
    {
        RestApiService apiService = RetrofitInstance.getApiService();

        Call<ResponseModel> call = apiService.getResponseData();

        call.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {

                Log.d(TAG,"RESPINSE_MODEL " + response);

                ResponseModel responseModel = response.body();

                if(responseModel != null && responseModel.getmData()!= null)
                {
                    regional = (ArrayList<RegionalModel>) responseModel.getmData().getRegional();

                    mutableLiveData.setValue(responseModel);


                    //mutableLiveData.setValue(regional);
                }
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {

            }
        });

        return mutableLiveData;
    }


}
