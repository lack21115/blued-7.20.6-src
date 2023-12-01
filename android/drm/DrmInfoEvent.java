package android.drm;

import java.util.HashMap;

/* loaded from: source-9557208-dex2jar.jar:android/drm/DrmInfoEvent.class */
public class DrmInfoEvent extends DrmEvent {
    public static final int TYPE_ACCOUNT_ALREADY_REGISTERED = 5;
    public static final int TYPE_ALREADY_REGISTERED_BY_ANOTHER_ACCOUNT = 1;
    public static final int TYPE_REMOVE_RIGHTS = 2;
    public static final int TYPE_RIGHTS_INSTALLED = 3;
    public static final int TYPE_RIGHTS_REMOVED = 6;
    public static final int TYPE_WAIT_FOR_RIGHTS = 4;

    public DrmInfoEvent(int i, int i2, String str) {
        super(i, i2, str);
        checkTypeValidity(i2);
    }

    public DrmInfoEvent(int i, int i2, String str, HashMap<String, Object> hashMap) {
        super(i, i2, str, hashMap);
        checkTypeValidity(i2);
    }

    private void checkTypeValidity(int i) {
        if ((i < 1 || i > 6) && i != 1001 && i != 1002) {
            throw new IllegalArgumentException("Unsupported type: " + i);
        }
    }
}
