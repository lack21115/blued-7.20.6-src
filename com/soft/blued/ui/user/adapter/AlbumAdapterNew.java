package com.soft.blued.ui.user.adapter;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.community.model.AlbumFlow;
import com.blued.community.model.BluedIngSelfFeed;
import com.blued.community.ui.comment.model.FeedComment;
import com.blued.community.ui.eventbus.BusFeedInteractModel;
import com.blued.community.ui.feed.model.FeedRepost;
import com.blued.community.ui.feed.observer.IFeedDataObserver;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.R;
import com.soft.blued.utils.StringUtils;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/adapter/AlbumAdapterNew.class */
public class AlbumAdapterNew extends BaseQuickAdapter<AlbumFlow, BaseViewHolder> implements IFeedDataObserver {

    /* renamed from: a  reason: collision with root package name */
    public int f33730a;
    public int b;

    /* renamed from: c  reason: collision with root package name */
    public int f33731c;
    public int d;
    public RecyclerView.OnScrollListener e;
    private Context f;
    private ActivityFragmentActive g;

    public AlbumAdapterNew(Context context, ActivityFragmentActive activityFragmentActive) {
        super(R.layout.userinfo_album_item, new ArrayList());
        this.b = 3;
        this.e = new RecyclerView.OnScrollListener() { // from class: com.soft.blued.ui.user.adapter.AlbumAdapterNew.1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
            }
        };
        this.f = context;
        this.g = activityFragmentActive;
        this.f33731c = context.getResources().getDisplayMetrics().widthPixels;
        int a2 = DensityUtils.a(this.f, 3.0f);
        this.d = a2;
        this.f33730a = ((this.f33731c - (a2 * this.b)) - DensityUtils.a(this.f, 3.0f)) / this.b;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    public void addData(int i, AlbumFlow albumFlow) {
        if (this.mData == null || this.mData.size() <= 0 || !((AlbumFlow) this.mData.get(0)).showApply) {
            super.addData(i, (int) albumFlow);
        }
    }

    @Override // com.blued.community.ui.feed.observer.IFeedDataObserver
    public void a(BluedIngSelfFeed bluedIngSelfFeed) {
        String str = bluedIngSelfFeed == null ? "" : bluedIngSelfFeed.feed_id;
        if (StringUtils.d(str)) {
            return;
        }
        Iterator it = this.mData.iterator();
        while (it.hasNext()) {
            if (str.equals(((AlbumFlow) it.next()).feed_id)) {
                it.remove();
            }
        }
        notifyDataSetChanged();
    }

    @Override // com.blued.community.ui.feed.observer.IFeedDataObserver
    public void a(FeedComment feedComment) {
        if (StringUtils.d(feedComment.feed_id)) {
            return;
        }
        for (AlbumFlow albumFlow : this.mData) {
            if (feedComment.feed_id.equals(albumFlow.feed_id)) {
                albumFlow.feed_comment++;
            }
        }
        notifyDataSetChanged();
    }

    @Override // com.blued.community.ui.feed.observer.IFeedDataObserver
    public void a(BusFeedInteractModel busFeedInteractModel) {
    }

