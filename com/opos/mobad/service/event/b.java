package com.opos.mobad.service.event;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Parcel;
import android.text.TextUtils;
import android.util.LruCache;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/service/event/b.class */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static volatile b f27343a;
    private Context b;
    private BroadcastReceiver d;

    /* renamed from: c  reason: collision with root package name */
    private Map<String, c> f27344c = new HashMap();
    private LruCache<String, a> e = new LruCache<>(15);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/service/event/b$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        String f27346a;
        int b;

        /* renamed from: c  reason: collision with root package name */
        Parcel f27347c;

        public a(String str, int i, Parcel parcel) {
            this.f27346a = str;
            this.b = i;
            this.f27347c = parcel;
        }
    }

    private b() {
    }

    public static final b a() {
        b bVar;
        b bVar2 = f27343a;
        if (bVar2 == null) {
            synchronized (b.class) {
                try {
                    b bVar3 = f27343a;
                    bVar = bVar3;
                    if (bVar3 == null) {
                        bVar = new b();
                        f27343a = bVar;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return bVar;
        }
        return bVar2;
    }

    private void a(Context context, String str, int i, Parcel parcel, boolean z) {
        if (context == null) {
            return;
        }
        try {
            String str2 = context.getPackageName() + ".heytap.msp.mobad.BROADCAST_PERMISSION";
            Intent intent = new Intent();
            intent.setAction("com.heytap.msp.mobad.EVENT");
            intent.putExtra("description", str);
            intent.putExtra("code", i);
            intent.putExtra("stick", z);
            intent.setPackage(context.getPackageName());
            if (parcel != null) {
                intent.putExtra("data", parcel.marshall());
            }
            context.sendBroadcast(intent, str2);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.b("eManager", "send fail", e);
        }
    }

    private void b(Context context) {
        synchronized (this) {
            if (this.d == null && context != null) {
                this.d = new BroadcastReceiver() { // from class: com.opos.mobad.service.event.b.1
                    @Override // android.content.BroadcastReceiver
                    public void onReceive(Context context2, Intent intent) {
                        try {
                            String stringExtra = intent.getStringExtra("description");
                            int intExtra = intent.getIntExtra("code", -1);
                            boolean booleanExtra = intent.getBooleanExtra("stick", false);
                            byte[] byteArrayExtra = intent.getByteArrayExtra("data");
                            if (TextUtils.isEmpty(stringExtra) || -1 == intExtra) {
                                return;
                            }
                            Parcel parcel = null;
                            if (byteArrayExtra != null) {
                                parcel = null;
                                if (byteArrayExtra.length > 0) {
                                    parcel = Parcel.obtain();
                                    parcel.unmarshall(byteArrayExtra, 0, byteArrayExtra.length);
                                }
                            }
                            b.this.b(stringExtra, intExtra, parcel, booleanExtra);
                            if (parcel != null) {
                                parcel.recycle();
                            }
                        } catch (Exception e) {
                            com.opos.cmn.an.f.a.b("eManager", "receiver error", e);
                        }
                    }
                };
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("com.heytap.msp.mobad.EVENT");
                String str = context.getPackageName() + ".heytap.msp.mobad.BROADCAST_PERMISSION";
                if (Build.VERSION.SDK_INT >= 33) {
                    context.registerReceiver(this.d, intentFilter, str, null, 4);
                } else {
                    context.registerReceiver(this.d, intentFilter, str, null);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, int i, Parcel parcel, boolean z) {
        c cVar = this.f27344c.get(str);
        if (cVar != null) {
            cVar.a(i, parcel);
        } else if (z) {
            this.e.put(str, new a(str, i, parcel));
        }
    }

    public c a(EventDescription eventDescription) {
        if (eventDescription == null) {
            return null;
        }
        return this.f27344c.get(eventDescription.a());
    }

    public void a(Context context) {
        if (context != null) {
            this.b = context;
        }
        b(context);
    }

    public void a(c cVar) {
        if (cVar == null) {
            return;
        }
        this.f27344c.put(cVar.a().a(), cVar);
        a remove = this.e.remove(cVar.a().a());
        if (remove != null) {
            cVar.a(remove.b, remove.f27347c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, int i, Parcel parcel) {
        a(this.b, str, i, parcel, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, int i, Parcel parcel, boolean z) {
        a(this.b, str, i, parcel, z);
    }

    public void b(c cVar) {
        if (cVar == null) {
            return;
        }
        this.f27344c.remove(cVar.a().a());
    }
}
