package com.bytedance.pangle.receiver;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.pangle.util.FieldUtils;
import com.igexin.assist.util.AssistUtils;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/pangle/receiver/b.class */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static final c f7858a;

    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/pangle/receiver/b$a.class */
    static class a implements c {
        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        static Object a(Context context, String str) {
            return a(b(context), str);
        }

        private static Object a(Object obj, String str) {
            if (obj != null) {
                try {
                    return FieldUtils.readField(obj, str);
                } catch (Throwable th) {
                    return null;
                }
            }
            return null;
        }

        private static Object b(Context context) {
            Field field;
            Object readField;
            try {
                Field field2 = FieldUtils.getField(Class.forName("android.app.LoadedApk"), "mReceiverResource");
                if (field2 == null || (field = FieldUtils.getField(Class.forName("android.app.ContextImpl"), "mPackageInfo")) == null || (readField = FieldUtils.readField(field, context)) == null) {
                    return null;
                }
                return FieldUtils.readField(field2, readField);
            } catch (Throwable th) {
                return null;
            }
        }

        @Override // com.bytedance.pangle.receiver.b.c
        public boolean a(Context context) {
            Object b = b(context);
            Object a2 = a(b, "mWhiteList");
            if (!(a2 instanceof String[])) {
                if (b != null) {
                    FieldUtils.writeField(b, "mResourceConfig", (Object) null);
                    return false;
                }
                return false;
            }
            String[] strArr = (String[]) a2;
            ArrayList arrayList = new ArrayList();
            arrayList.add(context.getPackageName());
            Collections.addAll(arrayList, strArr);
            FieldUtils.writeField(b, "mWhiteList", arrayList.toArray(new String[arrayList.size()]));
            return true;
        }
    }

    /* renamed from: com.bytedance.pangle.receiver.b$b  reason: collision with other inner class name */
    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/pangle/receiver/b$b.class */
    static final class C0150b extends e {
        private C0150b() {
            super((byte) 0);
        }

        /* synthetic */ C0150b(byte b) {
            this();
        }

        @Override // com.bytedance.pangle.receiver.b.e, com.bytedance.pangle.receiver.b.a, com.bytedance.pangle.receiver.b.c
        public final boolean a(Context context) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/pangle/receiver/b$c.class */
    public interface c {
        boolean a(Context context);
    }

    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/pangle/receiver/b$d.class */
    static final class d extends a {
        private d() {
            super((byte) 0);
        }

        /* synthetic */ d(byte b) {
            this();
        }

        @Override // com.bytedance.pangle.receiver.b.a, com.bytedance.pangle.receiver.b.c
        public final boolean a(Context context) {
            Object a2 = a(context, "mWhiteList");
            if (a2 instanceof List) {
                ((List) a2).add(context.getPackageName());
                return true;
            }
            return false;
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/pangle/receiver/b$e.class */
    static class e extends a {
        private e() {
            super((byte) 0);
        }

        /* synthetic */ e(byte b) {
            this();
        }

        @Override // com.bytedance.pangle.receiver.b.a, com.bytedance.pangle.receiver.b.c
        public boolean a(Context context) {
            Object a2 = a(context, "mWhiteListMap");
            if (a2 instanceof Map) {
                Map map = (Map) a2;
                List list = (List) map.get(0);
                ArrayList arrayList = list;
                if (list == null) {
                    arrayList = new ArrayList();
                    map.put(0, arrayList);
                }
                arrayList.add(context.getPackageName());
                return true;
            }
            return false;
        }
    }

    static {
        int i = Build.VERSION.SDK_INT;
        if (i < 24) {
            f7858a = new a((byte) 0);
        } else if (i < 26) {
            f7858a = new d((byte) 0);
        } else if (i < 28) {
            f7858a = new e((byte) 0);
        } else {
            f7858a = new C0150b((byte) 0);
        }
    }

    public static void a(Application application) {
        if (application != null) {
            try {
                if (TextUtils.equals(Build.BRAND.toLowerCase(), AssistUtils.BRAND_HW)) {
                    f7858a.a(application.getBaseContext());
                }
            } catch (Throwable th) {
            }
        }
    }
}
