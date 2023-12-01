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

    /* renamed from: a  reason: collision with root package name */
    private final CompoundButton f44265a;
    private int b = 0;

    /* renamed from: c  reason: collision with root package name */
    private int f44266c = 0;

    public SkinCompatCompoundButtonHelper(CompoundButton compoundButton) {
        this.f44265a = compoundButton;
    }

    public void a() {
        int b = SkinCompatHelper.b(this.b);
        this.b = b;
        if (b != 0) {
            CompoundButton compoundButton = this.f44265a;
            compoundButton.setButtonDrawable(SkinCompatVectorResources.a(compoundButton.getContext(), this.b));
        }
        int b2 = SkinCompatHelper.b(this.f44266c);
        this.f44266c = b2;
        if (b2 != 0) {
            CompoundButton compoundButton2 = this.f44265a;
            CompoundButtonCompat.setButtonTintList(compoundButton2, SkinCompatResources.d(compoundButton2.getContext(), this.f44266c));
        }
    }

    public void a(int i) {
        this.b = i;
        a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = this.f44265a.getContext().obtainStyledAttributes(attributeSet, R.styleable.CompoundButton, i, 0);
        try {
            if (obtainStyledAttributes.hasValue(R.styleable.CompoundButton_android_button)) {
                this.b = obtainStyledAttributes.getResourceId(R.styleable.CompoundButton_android_button, 0);
            }
            if (obtainStyledAttributes.hasValue(R.styleable.CompoundButton_buttonTint)) {
                this.f44266c = obtainStyledAttributes.getResourceId(R.styleable.CompoundButton_buttonTint, 0);
            }
            obtainStyledAttributes.recycle();
            a();
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }
}
