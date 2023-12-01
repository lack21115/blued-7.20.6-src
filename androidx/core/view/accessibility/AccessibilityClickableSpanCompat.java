package androidx.core.view.accessibility;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;

/* loaded from: source-8756600-dex2jar.jar:androidx/core/view/accessibility/AccessibilityClickableSpanCompat.class */
public final class AccessibilityClickableSpanCompat extends ClickableSpan {
    public static final String SPAN_ID = "ACCESSIBILITY_CLICKABLE_SPAN_ID";

    /* renamed from: a  reason: collision with root package name */
    private final int f2670a;
    private final AccessibilityNodeInfoCompat b;

    /* renamed from: c  reason: collision with root package name */
    private final int f2671c;

    public AccessibilityClickableSpanCompat(int i, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, int i2) {
        this.f2670a = i;
        this.b = accessibilityNodeInfoCompat;
        this.f2671c = i2;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putInt(SPAN_ID, this.f2670a);
        this.b.performAction(this.f2671c, bundle);
    }
}
