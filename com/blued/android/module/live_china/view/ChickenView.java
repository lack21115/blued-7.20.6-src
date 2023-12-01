package com.blued.android.module.live_china.view;

import android.content.Context;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityBaseExtra;
import com.blued.android.framework.utils.AppUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.EnumOperation;
import com.blued.android.module.live_china.model.LiveGetChickenStatusExtraModel;
import com.blued.android.module.live_china.msg.LiveEventBusUtil;
import com.blued.android.module.live_china.observer.LiveRefreshUIObserver;
import com.blued.android.module.live_china.observer.LiveSetDataObserver;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.android.module.live_china.view.MarqueeTextView;
import com.blued.das.live.LiveProtos;
import com.jeremyliao.liveeventbus.LiveEventBus;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/ChickenView.class */
public class ChickenView extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    public boolean f14248a;
    public BaseFragment b;

    /* renamed from: c  reason: collision with root package name */
    private LiveGetChickenStatusExtraModel f14249c;
    private MarqueeTextView d;
    private String e;
    private String f;
    private Runnable g;
    private CountDownTimer h;

    public ChickenView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public ChickenView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(long j) {
        long j2 = j + 60;
        long j3 = j2 / 86400000;
        long j4 = j2 / 3600000;
        long j5 = j3 * 24;
        long j6 = j4 - j5;
        long j7 = ((j2 / 60000) - (j5 * 60)) - (60 * j6);
        long j8 = j2 / 1000;
        if (j6 > 0) {
            return String.format(getContext().getResources().getString(R.string.live_chicken_icon_hour_and_minute), Long.valueOf(j6), Long.valueOf(j7));
        }
        long j9 = j7;
        if (j7 == 0) {
            j9 = j7 + 1;
        }
        return String.format(getContext().getResources().getString(R.string.live_chicken_icon_minute), Long.valueOf(j9));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        MarqueeTextView marqueeTextView = this.d;
        if (marqueeTextView != null) {
            marqueeTextView.b();
        }
        CountDownTimer countDownTimer = this.h;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.h = null;
        }
        if (this.g != null) {
            AppInfo.n().removeCallbacks(this.g);
            this.g = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(int i) {
        if (i <= 1 || TextUtils.isEmpty(this.e)) {
            return;
        }
        this.d.b();
        b();
    }

    private void a(Context context) {
        LayoutInflater.from(getContext()).inflate(R.layout.live_chicken_layout, this);
        this.d = (MarqueeTextView) findViewById(R.id.tv_chicken_content);
        this.f14249c = null;
        a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        if (this.f14249c.link_half_open) {
            if (this.f14248a) {
                LiveSetDataObserver.a().b(this.f14249c.link_url, 0);
            } else {
                LiveRefreshUIObserver.a().b(this.f14249c.link_url, 0);
            }
        } else if (this.f14248a) {
            LiveSetDataObserver.a().f(this.f14249c.link_url);
        } else {
            LiveRefreshUIObserver.a().a(this.f14249c.link_url);
        }
        LiveGetChickenStatusExtraModel liveGetChickenStatusExtraModel = this.f14249c;
        if (liveGetChickenStatusExtraModel != null) {
            int i = liveGetChickenStatusExtraModel.status;
            EventTrackLive.o(LiveProtos.Event.LIVE_PK_CHICKEN_BTN_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g(), i != 1 ? i != 2 ? "todo" : "countdown" : "pking");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LiveGetChickenStatusExtraModel liveGetChickenStatusExtraModel) {
        a();
        this.f14249c = liveGetChickenStatusExtraModel;
        int i = liveGetChickenStatusExtraModel.status;
        boolean z = true;
        if (i == 1) {
            this.e = AppUtils.a(R.string.live_chicken_icon_ing);
            this.d.b();
            z = false;
        } else if (i == 2) {
            d();
        } else if (i == 3) {
            this.e = AppUtils.a(R.string.live_chicken_icon_allow);
        } else if (i != 4) {
            this.f14249c = null;
            setVisibility(8);
            return;
        } else {
            this.e = AppUtils.a(R.string.live_chicken_icon_not_allow);
        }
        if (TextUtils.isEmpty(this.e)) {
            this.d.b();
            this.f14249c = null;
            a();
            setVisibility(8);
            return;
        }
        if (z) {
            b();
        } else {
            this.d.setText(this.e, TextView.BufferType.SPANNABLE);
            this.d.b();
        }
        c();
        if (TextUtils.isEmpty(this.f14249c.link_url)) {
            setClickable(false);
        } else {
            setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.-$$Lambda$ChickenView$hO8E6cnh8-VqLr97OJSouupfG0w
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ChickenView.this.a(view);
                }
            });
        }
    }

    private void b() {
        this.d.setListener(new MarqueeTextView.callbackListener() { // from class: com.blued.android.module.live_china.view.-$$Lambda$ChickenView$Mb8NEv4YAg-fWJ0qTsksK9wUZZ0
            @Override // com.blued.android.module.live_china.view.MarqueeTextView.callbackListener
            public final void onFinish(int i) {
                ChickenView.this.a(i);
            }
        });
        this.d.setWaitTime(0L);
        this.d.setScrollSpeed(1.3f);
        MarqueeTextView marqueeTextView = this.d;
        marqueeTextView.setText("   " + this.e, TextView.BufferType.SPANNABLE);
        this.e = null;
        this.d.a();
    }

    private void c() {
        LiveGetChickenStatusExtraModel liveGetChickenStatusExtraModel = this.f14249c;
        if (liveGetChickenStatusExtraModel != null && liveGetChickenStatusExtraModel.countdown > 0) {
            this.g = new Runnable() { // from class: com.blued.android.module.live_china.view.-$$Lambda$ChickenView$9qtpT_wWLcnzV_DcQCaZ0_fSMbc
                @Override // java.lang.Runnable
                public final void run() {
                    ChickenView.this.e();
                }
            };
            AppInfo.n().postDelayed(this.g, this.f14249c.countdown * 1000);
        } else if (this.g != null) {
            AppInfo.n().removeCallbacks(this.g);
            this.g = null;
        }
    }

    private void d() {
        this.f = a(this.f14249c.countdown * 1000);
        this.e = String.format(getContext().getResources().getString(R.string.live_chicken_icon_game_time), this.f);
        CountDownTimer countDownTimer = this.h;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.h = null;
        }
        this.h = new CountDownTimer(this.f14249c.countdown * 1000, 1000L) { // from class: com.blued.android.module.live_china.view.ChickenView.2
            @Override // android.os.CountDownTimer
            public void onFinish() {
                if (ChickenView.this.h != null) {
                    ChickenView.this.h.cancel();
                    ChickenView.this.h = null;
                }
                if (ChickenView.this.g != null) {
                    AppInfo.n().removeCallbacks(ChickenView.this.g);
                    ChickenView.this.g = null;
                }
                ChickenView.this.e();
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                String a2 = ChickenView.this.a(Math.round((float) j));
                if (a2.equals(ChickenView.this.f)) {
                    return;
                }
                ChickenView.this.f = a2;
                ChickenView chickenView = ChickenView.this;
                chickenView.e = String.format(chickenView.getContext().getResources().getString(R.string.live_chicken_icon_game_time), ChickenView.this.f);
            }
        }.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getLiveChickenState */
    public void e() {
        LiveRoomHttpUtils.a((BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntity<BluedEntityBaseExtra, LiveGetChickenStatusExtraModel>>(this.b.getFragmentActive()) { // from class: com.blued.android.module.live_china.view.ChickenView.1
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str) {
                return true;
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<BluedEntityBaseExtra, LiveGetChickenStatusExtraModel> bluedEntity) {
                if (bluedEntity != null && bluedEntity.extra != null) {
                    ChickenView.this.a(bluedEntity.extra);
                    return;
                }
                ChickenView.this.f14249c = null;
                ChickenView.this.a();
                ChickenView.this.setVisibility(8);
            }
        }, LiveRoomManager.a().e(), this.b.getFragmentActive());
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        LiveGetChickenStatusExtraModel liveGetChickenStatusExtraModel;
        if (i == 8) {
            a();
            LiveEventBus.get(LiveEventBusUtil.k).post(Integer.valueOf(EnumOperation.VIEW_TYPE_CHICKEN_WIN.getValue()));
        } else if (i != 0 || (liveGetChickenStatusExtraModel = this.f14249c) == null) {
        } else {
            int i2 = liveGetChickenStatusExtraModel.status;
            EventTrackLive.o(LiveProtos.Event.LIVE_PK_CHICKEN_BTN_SHOW, LiveRoomManager.a().e(), LiveRoomManager.a().g(), i2 != 1 ? i2 != 2 ? "todo" : "countdown" : "pking");
        }
    }
}
