package android.view;

import android.view.ViewGroup;

/* loaded from: source-4181928-dex2jar.jar:android/view/ViewManager.class */
public interface ViewManager {
    void addView(View view, ViewGroup.LayoutParams layoutParams);

    void removeView(View view);

    void updateViewLayout(View view, ViewGroup.LayoutParams layoutParams);
}
