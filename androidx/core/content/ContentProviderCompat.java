package androidx.core.content;

import android.content.ContentProvider;
import android.content.Context;

/* loaded from: source-8756600-dex2jar.jar:androidx/core/content/ContentProviderCompat.class */
public final class ContentProviderCompat {
    private ContentProviderCompat() {
    }

    public static Context requireContext(ContentProvider contentProvider) {
        Context context = contentProvider.getContext();
        if (context != null) {
            return context;
        }
        throw new IllegalStateException("Cannot find context from the provider.");
    }
}
