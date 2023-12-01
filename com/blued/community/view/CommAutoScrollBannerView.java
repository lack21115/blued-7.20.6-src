package com.blued.community.view;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import androidx.cardview.widget.CardView;
import androidx.viewpager.widget.PagerAdapter;
import com.anythink.expressad.video.module.a.a.m;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.module.common.view.AutoScrollViewPager;
import com.blued.android.module.common.view.LinePageIndicator;
import com.blued.android.module.svgaplayer.SVGACallback;
import com.blued.android.module.svgaplayer.SVGAImageView;
import com.blued.android.module.svgaplayer.SVGAParser;
import com.blued.android.module.svgaplayer.SVGAVideoEntity;
import com.blued.community.R;
import com.blued.community.auto.CommunityServiceManager;
import com.blued.community.http.CommunityHttpUtils;
import com.blued.community.manager.CommunityManager;
import com.blued.community.model.OperatePromotionPopup;
import com.blued.community.track.EventTrackFeed;
import com.blued.community.ui.feed.manager.FeedMethods;
import com.blued.community.ui.square.model.CommBannerModel;
import com.blued.community.utils.CommunityPreferences;
import com.blued.community.view.CommAutoScrollBannerView;
import com.blued.das.client.feed.FeedProtos;
import com.bytedance.applog.tracker.Tracker;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* loaded from: source-7206380-dex2jar.jar:com/blued/community/view/CommAutoScrollBannerView.class */
public class CommAutoScrollBannerView extends CardView {
    private final int SVGA_PLAYING;
    private final int SVGA_PLAY_FINISH;
    private BannerAdapter adapter;
    private CardView cvSvga;
    private LinePageIndicator indicator;
    private boolean isSvgaShowed;
    private ImageView ivImage;
    private View layoutVpParent;
    private Context mContext;
    private View rootView;
    private SVGACallback svgaCallback;
    private SVGAParser svgaParser;
    private int svgaPlayDuration;
    private long svgaPlayStartTime;
    private int svgaPlayState;
    private SVGAImageView svgaView;
    private AutoScrollViewPager viewPager;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.blued.community.view.CommAutoScrollBannerView$2  reason: invalid class name */
    /* loaded from: source-7206380-dex2jar.jar:com/blued/community/view/CommAutoScrollBannerView$2.class */
    public class AnonymousClass2 implements SVGACallback {
        AnonymousClass2() {
        }

        public /* synthetic */ void lambda$onFinished$0$CommAutoScrollBannerView$2() {
            CommAutoScrollBannerView.this.lambda$showPromotionPopup$0$CommAutoScrollBannerView();
        }

