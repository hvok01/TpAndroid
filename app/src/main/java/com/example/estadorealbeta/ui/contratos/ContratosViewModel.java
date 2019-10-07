package com.example.estadorealbeta.ui.contratos;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ContratosViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ContratosViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is contratos fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}