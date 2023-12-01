package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.widget.CheckedTextView;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.widget.CheckedTextViewCompat;

/* loaded from: source-8756600-dex2jar.jar:androidx/appcompat/widget/AppCompatCheckedTextViewHelper.class */
class AppCompatCheckedTextViewHelper {

    /* renamed from: a  reason: collision with root package name */
    private final CheckedTextView f1701a;
    private ColorStateList b = null;

    /* renamed from: c  reason: collision with root package name */
    private PorterDuff.Mode f1702c = null;
    private boolean d = false;
    private boolean e = false;
    private boolean f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AppCompatCheckedTextViewHelper(CheckedTextView checkedTextView) {
        this.f1701a = checkedTextView;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList a() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ColorStateList colorStateList) {
        this.b = colorStateList;
        this.d = true;
        d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(PorterDuff.Mode mode) {
        this.f1702c = mode;
        this.e = true;
        d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0092 A[Catch: all -> 0x00c2, TryCatch #0 {all -> 0x00c2, blocks: (B:3:0x002b, B:5:0x0035, B:7:0x0042, B:12:0x005f, B:14:0x0069, B:16:0x0076, B:18:0x0089, B:20:0x0092, B:22:0x00a1, B:24:0x00aa), top: B:33:0x002b }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00aa A[Catch: all -> 0x00c2, TryCatch #0 {all -> 0x00c2, blocks: (B:3:0x002b, B:5:0x0035, B:7:0x0042, B:12:0x005f, B:14:0x0069, B:16:0x0076, B:18:0x0089, B:20:0x0092, B:22:0x00a1, B:24:0x00aa), top: B:33:0x002b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(android.util.AttributeSet r9, int r10) {
        /*
            r8 = this;
            r0 = r8
            android.widget.CheckedTextView r0 = r0.f1701a
            android.content.Context r0 = r0.getContext()
            r1 = r9
            int[] r2 = androidx.appcompat.R.styleable.CheckedTextView
            r3 = r10
            r4 = 0
            androidx.appcompat.widget.TintTypedArray r0 = androidx.appcompat.widget.TintTypedArray.obtainStyledAttributes(r0, r1, r2, r3, r4)
            r11 = r0
            r0 = r8
            android.widget.CheckedTextView r0 = r0.f1701a
            r12 = r0
            r0 = r12
            r1 = r12
            android.content.Context r1 = r1.getContext()
            int[] r2 = androidx.appcompat.R.styleable.CheckedTextView
            r3 = r9
            r4 = r11
            android.content.res.TypedArray r4 = r4.getWrappedTypeArray()
            r5 = r10
            r6 = 0
            androidx.core.view.ViewCompat.saveAttributeDataForStyleable(r0, r1, r2, r3, r4, r5, r6)
            r0 = r11
            int r1 = androidx.appcompat.R.styleable.CheckedTextView_checkMarkCompat     // Catch: java.lang.Throwable -> Lc2
            boolean r0 = r0.hasValue(r1)     // Catch: java.lang.Throwable -> Lc2
            if (r0 == 0) goto L59
            r0 = r11
            int r1 = androidx.appcompat.R.styleable.CheckedTextView_checkMarkCompat     // Catch: java.lang.Throwable -> Lc2
            r2 = 0
            int r0 = r0.getResourceId(r1, r2)     // Catch: java.lang.Throwable -> Lc2
            r10 = r0
            r0 = r10
            if (r0 == 0) goto L59
            r0 = r8
            android.widget.CheckedTextView r0 = r0.f1701a     // Catch: java.lang.Throwable -> Lc2 android.content.res.Resources.NotFoundException -> Lc9
            r1 = r8
            android.widget.CheckedTextView r1 = r1.f1701a     // Catch: java.lang.Throwable -> Lc2 android.content.res.Resources.NotFoundException -> Lc9
            android.content.Context r1 = r1.getContext()     // Catch: java.lang.Throwable -> Lc2 android.content.res.Resources.NotFoundException -> Lc9
            r2 = r10
            android.graphics.drawable.Drawable r1 = androidx.appcompat.content.res.AppCompatResources.getDrawable(r1, r2)     // Catch: java.lang.Throwable -> Lc2 android.content.res.Resources.NotFoundException -> Lc9
            r0.setCheckMarkDrawable(r1)     // Catch: java.lang.Throwable -> Lc2 android.content.res.Resources.NotFoundException -> Lc9
            r0 = 1
            r10 = r0
            goto L5b
        L59:
            r0 = 0
            r10 = r0
        L5b:
            r0 = r10
            if (r0 != 0) goto L88
            r0 = r11
            int r1 = androidx.appcompat.R.styleable.CheckedTextView_android_checkMark     // Catch: java.lang.Throwable -> Lc2
            boolean r0 = r0.hasValue(r1)     // Catch: java.lang.Throwable -> Lc2
            if (r0 == 0) goto L88
            r0 = r11
            int r1 = androidx.appcompat.R.styleable.CheckedTextView_android_checkMark     // Catch: java.lang.Throwable -> Lc2
            r2 = 0
            int r0 = r0.getResourceId(r1, r2)     // Catch: java.lang.Throwable -> Lc2
            r10 = r0
            r0 = r10
            if (r0 == 0) goto L88
            r0 = r8
            android.widget.CheckedTextView r0 = r0.f1701a     // Catch: java.lang.Throwable -> Lc2
            r1 = r8
            android.widget.CheckedTextView r1 = r1.f1701a     // Catch: java.lang.Throwable -> Lc2
            android.content.Context r1 = r1.getContext()     // Catch: java.lang.Throwable -> Lc2
            r2 = r10
            android.graphics.drawable.Drawable r1 = androidx.appcompat.content.res.AppCompatResources.getDrawable(r1, r2)     // Catch: java.lang.Throwable -> Lc2
            r0.setCheckMarkDrawable(r1)     // Catch: java.lang.Throwable -> Lc2
        L88:
            r0 = r11
            int r1 = androidx.appcompat.R.styleable.CheckedTextView_checkMarkTint     // Catch: java.lang.Throwable -> Lc2
            boolean r0 = r0.hasValue(r1)     // Catch: java.lang.Throwable -> Lc2
            if (r0 == 0) goto La0
            r0 = r8
            android.widget.CheckedTextView r0 = r0.f1701a     // Catch: java.lang.Throwable -> Lc2
            r1 = r11
            int r2 = androidx.appcompat.R.styleable.CheckedTextView_checkMarkTint     // Catch: java.lang.Throwable -> Lc2
            android.content.res.ColorStateList r1 = r1.getColorStateList(r2)     // Catch: java.lang.Throwable -> Lc2
            androidx.core.widget.CheckedTextViewCompat.setCheckMarkTintList(r0, r1)     // Catch: java.lang.Throwable -> Lc2
        La0:
            r0 = r11
            int r1 = androidx.appcompat.R.styleable.CheckedTextView_checkMarkTintMode     // Catch: java.lang.Throwable -> Lc2
            boolean r0 = r0.hasValue(r1)     // Catch: java.lang.Throwable -> Lc2
            if (r0 == 0) goto Lbd
            r0 = r8
            android.widget.CheckedTextView r0 = r0.f1701a     // Catch: java.lang.Throwable -> Lc2
            r1 = r11
            int r2 = androidx.appcompat.R.styleable.CheckedTextView_checkMarkTintMode     // Catch: java.lang.Throwable -> Lc2
            r3 = -1
            int r1 = r1.getInt(r2, r3)     // Catch: java.lang.Throwable -> Lc2
            r2 = 0
            android.graphics.PorterDuff$Mode r1 = androidx.appcompat.widget.DrawableUtils.parseTintMode(r1, r2)     // Catch: java.lang.Throwable -> Lc2
            androidx.core.widget.CheckedTextViewCompat.setCheckMarkTintMode(r0, r1)     // Catch: java.lang.Throwable -> Lc2
        Lbd:
            r0 = r11
            r0.recycle()
            return
        Lc2:
            r9 = move-exception
            r0 = r11
            r0.recycle()
            r0 = r9
            throw r0
        Lc9:
            r9 = move-exception
            goto L59
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.AppCompatCheckedTextViewHelper.a(android.util.AttributeSet, int):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PorterDuff.Mode b() {
        return this.f1702c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        if (this.f) {
            this.f = false;
            return;
        }
        this.f = true;
        d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d() {
        Drawable checkMarkDrawable = CheckedTextViewCompat.getCheckMarkDrawable(this.f1701a);
        if (checkMarkDrawable != null) {
            if (this.d || this.e) {
                Drawable mutate = DrawableCompat.wrap(checkMarkDrawable).mutate();
                if (this.d) {
                    DrawableCompat.setTintList(mutate, this.b);
                }
                if (this.e) {
                    DrawableCompat.setTintMode(mutate, this.f1702c);
                }
                if (mutate.isStateful()) {
                    mutate.setState(this.f1701a.getDrawableState());
                }
                this.f1701a.setCheckMarkDrawable(mutate);
            }
        }
    }
}
