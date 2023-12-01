package com.soft.blued.ui.find.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.RelativeLayout;
import androidx.viewpager.widget.ViewPager;
import com.anythink.expressad.video.module.a.a.m;
import com.blued.android.core.AppInfo;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityBaseExtra;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.common.view.AutoScrollViewPager;
import com.blued.android.module.common.view.LinePageIndicator;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.das.live.LiveProtos;
import com.soft.blued.R;
import com.soft.blued.ui.find.adapter.FloatSpreadPagerAdapter;
import com.soft.blued.ui.live.model.LiveFloatSpreadModel;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/view/FloatSpreadView.class */
public class FloatSpreadView extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    public Context f17007a;
    public View b;

    /* renamed from: c  reason: collision with root package name */
    private BaseFragment f17008c;
    private long d;
    private LinePageIndicator e;
    private AutoScrollViewPager f;
    private List<LiveFloatSpreadModel> g;
    private String h;
    private FloatSpreadPagerAdapter i;

    public FloatSpreadView(Context context) {
        super(context);
        this.d = 0L;
        this.f17007a = context;
        a();
    }

    public FloatSpreadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = 0L;
        this.f17007a = context;
        a();
    }

    public FloatSpreadView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = 0L;
        this.f17007a = context;
        a();
    }

    private void a() {
        View inflate = LayoutInflater.from(this.f17007a).inflate(R.layout.live_float_spread_view, this);
        this.b = inflate;
        this.f = inflate.findViewById(R.id.asvp_banner);
        this.e = this.b.findViewById(R.id.lpi_dot);
        this.f.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.soft.blued.ui.find.view.FloatSpreadView.1
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                LiveFloatSpreadModel liveFloatSpreadModel;
                if (FloatSpreadView.this.g == null || i >= FloatSpreadView.this.g.size() || (liveFloatSpreadModel = (LiveFloatSpreadModel) FloatSpreadView.this.g.get(i)) == null) {
                    return;
                }
                if (liveFloatSpreadModel.type == 2) {
                    EventTrackLive.b(LiveProtos.Event.LIVE_RESOURCE_SHOW, liveFloatSpreadModel.id, liveFloatSpreadModel.lid);
                } else {
                    EventTrackLive.d(LiveProtos.Event.LIVE_RESOURCE_SHOW, liveFloatSpreadModel.id, liveFloatSpreadModel.redirect);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        List<LiveFloatSpreadModel> list = this.g;
        if (list == null || list.isEmpty()) {
            setVisibility(8);
            return;
        }
        FloatSpreadPagerAdapter floatSpreadPagerAdapter = new FloatSpreadPagerAdapter(this.f17008c, this.g);
        this.i = floatSpreadPagerAdapter;
        this.f.setAdapter(floatSpreadPagerAdapter);
        this.f.setInterval((long) m.ag);
        if (this.g.size() == 1) {
            this.e.setVisibility(8);
            this.f.b();
        } else {
            this.e.setViewPager(this.f);
            this.e.setVisibility(0);
            this.f.setCurrentItem(0, false);
            this.e.a(this.f, 0);
        }
        LiveFloatSpreadModel liveFloatSpreadModel = this.g.get(0);
        if (liveFloatSpreadModel.type == 2) {
            EventTrackLive.b(LiveProtos.Event.LIVE_RESOURCE_SHOW, liveFloatSpreadModel.id, liveFloatSpreadModel.lid);
        } else {
            EventTrackLive.d(LiveProtos.Event.LIVE_RESOURCE_SHOW, liveFloatSpreadModel.id, liveFloatSpreadModel.redirect);
        }
        setVisibility(0);
    }

    private void b(final boolean z) {
        animate().cancel();
        animate().rotationX(z ? 0.0f : 90.0f).translationY(z ? 0.0f : -DensityUtils.a(this.f17007a, 54.0f)).setDuration(500L).setStartDelay(z ? 200L : 0L).setInterpolator(z ? new OvershootInterpolator(2.0f) : new AnticipateInterpolator(2.0f)).setListener(new AnimatorListenerAdapter() { // from class: com.soft.blued.ui.find.view.FloatSpreadView.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (!z) {
                    FloatSpreadView.super.setVisibility(8);
                } else if (FloatSpreadView.this.g == null || FloatSpreadView.this.g.size() <= 1) {
                } else {
                    FloatSpreadView.this.f.a();
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (!z && FloatSpreadView.this.g != null && FloatSpreadView.this.g.size() > 1) {
                    FloatSpreadView.this.f.b();
                }
                super.onAnimationStart(animator);
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d() {
        b(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e() {
        b(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getData */
    public void c() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.d < 1000) {
            return;
        }
        this.d = currentTimeMillis;
        LiveRoomHttpUtils.I(new BluedUIHttpResponse<BluedEntity<LiveFloatSpreadModel, BluedEntityBaseExtra>>(this.f17008c.getFragmentActive()) { // from class: com.soft.blued.ui.find.view.FloatSpreadView.2
            public boolean onUIFailure(int i, String str) {
                return false;
            }

            public void onUIUpdate(BluedEntity<LiveFloatSpreadModel, BluedEntityBaseExtra> bluedEntity) {
                if (bluedEntity == null || !bluedEntity.hasData()) {
                    FloatSpreadView.this.setVisibility(8);
                    FloatSpreadView.this.h = "";
                    FloatSpreadView.this.g = null;
                    return;
                }
                String json = AppInfo.f().toJson(bluedEntity.data);
                if (!TextUtils.isEmpty(FloatSpreadView.this.h) && FloatSpreadView.this.h.equals(json)) {
                    FloatSpreadView.this.setVisibility(0);
                    return;
                }
                FloatSpreadView.this.g = bluedEntity.data;
                FloatSpreadView.this.h = json;
                FloatSpreadView.this.b();
            }
        });
    }

    public void a(boolean z) {
        if (z || getVisibility() == 0) {
            post(new Runnable() { // from class: com.soft.blued.ui.find.view.-$$Lambda$FloatSpreadView$QZVdTJmtOgaCJqE8wuRKBCvqGbw
                @Override // java.lang.Runnable
                public final void run() {
                    FloatSpreadView.this.c();
                }
            });
        } else {
            setVisibility(0);
        }
    }

    public void setFragment(BaseFragment baseFragment) {
        this.f17008c = baseFragment;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        if (i != 0 || getVisibility() == 0) {
            if (i != 8 || getVisibility() == 8) {
                super.setVisibility(i);
                return;
            } else {
                post(new Runnable() { // from class: com.soft.blued.ui.find.view.-$$Lambda$FloatSpreadView$WbwBH7tWMNdp9dJxgCwr3imQvg0
                    @Override // java.lang.Runnable
                    public final void run() {
                        FloatSpreadView.this.d();
                    }
                });
                return;
            }
        }
        setPivotX(DensityUtils.a(this.f17007a, 156.0f) / 2);
        setPivotY(DensityUtils.a(this.f17007a, 54.0f));
        setRotationX(90.0f);
        setTranslationY(-DensityUtils.a(this.f17007a, 54.0f));
        super.setVisibility(0);
        post(new Runnable() { // from class: com.soft.blued.ui.find.view.-$$Lambda$FloatSpreadView$WGbxgPXBBiTYonDAals1aaKVVZQ
            @Override // java.lang.Runnable
            public final void run() {
                FloatSpreadView.this.e();
            }
        });
    }
}
