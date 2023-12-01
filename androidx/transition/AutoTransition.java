package androidx.transition;

import android.content.Context;
import android.util.AttributeSet;

/* loaded from: source-8756600-dex2jar.jar:androidx/transition/AutoTransition.class */
public class AutoTransition extends TransitionSet {
    public AutoTransition() {
        a();
    }

    public AutoTransition(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    private void a() {
        setOrdering(1);
        addTransition(new Fade(2)).addTransition(new ChangeBounds()).addTransition(new Fade(1));
    }
}
