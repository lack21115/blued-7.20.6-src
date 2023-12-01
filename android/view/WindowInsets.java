package android.view;

import android.graphics.Rect;
import com.alipay.sdk.util.i;

/* loaded from: source-4181928-dex2jar.jar:android/view/WindowInsets.class */
public final class WindowInsets {
    private boolean mIsRound;
    private Rect mStableInsets;
    private boolean mStableInsetsConsumed;
    private Rect mSystemWindowInsets;
    private boolean mSystemWindowInsetsConsumed;
    private Rect mTempRect;
    private Rect mWindowDecorInsets;
    private boolean mWindowDecorInsetsConsumed;
    private static final Rect EMPTY_RECT = new Rect(0, 0, 0, 0);
    public static final WindowInsets CONSUMED = new WindowInsets(null, null, null, false);

    public WindowInsets(Rect rect) {
        this(rect, null, null, false);
    }

    public WindowInsets(Rect rect, Rect rect2, Rect rect3, boolean z) {
        this.mSystemWindowInsetsConsumed = false;
        this.mWindowDecorInsetsConsumed = false;
        this.mStableInsetsConsumed = false;
        this.mSystemWindowInsetsConsumed = rect == null;
        this.mSystemWindowInsets = this.mSystemWindowInsetsConsumed ? EMPTY_RECT : rect;
        this.mWindowDecorInsetsConsumed = rect2 == null;
        this.mWindowDecorInsets = this.mWindowDecorInsetsConsumed ? EMPTY_RECT : rect2;
        this.mStableInsetsConsumed = rect3 == null;
        this.mStableInsets = this.mStableInsetsConsumed ? EMPTY_RECT : rect3;
        this.mIsRound = z;
    }

    public WindowInsets(WindowInsets windowInsets) {
        this.mSystemWindowInsetsConsumed = false;
        this.mWindowDecorInsetsConsumed = false;
        this.mStableInsetsConsumed = false;
        this.mSystemWindowInsets = windowInsets.mSystemWindowInsets;
        this.mWindowDecorInsets = windowInsets.mWindowDecorInsets;
        this.mStableInsets = windowInsets.mStableInsets;
        this.mSystemWindowInsetsConsumed = windowInsets.mSystemWindowInsetsConsumed;
        this.mWindowDecorInsetsConsumed = windowInsets.mWindowDecorInsetsConsumed;
        this.mStableInsetsConsumed = windowInsets.mStableInsetsConsumed;
        this.mIsRound = windowInsets.mIsRound;
    }

    public WindowInsets consumeStableInsets() {
        WindowInsets windowInsets = new WindowInsets(this);
        windowInsets.mStableInsets = EMPTY_RECT;
        windowInsets.mStableInsetsConsumed = true;
        return windowInsets;
    }

