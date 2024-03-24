package com.example.skillswap;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.lorentzos.flingswipe.SwipeFlingAdapterView;

import java.util.ArrayList;
import java.util.List;

public class Home extends Fragment {

    private ArrayAdapter<String> arrayAdapter;
    List<String> data;
    SwipeFlingAdapterView flingAdapterView;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {


        return inflater.inflate(R.layout.fragment_home, container, false);

    }
}