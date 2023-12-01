package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.util.SparseArray;
import androidx.core.app.NotificationCompat;
import androidx.core.graphics.drawable.IconCompat;
import com.huawei.openalliance.ad.constant.ao;
import com.igexin.assist.sdk.AssistPushConsts;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8756600-dex2jar.jar:androidx/core/app/NotificationCompatJellybean.class */
public class NotificationCompatJellybean {
    public static final String TAG = "NotificationCompat";
    private static Field b;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f2374c;
    private static Field e;
    private static Field f;
    private static Field g;
    private static Field h;
    private static boolean i;

    /* renamed from: a  reason: collision with root package name */
    private static final Object f2373a = new Object();
    private static final Object d = new Object();

    private NotificationCompatJellybean() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Bundle a(NotificationCompat.Action action) {
        Bundle bundle = new Bundle();
        IconCompat iconCompat = action.getIconCompat();
        bundle.putInt("icon", iconCompat != null ? iconCompat.getResId() : 0);
        bundle.putCharSequence("title", action.getTitle());
        bundle.putParcelable("actionIntent", action.getActionIntent());
        Bundle bundle2 = action.getExtras() != null ? new Bundle(action.getExtras()) : new Bundle();
        bundle2.putBoolean("android.support.allowGeneratedReplies", action.getAllowGeneratedReplies());
        bundle.putBundle(ao.K, bundle2);
        bundle.putParcelableArray("remoteInputs", a(action.getRemoteInputs()));
        bundle.putBoolean("showsUserInterface", action.getShowsUserInterface());
        bundle.putInt("semanticAction", action.getSemanticAction());
        return bundle;
    }

