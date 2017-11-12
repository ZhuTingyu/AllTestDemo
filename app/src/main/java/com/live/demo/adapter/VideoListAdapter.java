package com.live.demo.adapter;


import android.net.Uri;
import android.widget.FrameLayout;
import android.widget.MediaController;
import android.widget.VideoView;

import com.biz.base.BaseViewHolder;
import com.biz.util.Lists;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.live.demo.R;


import org.opencv.video.Video;

import cn.jzvd.JZVideoPlayerStandard;

/**
 * Created by TingYu Zhu on 2017/11/11.
 */

public class VideoListAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

    public VideoListAdapter() {
        super(R.layout.item_vedio_list_layout, Lists.newArrayList());
    }

    @Override
    protected void convert(BaseViewHolder holder, String item) {
        /*JZVideoPlayerStandard jzVideoPlayerStandard = (JZVideoPlayerStandard) helper.getView(R.id.videoplayer);
        jzVideoPlayerStandard.setUp(item
                , JZVideoPlayerStandard.SCREEN_STATE_ON, "饺子闭眼睛");*/

        /*FrameLayout fl = holder.getView(R.id.fl);
        VideoView videoView = holder.getView(R.id.video_view);
        videoView.setVideoURI(Uri.parse(item));
        videoView.setMediaController(new MediaController(fl.getContext()));

        holder.getView(R.id.play).setOnClickListener(v -> {
            videoView.start();
        });*/

        /*McoyVideoView videoView = ((McoyVideoView) holder.getView(R.id.videoView));

        videoView.setVideoUrl(item);*/
    }



}
