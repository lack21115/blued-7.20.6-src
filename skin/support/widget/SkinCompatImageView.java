package skin.support.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;

/* loaded from: source-3503164-dex2jar.jar:skin/support/widget/SkinCompatImageView.class */
public class SkinCompatImageView extends AppCompatImageView implements SkinCompatSupportable {

    /* renamed from: a  reason: collision with root package name */
    private SkinCompatBackgroundHelper f44272a;
    private SkinCompatImageHelper b;

    public SkinCompatImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SkinCompatImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        SkinCompatBackgroundHelper skinCompatBackgroundHelper = new SkinCompatBackgroundHelper(this);
        this.f44272a = skinCompatBackgroundHelper;
        skinCompatBackgroundHelper.a(attributeSet, i);
        SkinCompatImageHelper skinCompatImageHelper = new SkinCompatImageHelper(this);
        this.b = skinCompatImageHelper;
        skinCompatImageHelper.a(attributeSet, i);
    }

    @Override // skin.support.widget.SkinCompatSupportable
    public void applySkin() {
        SkinCompatBackgroundHelper skinCompatBackgroundHelper = this.f44272a;
        if (skinCompatBackgroundHelper != null) {
            skinCompatBackgroundHelper.a();
        }
        SkinCompatImageHelper skinCompatImageHelper = this.b;
        if (skinCompatImageHelper != null) {
            skinCompatImageHelper.a();
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        SkinCompatBackgroundHelper skinCompatBackgroundHelper = this.f44272a;
        if (skinCompatBackgroundHelper != null) {
            skinCompatBackgroundHelper.a(i);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int i) {
        SkinCompatImageHelper skinCompatImageHelper = this.b;
        if (skinCompatImageHelper != null) {
            skinCompatImageHelper.a(i);
        }
    }
}
