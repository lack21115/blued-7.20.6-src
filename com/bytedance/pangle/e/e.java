package com.bytedance.pangle.e;

import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ResultReceiver;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.e.f;
import com.bytedance.pangle.util.FieldUtils;
import com.bytedance.pangle.util.MethodUtils;
import java.io.File;
import java.io.FileDescriptor;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/pangle/e/e.class */
public final class e implements f.a {

    /* renamed from: a  reason: collision with root package name */
    private static volatile IBinder f21385a;
    private static volatile Object b;

    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/pangle/e/e$a.class */
    public interface a {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/pangle/e/e$b.class */
    public static final class b extends ResultReceiver {

        /* renamed from: a  reason: collision with root package name */
        private a f21386a;

        public b() {
            super((Handler) null);
            this.f21386a = null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.ResultReceiver
        public final void onReceiveResult(int i, Bundle bundle) {
            super.onReceiveResult(i, bundle);
        }
    }

    private static Object a(Object obj, String str, Object[] objArr, Class<?>[] clsArr) {
        try {
            return MethodUtils.invokeMethod(obj, str, objArr, clsArr);
        } catch (Exception e) {
            return null;
        }
    }

    private static Object a(Field field, Object obj) {
        try {
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }
            Object obj2 = field.get(obj);
            field.setAccessible(false);
            return obj2;
        } catch (Exception e) {
            return null;
        }
    }

    private static void a(String[] strArr) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeFileDescriptor(FileDescriptor.f42253in);
        obtain.writeFileDescriptor(FileDescriptor.out);
        obtain.writeFileDescriptor(FileDescriptor.err);
        obtain.writeStringArray(strArr);
        obtain.writeStrongBinder(null);
        new b().writeToParcel(obtain, 0);
        try {
            f21385a.transact(1598246212, obtain, obtain2, 0);
            obtain2.readException();
        } catch (Exception e) {
        } catch (Throwable th) {
            obtain.recycle();
            obtain2.recycle();
            throw th;
        }
        obtain.recycle();
        obtain2.recycle();
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0000, code lost:
        continue;
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0085  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String e1672829046107dc(java.lang.String r5) {
        /*
        L0:
            r0 = 73
            r6 = r0
            r0 = 96
            r7 = r0
        L6:
            r0 = r6
            switch(r0) {
                case 72: goto L85;
                case 73: goto L23;
                case 74: goto L40;
                default: goto L20;
            }
        L20:
            goto L8e
        L23:
            r0 = r7
            switch(r0) {
                case 94: goto L0;
                case 95: goto L85;
                case 96: goto L85;
                default: goto L40;
            }
        L40:
            r0 = r7
            switch(r0) {
                case 55: goto L5f;
                case 56: goto L85;
                case 57: goto L85;
                default: goto L5c;
            }
        L5c:
            goto L0
        L5f:
            r0 = r5
            char[] r0 = r0.toCharArray()
            r5 = r0
            r0 = 0
            r6 = r0
        L66:
            r0 = r6
            r1 = r5
            int r1 = r1.length
            if (r0 >= r1) goto L7c
            r0 = r5
            r1 = r6
            r2 = r5
            r3 = r6
            char r2 = r2[r3]
            r3 = r6
            r2 = r2 ^ r3
            char r2 = (char) r2
            r0[r1] = r2
            r0 = r6
            r1 = 1
            int r0 = r0 + r1
            r6 = r0
            goto L66
        L7c:
            java.lang.String r0 = new java.lang.String
            r1 = r0
            r2 = r5
            r1.<init>(r2)
            return r0
        L85:
            r0 = 74
            r6 = r0
            r0 = 55
            r7 = r0
            goto L6
        L8e:
            r0 = 72
            r6 = r0
            goto L6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.pangle.e.e.e1672829046107dc(java.lang.String):java.lang.String");
    }

    @Override // com.bytedance.pangle.e.f.a
    public final boolean a(String str, int i) {
        boolean z;
        IBinder asBinder;
        if (f21385a == null) {
            PackageManager packageManager = Zeus.getAppApplication().getPackageManager();
            Field field = packageManager == null ? null : FieldUtils.getField(packageManager.getClass(), "mPM");
            if (field != null) {
                Object a2 = a(field, packageManager);
                b = a2;
                if ((a2 instanceof IInterface) && (asBinder = ((IInterface) b).asBinder()) != null) {
                    f21385a = asBinder;
                }
            }
        }
        if (str != null) {
            String b2 = com.bytedance.pangle.d.c.b(str, i);
            String e = com.bytedance.pangle.d.c.e(str, i);
            try {
                com.bytedance.pangle.util.h.a(b2, e);
            } catch (Exception e2) {
            }
            String packageName = Zeus.getAppApplication().getPackageName();
            String a3 = com.bytedance.pangle.e.b.a();
            if (Build.VERSION.SDK_INT == 30) {
                if (b != null && packageName != null && e != null && a3 != null) {
                    a(b, "notifyDexLoad", new Object[]{packageName, Collections.singletonMap(e, "PCL[]"), a3}, new Class[]{String.class, Map.class, String.class});
                }
            } else if (Build.VERSION.SDK_INT == 29 && b != null && packageName != null && e != null && a3 != null) {
                a(b, "notifyDexLoad", new Object[]{packageName, Collections.singletonList("dalvik.system.DexClassLoader"), Collections.singletonList(e), a3}, new Class[]{String.class, List.class, List.class, String.class});
            }
        }
        String e3 = com.bytedance.pangle.d.c.e(str, i);
        String str2 = com.bytedance.pangle.d.c.h(str, i) + File.separator + com.bytedance.pangle.e.b.a(e3);
        int i2 = 1;
        while (true) {
            int i3 = i2;
            if (i3 > 3) {
                z = false;
                break;
            }
            a(new String[]{"compile", "-m", "speed", "-f", "--secondary-dex", Zeus.getAppApplication().getPackageName()});
            if (com.bytedance.pangle.e.b.a(str2)) {
                z = true;
                break;
            }
            i2 = i3 + 1;
        }
        if (str != null) {
            try {
                com.bytedance.pangle.util.g.a(com.bytedance.pangle.d.c.g(str, i), com.bytedance.pangle.d.c.f(str, i));
            } catch (Exception e4) {
            }
            try {
                File file = new File(com.bytedance.pangle.d.c.e(str, i));
                if (file.exists()) {
                    file.delete();
                }
            } catch (Exception e5) {
            }
            a(new String[]{"reconcile-secondary-dex-files", Zeus.getAppApplication().getPackageName()});
        }
        return z;
    }
}
