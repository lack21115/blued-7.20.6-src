package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8756600-dex2jar.jar:androidx/core/graphics/drawable/WrappedDrawableState.class */
public final class WrappedDrawableState extends Drawable.ConstantState {

    /* renamed from: a  reason: collision with root package name */
    int f2475a;
    Drawable.ConstantState b;

    /* renamed from: c  reason: collision with root package name */
    ColorStateList f2476c;
    PorterDuff.Mode d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public WrappedDrawableState(WrappedDrawableState wrappedDrawableState) {
        this.f2476c = null;
        this.d = WrappedDrawableApi14.f2473a;
        if (wrappedDrawableState != null) {
            this.f2475a = wrappedDrawableState.f2475a;
            this.b = wrappedDrawableState.b;
            this.f2476c = wrappedDrawableState.f2476c;
            this.d = wrappedDrawableState.d;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a() {
        return this.b != null;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public int getChangingConfigurations() {
        int i = this.f2475a;
        Drawable.ConstantState constantState = this.b;
        return i | (constantState != null ? constantState.getChangingConfigurations() : 0);
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public Drawable newDrawable() {
        return newDrawable(null);
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public Drawable newDrawable(Resources resources) {
        return Build.VERSION.SDK_INT >= 21 ? new WrappedDrawableApi21(this, resources) : new WrappedDrawableApi14(this, resources);
    }
}
