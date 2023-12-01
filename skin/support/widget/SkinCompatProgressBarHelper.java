package skin.support.widget;

import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Shader;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import skin.support.appcompat.R;
import skin.support.content.res.SkinCompatResources;
import skin.support.content.res.SkinCompatVectorResources;
import skin.support.utils.SkinCompatVersionUtils;

/* loaded from: source-3503164-dex2jar.jar:skin/support/widget/SkinCompatProgressBarHelper.class */
public class SkinCompatProgressBarHelper extends SkinCompatHelper {
    private final ProgressBar a;
    private Bitmap b;
    private int c = 0;
    private int d = 0;
    private int e = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SkinCompatProgressBarHelper(ProgressBar progressBar) {
        this.a = progressBar;
    }

    private int a(int i) {
        return b(i);
    }

    private Drawable a(Drawable drawable) {
        AnimationDrawable animationDrawable = drawable;
        if (drawable instanceof AnimationDrawable) {
            AnimationDrawable animationDrawable2 = (AnimationDrawable) drawable;
            int numberOfFrames = animationDrawable2.getNumberOfFrames();
            AnimationDrawable animationDrawable3 = new AnimationDrawable();
            animationDrawable3.setOneShot(animationDrawable2.isOneShot());
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= numberOfFrames) {
                    break;
                }
                Drawable a = a(animationDrawable2.getFrame(i2), true);
                a.setLevel(10000);
                animationDrawable3.addFrame(a, animationDrawable2.getDuration(i2));
                i = i2 + 1;
            }
            animationDrawable3.setLevel(10000);
            animationDrawable = animationDrawable3;
        }
        return animationDrawable;
    }

    private Drawable a(Drawable drawable, boolean z) {
        if (SkinCompatVersionUtils.a(drawable)) {
            Drawable b = SkinCompatVersionUtils.b(drawable);
            if (b != null) {
                SkinCompatVersionUtils.a(drawable, a(b, z));
                return drawable;
            }
        } else if (SkinCompatVersionUtils.c(drawable)) {
            Drawable d = SkinCompatVersionUtils.d(drawable);
            if (d != null) {
                SkinCompatVersionUtils.b(drawable, a(d, z));
                return drawable;
            }
        } else if (drawable instanceof LayerDrawable) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            int numberOfLayers = layerDrawable.getNumberOfLayers();
            Drawable[] drawableArr = new Drawable[numberOfLayers];
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= numberOfLayers) {
                    break;
                }
                int id = layerDrawable.getId(i2);
                drawableArr[i2] = a(layerDrawable.getDrawable(i2), id == 16908301 || id == 16908303);
                i = i2 + 1;
            }
            LayerDrawable layerDrawable2 = new LayerDrawable(drawableArr);
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= numberOfLayers) {
                    return layerDrawable2;
                }
                layerDrawable2.setId(i4, layerDrawable.getId(i4));
                i3 = i4 + 1;
            }
        } else if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            Bitmap bitmap = bitmapDrawable.getBitmap();
            if (this.b == null) {
                this.b = bitmap;
            }
            ShapeDrawable shapeDrawable = new ShapeDrawable(b());
            shapeDrawable.getPaint().setShader(new BitmapShader(bitmap, Shader.TileMode.REPEAT, Shader.TileMode.CLAMP));
            shapeDrawable.getPaint().setColorFilter(bitmapDrawable.getPaint().getColorFilter());
            Drawable drawable2 = shapeDrawable;
            if (z) {
                drawable2 = new ClipDrawable(shapeDrawable, 3, 1);
            }
            return drawable2;
        }
        return drawable;
    }

    private Shape b() {
        return new RoundRectShape(new float[]{5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f}, null, null);
    }

    public void a() {
        int b = b(this.c);
        this.c = b;
        if (b != 0) {
            Drawable a = SkinCompatVectorResources.a(this.a.getContext(), this.c);
            a.setBounds(this.a.getIndeterminateDrawable().getBounds());
            this.a.setIndeterminateDrawable(a(a));
        }
        int a2 = a(this.d);
        this.d = a2;
        if (a2 != 0) {
            this.a.setProgressDrawable(a(SkinCompatVectorResources.a(this.a.getContext(), this.d), false));
        }
        if (Build.VERSION.SDK_INT > 21) {
            int b2 = b(this.e);
            this.e = b2;
            if (b2 != 0) {
                ProgressBar progressBar = this.a;
                progressBar.setIndeterminateTintList(SkinCompatResources.d(progressBar.getContext(), this.e));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = this.a.getContext().obtainStyledAttributes(attributeSet, R.styleable.SkinCompatProgressBar, i, 0);
        this.c = obtainStyledAttributes.getResourceId(R.styleable.SkinCompatProgressBar_android_indeterminateDrawable, 0);
        this.d = obtainStyledAttributes.getResourceId(R.styleable.SkinCompatProgressBar_android_progressDrawable, 0);
        obtainStyledAttributes.recycle();
        if (Build.VERSION.SDK_INT > 21) {
            TypedArray obtainStyledAttributes2 = this.a.getContext().obtainStyledAttributes(attributeSet, new int[]{com.android.internal.R.attr.indeterminateTint}, i, 0);
            this.e = obtainStyledAttributes2.getResourceId(0, 0);
            obtainStyledAttributes2.recycle();
        }
        a();
    }
}
