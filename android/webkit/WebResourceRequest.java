package android.webkit;

import android.net.Uri;
import java.util.Map;

/* loaded from: source-4181928-dex2jar.jar:android/webkit/WebResourceRequest.class */
public interface WebResourceRequest {
    String getMethod();

    Map<String, String> getRequestHeaders();

    Uri getUrl();

    boolean hasGesture();

    boolean isForMainFrame();
}
