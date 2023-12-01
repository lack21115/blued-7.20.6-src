package com.soft.blued.ui.msg.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.viewpager.widget.PagerAdapter;
import com.anythink.expressad.video.module.a.a.m;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.module.common.view.AutoScrollViewPager;
import com.blued.android.module.common.view.LinePageIndicator;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.http.ChatHttpUtils;
import com.soft.blued.ui.msg.fragment.EmotionMallListFragment;
import com.soft.blued.ui.msg.model.EmotionBannerModel;
import com.soft.blued.ui.msg.model.EmotionListItemModel;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/fragment/EmotionMallListFragment.class */
public class EmotionMallListFragment extends EmotionBaseListFragment {
    private AutoScrollViewPager d;
    private LinePageIndicator e;
    private BannerPagerAdapter f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/fragment/EmotionMallListFragment$BannerPagerAdapter.class */
    public class BannerPagerAdapter extends PagerAdapter {
        private List<EmotionBannerModel> b = new ArrayList();

        /* renamed from: c  reason: collision with root package name */
        private List<View> f32357c = new ArrayList();

        BannerPagerAdapter() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(EmotionBannerModel emotionBannerModel, View view) {
            Tracker.onClick(view);
            EmotionMallListFragment.this.a(emotionBannerModel.emotion_id, emotionBannerModel.code);
        }

        public void a(List<EmotionBannerModel> list) {
            if (list != null) {
                this.b.clear();
                this.b.addAll(list);
            }
            while (this.f32357c.size() < this.b.size()) {
                this.f32357c.add(LayoutInflater.from(EmotionMallListFragment.this.getActivity()).inflate(R.layout.item_emotion_mall_banner, (ViewGroup) null));
            }
            notifyDataSetChanged();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return this.b.size();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getItemPosition(Object obj) {
            return -2;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            final EmotionBannerModel emotionBannerModel = this.b.get(i);
            View view = this.f32357c.get(i);
            viewGroup.addView(view);
            ImageView imageView = (ImageView) this.f32357c.get(i).findViewById(R.id.item_emotion_mall_banner_iv);
            ImageLoader.a(EmotionMallListFragment.this.getFragmentActive(), emotionBannerModel.banner).b(2131231620).a(imageView);
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.fragment.-$$Lambda$EmotionMallListFragment$BannerPagerAdapter$y6njuwmfJeTciEOO3rSwAthqmKw
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    EmotionMallListFragment.BannerPagerAdapter.this.a(emotionBannerModel, view2);
                }
            });
            return view;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }
    }

    @Override // com.soft.blued.ui.msg.fragment.EmotionBaseListFragment
    public void a() {
        this.f32337c.a(EmotionDataManager.a().c());
    }

    @Override // com.soft.blued.ui.msg.fragment.EmotionBaseListFragment
    public void a(EmotionListItemModel emotionListItemModel) {
        if (emotionListItemModel == null) {
            return;
        }
        LogUtils.c("onBtnEmotionClicked: " + emotionListItemModel.name + ", _pageIndex: $_pageIndex, code: " + emotionListItemModel.code + ", state: " + emotionListItemModel.downloadState);
        if (emotionListItemModel.downloadState == 0) {
            b(emotionListItemModel);
        } else if (emotionListItemModel.downloadState == 1) {
            if (emotionListItemModel.downloadUrl == null) {
                b(emotionListItemModel);
            } else {
                c(emotionListItemModel);
            }
        }
    }

    @Override // com.soft.blued.ui.msg.fragment.EmotionBaseListFragment, com.blued.android.framework.ui.SimpleFragment
    public void onInitView() {
        super.onInitView();
        this.f32336a.setVisibility(0);
        this.d = (AutoScrollViewPager) this.rootView.findViewById(R.id.emotion_list_banner_vp);
        BannerPagerAdapter bannerPagerAdapter = new BannerPagerAdapter();
        this.f = bannerPagerAdapter;
        this.d.setAdapter(bannerPagerAdapter);
        this.d.setInterval(m.ag);
        LinePageIndicator linePageIndicator = (LinePageIndicator) this.rootView.findViewById(R.id.emotion_list_banner_indicator);
        this.e = linePageIndicator;
        linePageIndicator.setViewPager(this.d);
        ViewGroup.LayoutParams layoutParams = this.f32336a.getLayoutParams();
        layoutParams.height = (int) ((AppInfo.l / 320.0f) * 120.0f);
        this.f32336a.setLayoutParams(layoutParams);
    }

    @Override // com.blued.android.framework.ui.SimpleFragment
    public void onLoadData() {
        super.onLoadData();
        ChatHttpUtils.b(new BluedUIHttpResponse<BluedEntityA<EmotionBannerModel>>(getFragmentActive()) { // from class: com.soft.blued.ui.msg.fragment.EmotionMallListFragment.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<EmotionBannerModel> bluedEntityA) {
                if (bluedEntityA == null || bluedEntityA.getSingleData() == null) {
                    EmotionMallListFragment.this.f32336a.setVisibility(8);
                    return;
                }
                EmotionMallListFragment.this.f32336a.setVisibility(0);
                if (bluedEntityA.data.size() == 1) {
                    EmotionMallListFragment.this.e.setVisibility(8);
                } else {
                    EmotionMallListFragment.this.e.setVisibility(0);
                }
                EmotionMallListFragment.this.f.a(bluedEntityA.data);
                EmotionMallListFragment.this.d.a();
                EmotionMallListFragment.this.e.setCurrentItem(0);
            }
        });
    }
}
