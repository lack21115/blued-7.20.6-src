package com.opos.mobad.n.a;

import android.animation.Animator;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.SystemClock;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.heytap.msp.mobad.api.R;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/n/a/p.class */
public class p implements SensorEventListener, f {

    /* renamed from: a  reason: collision with root package name */
    private Context f12853a;
    private RelativeLayout b;

    /* renamed from: c  reason: collision with root package name */
    private ImageView f12854c;
    private TextView d;
    private com.opos.mobad.n.c.g e;
    private Animator f;
    private Animator g;
    private Animator h;
    private com.opos.mobad.n.c.e i;
    private SensorManager j;
    private float n;
    private float o;
    private float p;
    private boolean k = false;
    private int l = 1000;
    private int m = 13000;
    private long q = 0;
    private boolean r = false;

    public p(Context context) {
        this.f12853a = context;
        g();
        this.g = n.d(this.f12854c);
    }

    private void a(SensorEvent sensorEvent) {
        if (this.r || sensorEvent == null || sensorEvent.values == null || sensorEvent.values.length < 3) {
            return;
        }
        if (this.q > 0) {
            if (Math.sqrt(Math.pow(sensorEvent.values[0] - this.n, 2.0d) + Math.pow(sensorEvent.values[1] - this.o, 2.0d) + Math.pow(sensorEvent.values[2] - this.p, 2.0d)) * 1000.0d >= this.m) {
                this.r = true;
                h();
                com.opos.mobad.n.c.g gVar = this.e;
                if (gVar != null) {
                    gVar.a(this.b, null);
                    return;
                }
                return;
            } else if (SystemClock.elapsedRealtime() - this.q < this.l) {
                return;
            }
        }
        b(sensorEvent);
    }

    private void b(SensorEvent sensorEvent) {
        this.n = sensorEvent.values[0];
        this.o = sensorEvent.values[1];
        this.p = sensorEvent.values[2];
        this.q = SystemClock.elapsedRealtime();
    }

    private void g() {
        RelativeLayout relativeLayout = new RelativeLayout(this.f12853a);
        this.b = relativeLayout;
        relativeLayout.setPadding(0, 0, 0, com.opos.cmn.an.h.f.a.a(this.f12853a, 18.0f));
        RelativeLayout relativeLayout2 = new RelativeLayout(this.f12853a);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f12853a, 110.0f), com.opos.cmn.an.h.f.a.a(this.f12853a, 110.0f));
        layoutParams.addRule(14);
        this.b.addView(relativeLayout2, layoutParams);
        relativeLayout2.setId(View.generateViewId());
        ImageView imageView = new ImageView(this.f12853a);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f12853a, 84.0f), com.opos.cmn.an.h.f.a.a(this.f12853a, 84.0f));
        layoutParams2.addRule(13);
        imageView.setBackgroundResource(R.drawable.opos_mobad_bg_cricle_black);
        relativeLayout2.addView(imageView, layoutParams2);
        this.i = new com.opos.mobad.n.c.e(this.f12853a);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f12853a, 110.0f), com.opos.cmn.an.h.f.a.a(this.f12853a, 110.0f));
        layoutParams3.addRule(13);
        this.i.setScaleType(ImageView.ScaleType.FIT_XY);
        this.i.setImageResource(R.drawable.opos_mobad_bg_circle_light);
        this.i.a(com.opos.cmn.an.h.f.a.a(this.f12853a, 28.0f));
        this.i.b(com.opos.cmn.an.h.f.a.a(this.f12853a, 110.0f));
        relativeLayout2.addView(this.i, layoutParams3);
        ImageView imageView2 = new ImageView(this.f12853a);
        this.f12854c = imageView2;
        imageView2.setImageResource(R.drawable.opos_mobad_icon_hand);
        this.f12854c.setScaleType(ImageView.ScaleType.CENTER);
        relativeLayout2.addView(this.f12854c, layoutParams2);
        TextView textView = new TextView(this.f12853a);
        textView.setTextSize(1, 18.0f);
        textView.setText("摇动手机");
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams4.topMargin = com.opos.cmn.an.h.f.a.a(this.f12853a, 12.0f);
        layoutParams4.addRule(14);
        layoutParams4.addRule(3, relativeLayout2.getId());
        textView.setId(View.generateViewId());
        textView.setTextColor(-1);
        this.b.addView(textView, layoutParams4);
        TextView textView2 = new TextView(this.f12853a);
        this.d = textView2;
        textView2.setTextSize(1, 14.0f);
        this.d.setTextColor(-1);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams5.addRule(14);
        layoutParams5.addRule(3, textView.getId());
        this.b.addView(this.d, layoutParams5);
    }

    private void h() {
        SensorManager sensorManager = this.j;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this);
            this.j = null;
        }
        this.p = 0.0f;
        this.o = 0.0f;
        this.n = 0.0f;
        this.q = 0L;
    }

    private void i() {
        if (this.j != null) {
            return;
        }
        SensorManager sensorManager = (SensorManager) this.f12853a.getSystemService("sensor");
        this.j = sensorManager;
        Sensor defaultSensor = sensorManager.getDefaultSensor(1);
        if (defaultSensor != null) {
            this.j.registerListener(this, defaultSensor, 1);
        }
    }

    @Override // com.opos.mobad.n.a.f
    public View a() {
        return this.b;
    }

    @Override // com.opos.mobad.n.a.f
    public void a(com.opos.mobad.n.c.g gVar) {
        this.e = gVar;
    }

    @Override // com.opos.mobad.n.a.f
    public void a(String str, int i, int i2) {
        this.d.setText(str);
        if (i > 0) {
            this.l = i;
        }
        if (i2 > 0) {
            this.m = i2;
        }
    }

    @Override // com.opos.mobad.n.a.f
    public void b() {
        if (Build.VERSION.SDK_INT < 21) {
            return;
        }
        if (this.h == null) {
            this.h = n.b(this.i);
        }
        this.h.start();
    }

    @Override // com.opos.mobad.n.a.f
    public void c() {
        if (Build.VERSION.SDK_INT >= 21 && !this.k) {
            this.k = true;
            Animator b = n.b(this.b);
            this.f = b;
            b.addListener(new Animator.AnimatorListener() { // from class: com.opos.mobad.n.a.p.1
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    p.this.g.start();
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }
            });
            this.f.start();
            i();
        }
    }

    @Override // com.opos.mobad.n.a.f
    public void d() {
        h();
    }

    @Override // com.opos.mobad.n.a.f
    public void e() {
        i();
    }

    @Override // com.opos.mobad.n.a.f
    public void f() {
        Animator animator = this.h;
        if (animator != null) {
            animator.end();
        }
        Animator animator2 = this.f;
        if (animator2 != null) {
            animator2.end();
        }
        Animator animator3 = this.g;
        if (animator3 != null) {
            animator3.end();
        }
        h();
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        a(sensorEvent);
    }
}
