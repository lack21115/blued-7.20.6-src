package io.grpc;

import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;

/* loaded from: source-8829756-dex2jar.jar:io/grpc/HandlerRegistry.class */
public abstract class HandlerRegistry {
    public List<ServerServiceDefinition> getServices() {
        return Collections.emptyList();
    }

    @Nullable
    public final ServerMethodDefinition<?, ?> lookupMethod(String str) {
        return lookupMethod(str, null);
    }

    @Nullable
    public abstract ServerMethodDefinition<?, ?> lookupMethod(String str, @Nullable String str2);
}
