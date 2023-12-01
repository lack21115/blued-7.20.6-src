package com.blued.android.module.live_china.adapter;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.viewpager.widget.PagerAdapter;
import com.blued.android.core.AppInfo;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.image.ImageFileLoader;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.image.util.ImageSize;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.framework.view.badgeview.DisplayUtil;
import com.blued.android.module.common.utils.DistanceUtils;
import com.blued.android.module.common.view.AutoScrollViewPager;
import com.blued.android.module.common.view.LinePageIndicator;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.adapter.LiveTabAdapter;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.model.BannerModel;
import com.blued.android.module.live_china.model.BluedLiveListData;
import com.blued.android.module.live_china.model.LiveHotListDiversion;
import com.blued.android.module.live_china.model.LiveRoomData;
import com.blued.android.module.live_china.utils.LiveRoomUtils;
import com.blued.android.module.live_china.utils.LiveUtils;
import com.blued.android.module.live_china.utils.log.InstantLog;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.android.module.live_china.view.LiveAutoPlayView;
import com.blued.android.module.live_china.view.LiveCurHotRedView;
import com.blued.android.module.live_china.view.LiveListAutoPlay;
import com.blued.android.module.live_china.view_model.LiveTabViewModel;
import com.blued.das.live.LiveProtos;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/adapter/LiveTabAdapter.class */
public final class LiveTabAdapter extends BaseMultiItemQuickAdapter<BluedLiveListData, BaseViewHolder> implements LiveListAutoPlay {
    private LiveTabViewModel a;
    private Context b;
    private IRequestHost c;
    private String d;
    private final int e;
    private int f;
    private String g;
    private LiveAutoPlayView h;
    private LiveCurHotRedView i;
    private List<BluedLiveListData> j;
    private final List<String> k;
    private boolean l;
    private boolean m;
    private Runnable n;

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/adapter/LiveTabAdapter$BannerPagerAdapter.class */
    public static final class BannerPagerAdapter extends PagerAdapter {
        private Context a;
        private LiveTabViewModel b;
        private List<View> c = new ArrayList();
        private List<BannerModel> d = new ArrayList();
        private IRequestHost e;

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(String str, BannerModel model, BannerPagerAdapter this$0, View view) {
            Intrinsics.e(model, "$model");
            Intrinsics.e(this$0, "this$0");
            EventTrackLive.a(LiveProtos.Event.LIVE_HOT_BANNER_CLICK, str, model.show_layer - 1);
            if (TextUtils.isEmpty(model.anchor_id)) {
                LiveRoomInfo.a().a(model.click_url);
                LiveRoomInfo.a().c(this$0.a, str);
                return;
            }
            LiveTabViewModel liveTabViewModel = this$0.b;
            if (liveTabViewModel == null) {
                return;
            }
            liveTabViewModel.a(model.anchor_id, this$0.e);
        }

        public final void a(Context context, IRequestHost iRequestHost, LiveTabViewModel liveTabViewModel, List<? extends BannerModel> list) {
            this.a = context;
            this.e = iRequestHost;
            this.b = liveTabViewModel;
            this.d.clear();
            if (list != null) {
                this.d.addAll(list);
            }
            notifyDataSetChanged();
        }

        public void destroyItem(ViewGroup container, int i, Object object) {
            Intrinsics.e(container, "container");
            Intrinsics.e(object, "object");
            container.removeView((View) object);
        }

        public final Context getContext() {
            return this.a;
        }

        public int getCount() {
            List<BannerModel> list = this.d;
            if (list != null) {
                return list.size();
            }
            return 0;
        }

        public int getItemPosition(Object object) {
            Intrinsics.e(object, "object");
            return -2;
        }

