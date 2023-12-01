package skin.support.constraint.app;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import skin.support.app.SkinLayoutInflater;
import skin.support.constraint.SkinCompatConstraintLayout;

/* loaded from: source-3503164-dex2jar.jar:skin/support/constraint/app/SkinConstraintViewInflater.class */
public class SkinConstraintViewInflater implements SkinLayoutInflater {
    @Override // skin.support.app.SkinLayoutInflater
    public View a(Context context, String str, AttributeSet attributeSet) {
        if ((str.hashCode() == -979739473 && str.equals("androidx.constraintlayout.widget.ConstraintLayout")) ? false : true) {
            return null;
        }
        return new SkinCompatConstraintLayout(context, attributeSet);
    }
}
