package javax.net.ssl;

import java.security.KeyStore;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: source-2895416-dex2jar.jar:javax/net/ssl/KeyStoreBuilderParameters.class */
public class KeyStoreBuilderParameters implements ManagerFactoryParameters {
    private final List<KeyStore.Builder> ksbuilders;

    public KeyStoreBuilderParameters(KeyStore.Builder builder) {
        if (builder == null) {
            throw new NullPointerException("builder == null");
        }
        this.ksbuilders = Collections.singletonList(builder);
    }

    public KeyStoreBuilderParameters(List<KeyStore.Builder> list) {
        if (list == null) {
            throw new NullPointerException("parameters == null");
        }
        if (list.isEmpty()) {
            throw new IllegalArgumentException("parameters.isEmpty()");
        }
        this.ksbuilders = Collections.unmodifiableList(new ArrayList(list));
    }

    public List<KeyStore.Builder> getParameters() {
        return this.ksbuilders;
    }
}
