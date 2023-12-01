package com.getui.gtc.dim;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.getui.gtc.base.GtcProvider;
import com.getui.gtc.base.ProcessSwitchContract;
import com.getui.gtc.base.crypt.CryptTools;
import com.getui.gtc.base.publish.Broker;
import com.getui.gtc.base.publish.Subscriber;
import com.getui.gtc.base.util.CommonUtil;
import com.getui.gtc.dim.DimRequest;
import com.getui.gtc.dim.a;
import com.getui.gtc.dim.b.e;
import com.getui.gtc.dim.e.b;
import com.getui.gtc.dim.e.c;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;

/* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/dim/DimManager.class */
public class DimManager implements Subscriber {
    private static String methodName;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/dim/DimManager$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private static final DimManager f8322a = new DimManager();
    }

    private DimManager() {
    }

    private Bundle createBundle() {
        Bundle bundle = new Bundle();
        bundle.putString(ProcessSwitchContract.CLASS_NAME, getClass().getName());
        bundle.putString(ProcessSwitchContract.GET_INSTANCE, methodName);
        return bundle;
    }

    public static DimManager getInstance() {
        methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
        return a.f8322a;
    }

    private void notifyGdiLoadSuccess(Class<?> cls) {
        com.getui.gtc.dim.a aVar;
        aVar = a.C0173a.f8325a;
        e eVar = aVar.f8324c;
        if (cls != null) {
            try {
                if (cls.getName().equals(new String(Base64.decode("Y29tLmlnZXhpbi5wdXNoLmV4dGVuc2lvbi5kaXN0cmlidXRpb24uZ2RpLnN0dWIuUHVzaEV4dGVuc2lvbg==", 2)))) {
                    eVar.f = cls.getDeclaredMethod(MonitorConstants.CONNECT_TYPE_GET, Bundle.class);
                    eVar.g = cls.getDeclaredMethod("updateRuntimeData", String.class);
                    return;
                }
            } catch (Throwable th) {
                b.a("notifyGdiLoadSuccess error", th);
                return;
            }
        }
        throw new IllegalArgumentException("not support class:".concat(String.valueOf(cls)));
    }

    public Object get(DimRequest dimRequest) {
        com.getui.gtc.dim.a aVar;
        if (CommonUtil.isGtcProcess()) {
            aVar = a.C0173a.f8325a;
            return aVar.a(dimRequest, true);
        }
        Bundle createBundle = createBundle();
        createBundle.putString(ProcessSwitchContract.METHOD_NAME, "dim-1-1-1");
        createBundle.putParcelable("dim-1-1-2", dimRequest);
        Object obj = Broker.getInstance().subscribe(createBundle).get(ProcessSwitchContract.METHOD_RETURN);
        Object obj2 = obj;
        if (obj instanceof File) {
            try {
                byte[] a2 = c.a((File) obj);
                ((File) obj).delete();
                return c.a(a2);
            } catch (Throwable th) {
                obj2 = null;
            }
        }
        return obj2;
    }

    public Object get(String str) {
        return get(new DimRequest.Builder().key(str).build());
    }

    @Override // com.getui.gtc.base.publish.Subscriber
    public void receive(Bundle bundle, Bundle bundle2) {
        File file;
        ArrayList<Throwable> arrayList = new ArrayList();
        try {
            Throwable th = (Throwable) bundle2.getSerializable(ProcessSwitchContract.METHOD_EXCEPTION);
            if (th != null) {
                arrayList.add(th);
            }
            String string = bundle.getString(ProcessSwitchContract.METHOD_NAME);
            if (TextUtils.isEmpty(string)) {
                throw new RuntimeException("methodName missed");
            }
            boolean z = true;
            int hashCode = string.hashCode();
            if (hashCode != 1538245748) {
                if (hashCode == 1538246709 && string.equals("dim-1-2-1")) {
                    z = true;
                }
            } else if (string.equals("dim-1-1-1")) {
                z = false;
            }
            if (!z) {
                Object obj = get((DimRequest) bundle.getParcelable("dim-1-1-2"));
                if (obj != null) {
                    byte[] b = c.b(obj);
                    if (b.length > 204800) {
                        File file2 = new File(GtcProvider.context().getCacheDir(), CryptTools.digestToHexString("MD5", b));
                        boolean a2 = c.a(b, file2);
                        file = file2;
                        if (!a2) {
                            throw new RuntimeException("failed to save dim result bytes to file");
                        }
                    } else {
                        if (obj instanceof Parcelable) {
                            bundle2.putParcelable(ProcessSwitchContract.METHOD_RETURN, (Parcelable) obj);
                        }
                        if (obj instanceof Serializable) {
                            file = (Serializable) obj;
                        }
                    }
                    bundle2.putSerializable(ProcessSwitchContract.METHOD_RETURN, file);
                }
            } else if (z) {
                set(bundle.getString("dim-1-2-2"), bundle.getString("dim-1-2-3"), bundle.getString("dim-1-2-4"));
            }
        } catch (Throwable th2) {
            try {
                arrayList.add(th2);
                for (Throwable th3 : arrayList) {
                    b.a(th3);
                }
            } finally {
                for (Throwable th4 : arrayList) {
                    b.a(th4);
                }
            }
        }
    }

    public void set(String str, String str2, String str3) {
        com.getui.gtc.dim.a aVar;
        if (!CommonUtil.isGtcProcess()) {
            Bundle createBundle = createBundle();
            createBundle.putString(ProcessSwitchContract.METHOD_NAME, "dim-1-2-1");
            createBundle.putString("dim-1-2-2", str);
            createBundle.putString("dim-1-2-3", str2);
            createBundle.putString("dim-1-2-4", str3);
            Broker.getInstance().subscribe(createBundle);
            return;
        }
        aVar = a.C0173a.f8325a;
        boolean z = true;
        try {
            boolean z2 = false;
            switch (str.hashCode()) {
                case 1673842650:
                    if (str.equals("dim-2-2-1-1")) {
                        z = false;
                        break;
                    }
                    break;
                case 1673843611:
                    if (str.equals("dim-2-2-2-1")) {
                        z = true;
                        break;
                    }
                    break;
                case 1673847455:
                    if (str.equals("dim-2-2-6-1")) {
                        z = true;
                        break;
                    }
                    break;
                case 1673848416:
                    if (str.equals("dim-2-2-7-1")) {
                        z = true;
                        break;
                    }
                    break;
            }
            if (!z) {
                com.getui.gtc.dim.b.a aVar2 = aVar.f8323a;
                long parseLong = Long.parseLong(str3);
                if (TextUtils.isEmpty(str2)) {
                    return;
                }
                aVar2.f8327a.put(str2, Long.valueOf(parseLong));
                b.a("dim ram globalValidTime set: " + str2 + " : " + parseLong);
            } else if (z) {
                com.getui.gtc.dim.b.b bVar = aVar.b;
                long parseLong2 = Long.parseLong(str3);
                if (TextUtils.isEmpty(str2)) {
                    return;
                }
                bVar.f8329a.put(str2, Long.valueOf(parseLong2));
                b.a("dim storage globalValidTime set: " + str2 + " : " + parseLong2);
            } else if (z) {
                aVar.a(str2, str3);
            } else if (!z) {
                aVar.f8324c.a(str, str2, str3);
            } else {
                int parseInt = Integer.parseInt(str3);
                Map<String, Boolean> map = aVar.d;
                if (parseInt != 0) {
                    z2 = true;
                }
                map.put(str2, Boolean.valueOf(z2));
                b.a("dim use expired enable set: " + str2 + " : " + parseInt);
            }
        } catch (Throwable th) {
            b.b(th);
        }
    }

    public boolean setAppDataProvider(Context context, AppDataProvider appDataProvider) {
        com.getui.gtc.dim.a aVar;
        if (context == null) {
            Log.e("DimManager", "setAppDataProvider failed,because context==null");
            return false;
        }
        GtcProvider.setContext(context);
        aVar = a.C0173a.f8325a;
        aVar.f8324c.a(appDataProvider);
        return true;
    }
}
