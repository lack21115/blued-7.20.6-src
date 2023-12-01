package java.util.logging;

/* loaded from: source-2895416-dex2jar.jar:java/util/logging/ConsoleHandler.class */
public class ConsoleHandler extends StreamHandler {
    public ConsoleHandler() {
        super(System.err);
    }

    @Override // java.util.logging.StreamHandler, java.util.logging.Handler
    public void close() {
        super.close(false);
    }

    @Override // java.util.logging.StreamHandler, java.util.logging.Handler
    public void publish(LogRecord logRecord) {
        super.publish(logRecord);
        super.flush();
    }
}
