package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.appcompat.R;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.ViewCompat;
import androidx.core.widget.ImageViewCompat;

/* loaded from: source-8756600-dex2jar.jar:androidx/appcompat/widget/AppCompatImageHelper.class */
public class AppCompatImageHelper {

    /* renamed from: a  reason: collision with root package name */
    private final ImageView f1763a;
    private TintInfo b;

    /* renamed from: c  reason: collision with root package name */
    private TintInfo f1764c;
    private TintInfo d;
    private int e = 0;

    public AppCompatImageHelper(ImageView imageView) {
        this.f1763a = imageView;
    }

    private boolean b(Drawable drawable) {
        if (this.d == null) {
            this.d = new TintInfo();
        }
        TintInfo tintInfo = this.d;
        tintInfo.a();
        ColorStateList imageTintList = ImageViewCompat.getImageTintList(this.f1763a);
        if (imageTintList != null) {
            tintInfo.mHasTintList = true;
            tintInfo.mTintList = imageTintList;
        }
        PorterDuff.Mode imageTintMode = ImageViewCompat.getImageTintMode(this.f1763a);
        if (imageTintMode != null) {
            tintInfo.mHasTintMode = true;
            tintInfo.mTintMode = imageTintMode;
        }
        if (tintInfo.mHasTintList || tintInfo.mHasTintMode) {
            AppCompatDrawableManager.a(drawable, tintInfo, this.f1763a.getDrawableState());
            return true;
        }
        return false;
    }

    private boolean f() {
        int i = Build.VERSION.SDK_INT;
        return i > 21 ? this.b != null : i == 21;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ColorStateList colorStateList) {
        if (this.f1764c == null) {
            this.f1764c = new TintInfo();
        }
        this.f1764c.mTintList = colorStateList;
        this.f1764c.mHasTintList = true;
        d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(PorterDuff.Mode mode) {
        if (this.f1764c == null) {
            this.f1764c = new TintInfo();
        }
        this.f1764c.mTintMode = mode;
        this.f1764c.mHasTintMode = true;
        d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Drawable drawable) {
        this.e = drawable.getLevel();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a() {
        return Build.VERSION.SDK_INT < 21 || !(this.f1763a.getBackground() instanceof RippleDrawable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList b() {
        TintInfo tintInfo = this.f1764c;
        if (tintInfo != null) {
            return tintInfo.mTintList;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PorterDuff.Mode c() {
        TintInfo tintInfo = this.f1764c;
        if (tintInfo != null) {
            return tintInfo.mTintMode;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d() {
        Drawable drawable = this.f1763a.getDrawable();
        if (drawable != null) {
            DrawableUtils.a(drawable);
        }
        if (drawable != null) {
            if (f() && b(drawable)) {
                return;
            }
            TintInfo tintInfo = this.f1764c;
            if (tintInfo != null) {
                AppCompatDrawableManager.a(drawable, tintInfo, this.f1763a.getDrawableState());
                return;
            }
            TintInfo tintInfo2 = this.b;
            if (tintInfo2 != null) {
                AppCompatDrawableManager.a(drawable, tintInfo2, this.f1763a.getDrawableState());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e() {
        if (this.f1763a.getDrawable() != null) {
            this.f1763a.getDrawable().setLevel(this.e);
        }
    }

    public void loadFromAttributes(AttributeSet attributeSet, int i) {
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(this.f1763a.getContext(), attributeSet, R.styleable.AppCompatImageView, i, 0);
        ImageView imageView = this.f1763a;
        ViewCompat.saveAttributeDataForStyleable(imageView, imageView.getContext(), R.styleable.AppCompatImageView, attributeSet, obtainStyledAttributes.getWrappedTypeArray(), i, 0);
        try {
            Drawable drawable = this.f1763a.getDrawable();
            Drawable drawable2 = drawable;
            if (drawable == null) {
                int resourceId = obtainStyledAttributes.getResourceId(R.styleable.AppCompatImageView_srcCompat, -1);
                drawable2 = drawable;
                if (resourceId != -1) {
                    Drawable drawable3 = AppCompatResources.getDrawable(this.f1763a.getContext(), resourceId);
                    drawable2 = drawable3;
                    if (drawable3 != null) {
                        this.f1763a.setImageDrawable(drawable3);
                        drawable2 = drawable3;
                    }
                }
            }
            if (drawable2 != null) {
                DrawableUtils.a(drawable2);
            }
            if (obtainStyledAttributes.hasValue(R.styleable.AppCompatImageView_tint)) {
                ImageViewCompat.setImageTintList(this.f1763a, obtainStyledAttributes.getColorStateList(R.styleable.AppCompatImageView_tint));
            }
            if (obtainStyledAttributes.hasValue(R.styleable.AppCompatImageView_tintMode)) {
                ImageViewCompat.setImageTintMode(this.f1763a, DrawableUtils.parseTintMode(obtainStyledAttributes.getInt(R.styleable.AppCompatImageView_tintMode, -1), null));
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public void setImageResource(int i) {
        if (i != 0) {
            Drawable drawable = AppCompatResources.getDrawable(this.f1763a.getContext(), i);
            if (drawable != null) {
                DrawableUtils.a(drawable);
            }
            this.f1763a.setImageDrawable(drawable);
        } else {
            this.f1763a.setImageDrawable(null);
        }
        d();
    }
}
