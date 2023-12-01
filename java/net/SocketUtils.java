package java.net;

/* loaded from: source-2895416-dex2jar.jar:java/net/SocketUtils.class */
public class SocketUtils {
    private SocketUtils() {
    }

    public static void setCreated(Socket socket) {
        socket.isCreated = true;
    }
}
