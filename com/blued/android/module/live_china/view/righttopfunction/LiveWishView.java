package com.blued.android.module.live_china.view.righttopfunction;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;
import com.anythink.expressad.video.module.a.a.m;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.fragment.LiveDesireDialogFragment;
import com.blued.android.module.live_china.fragment.PlayingOnliveBaseModeFragment;
import com.blued.android.module.live_china.fragment.RecordingOnliveFragment;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.LiveWishItemModel;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.android.module.live_china.view.LiveAutoScrollViewPager;
import com.blued.das.live.LiveProtos;
import com.bytedance.applog.tracker.Tracker;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/righttopfunction/LiveWishView.class */
public class LiveWishView extends FrameLayout implements View.OnClickListener, RightTopFunction {

    /* renamed from: a  reason: collision with root package name */
    private LiveAutoScrollViewPager f15442a;
    private List<View> b;

    /* renamed from: c  reason: collision with root package name */
    private List<LiveWishItemModel> f15443c;
    private WishPagerAdapter d;
    private BaseFragment e;
    private LiveDesireDialogFragment f;
    private boolean g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/righttopfunction/LiveWishView$WishPagerAdapter.class */
    public class WishPagerAdapter extends PagerAdapter {
        WishPagerAdapter() {
        }

        public void a(List<LiveWishItemModel> list) {
            if (list != null) {
                if (LiveWishView.this.f15443c != null) {
                    LiveWishView.this.f15443c.clear();
                } else {
                    LiveWishView.this.f15443c = new ArrayList();
                }
                LiveWishView.this.f15443c.addAll(list);
            }
            notifyDataSetChanged();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            if (LiveWishView.this.f15443c != null) {
                return LiveWishView.this.f15443c.size();
            }
            return 0;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getItemPosition(Object obj) {
            return -2;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            View view = i < LiveWishView.this.b.size() ? (View) LiveWishView.this.b.get(i) : null;
            while (view == null) {
                view = LayoutInflater.from(LiveWishView.this.getContext()).inflate(R.layout.live_wish_item_view, viewGroup, false);
                LiveWishView.this.b.add(view);
            }
            LiveWishView.this.a(i);
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            viewGroup.addView(view);
            return view;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }
    }

    public LiveWishView(Context context) {
        this(context, null);
    }

    public LiveWishView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = new ArrayList();
        this.f15443c = new ArrayList();
        b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        View view;
        final LiveWishItemModel liveWishItemModel;
        if (i >= this.b.size() || i >= this.f15443c.size() || (view = this.b.get(i)) == null || (liveWishItemModel = this.f15443c.get(i)) == null) {
            return;
        }
        TextView textView = (TextView) view.findViewById(R.id.tv_wish_name);
        TextView textView2 = (TextView) view.findViewById(R.id.tv_wish_cur);
        TextView textView3 = (TextView) view.findViewById(R.id.tv_wish_total);
        ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.live_wish_progress_view);
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_wish_icon);
        textView.setText(liveWishItemModel.name);
        if (liveWishItemModel.progress >= liveWishItemModel.count) {
            textView2.setText(getContext().getString(R.string.live_desire_complete));
            textView3.setVisibility(8);
        } else {
            textView2.setText(String.valueOf(liveWishItemModel.progress));
            textView3.setText(BridgeUtil.SPLIT_MARK + String.valueOf(liveWishItemModel.count));
            textView3.setVisibility(0);
        }
        if (liveWishItemModel.count > 0) {
            progressBar.setProgress((liveWishItemModel.progress * 100) / liveWishItemModel.count);
        }
        ImageLoader.a((IRequestHost) null, liveWishItemModel.pic).a(imageView);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.righttopfunction.LiveWishView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Tracker.onClick(view2);
                if (LiveWishView.this.f == null || !LiveWishView.this.f.isVisible()) {
                    EventTrackLive.b(LiveProtos.Event.LIVE_ANCHOR_WISH_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g(), liveWishItemModel.id);
                    if (LiveWishView.this.e instanceof PlayingOnliveBaseModeFragment) {
                        LiveWishView liveWishView = LiveWishView.this;
                        liveWishView.f = new LiveDesireDialogFragment(liveWishView.getContext(), LiveDesireDialogFragment.FormType.TYPE_PLAYING);
                        LiveWishView.this.f.show(LiveWishView.this.e.getFragmentManager(), "desireDialog");
                    } else if (LiveWishView.this.e instanceof RecordingOnliveFragment) {
                        LiveWishView liveWishView2 = LiveWishView.this;
                        liveWishView2.f = new LiveDesireDialogFragment(liveWishView2.getContext(), LiveDesireDialogFragment.FormType.TYPE_RECORDING_LOOK_UP);
                        LiveWishView.this.f.show(LiveWishView.this.e.getFragmentManager(), "desireDialog");
                    }
                }
            }
        });
    }

    private void b() {
        LayoutInflater.from(getContext()).inflate(R.layout.live_wish_view, this);
        LiveAutoScrollViewPager liveAutoScrollViewPager = (LiveAutoScrollViewPager) findViewById(R.id.view_page_wish);
        this.f15442a = liveAutoScrollViewPager;
        liveAutoScrollViewPager.setInterval(m.ag);
        WishPagerAdapter wishPagerAdapter = new WishPagerAdapter();
        this.d = wishPagerAdapter;
        this.f15442a.setAdapter(wishPagerAdapter);
        setVisibility(8);
    }

    public void a(LiveWishItemModel liveWishItemModel) {
        if (liveWishItemModel == null) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f15443c.size()) {
                return;
            }
            LiveWishItemModel liveWishItemModel2 = this.f15443c.get(i2);
            if (liveWishItemModel2 != null && TextUtils.equals(liveWishItemModel2.id, liveWishItemModel.id)) {
                liveWishItemModel2.progress += liveWishItemModel.progress;
                a(i2);
                LiveEventBus.get("desire_refresh").post(true);
                return;
            }
            i = i2 + 1;
        }
    }

    @Override // com.blued.android.module.live_china.view.righttopfunction.RightTopFunction
    public boolean a() {
        return this.g;
    }

    @Override // com.blued.android.module.live_china.view.righttopfunction.RightTopFunction
    public int getPriority() {
        return 2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public void setBaseFragment(BaseFragment baseFragment) {
        this.e = baseFragment;
    }

    public void setData(List<LiveWishItemModel> list) {
        if (list == null || list.size() == 0) {
            setWishViewVisible(8);
            return;
        }
        this.d.a(list);
        this.f15442a.setAdapter(this.d);
        this.f15442a.a();
        this.f15442a.setCurrentItem(0, false);
        setWishViewVisible(0);
    }

    public void setShow(boolean z) {
        this.g = z;
    }

    public void setWishViewVisible(int i) {
        setShow(i == 0);
    }
}
