package com.google.android.material.textfield;

import android.content.Context;
import com.google.android.material.internal.CheckableImageButton;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8110460-dex2jar.jar:com/google/android/material/textfield/EndIconDelegate.class */
public abstract class EndIconDelegate {
    Context context;
    final int customEndIcon;
    CheckableImageButton endIconView;
    TextInputLayout textInputLayout;

    /* JADX INFO: Access modifiers changed from: package-private */
    public EndIconDelegate(TextInputLayout textInputLayout, int i) {
        this.textInputLayout = textInputLayout;
        this.context = textInputLayout.getContext();
        this.endIconView = textInputLayout.getEndIconView();
        this.customEndIcon = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void initialize();

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isBoxBackgroundModeSupported(int i) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onSuffixVisibilityChanged(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean shouldTintIconOnError() {
        return false;
    }
}
