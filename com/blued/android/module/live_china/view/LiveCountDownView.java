package com.blued.android.module.live_china.view;

import android.content.Context;
import android.content.DialogInterface;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.module.common.widget.dialog.BluedAlertDialog;
import com.blued.android.module.live.base.utils.LiveTimeAndDateUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.das.live.LiveProtos;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveCountDownView.class */
public class LiveCountDownView extends FrameLayout {
    public View a;
    public View b;
    public TextView c;
    public TextView d;
    public ImageView e;
    Runnable f;
    Runnable g;
    public EventCallBack h;
    private final int i;
    private int j;
    private int k;
    private boolean l;

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveCountDownView$EventCallBack.class */
    public interface EventCallBack {
        void a();

        void a(boolean z);

        void b();
    }

    public LiveCountDownView(Context context) {
        this(context, null);
    }

    public LiveCountDownView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.i = 3;
        this.j = 0;
        this.k = 0;
        this.l = false;
        this.f = new Runnable() { // from class: com.blued.android.module.live_china.view.LiveCountDownView.2
            @Override // java.lang.Runnable
            public void run() {
                if (LiveCountDownView.this.j <= 0) {
                    LiveCountDownView.this.f();
                    return;
                }
                LiveCountDownView.this.l = true;
                LiveCountDownView.this.c.setText(String.valueOf(LiveCountDownView.this.j));
                LiveCountDownView.this.c.setVisibility(4);
                LiveCountDownView.this.c.clearAnimation();
                LiveCountDownView.this.c.startAnimation(LiveCountDownView.this.b());
                LiveCountDownView.c(LiveCountDownView.this);
            }
        };
        this.g = new Runnable() { // from class: com.blued.android.module.live_china.view.LiveCountDownView.4
            @Override // java.lang.Runnable
            public void run() {
                if (LiveCountDownView.this.getVisibility() == 8) {
                    return;
                }
                if (LiveCountDownView.this.k >= 297) {
                    LiveCountDownView.this.a(true);
                    return;
                }
                LiveCountDownView.e(LiveCountDownView.this);
                LiveCountDownView.this.d.setText(LiveTimeAndDateUtils.a(LiveCountDownView.this.k, false));
                LiveCountDownView liveCountDownView = LiveCountDownView.this;
                liveCountDownView.postDelayed(liveCountDownView.g, 1000L);
            }
        };
        e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        EventCallBack eventCallBack;
        setVisibility(8);
        this.a.setVisibility(8);
        this.b.setVisibility(0);
        EventCallBack eventCallBack2 = this.h;
        if (eventCallBack2 != null) {
            eventCallBack2.a(z);
        }
        if (!z && (eventCallBack = this.h) != null) {
            eventCallBack.b();
        }
        this.d.setText("00:00");
        d();
    }

    static /* synthetic */ int c(LiveCountDownView liveCountDownView) {
        int i = liveCountDownView.j;
        liveCountDownView.j = i - 1;
        return i;
    }

    static /* synthetic */ int e(LiveCountDownView liveCountDownView) {
        int i = liveCountDownView.k;
        liveCountDownView.k = i + 1;
        return i;
    }

    private void e() {
        LayoutInflater.from(getContext()).inflate(R.layout.live_record_button_view, this);
        this.a = findViewById(R.id.ll_record);
        this.b = findViewById(R.id.ll_recording);
        this.c = (TextView) findViewById(R.id.tv_count_time);
        this.d = (TextView) findViewById(R.id.tv_record_time);
        ImageView imageView = (ImageView) findViewById(R.id.iv_record_pause);
        this.e = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.LiveCountDownView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                EventTrackLive.b(LiveProtos.Event.LIVE_RECORD_SCREEN_STOP_CLICK, LiveRoomManager.a().e());
                LiveCountDownView.this.a(true);
            }
        });
        setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        this.l = false;
        this.j = 3;
        this.a.setVisibility(8);
        this.b.setVisibility(0);
        EventCallBack eventCallBack = this.h;
        if (eventCallBack != null) {
            eventCallBack.a();
        }
        this.d.setText("00:00");
        c();
    }

    public void a() {
        if (getVisibility() == 0) {
            return;
        }
        setVisibility(0);
        this.a.setVisibility(0);
        this.b.setVisibility(8);
        Log.i("xpm", "recordTime:" + this.k);
        this.k = 0;
        Log.i("xpm", "recordTime:" + this.k);
        this.j = 3;
        this.c.setText(String.valueOf(3));
        post(this.f);
    }

    public void a(Context context) {
        BluedAlertDialog.Builder builder = new BluedAlertDialog.Builder(context);
        builder.a(context.getResources().getString(R.string.live_recording_title)).b(context.getResources().getString(R.string.live_recording_content)).a(context.getResources().getString(R.string.live_record_confirm), new DialogInterface.OnClickListener() { // from class: com.blued.android.module.live_china.view.LiveCountDownView.6
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Tracker.onClick(dialogInterface, i);
                LiveCountDownView.this.a(false);
            }
        }).b(context.getResources().getString(R.string.live_record_cancel), new DialogInterface.OnClickListener() { // from class: com.blued.android.module.live_china.view.LiveCountDownView.5
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Tracker.onClick(dialogInterface, i);
            }
        }).a(false).b(true).h(context.getResources().getColor(R.color.syc_dark_BABABA)).a((DialogInterface.OnDismissListener) null).a(0);
        builder.a().show();
    }

    public AnimationSet b() {
        AnimationSet animationSet = new AnimationSet(true);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.5f, 1.0f, 0.5f, 1.0f, 1, 0.5f, 1, 0.5f);
        animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(scaleAnimation);
        animationSet.setAnimationListener(new Animation.AnimationListener() { // from class: com.blued.android.module.live_china.view.LiveCountDownView.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                Log.i("xpm", "onAnimationEnd");
                LiveCountDownView.this.c.setVisibility(4);
                LiveCountDownView liveCountDownView = LiveCountDownView.this;
                liveCountDownView.postDelayed(liveCountDownView.f, 500L);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                Log.i("xpm", "onAnimationRepeat:");
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                Log.i("xpm", "onAnimationStart:");
                LiveCountDownView.this.c.setVisibility(0);
            }
        });
        animationSet.setDuration(500L);
        animationSet.setFillAfter(true);
        animationSet.setRepeatCount(1);
        Log.i("xpm", "start:");
        return animationSet;
    }

    public void c() {
        postDelayed(this.g, 1000L);
    }

    public void d() {
        removeCallbacks(this.g);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.l = false;
        removeCallbacks(this.f);
        d();
    }

    public void setEventCallBack(EventCallBack eventCallBack) {
        this.h = eventCallBack;
    }
}
