package androidx.appcompat.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* loaded from: source-8756600-dex2jar.jar:androidx/appcompat/widget/TintContextWrapper.class */
public class TintContextWrapper extends ContextWrapper {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f1895a = new Object();
    private static ArrayList<WeakReference<TintContextWrapper>> b;

    /* renamed from: c  reason: collision with root package name */
    private final Resources f1896c;
    private final Resources.Theme d;

    private TintContextWrapper(Context context) {
        super(context);
        if (!VectorEnabledTintResources.shouldBeUsed()) {
            this.f1896c = new TintResources(this, context.getResources());
            this.d = null;
            return;
        }
        VectorEnabledTintResources vectorEnabledTintResources = new VectorEnabledTintResources(this, context.getResources());
        this.f1896c = vectorEnabledTintResources;
        Resources.Theme newTheme = vectorEnabledTintResources.newTheme();
        this.d = newTheme;
        newTheme.setTo(context.getTheme());
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0032, code lost:
        if (androidx.appcompat.widget.VectorEnabledTintResources.shouldBeUsed() != false) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean a(android.content.Context r3) {
        /*
            r0 = r3
            boolean r0 = r0 instanceof androidx.appcompat.widget.TintContextWrapper
            r6 = r0
            r0 = 0
            r5 = r0
            r0 = r5
            r4 = r0
            r0 = r6
            if (r0 != 0) goto L37
            r0 = r5
            r4 = r0
            r0 = r3
            android.content.res.Resources r0 = r0.getResources()
            boolean r0 = r0 instanceof androidx.appcompat.widget.TintResources
            if (r0 != 0) goto L37
            r0 = r3
            android.content.res.Resources r0 = r0.getResources()
            boolean r0 = r0 instanceof androidx.appcompat.widget.VectorEnabledTintResources
            if (r0 == 0) goto L25
            r0 = 0
            return r0
        L25:
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 21
            if (r0 < r1) goto L35
            r0 = r5
            r4 = r0
            boolean r0 = androidx.appcompat.widget.VectorEnabledTintResources.shouldBeUsed()
            if (r0 == 0) goto L37
        L35:
            r0 = 1
            r4 = r0
        L37:
            r0 = r4
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.TintContextWrapper.a(android.content.Context):boolean");
    }

    public static Context wrap(Context context) {
        if (a(context)) {
            synchronized (f1895a) {
                if (b != null) {
                    int size = b.size();
                    while (true) {
                        int i = size - 1;
                        if (i < 0) {
                            break;
                        }
                        WeakReference<TintContextWrapper> weakReference = b.get(i);
                        if (weakReference == null || weakReference.get() == null) {
                            b.remove(i);
                        }
                        size = i;
                    }
                    int size2 = b.size();
                    while (true) {
                        int i2 = size2 - 1;
                        if (i2 < 0) {
                            break;
                        }
                        WeakReference<TintContextWrapper> weakReference2 = b.get(i2);
                        TintContextWrapper tintContextWrapper = weakReference2 != null ? weakReference2.get() : null;
                        if (tintContextWrapper != null && tintContextWrapper.getBaseContext() == context) {
                            return tintContextWrapper;
                        }
                        size2 = i2;
                    }
                } else {
                    b = new ArrayList<>();
                }
                TintContextWrapper tintContextWrapper2 = new TintContextWrapper(context);
                b.add(new WeakReference<>(tintContextWrapper2));
                return tintContextWrapper2;
            }
        }
        return context;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return this.f1896c.getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return this.f1896c;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme theme = this.d;
        Resources.Theme theme2 = theme;
        if (theme == null) {
            theme2 = super.getTheme();
        }
        return theme2;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i) {
        Resources.Theme theme = this.d;
        if (theme == null) {
            super.setTheme(i);
        } else {
            theme.applyStyle(i, true);
        }
    }
}
