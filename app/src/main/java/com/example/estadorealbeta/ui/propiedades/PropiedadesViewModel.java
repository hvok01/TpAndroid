package com.example.estadorealbeta.ui.propiedades;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PropiedadesViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public PropiedadesViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is propiedades fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}