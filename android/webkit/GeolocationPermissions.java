package android.webkit;

import java.util.Set;

/* loaded from: source-4181928-dex2jar.jar:android/webkit/GeolocationPermissions.class */
public class GeolocationPermissions {

    /* loaded from: source-4181928-dex2jar.jar:android/webkit/GeolocationPermissions$Callback.class */
    public interface Callback {
        void invoke(String str, boolean z, boolean z2);
    }

    public static GeolocationPermissions getInstance() {
        return WebViewFactory.getProvider().getGeolocationPermissions();
    }

    public void allow(String str) {
    }

    public void clear(String str) {
    }

    public void clearAll() {
    }

    public void getAllowed(String str, ValueCallback<Boolean> valueCallback) {
    }

    public void getOrigins(ValueCallback<Set<String>> valueCallback) {
    }
}
