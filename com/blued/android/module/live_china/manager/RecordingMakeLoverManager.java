package com.blued.android.module.live_china.manager;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.fragment.RecordingOnliveFragment;
import com.blued.android.module.live_china.model.LiveMakeLoverFansModel;
import com.blued.android.module.live_china.same.Logger;
import com.blued.android.module.live_china.utils.LivePreferencesUtils;
import com.blued.android.module.live_china.view.HoleRelativeLayout;
import com.blued.android.module.live_china.view.NewFuncPopwindow;
import java.util.List;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/manager/RecordingMakeLoverManager.class */
public class RecordingMakeLoverManager extends MakeLoverBaseManager {
    public static int b = 0;

    /* renamed from: c  reason: collision with root package name */
    public static int f13755c = 0;
    public static double d = 1.0d;
    View.OnLayoutChangeListener e = new AnonymousClass3();
    private Context f;
    private RecordingOnliveFragment g;
    private int h;

    /* renamed from: com.blued.android.module.live_china.manager.RecordingMakeLoverManager$3  reason: invalid class name */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/manager/RecordingMakeLoverManager$3.class */
    class AnonymousClass3 implements View.OnLayoutChangeListener {
        AnonymousClass3() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            int i9;
            int childCount = RecordingMakeLoverManager.this.g.cU.getChildCount();
            int i10 = 0;
            int i11 = 0;
            while (true) {
                i9 = i11;
                if (i10 >= childCount) {
                    break;
                }
                int i12 = i9;
                if (RecordingMakeLoverManager.this.g.cU.getChildAt(i10).getVisibility() == 0) {
                    i12 = i9 + 1;
                }
                i10++;
                i11 = i12;
            }
            if (RecordingMakeLoverManager.this.g.cU.getTag() != null && (RecordingMakeLoverManager.this.g.cU.getTag() instanceof Integer) && ((Integer) RecordingMakeLoverManager.this.g.cU.getTag()).intValue() == i9) {
                return;
            }
            RecordingMakeLoverManager.this.g.cU.setTag(Integer.valueOf(i9));
            Log.i("==xpm", "===flag:" + i9);
            RecordingMakeLoverManager.this.g.cU.post(new Runnable() { // from class: com.blued.android.module.live_china.manager.RecordingMakeLoverManager.3.1
                @Override // java.lang.Runnable
                public void run() {
                    RecordingMakeLoverManager.this.g.bk.P.post(new Runnable() { // from class: com.blued.android.module.live_china.manager.RecordingMakeLoverManager.3.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            int[] iArr = new int[2];
                            RecordingMakeLoverManager.this.g.cU.getLocationOnScreen(iArr);
                            int i13 = iArr[1];
                            int[] iArr2 = new int[2];
                            RecordingMakeLoverManager.this.g.bk.P.getLocationOnScreen(iArr2);
                            int height = ((iArr2[1] + RecordingMakeLoverManager.this.g.bk.P.getHeight()) + AppMethods.a(7)) - i13;
                            if (height <= 0) {
                                height = 0;
                            }
                            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) RecordingMakeLoverManager.this.g.bk.P.getLayoutParams();
                            layoutParams.gravity = 5;
                            layoutParams.rightMargin = DensityUtils.a(RecordingMakeLoverManager.this.f, 10.0f);
                            layoutParams.topMargin = ((RecordingMakeLoverManager.b * 2) + DensityUtils.a(RecordingMakeLoverManager.this.f, 10.0f)) - height;
                            RecordingMakeLoverManager.this.g.bk.P.setLayoutParams(layoutParams);
                        }
                    });
                }
            });
        }
    }

    public RecordingMakeLoverManager(RecordingOnliveFragment recordingOnliveFragment) {
        this.g = recordingOnliveFragment;
        this.f = recordingOnliveFragment.getContext();
        int i = AppInfo.l / 3;
        this.h = i;
        b = (int) (i * d);
        f13755c = DensityUtils.a(this.f, 148);
    }

    private NewFuncPopwindow a(View view, int i) {
        NewFuncPopwindow newFuncPopwindow = new NewFuncPopwindow(this.f, (int) (AppInfo.l * 0.453d), -1);
        newFuncPopwindow.a(i);
        newFuncPopwindow.b(DensityUtils.a(this.f, 10.0f));
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        Logger.d("RecordingMakeLoverManager", "x:" + iArr[0] + " ; y:" + iArr[1]);
        HoleRelativeLayout.RoundRect roundRect = new HoleRelativeLayout.RoundRect();
        roundRect.f14305a = (float) iArr[0];
        roundRect.b = (float) iArr[1];
        roundRect.f14306c = (float) view.getWidth();
        roundRect.d = (float) view.getHeight();
        roundRect.i = false;
        newFuncPopwindow.a(roundRect);
        newFuncPopwindow.a(5000L);
        newFuncPopwindow.a(this.g.b, iArr[0], iArr[1]);
        return newFuncPopwindow;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        a(this.g.bk.Q, R.drawable.live_lover_restart).a((NewFuncPopwindow.FuncDismissListener) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        a(this.g.bk.R, R.drawable.live_lover_ok).a(new NewFuncPopwindow.FuncDismissListener() { // from class: com.blued.android.module.live_china.manager.RecordingMakeLoverManager.2
            @Override // com.blued.android.module.live_china.view.NewFuncPopwindow.FuncDismissListener
            public void a() {
                RecordingMakeLoverManager.this.j();
            }
        });
    }

    public void b(List<LiveMakeLoverFansModel> list) {
        if (list != null) {
            a(list);
        }
        h();
    }

    public void d(String str) {
        int b2 = b(str);
        h();
        this.g.bk.a(b2);
    }

    public void f() {
        this.g.d_(8);
        this.g.J.setVisibility(0);
        this.g.cb.setVisibility(8);
        this.g.ac.d();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.setMargins(0, f13755c, 0, 0);
        this.g.bC.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.g.bD.getLayoutParams();
        layoutParams2.width = -1;
        layoutParams2.height = b * 2;
        this.g.bD.setLayoutParams(layoutParams2);
        this.g.L.setLayoutParams(new FrameLayout.LayoutParams(this.h, b));
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(this.h, b);
        layoutParams3.leftMargin = this.h;
        this.g.bQ.setLayoutParams(layoutParams3);
        this.g.bk.b.setLayoutParams(layoutParams3);
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(this.h, b);
        layoutParams4.leftMargin = this.h * 2;
        this.g.bR.setLayoutParams(layoutParams4);
        this.g.bk.f14583c.setLayoutParams(layoutParams4);
        FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(this.h, b);
        layoutParams5.topMargin = b;
        this.g.bS.setLayoutParams(layoutParams5);
        this.g.bk.d.setLayoutParams(layoutParams5);
        FrameLayout.LayoutParams layoutParams6 = new FrameLayout.LayoutParams(this.h, b);
        layoutParams6.topMargin = b;
        layoutParams6.leftMargin = this.h;
        this.g.bT.setLayoutParams(layoutParams6);
        this.g.bk.e.setLayoutParams(layoutParams6);
        FrameLayout.LayoutParams layoutParams7 = new FrameLayout.LayoutParams(this.h, b);
        layoutParams7.topMargin = b;
        layoutParams7.leftMargin = this.h * 2;
        this.g.bU.setLayoutParams(layoutParams7);
        this.g.bk.f.setLayoutParams(layoutParams7);
        FrameLayout.LayoutParams layoutParams8 = (FrameLayout.LayoutParams) this.g.bk.P.getLayoutParams();
        layoutParams8.gravity = 5;
        layoutParams8.rightMargin = DensityUtils.a(this.f, 10.0f);
        layoutParams8.topMargin = (b * 2) + DensityUtils.a(this.f, 10.0f);
        this.g.bk.P.setLayoutParams(layoutParams8);
        i();
        this.g.cw.setVisibility(8);
        this.g.bQ.setVisibility(0);
        this.g.bR.setVisibility(0);
        this.g.bS.setVisibility(0);
        this.g.bT.setVisibility(0);
        this.g.bU.setVisibility(0);
        this.g.bk.f14582a.setVisibility(0);
        this.g.bk.g.setVisibility(0);
        this.g.bk.h.setVisibility(0);
        this.g.bk.i.setVisibility(0);
        this.g.bk.j.setVisibility(0);
        this.g.bk.k.setVisibility(0);
        this.g.bk.l.setVisibility(8);
        this.g.bk.m.setVisibility(8);
        this.g.bk.n.setVisibility(8);
        this.g.bk.o.setVisibility(8);
        this.g.bk.p.setVisibility(8);
        this.g.bk.v.setVisibility(8);
        this.g.bk.w.setVisibility(8);
        this.g.bk.x.setVisibility(8);
        this.g.bk.y.setVisibility(8);
        this.g.bk.z.setVisibility(8);
        this.g.bk.F.setVisibility(8);
        this.g.bk.G.setVisibility(8);
        this.g.bk.H.setVisibility(8);
        this.g.bk.I.setVisibility(8);
        this.g.bk.J.setVisibility(8);
        if (LivePreferencesUtils.d()) {
            return;
        }
        this.g.postDelaySafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.live_china.manager.RecordingMakeLoverManager.1
            @Override // java.lang.Runnable
            public void run() {
                Logger.d("NewFuncPopwindow", "NewFuncPopwindow create ... ");
                LivePreferencesUtils.b(true);
                RecordingMakeLoverManager.this.k();
            }
        }, 500L);
    }

    public void g() {
        this.g.J.setVisibility(0);
    }

    public void h() {
        if (this.f13675a != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.f13675a.size()) {
                    break;
                }
                LiveMakeLoverFansModel liveMakeLoverFansModel = this.f13675a.get(i2);
                if (i2 == 0) {
                    if (liveMakeLoverFansModel.isEmpty()) {
                        this.g.bk.F.setVisibility(8);
                        if (this.g.bk.g.getVisibility() == 8) {
                            this.g.bk.g.setVisibility(0);
                        }
                    } else {
                        this.g.bk.g.setVisibility(8);
                        this.g.bk.F.setVisibility(0);
                    }
                }
                if (i2 == 1) {
                    if (liveMakeLoverFansModel.isEmpty()) {
                        this.g.bk.G.setVisibility(8);
                        if (this.g.bk.h.getVisibility() == 8) {
                            this.g.bk.h.setVisibility(0);
                        }
                    } else {
                        this.g.bk.h.setVisibility(8);
                        this.g.bk.G.setVisibility(0);
                    }
                }
                if (i2 == 2) {
                    if (liveMakeLoverFansModel.isEmpty()) {
                        this.g.bk.H.setVisibility(8);
                        if (this.g.bk.i.getVisibility() == 8) {
                            this.g.bk.i.setVisibility(0);
                        }
                    } else {
                        this.g.bk.i.setVisibility(8);
                        this.g.bk.H.setVisibility(0);
                    }
                }
                if (i2 == 3) {
                    if (liveMakeLoverFansModel.isEmpty()) {
                        this.g.bk.I.setVisibility(8);
                        if (this.g.bk.j.getVisibility() == 8) {
                            this.g.bk.j.setVisibility(0);
                        }
                    } else {
                        this.g.bk.j.setVisibility(8);
                        this.g.bk.I.setVisibility(0);
                    }
                }
                if (i2 == 4) {
                    if (liveMakeLoverFansModel.isEmpty()) {
                        this.g.bk.J.setVisibility(8);
                        if (this.g.bk.k.getVisibility() == 8) {
                            this.g.bk.k.setVisibility(0);
                        }
                    } else {
                        this.g.bk.k.setVisibility(8);
                        this.g.bk.J.setVisibility(0);
                    }
                }
                i = i2 + 1;
            }
        }
        this.g.bk.a();
        this.g.bk.b();
    }

    public void i() {
        RecordingOnliveFragment recordingOnliveFragment = this.g;
        if (recordingOnliveFragment == null || recordingOnliveFragment.cU == null) {
            return;
        }
        this.g.cU.addOnLayoutChangeListener(this.e);
    }
}
