package com.sobot.chat.widget.zxing;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/zxing/ReaderException.class */
public abstract class ReaderException extends Exception {
    protected static final StackTraceElement[] NO_TRACE;
    protected static final boolean isStackTrace;

    static {
        isStackTrace = System.getProperty("surefire.test.class.path") != null;
        NO_TRACE = new StackTraceElement[0];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ReaderException() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ReaderException(Throwable th) {
        super(th);
    }

    @Override // java.lang.Throwable
    public final Throwable fillInStackTrace() {
        synchronized (this) {
        }
        return null;
    }
}
