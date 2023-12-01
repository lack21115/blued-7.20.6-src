package com.android.internal.util.cm;

import android.app.Notification;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/util/cm/SpamFilter.class */
public class SpamFilter {
    public static final String MESSAGE_PATH = "message";
    public static final String AUTHORITY = "com.cyanogenmod.spam";
    public static final Uri NOTIFICATION_URI = new Uri.Builder().scheme("content").authority(AUTHORITY).appendEncodedPath("message").build();

    /* loaded from: source-4181928-dex2jar.jar:com/android/internal/util/cm/SpamFilter$SpamContract.class */
    public static final class SpamContract {

        /* loaded from: source-4181928-dex2jar.jar:com/android/internal/util/cm/SpamFilter$SpamContract$NotificationTable.class */
        public static final class NotificationTable {
            public static final String COUNT = "count";
            public static final String ID = "_id";
            public static final String LAST_BLOCKED = "last_blocked";
            public static final String MESSAGE_TEXT = "message_text";
            public static final String NORMALIZED_TEXT = "normalized_text";
            public static final String PACKAGE_ID = "package_id";
            public static final String TABLE_NAME = "notifications";
        }

        /* loaded from: source-4181928-dex2jar.jar:com/android/internal/util/cm/SpamFilter$SpamContract$PackageTable.class */
        public static final class PackageTable {
            public static final String ID = "_id";
            public static final String PACKAGE_NAME = "package_name";
            public static final String TABLE_NAME = "packages";
        }
    }

    public static String getNormalizedContent(String str) {
        return str.toLowerCase().replaceAll("[^\\p{L}\\p{Nd}]+", "");
    }

    public static String getNormalizedNotificationContent(Notification notification) {
        return getNormalizedContent(getNotificationContent(notification));
    }

    public static String getNotificationContent(Notification notification) {
        Bundle bundle = notification.extras;
        CharSequence charSequence = bundle.getCharSequence(bundle.containsKey("android.title.big") ? "android.title.big" : "android.title");
        CharSequence charSequence2 = bundle.getCharSequence("android.text");
        String str = charSequence2;
        if (TextUtils.isEmpty(charSequence2)) {
            CharSequence[] charSequenceArray = bundle.getCharSequenceArray("android.textLines");
            str = (charSequenceArray == null || charSequenceArray.length == 0) ? "" : TextUtils.join("\n", charSequenceArray);
        }
        return ((Object) charSequence) + "\n" + ((Object) str);
    }
}
