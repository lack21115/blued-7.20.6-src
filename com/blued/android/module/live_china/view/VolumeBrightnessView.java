package com.blued.android.module.live_china.view;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.live_china.R;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/VolumeBrightnessView.class */
public class VolumeBrightnessView extends FrameLayout {
    public View a;
    public Context b;
    public LayoutInflater c;
    public AudioManager d;
    public DismissWindow e;
    private ImageView f;
    private ProgressBar g;
    private int h;
    private int i;
    private float j;
    private boolean k;
    private int l;
    private int m;
    private int n;

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/VolumeBrightnessView$DismissWindow.class */
    public class DismissWindow implements Runnable {
        public DismissWindow() {
        }

        @Override // java.lang.Runnable
        public void run() {
            VolumeBrightnessView.this.a.setVisibility(8);
        }
    }

    public VolumeBrightnessView(Context context) {
        this(context, null);
    }

    public VolumeBrightnessView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.j = -1.0f;
        this.m = 1;
        this.n = 2;
        this.b = context;
        d();
        c();
    }

    private void c() {
        LayoutInflater from = LayoutInflater.from(this.b);
        this.c = from;
        View inflate = from.inflate(R.layout.live_volume_brightness_layout, this);
        this.a = inflate;
        this.f = (ImageView) inflate.findViewById(R.id.function_icon);
        this.g = (ProgressBar) this.a.findViewById(R.id.function_progress);
    }

    private void d() {
        this.e = new DismissWindow();
        this.d = (AudioManager) this.b.getSystemService("audio");
    }

    public void a() {
        this.k = true;
        this.h = this.d.getStreamMaxVolume(3);
    }

    public void a(Activity activity, MotionEvent motionEvent, float f, float f2) {
        int i;
        float x = motionEvent.getX();
        if (this.k) {
            if (x > AppInfo.m / 2) {
                this.l = this.m;
            } else if (x < AppInfo.m / 2) {
                this.l = this.n;
            }
        }
        int i2 = this.l;
        if (i2 == this.m) {
            this.i = this.d.getStreamVolume(3);
            if (Math.abs(f2) > Math.abs(f)) {
                if (f2 >= DensityUtils.a(this.b, 2.0f)) {
                    int i3 = this.i;
                    if (i3 < this.h) {
                        this.i = i3 + 1;
                    }
                } else if (f2 <= (-DensityUtils.a(this.b, 2.0f)) && (i = this.i) > 0) {
                    this.i = i - 1;
                }
                this.d.setStreamVolume(3, this.i, 0);
                int i4 = (this.i * 100) / this.h;
                this.a.setVisibility(0);
                this.f.setImageResource(R.drawable.live_volume_icon);
                this.g.setProgress(i4);
            }
        } else if (i2 == this.n) {
            if (this.j < 0.0f) {
                float f3 = activity.getWindow().getAttributes().screenBrightness;
                this.j = f3;
                if (f3 <= 0.0f) {
                    this.j = 0.5f;
                }
                if (this.j < 0.01f) {
                    this.j = 0.01f;
                }
            }
            WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
            this.j = attributes.screenBrightness;
            if (Math.abs(f2) > Math.abs(f)) {
                if (f2 >= DensityUtils.a(this.b, 2.0f)) {
                    float f4 = this.j;
                    if (f4 < 1.0f) {
                        this.j = (float) (f4 + 0.05d);
                    }
                } else if (f2 <= (-DensityUtils.a(this.b, 2.0f))) {
                    float f5 = this.j;
                    if (f5 > 0.0f) {
                        this.j = (float) (f5 - 0.05d);
                    }
                }
            }
            attributes.screenBrightness = this.j;
            if (attributes.screenBrightness > 1.0f) {
                attributes.screenBrightness = 1.0f;
            } else if (attributes.screenBrightness < 0.01f) {
                attributes.screenBrightness = 0.01f;
            }
            activity.getWindow().setAttributes(attributes);
            this.a.setVisibility(0);
            this.f.setImageResource(R.drawable.live_brightness_icon);
            this.g.setProgress((int) (attributes.screenBrightness * 100.0f));
        }
        this.k = false;
        b();
    }

    public void b() {
        AppInfo.n().removeCallbacks(this.e);
        AppInfo.n().postDelayed(this.e, 3000L);
    }
}
