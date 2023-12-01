package androidx.core.view.accessibility;

import android.os.Build;
import android.os.Parcelable;
import android.view.View;
import android.view.accessibility.AccessibilityRecord;
import java.util.List;

/* loaded from: source-8756600-dex2jar.jar:androidx/core/view/accessibility/AccessibilityRecordCompat.class */
public class AccessibilityRecordCompat {

    /* renamed from: a  reason: collision with root package name */
    private final AccessibilityRecord f2682a;

    @Deprecated
    public AccessibilityRecordCompat(Object obj) {
        this.f2682a = (AccessibilityRecord) obj;
    }

    public static int getMaxScrollX(AccessibilityRecord accessibilityRecord) {
        if (Build.VERSION.SDK_INT >= 15) {
            return accessibilityRecord.getMaxScrollX();
        }
        return 0;
    }

    public static int getMaxScrollY(AccessibilityRecord accessibilityRecord) {
        if (Build.VERSION.SDK_INT >= 15) {
            return accessibilityRecord.getMaxScrollY();
        }
        return 0;
    }

    @Deprecated
    public static AccessibilityRecordCompat obtain() {
        return new AccessibilityRecordCompat(AccessibilityRecord.obtain());
    }

    @Deprecated
    public static AccessibilityRecordCompat obtain(AccessibilityRecordCompat accessibilityRecordCompat) {
        return new AccessibilityRecordCompat(AccessibilityRecord.obtain(accessibilityRecordCompat.f2682a));
    }

    public static void setMaxScrollX(AccessibilityRecord accessibilityRecord, int i) {
        if (Build.VERSION.SDK_INT >= 15) {
            accessibilityRecord.setMaxScrollX(i);
        }
    }

    public static void setMaxScrollY(AccessibilityRecord accessibilityRecord, int i) {
        if (Build.VERSION.SDK_INT >= 15) {
            accessibilityRecord.setMaxScrollY(i);
        }
    }

    public static void setSource(AccessibilityRecord accessibilityRecord, View view, int i) {
        if (Build.VERSION.SDK_INT >= 16) {
            accessibilityRecord.setSource(view, i);
        }
    }

    @Deprecated
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AccessibilityRecordCompat) {
            AccessibilityRecordCompat accessibilityRecordCompat = (AccessibilityRecordCompat) obj;
            AccessibilityRecord accessibilityRecord = this.f2682a;
            return accessibilityRecord == null ? accessibilityRecordCompat.f2682a == null : accessibilityRecord.equals(accessibilityRecordCompat.f2682a);
        }
        return false;
    }

    @Deprecated
    public int getAddedCount() {
        return this.f2682a.getAddedCount();
    }

    @Deprecated
    public CharSequence getBeforeText() {
        return this.f2682a.getBeforeText();
    }

    @Deprecated
    public CharSequence getClassName() {
        return this.f2682a.getClassName();
    }

    @Deprecated
    public CharSequence getContentDescription() {
        return this.f2682a.getContentDescription();
    }

    @Deprecated
    public int getCurrentItemIndex() {
        return this.f2682a.getCurrentItemIndex();
    }

    @Deprecated
    public int getFromIndex() {
        return this.f2682a.getFromIndex();
    }

    @Deprecated
    public Object getImpl() {
        return this.f2682a;
    }

    @Deprecated
    public int getItemCount() {
        return this.f2682a.getItemCount();
    }

    @Deprecated
    public int getMaxScrollX() {
        return getMaxScrollX(this.f2682a);
    }

    @Deprecated
    public int getMaxScrollY() {
        return getMaxScrollY(this.f2682a);
    }

    @Deprecated
    public Parcelable getParcelableData() {
        return this.f2682a.getParcelableData();
    }

    @Deprecated
    public int getRemovedCount() {
        return this.f2682a.getRemovedCount();
    }

    @Deprecated
    public int getScrollX() {
        return this.f2682a.getScrollX();
    }

    @Deprecated
    public int getScrollY() {
        return this.f2682a.getScrollY();
    }

    @Deprecated
    public AccessibilityNodeInfoCompat getSource() {
        return AccessibilityNodeInfoCompat.wrapNonNullInstance(this.f2682a.getSource());
    }

    @Deprecated
    public List<CharSequence> getText() {
        return this.f2682a.getText();
    }

    @Deprecated
    public int getToIndex() {
        return this.f2682a.getToIndex();
    }

    @Deprecated
    public int getWindowId() {
        return this.f2682a.getWindowId();
    }

    @Deprecated
    public int hashCode() {
        AccessibilityRecord accessibilityRecord = this.f2682a;
        if (accessibilityRecord == null) {
            return 0;
        }
        return accessibilityRecord.hashCode();
    }

    @Deprecated
    public boolean isChecked() {
        return this.f2682a.isChecked();
    }

    @Deprecated
    public boolean isEnabled() {
        return this.f2682a.isEnabled();
    }

    @Deprecated
    public boolean isFullScreen() {
        return this.f2682a.isFullScreen();
    }

    @Deprecated
    public boolean isPassword() {
        return this.f2682a.isPassword();
    }

    @Deprecated
    public boolean isScrollable() {
        return this.f2682a.isScrollable();
    }

    @Deprecated
    public void recycle() {
        this.f2682a.recycle();
    }

    @Deprecated
    public void setAddedCount(int i) {
        this.f2682a.setAddedCount(i);
    }

    @Deprecated
    public void setBeforeText(CharSequence charSequence) {
        this.f2682a.setBeforeText(charSequence);
    }

    @Deprecated
    public void setChecked(boolean z) {
        this.f2682a.setChecked(z);
    }

    @Deprecated
    public void setClassName(CharSequence charSequence) {
        this.f2682a.setClassName(charSequence);
    }

    @Deprecated
    public void setContentDescription(CharSequence charSequence) {
        this.f2682a.setContentDescription(charSequence);
    }

    @Deprecated
    public void setCurrentItemIndex(int i) {
        this.f2682a.setCurrentItemIndex(i);
    }

    @Deprecated
    public void setEnabled(boolean z) {
        this.f2682a.setEnabled(z);
    }

    @Deprecated
    public void setFromIndex(int i) {
        this.f2682a.setFromIndex(i);
    }

    @Deprecated
    public void setFullScreen(boolean z) {
        this.f2682a.setFullScreen(z);
    }

    @Deprecated
    public void setItemCount(int i) {
        this.f2682a.setItemCount(i);
    }

    @Deprecated
    public void setMaxScrollX(int i) {
        setMaxScrollX(this.f2682a, i);
    }

    @Deprecated
    public void setMaxScrollY(int i) {
        setMaxScrollY(this.f2682a, i);
    }

    @Deprecated
    public void setParcelableData(Parcelable parcelable) {
        this.f2682a.setParcelableData(parcelable);
    }

    @Deprecated
    public void setPassword(boolean z) {
        this.f2682a.setPassword(z);
    }

    @Deprecated
    public void setRemovedCount(int i) {
        this.f2682a.setRemovedCount(i);
    }

    @Deprecated
    public void setScrollX(int i) {
        this.f2682a.setScrollX(i);
    }

    @Deprecated
    public void setScrollY(int i) {
        this.f2682a.setScrollY(i);
    }

    @Deprecated
    public void setScrollable(boolean z) {
        this.f2682a.setScrollable(z);
    }

    @Deprecated
    public void setSource(View view) {
        this.f2682a.setSource(view);
    }

    @Deprecated
    public void setSource(View view, int i) {
        setSource(this.f2682a, view, i);
    }

    @Deprecated
    public void setToIndex(int i) {
        this.f2682a.setToIndex(i);
    }
}
