package com.kwad.sdk.api.core.fragment;

import androidx.fragment.app.Fragment;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/api/core/fragment/KsSavedState.class */
public class KsSavedState {
    final Fragment.SavedState mSaveState;

    public KsSavedState(Fragment.SavedState savedState) {
        this.mSaveState = savedState;
    }

    public Fragment.SavedState getBase() {
        return this.mSaveState;
    }
}
