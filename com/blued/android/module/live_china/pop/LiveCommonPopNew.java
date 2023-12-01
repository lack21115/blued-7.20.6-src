package com.blued.android.module.live_china.pop;

import android.graphics.Rect;
import android.text.TextUtils;
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
import com.blued.android.module.live_china.model.LivePopItemModel;
import com.blued.android.module.live_china.observer.LiveSetDataObserver;
import com.bytedance.applog.tracker.Tracker;
import com.jeremyliao.liveeventbus.LiveEventBus;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/pop/LiveCommonPopNew.class */
public class LiveCommonPopNew extends AttachPopupView {
    private boolean A;
    Runnable t;
    private boolean u;
    private int v;
    private int w;
    private LivePopItemModel x;
    private int[] y;
    private int[] z;

    /* renamed from: com.blued.android.module.live_china.pop.LiveCommonPopNew$2  reason: invalid class name */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/pop/LiveCommonPopNew$2.class */
    class AnonymousClass2 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ LiveCommonPopNew f13968a;

        @Override // java.lang.Runnable
        public void run() {
            if (this.f13968a.t()) {
                return;
            }
            this.f13968a.p();
        }
    }

    /* renamed from: com.blued.android.module.live_china.pop.LiveCommonPopNew$4  reason: invalid class name */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/pop/LiveCommonPopNew$4.class */
    class AnonymousClass4 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f13970a;
        final /* synthetic */ XPopupCallback b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ boolean f13971c;
        final /* synthetic */ LiveCommonPopNew d;

        @Override // java.lang.Runnable
        public void run() {
            this.f13970a.getLocationOnScreen(this.d.y);
            this.d.z[0] = this.f13970a.getMeasuredWidth();
            this.d.z[1] = this.f13970a.getMeasuredHeight();
            new XPopup.Builder(this.d.getContext()).a(this.b).a(PopupAnimation.ScaleAlphaFromCenter).d((Boolean) false).a(PopupPosition.Top).b(this.f13971c).a(this.f13970a).a((BasePopupView) this.d).h();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A() {
        if (this.x.getLink_type() == 1) {
            if (!TextUtils.isEmpty(this.x.getLink())) {
                LiveSetDataObserver.a().b(this.x.getLink(), 25);
            }
        } else if (this.x.getLink_type() == 2 && !TextUtils.isEmpty(this.x.getLink())) {
            LiveSetDataObserver.a().c(this.x.getLink(), 25);
        }
        p();
    }

    @Override // com.blued.android.framework.ui.xpop.core.AttachPopupView, com.blued.android.framework.ui.xpop.core.BasePopupView
    public void b() {
        super.b();
        ((TextView) findViewById(R.id.tv_tip)).setText(this.x.getText());
        View findViewById = findViewById(R.id.rl_root);
        if (findViewById != null) {
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.pop.LiveCommonPopNew.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    AppInfo.n().removeCallbacks(LiveCommonPopNew.this.t);
                    LiveCommonPopNew.this.A();
                }
            });
        }
        if (this.x.getPop_duration_local() > 0) {
            AppInfo.n().postDelayed(this.t, this.x.getPop_duration_local());
        }
    }

    @Override // com.blued.android.framework.ui.xpop.core.AttachPopupView
    public void d() {
        super.d();
        getPopupContentView().post(new Runnable() { // from class: com.blued.android.module.live_china.pop.LiveCommonPopNew.3
            @Override // java.lang.Runnable
            public void run() {
                View findViewById = LiveCommonPopNew.this.findViewById(R.id.rl_root);
                boolean z = false;
                findViewById.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
                findViewById.layout(0, 0, findViewById.getMeasuredWidth(), findViewById.getMeasuredHeight());
                LiveCommonPopNew.this.v = findViewById.getMeasuredWidth();
                Rect rect = new Rect(LiveCommonPopNew.this.y[0], LiveCommonPopNew.this.y[1], LiveCommonPopNew.this.y[0] + LiveCommonPopNew.this.z[0], LiveCommonPopNew.this.y[1] + LiveCommonPopNew.this.z[1]);
                if ((rect.left + rect.right) / 2 <= XPopupUtils.a(AppInfo.d()) / 2) {
                    z = true;
                }
                Log.i("==xpm", "isShowLeft:" + z);
                View findViewById2 = LiveCommonPopNew.this.findViewById(R.id.iv_tip);
                if (LiveCommonPopNew.this.u) {
                    LiveCommonPopNew liveCommonPopNew = LiveCommonPopNew.this;
                    liveCommonPopNew.w = (liveCommonPopNew.v - DensityUtils.a(AppInfo.d(), 12.0f)) / 2;
                } else if (z) {
                    LiveCommonPopNew.this.w = DensityUtils.a(AppInfo.d(), 12.5f);
                } else {
                    LiveCommonPopNew liveCommonPopNew2 = LiveCommonPopNew.this;
                    liveCommonPopNew2.w = liveCommonPopNew2.v - DensityUtils.a(AppInfo.d(), 24.5f);
                }
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) findViewById2.getLayoutParams();
                marginLayoutParams.leftMargin = LiveCommonPopNew.this.w;
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
        A();
        return false;
    }

    @Override // com.blued.android.framework.ui.xpop.core.BasePopupView
    public void u() {
        super.u();
        z();
    }

    public void z() {
        this.A = false;
        LiveEventBus.get("live_common_pop").post("");
    }
}
