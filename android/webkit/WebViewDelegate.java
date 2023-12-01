package android.webkit;

import android.app.ActivityThread;
import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.net.http.ErrorStrings;
import android.os.SystemProperties;
import android.os.Trace;
import android.util.SparseArray;
import android.view.HardwareCanvas;
import android.view.View;
import android.view.ViewRootImpl;

/* loaded from: source-4181928-dex2jar.jar:android/webkit/WebViewDelegate.class */
public final class WebViewDelegate {

    /* loaded from: source-4181928-dex2jar.jar:android/webkit/WebViewDelegate$OnTraceEnabledChangeListener.class */
    public interface OnTraceEnabledChangeListener {
        void onTraceEnabledChange(boolean z);
    }

    public void addWebViewAssetPath(Context context) {
        context.getAssets().addAssetPath(WebViewFactory.getLoadedPackageInfo().applicationInfo.sourceDir);
    }

    public void callDrawGlFunction(Canvas canvas, long j) {
        if (!(canvas instanceof HardwareCanvas)) {
            throw new IllegalArgumentException(canvas.getClass().getName() + " is not hardware accelerated");
        }
        ((HardwareCanvas) canvas).callDrawGLFunction2(j);
    }

    public boolean canInvokeDrawGlFunctor(View view) {
        return view.getViewRootImpl() != null;
    }

    public void detachDrawGlFunctor(View view, long j) {
        ViewRootImpl viewRootImpl = view.getViewRootImpl();
        if (j == 0 || viewRootImpl == null) {
            return;
        }
        viewRootImpl.detachFunctor(j);
    }

    public Application getApplication() {
        return ActivityThread.currentApplication();
    }

    public String getErrorString(Context context, int i) {
        return ErrorStrings.getString(i, context);
    }

    public int getPackageId(Resources resources, String str) {
        SparseArray assignedPackageIdentifiers = resources.getAssets().getAssignedPackageIdentifiers();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= assignedPackageIdentifiers.size()) {
                throw new RuntimeException("Package not found: " + str);
            }
            if (str.equals((String) assignedPackageIdentifiers.valueAt(i2))) {
                return assignedPackageIdentifiers.keyAt(i2);
            }
            i = i2 + 1;
        }
    }

    public void invokeDrawGlFunctor(View view, long j, boolean z) {
        view.getViewRootImpl().invokeFunctor(j, z);
    }

    public boolean isTraceTagEnabled() {
        return Trace.isTagEnabled(16L);
    }

    public void setOnTraceEnabledChangeListener(final OnTraceEnabledChangeListener onTraceEnabledChangeListener) {
        SystemProperties.addChangeCallback(new Runnable() { // from class: android.webkit.WebViewDelegate.1
            @Override // java.lang.Runnable
            public void run() {
                onTraceEnabledChangeListener.onTraceEnabledChange(WebViewDelegate.this.isTraceTagEnabled());
            }
        });
    }
}
