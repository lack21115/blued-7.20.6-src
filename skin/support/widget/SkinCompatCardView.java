package skin.support.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import androidx.cardview.widget.CardView;
import skin.support.cardview.R;
import skin.support.content.res.SkinCompatResources;

/* loaded from: source-3503164-dex2jar.jar:skin/support/widget/SkinCompatCardView.class */
public class SkinCompatCardView extends CardView implements SkinCompatSupportable {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f44259a = {16842801};
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private int f44260c;

    public SkinCompatCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SkinCompatCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = 0;
        this.f44260c = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CardView, i, R.style.CardView);
        if (obtainStyledAttributes.hasValue(R.styleable.CardView_cardBackgroundColor)) {
            this.f44260c = obtainStyledAttributes.getResourceId(R.styleable.CardView_cardBackgroundColor, 0);
        } else {
            TypedArray obtainStyledAttributes2 = getContext().obtainStyledAttributes(f44259a);
            this.b = obtainStyledAttributes2.getResourceId(0, 0);
            obtainStyledAttributes2.recycle();
        }
        obtainStyledAttributes.recycle();
        a();
    }

    private void a() {
        this.f44260c = SkinCompatHelper.b(this.f44260c);
        int b = SkinCompatHelper.b(this.b);
        this.b = b;
        if (this.f44260c != 0) {
            setCardBackgroundColor(SkinCompatResources.d(getContext(), this.f44260c));
        } else if (b != 0) {
            float[] fArr = new float[3];
            Color.colorToHSV(SkinCompatResources.c(getContext(), this.b), fArr);
            setCardBackgroundColor(ColorStateList.valueOf(fArr[2] > 0.5f ? getResources().getColor(R.color.cardview_light_background) : getResources().getColor(R.color.cardview_dark_background)));
        }
    }

    @Override // skin.support.widget.SkinCompatSupportable
    public void applySkin() {
        a();
    }
}
