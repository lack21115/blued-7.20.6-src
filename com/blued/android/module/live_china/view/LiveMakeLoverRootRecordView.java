package com.blued.android.module.live_china.view;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.blued.android.core.AppMethods;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.fragment.LiveBaseDialogFragment;
import com.blued.android.module.live_china.fragment.LivePictureFragment;
import com.blued.android.module.live_china.fragment.RecordingOnliveFragment;
import com.blued.android.module.live_china.model.LiveMakeLoverFansModel;
import com.blued.android.module.live_china.same.Logger;
import com.blued.android.module.live_china.same.tip.CommonAlertDialog;
import com.blued.android.module.live_china.utils.LivePreferencesUtils;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.das.live.LiveProtos;
import com.bytedance.applog.tracker.Tracker;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveMakeLoverRootRecordView.class */
public class LiveMakeLoverRootRecordView extends FrameLayout implements View.OnClickListener {
    private static long am;
    public ImageView A;
    public ImageView B;
    public ImageView C;
    public ImageView D;
    public ImageView E;
    public View F;
    public View G;
    public View H;
    public View I;
    public View J;
    public ShapeTextView K;
    public ShapeTextView L;
    public ShapeTextView M;
    public ShapeTextView N;
    public ShapeTextView O;
    public View P;
    public View Q;
    public ImageView R;
    public LiveEventListener S;
    GestureDetector T;
    GestureDetector U;
    GestureDetector V;
    GestureDetector W;
    public View a;
    GestureDetector aa;
    private Context ab;
    private LayoutInflater ac;
    private View ad;
    private View ae;
    private View af;
    private View ag;
    private View ah;
    private boolean ai;
    private int aj;
    private Dialog ak;
    private RecordingOnliveFragment al;
    public View b;
    public View c;
    public View d;
    public View e;
    public View f;
    public View g;
    public View h;
    public View i;
    public View j;
    public View k;
    public View l;
    public View m;
    public View n;
    public View o;
    public View p;
    public View q;
    public View r;
    public View s;
    public View t;
    public View u;
    public ImageView v;
    public ImageView w;
    public ImageView x;
    public ImageView y;
    public ImageView z;

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveMakeLoverRootRecordView$LiveEventListener.class */
    public interface LiveEventListener {
    }

    public LiveMakeLoverRootRecordView(Context context) {
        this(context, null);
    }