    @Override // com.blued.community.ui.feed.observer.IFeedDataObserver
    public void a(FeedRepost feedRepost) {
        if (StringUtils.d(feedRepost.feed_id)) {
            return;
        }
        for (AlbumFlow albumFlow : this.mData) {
            if (feedRepost.feed_id.equals(albumFlow.feed_id)) {
                albumFlow.repost_count++;
            }
        }
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, AlbumFlow albumFlow) {
        if (baseViewHolder != null) {
            FrameLayout frameLayout = (FrameLayout) baseViewHolder.getView(2131363859);
            GridLayoutManager.LayoutParams layoutParams = (GridLayoutManager.LayoutParams) frameLayout.getLayoutParams();
            layoutParams.width = this.f33730a;
            layoutParams.height = this.f33730a;
            layoutParams.bottomMargin = this.d;
            layoutParams.rightMargin = this.d;
            if (baseViewHolder.getAdapterPosition() <= 2) {
                layoutParams.topMargin = DensityUtils.a(this.f, 16.0f);
            } else {
                layoutParams.topMargin = 0;
            }
            frameLayout.setLayoutParams(layoutParams);
            ImageView imageView = (ImageView) baseViewHolder.getView(2131364232);
            ImageView imageView2 = (ImageView) baseViewHolder.getView(R.id.icon_play);
            ImageView imageView3 = (ImageView) baseViewHolder.getView(2131364595);
            TextView textView = (TextView) baseViewHolder.getView(R.id.lock_state);
            if ("1".equals(albumFlow.is_videos)) {
                imageView2.setVisibility(0);
            } else {
                imageView2.setVisibility(8);
            }
            if (!albumFlow.showApply) {
                imageView3.setVisibility(8);
                textView.setVisibility(8);
                ImageLoader.a(this.g, albumFlow.album_pic).a(6.0f).b(2131232687).a(imageView);
                return;
            }
            imageView3.setVisibility(0);
            textView.setVisibility(0);
            textView.setText(albumFlow.lockText);
            String imageMogr = (albumFlow.feed_pics_width == null || albumFlow.feed_pics_width.length <= 0 || StringUtils.a(albumFlow.feed_pics_width[0], 0) <= 0 || albumFlow.feed_pics_height == null || albumFlow.feed_pics_height.length <= 0 || StringUtils.a(albumFlow.feed_pics_height[0], 0) <= 0 || StringUtils.a(albumFlow.feed_pics_height[0], 0) <= StringUtils.a(albumFlow.feed_pics_width[0], 0) * 3) ? "" : albumFlow.getImageMogr(true);
            ActivityFragmentActive activityFragmentActive = this.g;
            ImageLoader.a(activityFragmentActive, albumFlow.album_pic + imageMogr).a(6.0f).b(R.drawable.private_album_icon).d(R.drawable.private_album_icon).d().a(imageView);
        }
    }

    @Override // com.blued.community.ui.feed.observer.IFeedDataObserver
    public void a(String str, int i) {
        if (StringUtils.d(str)) {
            return;
        }
        for (AlbumFlow albumFlow : this.mData) {
            if (str.equals(albumFlow.feed_id)) {
                albumFlow.allow_comments = i;
            }
        }
        notifyDataSetChanged();
    }

    @Override // com.blued.community.ui.feed.observer.IFeedDataObserver
    public void a(String str, String str2) {
        if (StringUtils.d(str)) {
            return;
        }
        for (AlbumFlow albumFlow : this.mData) {
            if (str.equals(albumFlow.feed_id)) {
                int i = albumFlow.feed_comment;
                int i2 = i;
                if (i >= 1) {
                    i2 = i - 1;
                }
                albumFlow.feed_comment = i2;
            }
        }
        notifyDataSetChanged();
    }

    @Override // com.blued.community.ui.feed.observer.IFeedDataObserver
    public void b(BluedIngSelfFeed bluedIngSelfFeed) {
    }

    @Override // com.blued.community.ui.feed.observer.IFeedDataObserver
    public void b(String str, int i) {
        if (StringUtils.d(str)) {
            return;
        }
        for (AlbumFlow albumFlow : this.mData) {
            if (str.equals(albumFlow.feed_id)) {
                albumFlow.reading_scope = i;
            }
        }
        notifyDataSetChanged();
    }

    @Override // com.blued.community.ui.feed.observer.IFeedDataObserver
    public void b(String str, String str2) {
    }

    @Override // com.blued.community.ui.feed.observer.IFeedDataObserver
    public void c(int i) {
    }

    @Override // com.blued.community.ui.feed.observer.IFeedDataObserver
    public void c(String str) {
        if (StringUtils.d(str)) {
            return;
        }
        for (AlbumFlow albumFlow : this.mData) {
            if (str.equals(albumFlow.feed_id)) {
                int i = albumFlow.repost_count - 1;
                int i2 = i;
                if (i < 0) {
                    i2 = 0;
                }
                albumFlow.repost_count = i2;
            }
        }
        notifyDataSetChanged();
    }

    @Override // com.blued.community.ui.feed.observer.IFeedDataObserver
    public void c(String str, int i) {
        int i2;
        if (StringUtils.d(str)) {
            return;
        }
        for (AlbumFlow albumFlow : this.mData) {
            if (str.equals(albumFlow.feed_id)) {
                int i3 = albumFlow.feed_dig;
                if (i == 1) {
                    i2 = i3 + 1;
                    albumFlow.iliked = 1;
                } else {
                    i2 = i3;
                    if (i3 >= 1) {
                        i2 = i3 - 1;
                    }
                    albumFlow.iliked = 0;
                }
                albumFlow.feed_dig = i2;
            }
        }
        notifyDataSetChanged();
    }

    @Override // com.blued.community.ui.feed.observer.IFeedDataObserver
    public void d(int i) {
    }

    @Override // com.blued.community.ui.feed.observer.IFeedDataObserver
    public void d(String str, int i) {
    }
}
