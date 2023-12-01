package com.blued.android.module.live_china.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.live_china.R;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LivePKProgressView.class */
public class LivePKProgressView extends FrameLayout {
    private Context a;
    private LayoutInflater b;
    private ViewGroup c;
    private ProgressBar d;
    private TextView e;
    private TextView f;
    private int g;
    private int h;
    private boolean i;
    private ImageView j;
    private View k;
    private int l;

    public LivePKProgressView(Context context) {
        this(context, null);
    }

    public LivePKProgressView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LivePKProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.i = false;
        this.a = context;
        c();
    }

    private void c() {
        LayoutInflater from = LayoutInflater.from(this.a);
        this.b = from;
        from.inflate(R.layout.live_pk_progress_view, this);
        this.c = (ViewGroup) findViewById(R.id.content_layout);
        this.d = (ProgressBar) findViewById(R.id.live_pk_progress_view);
        this.e = (TextView) findViewById(R.id.live_pk_our_progress);
        this.f = (TextView) findViewById(R.id.live_pk_other_progress);
        this.k = findViewById(R.id.fl_bar);
        this.j = (ImageView) findViewById(R.id.live_pk_progress_anim);
        this.l = AppInfo.l - DensityUtils.a(this.a, 38.0f);
        b();
        ImageLoader.c(null, "live_pk_progress_anim.png").g(-1).e(this.j.hashCode()).a(this.j);
    }

    private void setAnimMargin(int i) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.k.getLayoutParams();
        int a = DensityUtils.a(this.a, 36.0f);
        layoutParams.leftMargin = (((int) (this.l * (i / 100.0f))) + DensityUtils.a(this.a, 16.0f)) - (a / 2);
        Log.i("==opop", " progress:" + i + "  pkIconwidth:" + a + "  mProgressWidth: " + this.l + "  margin:" + layoutParams.leftMargin);
        this.k.setLayoutParams(layoutParams);
    }

    private void setProgress(int i) {
        this.d.setProgress(i);
        setAnimMargin(i);
    }

    public void a() {
        this.i = true;
        ProgressBar progressBar = this.d;
        if (progressBar != null) {
            progressBar.clearAnimation();
        }
    }

    public void b() {
        Log.i("==xpm", "reset");
        setProgress(50);
        this.g = 0;
        this.h = 0;
        this.e.setText(String.format(this.a.getString(R.string.live_pk_my_result), "0"));
        this.f.setText(String.format(this.a.getString(R.string.live_pk_your_result), "0"));
    }

    public void setOtherProgress(int i) {
        Log.i("==xpm", "setOtherProgress:" + i);
        if (i > this.h) {
            int i2 = this.g;
            if (i2 == 0) {
                setProgress(0);
            } else {
                setProgress((int) ((i2 / (i2 + i)) * 100.0f));
            }
            this.h = i;
            TextView textView = this.f;
            String string = this.a.getString(R.string.live_pk_your_result);
            textView.setText(String.format(string, i + ""));
        }
    }

    public void setOurProgress(int i) {
        Log.i("==xpm", "setOurProgress:" + i);
        if (i > this.g) {
            int i2 = this.h;
            if (i2 == 0) {
                setProgress(100);
            } else {
                setProgress((int) ((i / (i2 + i)) * 100.0f));
            }
            this.g = i;
            TextView textView = this.e;
            String string = this.a.getString(R.string.live_pk_my_result);
            textView.setText(String.format(string, i + ""));
        }
    }
}
