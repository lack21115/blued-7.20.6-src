package android.net;

/* loaded from: source-9557208-dex2jar.jar:android/net/LocalSocketAddress.class */
public class LocalSocketAddress {
    private final String name;
    private final Namespace namespace;

    /* loaded from: source-9557208-dex2jar.jar:android/net/LocalSocketAddress$Namespace.class */
    public enum Namespace {
        ABSTRACT(0),
        RESERVED(1),
        FILESYSTEM(2);
        
        private int id;

        Namespace(int i) {
            this.id = i;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int getId() {
            return this.id;
        }
    }

    public LocalSocketAddress(String str) {
        this(str, Namespace.ABSTRACT);
    }

    public LocalSocketAddress(String str, Namespace namespace) {
        this.name = str;
        this.namespace = namespace;
    }

    public String getName() {
        return this.name;
    }

    public Namespace getNamespace() {
        return this.namespace;
    }
}
