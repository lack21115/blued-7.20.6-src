package pl.droidsonroids.gif;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.widget.TextView;
import com.anythink.expressad.foundation.h.i;
import java.io.IOException;

/* loaded from: source-3503164-dex2jar.jar:pl/droidsonroids/gif/GifTextView.class */
public class GifTextView extends TextView {

    /* renamed from: a  reason: collision with root package name */
    private boolean f44144a;

    public GifTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(attributeSet, 0, 0);
    }

    public GifTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(attributeSet, i, 0);
    }

    private Drawable a(int i) {
        if (i == 0) {
            return null;
        }
        Resources resources = getResources();
        if (!isInEditMode() && i.f7952c.equals(resources.getResourceTypeName(i))) {
            try {
                return new GifDrawable(resources, i);
            } catch (Resources.NotFoundException | IOException e) {
            }
        }
        return Build.VERSION.SDK_INT >= 21 ? resources.getDrawable(i, getContext().getTheme()) : resources.getDrawable(i);
    }

    private void a(AttributeSet attributeSet, int i, int i2) {
        Drawable drawable;
        Drawable drawable2;
        if (attributeSet != null) {
            Drawable a2 = a(attributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "drawableLeft", 0));
            Drawable a3 = a(attributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "drawableTop", 0));
            Drawable a4 = a(attributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "drawableRight", 0));
            Drawable a5 = a(attributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "drawableBottom", 0));
            Drawable a6 = a(attributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "drawableStart", 0));
            Drawable a7 = a(attributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "drawableEnd", 0));
            if (Build.VERSION.SDK_INT >= 17) {
                if (getLayoutDirection() == 0) {
                    Drawable drawable3 = a6;
                    if (a6 == null) {
                        drawable3 = a2;
                    }
                    drawable = drawable3;
                    drawable2 = a7;
                    if (a7 == null) {
                        drawable2 = a4;
                        drawable = drawable3;
                    }
                } else {
                    Drawable drawable4 = a6;
                    if (a6 == null) {
                        drawable4 = a4;
                    }
                    drawable = drawable4;
                    drawable2 = a7;
                    if (a7 == null) {
                        drawable2 = a2;
                        drawable = drawable4;
                    }
                }
                setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, a3, drawable2, a5);
                setCompoundDrawablesWithIntrinsicBounds(a2, a3, a4, a5);
            } else {
                setCompoundDrawablesWithIntrinsicBounds(a2, a3, a4, a5);
            }
            setBackgroundInternal(a(attributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "background", 0)));
        }
        this.f44144a = GifViewUtils.a(this, attributeSet, i, i2);
    }

    private void a(Drawable[] drawableArr) {
        int length = drawableArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            Drawable drawable = drawableArr[i2];
            if (drawable != null) {
                drawable.setVisible(false, false);
            }
            i = i2 + 1;
        }
    }

    private void setBackgroundInternal(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 16) {
            setBackground(drawable);
        } else {
            setBackgroundDrawable(drawable);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a(getCompoundDrawables());
        if (Build.VERSION.SDK_INT >= 17) {
            a(getCompoundDrawablesRelative());
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof GifViewSavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        GifViewSavedState gifViewSavedState = (GifViewSavedState) parcelable;
        super.onRestoreInstanceState(gifViewSavedState.getSuperState());
        Drawable[] compoundDrawables = getCompoundDrawables();
        gifViewSavedState.a(compoundDrawables[0], 0);
        gifViewSavedState.a(compoundDrawables[1], 1);
        gifViewSavedState.a(compoundDrawables[2], 2);
        gifViewSavedState.a(compoundDrawables[3], 3);
        if (Build.VERSION.SDK_INT >= 17) {
            Drawable[] compoundDrawablesRelative = getCompoundDrawablesRelative();
            gifViewSavedState.a(compoundDrawablesRelative[0], 4);
            gifViewSavedState.a(compoundDrawablesRelative[2], 5);
        }
        gifViewSavedState.a(getBackground(), 6);
    }

    @Override // android.widget.TextView, android.view.View
    public Parcelable onSaveInstanceState() {
        Drawable[] drawableArr = new Drawable[7];
        if (this.f44144a) {
            Drawable[] compoundDrawables = getCompoundDrawables();
            System.arraycopy(compoundDrawables, 0, drawableArr, 0, compoundDrawables.length);
            if (Build.VERSION.SDK_INT >= 17) {
                Drawable[] compoundDrawablesRelative = getCompoundDrawablesRelative();
                drawableArr[4] = compoundDrawablesRelative[0];
                drawableArr[5] = compoundDrawablesRelative[2];
            }
            drawableArr[6] = getBackground();
        }
        return new GifViewSavedState(super.onSaveInstanceState(), drawableArr);
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        setBackgroundInternal(a(i));
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i, int i2, int i3, int i4) {
        setCompoundDrawablesRelativeWithIntrinsicBounds(a(i), a(i2), a(i3), a(i4));
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(int i, int i2, int i3, int i4) {
        setCompoundDrawablesWithIntrinsicBounds(a(i), a(i2), a(i3), a(i4));
    }

    public void setFreezesAnimation(boolean z) {
        this.f44144a = z;
    }
}
