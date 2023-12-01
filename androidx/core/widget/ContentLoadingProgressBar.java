package androidx.core.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ProgressBar;

/* loaded from: source-8756600-dex2jar.jar:androidx/core/widget/ContentLoadingProgressBar.class */
public class ContentLoadingProgressBar extends ProgressBar {

    /* renamed from: a  reason: collision with root package name */
    long f2749a;
    boolean b;

    /* renamed from: c  reason: collision with root package name */
    boolean f2750c;
    boolean d;
    private final Runnable e;
    private final Runnable f;

    public ContentLoadingProgressBar(Context context) {
        this(context, null);
    }

    public ContentLoadingProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f2749a = -1L;
        this.b = false;
        this.f2750c = false;
        this.d = false;
        this.e = new Runnable() { // from class: androidx.core.widget.-$$Lambda$ContentLoadingProgressBar$RRZMcqB-4h2-lyW2GeLnU3S6gHA
            @Override // java.lang.Runnable
            public final void run() {
                ContentLoadingProgressBar.this.e();
            }
        };
        this.f = new Runnable() { // from class: androidx.core.widget.-$$Lambda$ContentLoadingProgressBar$xgunBHfnkGzKMlU2_4e3df8PDjo
            @Override // java.lang.Runnable
            public final void run() {
                ContentLoadingProgressBar.this.d();
            }
        };
    }

    private void a() {
        removeCallbacks(this.e);
        removeCallbacks(this.f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        this.d = true;
        removeCallbacks(this.f);
        this.f2750c = false;
        long currentTimeMillis = System.currentTimeMillis();
        long j = this.f2749a;
        long j2 = currentTimeMillis - j;
        if (j2 >= 500 || j == -1) {
            setVisibility(8);
        } else if (this.b) {
        } else {
            postDelayed(this.e, 500 - j2);
            this.b = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        this.f2749a = -1L;
        this.d = false;
        removeCallbacks(this.e);
        this.b = false;
        if (this.f2750c) {
            return;
        }
        postDelayed(this.f, 500L);
        this.f2750c = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d() {
        this.f2750c = false;
        if (this.d) {
            return;
        }
        this.f2749a = System.currentTimeMillis();
        setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e() {
        this.b = false;
        this.f2749a = -1L;
        setVisibility(8);
    }

    public void hide() {
        post(new Runnable() { // from class: androidx.core.widget.-$$Lambda$ContentLoadingProgressBar$5wDgwJ1osr9YIRy1q7Xyeirvkd4
            @Override // java.lang.Runnable
            public final void run() {
                ContentLoadingProgressBar.this.b();
            }
        });
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        a();
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a();
    }

    public void show() {
        post(new Runnable() { // from class: androidx.core.widget.-$$Lambda$ContentLoadingProgressBar$YMGfbggZ28c1CMABX68Yt4GxBik
            @Override // java.lang.Runnable
            public final void run() {
                ContentLoadingProgressBar.this.c();
            }
        });
    }
}
