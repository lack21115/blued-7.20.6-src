package com.anythink.core.common;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.efs.sdk.base.core.util.NetworkUtil;
import org.json.JSONObject;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/r.class */
public class r {

    /* renamed from: a  reason: collision with root package name */
    public static final String f6875a = r.class.getSimpleName();
    private static volatile r b;

    /* renamed from: c  reason: collision with root package name */
    private Context f6876c;

    private r(Context context) {
        this.f6876c = context.getApplicationContext();
    }

    public static r a(Context context) {
        if (b == null) {
            synchronized (r.class) {
                try {
                    if (b == null) {
                        b = new r(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return b;
    }

    private void a(int i, String str, String str2, String str3, String str4, com.anythink.core.common.e.e eVar) {
        if (this.f6876c == null) {
            return;
        }
        try {
            Intent intent = new Intent(str);
            intent.putExtra("common", str2);
            intent.putExtra("data", str3);
            intent.putExtra("adsourceId", str4);
            intent.putExtra("networkType", String.valueOf(eVar.H()));
            intent.putExtra("format", eVar.Y());
            intent.putExtra("showid", eVar.l());
            intent.putExtra("tktype", i);
            intent.setPackage(this.f6876c.getPackageName());
            com.anythink.core.common.b.k.a(this.f6876c).a(intent);
        } catch (Throwable th) {
        }
    }

    static /* synthetic */ void a(r rVar, int i, String str, String str2, String str3, String str4, com.anythink.core.common.e.e eVar) {
        if (rVar.f6876c != null) {
            try {
                Intent intent = new Intent(str);
                intent.putExtra("common", str2);
                intent.putExtra("data", str3);
                intent.putExtra("adsourceId", str4);
                intent.putExtra("networkType", String.valueOf(eVar.H()));
                intent.putExtra("format", eVar.Y());
                intent.putExtra("showid", eVar.l());
                intent.putExtra("tktype", i);
                intent.setPackage(rVar.f6876c.getPackageName());
                com.anythink.core.common.b.k.a(rVar.f6876c).a(intent);
            } catch (Throwable th) {
            }
        }
    }

    public final void a(final int i, final com.anythink.core.common.e.f fVar, final com.anythink.core.c.a aVar) {
        try {
            com.anythink.core.common.b.n.a();
            com.anythink.core.common.b.n.b(new Runnable() { // from class: com.anythink.core.common.r.1
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        if (com.anythink.core.c.e.a(com.anythink.core.common.b.n.a().g()).a(fVar.b.W()) == null) {
                            return;
                        }
                        String x = ((com.anythink.core.common.e.e) fVar.b).x();
                        if (TextUtils.isEmpty(x)) {
                            return;
                        }
                        String str = null;
                        int i2 = i;
                        boolean z = false;
                        if (i2 == 4) {
                            z = false;
                            if (((com.anythink.core.common.e.e) fVar.b).t() == 1) {
                                z = true;
                            }
                            str = aVar.M().get("show");
                        } else if (i2 != 6) {
                            switch (i2) {
                                case 18:
                                case 19:
                                case 20:
                                    if (((com.anythink.core.common.e.e) fVar.b).b() == 1) {
                                        z = true;
                                    }
                                    str = aVar.M().get("dl");
                                    break;
                                default:
                                    z = false;
                                    break;
                            }
                        } else {
                            z = false;
                            if (((com.anythink.core.common.e.e) fVar.b).u() == 1) {
                                z = true;
                            }
                            str = aVar.M().get("click");
                        }
                        if (!z || TextUtils.isEmpty(str)) {
                            return;
                        }
                        JSONObject a2 = com.anythink.core.common.k.m.a();
                        String str2 = r.f6875a;
                        new StringBuilder("common -> ").append(a2.toString());
                        String str3 = r.f6875a;
                        new StringBuilder("data -> ").append(fVar.a().toString());
                        r.a(r.this, i, str, a2.toString(), fVar.a().toString(), x, (com.anythink.core.common.e.e) fVar.b);
                    } catch (Throwable th) {
                    }
                }
            });
        } catch (Throwable th) {
        }
    }

    public final void a(final com.anythink.core.c.a aVar) {
        com.anythink.core.common.b.n.a();
        com.anythink.core.common.b.n.d(new Runnable() { // from class: com.anythink.core.common.r.2
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    if (r.this.f6876c == null) {
                        return;
                    }
                    String packageName = r.this.f6876c.getPackageName();
                    String str = "";
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= 2) {
                            String c2 = com.anythink.core.common.k.f.c(str);
                            Intent intent = new Intent(c2);
                            intent.putExtra(c2, aVar.H());
                            intent.putExtra("data", com.anythink.core.common.k.m.a().toString());
                            intent.putExtra(NetworkUtil.NETWORK_CLASS_DENIED, com.anythink.core.common.b.n.a().f());
                            intent.setPackage(packageName);
                            com.anythink.core.common.b.k.a(r.this.f6876c).a(intent);
                            return;
                        }
                        str = str + packageName;
                        i = i2 + 1;
                    }
                } catch (Throwable th) {
                }
            }
        });
    }
}
