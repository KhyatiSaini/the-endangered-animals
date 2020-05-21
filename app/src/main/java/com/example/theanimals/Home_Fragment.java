package com.example.theanimals;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Home_Fragment extends Fragment implements Home_Adapter.SelectedAnimalHome{

    private RecyclerView homeRecyclerView;
    private Home_Adapter homeAdapter;
    private ArrayList<Home_Model> list;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment, container, false);
        homeRecyclerView = view.findViewById(R.id.recyclerViewHome);

        addingDataHome();
        buildRecyclerViewHome();

        return view;
    }

    private void buildRecyclerViewHome() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getActivity());
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        homeRecyclerView.setLayoutManager(linearLayoutManager);
        homeAdapter = new Home_Adapter(list, getContext(), this);
        homeRecyclerView.setAdapter(homeAdapter);
    }

    private void addingDataHome() {
        list = new ArrayList<>();
        list.add(new Home_Model(R.drawable.amurleopard,"Amur Leopard",R.drawable.arrow));
        list.add(new Home_Model(R.drawable.blackrhinos,"Black Rhino",R.drawable.arrow));
        list.add(new Home_Model(R.drawable.orangutan,"Bornean Orangutan",R.drawable.arrow));
        list.add(new Home_Model(R.drawable.crossrivergorilla,"Cross River Gorilla",R.drawable.arrow));
        list.add(new Home_Model(R.drawable.lowlandgorilla,"Eastern Lowland Gorilla",R.drawable.arrow));
        list.add(new Home_Model(R.drawable.hawksbilturtle,"Hawksbill Turtle",R.drawable.arrow));
        list.add(new Home_Model(R.drawable.javanrhino,"Javan Rhino",R.drawable.arrow));
        list.add(new Home_Model(R.drawable.orangutan,"Orangutan",R.drawable.arrow));
        list.add(new Home_Model(R.drawable.saola,"Saola",R.drawable.arrow));
        list.add(new Home_Model(R.drawable.sumatranelephant,"Sumatran Elephant",R.drawable.arrow));
        list.add(new Home_Model(R.drawable.sumatranorangutan,"Sumatran Orangutan",R.drawable.arrow));
        list.add(new Home_Model(R.drawable.sumatranrhino,"Sumatran Rhino",R.drawable.arrow));
        list.add(new Home_Model(R.drawable.siberiantiger,"Sunda Tiger",R.drawable.arrow));
        list.add(new Home_Model(R.drawable.vaquita,"Vaquita",R.drawable.arrow));
        list.add(new Home_Model(R.drawable.westrenlowlandgorilla,"Western Lowland Gorilla",R.drawable.arrow));
        list.add(new Home_Model(R.drawable.porpoise,"Yangtze Finless Porpoise",R.drawable.arrow));
    }


    @Override
    public void selectedAnimalHome(Home_Model homeModel, Context context) {
        Intent intent = new Intent(getContext(), InformationActivity.class);
        intent.putExtra("ImageURL", homeModel.getAnimalImageResource());
        intent.putExtra("AnimalName", homeModel.getNameOfAnimal());
        startActivity(intent);
    }
}
