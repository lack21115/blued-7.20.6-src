package com.anythink.core.common;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.android.internal.telephony.PhoneConstants;
import com.anythink.core.common.c.l;
import org.json.JSONObject;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/r.class */
public class r {
    public static final String a = r.class.getSimpleName();
    private static volatile r b;
    private Context c;

    private r(Context context) {
        this.c = context.getApplicationContext();
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
        if (this.c == null) {
            return;
        }
        try {
            Intent intent = new Intent(str);
            intent.putExtra(com.anythink.core.common.g.c.Z, str2);
            intent.putExtra("data", str3);
            intent.putExtra("adsourceId", str4);
            intent.putExtra(PhoneConstants.DATA_NETWORK_TYPE_KEY, String.valueOf(eVar.H()));
            intent.putExtra(l.a.b, eVar.Y());
            intent.putExtra("showid", eVar.l());
            intent.putExtra("tktype", i);
            intent.setPackage(this.c.getPackageName());
            com.anythink.core.common.b.k.a(this.c).a(intent);
        } catch (Throwable th) {
        }
    }

    static /* synthetic */ void a(r rVar, int i, String str, String str2, String str3, String str4, com.anythink.core.common.e.e eVar) {
        if (rVar.c != null) {
            try {
                Intent intent = new Intent(str);
                intent.putExtra(com.anythink.core.common.g.c.Z, str2);
                intent.putExtra("data", str3);
                intent.putExtra("adsourceId", str4);
                intent.putExtra(PhoneConstants.DATA_NETWORK_TYPE_KEY, String.valueOf(eVar.H()));
                intent.putExtra(l.a.b, eVar.Y());
                intent.putExtra("showid", eVar.l());
                intent.putExtra("tktype", i);
                intent.setPackage(rVar.c.getPackageName());
                com.anythink.core.common.b.k.a(rVar.c).a(intent);
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
                        String str2 = r.a;
                        new StringBuilder("common -> ").append(a2.toString());
                        String str3 = r.a;
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
                    if (r.this.c == null) {
                        return;
                    }
                    String packageName = r.this.c.getPackageName();
                    String str = "";
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= 2) {
                            String c = com.anythink.core.common.k.f.c(str);
                            Intent intent = new Intent(c);
                            intent.putExtra(c, aVar.H());
                            intent.putExtra("data", com.anythink.core.common.k.m.a().toString());
                            intent.putExtra("denied", com.anythink.core.common.b.n.a().f());
                            intent.setPackage(packageName);
                            com.anythink.core.common.b.k.a(r.this.c).a(intent);
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
