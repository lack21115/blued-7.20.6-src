package com.tencent.rtmp.ui;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/rtmp/ui/DashBoard.class */
public class DashBoard extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    final StringBuilder f24990a;
    TextView b;

    /* renamed from: c  reason: collision with root package name */
    TextView f24991c;
    private final SimpleDateFormat d;
    private ScrollView e;
    private int f;
    private boolean g;

    public DashBoard(Context context) {
        this(context, null);
    }

    public DashBoard(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f24990a = new StringBuilder();
        this.d = new SimpleDateFormat("HH:mm:ss.SSS", Locale.ENGLISH);
        this.f = 3000;
        this.g = false;
        setOrientation(1);
        setVisibility(8);
    }

    private void a() {
        if (this.b != null) {
            return;
        }
        this.b = new TextView(getContext());
        this.f24991c = new TextView(getContext());
        this.e = new ScrollView(getContext());
        this.b.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.b.setTextColor(-49023);
        this.b.setTypeface(Typeface.MONOSPACE);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        this.e.setPadding(0, 10, 0, 0);
        this.e.setLayoutParams(layoutParams);
        this.e.setVerticalScrollBarEnabled(true);
        this.e.setScrollbarFadingEnabled(true);
        this.f24991c.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.f24991c.setTextColor(-49023);
        this.e.addView(this.f24991c);
        addView(this.b);
        addView(this.e);
        if (this.f24990a.length() <= 0) {
            this.f24990a.append("liteav sdk version:\n");
        }
        this.f24991c.setText(this.f24990a.toString());
    }

    public final void a(int i, int i2, int i3, int i4) {
        TextView textView = this.b;
        if (textView != null) {
            textView.setPadding(i, i2, i3, 0);
        }
        ScrollView scrollView = this.e;
        if (scrollView != null) {
            scrollView.setPadding(i, 0, i3, i4);
        }
    }

    public void setEventTextSize(float f) {
        TextView textView = this.f24991c;
        if (textView != null) {
            textView.setTextSize(f);
        }
    }

    public void setMessageMaxLength(int i) {
        this.f = i;
    }

    public void setShowLevel(int i) {
        if (i == 0) {
            TextView textView = this.b;
            if (textView != null) {
                textView.setVisibility(4);
            }
            ScrollView scrollView = this.e;
            if (scrollView != null) {
                scrollView.setVisibility(4);
            }
            setVisibility(4);
        } else if (i != 1) {
            a();
            this.b.setVisibility(0);
            this.e.setVisibility(0);
            setVisibility(0);
        } else {
            a();
            this.b.setVisibility(0);
            this.e.setVisibility(4);
            setVisibility(0);
        }
    }

    public void setStatusText(CharSequence charSequence) {
        TextView textView = this.b;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public void setStatusTextSize(float f) {
        TextView textView = this.b;
        if (textView != null) {
            textView.setTextSize(f);
        }
    }
}
