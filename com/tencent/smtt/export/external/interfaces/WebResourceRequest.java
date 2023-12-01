package com.tencent.smtt.export.external.interfaces;

import android.net.Uri;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/export/external/interfaces/WebResourceRequest.class */
public interface WebResourceRequest {
    String getMethod();

    Map<String, String> getRequestHeaders();

    Uri getUrl();

    boolean hasGesture();

    boolean isForMainFrame();

    boolean isRedirect();
}
