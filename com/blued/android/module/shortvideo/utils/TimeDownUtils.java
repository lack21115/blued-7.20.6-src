package com.blued.android.module.shortvideo.utils;

import android.os.Handler;
import android.widget.TextView;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/utils/TimeDownUtils.class */
public class TimeDownUtils {
    Handler a = new Handler();
    Runnable b = new Runnable() { // from class: com.blued.android.module.shortvideo.utils.TimeDownUtils.1
        @Override // java.lang.Runnable
        public void run() {
            TimeDownUtils.a(TimeDownUtils.this);
            TextView textView = TimeDownUtils.this.d;
            textView.setText(TimeDownUtils.this.c + "");
            if (TimeDownUtils.this.c != 0) {
                TimeDownUtils.this.a.postDelayed(this, 1000L);
                return;
            }
            TimeDownUtils.this.c = 3;
            TimeDownUtils.this.a.removeCallbacks(TimeDownUtils.this.b);
            if (TimeDownUtils.this.e != null) {
                TimeDownUtils.this.e.j();
            }
        }
    };
    private int c;
    private TextView d;
    private ITimeDownCallBack e;

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/utils/TimeDownUtils$ITimeDownCallBack.class */
    public interface ITimeDownCallBack {
        void j();
    }

    public TimeDownUtils(TextView textView, int i, ITimeDownCallBack iTimeDownCallBack) {
        this.c = 3;
        this.d = textView;
        this.c = i;
        this.e = iTimeDownCallBack;
    }

    static /* synthetic */ int a(TimeDownUtils timeDownUtils) {
        int i = timeDownUtils.c;
        timeDownUtils.c = i - 1;
        return i;
    }

    public void a() {
        TextView textView = this.d;
        if (textView != null) {
            textView.setText(this.c + "");
        }
        Handler handler = this.a;
        if (handler != null) {
            handler.postDelayed(this.b, 1000L);
        }
    }

    public void b() {
        Handler handler = this.a;
        if (handler != null) {
            handler.removeCallbacks(this.b);
        }
        this.c = 3;
    }
}
