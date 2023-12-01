package com.google.protobuf;

import com.google.protobuf.GeneratedMessageLite;

/* loaded from: source-8110460-dex2jar.jar:com/google/protobuf/NewInstanceSchemaLite.class */
final class NewInstanceSchemaLite implements NewInstanceSchema {
    @Override // com.google.protobuf.NewInstanceSchema
    public Object newInstance(Object obj) {
        return ((GeneratedMessageLite) obj).dynamicMethod(GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE);
    }
}
