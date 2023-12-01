package com.baidu.mobads.sdk.internal.widget;

import android.os.Parcelable;

/* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/internal/widget/StatefulAdapter.class */
public interface StatefulAdapter {
    void restoreState(Parcelable parcelable);

    Parcelable saveState();
}
