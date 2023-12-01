package com.kwad.components.core.offline.api.a.kwai;

import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/offline/api/a/kwai/a.class */
public final class a {
    private static final Map<Integer, AdTemplate> Kc = new HashMap();

    public static void a(int i, AdTemplate adTemplate) {
        Kc.put(Integer.valueOf(i), adTemplate);
    }

    public static AdTemplate av(int i) {
        return Kc.get(Integer.valueOf(i));
    }

    public static void aw(int i) {
        Kc.remove(Integer.valueOf(i));
    }
}
