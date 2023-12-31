package androidx.core.content;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import androidx.core.util.Preconditions;

/* loaded from: source-8756600-dex2jar.jar:androidx/core/content/IntentCompat.class */
public final class IntentCompat {
    public static final String ACTION_CREATE_REMINDER = "android.intent.action.CREATE_REMINDER";
    public static final String CATEGORY_LEANBACK_LAUNCHER = "android.intent.category.LEANBACK_LAUNCHER";
    public static final String EXTRA_HTML_TEXT = "android.intent.extra.HTML_TEXT";
    public static final String EXTRA_START_PLAYBACK = "android.intent.extra.START_PLAYBACK";
    public static final String EXTRA_TIME = "android.intent.extra.TIME";

    private IntentCompat() {
    }

    public static Intent createManageUnusedAppRestrictionsIntent(Context context, String str) {
        if (PackageManagerCompat.areUnusedAppRestrictionsAvailable(context.getPackageManager())) {
            if (Build.VERSION.SDK_INT >= 31) {
                return new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS).setData(Uri.fromParts("package", str, null));
            }
            Intent data = new Intent(PackageManagerCompat.ACTION_PERMISSION_REVOCATION_SETTINGS).setData(Uri.fromParts("package", str, null));
            return Build.VERSION.SDK_INT >= 30 ? data : data.setPackage((String) Preconditions.checkNotNull(PackageManagerCompat.getPermissionRevocationVerifierApp(context.getPackageManager())));
        }
        throw new UnsupportedOperationException("Unused App Restriction features are not available on this device");
    }

    public static Intent makeMainSelectorActivity(String str, String str2) {
        if (Build.VERSION.SDK_INT >= 15) {
            return Intent.makeMainSelectorActivity(str, str2);
        }
        Intent intent = new Intent(str);
        intent.addCategory(str2);
        return intent;
    }
}
