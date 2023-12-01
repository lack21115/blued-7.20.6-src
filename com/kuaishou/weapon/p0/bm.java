package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.jni.Engine;

/* loaded from: source-7994992-dex2jar.jar:com/kuaishou/weapon/p0/bm.class */
public class bm {

    /* renamed from: a  reason: collision with root package name */
    private Context f23753a;

    public bm(Context context) {
        this.f23753a = context;
    }

    public static String b(String str) {
        String str2;
        String str3 = new String(c.a("a3NyaXNrY3RsYnVzaW5zc3Z4cHprd3NwYWlvcXBrc3M=".getBytes(), 2));
        try {
            if (TextUtils.isEmpty(str3)) {
                return null;
            }
            if (str3.length() < 16) {
                int length = str3.length();
                StringBuilder sb = new StringBuilder(str3);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= 16 - length) {
                        break;
                    }
                    sb.append("0");
                    i = i2 + 1;
                }
                str2 = sb.toString();
            } else {
                str2 = str3;
                if (str3.length() > 16) {
                    str2 = str3.substring(0, 16);
                }
            }
            return new String(d.b(i.a(b.b(str2.substring(0, 16), str2.substring(0, 16), c.a(str.getBytes(), 2)), str2.substring(0, 16))));
        } catch (Exception e) {
            return null;
        }
    }

    public String a(String str) {
        try {
            return b(str, new String(c.a("a3NyaXNrY3RsYnVzaW5zc3Z4cHprd3NwYWlvcXBrc3M=".getBytes(), 2)));
        } catch (Exception e) {
            return null;
        }
    }

    public String a(String str, String str2) {
        try {
            return c(str, new String(c.a(str2.getBytes(), 2)));
        } catch (Exception e) {
            return null;
        }
    }

    public String b(String str, String str2) {
        String str3;
        byte[] a2;
        try {
            if (TextUtils.isEmpty(str2)) {
                return null;
            }
            if (str2.length() < 16) {
                int length = str2.length();
                StringBuilder sb = new StringBuilder(str2);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= 16 - length) {
                        break;
                    }
                    sb.append("0");
                    i = i2 + 1;
                }
                str3 = sb.toString();
            } else {
                str3 = str2;
                if (str2.length() > 16) {
                    str3 = str2.substring(0, 16);
                }
            }
            byte[] a3 = c.a(str.getBytes(), 2);
            if (Engine.loadSuccess) {
                a2 = Engine.getInstance(this.f23753a).dr(Engine.getInstance(this.f23753a).dc(a3, str3.substring(0, 16).getBytes()), str3.getBytes());
            } else {
                a2 = i.a(b.b(str3.substring(0, 16), str3.substring(0, 16), a3), str3.substring(0, 16));
            }
            return new String(d.b(a2));
        } catch (Exception e) {
            return null;
        }
    }

    public String c(String str) {
        try {
            return c(str, new String(c.a("a3NyaXNrY3RsYnVzaW5zc3Z4cHprd3NwYWlvcXBrc3M=".getBytes(), 2)));
        } catch (Exception e) {
            return null;
        }
    }

    public String c(String str, String str2) {
        String str3;
        byte[] bArr;
        try {
            if (TextUtils.isEmpty(str2)) {
                return null;
            }
            if (str2.length() < 16) {
                int length = str2.length();
                StringBuilder sb = new StringBuilder(str2);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= 16 - length) {
                        break;
                    }
                    sb.append("0");
                    i = i2 + 1;
                }
                str3 = sb.toString();
            } else {
                str3 = str2;
                if (str2.length() > 16) {
                    str3 = str2.substring(0, 16);
                }
            }
            byte[] a2 = d.a(str.getBytes());
            if (Engine.loadSuccess) {
                bArr = Engine.getInstance(this.f23753a).ac(Engine.getInstance(this.f23753a).ar(a2, str3.getBytes()), str3.substring(0, 16).getBytes());
            } else {
                try {
                    bArr = b.a(str3.substring(0, 16), str3.substring(0, 16), i.b(a2, str3));
                } catch (Throwable th) {
                    bArr = null;
                }
            }
            if (bArr == null || bArr.length <= 0) {
                return null;
            }
            return c.b(bArr, 2);
        } catch (Exception e) {
            return null;
        }
    }
}
