package com.blued.android.module.live_china.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.msg.LiveEventBusUtil;
import com.blued.android.module.live_china.utils.log.EventTrackLive;
import com.blued.das.live.LiveProtos;
import com.bytedance.applog.tracker.Tracker;
import com.jeremyliao.liveeventbus.LiveEventBus;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveAnnouceView.class */
public class LiveAnnouceView extends FrameLayout implements View.OnClickListener {
    Runnable a;
    private View b;
    private View c;
    private TextView d;

    public LiveAnnouceView(Context context) {
        this(context, null);
    }

    public LiveAnnouceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = new Runnable() { // from class: com.blued.android.module.live_china.view.LiveAnnouceView.4
            @Override // java.lang.Runnable
            public void run() {
                LiveAnnouceView.this.a();
            }
        };
        c();
    }

    private void c() {
        LayoutInflater.from(getContext()).inflate(R.layout.live_announce_view, this);
        this.b = findViewById(R.id.shape_lay);
        this.c = findViewById(R.id.iv_announce);
        this.d = (TextView) findViewById(R.id.tv_announce);
        this.c.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.LiveAnnouceView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                LiveAnnouceView liveAnnouceView = LiveAnnouceView.this;
                liveAnnouceView.removeCallbacks(liveAnnouceView.a);
                LiveAnnouceView.this.a();
            }
        });
        setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d() {
        animate().translationX(0.0f).setDuration(3000L).setInterpolator(new DecelerateInterpolator(1.5f)).setListener(new AnimatorListenerAdapter() { // from class: com.blued.android.module.live_china.view.LiveAnnouceView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                LiveAnnouceView liveAnnouceView = LiveAnnouceView.this;
                liveAnnouceView.removeCallbacks(liveAnnouceView.a);
                LiveAnnouceView liveAnnouceView2 = LiveAnnouceView.this;
                liveAnnouceView2.postDelayed(liveAnnouceView2.a, 5000L);
            }
        });
    }

    public void a() {
        animate().translationX(-getWidth()).setDuration(1500L).setInterpolator(new AccelerateInterpolator(1.5f)).setListener(new AnimatorListenerAdapter() { // from class: com.blued.android.module.live_china.view.LiveAnnouceView.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                LiveAnnouceView liveAnnouceView = LiveAnnouceView.this;
                liveAnnouceView.removeCallbacks(liveAnnouceView.a);
                LiveAnnouceView.this.setVisibility(8);
                LiveEventBus.get(LiveEventBusUtil.q).post((Object) null);
            }
        });
    }

    public void a(String str) {
        removeCallbacks(this.a);
        setVisibility(8);
        animate().cancel();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        EventTrackLive.a(LiveProtos.Event.LIVE_NOTICE_SHOW, LiveRoomManager.a().e(), LiveRoomManager.a().g());
        this.d.setMaxWidth(AppInfo.l - DensityUtils.a(getContext(), 100.0f));
        setTranslationX(AppInfo.l);
        TextView textView = this.d;
        textView.setText(getResources().getString(R.string.live_announce) + ":" + str);
        setVisibility(0);
        this.d.post(new Runnable() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LiveAnnouceView$DLdPagcMqjc8g5wjm9kqengeGps
            @Override // java.lang.Runnable
            public final void run() {
                LiveAnnouceView.this.d();
            }
        });
    }

    public void b() {
        removeCallbacks(this.a);
        setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setVisibility(8);
        removeCallbacks(this.a);
    }
}
