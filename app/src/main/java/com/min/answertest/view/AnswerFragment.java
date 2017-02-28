package com.min.answertest.view;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hanks.htextview.HTextView;
import com.min.answertest.R;

/**
 * Created by w on 2017/2/28.
 */

public class AnswerFragment extends Fragment{

    private View rootView;

    private HTextView tvTitle;
    private HTextView tvQuestion;
    private HTextView tvA;
    private HTextView tvB;
    private HTextView tvC;
    private HTextView tvD;
    private HTextView tvRightTotal;
    private HTextView tvWrongTotal;
    private HTextView tvScore;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        if (rootView != null) {
            ViewGroup parent = (ViewGroup) rootView.getParent();
            if (parent != null) {
                parent.removeView(rootView);
            }
        } else {
            rootView = inflater.inflate(R.layout.fragment_answer, container, false);
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

    }

    private void initView() {
        tvTitle = (HTextView) rootView.findViewById(R.id.tv_title);
        tvQuestion = (HTextView) rootView.findViewById(R.id.tv_question);
        tvA = (HTextView) rootView.findViewById(R.id.tv_a);
        tvB = (HTextView) rootView.findViewById(R.id.tv_b);
        tvC = (HTextView) rootView.findViewById(R.id.tv_c);
        tvD = (HTextView) rootView.findViewById(R.id.tv_d);
        tvRightTotal = (HTextView) rootView.findViewById(R.id.tv_right_total);
        tvWrongTotal = (HTextView) rootView.findViewById(R.id.tv_wrong_total);
        tvScore = (HTextView) rootView.findViewById(R.id.tv_score);
    }

    private void initListener() {

    }

    private void initData() {
        tvTitle.animateText("历史题目");
        tvQuestion.animateText("1、金瓶挚签制度始于？");
        tvA.animateText("A、唐朝");
        tvB.animateText("B、元朝");
        tvC.animateText("C、明朝");
        tvD.animateText("D、清朝");
        tvRightTotal.animateText("答对：0 个");
        tvWrongTotal.animateText("答错：0 个");
        tvScore.animateText("得分：0 分");
    }

}
