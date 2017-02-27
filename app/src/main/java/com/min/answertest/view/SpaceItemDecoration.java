package com.min.answertest.view;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by w on 2017/2/27.
 */

public class SpaceItemDecoration extends RecyclerView.ItemDecoration {

    private int space;

    SpaceItemDecoration(int space) {
        this.space = space;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent,
                               RecyclerView.State state) {
        outRect.left = space;
    }
}