        public void onFinished() {
            CommAutoScrollBannerView.this.svgaPlayState = 12;
            int elapsedRealtime = (int) ((((float) (SystemClock.elapsedRealtime() - CommAutoScrollBannerView.this.svgaPlayStartTime)) / 1000.0f) + 0.5f);
            LogUtils.c("svgView callback onFinished, playTime=" + elapsedRealtime);
            if (elapsedRealtime >= CommAutoScrollBannerView.this.svgaPlayDuration) {
                CommAutoScrollBannerView.this.lambda$showPromotionPopup$0$CommAutoScrollBannerView();
                return;
            }
            AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.community.view.-$$Lambda$CommAutoScrollBannerView$2$bDrnAIcGhMGRbeIdECBM4kr_jo4
                @Override // java.lang.Runnable
                public final void run() {
                    CommAutoScrollBannerView.AnonymousClass2.this.lambda$onFinished$0$CommAutoScrollBannerView$2();
                }
            }, (CommAutoScrollBannerView.this.svgaPlayDuration - elapsedRealtime) * 1000);
        }

        public void onPause() {
            LogUtils.c("svgView callback onPause");
        }

        public void onRepeat() {
        }

        public void onStep(int i, double d) {
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/community/view/CommAutoScrollBannerView$BannerAdapter.class */
    public class BannerAdapter extends PagerAdapter {
        private Context context;
        private final List<CommBannerModel> dataList = new ArrayList();
        private List<View> views = new ArrayList();

        public BannerAdapter(Context context) {
            this.context = context;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }

        public void getADView() {
            this.views.clear();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.dataList.size()) {
                    return;
                }
                final CommBannerModel commBannerModel = this.dataList.get(i2);
                View inflate = LayoutInflater.from(this.context).inflate(R.layout.item_more_adpic, (ViewGroup) null);
                View findViewById = inflate.findViewById(R.id.img_ad_icon);
                ImageView imageView = (ImageView) inflate.findViewById(R.id.img_ad);
                if (commBannerModel.is_show_adm_icon == 1) {
                    findViewById.setVisibility(0);
                } else {
                    findViewById.setVisibility(8);
                }
                ImageLoader.a((IRequestHost) null, commBannerModel.image).a(imageView);
                imageView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.view.CommAutoScrollBannerView.BannerAdapter.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Tracker.onClick(view);
                        CommBannerModel commBannerModel2 = commBannerModel;
                        if (commBannerModel2 != null && commBannerModel2.click_url != null) {
                            int i3 = 0;
                            while (true) {
                                int i4 = i3;
                                if (i4 >= commBannerModel.click_url.length) {
                                    break;
                                }
                                CommunityHttpUtils.a(commBannerModel.click_url[i4]);
                                i3 = i4 + 1;
                            }
                        }
                        if (!TextUtils.isEmpty(commBannerModel.url)) {
                            CommunityServiceManager.b().a(CommAutoScrollBannerView.this.getContext(), commBannerModel.url);
                        }
                        EventTrackFeed.j(FeedProtos.Event.FIND_PLAZA_BANNER_CLICK, commBannerModel.url, commBannerModel.id);
                    }
                });
                this.views.add(inflate);
                i = i2 + 1;
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return this.dataList.size();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getItemPosition(Object obj) {
            return -2;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            viewGroup.addView(this.views.get(i));
            CommBannerModel commBannerModel = this.dataList.get(i);
            if (!commBannerModel.isShowUrlVisited && commBannerModel.show_url != null && commBannerModel.show_url.length > 0) {
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= commBannerModel.show_url.length) {
                        break;
                    }
                    CommunityHttpUtils.a(commBannerModel.show_url[i3]);
                    i2 = i3 + 1;
                }
                EventTrackFeed.j(FeedProtos.Event.FIND_PLAZA_BANNER_SHOW, commBannerModel.url, commBannerModel.id);
                commBannerModel.isShowUrlVisited = true;
            }
            return this.views.get(i);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        public void setDataList(List<CommBannerModel> list) {
            if (list == null) {
                return;
            }
            this.dataList.clear();
            this.dataList.addAll(list);
            getADView();
            notifyDataSetChanged();
        }
    }

    public CommAutoScrollBannerView(Context context) {
        super(context);
        this.isSvgaShowed = false;
        this.svgaPlayDuration = 0;
        this.svgaPlayStartTime = 0L;
        this.SVGA_PLAYING = 1;
        this.SVGA_PLAY_FINISH = 12;
        this.svgaPlayState = 0;
        this.mContext = context;
        init(context);
    }

    public CommAutoScrollBannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isSvgaShowed = false;
        this.svgaPlayDuration = 0;
        this.svgaPlayStartTime = 0L;
        this.SVGA_PLAYING = 1;
        this.SVGA_PLAY_FINISH = 12;
        this.svgaPlayState = 0;
        this.mContext = context;
        init(context);
    }

    public CommAutoScrollBannerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isSvgaShowed = false;
        this.svgaPlayDuration = 0;
        this.svgaPlayStartTime = 0L;
        this.SVGA_PLAYING = 1;
        this.SVGA_PLAY_FINISH = 12;
        this.svgaPlayState = 0;
        this.mContext = context;
        init(context);
    }

    private SVGAParser getSvgaParser() {
        if (this.svgaParser == null) {
            this.svgaParser = SVGAParser.a.b();
        }
        return this.svgaParser;
    }

    private void init(Context context) {
        View inflate = inflate(context, R.layout.auto_scroll_banner_view, null);
        this.rootView = inflate;
        View findViewById = inflate.findViewById(R.id.comm_auto_scroll_banner_lo);
        this.layoutVpParent = findViewById;
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) findViewById.getLayoutParams();
        marginLayoutParams.height = (int) (((AppInfo.l - FeedMethods.c(24)) * 180) / 750.0f);
        this.layoutVpParent.setLayoutParams(marginLayoutParams);
        this.viewPager = this.rootView.findViewById(R.id.comm_auto_scroll_banner_vp);
        this.indicator = this.rootView.findViewById(R.id.comm_auto_scroll_banner_indicator);
        BannerAdapter bannerAdapter = new BannerAdapter(context);
        this.adapter = bannerAdapter;
        this.viewPager.setAdapter(bannerAdapter);
        this.viewPager.setInterval((long) m.ag);
        this.indicator.a(this.viewPager, 0);
        this.cvSvga = (CardView) this.rootView.findViewById(R.id.comm_auto_scroll_banner_svga_layout);
        this.svgaView = this.rootView.findViewById(R.id.comm_auto_scroll_banner_svga);
        this.ivImage = (ImageView) this.rootView.findViewById(R.id.comm_auto_scroll_banner_static);
        this.cvSvga.setVisibility(8);
        removeAllViews();
        setBackgroundResource(R.color.transparent);
        addView(this.rootView);
    }

    private void loadRes(OperatePromotionPopup operatePromotionPopup) throws MalformedURLException {
        this.svgaPlayState = 1;
        LogUtils.c("loadRes start");
        if (this.svgaCallback == null) {
            this.svgaCallback = new AnonymousClass2();
        }
        this.svgaView.setCallback(this.svgaCallback);
        getSvgaParser().a(new URL(operatePromotionPopup.getMaterial()), new SVGAParser.ParseCompletion() { // from class: com.blued.community.view.CommAutoScrollBannerView.3
            public void onComplete(SVGAVideoEntity sVGAVideoEntity) {
                LogUtils.c("svgView load onFinished, start svga Anim");
                LogUtils.c("svgaVideoEntity: " + sVGAVideoEntity.a().d() + ", " + sVGAVideoEntity.a().e());
                CommAutoScrollBannerView.this.svgaPlayDuration = (int) ((((float) sVGAVideoEntity.a().e()) / ((float) sVGAVideoEntity.a().d())) + 0.5f);
                StringBuilder sb = new StringBuilder();
                sb.append("播放时间: ");
                sb.append(CommAutoScrollBannerView.this.svgaPlayDuration);
                LogUtils.c(sb.toString());
                CommAutoScrollBannerView.this.svgaPlayStartTime = SystemClock.elapsedRealtime();
                CommAutoScrollBannerView.this.cvSvga.clearAnimation();
                CommAutoScrollBannerView.this.svgaView.setLoops(1);
                CommAutoScrollBannerView.this.svgaView.setVideoItem(sVGAVideoEntity);
                CommAutoScrollBannerView.this.svgaView.a(0, true);
                CommAutoScrollBannerView.this.svgaPlayState = 1;
            }

            public void onError() {
                CommAutoScrollBannerView.this.svgaPlayState = 0;
            }
        }, (SVGAParser.PlayCallback) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onSvgAnimFinish */
    public void lambda$showPromotionPopup$0$CommAutoScrollBannerView() {
        ValueAnimator ofInt = ValueAnimator.ofInt(FeedMethods.c(263), FeedMethods.c(90));
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.blued.community.view.-$$Lambda$CommAutoScrollBannerView$0G7ZH1maihH-SxIOAIP9QR7GfRc
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                CommAutoScrollBannerView.this.lambda$onSvgAnimFinish$3$CommAutoScrollBannerView(valueAnimator);
            }
        });
        ofInt.setDuration(400L);
        ofInt.addListener(new Animator.AnimatorListener() { // from class: com.blued.community.view.CommAutoScrollBannerView.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                CommAutoScrollBannerView.this.cvSvga.setVisibility(8);
                CommAutoScrollBannerView.this.viewPager.a();
                LiveEventBus.get("FEED_RECOMMEND_BANNER_ADV_ANIM_FINISH").post(true);
                CommAutoScrollBannerView.this.svgaPlayState = 12;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
        ofInt.start();
    }

    private void showPromotionPopup(final CommBannerModel commBannerModel) {
        if (commBannerModel == null || commBannerModel.popup == null || !commBannerModel.popup.isValid()) {
            return;
        }
        this.cvSvga.setVisibility(0);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.cvSvga.getLayoutParams();
        marginLayoutParams.height = FeedMethods.c(263);
        this.cvSvga.setLayoutParams(marginLayoutParams);
        if (commBannerModel.popup.getMaterial_type() == 2) {
            this.svgaView.setVisibility(0);
            this.ivImage.setVisibility(8);
            startSvgaColorAnim(commBannerModel.popup);
        } else {
            this.svgaView.setVisibility(8);
            this.ivImage.setVisibility(0);
            ImageLoader.a((IRequestHost) null, commBannerModel.popup.getMaterial()).b(R.drawable.defaultpicture).d(R.drawable.defaultpicture).a(this.ivImage);
            postDelayed(new Runnable() { // from class: com.blued.community.view.-$$Lambda$CommAutoScrollBannerView$wuCzzsYEZDc71SHogTAf97OUB-M
                @Override // java.lang.Runnable
                public final void run() {
                    CommAutoScrollBannerView.this.lambda$showPromotionPopup$0$CommAutoScrollBannerView();
                }
            }, 2000L);
        }
        this.cvSvga.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.view.-$$Lambda$CommAutoScrollBannerView$TNEuoAz2gUdJLyID4H1f_lZgNqk
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CommAutoScrollBannerView.this.lambda$showPromotionPopup$1$CommAutoScrollBannerView(commBannerModel, view);
            }
        });
    }

    private void startSvgaColorAnim(OperatePromotionPopup operatePromotionPopup) {
        String str;
        String str2;
        if (CommunityManager.a.a().s()) {
            str = "#222222";
            str2 = "#1A1A1A";
        } else {
            str = "#E7E7E7";
            str2 = "#F5F5F5";
        }
        final int parseColor = Color.parseColor(str);
        final int parseColor2 = Color.parseColor(str2);
        this.cvSvga.setCardBackgroundColor(parseColor);
        ValueAnimator ofInt = ValueAnimator.ofInt(0, 10, 0);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.blued.community.view.-$$Lambda$CommAutoScrollBannerView$3SSEq3bWRWw5qLfXKJCItdQ0V5o
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                CommAutoScrollBannerView.this.lambda$startSvgaColorAnim$2$CommAutoScrollBannerView(parseColor, parseColor2, valueAnimator);
            }
        });
        ofInt.setRepeatCount(4);
        ofInt.setDuration(1250L);
        ofInt.setInterpolator(new LinearInterpolator());
        ofInt.addListener(new Animator.AnimatorListener() { // from class: com.blued.community.view.CommAutoScrollBannerView.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
        ofInt.start();
        try {
            loadRes(operatePromotionPopup);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isSvgaAnimPlaying() {
        return this.svgaPlayState == 1;
    }

    public /* synthetic */ void lambda$onSvgAnimFinish$3$CommAutoScrollBannerView(ValueAnimator valueAnimator) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.cvSvga.getLayoutParams();
        marginLayoutParams.height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        this.cvSvga.setLayoutParams(marginLayoutParams);
    }

    public /* synthetic */ void lambda$showPromotionPopup$1$CommAutoScrollBannerView(CommBannerModel commBannerModel, View view) {
        CommunityServiceManager.b().a(getContext(), commBannerModel.url);
        lambda$showPromotionPopup$0$CommAutoScrollBannerView();
        EventTrackFeed.j(FeedProtos.Event.FIND_PLAZA_BANNER_CLICK, commBannerModel.url, commBannerModel.id);
    }

    public /* synthetic */ void lambda$startSvgaColorAnim$2$CommAutoScrollBannerView(int i, int i2, ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        if (intValue <= 1) {
            this.cvSvga.setCardBackgroundColor(i);
        }
        if (intValue >= 9) {
            this.cvSvga.setCardBackgroundColor(i2);
        }
    }

    public boolean setBannerData(List<CommBannerModel> list) {
        if (list == null || list.isEmpty()) {
            setVisibility(8);
            return false;
        }
        setVisibility(0);
        this.adapter.setDataList(list);
        if (list.size() == 1) {
            this.indicator.setVisibility(8);
        } else {
            this.indicator.setVisibility(0);
        }
        OperatePromotionPopup operatePromotionPopup = null;
        CommBannerModel commBannerModel = null;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                break;
            }
            commBannerModel = list.get(i2);
            operatePromotionPopup = commBannerModel.popup;
            if (operatePromotionPopup != null && operatePromotionPopup.isValid()) {
                break;
            }
            i = i2 + 1;
        }
        this.cvSvga.setVisibility(8);
        if (this.isSvgaShowed || operatePromotionPopup == null) {
            this.viewPager.a();
            return false;
        }
        long c2 = CommunityPreferences.c(11);
        Date date = new Date(System.currentTimeMillis());
        long year = (date.getYear() * 1000000) + ((date.getMonth() + 1) * 10000) + (date.getDate() * 100) + date.getHours();
        LogUtils.c("lastNearbyPromotionPopupTime: " + c2 + ", curHour:" + year);
        if (operatePromotionPopup.getFrequency_type() == 2) {
            if (year / 100 > c2 / 100) {
                CommunityPreferences.d(11);
            }
        } else if (operatePromotionPopup.getFrequency_type() == 1 && year > c2) {
            CommunityPreferences.d(11);
        }
        int e = CommunityPreferences.e(11);
        LogUtils.c("NearbyPromotionPopupCount: " + e + ", getFrequency_count:" + operatePromotionPopup.getFrequency_count());
        if (operatePromotionPopup.getFrequency_type() != 0 && e >= operatePromotionPopup.getFrequency_count()) {
            this.viewPager.a();
            return false;
        }
        showPromotionPopup(commBannerModel);
        CommunityPreferences.a(11, year);
        CommunityPreferences.f(11);
        this.isSvgaShowed = true;
        return true;
    }

    public void setVisibleFromOuter(int i) {
        setVisibility(i);
    }
}
