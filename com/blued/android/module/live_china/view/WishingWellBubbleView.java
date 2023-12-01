package com.blued.android.module.live_china.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.ui.xpop.XPopup;
import com.blued.android.framework.ui.xpop.core.AttachPopupView;
import com.blued.android.framework.ui.xpop.core.BasePopupView;
import com.blued.android.framework.ui.xpop.enums.PopupAnimation;
import com.blued.android.framework.ui.xpop.enums.PopupPosition;
import com.blued.android.framework.ui.xpop.interfaces.XPopupCallback;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.observer.LiveRefreshUIObserver;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.das.live.LiveProtos;
import com.jeremyliao.liveeventbus.LiveEventBus;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/WishingWellBubbleView.class */
public class WishingWellBubbleView extends AttachPopupView {
    private boolean t;
    private View u;
    private View v;
    private TextView w;
    private View x;
    private String y;
    private String z;

    public WishingWellBubbleView(Context context, String str, String str2, boolean z) {
        super(context);
        this.y = str;
        this.z = str2;
        this.t = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void A() {
        if (t()) {
            return;
        }
        p();
        LiveEventBus.get("live_hide_wishing_welldot").post(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(View view) {
        if (this.t) {
            EventTrackLive.a(LiveProtos.Event.LIVE_HITS_TIPS_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g());
        } else {
            EventTrackLive.a(LiveProtos.Event.LIVE_HITS_EXPIRE_TIPS_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g());
        }
        if (TextUtils.isEmpty(this.z)) {
            LiveRefreshUIObserver.a().t();
        } else {
            LiveRefreshUIObserver.a().a(this.z);
        }
        p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z() {
        if (this.l == null || this.x == null) {
            return;
        }
        View a2 = this.l.a();
        View popupContentView = getPopupContentView();
        if (a2 == null || popupContentView == null) {
            return;
        }
        int width = popupContentView.getWidth();
        int[] iArr = new int[2];
        a2.getLocationOnScreen(iArr);
        int i = 0;
        int width2 = ((iArr[0] + (a2.getWidth() / 2)) - (popupContentView.getWidth() / 2)) + width;
        if (width2 > AppInfo.l) {
            i = AppInfo.l - width2;
        }
        if (i != 0) {
            this.x.setTranslationX(-i);
            ((FrameLayout.LayoutParams) popupContentView.getLayoutParams()).leftMargin += i;
            popupContentView.invalidate();
        }
    }

    public void a(View view, XPopupCallback xPopupCallback) {
        new XPopup.Builder(getContext()).a(xPopupCallback).a(PopupAnimation.ScrollAlphaFromBottom).d((Boolean) false).a(PopupPosition.Top).b(true).a(view).a((BasePopupView) this).h();
    }

    @Override // com.blued.android.framework.ui.xpop.core.AttachPopupView, com.blued.android.framework.ui.xpop.core.BasePopupView
    public void b() {
        super.b();
        if (this.t) {
            EventTrackLive.a(LiveProtos.Event.LIVE_HITS_TIPS_SHOW, LiveRoomManager.a().e(), LiveRoomManager.a().g());
        } else {
            EventTrackLive.a(LiveProtos.Event.LIVE_HITS_EXPIRE_TIPS_SHOW, LiveRoomManager.a().e(), LiveRoomManager.a().g());
        }
        this.u = findViewById(R.id.rl_root);
        this.v = findViewById(R.id.rl_content);
        this.w = (TextView) findViewById(R.id.tv_content);
        this.x = findViewById(R.id.iv_indicate);
        this.w.setText(this.y);
        this.w.getPaint().setFakeBoldText(true);
        this.v.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.-$$Lambda$WishingWellBubbleView$sjQpW8907Rh_SaKUx-S2gRQao8U
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WishingWellBubbleView.this.c(view);
            }
        });
        AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.android.module.live_china.view.-$$Lambda$WishingWellBubbleView$6XAVjXnt5iAWiUb5v3vQTDU-gu4
            @Override // java.lang.Runnable
            public final void run() {
                WishingWellBubbleView.this.A();
            }
        }, 5000L);
        View view = this.u;
        if (view == null) {
            return;
        }
        view.post(new Runnable() { // from class: com.blued.android.module.live_china.view.-$$Lambda$WishingWellBubbleView$_9McJ3e8W3EuF2lFYO137A3uMCc
            @Override // java.lang.Runnable
            public final void run() {
                WishingWellBubbleView.this.z();
            }
        });
    }

    public void b(View view) {
        a(view, (XPopupCallback) null);
    }

    @Override // com.blued.android.framework.ui.xpop.core.BasePopupView
    public int getImplLayoutId() {
        return R.layout.pop_wishing_well;
    }

    @Override // com.blued.android.framework.ui.xpop.core.BasePopupView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        p();
        return false;
    }
}
