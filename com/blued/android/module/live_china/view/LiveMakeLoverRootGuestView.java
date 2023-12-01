package com.blued.android.module.live_china.view;

import android.app.Dialog;
import android.content.Context;
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
import com.blued.android.module.live_china.fragment.PlayingOnliveFragment;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.model.LiveMakeLoverFansModel;
import com.blued.android.module.live_china.observer.LiveSetDataObserver;
import com.blued.android.module.live_china.utils.LivePreferencesUtils;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.bytedance.applog.tracker.Tracker;
import java.util.List;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveMakeLoverRootGuestView.class */
public class LiveMakeLoverRootGuestView extends FrameLayout implements View.OnClickListener {
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
    public LiveEventListener P;
    GestureDetector Q;
    GestureDetector R;
    GestureDetector S;
    GestureDetector T;
    GestureDetector U;
    private Context V;
    private LayoutInflater W;
    public View a;
    private View aa;
    private View ab;
    private View ac;
    private View ad;
    private View ae;
    private Dialog af;
    private PlayingOnliveFragment ag;
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

    /* renamed from: com.blued.android.module.live_china.view.LiveMakeLoverRootGuestView$11  reason: invalid class name */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveMakeLoverRootGuestView$11.class */
    class AnonymousClass11 extends BluedUIHttpResponse {
        final /* synthetic */ LiveMakeLoverRootGuestView a;

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public boolean onUIFailure(int i, String str) {
            AppMethods.a((CharSequence) str);
            return true;
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public void onUIFinish() {
            super.onUIFinish();
            DialogUtils.b(this.a.af);
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public void onUIStart() {
            super.onUIStart();
            DialogUtils.a(this.a.af);
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public void onUIUpdate(BluedEntity bluedEntity) {
            this.a.ag.bY.b(LiveRoomInfo.a().f());
            this.a.ag.bY.h();
        }
    }

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveMakeLoverRootGuestView$LiveEventListener.class */
    public interface LiveEventListener {
    }

    public LiveMakeLoverRootGuestView(Context context) {
        this(context, null);
    }

    public LiveMakeLoverRootGuestView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LiveMakeLoverRootGuestView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Q = new GestureDetector(this.V, new GestureDetector.SimpleOnGestureListener() { // from class: com.blued.android.module.live_china.view.LiveMakeLoverRootGuestView.6
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(MotionEvent motionEvent) {
                Log.i("ldp", "onDoubleTap");
                return super.onDoubleTap(motionEvent);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                Log.i("ldp", "onSingleTapConfirmed");
                return super.onSingleTapConfirmed(motionEvent);
            }
        });
        this.R = new GestureDetector(this.V, new GestureDetector.SimpleOnGestureListener() { // from class: com.blued.android.module.live_china.view.LiveMakeLoverRootGuestView.7
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(MotionEvent motionEvent) {
                return super.onDoubleTap(motionEvent);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                return super.onSingleTapConfirmed(motionEvent);
            }
        });
        this.S = new GestureDetector(this.V, new GestureDetector.SimpleOnGestureListener() { // from class: com.blued.android.module.live_china.view.LiveMakeLoverRootGuestView.8
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(MotionEvent motionEvent) {
                return super.onDoubleTap(motionEvent);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                return super.onSingleTapConfirmed(motionEvent);
            }
        });
        this.T = new GestureDetector(this.V, new GestureDetector.SimpleOnGestureListener() { // from class: com.blued.android.module.live_china.view.LiveMakeLoverRootGuestView.9
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(MotionEvent motionEvent) {
                return super.onDoubleTap(motionEvent);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                return super.onSingleTapConfirmed(motionEvent);
            }
        });
        this.U = new GestureDetector(this.V, new GestureDetector.SimpleOnGestureListener() { // from class: com.blued.android.module.live_china.view.LiveMakeLoverRootGuestView.10
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(MotionEvent motionEvent) {
                return super.onDoubleTap(motionEvent);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                return super.onSingleTapConfirmed(motionEvent);
            }
        });
        this.V = context;
    }

    public void a() {
        List<LiveMakeLoverFansModel> a = this.ag.bY.a();
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
            Log.i("==makelover==", i2 + "  setLoverLightStatus:" + liveMakeLoverFansModel.lamp + "  :" + liveMakeLoverFansModel.uid);
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
        if (LivePreferencesUtils.e()) {
            return;
        }
        LivePreferencesUtils.c(true);
        Log.i("==makelover==", "position:" + i);
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

    public void a(PlayingOnliveFragment playingOnliveFragment) {
        this.ag = playingOnliveFragment;
        this.W = LayoutInflater.from(this.V);
        this.af = DialogUtils.a(this.V);
        View inflate = this.W.inflate(R.layout.live_make_lover_guest_view, this);
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
        this.aa = inflate.findViewById(R.id.fl_lover_heart_gray_b);
        this.ab = inflate.findViewById(R.id.fl_lover_heart_gray_c);
        this.ac = inflate.findViewById(R.id.fl_lover_heart_gray_d);
        this.ad = inflate.findViewById(R.id.fl_lover_heart_gray_e);
        this.ae = inflate.findViewById(R.id.fl_lover_heart_gray_f);
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
        this.b.setOnTouchListener(new View.OnTouchListener() { // from class: com.blued.android.module.live_china.view.LiveMakeLoverRootGuestView.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return LiveMakeLoverRootGuestView.this.Q.onTouchEvent(motionEvent);
            }
        });
        this.c.setOnTouchListener(new View.OnTouchListener() { // from class: com.blued.android.module.live_china.view.LiveMakeLoverRootGuestView.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return LiveMakeLoverRootGuestView.this.R.onTouchEvent(motionEvent);
            }
        });
        this.d.setOnTouchListener(new View.OnTouchListener() { // from class: com.blued.android.module.live_china.view.LiveMakeLoverRootGuestView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return LiveMakeLoverRootGuestView.this.S.onTouchEvent(motionEvent);
            }
        });
        this.e.setOnTouchListener(new View.OnTouchListener() { // from class: com.blued.android.module.live_china.view.LiveMakeLoverRootGuestView.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return LiveMakeLoverRootGuestView.this.T.onTouchEvent(motionEvent);
            }
        });
        this.f.setOnTouchListener(new View.OnTouchListener() { // from class: com.blued.android.module.live_china.view.LiveMakeLoverRootGuestView.5
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return LiveMakeLoverRootGuestView.this.U.onTouchEvent(motionEvent);
            }
        });
    }

    public void a(String str) {
        this.ag.bY.c(str);
        a();
    }

    public void a(final String str, final String str2) {
        LiveRoomHttpUtils.b(str, String.valueOf(this.ag.t), new BluedUIHttpResponse(this.ag.getFragmentActive()) { // from class: com.blued.android.module.live_china.view.LiveMakeLoverRootGuestView.13
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str3) {
                AppMethods.a((CharSequence) str3);
                return true;
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                super.onUIFinish();
                DialogUtils.b(LiveMakeLoverRootGuestView.this.af);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
                DialogUtils.a(LiveMakeLoverRootGuestView.this.af);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity bluedEntity) {
                LiveMakeLoverRootGuestView.this.a(LiveRoomInfo.a().f(), str, str2);
            }
        });
    }

    public void a(String str, String str2, String str3) {
        this.ag.bY.a(str, str2, str3);
    }

    public void b() {
        if (this.ag.aD()) {
            LiveSetDataObserver.a().a(false, false);
        }
        AppMethods.d(R.string.live_make_lover_reset);
        this.ag.bY.b();
        a();
    }

    public void c() {
        this.K.setVisibility(8);
        this.L.setVisibility(8);
        this.M.setVisibility(8);
        this.N.setVisibility(8);
        this.O.setVisibility(8);
    }

    public void d() {
        if (this.ag.bY.c()) {
            LiveRoomHttpUtils.d(String.valueOf(this.ag.t), new BluedUIHttpResponse(this.ag.getFragmentActive()) { // from class: com.blued.android.module.live_china.view.LiveMakeLoverRootGuestView.12
                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                public boolean onUIFailure(int i, String str) {
                    AppMethods.a((CharSequence) str);
                    return true;
                }

                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                public void onUIFinish() {
                    super.onUIFinish();
                    DialogUtils.b(LiveMakeLoverRootGuestView.this.af);
                }

                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                public void onUIStart() {
                    super.onUIStart();
                    DialogUtils.a(LiveMakeLoverRootGuestView.this.af);
                }

                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                public void onUIUpdate(BluedEntity bluedEntity) {
                    LiveMakeLoverRootGuestView.this.a(LiveRoomInfo.a().f());
                    LiveSetDataObserver.a().a(true, false);
                    LiveSetDataObserver.a().c(LiveMakeLoverRootGuestView.this.getResources().getString(R.string.live_make_lover_light_gray));
                }
            });
        } else {
            AppMethods.d(R.string.live_make_lover_wait);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        if (view.getId() == R.id.live_lover_close_B) {
            Log.i("ldp", "live_lover_close_B");
        } else if (view.getId() == R.id.live_lover_close_C || view.getId() == R.id.live_lover_close_D || view.getId() == R.id.live_lover_close_E) {
        } else {
            view.getId();
            int i = R.id.live_lover_close_F;
        }
    }

    public void setLiveEventListener(LiveEventListener liveEventListener) {
        this.P = liveEventListener;
    }
}