    private static Bundle a(RemoteInput remoteInput) {
        Bundle bundle = new Bundle();
        bundle.putString("resultKey", remoteInput.getResultKey());
        bundle.putCharSequence("label", remoteInput.getLabel());
        bundle.putCharSequenceArray("choices", remoteInput.getChoices());
        bundle.putBoolean("allowFreeFormInput", remoteInput.getAllowFreeFormInput());
        bundle.putBundle(ao.K, remoteInput.getExtras());
        Set<String> allowedDataTypes = remoteInput.getAllowedDataTypes();
        if (allowedDataTypes != null && !allowedDataTypes.isEmpty()) {
            ArrayList<String> arrayList = new ArrayList<>(allowedDataTypes.size());
            for (String str : allowedDataTypes) {
                arrayList.add(str);
            }
            bundle.putStringArrayList("allowedDataTypes", arrayList);
        }
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static NotificationCompat.Action a(Bundle bundle) {
        Bundle bundle2 = bundle.getBundle(ao.K);
        return new NotificationCompat.Action(bundle.getInt("icon"), bundle.getCharSequence("title"), (PendingIntent) bundle.getParcelable("actionIntent"), bundle.getBundle(ao.K), a(a(bundle, "remoteInputs")), a(a(bundle, "dataOnlyRemoteInputs")), bundle2 != null ? bundle2.getBoolean("android.support.allowGeneratedReplies", false) : false, bundle.getInt("semanticAction"), bundle.getBoolean("showsUserInterface"), false);
    }

    private static boolean a() {
        if (i) {
            return false;
        }
        try {
            if (e == null) {
                Class<?> cls = Class.forName("android.app.Notification$Action");
                f = cls.getDeclaredField("icon");
                g = cls.getDeclaredField("title");
                h = cls.getDeclaredField("actionIntent");
                Field declaredField = Notification.class.getDeclaredField(AssistPushConsts.MSG_TYPE_ACTIONS);
                e = declaredField;
                declaredField.setAccessible(true);
            }
        } catch (ClassNotFoundException e2) {
            Log.e(TAG, "Unable to access notification actions", e2);
            i = true;
        } catch (NoSuchFieldException e3) {
            Log.e(TAG, "Unable to access notification actions", e3);
            i = true;
        }
        return !i;
    }

    private static Bundle[] a(Bundle bundle, String str) {
        Parcelable[] parcelableArray = bundle.getParcelableArray(str);
        if ((parcelableArray instanceof Bundle[]) || parcelableArray == null) {
            return (Bundle[]) parcelableArray;
        }
        Bundle[] bundleArr = (Bundle[]) Arrays.copyOf(parcelableArray, parcelableArray.length, Bundle[].class);
        bundle.putParcelableArray(str, bundleArr);
        return bundleArr;
    }

    private static Bundle[] a(RemoteInput[] remoteInputArr) {
        if (remoteInputArr == null) {
            return null;
        }
        Bundle[] bundleArr = new Bundle[remoteInputArr.length];
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= remoteInputArr.length) {
                return bundleArr;
            }
            bundleArr[i3] = a(remoteInputArr[i3]);
            i2 = i3 + 1;
        }
    }

    private static RemoteInput[] a(Bundle[] bundleArr) {
        if (bundleArr == null) {
            return null;
        }
        RemoteInput[] remoteInputArr = new RemoteInput[bundleArr.length];
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= bundleArr.length) {
                return remoteInputArr;
            }
            remoteInputArr[i3] = b(bundleArr[i3]);
            i2 = i3 + 1;
        }
    }

    private static Object[] a(Notification notification) {
        synchronized (d) {
            if (a()) {
                try {
                    return (Object[]) e.get(notification);
                } catch (IllegalAccessException e2) {
                    Log.e(TAG, "Unable to access notification actions", e2);
                    i = true;
                    return null;
                }
            }
            return null;
        }
    }

    private static RemoteInput b(Bundle bundle) {
        ArrayList<String> stringArrayList = bundle.getStringArrayList("allowedDataTypes");
        HashSet hashSet = new HashSet();
        if (stringArrayList != null) {
            Iterator<String> it = stringArrayList.iterator();
            while (it.hasNext()) {
                hashSet.add(it.next());
            }
        }
        return new RemoteInput(bundle.getString("resultKey"), bundle.getCharSequence("label"), bundle.getCharSequenceArray("choices"), bundle.getBoolean("allowFreeFormInput"), 0, bundle.getBundle(ao.K), hashSet);
    }

    public static SparseArray<Bundle> buildActionExtrasMap(List<Bundle> list) {
        int size = list.size();
        SparseArray<Bundle> sparseArray = null;
        int i2 = 0;
        while (i2 < size) {
            Bundle bundle = list.get(i2);
            SparseArray<Bundle> sparseArray2 = sparseArray;
            if (bundle != null) {
                sparseArray2 = sparseArray;
                if (sparseArray == null) {
                    sparseArray2 = new SparseArray<>();
                }
                sparseArray2.put(i2, bundle);
            }
            i2++;
            sparseArray = sparseArray2;
        }
        return sparseArray;
    }

    public static NotificationCompat.Action getAction(Notification notification, int i2) {
        SparseArray sparseParcelableArray;
        synchronized (d) {
            try {
                Object[] a2 = a(notification);
                if (a2 != null) {
                    Object obj = a2[i2];
                    Bundle extras = getExtras(notification);
                    return readAction(f.getInt(obj), (CharSequence) g.get(obj), (PendingIntent) h.get(obj), (extras == null || (sparseParcelableArray = extras.getSparseParcelableArray(NotificationCompatExtras.EXTRA_ACTION_EXTRAS)) == null) ? null : (Bundle) sparseParcelableArray.get(i2));
                }
            } catch (IllegalAccessException e2) {
                Log.e(TAG, "Unable to access notification actions", e2);
                i = true;
            }
            return null;
        }
    }

    public static int getActionCount(Notification notification) {
        int length;
        synchronized (d) {
            Object[] a2 = a(notification);
            length = a2 != null ? a2.length : 0;
        }
        return length;
    }

    public static Bundle getExtras(Notification notification) {
        synchronized (f2373a) {
            if (f2374c) {
                return null;
            }
            try {
                if (b == null) {
                    Field declaredField = Notification.class.getDeclaredField(ao.K);
                    if (!Bundle.class.isAssignableFrom(declaredField.getType())) {
                        Log.e(TAG, "Notification.extras field is not of type Bundle");
                        f2374c = true;
                        return null;
                    }
                    declaredField.setAccessible(true);
                    b = declaredField;
                }
                Bundle bundle = (Bundle) b.get(notification);
                Bundle bundle2 = bundle;
                if (bundle == null) {
                    bundle2 = new Bundle();
                    b.set(notification, bundle2);
                }
                return bundle2;
            } catch (IllegalAccessException e2) {
                Log.e(TAG, "Unable to access notification extras", e2);
                f2374c = true;
                return null;
            } catch (NoSuchFieldException e3) {
                Log.e(TAG, "Unable to access notification extras", e3);
                f2374c = true;
                return null;
            }
        }
    }

    public static NotificationCompat.Action readAction(int i2, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle) {
        RemoteInput[] remoteInputArr;
        RemoteInput[] remoteInputArr2;
        boolean z;
        if (bundle != null) {
            remoteInputArr = a(a(bundle, NotificationCompatExtras.EXTRA_REMOTE_INPUTS));
            remoteInputArr2 = a(a(bundle, "android.support.dataRemoteInputs"));
            z = bundle.getBoolean("android.support.allowGeneratedReplies");
        } else {
            remoteInputArr = null;
            remoteInputArr2 = null;
            z = false;
        }
        return new NotificationCompat.Action(i2, charSequence, pendingIntent, bundle, remoteInputArr, remoteInputArr2, z, 0, true, false);
    }

    public static Bundle writeActionAndGetExtras(Notification.Builder builder, NotificationCompat.Action action) {
        IconCompat iconCompat = action.getIconCompat();
        builder.addAction(iconCompat != null ? iconCompat.getResId() : 0, action.getTitle(), action.getActionIntent());
        Bundle bundle = new Bundle(action.getExtras());
        if (action.getRemoteInputs() != null) {
            bundle.putParcelableArray(NotificationCompatExtras.EXTRA_REMOTE_INPUTS, a(action.getRemoteInputs()));
        }
        if (action.getDataOnlyRemoteInputs() != null) {
            bundle.putParcelableArray("android.support.dataRemoteInputs", a(action.getDataOnlyRemoteInputs()));
        }
        bundle.putBoolean("android.support.allowGeneratedReplies", action.getAllowGeneratedReplies());
        return bundle;
    }
}
