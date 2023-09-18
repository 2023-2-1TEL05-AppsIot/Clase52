package com.example.clase5.viewModels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.clase5.entity.Persona;

import java.util.List;

public class MainActivityViewModel extends ViewModel {

    MutableLiveData<List<Persona>> listMutableLiveData = new MutableLiveData<>();
    MutableLiveData<String> texto = new MutableLiveData<>();

    public MutableLiveData<List<Persona>> getListMutableLiveData() {
        return listMutableLiveData;
    }

    public MutableLiveData<String> getTexto() {
        return texto;
    }
}
