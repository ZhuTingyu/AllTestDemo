package com.live.demo.adapter;


import com.biz.base.BaseViewHolder;
import com.biz.util.Lists;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.live.demo.R;


import cn.jzvd.JZVideoPlayerStandard;

/**
 * Created by TingYu Zhu on 2017/11/11.
 */

public class VideoListAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

    public VideoListAdapter() {
        super(R.layout.item_vedio_list_layout, Lists.newArrayList());
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        JZVideoPlayerStandard jzVideoPlayerStandard = (JZVideoPlayerStandard) helper.getView(R.id.videoplayer);
        jzVideoPlayerStandard.setUp(item
                , JZVideoPlayerStandard.SCREEN_STATE_ON, "饺子闭眼睛");
    }



}
