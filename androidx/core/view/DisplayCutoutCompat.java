package androidx.core.view;

import android.graphics.Rect;
import android.os.Build;
import android.view.DisplayCutout;
import androidx.core.graphics.Insets;
import androidx.core.os.BuildCompat;
import androidx.core.util.ObjectsCompat;
import com.alipay.sdk.util.i;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: source-8756600-dex2jar.jar:androidx/core/view/DisplayCutoutCompat.class */
public final class DisplayCutoutCompat {

    /* renamed from: a  reason: collision with root package name */
    private final Object f2628a;

    public DisplayCutoutCompat(Rect rect, List<Rect> list) {
        this(Build.VERSION.SDK_INT >= 28 ? new DisplayCutout(rect, list) : null);
    }

    public DisplayCutoutCompat(Insets insets, Rect rect, Rect rect2, Rect rect3, Rect rect4, Insets insets2) {
        this(a(insets, rect, rect2, rect3, rect4, insets2));
    }

    private DisplayCutoutCompat(Object obj) {
        this.f2628a = obj;
    }

    private static DisplayCutout a(Insets insets, Rect rect, Rect rect2, Rect rect3, Rect rect4, Insets insets2) {
        if (BuildCompat.isAtLeastR()) {
            return new DisplayCutout(insets.toPlatformInsets(), rect, rect2, rect3, rect4, insets2.toPlatformInsets());
        }
        if (Build.VERSION.SDK_INT >= 29) {
            return new DisplayCutout(insets.toPlatformInsets(), rect, rect2, rect3, rect4);
        }
        if (Build.VERSION.SDK_INT >= 28) {
            Rect rect5 = new Rect(insets.left, insets.top, insets.right, insets.bottom);
            ArrayList arrayList = new ArrayList();
            if (rect != null) {
                arrayList.add(rect);
            }
            if (rect2 != null) {
                arrayList.add(rect2);
            }
            if (rect3 != null) {
                arrayList.add(rect3);
            }
            if (rect4 != null) {
                arrayList.add(rect4);
            }
            return new DisplayCutout(rect5, arrayList);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static DisplayCutoutCompat a(Object obj) {
        if (obj == null) {
            return null;
        }
        return new DisplayCutoutCompat(obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DisplayCutout a() {
        return (DisplayCutout) this.f2628a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return ObjectsCompat.equals(this.f2628a, ((DisplayCutoutCompat) obj).f2628a);
    }

    public List<Rect> getBoundingRects() {
        return Build.VERSION.SDK_INT >= 28 ? ((DisplayCutout) this.f2628a).getBoundingRects() : Collections.emptyList();
    }

    public int getSafeInsetBottom() {
        if (Build.VERSION.SDK_INT >= 28) {
            return ((DisplayCutout) this.f2628a).getSafeInsetBottom();
        }
        return 0;
    }

    public int getSafeInsetLeft() {
        if (Build.VERSION.SDK_INT >= 28) {
            return ((DisplayCutout) this.f2628a).getSafeInsetLeft();
        }
        return 0;
    }

    public int getSafeInsetRight() {
        if (Build.VERSION.SDK_INT >= 28) {
            return ((DisplayCutout) this.f2628a).getSafeInsetRight();
        }
        return 0;
    }

    public int getSafeInsetTop() {
        if (Build.VERSION.SDK_INT >= 28) {
            return ((DisplayCutout) this.f2628a).getSafeInsetTop();
        }
        return 0;
    }

    public Insets getWaterfallInsets() {
        return BuildCompat.isAtLeastR() ? Insets.toCompatInsets(((DisplayCutout) this.f2628a).getWaterfallInsets()) : Insets.NONE;
    }

    public int hashCode() {
        Object obj = this.f2628a;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public String toString() {
        return "DisplayCutoutCompat{" + this.f2628a + i.d;
    }
}
