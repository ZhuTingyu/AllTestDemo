package com.live.demo.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.live.demo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TingYu Zhu on 2017/9/18.
 */

public class MainListAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

    public MainListAdapter() {
        super(R.layout.item_line_text_layout, new ArrayList<>());
    }

    @Override
    protected void convert(BaseViewHolder holder, String item) {
        holder.setText(R.id.title, item);
    }
}
