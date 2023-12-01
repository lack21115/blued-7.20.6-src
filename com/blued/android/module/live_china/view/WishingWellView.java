package com.blued.android.module.live_china.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.internal.util.cm.QSConstants;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.EnumOperation;
import com.blued.android.module.live_china.model.LiveWishingDrawModel;
import com.blued.android.module.live_china.msg.LiveEventBusUtil;
import com.blued.android.module.live_china.observer.LiveSetDataObserver;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.android.module.live_china.view.WishingWellView;
import com.blued.das.live.LiveProtos;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.text.DecimalFormat;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/WishingWellView.class */
public class WishingWellView extends FrameLayout {
    public static String a;
    private BaseFragment b;
    private LiveWishingDrawModel c;
    private CountDownTimer d;
    private View e;
    private ImageView f;
    private ImageView g;
    private TextView h;
    private TextView i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.blued.android.module.live_china.view.WishingWellView$1  reason: invalid class name */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/WishingWellView$1.class */
    public class AnonymousClass1 extends CountDownTimer {
        AnonymousClass1(long j, long j2) {
            super(j, j2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a() {
            WishingWellView.this.setVisibility(8);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            LiveSetDataObserver.a().a((LiveWishingDrawModel) null);
            WishingWellView.this.post(new Runnable() { // from class: com.blued.android.module.live_china.view.-$$Lambda$WishingWellView$1$G1AhzbHjXkktLaF3xxWLhghtYPA
                @Override // java.lang.Runnable
                public final void run() {
                    WishingWellView.AnonymousClass1.this.a();
                }
            });
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            WishingWellView.this.i.setText(String.format(WishingWellView.this.getContext().getResources().getString(R.string.live_wishing_well_time), Long.valueOf(j / 1000)));
        }
    }

    public WishingWellView(Context context) {
        this(context, null);
    }

    public WishingWellView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    private String a(float f) {
        if (f >= 10000.0f) {
            return new DecimalFormat("0").format(f / 10000.0f) + "w";
        }
        return new DecimalFormat("0").format(f);
    }

    private void a() {
        LayoutInflater.from(getContext()).inflate(R.layout.live_wishing_well_view, this);
        this.e = findViewById(R.id.rl_wishing_well_content);
        this.f = (ImageView) findViewById(R.id.iv_wishing_well_knocking_lighting);
        this.g = (ImageView) findViewById(R.id.iv_wishing_well_knocking_gift);
        this.h = (TextView) findViewById(R.id.tv_wishing_well_knocking_percentage);
        this.i = (TextView) findViewById(R.id.tv_wishing_well_knocking_time);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        EventTrackLive.a(LiveProtos.Event.LIVE_HITS_GIFT_ICON_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g(), this.c.goods_id);
        LiveSetDataObserver.a().w();
    }

    private void b() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f, QSConstants.TILE_ROTATION, 0.0f, 360.0f);
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(-1);
        ofFloat.setInterpolator(new DecelerateInterpolator(1.2f));
        ofFloat.setDuration(5000L);
        ofFloat.start();
        ImageLoader.a(this.b.getFragmentActive(), this.c.goods_icon).a(this.g);
        this.h.setText(String.format(getContext().getResources().getString(R.string.live_wishing_well_percentage), a(this.c.times)));
        c();
        post(new Runnable() { // from class: com.blued.android.module.live_china.view.-$$Lambda$WishingWellView$1acWU2EUAaOhgi7PNZcHWwpealo
            @Override // java.lang.Runnable
            public final void run() {
                WishingWellView.this.d();
            }
        });
        a = this.c.url;
        setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.-$$Lambda$WishingWellView$dyN_egblagxwvqv5pwRrO108ZyU
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WishingWellView.this.a(view);
            }
        });
    }

    private void c() {
        LiveWishingDrawModel liveWishingDrawModel = this.c;
        if (liveWishingDrawModel != null && liveWishingDrawModel.countdown > 0) {
            CountDownTimer countDownTimer = this.d;
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            this.d = new AnonymousClass1(this.c.countdown * 1000, 1000L).start();
            return;
        }
        CountDownTimer countDownTimer2 = this.d;
        if (countDownTimer2 != null) {
            countDownTimer2.cancel();
            this.d = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.e, "scaleX", 1.0f, 1.1f, 1.0f);
        ofFloat.setDuration(1200L);
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(-1);
        ofFloat.start();
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.e, "scaleY", 1.0f, 1.1f, 1.0f);
        ofFloat2.setDuration(1200L);
        ofFloat2.setRepeatCount(-1);
        ofFloat2.setRepeatMode(-1);
        ofFloat2.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e() {
        setVisibility(8);
    }

    public boolean a(LiveWishingDrawModel liveWishingDrawModel) {
        this.c = liveWishingDrawModel;
        if (liveWishingDrawModel == null) {
            post(new Runnable() { // from class: com.blued.android.module.live_china.view.-$$Lambda$WishingWellView$2moyD0gEtjLLXcizJRqGbCi4YL8
                @Override // java.lang.Runnable
                public final void run() {
                    WishingWellView.this.e();
                }
            });
            return false;
        }
        b();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public void setBaseFragment(BaseFragment baseFragment) {
        this.b = baseFragment;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void setVisibility(int i) {
        if (i == 8) {
            a = "";
            CountDownTimer countDownTimer = this.d;
            if (countDownTimer != null) {
                countDownTimer.cancel();
                this.d = null;
            }
            LiveEventBus.get(LiveEventBusUtil.k).post(Integer.valueOf(EnumOperation.VIEW_TYPE_WISHING_KNOCKING.getValue()));
        }
    }
}
