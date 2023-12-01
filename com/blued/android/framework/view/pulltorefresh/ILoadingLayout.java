package com.blued.android.framework.view.pulltorefresh;

import android.graphics.drawable.Drawable;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/pulltorefresh/ILoadingLayout.class */
public interface ILoadingLayout {
    void setLastUpdatedLabel(CharSequence charSequence);

    void setLoadingDrawable(Drawable drawable);

    void setPullLabel(CharSequence charSequence);

    void setRefreshingLabel(CharSequence charSequence);

    void setReleaseLabel(CharSequence charSequence);
}
