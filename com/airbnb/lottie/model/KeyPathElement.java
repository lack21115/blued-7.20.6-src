package com.airbnb.lottie.model;

import com.airbnb.lottie.value.LottieValueCallback;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/model/KeyPathElement.class */
public interface KeyPathElement {
    void a(KeyPath keyPath, int i, List<KeyPath> list, KeyPath keyPath2);

    <T> void a(T t, LottieValueCallback<T> lottieValueCallback);
}
