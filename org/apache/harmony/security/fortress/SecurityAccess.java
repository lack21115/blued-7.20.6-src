package org.apache.harmony.security.fortress;

import java.security.Provider;
import java.util.List;

/* loaded from: source-2895416-dex2jar.jar:org/apache/harmony/security/fortress/SecurityAccess.class */
public interface SecurityAccess {
    List<String> getAliases(Provider.Service service);

    Provider.Service getService(Provider provider, String str);

    void renumProviders();
}
