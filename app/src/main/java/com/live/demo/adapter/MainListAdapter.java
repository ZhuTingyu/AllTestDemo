
package com.live.demo.adapter;

import android.support.annotation.Nullable;
import android.widget.TextSwitcher;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.live.demo.R;
import com.live.demo.viewmodel.StringListViewModel;
import com.live.demo.viewmodel.StringListViewModel;

import org.w3c.dom.Entity;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by TingYu Zhu on 2017/9/18.
 */


public class MainListAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

    private StringListViewModel viewModel;


public MainListAdapter(StringListViewModel viewModel) {
        super(R.layout.item_line_text_layout, new ArrayList<>());
        this.viewModel = viewModel;
    }


    @Override
    protected void convert(BaseViewHolder holder, String item) {
        TextSwitcher textSwitcher = holder.getView(R.id.text_switcher);
        textSwitcher.setCurrentText(String.valueOf(item));

        holder.itemView.setOnClickListener(view -> {
            int itemDate = Integer.parseInt(mData.get(holder.getAdapterPosition()));
            itemDate += 1;
            mData.set(holder.getAdapterPosition(), String.valueOf(itemDate));
            TextSwitcher switcher = view.findViewById(R.id.text_switcher);
            switcher.setText(String.valueOf(itemDate));
        });
    }
}

