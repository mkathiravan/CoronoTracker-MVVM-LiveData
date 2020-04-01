package net.kathir.livedata;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class MainViewModel extends AndroidViewModel {

    private StateRepository stateRepository;


    public MainViewModel(@NonNull Application application) {
        super(application);
        stateRepository = new StateRepository(application);
    }

    public LiveData<ResponseModel> getAllRegional()
    {
        return stateRepository.getMutableLiveData();
    }
}
