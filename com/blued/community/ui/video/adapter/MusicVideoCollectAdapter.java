package com.blued.community.ui.video.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.blued.android.core.image.ImageLoadResult;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.community.R;
import com.blued.community.model.BluedIngSelfFeed;
import com.blued.community.ui.video.fragment.VideoScanFragment;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

/* loaded from: source-7206380-dex2jar.jar:com/blued/community/ui/video/adapter/MusicVideoCollectAdapter.class */
public class MusicVideoCollectAdapter extends BaseQuickAdapter<BluedIngSelfFeed, BaseViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    private Context f20290a;
    private IRequestHost b;

    /* renamed from: c  reason: collision with root package name */
    private String f20291c;

    public MusicVideoCollectAdapter(Context context, IRequestHost iRequestHost) {
        super(R.layout.item_music_video_collect);
        this.f20290a = context;
        this.b = iRequestHost;
    }

    private boolean b(String str) {
        if (TextUtils.isEmpty(this.f20291c) || TextUtils.isEmpty(str)) {
            return false;
        }
        return this.f20291c.equals(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, final BluedIngSelfFeed bluedIngSelfFeed) {
        if (baseViewHolder != null) {
            final ImageView imageView = (ImageView) baseViewHolder.getView(R.id.iv_cover);
            if (bluedIngSelfFeed.feed_videos == null || bluedIngSelfFeed.feed_videos.length <= 0) {
                imageView.setImageResource(R.drawable.defaultpicture);
            } else {
                ImageLoader.a(this.b, bluedIngSelfFeed.feed_videos[0]).b(R.drawable.defaultpicture).a(new ImageLoadResult(this.b) { // from class: com.blued.community.ui.video.adapter.MusicVideoCollectAdapter.1
                    @Override // com.blued.android.core.image.ImageLoadResult
                    public void a() {
                        Drawable drawable = imageView.getDrawable();
                        if (drawable == null) {
                            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        } else if (drawable.getIntrinsicWidth() > drawable.getIntrinsicHeight()) {
                            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                        } else {
                            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        }
                    }
                }).a(imageView);
            }
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.video.adapter.MusicVideoCollectAdapter.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    VideoScanFragment.a(MusicVideoCollectAdapter.this.f20290a, bluedIngSelfFeed, true, 17);
                }
            });
            if (b(bluedIngSelfFeed.feed_id)) {
                baseViewHolder.setGone(R.id.tv_first, true);
            } else {
                baseViewHolder.setGone(R.id.tv_first, false);
            }
        }
    }

    public void a(String str) {
        this.f20291c = str;
    }
}
