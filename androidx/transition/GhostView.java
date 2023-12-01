package androidx.transition;

import android.view.View;
import android.view.ViewGroup;

/* loaded from: source-8756600-dex2jar.jar:androidx/transition/GhostView.class */
interface GhostView {
    void reserveEndViewTransition(ViewGroup viewGroup, View view);

    void setVisibility(int i);
}
