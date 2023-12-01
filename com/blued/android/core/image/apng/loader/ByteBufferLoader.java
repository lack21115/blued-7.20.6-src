package com.blued.android.core.image.apng.loader;

import com.blued.android.core.image.apng.io.ByteBufferReader;
import com.blued.android.core.image.apng.io.Reader;
import java.nio.ByteBuffer;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/image/apng/loader/ByteBufferLoader.class */
public abstract class ByteBufferLoader {
    public abstract ByteBuffer a();

    public Reader b() {
        return new ByteBufferReader(a());
    }
}
