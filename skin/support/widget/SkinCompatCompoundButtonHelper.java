package skin.support.widget;

import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import androidx.core.widget.CompoundButtonCompat;
import skin.support.appcompat.R;
import skin.support.content.res.SkinCompatResources;
import skin.support.content.res.SkinCompatVectorResources;

/* loaded from: source-3503164-dex2jar.jar:skin/support/widget/SkinCompatCompoundButtonHelper.class */
public class SkinCompatCompoundButtonHelper extends SkinCompatHelper {
    private final CompoundButton a;
    private int b = 0;
    private int c = 0;

    public SkinCompatCompoundButtonHelper(CompoundButton compoundButton) {
        this.a = compoundButton;
    }

    public void a() {
        int b = SkinCompatHelper.b(this.b);
        this.b = b;
        if (b != 0) {
            CompoundButton compoundButton = this.a;
            compoundButton.setButtonDrawable(SkinCompatVectorResources.a(compoundButton.getContext(), this.b));
        }
        int b2 = SkinCompatHelper.b(this.c);
        this.c = b2;
        if (b2 != 0) {
            CompoundButton compoundButton2 = this.a;
            CompoundButtonCompat.setButtonTintList(compoundButton2, SkinCompatResources.d(compoundButton2.getContext(), this.c));
        }
    }

    public void a(int i) {
        this.b = i;
        a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = this.a.getContext().obtainStyledAttributes(attributeSet, R.styleable.CompoundButton, i, 0);
        try {
            if (obtainStyledAttributes.hasValue(R.styleable.CompoundButton_android_button)) {
                this.b = obtainStyledAttributes.getResourceId(R.styleable.CompoundButton_android_button, 0);
            }
            if (obtainStyledAttributes.hasValue(R.styleable.CompoundButton_buttonTint)) {
                this.c = obtainStyledAttributes.getResourceId(R.styleable.CompoundButton_buttonTint, 0);
            }
            obtainStyledAttributes.recycle();
            a();
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }
}
