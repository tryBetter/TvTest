package com.min.answertest.view;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.min.answertest.R;
import com.min.answertest.bean.CardInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by w on 2017/2/26.
 */

public class MainFragment extends Fragment {

    private View rootView;

    private RecyclerView recyclerCard;

    private List<CardInfo> dataList = new ArrayList<>();

    private String[] titleList = {"历史题目","人文题目","地理题目","急转弯题目"};

    private RecycleAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (rootView != null) {
            ViewGroup parent = (ViewGroup) rootView.getParent();
            if (parent != null) {
                parent.removeView(rootView);
            }
        } else {
            rootView = inflater.inflate(R.layout.fragment_main, container, false);
            initialize();
        }

        return rootView;
    }

    private void initialize() {
        initParams();
        initView();
        initData();
    }

    private void initData() {
        for(String title : titleList){
            dataList.add(new CardInfo(title,R.mipmap.ic_launcher,""));
        }
        adapter.notifyDataSetChanged();
    }

    private void initParams() {
        adapter = new RecycleAdapter(getActivity(),dataList);
    }

    private void initView() {
        recyclerCard = (RecyclerView) rootView.findViewById(R.id.recycler_card);
        recyclerCard.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));
        recyclerCard.setAdapter(adapter);
    }
}
