package com.example.estadorealbeta.ui.pagos;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PagosViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public PagosViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is pagos fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}