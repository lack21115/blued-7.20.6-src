package com.soft.blued.ui.feed.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.community.ui.send.model.ChildImageInfo;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.customview.DragGridBaseAdapter;
import com.soft.blued.utils.StringUtils;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/feed/adapter/NewsFeedGirdAdapter.class */
public class NewsFeedGirdAdapter extends BaseAdapter implements DragGridBaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    private IRequestHost f29870a;
    private LayoutInflater b;

    /* renamed from: c  reason: collision with root package name */
    private int f29871c = -1;
    private List<ChildImageInfo> d;
    private OnClickDeletePhotoListener e;

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/feed/adapter/NewsFeedGirdAdapter$OnClickDeletePhotoListener.class */
    public interface OnClickDeletePhotoListener {
        void a(int i);
    }

    public NewsFeedGirdAdapter(Context context, IRequestHost iRequestHost, List<ChildImageInfo> list) {
        this.b = LayoutInflater.from(context);
        this.f29870a = iRequestHost;
        this.d = list;
    }

    public void a(OnClickDeletePhotoListener onClickDeletePhotoListener) {
        this.e = onClickDeletePhotoListener;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.d.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.d.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        View inflate = this.b.inflate(R.layout.item_news_feed_photo_show, viewGroup, false);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.iv_feed_photo);
        ImageView imageView2 = (ImageView) inflate.findViewById(R.id.iv_feed_add);
        ImageView imageView3 = (ImageView) inflate.findViewById(2131365254);
        ImageView imageView4 = (ImageView) inflate.findViewById(R.id.iv_video_preview);
        ChildImageInfo childImageInfo = this.d.get(i);
        if (StringUtils.d(childImageInfo.mImagePath)) {
            imageView.setVisibility(8);
            imageView2.setVisibility(0);
            imageView3.setVisibility(8);
            imageView4.setVisibility(8);
            imageView2.setBackgroundResource(2131232686);
        } else {
            (childImageInfo.mImagePath.contains("http") ? ImageLoader.a(this.f29870a, childImageInfo.mImagePath) : ImageLoader.d(this.f29870a, childImageInfo.mImagePath)).b(2131232687).a(imageView);
            imageView3.setVisibility(0);
            if (childImageInfo.isVideo) {
                imageView4.setVisibility(0);
            }
            imageView3.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.feed.adapter.NewsFeedGirdAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Tracker.onClick(view2);
                    NewsFeedGirdAdapter.this.e.a(i);
                }
            });
        }
        if (i == this.f29871c) {
            inflate.setVisibility(4);
        }
        return inflate;
    }
}
