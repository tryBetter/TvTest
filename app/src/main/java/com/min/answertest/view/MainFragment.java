package com.min.answertest.view;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.hanks.htextview.HTextView;
import com.min.answertest.R;
import com.min.answertest.bean.CardInfo;
import com.min.answertest.util.MyTexts;

import java.util.ArrayList;
import java.util.List;

import me.zhanghai.android.materialratingbar.MaterialRatingBar;

/**
 * Created by w on 2017/2/26.
 */

public class MainFragment extends Fragment {

    private View rootView;

    private ScaleRecyclerView recyclerCard;

    private List<CardInfo> dataList = new ArrayList<>();

    private HTextView tvKeyword;
    private MaterialRatingBar rbLevel;
    private HTextView tvHighScore;

    private String[] titleList = {"历史题目", "人文题目", "地理题目", "急转弯题目"};
    private int[] imageList = {R.drawable.history, R.drawable.people, R.drawable.timg, R.drawable.turnhead};
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
        initListener();
        initData();
    }

    private void initParams() {
        adapter = new RecycleAdapter(getActivity(), dataList);
    }

    private void initView() {
        recyclerCard = (ScaleRecyclerView) rootView.findViewById(R.id.recycler_card);
        tvKeyword = (HTextView) rootView.findViewById(R.id.tv_keyword);
        rbLevel = (MaterialRatingBar) rootView.findViewById(R.id.rb_level);
        rbLevel.setNumStars(10);
        rbLevel.setFocusable(false);
        rbLevel.setFocusableInTouchMode(false);
        rbLevel.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });
        tvHighScore = (HTextView) rootView.findViewById(R.id.tv_high_score);
        recycleViewSetup();
    }

    private void initListener() {
        adapter.setOnItemStateListener(new RecycleAdapter.OnItemStateListener() {
            @Override
            public void onItemClick(View view, int position) {
                    startActivity(new Intent(getActivity(),AnswerActivity.class));
                    setInfoTexts(position);
            }

            @Override
            public void onFocuseChange(View view, int position) {
                setInfoTexts(position);
            }
        });
    }

    private void initData() {
        for (int i = 0; i < titleList.length; i++) {
            dataList.add(new CardInfo(titleList[i], imageList[i], ""));
        }
        adapter.notifyDataSetChanged();
        setInfoTexts(0);
    }

    private void recycleViewSetup() {
        LinearLayoutManager llmanager =
                new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recyclerCard.setLayoutManager(llmanager);

        int itemSpace = getResources().
                getDimensionPixelSize(R.dimen.dp20);
        recyclerCard.addItemDecoration(new SpaceItemDecoration(itemSpace));
        recyclerCard.setAdapter(adapter);
    }

    private void setInfoTexts(int position){
        tvKeyword.animateText("题目类型："+MyTexts.KEY_WORD[position]);
        tvHighScore.animateText("最高分："+MyTexts.HIGH_SCORE[position]);
        rbLevel.setProgress(MyTexts.LEVEL[position]);
    }
}
