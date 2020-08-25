package com.example.electronicapplication.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class HomeViewModel extends ViewModel {

    static List<HomeViewModel> listcategory=new ArrayList<>();
    private int img;


    public HomeViewModel(int img) {
        this.img = img;
    }


    public static List<HomeViewModel> getListcategory() {
        return listcategory;
    }



    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}