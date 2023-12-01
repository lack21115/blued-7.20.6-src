package skin.support.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import androidx.appcompat.widget.AppCompatSpinner;
import com.android.internal.R;
import skin.support.content.res.SkinCompatVectorResources;

/* loaded from: source-3503164-dex2jar.jar:skin/support/widget/SkinCompatSpinner.class */
public class SkinCompatSpinner extends AppCompatSpinner implements SkinCompatSupportable {
    private static final String c = SkinCompatSpinner.class.getSimpleName();
    private static final int[] d = {R.attr.spinnerMode};
    private SkinCompatBackgroundHelper e;
    private int f;

    public SkinCompatSpinner(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, skin.support.appcompat.R.attr.spinnerStyle);
    }

    public SkinCompatSpinner(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, -1);
    }

    public SkinCompatSpinner(Context context, AttributeSet attributeSet, int i, int i2) {
        this(context, attributeSet, i, i2, null);
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Multi-variable type inference failed */
    public SkinCompatSpinner(Context context, AttributeSet attributeSet, int i, int i2, Resources.Theme theme) {
        super(context, attributeSet, i, i2, theme);
        TypedArray typedArray;
        int i3;
        this.f = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, skin.support.appcompat.R.styleable.Spinner, i, 0);
        if (getPopupContext() != null) {
            int i4 = i2;
            if (i2 == -1) {
                if (Build.VERSION.SDK_INT >= 11) {
                    TypedArray typedArray2 = null;
                    TypedArray typedArray3 = null;
                    try {
                        try {
                            typedArray = context.obtainStyledAttributes(attributeSet, d, i, 0);
                            i3 = i2;
                            if (typedArray.hasValue(0)) {
                                typedArray3 = typedArray;
                                typedArray2 = typedArray;
                                i3 = typedArray.getInt(0, 0);
                            }
                            i4 = i3;
                        } catch (Exception e) {
                            Log.i(c, "Could not read android:spinnerMode", e);
                            i4 = i2;
                            typedArray = typedArray2 != null ? typedArray2 : typedArray;
                        }
                        if (typedArray != null) {
                            i2 = i3;
                            typedArray.recycle();
                            i4 = i2;
                        }
                    } catch (Throwable th) {
                        if (typedArray3 != null) {
                            typedArray3.recycle();
                        }
                        throw th;
                    }
                } else {
                    i4 = 1;
                }
            }
            if (i4 == 1) {
                TypedArray obtainStyledAttributes2 = getPopupContext().obtainStyledAttributes(attributeSet, skin.support.appcompat.R.styleable.Spinner, i, 0);
                this.f = obtainStyledAttributes2.getResourceId(skin.support.appcompat.R.styleable.Spinner_android_popupBackground, 0);
                obtainStyledAttributes2.recycle();
            }
        }
        obtainStyledAttributes.recycle();
        SkinCompatBackgroundHelper skinCompatBackgroundHelper = new SkinCompatBackgroundHelper(this);
        this.e = skinCompatBackgroundHelper;
        skinCompatBackgroundHelper.a(attributeSet, i);
    }

    private void b() {
        int b = SkinCompatHelper.b(this.f);
        this.f = b;
        if (b != 0) {
            setPopupBackgroundDrawable(SkinCompatVectorResources.a(getContext(), this.f));
        }
    }

    @Override // skin.support.widget.SkinCompatSupportable
    public void applySkin() {
        SkinCompatBackgroundHelper skinCompatBackgroundHelper = this.e;
        if (skinCompatBackgroundHelper != null) {
            skinCompatBackgroundHelper.a();
        }
        b();
    }

    public void setPopupBackgroundResource(int i) {
        super.setPopupBackgroundResource(i);
        this.f = i;
        b();
    }
}
