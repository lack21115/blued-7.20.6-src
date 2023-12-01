package com.blued.android.module.shortvideo.utils;

import android.os.Handler;
import android.widget.TextView;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/utils/TimeDownUtils.class */
public class TimeDownUtils {

    /* renamed from: a  reason: collision with root package name */
    Handler f15871a = new Handler();
    Runnable b = new Runnable() { // from class: com.blued.android.module.shortvideo.utils.TimeDownUtils.1
        @Override // java.lang.Runnable
        public void run() {
            TimeDownUtils.a(TimeDownUtils.this);
            TextView textView = TimeDownUtils.this.d;
            textView.setText(TimeDownUtils.this.f15872c + "");
            if (TimeDownUtils.this.f15872c != 0) {
                TimeDownUtils.this.f15871a.postDelayed(this, 1000L);
                return;
            }
            TimeDownUtils.this.f15872c = 3;
            TimeDownUtils.this.f15871a.removeCallbacks(TimeDownUtils.this.b);
            if (TimeDownUtils.this.e != null) {
                TimeDownUtils.this.e.j();
            }
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private int f15872c;
    private TextView d;
    private ITimeDownCallBack e;

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/utils/TimeDownUtils$ITimeDownCallBack.class */
    public interface ITimeDownCallBack {
        void j();
    }

    public TimeDownUtils(TextView textView, int i, ITimeDownCallBack iTimeDownCallBack) {
        this.f15872c = 3;
        this.d = textView;
        this.f15872c = i;
        this.e = iTimeDownCallBack;
    }

    static /* synthetic */ int a(TimeDownUtils timeDownUtils) {
        int i = timeDownUtils.f15872c;
        timeDownUtils.f15872c = i - 1;
        return i;
    }

    public void a() {
        TextView textView = this.d;
        if (textView != null) {
            textView.setText(this.f15872c + "");
        }
        Handler handler = this.f15871a;
        if (handler != null) {
            handler.postDelayed(this.b, 1000L);
        }
    }

    public void b() {
        Handler handler = this.f15871a;
        if (handler != null) {
            handler.removeCallbacks(this.b);
        }
        this.f15872c = 3;
    }
}
