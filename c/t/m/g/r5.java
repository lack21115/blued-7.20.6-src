package c.t.m.g;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import java.io.UnsupportedEncodingException;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/r5.class */
public class r5 {
    public static String a(int i) {
        byte[] bArr = {-100, -112, -110, -47, -117, -102, -111, -100, -102, -111, -117, -47, -110, -98, -113, -47, -120, -98, -108, -102, -118, -113};
        int i2 = (i * 7) + 15 > 15 ? 21 : 15;
        byte[] bArr2 = new byte[i2];
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= i2) {
                try {
                    return new String(bArr2, "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                    return "";
                }
            }
            if (i2 <= 15 || i4 <= 9) {
                bArr2[i4] = bArr[i4];
            } else {
                bArr2[i4] = bArr[i4 + 1];
            }
            i3 = i4 + 1;
        }
    }

    public static void a(Context context) {
        try {
            String str = Build.MANUFACTURER;
            if (Boolean.parseBoolean(e6.a().get("enable_invoke_map"))) {
                if (str.equals("Meizu") || str.equals("samsung") || str.equals("OnePlus")) {
                    long a2 = d6.a("LocationSDK", "location_invoke_map_time", 0L);
                    int a3 = d6.a("LocationSDK", "location_invoke_map_count", 0);
                    if (System.currentTimeMillis() - a2 <= 86400000 || a3 > 5) {
                        return;
                    }
                    d6.b("LocationSDK", "location_invoke_map_time", System.currentTimeMillis());
                    d6.b("LocationSDK", "location_invoke_map_count", a3 + 1);
                    Intent intent = new Intent();
                    intent.setPackage(a(0));
                    intent.setAction(a(1));
                    intent.putExtra("source", "location_official");
                    context.startService(intent);
                    a(0);
                    a(1);
                }
            }
        } catch (Throwable th) {
        }
    }
}
