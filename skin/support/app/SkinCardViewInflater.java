package skin.support.app;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import skin.support.widget.SkinCompatCardView;

/* loaded from: source-3503164-dex2jar.jar:skin/support/app/SkinCardViewInflater.class */
public class SkinCardViewInflater implements SkinLayoutInflater {
    @Override // skin.support.app.SkinLayoutInflater
    public View a(Context context, String str, AttributeSet attributeSet) {
        if ((str.hashCode() == 966046347 && str.equals("androidx.cardview.widget.CardView")) ? false : true) {
            return null;
        }
        return new SkinCompatCardView(context, attributeSet);
    }
}
