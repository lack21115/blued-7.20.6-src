package com.tencent.liteav.videobase.videobase;

import android.view.View;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videobase/videobase/b.class */
public final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final View f36670a;
    private final int b;

    private b(View view, int i) {
        this.f36670a = view;
        this.b = i;
    }

    public static Runnable a(View view, int i) {
        return new b(view, i);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f36670a.setVisibility(this.b);
    }
}
