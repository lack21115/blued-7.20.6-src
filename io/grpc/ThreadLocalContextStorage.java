package io.grpc;

import io.grpc.Context;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: source-8829756-dex2jar.jar:io/grpc/ThreadLocalContextStorage.class */
final class ThreadLocalContextStorage extends Context.Storage {
    private static final Logger log = Logger.getLogger(ThreadLocalContextStorage.class.getName());
    static final ThreadLocal<Context> localContext = new ThreadLocal<>();

    @Override // io.grpc.Context.Storage
    public Context current() {
        Context context = localContext.get();
        Context context2 = context;
        if (context == null) {
            context2 = Context.ROOT;
        }
        return context2;
    }

    @Override // io.grpc.Context.Storage
    public void detach(Context context, Context context2) {
        if (current() != context) {
            log.log(Level.SEVERE, "Context was not attached when detaching", new Throwable().fillInStackTrace());
        }
        if (context2 != Context.ROOT) {
            localContext.set(context2);
        } else {
            localContext.set(null);
        }
    }

    @Override // io.grpc.Context.Storage
    public Context doAttach(Context context) {
        Context current = current();
        localContext.set(context);
        return current;
    }
}
