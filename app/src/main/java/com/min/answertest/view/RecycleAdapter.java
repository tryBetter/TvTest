package com.min.answertest.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.min.answertest.R;
import com.min.answertest.bean.CardInfo;

import java.util.List;

/**
 * Created by w on 2017/2/26.
 */

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.CardHolder> {

    private LayoutInflater inflater;
    private List<CardInfo> dataList;
    private OnItemStateListener mListener;

    public RecycleAdapter(Context context, List<CardInfo> dataList) {
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
        holder.imageTop.setImageResource(dataList.get(position).ImageId);
    }

    @Override
    public int getItemCount() {
        return dataList == null ? 0 : dataList.size();
    }

    class CardHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnFocusChangeListener {

        private TextView tvTitle;
        private ImageView imageTop;
        FocusRelativeLayout mRelativeLayout;

        public CardHolder(View itemView) {
            super(itemView);
            tvTitle = (TextView) itemView.findViewById(R.id.tv_card_title);
            imageTop = (ImageView) itemView.findViewById(R.id.img_type);
            mRelativeLayout = (FocusRelativeLayout) itemView.findViewById(R.id.layout_focuse);
            mRelativeLayout.setOnClickListener(this);
            mRelativeLayout.setOnFocusChangeListener(this);
        }

        @Override
        public void onClick(View v) {
            if (mListener != null) {
                mListener.onItemClick(v, getAdapterPosition());
            }
        }

        @Override
        public void onFocusChange(View v, boolean hasFocus) {
            if (mListener != null) {
                mListener.onFocuseChange(v, getAdapterPosition());
            }
        }
    }

    public void setOnItemStateListener(OnItemStateListener listener) {
        mListener = listener;
    }

    public interface OnItemStateListener {
        void onItemClick(View view, int position);
        void onFocuseChange(View view, int position);
    }
}
