package com.blued.community.ui.video.adapter;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.common.utils.AvatarUtils;
import com.blued.community.R;
import com.blued.community.ui.video.model.VideoScanMusic;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

/* loaded from: source-7206380-dex2jar.jar:com/blued/community/ui/video/adapter/MyMusicCollectionAdapter.class */
public class MyMusicCollectionAdapter extends BaseQuickAdapter<VideoScanMusic, BaseViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    private Context f20294a;
    private IRequestHost b;

    public MyMusicCollectionAdapter(Context context, IRequestHost iRequestHost) {
        super(R.layout.item_my_music_collection);
        this.f20294a = context;
        this.b = iRequestHost;
    }

    private String a(long j) {
        if (j >= 60) {
            return (j / 60) + ":" + (j % 60);
        } else if (j > 0) {
            return "0:" + j;
        } else {
            return "";
        }
    }

    public void a() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mData.size()) {
                notifyDataSetChanged();
                return;
            } else {
                ((VideoScanMusic) this.mData.get(i2)).isPlaying = false;
                i = i2 + 1;
            }
        }
    }

    public void a(VideoScanMusic videoScanMusic) {
        if (videoScanMusic.isPlaying) {
            videoScanMusic.isPlaying = false;
        } else {
            a();
            videoScanMusic.isPlaying = true;
        }
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, VideoScanMusic videoScanMusic) {
        if (baseViewHolder != null) {
            ImageLoader.a(this.b, AvatarUtils.a(1, videoScanMusic.music_cover)).b(R.drawable.user_bg_round).c().a((ImageView) baseViewHolder.getView(R.id.iv_cover));
            FrameLayout frameLayout = (FrameLayout) baseViewHolder.getView(R.id.layout_cover);
            ImageView imageView = (ImageView) baseViewHolder.getView(R.id.iv_music_play);
            if (videoScanMusic.isPlaying) {
                imageView.setImageResource(R.drawable.video_scan_music_pause_icon);
                Animation loadAnimation = AnimationUtils.loadAnimation(this.f20294a, R.anim.anim_music_cover_rotate_repeat);
                loadAnimation.setInterpolator(new LinearInterpolator());
                frameLayout.startAnimation(loadAnimation);
            } else {
                imageView.setImageResource(R.drawable.video_scan_music_play_icon);
                frameLayout.clearAnimation();
            }
            baseViewHolder.setText(R.id.tv_music_name, videoScanMusic.music_name);
            baseViewHolder.setText(R.id.tv_music_time, a((long) videoScanMusic.music_duration));
            baseViewHolder.addOnClickListener(R.id.stv_use);
            baseViewHolder.addOnClickListener(R.id.iv_collection);
            baseViewHolder.addOnClickListener(R.id.layout_cover);
        }
    }
}
