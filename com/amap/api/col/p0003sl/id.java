package com.amap.api.col.p0003sl;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.Settings;
import android.text.TextUtils;
import java.lang.ref.WeakReference;
import java.util.List;

/* renamed from: com.amap.api.col.3sl.id  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/id.class */
public final class id {

    /* renamed from: a  reason: collision with root package name */
    public static final String f5142a = ib.c("SU2hhcmVkUHJlZmVyZW5jZUFkaXU");
    private static id f;
    private List<String> b;

    /* renamed from: c  reason: collision with root package name */
    private String f5143c;
    private final Context d;
    private final Handler e;

    /* renamed from: com.amap.api.col.3sl.id$a */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/id$a.class */
    static final class a extends Handler {

        /* renamed from: a  reason: collision with root package name */
        private final WeakReference<id> f5146a;

        a(Looper looper, id idVar) {
            super(looper);
            this.f5146a = new WeakReference<>(idVar);
        }

        a(id idVar) {
            this.f5146a = new WeakReference<>(idVar);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            id idVar = this.f5146a.get();
            if (idVar == null || message == null || message.obj == null) {
                return;
            }
            idVar.a((String) message.obj, message.what);
        }
    }

    private id(Context context) {
        this.d = context.getApplicationContext();
        if (Looper.myLooper() == null) {
            this.e = new a(Looper.getMainLooper(), this);
        } else {
            this.e = new a(this);
        }
    }

    public static id a(Context context) {
        if (f == null) {
            synchronized (id.class) {
                try {
                    if (f == null) {
                        f = new id(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final String str, final int i) {
        synchronized (this) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                new Thread() { // from class: com.amap.api.col.3sl.id.1
                    @Override // java.lang.Thread, java.lang.Runnable
                    public final void run() {
                        String b = ij.b(str);
                        if (TextUtils.isEmpty(b)) {
                            return;
                        }
                        if ((i & 1) > 0) {
                            try {
                                if (Build.VERSION.SDK_INT < 23) {
                                    Settings.System.putString(id.this.d.getContentResolver(), id.this.f5143c, b);
                                } else if (Settings.System.canWrite(id.this.d)) {
                                    Settings.System.putString(id.this.d.getContentResolver(), id.this.f5143c, b);
                                }
                            } catch (Exception e) {
                            }
                        }
                        if ((i & 16) > 0) {
                            Cif.a(id.this.d, id.this.f5143c, b);
                        }
                        if ((i & 256) > 0) {
                            SharedPreferences.Editor edit = id.this.d.getSharedPreferences(id.f5142a, 0).edit();
                            edit.putString(id.this.f5143c, b);
                            if (Build.VERSION.SDK_INT >= 9) {
                                edit.apply();
                            } else {
                                edit.commit();
                            }
                        }
                    }
                }.start();
                return;
            }
            String b = ij.b(str);
            if (!TextUtils.isEmpty(b)) {
                if ((i & 1) > 0) {
                    try {
                        if (Build.VERSION.SDK_INT >= 23) {
                            Settings.System.putString(this.d.getContentResolver(), this.f5143c, b);
                        } else {
                            Settings.System.putString(this.d.getContentResolver(), this.f5143c, b);
                        }
                    } catch (Exception e) {
                    }
                }
                if ((i & 16) > 0) {
                    Cif.a(this.d, this.f5143c, b);
                }
                if ((i & 256) > 0) {
                    SharedPreferences.Editor edit = this.d.getSharedPreferences(f5142a, 0).edit();
                    edit.putString(this.f5143c, b);
                    if (Build.VERSION.SDK_INT >= 9) {
                        edit.apply();
                        return;
                    }
                    edit.commit();
                }
            }
        }
    }

    public final void a(String str) {
        this.f5143c = str;
    }

    public final void b(String str) {
        List<String> list = this.b;
        if (list != null) {
            list.clear();
            this.b.add(str);
        }
        a(str, 273);
    }
}
