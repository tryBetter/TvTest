package com.min.answertest.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.min.answertest.R;
import com.min.answertest.bean.CardInfo;

import java.util.List;

/**
 * Created by w on 2017/2/26.
 */

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.CardHolder> {

    private LayoutInflater inflater;
    private Context context;
    private List<CardInfo> dataList;

    public RecycleAdapter(Context context, List<CardInfo> dataList) {
        this.context = context;
        this.dataList = dataList;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public RecycleAdapter.CardHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.item_card, null);
        return new CardHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecycleAdapter.CardHolder holder, int position) {
        holder.tvTitle.setText(dataList.get(position).title);
    }

    @Override
    public int getItemCount() {
        return dataList == null ? 0 : dataList.size();
    }

    static class CardHolder extends RecyclerView.ViewHolder {

        private TextView tvTitle;

        public CardHolder(View itemView) {
            super(itemView);
            tvTitle = (TextView) itemView.findViewById(R.id.tv_card_title);
        }
    }
}
