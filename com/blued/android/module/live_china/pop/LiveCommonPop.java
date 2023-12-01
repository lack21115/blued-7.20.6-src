package com.blued.android.module.live_china.pop;

import android.graphics.Rect;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.ui.xpop.XPopup;
import com.blued.android.framework.ui.xpop.core.AttachPopupView;
import com.blued.android.framework.ui.xpop.core.BasePopupView;
import com.blued.android.framework.ui.xpop.enums.PopupAnimation;
import com.blued.android.framework.ui.xpop.enums.PopupPosition;
import com.blued.android.framework.ui.xpop.interfaces.XPopupCallback;
import com.blued.android.framework.ui.xpop.util.XPopupUtils;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.das.live.LiveProtos;
import com.bytedance.applog.tracker.Tracker;
import com.jeremyliao.liveeventbus.LiveEventBus;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/pop/LiveCommonPop.class */
public class LiveCommonPop extends AttachPopupView {
    private int[] A;
    private int t;
    private String u;
    private boolean v;
    private int w;
    private int x;
    private int y;
    private int[] z;

    /* renamed from: com.blued.android.module.live_china.pop.LiveCommonPop$3  reason: invalid class name */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/pop/LiveCommonPop$3.class */
    class AnonymousClass3 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f13965a;
        final /* synthetic */ XPopupCallback b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ boolean f13966c;
        final /* synthetic */ LiveCommonPop d;

        @Override // java.lang.Runnable
        public void run() {
            this.f13965a.getLocationOnScreen(this.d.z);
            this.d.A[0] = this.f13965a.getMeasuredWidth();
            this.d.A[1] = this.f13965a.getMeasuredHeight();
            new XPopup.Builder(this.d.getContext()).a(this.b).a(PopupAnimation.ScaleAlphaFromCenter).d((Boolean) false).a(PopupPosition.Top).b(this.f13966c).a(this.f13965a).a((BasePopupView) this.d).h();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void A() {
        if (t()) {
            return;
        }
        p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        if (this.y == 0) {
            EventTrackLive.a(LiveProtos.Event.LIVE_PK_TIPS_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g());
            LiveEventBus.get("live_center_multi_con_friends_pop").post(true);
        }
        p();
    }

    @Override // com.blued.android.framework.ui.xpop.core.AttachPopupView, com.blued.android.framework.ui.xpop.core.BasePopupView
    public void b() {
        super.b();
        ((TextView) findViewById(R.id.tv_tip)).setText(this.u);
        View findViewById = findViewById(R.id.rl_root);
        if (findViewById != null) {
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.pop.LiveCommonPop.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    LiveCommonPop.this.z();
                }
            });
        }
        AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.android.module.live_china.pop.-$$Lambda$LiveCommonPop$CcUPK25sHp86PG0S6Kr_fCl2uj4
            @Override // java.lang.Runnable
            public final void run() {
                LiveCommonPop.this.A();
            }
        }, this.t);
    }

    @Override // com.blued.android.framework.ui.xpop.core.AttachPopupView
    public void d() {
        super.d();
        getPopupContentView().post(new Runnable() { // from class: com.blued.android.module.live_china.pop.LiveCommonPop.2
            @Override // java.lang.Runnable
            public void run() {
                View findViewById = LiveCommonPop.this.findViewById(R.id.rl_root);
                boolean z = false;
                findViewById.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
                findViewById.layout(0, 0, findViewById.getMeasuredWidth(), findViewById.getMeasuredHeight());
                LiveCommonPop.this.w = findViewById.getMeasuredWidth();
                Rect rect = new Rect(LiveCommonPop.this.z[0], LiveCommonPop.this.z[1], LiveCommonPop.this.z[0] + LiveCommonPop.this.A[0], LiveCommonPop.this.z[1] + LiveCommonPop.this.A[1]);
                if ((rect.left + rect.right) / 2 <= XPopupUtils.a(AppInfo.d()) / 2) {
                    z = true;
                }
                Log.i("==xpm", "isShowLeft:" + z);
                View findViewById2 = LiveCommonPop.this.findViewById(R.id.iv_tip);
                if (LiveCommonPop.this.v) {
                    LiveCommonPop liveCommonPop = LiveCommonPop.this;
                    liveCommonPop.x = (liveCommonPop.w - DensityUtils.a(AppInfo.d(), 12.0f)) / 2;
                } else if (z) {
                    LiveCommonPop.this.x = DensityUtils.a(AppInfo.d(), 12.5f);
                } else {
                    LiveCommonPop liveCommonPop2 = LiveCommonPop.this;
                    liveCommonPop2.x = liveCommonPop2.w - DensityUtils.a(AppInfo.d(), 24.5f);
                }
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) findViewById2.getLayoutParams();
                marginLayoutParams.leftMargin = LiveCommonPop.this.x;
                findViewById2.setLayoutParams(marginLayoutParams);
            }
        });
    }

    @Override // com.blued.android.framework.ui.xpop.core.BasePopupView
    public int getImplLayoutId() {
        return R.layout.pop_live_tips;
    }

    @Override // com.blued.android.framework.ui.xpop.core.BasePopupView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        z();
        return false;
    }

    @Override // com.blued.android.framework.ui.xpop.core.BasePopupView
    public void u() {
        super.u();
    }
}
