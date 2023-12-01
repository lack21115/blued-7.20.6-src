package skin.support.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import androidx.cardview.widget.CardView;
import com.android.internal.R;
import skin.support.content.res.SkinCompatResources;

/* loaded from: source-3503164-dex2jar.jar:skin/support/widget/SkinCompatCardView.class */
public class SkinCompatCardView extends CardView implements SkinCompatSupportable {
    private static final int[] a = {R.attr.colorBackground};
    private int b;
    private int c;

    public SkinCompatCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SkinCompatCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = 0;
        this.c = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, skin.support.cardview.R.styleable.CardView, i, skin.support.cardview.R.style.CardView);
        if (obtainStyledAttributes.hasValue(skin.support.cardview.R.styleable.CardView_cardBackgroundColor)) {
            this.c = obtainStyledAttributes.getResourceId(skin.support.cardview.R.styleable.CardView_cardBackgroundColor, 0);
        } else {
            TypedArray obtainStyledAttributes2 = getContext().obtainStyledAttributes(a);
            this.b = obtainStyledAttributes2.getResourceId(0, 0);
            obtainStyledAttributes2.recycle();
        }
        obtainStyledAttributes.recycle();
        a();
    }

    private void a() {
        this.c = SkinCompatHelper.b(this.c);
        int b = SkinCompatHelper.b(this.b);
        this.b = b;
        if (this.c != 0) {
            setCardBackgroundColor(SkinCompatResources.d(getContext(), this.c));
        } else if (b != 0) {
            float[] fArr = new float[3];
            Color.colorToHSV(SkinCompatResources.c(getContext(), this.b), fArr);
            setCardBackgroundColor(ColorStateList.valueOf(fArr[2] > 0.5f ? getResources().getColor(skin.support.cardview.R.color.cardview_light_background) : getResources().getColor(skin.support.cardview.R.color.cardview_dark_background)));
        }
    }

    @Override // skin.support.widget.SkinCompatSupportable
    public void applySkin() {
        a();
    }
}
