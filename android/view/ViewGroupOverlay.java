package android.view;

import android.content.Context;

/* loaded from: source-4181928-dex2jar.jar:android/view/ViewGroupOverlay.class */
public class ViewGroupOverlay extends ViewOverlay {
    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewGroupOverlay(Context context, View view) {
        super(context, view);
    }

    public void add(View view) {
        this.mOverlayViewGroup.add(view);
    }

    public void remove(View view) {
        this.mOverlayViewGroup.remove(view);
    }
}
