package com.blued.android.module.live.base.view.subscaleview.decoder;

import java.lang.reflect.InvocationTargetException;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/live/base/view/subscaleview/decoder/DecoderFactory.class */
public interface DecoderFactory<T> {
    T a() throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException;
}
