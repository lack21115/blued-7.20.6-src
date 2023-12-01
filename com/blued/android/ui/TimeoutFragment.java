package com.blued.android.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentActivity;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.Logger;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.framework.view.shape.ShapeModel;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.blued.das.login.LoginAndRegisterProtos;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.log.track.EventTrackLoginAndRegister;
import com.soft.blued.ui.welcome.model.ADClickCoordinate;
import com.soft.blued.ui.welcome.model.SplashEntity;
import in.xiandan.countdowntimer.CountDownTimerSupport;
import in.xiandan.countdowntimer.OnCountDownTimerListener;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/ui/TimeoutFragment.class */
public abstract class TimeoutFragment extends BaseFragment implements SensorEventListener, View.OnTouchListener {
    private TextView A;
    private ViewGroup B;
    private ImageView C;
    private ImageView D;
    private CardView E;
    private TextView F;
    private View G;
    private View H;
    private ImageView I;
    private TextView J;
    private TextView K;
    private View L;
    private ImageView M;
    private TextView N;
    private TextView O;
    private ShapeLinearLayout P;
    private TextView Q;
    private SensorManager R;
    private Sensor S;
    private Sensor T;
    public boolean a;
    public SplashEntity.ShowEntity j;
    private int o;
    private CountDownTimerSupport p;
    private int q;
    private int r;
    private long s;
    private ImageView t;
    private View u;
    private View v;
    private View w;
    private View x;
    private View y;
    private ShapeLinearLayout z;
    private static final String m = TimeoutFragment.class.getName();
    private static int U = 50;
    private int n = 0;
    public ADTimeoutTask b = new ADTimeoutTask();
    public Handler c = new Handler();
    public boolean d = false;
    public boolean e = false;
    public boolean f = false;
    float[] g = new float[3];
    float[] h = new float[3];
    float[] i = new float[3];
    boolean k = false;
    GestureDetector l = new GestureDetector((Context) getActivity(), (GestureDetector.OnGestureListener) new GestureDetector.SimpleOnGestureListener() { // from class: com.blued.android.ui.TimeoutFragment.11
        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            return super.onDoubleTap(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (motionEvent.getY() - motionEvent2.getY() > TimeoutFragment.U && Math.abs(f) > 100.0f) {
                TimeoutFragment.this.b();
                return false;
            } else if (motionEvent2.getY() - motionEvent.getY() > TimeoutFragment.U) {
                Math.abs(f);
                return false;
            } else {
                return false;
            }
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            return super.onSingleTapConfirmed(motionEvent);
        }
    });

    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/ui/TimeoutFragment$ADTimeoutTask.class */
    public class ADTimeoutTask implements Runnable {
        ADTimeoutTask() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Log.v("drb", "开机图广告_请求超时----------->");
            TimeoutFragment.this.a = true;
            EventTrackLoginAndRegister.c(LoginAndRegisterProtos.Event.OPEN_AD_TIMEOUT, TimeoutFragment.this.j);
            TimeoutFragment.this.g();
        }
    }

    private void j() {
        int i = this.n;
        if (i <= 0) {
            return;
        }
        CountDownTimerSupport countDownTimerSupport = this.p;
        if (countDownTimerSupport != null) {
            countDownTimerSupport.c();
            return;
        }
        CountDownTimerSupport countDownTimerSupport2 = new CountDownTimerSupport(i, i);
        this.p = countDownTimerSupport2;
        countDownTimerSupport2.a(new OnCountDownTimerListener() { // from class: com.blued.android.ui.TimeoutFragment.12
            public void a() {
                Log.v("drb", "广告安全时间totalTimeoutMs：" + TimeoutFragment.this.n + "已到，关闭广告页面");
                TimeoutFragment.this.g();
            }

            public void a(long j) {
            }

            public void b() {
            }
        });
        this.p.a();
    }

    private void k() {
        CountDownTimerSupport countDownTimerSupport = this.p;
        if (countDownTimerSupport != null) {
            try {
                countDownTimerSupport.d();
            } catch (Exception e) {
            }
        }
    }

    public void a() {
        a(this.o);
    }

    public void a(int i) {
        this.o = i;
        View h = h();
        if (h != null) {
            this.u = h.findViewById(2131367947);
            this.v = h.findViewById(2131363827);
            this.w = h.findViewById(2131363829);
            this.y = h.findViewById(2131363828);
            this.x = h.findViewById(2131373123);
            this.z = (ShapeLinearLayout) h.findViewById(2131367948);
            this.A = (TextView) h.findViewById(2131361990);
            this.B = (ViewGroup) h.findViewById(2131367949);
            this.C = (ImageView) h.findViewById(2131361978);
            this.D = (ImageView) h.findViewById(2131361976);
            this.E = h.findViewById(2131361977);
            this.F = (TextView) h.findViewById(2131361987);
            this.G = h.findViewById(2131361989);
            this.H = h.findViewById(2131367950);
            this.I = (ImageView) h.findViewById(2131361984);
            this.J = (TextView) h.findViewById(2131361985);
            this.K = (TextView) h.findViewById(2131361986);
            this.L = h.findViewById(2131367951);
            this.M = (ImageView) h.findViewById(2131361979);
            this.N = (TextView) h.findViewById(2131361982);
            this.O = (TextView) h.findViewById(2131361983);
            this.P = (ShapeLinearLayout) h.findViewById(2131361980);
            this.Q = (TextView) h.findViewById(2131361981);
            this.t = (ImageView) h.findViewById(2131365720);
            this.u.setOnTouchListener(new View.OnTouchListener() { // from class: com.blued.android.ui.TimeoutFragment.1
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 0) {
                        EventTrackLoginAndRegister.a(LoginAndRegisterProtos.Event.OPEN_AD_WORD_CLICK);
                        return false;
                    }
                    return false;
                }
            });
            this.v.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.ui.TimeoutFragment.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                }
            });
            this.w.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.ui.TimeoutFragment.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                }
            });
            this.y.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.ui.TimeoutFragment.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                }
            });
            if (i == 0 || i == 1) {
                this.u.setVisibility(8);
                this.v.setVisibility(8);
                this.w.setVisibility(8);
            } else if (i == 2) {
                this.u.setVisibility(0);
                this.v.setVisibility(0);
                this.w.setVisibility(0);
            } else if (i != 3) {
            } else {
                this.u.setVisibility(0);
                this.v.setVisibility(8);
                this.w.setVisibility(8);
            }
        }
    }

    public void a(int i, String str) {
        this.z.setVisibility(0);
        this.B.setVisibility(8);
        this.H.setVisibility(8);
        this.L.setVisibility(8);
        if (TextUtils.isEmpty(str)) {
            this.A.setText(2131891999);
        } else {
            this.A.setText(str);
        }
        ShapeModel shapeModel = new ShapeModel();
        if (i == 50) {
            shapeModel.k = getResources().getColor(2131099827);
        } else {
            shapeModel.k = getResources().getColor(2131099828);
        }
        shapeModel.H = DensityUtils.a(getContext(), 30.0f);
        this.z.setShapeModel(shapeModel);
    }

    public void a(int i, String str, String str2) {
        this.z.setVisibility(8);
        this.B.setVisibility(8);
        this.H.setVisibility(8);
        this.L.setVisibility(0);
        this.P.setVisibility(8);
        ImageLoader.c(getFragmentActive(), "ad_anim_shake.png").g(-1).f().a(this.M);
        if (TextUtils.isEmpty(str)) {
            this.Q.setText(2131891999);
        } else {
            this.Q.setText(str);
        }
        if (TextUtils.isEmpty(str2)) {
            this.O.setText(2131891997);
        } else {
            this.O.setText(str2);
        }
        ShapeModel shapeModel = new ShapeModel();
        if (i == 50) {
            shapeModel.k = getResources().getColor(2131099827);
        } else {
            shapeModel.k = getResources().getColor(2131099828);
        }
        shapeModel.H = DensityUtils.a(getContext(), 30.0f);
        this.P.setShapeModel(shapeModel);
        int i2 = this.o;
        if (i2 != 0 && i2 != 1) {
            if (i2 == 2) {
                this.v.setVisibility(0);
                this.w.setVisibility(0);
                this.y.setVisibility(0);
                this.L.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.ui.TimeoutFragment.9
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Tracker.onClick(view);
                    }
                });
                return;
            } else if (i2 != 3) {
                return;
            }
        }
        this.v.setVisibility(8);
        this.w.setVisibility(8);
        this.y.setVisibility(8);
    }

    public void a(long j) {
        Log.v("drb", "开启广告请求超时任务 :" + j);
        this.c.postDelayed(this.b, j);
    }

    public void a(ADClickCoordinate aDClickCoordinate) {
    }

    public void a(String str) {
        this.z.setVisibility(8);
        this.B.setVisibility(8);
        this.H.setVisibility(0);
        this.L.setVisibility(8);
        this.y.setVisibility(0);
        this.y.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.ui.TimeoutFragment.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
            }
        });
        ImageLoader.c(getFragmentActive(), "ad_anim_slide.png").g(-1).f().a(this.I);
        if (TextUtils.isEmpty(str)) {
            this.K.setText(2131891998);
        } else {
            this.K.setText(str);
        }
        this.H.setOnTouchListener(this);
    }

    public void b() {
    }

    public void b(int i, String str) {
        if (this.k) {
            return;
        }
        this.z.setVisibility(8);
        this.B.setVisibility(0);
        this.H.setVisibility(8);
        this.L.setVisibility(8);
        this.C.setVisibility(0);
        this.D.setVisibility(0);
        if (TextUtils.isEmpty(str)) {
            this.F.setText(2131891999);
        } else {
            this.F.setText(str);
        }
        if (i == 50) {
            this.E.setCardBackgroundColor(getResources().getColor(2131099827));
        } else {
            this.E.setCardBackgroundColor(getResources().getColor(2131099828));
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.C, "translationX", -100.0f, AppInfo.l);
        ofFloat.setDuration(1000L);
        ofFloat.setRepeatCount(-1);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.D, "ScaleX", 1.0f, 1.2f, 1.0f);
        ofFloat2.setDuration(1500L);
        ofFloat2.setRepeatCount(-1);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.D, "ScaleY", 1.0f, 1.2f, 1.0f);
        ofFloat3.setDuration(1500L);
        ofFloat3.setRepeatCount(-1);
        ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.blued.android.ui.TimeoutFragment.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                TimeoutFragment.this.k = true;
            }
        });
        ofFloat2.start();
        ofFloat3.start();
        ofFloat.start();
    }

    public void b(int i, String str, String str2) {
        a(i, str, str2);
        this.P.setVisibility(0);
        final ADClickCoordinate aDClickCoordinate = new ADClickCoordinate();
        this.P.setOnTouchListener(new View.OnTouchListener() { // from class: com.blued.android.ui.TimeoutFragment.10
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    ADClickCoordinate aDClickCoordinate2 = aDClickCoordinate;
                    aDClickCoordinate2.down_x = motionEvent.getX() + "";
                    ADClickCoordinate aDClickCoordinate3 = aDClickCoordinate;
                    aDClickCoordinate3.down_y = motionEvent.getY() + "";
                    return true;
                } else if (action != 1) {
                    return true;
                } else {
                    ADClickCoordinate aDClickCoordinate4 = aDClickCoordinate;
                    aDClickCoordinate4.up_x = motionEvent.getX() + "";
                    ADClickCoordinate aDClickCoordinate5 = aDClickCoordinate;
                    aDClickCoordinate5.up_y = motionEvent.getY() + "";
                    TimeoutFragment.this.a(aDClickCoordinate);
                    return true;
                }
            }
        });
    }

    public void c() {
    }

    public void c(int i, String str) {
        if (this.k) {
            return;
        }
        this.z.setVisibility(8);
        this.B.setVisibility(0);
        this.H.setVisibility(8);
        this.L.setVisibility(8);
        this.D.setVisibility(8);
        this.C.setVisibility(0);
        if (TextUtils.isEmpty(str)) {
            this.F.setText(2131891999);
        } else {
            this.F.setText(str);
        }
        if (i == 50) {
            this.E.setCardBackgroundColor(getResources().getColor(2131099827));
        } else {
            this.E.setCardBackgroundColor(getResources().getColor(2131099828));
        }
        final ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.C, "translationX", -100.0f, AppInfo.l);
        ofFloat.setDuration(1000L);
        final ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.E, "ScaleX", 1.0f, 1.05f, 1.0f);
        ofFloat2.setDuration(500L);
        final ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.E, "ScaleY", 1.0f, 1.05f, 1.0f);
        ofFloat3.setDuration(500L);
        ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.blued.android.ui.TimeoutFragment.6
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                ofFloat2.start();
                ofFloat3.start();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                TimeoutFragment.this.k = true;
            }
        });
        ofFloat2.addListener(new AnimatorListenerAdapter() { // from class: com.blued.android.ui.TimeoutFragment.7
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                ofFloat.start();
            }
        });
        ofFloat.start();
    }

    public void d() {
        CountDownTimerSupport countDownTimerSupport = this.p;
        if (countDownTimerSupport != null) {
            try {
                countDownTimerSupport.b();
            } catch (Exception e) {
            }
        }
    }

    public void e() {
        Log.v("drb", "startADTimeoutTask:" + this.q);
        this.c.postDelayed(this.b, (long) (this.q * 1000));
    }

    public void f() {
        Log.v("drb", "关闭广告请求超时任务");
        this.c.removeCallbacks(this.b);
    }

    protected abstract void g();

    protected abstract View h();

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.n = arguments.getInt("timeout_ms", 0);
            this.q = getArguments().getInt("AD_TIMEOUT");
            this.r = getArguments().getInt("AD_SHOW_TIME");
            this.o = getArguments().getInt("hot_type");
            this.s = getArguments().getLong("AD_ID");
            Log.v("drb", "setHotType:" + this.o + " adTimeout:" + this.q + " ad_id:" + this.s + " totalTimeoutMs:" + this.n);
            if (this.n == 0) {
                if (this.q == 0) {
                    this.q = 4;
                }
                if (this.r == 0) {
                    this.r = 4;
                }
                this.n = (this.q + this.r) * 1000;
            }
        }
        FragmentActivity activity = getActivity();
        getActivity();
        SensorManager sensorManager = (SensorManager) activity.getSystemService("sensor");
        this.R = sensorManager;
        this.S = sensorManager.getDefaultSensor(1);
        this.T = this.R.getDefaultSensor(2);
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public void onDestroy() {
        super.onDestroy();
        k();
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public void onPause() {
        super.onPause();
        d();
        SensorManager sensorManager = this.R;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this, this.S);
            this.R.unregisterListener(this, this.T);
        }
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public void onResume() {
        super.onResume();
        j();
        SensorManager sensorManager = this.R;
        if (sensorManager != null) {
            sensorManager.registerListener(this, this.S, 3);
            this.R.registerListener(this, this.T, 3);
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        SplashEntity.ShowEntity showEntity;
        int type = sensorEvent.sensor.getType();
        float[] fArr = new float[9];
        float[] fArr2 = new float[3];
        if (type == 2) {
            this.g = sensorEvent.values;
        }
        if (type == 1) {
            float f = sensorEvent.values[0];
            float f2 = sensorEvent.values[1];
            float f3 = sensorEvent.values[2];
            double sqrt = Math.sqrt((f * f) + (f2 * f2) + (f3 * f3));
            if (Double.isInfinite(sqrt) || !this.d || (showEntity = this.j) == null || showEntity.triggered) {
                return;
            }
            if (this.j.operating_time == 0.0d && this.j.turn_angle == 0 && this.j.speed == 0) {
                return;
            }
            float[] fArr3 = sensorEvent.values;
            this.h = fArr3;
            SensorManager.getRotationMatrix(fArr, null, fArr3, this.g);
            SensorManager.getOrientation(fArr, fArr2);
            double degrees = Math.toDegrees(fArr2[0]);
            double degrees2 = Math.toDegrees(fArr2[1]);
            double degrees3 = Math.toDegrees(fArr2[2]);
            float[] fArr4 = this.i;
            if (fArr4[0] == 0.0f && fArr4[1] == 0.0f && fArr4[2] == 0.0f) {
                this.i = fArr2;
            }
            double degrees4 = Math.toDegrees(this.i[0]);
            double degrees5 = Math.toDegrees(this.i[1]);
            double degrees6 = Math.toDegrees(this.i[2]);
            int i = this.j.turn_angle;
            double max = Math.max(Math.abs(Math.abs(degrees2) - Math.abs(degrees5)), Math.max(Math.abs(Math.abs(degrees3) - Math.abs(degrees6)), Math.abs(Math.abs(degrees) - Math.abs(degrees4))));
            if (max >= i) {
                this.f = true;
                float[] fArr5 = this.i;
                fArr5[0] = 0.0f;
                fArr5[1] = 0.0f;
                fArr5[2] = 0.0f;
                Logger.c("ljx_shake", "角度详细数据：" + degrees5 + "->" + degrees2 + "," + degrees6 + "->" + degrees3 + "," + degrees4 + "->" + degrees);
                StringBuilder sb = new StringBuilder();
                sb.append("满足角度：");
                sb.append(max);
                sb.append(BridgeUtil.SPLIT_MARK);
                sb.append(this.j.turn_angle);
                sb.append("，此时速度：");
                sb.append(sqrt);
                Logger.c("ljx_shake", sb.toString());
            }
            if (sqrt >= this.j.speed) {
                Logger.c("ljx_shake", "满足速度：" + sqrt + BridgeUtil.SPLIT_MARK + this.j.speed + "，此时角度：" + max);
                this.e = true;
            }
            if (this.e || this.f) {
                c();
                EventTrackLoginAndRegister.a(LoginAndRegisterProtos.Event.AD_OPEN_SHAKE_DONE, sqrt + "", max + "", "");
                Logger.c("ljx_shake", "触发摇一摇:速度=" + sqrt + BridgeUtil.SPLIT_MARK + this.j.speed + "，角度=" + max + BridgeUtil.SPLIT_MARK + this.j.turn_angle);
                this.e = false;
                this.f = false;
                this.j.triggered = true;
            }
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        Log.v("drb", "onTouch");
        return this.l.onTouchEvent(motionEvent);
    }
}
