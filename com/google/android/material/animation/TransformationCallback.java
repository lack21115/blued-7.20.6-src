package com.google.android.material.animation;

import android.view.View;

/* loaded from: source-8110460-dex2jar.jar:com/google/android/material/animation/TransformationCallback.class */
public interface TransformationCallback<T extends View> {
    void onScaleChanged(T t);

    void onTranslationChanged(T t);
}