    public WindowInsets consumeSystemWindowInsets() {
        WindowInsets windowInsets = new WindowInsets(this);
        windowInsets.mSystemWindowInsets = EMPTY_RECT;
        windowInsets.mSystemWindowInsetsConsumed = true;
        return windowInsets;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0014, code lost:
        if (r12 != false) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.view.WindowInsets consumeSystemWindowInsets(boolean r9, boolean r10, boolean r11, boolean r12) {
        /*
            r8 = this;
            r0 = 0
            r16 = r0
            r0 = r9
            if (r0 != 0) goto L17
            r0 = r10
            if (r0 != 0) goto L17
            r0 = r11
            if (r0 != 0) goto L17
            r0 = r8
            r17 = r0
            r0 = r12
            if (r0 == 0) goto L4f
        L17:
            android.view.WindowInsets r0 = new android.view.WindowInsets
            r1 = r0
            r2 = r8
            r1.<init>(r2)
            r17 = r0
            r0 = r9
            if (r0 == 0) goto L52
            r0 = 0
            r13 = r0
        L28:
            r0 = r10
            if (r0 == 0) goto L5e
            r0 = 0
            r14 = r0
        L2f:
            r0 = r11
            if (r0 == 0) goto L6a
            r0 = 0
            r15 = r0
        L36:
            r0 = r12
            if (r0 == 0) goto L76
        L3b:
            r0 = r17
            android.graphics.Rect r1 = new android.graphics.Rect
            r2 = r1
            r3 = r13
            r4 = r14
            r5 = r15
            r6 = r16
            r2.<init>(r3, r4, r5, r6)
            r0.mSystemWindowInsets = r1
        L4f:
            r0 = r17
            return r0
        L52:
            r0 = r8
            android.graphics.Rect r0 = r0.mSystemWindowInsets
            int r0 = r0.left
            r13 = r0
            goto L28
        L5e:
            r0 = r8
            android.graphics.Rect r0 = r0.mSystemWindowInsets
            int r0 = r0.top
            r14 = r0
            goto L2f
        L6a:
            r0 = r8
            android.graphics.Rect r0 = r0.mSystemWindowInsets
            int r0 = r0.right
            r15 = r0
            goto L36
        L76:
            r0 = r8
            android.graphics.Rect r0 = r0.mSystemWindowInsets
            int r0 = r0.bottom
            r16 = r0
            goto L3b
        */
        throw new UnsupportedOperationException("Method not decompiled: android.view.WindowInsets.consumeSystemWindowInsets(boolean, boolean, boolean, boolean):android.view.WindowInsets");
    }

    public WindowInsets consumeWindowDecorInsets() {
        WindowInsets windowInsets = new WindowInsets(this);
        windowInsets.mWindowDecorInsets.set(0, 0, 0, 0);
        windowInsets.mWindowDecorInsetsConsumed = true;
        return windowInsets;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0014, code lost:
        if (r12 != false) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.view.WindowInsets consumeWindowDecorInsets(boolean r9, boolean r10, boolean r11, boolean r12) {
        /*
            r8 = this;
            r0 = 0
            r16 = r0
            r0 = r9
            if (r0 != 0) goto L17
            r0 = r10
            if (r0 != 0) goto L17
            r0 = r11
            if (r0 != 0) goto L17
            r0 = r8
            r17 = r0
            r0 = r12
            if (r0 == 0) goto L4f
        L17:
            android.view.WindowInsets r0 = new android.view.WindowInsets
            r1 = r0
            r2 = r8
            r1.<init>(r2)
            r17 = r0
            r0 = r9
            if (r0 == 0) goto L52
            r0 = 0
            r13 = r0
        L28:
            r0 = r10
            if (r0 == 0) goto L5e
            r0 = 0
            r14 = r0
        L2f:
            r0 = r11
            if (r0 == 0) goto L6a
            r0 = 0
            r15 = r0
        L36:
            r0 = r12
            if (r0 == 0) goto L76
        L3b:
            r0 = r17
            android.graphics.Rect r1 = new android.graphics.Rect
            r2 = r1
            r3 = r13
            r4 = r14
            r5 = r15
            r6 = r16
            r2.<init>(r3, r4, r5, r6)
            r0.mWindowDecorInsets = r1
        L4f:
            r0 = r17
            return r0
        L52:
            r0 = r8
            android.graphics.Rect r0 = r0.mWindowDecorInsets
            int r0 = r0.left
            r13 = r0
            goto L28
        L5e:
            r0 = r8
            android.graphics.Rect r0 = r0.mWindowDecorInsets
            int r0 = r0.top
            r14 = r0
            goto L2f
        L6a:
            r0 = r8
            android.graphics.Rect r0 = r0.mWindowDecorInsets
            int r0 = r0.right
            r15 = r0
            goto L36
        L76:
            r0 = r8
            android.graphics.Rect r0 = r0.mWindowDecorInsets
            int r0 = r0.bottom
            r16 = r0
            goto L3b
        */
        throw new UnsupportedOperationException("Method not decompiled: android.view.WindowInsets.consumeWindowDecorInsets(boolean, boolean, boolean, boolean):android.view.WindowInsets");
    }

    public int getStableInsetBottom() {
        return this.mStableInsets.bottom;
    }

    public int getStableInsetLeft() {
        return this.mStableInsets.left;
    }

    public int getStableInsetRight() {
        return this.mStableInsets.right;
    }

    public int getStableInsetTop() {
        return this.mStableInsets.top;
    }

    public int getSystemWindowInsetBottom() {
        return this.mSystemWindowInsets.bottom;
    }

    public int getSystemWindowInsetLeft() {
        return this.mSystemWindowInsets.left;
    }

    public int getSystemWindowInsetRight() {
        return this.mSystemWindowInsets.right;
    }

    public int getSystemWindowInsetTop() {
        return this.mSystemWindowInsets.top;
    }

    public Rect getSystemWindowInsets() {
        if (this.mTempRect == null) {
            this.mTempRect = new Rect();
        }
        if (this.mSystemWindowInsets != null) {
            this.mTempRect.set(this.mSystemWindowInsets);
        } else {
            this.mTempRect.setEmpty();
        }
        return this.mTempRect;
    }

    public int getWindowDecorInsetBottom() {
        return this.mWindowDecorInsets.bottom;
    }

    public int getWindowDecorInsetLeft() {
        return this.mWindowDecorInsets.left;
    }

    public int getWindowDecorInsetRight() {
        return this.mWindowDecorInsets.right;
    }

    public int getWindowDecorInsetTop() {
        return this.mWindowDecorInsets.top;
    }

    public boolean hasInsets() {
        return hasSystemWindowInsets() || hasWindowDecorInsets();
    }

    public boolean hasStableInsets() {
        return (this.mStableInsets.top == 0 && this.mStableInsets.left == 0 && this.mStableInsets.right == 0 && this.mStableInsets.bottom == 0) ? false : true;
    }

    public boolean hasSystemWindowInsets() {
        return (this.mSystemWindowInsets.left == 0 && this.mSystemWindowInsets.top == 0 && this.mSystemWindowInsets.right == 0 && this.mSystemWindowInsets.bottom == 0) ? false : true;
    }

    public boolean hasWindowDecorInsets() {
        return (this.mWindowDecorInsets.left == 0 && this.mWindowDecorInsets.top == 0 && this.mWindowDecorInsets.right == 0 && this.mWindowDecorInsets.bottom == 0) ? false : true;
    }

    public boolean isConsumed() {
        return this.mSystemWindowInsetsConsumed && this.mWindowDecorInsetsConsumed && this.mStableInsetsConsumed;
    }

    public boolean isRound() {
        return this.mIsRound;
    }

    public WindowInsets replaceSystemWindowInsets(int i, int i2, int i3, int i4) {
        WindowInsets windowInsets = new WindowInsets(this);
        windowInsets.mSystemWindowInsets = new Rect(i, i2, i3, i4);
        return windowInsets;
    }

    public WindowInsets replaceSystemWindowInsets(Rect rect) {
        WindowInsets windowInsets = new WindowInsets(this);
        windowInsets.mSystemWindowInsets = new Rect(rect);
        return windowInsets;
    }

    public WindowInsets replaceWindowDecorInsets(int i, int i2, int i3, int i4) {
        WindowInsets windowInsets = new WindowInsets(this);
        windowInsets.mWindowDecorInsets = new Rect(i, i2, i3, i4);
        return windowInsets;
    }

    public String toString() {
        return "WindowInsets{systemWindowInsets=" + this.mSystemWindowInsets + " windowDecorInsets=" + this.mWindowDecorInsets + " stableInsets=" + this.mStableInsets + (isRound() ? " round}" : i.d);
    }
}
