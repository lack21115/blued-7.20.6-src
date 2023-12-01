package java.net;

/* loaded from: source-2895416-dex2jar.jar:java/net/Authenticator.class */
public abstract class Authenticator {
    private static Authenticator thisAuthenticator;
    private InetAddress addr;
    private String host;
    private int port;
    private String prompt;
    private String protocol;
    private RequestorType rt;
    private String scheme;
    private URL url;

    /* loaded from: source-2895416-dex2jar.jar:java/net/Authenticator$RequestorType.class */
    public enum RequestorType {
        PROXY,
        SERVER
    }

    public static PasswordAuthentication requestPasswordAuthentication(String str, InetAddress inetAddress, int i, String str2, String str3, String str4) {
        PasswordAuthentication passwordAuthentication;
        synchronized (Authenticator.class) {
            try {
                if (thisAuthenticator == null) {
                    passwordAuthentication = null;
                } else {
                    thisAuthenticator.host = str;
                    thisAuthenticator.addr = inetAddress;
                    thisAuthenticator.port = i;
                    thisAuthenticator.protocol = str2;
                    thisAuthenticator.prompt = str3;
                    thisAuthenticator.scheme = str4;
                    thisAuthenticator.rt = RequestorType.SERVER;
                    passwordAuthentication = thisAuthenticator.getPasswordAuthentication();
                }
            } finally {
            }
        }
        return passwordAuthentication;
    }

    public static PasswordAuthentication requestPasswordAuthentication(String str, InetAddress inetAddress, int i, String str2, String str3, String str4, URL url, RequestorType requestorType) {
        if (thisAuthenticator == null) {
            return null;
        }
        thisAuthenticator.host = str;
        thisAuthenticator.addr = inetAddress;
        thisAuthenticator.port = i;
        thisAuthenticator.protocol = str2;
        thisAuthenticator.prompt = str3;
        thisAuthenticator.scheme = str4;
        thisAuthenticator.url = url;
        thisAuthenticator.rt = requestorType;
        return thisAuthenticator.getPasswordAuthentication();
    }

    public static PasswordAuthentication requestPasswordAuthentication(InetAddress inetAddress, int i, String str, String str2, String str3) {
        PasswordAuthentication passwordAuthentication;
        synchronized (Authenticator.class) {
            try {
                if (thisAuthenticator == null) {
                    passwordAuthentication = null;
                } else {
                    thisAuthenticator.addr = inetAddress;
                    thisAuthenticator.port = i;
                    thisAuthenticator.protocol = str;
                    thisAuthenticator.prompt = str2;
                    thisAuthenticator.scheme = str3;
                    thisAuthenticator.rt = RequestorType.SERVER;
                    passwordAuthentication = thisAuthenticator.getPasswordAuthentication();
                }
            } finally {
            }
        }
        return passwordAuthentication;
    }

    public static void setDefault(Authenticator authenticator) {
        thisAuthenticator = authenticator;
    }

    protected PasswordAuthentication getPasswordAuthentication() {
        return null;
    }

    protected final String getRequestingHost() {
        return this.host;
    }

    protected final int getRequestingPort() {
        return this.port;
    }

    protected final String getRequestingPrompt() {
        return this.prompt;
    }

    protected final String getRequestingProtocol() {
        return this.protocol;
    }

    protected final String getRequestingScheme() {
        return this.scheme;
    }

    protected final InetAddress getRequestingSite() {
        return this.addr;
    }

    protected URL getRequestingURL() {
        return this.url;
    }

    protected RequestorType getRequestorType() {
        return this.rt;
    }
}
