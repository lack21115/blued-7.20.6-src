package com.bumptech.glide.load.engine;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/engine/CallbackException.class */
final class CallbackException extends RuntimeException {
    private static final long serialVersionUID = -7530898992688511851L;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CallbackException(Throwable th) {
        super("Unexpected exception thrown by non-Glide code", th);
    }
}
