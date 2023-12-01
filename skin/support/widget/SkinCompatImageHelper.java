package skin.support.widget;

import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.core.widget.ImageViewCompat;
import skin.support.R;
import skin.support.content.res.SkinCompatResources;
import skin.support.content.res.SkinCompatVectorResources;

/* loaded from: source-3503164-dex2jar.jar:skin/support/widget/SkinCompatImageHelper.class */
public class SkinCompatImageHelper extends SkinCompatHelper {

    /* renamed from: a  reason: collision with root package name */
    private static final String f44270a = SkinCompatImageHelper.class.getSimpleName();
    private final ImageView b;

    /* renamed from: c  reason: collision with root package name */
    private int f44271c = 0;
    private int d = 0;
    private int e = 0;

    public SkinCompatImageHelper(ImageView imageView) {
        this.b = imageView;
    }

    public void a() {
        Drawable a2;
        int b = b(this.d);
        this.d = b;
        if (b != 0) {
            Drawable a3 = SkinCompatVectorResources.a(this.b.getContext(), this.d);
            if (a3 != null) {
                this.b.setImageDrawable(a3);
            }
        } else {
            int b2 = b(this.f44271c);
            this.f44271c = b2;
            if (b2 != 0 && (a2 = SkinCompatVectorResources.a(this.b.getContext(), this.f44271c)) != null) {
                this.b.setImageDrawable(a2);
            }
        }
        int b3 = b(this.e);
        this.e = b3;
        if (b3 != 0) {
            ImageViewCompat.setImageTintList(this.b, SkinCompatResources.d(this.b.getContext(), this.e));
        }
    }

    public void a(int i) {
        this.f44271c = i;
        this.d = 0;
        a();
    }

    public void a(AttributeSet attributeSet, int i) {
        TypedArray typedArray = null;
        try {
            TypedArray obtainStyledAttributes = this.b.getContext().obtainStyledAttributes(attributeSet, R.styleable.SkinCompatImageView, i, 0);
            this.f44271c = obtainStyledAttributes.getResourceId(R.styleable.SkinCompatImageView_android_src, 0);
            this.d = obtainStyledAttributes.getResourceId(R.styleable.SkinCompatImageView_srcCompat, 0);
            int resourceId = obtainStyledAttributes.getResourceId(R.styleable.SkinCompatImageView_tint, 0);
            this.e = resourceId;
            if (resourceId == 0) {
                typedArray = obtainStyledAttributes;
                this.e = obtainStyledAttributes.getResourceId(R.styleable.SkinCompatImageView_android_tint, 0);
            }
            if (obtainStyledAttributes != null) {
                obtainStyledAttributes.recycle();
            }
            a();
        } catch (Throwable th) {
            if (typedArray != null) {
                typedArray.recycle();
            }
            throw th;
        }
    }
}
