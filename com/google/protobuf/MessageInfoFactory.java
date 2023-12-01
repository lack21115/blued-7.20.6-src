package com.google.protobuf;

/* loaded from: source-8110460-dex2jar.jar:com/google/protobuf/MessageInfoFactory.class */
interface MessageInfoFactory {
    boolean isSupported(Class<?> cls);

    MessageInfo messageInfoFor(Class<?> cls);
}
