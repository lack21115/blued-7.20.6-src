package com.kwad.sdk.utils;

import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/utils/ah.class */
public final class ah {
    public static boolean D(List<?> list) {
        return (list == null || list.isEmpty()) ? false : true;
    }

    public static void checkUiThread() {
        SystemUtil.checkUiThread();
    }
}
