package com.blued.android.module.shortvideo.view;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.animation.AlphaAnimation;
import android.view.animation.ScaleAnimation;
import androidx.appcompat.widget.AppCompatTextView;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.shortvideo.R;
import com.blued.android.module.shortvideo.manager.ObserverMgr;
import com.blued.android.module.shortvideo.model.EventType;
import com.blued.android.module.shortvideo.observer.EventObserver;
import com.blued.android.module.shortvideo.presenter.ShinePresenter;
import java.lang.ref.WeakReference;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/view/TimeDownView.class */
public class TimeDownView extends AppCompatTextView implements EventObserver {

    /* renamed from: a  reason: collision with root package name */
    private Handler f15917a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private ShinePresenter f15918c;

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/view/TimeDownView$MsgHandler.class */
    public static class MsgHandler extends Handler {

        /* renamed from: a  reason: collision with root package name */
        private WeakReference<TimeDownView> f15919a;

        public MsgHandler(TimeDownView timeDownView) {
            this.f15919a = new WeakReference<>(timeDownView);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            TimeDownView timeDownView = this.f15919a.get();
            if (timeDownView != null) {
                timeDownView.a(message);
            }
        }
    }

    public TimeDownView(Context context) {
        super(context);
        this.f15917a = new MsgHandler(this);
        this.b = 3;
    }

    public TimeDownView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f15917a = new MsgHandler(this);
        this.b = 3;
    }

    public TimeDownView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f15917a = new MsgHandler(this);
        this.b = 3;
    }

    private void g() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.3f, 1.0f);
        alphaAnimation.setDuration(1000L);
        startAnimation(alphaAnimation);
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.5f, 1.0f, 0.5f, 1.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(1000L);
        startAnimation(scaleAnimation);
    }

    public void a() {
        ShinePresenter shinePresenter = this.f15918c;
        if (shinePresenter != null) {
            shinePresenter.a(5);
        }
        setVisibility(0);
        setText("" + this.b);
        g();
    }

    public void a(Message message) {
        if (this.b == 0) {
            ObserverMgr.a().a(EventType.VALUE.SHINE_RECORD);
            b();
            return;
        }
        setText("" + this.b);
        g();
        this.f15917a.sendEmptyMessageDelayed(0, 1000L);
        this.b = this.b - 1;
    }

    @Override // com.blued.android.module.shortvideo.observer.EventObserver
    public void a(EventType.VALUE value) {
        if (value == EventType.VALUE.START_TIMEDOWN) {
            a();
            this.f15917a.sendEmptyMessage(0);
        }
    }

    public void a(ShinePresenter shinePresenter) {
        this.f15918c = shinePresenter;
        setTextColor(getResources().getColor(R.color.nafio_b));
        setShadowLayer(1.0f, 0.0f, 1.0f, getResources().getColor(R.color.stv_tv_shadow_color));
        setTextSize(DensityUtils.c(getContext(), 200.0f));
        getPaint().setFakeBoldText(true);
    }

    public void b() {
        this.f15917a.removeMessages(0);
        this.b = 3;
        ShinePresenter shinePresenter = this.f15918c;
        if (shinePresenter != null) {
            shinePresenter.a(0);
        }
        setVisibility(8);
    }

    public void c() {
        ObserverMgr.a().a(this);
    }

    public void d() {
        if (getVisibility() == 0) {
            ObserverMgr.a().a(EventType.VALUE.RECOVER_SHINE_V);
        }
        b();
    }

    public void e() {
        ObserverMgr.a().b(this);
    }

    public void f() {
        this.f15917a.removeMessages(0);
    }
}
