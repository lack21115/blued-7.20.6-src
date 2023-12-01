package android.service.fingerprint;

import android.content.ContentResolver;
import android.content.Context;
import android.hardware.fingerprint.Fingerprint;
import android.provider.Settings;
import com.android.internal.R;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/* loaded from: source-9557208-dex2jar.jar:android/service/fingerprint/FingerprintUtils.class */
public class FingerprintUtils {
    private static final boolean DEBUG = false;
    private static final String TAG = "FingerprintUtils";

    public static void addFingerprintIdForUser(int i, Context context, int i2) {
        if (i == 0) {
            return;
        }
        List<Fingerprint> fingerprintsForUser = getFingerprintsForUser(context.getContentResolver(), i2);
        for (Fingerprint fingerprint : fingerprintsForUser) {
            if (fingerprint.getFingerId().intValue() == i) {
                return;
            }
        }
        fingerprintsForUser.add(new Fingerprint(context.getString(R.string.fingerprint_default_name, Integer.valueOf(i)), Integer.valueOf(i), Integer.valueOf(i2)));
        saveFingerprints(fingerprintsForUser, context.getContentResolver(), i2);
    }

    public static List<Fingerprint> getFingerprintsForUser(ContentResolver contentResolver, int i) {
        List<Fingerprint> fromJson = Fingerprint.JsonSerializer.fromJson(Settings.Global.getString(contentResolver, Settings.Global.USER_FINGERPRINTS));
        Iterator<Fingerprint> it = fromJson.iterator();
        while (it.hasNext()) {
            if (it.next().getUserId().intValue() != i) {
                it.remove();
            }
        }
        return fromJson;
    }

    public static boolean removeFingerprintIdForUser(int i, ContentResolver contentResolver, int i2) {
        if (i == 0) {
            throw new IllegalStateException("Bad fingerId");
        }
        List<Fingerprint> fingerprintsForUser = getFingerprintsForUser(contentResolver, i2);
        Iterator<Fingerprint> it = fingerprintsForUser.iterator();
        while (it.hasNext()) {
            if (it.next().getFingerId().intValue() == i) {
                it.remove();
            }
        }
        saveFingerprints(fingerprintsForUser, contentResolver, i2);
        return true;
    }

    public static void saveFingerprints(List<Fingerprint> list, ContentResolver contentResolver, int i) {
        Settings.Global.putString(contentResolver, Settings.Global.USER_FINGERPRINTS, Fingerprint.JsonSerializer.toJson(list));
    }

    public static void setFingerprintName(int i, String str, ContentResolver contentResolver, int i2) {
        if (i == 0) {
            throw new IllegalStateException("Bad fingerId");
        }
        List<Fingerprint> fingerprintsForUser = getFingerprintsForUser(contentResolver, i2);
        ListIterator<Fingerprint> listIterator = fingerprintsForUser.listIterator();
        while (listIterator.hasNext()) {
            Fingerprint next = listIterator.next();
            if (next.getFingerId().intValue() == i) {
                Fingerprint.Builder builder = new Fingerprint.Builder(next);
                builder.name(str);
                listIterator.set(builder.build());
            }
        }
        saveFingerprints(fingerprintsForUser, contentResolver, i2);
    }
}
