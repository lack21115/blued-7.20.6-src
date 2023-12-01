package com.blued.android.module.live.base.view.subscaleview.decoder;

import android.graphics.Bitmap;
import java.lang.reflect.InvocationTargetException;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/live/base/view/subscaleview/decoder/CompatDecoderFactory.class */
public class CompatDecoderFactory<T> implements DecoderFactory<T> {
    private final Class<? extends T> a;
    private final Bitmap.Config b;

    public CompatDecoderFactory(Class<? extends T> cls) {
        this(cls, null);
    }

    public CompatDecoderFactory(Class<? extends T> cls, Bitmap.Config config) {
        this.a = cls;
        this.b = config;
    }

    @Override // com.blued.android.module.live.base.view.subscaleview.decoder.DecoderFactory
    public T a() throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        return this.b == null ? this.a.newInstance() : this.a.getConstructor(Bitmap.Config.class).newInstance(this.b);
    }
}
