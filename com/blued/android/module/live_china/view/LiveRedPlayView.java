package com.blued.android.module.live_china.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.utils.CommonTools;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.module.common.utils.NetworkUtils;
import com.blued.android.module.live_china.manager.LiveFloatManager;
import com.blued.android.module.live_china.model.BluedLiveListData;
import com.blued.android.module.live_china.model.LiveRoomData;
import com.blued.android.module.player.txplayer.view.BlLiveView;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveRedPlayView.class */
public class LiveRedPlayView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    ImageView f14919a;
    boolean b;

    /* renamed from: c  reason: collision with root package name */
    Runnable f14920c;
    Runnable d;
    private long e;
    private int f;
    private BluedLiveListData g;
    private String h;
    private boolean i;
    private int j;
    private int k;
    private boolean l;
    private boolean m;
    private LiveListAutoPlay n;
    private boolean o;
    private LiveAutoPlayManager p;

    public LiveRedPlayView(Context context) {
        this(context, null);
    }

    public LiveRedPlayView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LiveRedPlayView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.e = -1L;
        this.f = -1;
        this.g = new BluedLiveListData();
        this.i = false;
        this.l = true;
        this.m = false;
        this.o = true;
        this.f14919a = null;
        this.p = null;
        this.b = true;
        this.f14920c = new Runnable() { // from class: com.blued.android.module.live_china.view.LiveRedPlayView.1
            @Override // java.lang.Runnable
            public void run() {
                Log.i("LiveRedPlayView", "resumeRunnable");
                LiveRedPlayView.this.f();
            }
        };
        this.d = new Runnable() { // from class: com.blued.android.module.live_china.view.LiveRedPlayView.2
            @Override // java.lang.Runnable
            public void run() {
                if (LiveRedPlayView.this.getChildCount() > 0) {
                    LiveRedPlayView.this.d();
                }
            }
        };
        a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (this.m) {
            return;
        }
        if (LiveFloatManager.a().H()) {
            Log.i("LiveRedPlayView", "prepare play but float window showing");
        } else if (!this.i) {
            Log.i("LiveRedPlayView", "prepare pause");
            if (getChildCount() > 0) {
                d();
            }
            this.p.f();
        } else {
            Log.i("LiveRedPlayView", "prepare play");
            if (this.f == 0) {
                if (this.e == this.p.g() && this.p.l() && getChildCount() != 0) {
                    Log.i("LiveRedPlayView", "return for playing");
                } else {
                    g();
                }
            }
        }
    }

    private void g() {
        Log.i("LiveRedPlayView", "autoPlay isAppInBackground:" + AppInfo.g());
        if ((this.o && NetworkUtils.a()) || AppInfo.g() || this.g.anchor == null) {
            return;
        }
        LiveRoomData liveRoomData = new LiveRoomData(CommonTools.a(this.g.lid), this.g.screen_pattern, this.h, this.g.uid, this.g.anchor.name, this.g.anchor.avatar, this.g.anchor.vbadge);
        liveRoomData.live_url = this.g.live_play;
        this.p.a(liveRoomData, this.h, this, this.j, this.k);
        this.l = false;
    }

    void a() {
        this.p = LiveAutoPlayManager.b();
        ImageView imageView = new ImageView(getContext());
        this.f14919a = imageView;
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.f14919a, new FrameLayout.LayoutParams(-1, -1));
    }

    public void a(LiveListAutoPlay liveListAutoPlay, BluedLiveListData bluedLiveListData, String str, int i, int i2) {
        if (bluedLiveListData == null) {
            return;
        }
        this.n = liveListAutoPlay;
        this.g = bluedLiveListData;
        this.h = str;
        this.j = i;
        this.k = i2;
        this.e = StringUtils.a(bluedLiveListData.lid, 0L);
        int i3 = bluedLiveListData.positionReal;
        this.f = i3;
        if (i3 == 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("setSessionData ===name:");
            sb.append(bluedLiveListData.anchor.name);
            sb.append(bluedLiveListData.lid);
            sb.append(bluedLiveListData.auth != null ? bluedLiveListData.anchor.name : "");
            sb.append("  position:");
            sb.append(this.f);
            Log.i("LiveRedPlayView", sb.toString());
        }
    }

    public void a(boolean z) {
        this.m = z;
        if (z) {
            removeCallbacks(this.f14920c);
        }
    }

    public void b() {
        removeCallbacks(this.f14920c);
        AppInfo.n().postDelayed(this.f14920c, 300L);
    }

    public void c() {
        Log.i("LiveRedPlayView", "redplay pause");
        removeCallbacks(this.f14920c);
        this.p.f();
    }

    public void d() {
        int childCount = getChildCount();
        if (childCount > 0) {
            int i = -1;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= childCount) {
                    break;
                }
                if (getChildAt(i3) instanceof BlLiveView) {
                    i = i3;
                }
                i2 = i3 + 1;
            }
            if (i >= 0) {
                removeView(getChildAt(i));
            }
        }
    }

    public boolean e() {
        return this.i && this.f == 0;
    }

    public long getSessionId() {
        return this.e;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f == 0) {
            Log.i("LiveRedPlayView", "AttachedToWindow： " + this.g.title + this.g.description);
        }
        this.i = true;
        if (this.f == 0 && this.l) {
            Log.i("LiveRedPlayView", "firstLoadData");
            LiveListAutoPlay liveListAutoPlay = this.n;
            if (liveListAutoPlay != null) {
                liveListAutoPlay.c();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.i = false;
        if (this.f == 0) {
            Log.i("LiveRedPlayView", "onDetachedFromWindow： " + this.g.title + this.g.description);
        }
        removeCallbacks(this.f14920c);
        if (LiveAutoPlayManager.a().f14368a != null && LiveAutoPlayManager.a().f14368a.getParent() == this) {
            c();
            d();
        }
        this.n = null;
    }

    public void setCheckWIFI(boolean z) {
        this.o = z;
    }
}