    public LiveMakeLoverRootRecordView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LiveMakeLoverRootRecordView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.T = new GestureDetector(this.ab, new GestureDetector.SimpleOnGestureListener() { // from class: com.blued.android.module.live_china.view.LiveMakeLoverRootRecordView.6
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(MotionEvent motionEvent) {
                LiveMakeLoverFansModel a = LiveMakeLoverRootRecordView.this.al.bm.a(0);
                if (a == null || a.isEmpty()) {
                    return super.onSingleTapConfirmed(motionEvent);
                }
                LiveMakeLoverRootRecordView.this.d(0);
                return super.onDoubleTap(motionEvent);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                LiveMakeLoverFansModel a = LiveMakeLoverRootRecordView.this.al.bm.a(0);
                if (a == null || a.isEmpty()) {
                    return super.onSingleTapConfirmed(motionEvent);
                }
                if (!LiveMakeLoverRootRecordView.this.ai) {
                    LiveMakeLoverRootRecordView.this.c(0);
                }
                return super.onSingleTapConfirmed(motionEvent);
            }
        });
        this.U = new GestureDetector(this.ab, new GestureDetector.SimpleOnGestureListener() { // from class: com.blued.android.module.live_china.view.LiveMakeLoverRootRecordView.7
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(MotionEvent motionEvent) {
                LiveMakeLoverFansModel a = LiveMakeLoverRootRecordView.this.al.bm.a(1);
                if (a == null || a.isEmpty()) {
                    return super.onDoubleTap(motionEvent);
                }
                LiveMakeLoverRootRecordView.this.d(1);
                return super.onDoubleTap(motionEvent);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                LiveMakeLoverFansModel a = LiveMakeLoverRootRecordView.this.al.bm.a(1);
                if (a == null || a.isEmpty()) {
                    return super.onSingleTapConfirmed(motionEvent);
                }
                if (!LiveMakeLoverRootRecordView.this.ai) {
                    LiveMakeLoverRootRecordView.this.c(1);
                } else if (a.lamp == 0) {
                    AppMethods.d(R.string.live_make_lover_can_not_match);
                    return super.onSingleTapConfirmed(motionEvent);
                } else {
                    LiveMakeLoverRootRecordView.this.setHeartSelectd(1);
                    LiveMakeLoverRootRecordView.this.b(1);
                }
                return super.onSingleTapConfirmed(motionEvent);
            }
        });
        this.V = new GestureDetector(this.ab, new GestureDetector.SimpleOnGestureListener() { // from class: com.blued.android.module.live_china.view.LiveMakeLoverRootRecordView.8
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(MotionEvent motionEvent) {
                LiveMakeLoverFansModel a = LiveMakeLoverRootRecordView.this.al.bm.a(2);
                if (a == null || a.isEmpty()) {
                    return super.onDoubleTap(motionEvent);
                }
                LiveMakeLoverRootRecordView.this.d(2);
                return super.onDoubleTap(motionEvent);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                LiveMakeLoverFansModel a = LiveMakeLoverRootRecordView.this.al.bm.a(2);
                if (a == null || a.isEmpty()) {
                    return super.onSingleTapConfirmed(motionEvent);
                }
                if (!LiveMakeLoverRootRecordView.this.ai) {
                    LiveMakeLoverRootRecordView.this.c(2);
                } else if (a.lamp == 0) {
                    AppMethods.d(R.string.live_make_lover_can_not_match);
                    return super.onSingleTapConfirmed(motionEvent);
                } else {
                    LiveMakeLoverRootRecordView.this.setHeartSelectd(2);
                    LiveMakeLoverRootRecordView.this.b(2);
                }
                return super.onSingleTapConfirmed(motionEvent);
            }
        });
        this.W = new GestureDetector(this.ab, new GestureDetector.SimpleOnGestureListener() { // from class: com.blued.android.module.live_china.view.LiveMakeLoverRootRecordView.9
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(MotionEvent motionEvent) {
                LiveMakeLoverFansModel a = LiveMakeLoverRootRecordView.this.al.bm.a(3);
                if (a == null || a.isEmpty()) {
                    return super.onDoubleTap(motionEvent);
                }
                LiveMakeLoverRootRecordView.this.d(3);
                return super.onDoubleTap(motionEvent);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                LiveMakeLoverFansModel a = LiveMakeLoverRootRecordView.this.al.bm.a(3);
                if (a == null || a.isEmpty()) {
                    return super.onSingleTapConfirmed(motionEvent);
                }
                if (!LiveMakeLoverRootRecordView.this.ai) {
                    LiveMakeLoverRootRecordView.this.c(3);
                } else if (a.lamp == 0) {
                    AppMethods.d(R.string.live_make_lover_can_not_match);
                    return super.onSingleTapConfirmed(motionEvent);
                } else {
                    LiveMakeLoverRootRecordView.this.setHeartSelectd(3);
                    LiveMakeLoverRootRecordView.this.b(3);
                }
                return super.onSingleTapConfirmed(motionEvent);
            }
        });
        this.aa = new GestureDetector(this.ab, new GestureDetector.SimpleOnGestureListener() { // from class: com.blued.android.module.live_china.view.LiveMakeLoverRootRecordView.10
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(MotionEvent motionEvent) {
                LiveMakeLoverFansModel a = LiveMakeLoverRootRecordView.this.al.bm.a(4);
                if (a == null || a.isEmpty()) {
                    return super.onDoubleTap(motionEvent);
                }
                LiveMakeLoverRootRecordView.this.d(4);
                return super.onDoubleTap(motionEvent);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                LiveMakeLoverFansModel a = LiveMakeLoverRootRecordView.this.al.bm.a(4);
                if (a == null || a.isEmpty()) {
                    return super.onSingleTapConfirmed(motionEvent);
                }
                if (!LiveMakeLoverRootRecordView.this.ai) {
                    LiveMakeLoverRootRecordView.this.c(4);
                } else if (a.lamp == 0) {
                    AppMethods.d(R.string.live_make_lover_can_not_match);
                    return super.onSingleTapConfirmed(motionEvent);
                } else {
                    LiveMakeLoverRootRecordView.this.setHeartSelectd(4);
                    LiveMakeLoverRootRecordView.this.b(4);
                }
                return super.onSingleTapConfirmed(motionEvent);
            }
        });
        this.ab = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final LiveMakeLoverFansModel liveMakeLoverFansModel, String str) {
        LiveRoomHttpUtils.a(liveMakeLoverFansModel.uid, str, new BluedUIHttpResponse(this.al.getFragmentActive()) { // from class: com.blued.android.module.live_china.view.LiveMakeLoverRootRecordView.13
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str2) {
                AppMethods.a((CharSequence) str2);
                return true;
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                super.onUIFinish();
                DialogUtils.b(LiveMakeLoverRootRecordView.this.ak);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
                DialogUtils.a(LiveMakeLoverRootRecordView.this.ak);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity bluedEntity) {
                LiveMakeLoverRootRecordView.this.al.bm.b(liveMakeLoverFansModel.uid);
                LiveMakeLoverRootRecordView.this.al.bm.h();
            }
        });
    }

    private void f() {
        if (this.ai) {
            this.R.setImageResource(R.drawable.live_make_lover_make_gray);
            this.q.setVisibility(0);
            setHeartSelectd(0);
            return;
        }
        if (this.al.bm.e()) {
            this.R.setImageResource(R.drawable.live_make_lover_make_ok);
        } else {
            this.R.setImageResource(R.drawable.live_make_lover_make_gray);
        }
        this.q.setVisibility(8);
        this.r.setVisibility(8);
        this.s.setVisibility(8);
        this.t.setVisibility(8);
        this.u.setVisibility(8);
        this.ad.setVisibility(8);
        this.ae.setVisibility(8);
        this.af.setVisibility(8);
        this.ag.setVisibility(8);
        this.ah.setVisibility(8);
    }

    private void f(int i) {
        if (LivePreferencesUtils.e()) {
            return;
        }
        LivePreferencesUtils.c(true);
        Logger.d("LiveMakeLoverRootRecordView", "position = " + i);
        if (i == 0) {
            this.K.setVisibility(0);
            this.L.setVisibility(8);
            this.M.setVisibility(8);
            this.N.setVisibility(8);
            this.O.setVisibility(8);
        } else if (i == 1) {
            this.K.setVisibility(8);
            this.L.setVisibility(0);
            this.M.setVisibility(8);
            this.N.setVisibility(8);
            this.O.setVisibility(8);
        } else if (i == 2) {
            this.K.setVisibility(8);
            this.L.setVisibility(8);
            this.M.setVisibility(0);
            this.N.setVisibility(8);
            this.O.setVisibility(8);
        } else if (i == 3) {
            this.K.setVisibility(8);
            this.L.setVisibility(8);
            this.M.setVisibility(8);
            this.N.setVisibility(0);
            this.O.setVisibility(8);
        } else if (i != 4) {
            this.K.setVisibility(8);
            this.L.setVisibility(8);
            this.M.setVisibility(8);
            this.N.setVisibility(8);
            this.O.setVisibility(8);
        } else {
            this.K.setVisibility(8);
            this.L.setVisibility(8);
            this.M.setVisibility(8);
            this.N.setVisibility(8);
            this.O.setVisibility(0);
        }
    }

    private void g() {
        this.K.setVisibility(8);
        this.L.setVisibility(8);
        this.M.setVisibility(8);
        this.N.setVisibility(8);
        this.O.setVisibility(8);
    }

    public void a() {
        if (this.al.bm.e()) {
            this.R.setImageResource(R.drawable.live_make_lover_make_ok);
        } else {
            this.R.setImageResource(R.drawable.live_make_lover_make_gray);
        }
        List<LiveMakeLoverFansModel> a = this.al.bm.a();
        if (a == null) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= a.size()) {
                return;
            }
            LiveMakeLoverFansModel liveMakeLoverFansModel = a.get(i2);
            if (i2 == 1) {
                if (liveMakeLoverFansModel == null || liveMakeLoverFansModel.isEmpty()) {
                    this.w.setVisibility(8);
                } else {
                    this.w.setVisibility(0);
                    this.w.setImageResource(liveMakeLoverFansModel.lamp == 1 ? R.drawable.live_make_lover_like_open : R.drawable.live_make_lover_like_disopen);
                }
            } else if (i2 == 2) {
                if (liveMakeLoverFansModel == null || liveMakeLoverFansModel.isEmpty()) {
                    this.x.setVisibility(8);
                } else {
                    this.x.setVisibility(0);
                    this.x.setImageResource(liveMakeLoverFansModel.lamp == 1 ? R.drawable.live_make_lover_like_open : R.drawable.live_make_lover_like_disopen);
                }
            } else if (i2 == 3) {
                if (liveMakeLoverFansModel == null || liveMakeLoverFansModel.isEmpty()) {
                    this.y.setVisibility(8);
                } else {
                    this.y.setVisibility(0);
                    this.y.setImageResource(liveMakeLoverFansModel.lamp == 1 ? R.drawable.live_make_lover_like_open : R.drawable.live_make_lover_like_disopen);
                }
            } else if (i2 == 4) {
                if (liveMakeLoverFansModel == null || liveMakeLoverFansModel.isEmpty()) {
                    this.z.setVisibility(8);
                } else {
                    this.z.setVisibility(0);
                    this.z.setImageResource(liveMakeLoverFansModel.lamp == 1 ? R.drawable.live_make_lover_like_open : R.drawable.live_make_lover_like_disopen);
                }
            }
            i = i2 + 1;
        }
    }

    public void a(int i) {
        if (i == 0 && i + 1 == this.aj) {
            d();
        } else if (i <= 0 || i + 1 != this.aj) {
        } else {
            f();
        }
    }

    public void a(RecordingOnliveFragment recordingOnliveFragment) {
        this.al = recordingOnliveFragment;
        this.ac = LayoutInflater.from(this.ab);
        this.ak = DialogUtils.a(this.ab);
        View inflate = this.ac.inflate(R.layout.live_make_lover_record_view, this);
        this.a = inflate.findViewById(R.id.fl_make_lover_window_root);
        this.b = inflate.findViewById(R.id.live_make_lover_windows_B);
        this.c = inflate.findViewById(R.id.live_make_lover_windows_C);
        this.d = inflate.findViewById(R.id.live_make_lover_windows_D);
        this.e = inflate.findViewById(R.id.live_make_lover_windows_E);
        this.f = inflate.findViewById(R.id.live_make_lover_windows_F);
        this.g = inflate.findViewById(R.id.live_lover_free_B);
        this.h = inflate.findViewById(R.id.live_lover_free_C);
        this.i = inflate.findViewById(R.id.live_lover_free_D);
        this.j = inflate.findViewById(R.id.live_lover_free_E);
        this.k = inflate.findViewById(R.id.live_lover_free_F);
        this.l = inflate.findViewById(R.id.live_lover_mic_B);
        this.m = inflate.findViewById(R.id.live_lover_mic_C);
        this.n = inflate.findViewById(R.id.live_lover_mic_D);
        this.o = inflate.findViewById(R.id.live_lover_mic_E);
        this.p = inflate.findViewById(R.id.live_lover_mic_F);
        this.q = inflate.findViewById(R.id.fl_lover_heart_b);
        this.r = inflate.findViewById(R.id.fl_lover_heart_c);
        this.s = inflate.findViewById(R.id.fl_lover_heart_d);
        this.t = inflate.findViewById(R.id.fl_lover_heart_e);
        this.u = inflate.findViewById(R.id.fl_lover_heart_f);
        this.ad = inflate.findViewById(R.id.fl_lover_heart_gray_b);
        this.ae = inflate.findViewById(R.id.fl_lover_heart_gray_c);
        this.af = inflate.findViewById(R.id.fl_lover_heart_gray_d);
        this.ag = inflate.findViewById(R.id.fl_lover_heart_gray_e);
        this.ah = inflate.findViewById(R.id.fl_lover_heart_gray_f);
        this.v = (ImageView) inflate.findViewById(R.id.iv_like_state_b);
        this.w = (ImageView) inflate.findViewById(R.id.iv_like_state_c);
        this.x = (ImageView) inflate.findViewById(R.id.iv_like_state_d);
        this.y = (ImageView) inflate.findViewById(R.id.iv_like_state_e);
        this.z = (ImageView) inflate.findViewById(R.id.iv_like_state_f);
        this.A = (ImageView) inflate.findViewById(R.id.live_lover_photo_B);
        this.B = (ImageView) inflate.findViewById(R.id.live_lover_photo_C);
        this.C = (ImageView) inflate.findViewById(R.id.live_lover_photo_D);
        this.D = (ImageView) inflate.findViewById(R.id.live_lover_photo_E);
        this.E = (ImageView) inflate.findViewById(R.id.live_lover_photo_F);
        this.F = inflate.findViewById(R.id.live_lover_close_B);
        this.G = inflate.findViewById(R.id.live_lover_close_C);
        this.H = inflate.findViewById(R.id.live_lover_close_D);
        this.I = inflate.findViewById(R.id.live_lover_close_E);
        this.J = inflate.findViewById(R.id.live_lover_close_F);
        this.K = (ShapeTextView) inflate.findViewById(R.id.live_lover_pic_B);
        this.L = (ShapeTextView) inflate.findViewById(R.id.live_lover_pic_C);
        this.M = (ShapeTextView) inflate.findViewById(R.id.live_lover_pic_D);
        this.N = (ShapeTextView) inflate.findViewById(R.id.live_lover_pic_E);
        this.O = (ShapeTextView) inflate.findViewById(R.id.live_lover_pic_F);
        this.P = inflate.findViewById(R.id.fl_make_btn);
        this.Q = inflate.findViewById(R.id.iv_re_start);
        this.R = (ImageView) inflate.findViewById(R.id.iv_make_ok);
        this.Q.setOnClickListener(this);
        this.R.setOnClickListener(this);
        this.F.setOnClickListener(this);
        this.G.setOnClickListener(this);
        this.H.setOnClickListener(this);
        this.I.setOnClickListener(this);
        this.J.setOnClickListener(this);
        this.b.setOnClickListener(this);
        this.c.setOnClickListener(this);
        this.d.setOnClickListener(this);
        this.e.setOnClickListener(this);
        this.f.setOnClickListener(this);
        this.b.setOnTouchListener(new View.OnTouchListener() { // from class: com.blued.android.module.live_china.view.LiveMakeLoverRootRecordView.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return LiveMakeLoverRootRecordView.this.T.onTouchEvent(motionEvent);
            }
        });
        this.c.setOnTouchListener(new View.OnTouchListener() { // from class: com.blued.android.module.live_china.view.LiveMakeLoverRootRecordView.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return LiveMakeLoverRootRecordView.this.U.onTouchEvent(motionEvent);
            }
        });
        this.d.setOnTouchListener(new View.OnTouchListener() { // from class: com.blued.android.module.live_china.view.LiveMakeLoverRootRecordView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return LiveMakeLoverRootRecordView.this.V.onTouchEvent(motionEvent);
            }
        });
        this.e.setOnTouchListener(new View.OnTouchListener() { // from class: com.blued.android.module.live_china.view.LiveMakeLoverRootRecordView.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return LiveMakeLoverRootRecordView.this.W.onTouchEvent(motionEvent);
            }
        });
        this.f.setOnTouchListener(new View.OnTouchListener() { // from class: com.blued.android.module.live_china.view.LiveMakeLoverRootRecordView.5
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return LiveMakeLoverRootRecordView.this.aa.onTouchEvent(motionEvent);
            }
        });
    }

    public void a(String str) {
        this.al.bm.c(str);
        a();
    }

    public void a(String str, String str2) {
        this.al.bm.a(str, str2);
    }

    public void b() {
        if (this.al.bm.e()) {
            this.R.setImageResource(R.drawable.live_make_lover_make_ok);
        } else {
            this.R.setImageResource(R.drawable.live_make_lover_make_gray);
        }
    }

    public void b(int i) {
        LiveMakeLoverFansModel a = this.al.bm.a(0);
        a.index = 1;
        LiveMakeLoverFansModel a2 = this.al.bm.a(i);
        a2.index = i + 1;
        this.al.a(a, a2, "", true);
    }

    public void c() {
        AppMethods.d(R.string.live_make_lover_reset);
        d();
        this.al.bm.b();
        a();
    }

    public void c(int i) {
        LiveMakeLoverFansModel a = this.al.bm.a(i);
        if (a != null) {
            f(i);
            this.al.dd.a(a.uid);
        }
    }

    public void d() {
        this.ai = false;
        f();
    }

    public void d(int i) {
        g();
        LiveMakeLoverFansModel a = this.al.bm.a(i);
        if (a == null) {
            return;
        }
        String str = a.pic;
        String str2 = str;
        if (TextUtils.isEmpty(str)) {
            str2 = a.avatar;
        }
        if (TextUtils.isEmpty(str2)) {
            Log.i("==makelover==", "photo is empty");
            return;
        }
        LivePictureFragment livePictureFragment = new LivePictureFragment();
        livePictureFragment.a(new LiveBaseDialogFragment.IDialogEvent() { // from class: com.blued.android.module.live_china.view.LiveMakeLoverRootRecordView.11
            @Override // com.blued.android.module.live_china.fragment.LiveBaseDialogFragment.IDialogEvent
            public void a() {
                LiveMakeLoverRootRecordView.this.al.t();
            }

            @Override // com.blued.android.module.live_china.fragment.LiveBaseDialogFragment.IDialogEvent
            public void a(Object obj) {
            }
        });
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(str2);
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("picture_url_list", arrayList);
        livePictureFragment.setArguments(bundle);
        livePictureFragment.show(this.al.getFragmentManager(), "see_picture");
    }

    public void e() {
        LiveRoomHttpUtils.w(new BluedUIHttpResponse(this.al.getFragmentActive()) { // from class: com.blued.android.module.live_china.view.LiveMakeLoverRootRecordView.14
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str) {
                AppMethods.a((CharSequence) str);
                return true;
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                super.onUIFinish();
                DialogUtils.b(LiveMakeLoverRootRecordView.this.ak);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
                DialogUtils.a(LiveMakeLoverRootRecordView.this.ak);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity bluedEntity) {
                LiveMakeLoverRootRecordView.this.c();
            }
        });
    }

    public void e(int i) {
        String str = i == 0 ? "0" : "1";
        final LiveMakeLoverFansModel a = this.al.bm.a(i);
        if (a == null) {
            return;
        }
        String format = String.format(this.ab.getString(R.string.live_make_lover_kik_tip), a.name);
        Context context = this.ab;
        final String str2 = str;
        CommonAlertDialog.a(context, "", format, context.getString(R.string.live_make_lover_confirm), new DialogInterface.OnClickListener() { // from class: com.blued.android.module.live_china.view.LiveMakeLoverRootRecordView.12
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                Tracker.onClick(dialogInterface, i2);
                LiveMakeLoverRootRecordView.this.a(a, str2);
            }
        }, (String) null, (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        if (view.getId() == R.id.iv_re_start) {
            EventTrackLive.b(LiveProtos.Event.ANCHOR_RENEW_BTN_CLICK, String.valueOf(this.al.t));
            e();
        } else if (view.getId() == R.id.iv_make_ok) {
            EventTrackLive.b(LiveProtos.Event.ANCHOR_MATCH_SUCCESS_CLICK, String.valueOf(this.al.t));
            if (!this.al.bm.c()) {
                AppMethods.d(R.string.live_make_lover_wait);
            } else if (this.al.bm.e()) {
                this.ai = !this.ai;
                f();
            }
        } else if (view.getId() == R.id.live_lover_close_B) {
            e(0);
        } else if (view.getId() == R.id.live_lover_close_C) {
            e(1);
        } else if (view.getId() == R.id.live_lover_close_D) {
            e(2);
        } else if (view.getId() == R.id.live_lover_close_E) {
            e(3);
        } else if (view.getId() == R.id.live_lover_close_F) {
            e(4);
        }
    }

    public void setHeartSelectd(int i) {
        this.aj = i;
        if (i == 0) {
            this.r.setVisibility(8);
            if (this.h.getVisibility() == 8) {
                this.ae.setVisibility(0);
            }
            this.s.setVisibility(8);
            if (this.i.getVisibility() == 8) {
                this.af.setVisibility(0);
            }
            this.t.setVisibility(8);
            if (this.j.getVisibility() == 8) {
                this.ag.setVisibility(0);
            }
            this.u.setVisibility(8);
            if (this.k.getVisibility() == 8) {
                this.ah.setVisibility(0);
            }
        } else if (i == 1) {
            this.r.setVisibility(0);
            this.ae.setVisibility(8);
            this.s.setVisibility(8);
            if (this.i.getVisibility() == 8) {
                this.af.setVisibility(0);
            }
            this.t.setVisibility(8);
            if (this.j.getVisibility() == 8) {
                this.ag.setVisibility(0);
            }
            this.u.setVisibility(8);
            if (this.k.getVisibility() == 8) {
                this.ah.setVisibility(0);
            }
        } else if (i == 2) {
            this.r.setVisibility(8);
            if (this.h.getVisibility() == 8) {
                this.ae.setVisibility(0);
            }
            this.s.setVisibility(0);
            this.af.setVisibility(8);
            this.t.setVisibility(8);
            if (this.j.getVisibility() == 8) {
                this.ag.setVisibility(0);
            }
            this.u.setVisibility(8);
            if (this.k.getVisibility() == 8) {
                this.ah.setVisibility(0);
            }
        } else if (i == 3) {
            this.r.setVisibility(8);
            if (this.h.getVisibility() == 8) {
                this.ae.setVisibility(0);
            }
            this.s.setVisibility(8);
            if (this.i.getVisibility() == 8) {
                this.af.setVisibility(0);
            }
            this.t.setVisibility(0);
            this.ag.setVisibility(8);
            this.u.setVisibility(8);
            if (this.k.getVisibility() == 8) {
                this.ah.setVisibility(0);
            }
        } else if (i == 4) {
            this.r.setVisibility(8);
            if (this.h.getVisibility() == 8) {
                this.ae.setVisibility(0);
            }
            this.s.setVisibility(8);
            if (this.i.getVisibility() == 8) {
                this.af.setVisibility(0);
            }
            this.t.setVisibility(8);
            if (this.j.getVisibility() == 8) {
                this.ag.setVisibility(0);
            }
            this.u.setVisibility(0);
            this.ah.setVisibility(8);
        }
    }

    public void setLiveEventListener(LiveEventListener liveEventListener) {
        this.S = liveEventListener;
    }
}
