package com.kelurahankepuharjo.nyobam5;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements RecyclerViewAdapter.ItemClickListener {

    private ArrayList<Model> list;
    RecyclerView recyclerview;

    public HomeFragment() {

    }

    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        initRecyclerView(view);
        return view;
    }
    private void initRecyclerView(View view) {
        RecyclerView recyclerView = view.findViewById(R.id.recycleView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());

        recyclerView.setLayoutManager(layoutManager);
        data();
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(list, this);
        recyclerView.setAdapter(adapter);
    }

    private void data() {
        list = new ArrayList<>();

        String[] titleModel = new String[]{
            getString(R.string.title1),
            getString(R.string.title2),
            getString(R.string.title3),
            getString(R.string.title4),
            getString(R.string.title5),
            getString(R.string.title6),
            getString(R.string.title7),
        };
        String[] subtitleModel = new String[]{
                getString(R.string.subtitle1),
                getString(R.string.subtitle2),
                getString(R.string.subtitle3),
                getString(R.string.subtitle4),
                getString(R.string.subtitle5),
                getString(R.string.subtitle4),
                getString(R.string.subtitle6),
        };
        int[] imageResource = new int[]{
            R.drawable.polije,
            R.drawable.polinema,
            R.drawable.semarang,
            R.drawable.pens,
            R.drawable.madiun,
            R.drawable.its,
            R.drawable.itb,
        };

        for (int i=0; i<titleModel.length; i++){
            Model model = new Model(titleModel[i],subtitleModel[i],imageResource[i]);
            list.add(model);
        }
    }

    @Override
    public void onItemClick(Model model) {
        Fragment fragment = BlankFragment.newInstance(model.getTitle(),model.getSubtitle(), model.getImagetitle());

        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();

        transaction.hide(getActivity().getSupportFragmentManager().findFragmentByTag("main_fragment"));
        transaction.add(R.id.frame, fragment);
        transaction.addToBackStack(null);
        transaction.commit();

    }
}