        public Object instantiateItem(ViewGroup container, int i) {
            Intrinsics.e(container, "container");
            final BannerModel bannerModel = this.d.get(i);
            final String str = bannerModel.url;
            while (this.c.size() < this.d.size()) {
                View inflate = LayoutInflater.from(AppInfo.d()).inflate(R.layout.item_live_banner_new, container, false);
                Intrinsics.c(inflate, "from(AppInfo.getAppConte…er_new, container, false)");
                this.c.add(inflate);
            }
            View view = this.c.get(i);
            if (view == null) {
                return view;
            }
            ImageView imageView = (ImageView) view.findViewById(R.id.aariv_banner);
            ImageLoader.a(this.e, bannerModel.imgurl).b(R.drawable.defaultpicture).a(imageView);
            if (!bannerModel.isShowUrlVisited) {
                LiveRoomInfo.a().a(bannerModel.show_url);
                bannerModel.isShowUrlVisited = true;
            }
            EventTrackLive.a(LiveProtos.Event.LIVE_HOT_BANNER_SHOW, str, bannerModel.show_layer - 1);
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.adapter.-$$Lambda$LiveTabAdapter$BannerPagerAdapter$jMGhOuNXpYc-Km-UtgyYFD5LwP4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    LiveTabAdapter.BannerPagerAdapter.a(String.this, bannerModel, this, view2);
                }
            });
            if (view.getParent() != null) {
                ((ViewGroup) view).removeView(view);
            }
            container.addView(view);
            return view;
        }

        public boolean isViewFromObject(View view, Object object) {
            Intrinsics.e(view, "view");
            Intrinsics.e(object, "object");
            return view == object;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveTabAdapter(Context context, List<BluedLiveListData> models, String str, LiveTabViewModel liveTabViewModel) {
        super(models);
        Intrinsics.e(models, "models");
        this.e = 2;
        this.j = new ArrayList();
        this.k = new ArrayList();
        this.b = context;
        this.g = str;
        this.a = liveTabViewModel;
        this.d = Intrinsics.a("tag_", (Object) str);
        this.j.clear();
        this.j.addAll(models);
        addItemType(0, R.layout.item_live_tab_user);
        addItemType(12, R.layout.layout_live_hot_red_new);
        addItemType(11, R.layout.live_new_banner_auto_scroll);
        this.n = new Runnable() { // from class: com.blued.android.module.live_china.adapter.-$$Lambda$LiveTabAdapter$Y4b-6TIL8BE_yfJZW8KonQFLoM4
            @Override // java.lang.Runnable
            public final void run() {
                LiveTabAdapter.a(LiveTabAdapter.this);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(ImageSize size, LiveTabAdapter this$0, Ref.ObjectRef iv_top_left, BluedLiveListData bluedLiveListData, BaseViewHolder baseViewHolder, File file, Exception exc) {
        Intrinsics.e(size, "$size");
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(iv_top_left, "$iv_top_left");
        if (file == null || !file.exists()) {
            return;
        }
        int a = size.a();
        int b = size.b();
        int a2 = DensityUtils.a(this$0.mContext, 20.0f);
        int i = b > 0 ? (a * a2) / b : 0;
        ViewGroup.LayoutParams layoutParams = ((ImageView) iv_top_left.a).getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        }
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        layoutParams2.width = i;
        layoutParams2.height = a2;
        ((ImageView) iv_top_left.a).setLayoutParams(layoutParams2);
        String str = bluedLiveListData.anchor_tag;
        Intrinsics.c(str, "item.anchor_tag");
        if (StringsKt.b(str, ".gif", false, 2, (Object) null)) {
            ImageLoader.a(this$0.c, bluedLiveListData.anchor_tag).h().a((ImageView) iv_top_left.a);
        } else {
            String str2 = bluedLiveListData.anchor_tag;
            Intrinsics.c(str2, "item.anchor_tag");
            if (StringsKt.b(str2, ".png", false, 2, (Object) null)) {
                ImageLoader.a(this$0.c, bluedLiveListData.anchor_tag).e(baseViewHolder.hashCode()).g(-1).a((ImageView) iv_top_left.a);
            } else {
                ImageLoader.a(this$0.c, bluedLiveListData.anchor_tag).a((ImageView) iv_top_left.a);
            }
        }
        baseViewHolder.setGone(R.id.iv_top_left, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveTabAdapter this$0) {
        Intrinsics.e(this$0, "this$0");
        LiveCurHotRedView liveCurHotRedView = this$0.i;
        if (liveCurHotRedView != null) {
            Intrinsics.a(liveCurHotRedView);
            if (liveCurHotRedView.h()) {
                Log.i("==uiop", "redView");
                this$0.f();
                return;
            }
        }
        LiveAutoPlayView liveAutoPlayView = this$0.h;
        if (liveAutoPlayView != null) {
            Intrinsics.a(liveAutoPlayView);
            if (liveAutoPlayView.e()) {
                Log.i("==uiop", "playHotView");
                this$0.g();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(BluedLiveListData bluedLiveListData, LiveTabAdapter this$0, String str, String str2, LiveRoomData liveRoomData, View view) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(liveRoomData, "$liveRoomData");
        if (bluedLiveListData.positionReal == 0 && TextUtils.equals(this$0.g, "0")) {
            if (bluedLiveListData.link_type == 1) {
                EventTrackLive.a(LiveProtos.Event.LIVE_HOT_FIRST_ROOM_CLICK, str, str2, LiveProtos.EnterType.PK);
            } else if (bluedLiveListData.link_type == 2) {
                EventTrackLive.a(LiveProtos.Event.LIVE_HOT_FIRST_ROOM_CLICK, str, str2, LiveProtos.EnterType.FRIEND);
            } else {
                EventTrackLive.a(LiveProtos.Event.LIVE_HOT_FIRST_ROOM_CLICK, str, str2, LiveProtos.EnterType.COMMON);
            }
        }
        if (TextUtils.equals(this$0.g, "12")) {
            EventTrackLive.a(LiveProtos.Event.LIVE_RECOMMEND_CLICK, bluedLiveListData.lid, bluedLiveListData.uid);
        }
        EventTrackLive.a(LiveProtos.Event.LIVE_ROOM_CLICK, this$0.g, bluedLiveListData.lid, bluedLiveListData.uid, bluedLiveListData.isPKStreamShow(), bluedLiveListData.weight, bluedLiveListData.cover_box_id);
        EventTrackLive.b(LiveProtos.Event.LIVE_ROOM_CLICK, bluedLiveListData.lid, bluedLiveListData.uid, bluedLiveListData.weight, bluedLiveListData.recommend_type);
        if (!TextUtils.isEmpty(bluedLiveListData.event_tracking)) {
            this$0.d = bluedLiveListData.event_tracking;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("live_prop", bluedLiveListData.recommended_prop);
        LiveRoomInfo.a().a(this$0.b, liveRoomData, -1, LiveRoomUtils.a(this$0.j, this$0.d), bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveHotListDiversion liveHotListDiversion, LiveTabAdapter this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        LiveRoomInfo.a().a(liveHotListDiversion.click_url);
        LiveRoomInfo.a().I();
        LiveRoomInfo.a().a(this$0.b, liveHotListDiversion.link);
        EventTrackLive.a(LiveProtos.Event.HOT_LIVE_H5_LINK_CLICK, liveHotListDiversion.link);
        EventTrackLive.a(LiveProtos.Event.LIVE_TASK_COLLECTION_PAGE_CLICK, liveHotListDiversion.link);
    }

    private final void c(BaseViewHolder baseViewHolder, BluedLiveListData bluedLiveListData) {
        if (bluedLiveListData == null) {
            return;
        }
        LiveCurHotRedView liveCurHotRedView = (LiveCurHotRedView) baseViewHolder.getView(R.id.live_cur_hot);
        this.i = liveCurHotRedView;
        Intrinsics.a(liveCurHotRedView);
        liveCurHotRedView.setPlayEnable(this.l);
        LiveCurHotRedView liveCurHotRedView2 = this.i;
        Intrinsics.a(liveCurHotRedView2);
        liveCurHotRedView2.setEventCallback(new LiveCurHotRedView.EventCallback() { // from class: com.blued.android.module.live_china.adapter.LiveTabAdapter$bindHotRedView$1
            @Override // com.blued.android.module.live_china.view.LiveCurHotRedView.EventCallback
            public void a() {
                LiveTabAdapter.this.c();
            }
        });
        LiveCurHotRedView liveCurHotRedView3 = this.i;
        Intrinsics.a(liveCurHotRedView3);
        liveCurHotRedView3.a(bluedLiveListData, "red", "red", this.j);
    }

    private final void f() {
        LiveCurHotRedView liveCurHotRedView = this.i;
        if (liveCurHotRedView == null || !this.l) {
            return;
        }
        Intrinsics.a(liveCurHotRedView);
        liveCurHotRedView.f();
    }

    private final void g() {
        LiveAutoPlayView liveAutoPlayView = this.h;
        if (liveAutoPlayView == null || !this.l) {
            return;
        }
        Intrinsics.a(liveAutoPlayView);
        liveAutoPlayView.b();
    }

    public final String a() {
        return this.d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, BluedLiveListData bluedLiveListData) {
        if (baseViewHolder != null) {
            int itemViewType = baseViewHolder.getItemViewType();
            if (itemViewType == 0) {
                b(baseViewHolder, bluedLiveListData);
            } else if (itemViewType != 11) {
                if (itemViewType != 12) {
                    return;
                }
                c(baseViewHolder, bluedLiveListData);
            } else {
                List<BannerModel> list = bluedLiveListData == null ? null : bluedLiveListData.banner_list;
                Intrinsics.a(bluedLiveListData);
                a(baseViewHolder, list, bluedLiveListData.positionReal);
            }
        }
    }

    public final void a(BaseViewHolder baseViewHolder, List<? extends BannerModel> list, int i) {
        int a;
        int a2;
        if (i == 0) {
            a2 = DensityUtils.a(this.b, 3.5f);
            a = 0;
        } else {
            a = DensityUtils.a(this.b, 3.5f);
            a2 = DensityUtils.a(this.b, 3.5f);
        }
        ViewGroup.LayoutParams layoutParams = null;
        View view = baseViewHolder == null ? null : baseViewHolder.getView(R.id.fl_banner);
        ViewGroup.LayoutParams layoutParams2 = view == null ? null : view.getLayoutParams();
        if (layoutParams2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        }
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) layoutParams2;
        layoutParams3.leftMargin = 0;
        layoutParams3.topMargin = a;
        layoutParams3.rightMargin = 0;
        layoutParams3.bottomMargin = a2;
        view.setLayoutParams(layoutParams3);
        FrameLayout frameLayout = baseViewHolder == null ? null : (FrameLayout) baseViewHolder.getView(R.id.asvp_banner_hot_parent);
        AutoScrollViewPager autoScrollViewPager = baseViewHolder == null ? null : (AutoScrollViewPager) baseViewHolder.getView(R.id.asvp_banner_hot_new);
        LinePageIndicator linePageIndicator = baseViewHolder == null ? null : (LinePageIndicator) baseViewHolder.getView(R.id.lpi_line);
        if (frameLayout != null) {
            layoutParams = frameLayout.getLayoutParams();
        }
        if (layoutParams != null) {
            layoutParams.width = AppInfo.l - DisplayUtil.a(this.b, 24.0f);
        }
        if (layoutParams != null) {
            layoutParams.height = (int) ((layoutParams.width * 140.0f) / 702.0f);
        }
        if (frameLayout != null) {
            frameLayout.setLayoutParams(layoutParams);
        }
        BannerPagerAdapter bannerPagerAdapter = new BannerPagerAdapter();
        if (autoScrollViewPager != null) {
            autoScrollViewPager.setAdapter(bannerPagerAdapter);
        }
        if (autoScrollViewPager != null) {
            autoScrollViewPager.setInterval(3000L);
        }
        if (linePageIndicator != null) {
            linePageIndicator.setViewPager(autoScrollViewPager);
        }
        if (list == null || list.size() <= 0) {
            if (frameLayout != null) {
                frameLayout.setVisibility(8);
            }
            if (linePageIndicator == null) {
                return;
            }
            linePageIndicator.setVisibility(8);
            return;
        }
        if (linePageIndicator != null) {
            linePageIndicator.setVisibility(0);
        }
        if (list.size() == 1 && linePageIndicator != null) {
            linePageIndicator.setVisibility(8);
        }
        bannerPagerAdapter.a(this.b, this.c, this.a, list);
        if (frameLayout != null) {
            frameLayout.setVisibility(0);
        }
        if (autoScrollViewPager != null) {
            autoScrollViewPager.a();
        }
        if (autoScrollViewPager != null) {
            autoScrollViewPager.setCurrentItem(0, false);
        }
        if (linePageIndicator == null) {
            return;
        }
        linePageIndicator.a(autoScrollViewPager, 0);
    }

    public final void a(List<BluedLiveListData> liveList) {
        Intrinsics.e(liveList, "liveList");
        this.j.clear();
        this.k.clear();
        this.j.addAll(liveList);
        setNewData(this.j);
        this.m = true;
        notifyDataSetChanged();
    }

    public final void a(boolean z) {
        this.l = z;
        LiveCurHotRedView liveCurHotRedView = this.i;
        if (liveCurHotRedView != null) {
            Intrinsics.a(liveCurHotRedView);
            liveCurHotRedView.setPlayEnable(this.l);
        }
    }

    public final List<BluedLiveListData> b() {
        return this.j;
    }

    /* JADX WARN: Type inference failed for: r1v80, types: [T, android.view.View] */
    public final void b(final BaseViewHolder baseViewHolder, final BluedLiveListData bluedLiveListData) {
        int a;
        int a2;
        if (bluedLiveListData == null) {
            return;
        }
        if (!TextUtils.isEmpty(bluedLiveListData.lid) && !this.k.contains(bluedLiveListData.lid)) {
            List<String> list = this.k;
            String str = bluedLiveListData.lid;
            Intrinsics.c(str, "item.lid");
            list.add(str);
            EventTrackLive.a(LiveProtos.Event.LIVE_ROOM_SHOW, this.g, bluedLiveListData.lid, bluedLiveListData.uid, bluedLiveListData.isPKStreamShow(), bluedLiveListData.weight, bluedLiveListData.cover_box_id);
            EventTrackLive.b(LiveProtos.Event.LIVE_ROOM_SHOW, bluedLiveListData.lid, bluedLiveListData.uid, bluedLiveListData.weight, bluedLiveListData.recommend_type);
        }
        Intrinsics.a(baseViewHolder);
        View view = baseViewHolder.getView(R.id.live_user_layout);
        if (view == null) {
            return;
        }
        GridLayoutManager.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager.LayoutParams");
        }
        GridLayoutManager.LayoutParams layoutParams2 = layoutParams;
        layoutParams2.width = (AppInfo.l - DensityUtils.a(this.b, 12.0f)) / this.e;
        layoutParams2.height = layoutParams2.width;
        view.setLayoutParams((ViewGroup.LayoutParams) layoutParams2);
        DensityUtils.a(this.b, 4.5f);
        int a3 = DensityUtils.a(this.b, 4.5f);
        if (bluedLiveListData.position == 0) {
            a = DensityUtils.a(this.b, 6.0f);
            a2 = DensityUtils.a(this.b, 3.0f);
        } else {
            a = DensityUtils.a(this.b, 3.0f);
            a2 = DensityUtils.a(this.b, 6.0f);
        }
        int a4 = (bluedLiveListData.positionReal == 0 || bluedLiveListData.positionReal == 1) ? DensityUtils.a(this.b, 1.0f) : DensityUtils.a(this.b, 4.5f);
        View findViewById = view.findViewById(R.id.aariv_cover_layout);
        ViewGroup.LayoutParams layoutParams3 = findViewById.getLayoutParams();
        if (layoutParams3 == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        }
        FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) layoutParams3;
        layoutParams4.leftMargin = a;
        layoutParams4.topMargin = a4;
        layoutParams4.rightMargin = a2;
        layoutParams4.bottomMargin = a3;
        findViewById.setLayoutParams(layoutParams4);
        ImageView imageView = (ImageView) baseViewHolder.getView(R.id.aariv_cover);
        ImageView imageView2 = (ImageView) baseViewHolder.getView(R.id.iv_cover_box);
        TextView textView = (TextView) baseViewHolder.getView(R.id.tv_audience_count);
        TextView textView2 = (TextView) baseViewHolder.getView(R.id.tv_username);
        LiveAutoPlayView liveAutoPlayView = (LiveAutoPlayView) baseViewHolder.getView(R.id.fl_video_view);
        liveAutoPlayView.a(this, bluedLiveListData, this.d, layoutParams2.width, layoutParams2.height);
        if (bluedLiveListData.positionReal == 0) {
            this.h = liveAutoPlayView;
        }
        final LiveHotListDiversion liveHotListDiversion = bluedLiveListData.recommend_ad;
        if (bluedLiveListData.recommend_type == 1) {
            if (liveHotListDiversion != null) {
                EventTrackLive.a(LiveProtos.Event.LIVE_TASK_COLLECTION_PAGE_SHOW, liveHotListDiversion.link);
                ImageLoader.a(this.c, liveHotListDiversion.pic).b(R.drawable.live_bg).a(imageView);
                textView2.setText(liveHotListDiversion.title);
                imageView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.adapter.-$$Lambda$LiveTabAdapter$Hzz6Hp_X6qhH6vGX4FsXO_LVuKo
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        LiveTabAdapter.a(LiveHotListDiversion.this, this, view2);
                    }
                });
                textView.setVisibility(8);
                if (!bluedLiveListData.isShowUrlVisited) {
                    LiveRoomInfo.a().a(liveHotListDiversion.show_url);
                    bluedLiveListData.isShowUrlVisited = true;
                }
                baseViewHolder.setGone(R.id.live_record_level, false);
                baseViewHolder.setGone(R.id.iv_top_left, false);
                baseViewHolder.setGone(R.id.iv_cover_box, false);
                return;
            }
            return;
        }
        textView.setVisibility(0);
        ImageLoader.a(this.c, bluedLiveListData.pic_url).b(R.drawable.live_bg).a(imageView);
        if (TextUtils.isEmpty(bluedLiveListData.cover_box_url)) {
            imageView2.setVisibility(8);
        } else {
            imageView2.setVisibility(0);
            ImageLoader.a(this.c, bluedLiveListData.cover_box_url).e(imageView2.hashCode()).g(-1).a(imageView2);
        }
        baseViewHolder.setGone(R.id.iv_top_left, false);
        if (!TextUtils.isEmpty(bluedLiveListData.anchor_tag)) {
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.a = baseViewHolder.getView(R.id.iv_top_left);
            final ImageSize imageSize = new ImageSize();
            ImageFileLoader.a(this.c).a(bluedLiveListData.anchor_tag).a(imageSize).a(new ImageFileLoader.OnLoadFileListener() { // from class: com.blued.android.module.live_china.adapter.-$$Lambda$LiveTabAdapter$6WguIVojLeMpcaHTFIdTT94aNWc
                @Override // com.blued.android.core.image.ImageFileLoader.OnLoadFileListener
                public final void onUIFinish(File file, Exception exc) {
                    LiveTabAdapter.a(ImageSize.this, this, objectRef, bluedLiveListData, baseViewHolder, file, exc);
                }
            }).a();
        }
        if (TextUtils.isEmpty(bluedLiveListData.realtime_count)) {
            textView.setText("");
        } else {
            Long valueOf = Long.valueOf(bluedLiveListData.realtime_count);
            Intrinsics.c(valueOf, "valueOf(item.realtime_count)");
            String a5 = LiveRoomUtils.a(valueOf.longValue());
            Intrinsics.c(a5, "formatPriceForLiveList(j…eOf(item.realtime_count))");
            textView.setText(a5);
        }
        if (bluedLiveListData.anchor != null) {
            int i = bluedLiveListData.screen_pattern;
            String str2 = bluedLiveListData.anchor.avatar;
            String str3 = bluedLiveListData.pic_url;
            final String str4 = bluedLiveListData.lid;
            String str5 = bluedLiveListData.anchor.name;
            final String str6 = bluedLiveListData.uid;
            final LiveRoomData liveRoomData = new LiveRoomData(StringUtils.a(str4, 0L), i, this.d, str6, str5, str2, bluedLiveListData.anchor.vbadge);
            liveRoomData.live_url = bluedLiveListData.live_play;
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.adapter.-$$Lambda$LiveTabAdapter$_U6BWl8vmmC1rP2CuxNTXzKkZuo
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    LiveTabAdapter.a(BluedLiveListData.this, this, str4, str6, liveRoomData, view2);
                }
            });
            if (!TextUtils.isEmpty(bluedLiveListData.title)) {
                textView2.setText(bluedLiveListData.title);
            } else if (TextUtils.isEmpty(bluedLiveListData.anchor.name)) {
                textView2.setText("");
            } else {
                textView2.setText(bluedLiveListData.anchor.name);
            }
            if (bluedLiveListData.is_distance == 1) {
                baseViewHolder.setGone(R.id.tv_distance, true);
                if (bluedLiveListData.anchor.is_hide_distance == 1) {
                    baseViewHolder.setText(R.id.tv_distance, R.string.live_distance_privacy);
                } else {
                    baseViewHolder.setText(R.id.tv_distance, DistanceUtils.a(bluedLiveListData.distance, BlueAppLocal.c(), false));
                }
            } else {
                baseViewHolder.setGone(R.id.tv_distance, false);
            }
            if (bluedLiveListData.anchor_level >= 80) {
                LiveUtils.a(this.b, (ImageView) baseViewHolder.getView(R.id.live_record_level), bluedLiveListData.anchor_level, false);
            } else {
                baseViewHolder.setGone(R.id.live_record_level, false);
            }
        }
        if (bluedLiveListData.isShowUrlVisited) {
            return;
        }
        LiveRoomInfo.a().a(bluedLiveListData.show_url);
        InstantLog.a(this.f, bluedLiveListData.uid, bluedLiveListData.lid, this.g, bluedLiveListData.link_type == 1 ? "1" : "0", bluedLiveListData.realtime_count);
        bluedLiveListData.isShowUrlVisited = true;
    }

    public final void b(List<BluedLiveListData> liveList) {
        Intrinsics.e(liveList, "liveList");
        if (!this.m) {
            a(liveList);
            return;
        }
        int size = this.j.size();
        this.j.clear();
        this.k.clear();
        this.j.addAll(liveList);
        int size2 = this.j.size() - size;
        if (size2 > 0) {
            notifyItemRangeChanged(size, size2);
        } else {
            notifyDataSetChanged();
        }
    }

    public final void b(boolean z) {
        LiveAutoPlayView liveAutoPlayView = this.h;
        if (liveAutoPlayView != null) {
            Intrinsics.a(liveAutoPlayView);
            liveAutoPlayView.a(z);
        }
        LiveCurHotRedView liveCurHotRedView = this.i;
        if (liveCurHotRedView != null) {
            Intrinsics.a(liveCurHotRedView);
            liveCurHotRedView.a(z);
        }
    }

    @Override // com.blued.android.module.live_china.view.LiveListAutoPlay
    public boolean c() {
        AppInfo.n().removeCallbacks(this.n);
        AppInfo.n().postDelayed(this.n, 100L);
        return true;
    }

    public void d() {
        AppInfo.n().removeCallbacks(this.n);
        LiveAutoPlayView liveAutoPlayView = this.h;
        if (liveAutoPlayView != null) {
            Intrinsics.a(liveAutoPlayView);
            liveAutoPlayView.c();
        }
        LiveCurHotRedView liveCurHotRedView = this.i;
        if (liveCurHotRedView != null) {
            Intrinsics.a(liveCurHotRedView);
            liveCurHotRedView.g();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0028, code lost:
        c();
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x002d, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0011, code lost:
        if (r0.e() == false) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0025, code lost:
        if (r0.h() != false) goto L5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void e() {
        /*
            r2 = this;
            r0 = r2
            com.blued.android.module.live_china.view.LiveAutoPlayView r0 = r0.h
            r3 = r0
            r0 = r3
            if (r0 == 0) goto L14
            r0 = r3
            kotlin.jvm.internal.Intrinsics.a(r0)
            r0 = r3
            boolean r0 = r0.e()
            if (r0 != 0) goto L28
        L14:
            r0 = r2
            com.blued.android.module.live_china.view.LiveCurHotRedView r0 = r0.i
            r3 = r0
            r0 = r3
            if (r0 == 0) goto L2e
            r0 = r3
            kotlin.jvm.internal.Intrinsics.a(r0)
            r0 = r3
            boolean r0 = r0.h()
            if (r0 == 0) goto L2e
        L28:
            r0 = r2
            boolean r0 = r0.c()
            return
        L2e:
            r0 = r2
            r0.d()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.live_china.adapter.LiveTabAdapter.e():void");
    }

    public final Context getContext() {
        return this.b;
    }
}
