package com.youzan.spiderman.utils;

import java.io.InputStream;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/spiderman/utils/StreamCallback.class */
public interface StreamCallback {
    void fail();

    void success(InputStream inputStream);
}
