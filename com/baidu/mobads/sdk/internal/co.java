package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.view.KeyEvent;
import android.widget.RelativeLayout;

/* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/internal/co.class */
public class co extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    public static final String f9389a = "ContainerView";
    private a b;

    /* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/internal/co$a.class */
    public interface a {
        void onAttachedToWindow();

        void onDetachedFromWindow();

        boolean onKeyDown(int i, KeyEvent keyEvent);

        void onLayoutComplete(int i, int i2);

        void onWindowFocusChanged(boolean z);

        void onWindowVisibilityChanged(int i);
    }

    public co(Context context) {
        super(context);
    }

    public void a(a aVar) {
        this.b = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        a aVar = this.b;
        if (aVar != null) {
            aVar.onAttachedToWindow();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a aVar = this.b;
        if (aVar != null) {
            aVar.onDetachedFromWindow();
        }
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        a aVar = this.b;
        if (aVar != null) {
            return aVar.onKeyDown(i, keyEvent);
        }
        super.onKeyDown(i, keyEvent);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        a aVar;
        super.onLayout(z, i, i2, i3, i4);
        if (!z || (aVar = this.b) == null) {
            return;
        }
        aVar.onLayoutComplete(getWidth(), getHeight());
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        a aVar = this.b;
        if (aVar != null) {
            aVar.onWindowFocusChanged(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        a aVar = this.b;
        if (aVar != null) {
            aVar.onWindowVisibilityChanged(i);
        }
    }
}
