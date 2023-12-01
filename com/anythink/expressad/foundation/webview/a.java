package com.anythink.expressad.foundation.webview;

import android.graphics.drawable.Drawable;
import android.view.ViewGroup;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/foundation/webview/a.class */
public interface a {

    /* renamed from: a  reason: collision with root package name */
    public static final int f5152a = 4;
    public static final int b = 5;

    /* renamed from: c  reason: collision with root package name */
    public static final int f5153c = 6;
    public static final int d = 7;
    public static final int e = 8;

    /* renamed from: com.anythink.expressad.foundation.webview.a$a  reason: collision with other inner class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/foundation/webview/a$a.class */
    public interface InterfaceC0078a {
        void a();

        void b();
    }

    Drawable getBackground();

    ViewGroup.LayoutParams getLayoutParams();

    float getProgress();

    int getVisibility();

    void initResource(boolean z);

    void onThemeChange();

    void setBackgroundColor(int i);

    void setBackgroundDrawable(Drawable drawable);

    void setLayoutParams(ViewGroup.LayoutParams layoutParams);

    void setPaused(boolean z);

    void setProgress(float f, boolean z);

    void setProgressBarListener(InterfaceC0078a interfaceC0078a);

    void setProgressState(int i);

    void setVisibility(int i);

    void setVisible(boolean z);

    void startEndAnimation();
}
