package com.google.common.io;

import java.io.IOException;

/* loaded from: source-8110460-dex2jar.jar:com/google/common/io/LineProcessor.class */
public interface LineProcessor<T> {
    T getResult();

    boolean processLine(String str) throws IOException;
}
