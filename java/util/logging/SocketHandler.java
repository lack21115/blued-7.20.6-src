package java.util.logging;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.Socket;

/* loaded from: source-2895416-dex2jar.jar:java/util/logging/SocketHandler.class */
public class SocketHandler extends StreamHandler {
    private static final String DEFAULT_FORMATTER = "java.util.logging.XMLFormatter";
    private static final String DEFAULT_LEVEL = "ALL";
    private Socket socket;

    public SocketHandler() throws IOException {
        super("ALL", null, DEFAULT_FORMATTER, null);
        initSocket(LogManager.getLogManager().getProperty("java.util.logging.SocketHandler.host"), LogManager.getLogManager().getProperty("java.util.logging.SocketHandler.port"));
    }

    public SocketHandler(String str, int i) throws IOException {
        super("ALL", null, DEFAULT_FORMATTER, null);
        initSocket(str, String.valueOf(i));
    }

    private void initSocket(String str, String str2) throws IOException {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("host == null || host.isEmpty()");
        }
        try {
            try {
                this.socket = new Socket(str, Integer.parsePositiveInt(str2));
                super.internalSetOutputStream(new BufferedOutputStream(this.socket.getOutputStream()));
            } catch (IOException e) {
                getErrorManager().error("Failed to establish the network connection", e, 4);
                throw e;
            }
        } catch (NumberFormatException e2) {
            throw new IllegalArgumentException("Illegal port argument " + str2);
        }
    }

    @Override // java.util.logging.StreamHandler, java.util.logging.Handler
    public void close() {
        try {
            super.close();
            if (this.socket != null) {
                this.socket.close();
                this.socket = null;
            }
        } catch (Exception e) {
            getErrorManager().error("Exception occurred when closing the socket handler", e, 3);
        }
    }

    @Override // java.util.logging.StreamHandler, java.util.logging.Handler
    public void publish(LogRecord logRecord) {
        super.publish(logRecord);
        super.flush();
    }
}
