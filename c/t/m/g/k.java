package c.t.m.g;

import android.location.Location;
import android.net.wifi.ScanResult;
import android.os.Build;
import android.os.SystemClock;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.json.JSONObject;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/k.class */
public class k {

    /* renamed from: a  reason: collision with root package name */
    public static volatile String f3856a = "209";
    public static volatile String b = "fc_sdk";

    /* renamed from: c  reason: collision with root package name */
    public static final Comparator<Object> f3857c = new a();

    /* loaded from: source-8756600-dex2jar.jar:c/t/m/g/k$a.class */
    public static final class a implements Comparator<Object> {
        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            ScanResult scanResult = (ScanResult) obj;
            ScanResult scanResult2 = (ScanResult) obj2;
            int i = Build.VERSION.SDK_INT >= 17 ? (int) (((scanResult2.timestamp / 1000) / 1000) - ((scanResult.timestamp / 1000) / 1000)) : 0;
            int i2 = i;
            if (i == 0) {
                i2 = scanResult2.level - scanResult.level;
            }
            return i2;
        }
    }

    public static String a(c cVar, Location location, List<ScanResult> list, List<d> list2, boolean z) {
        int size;
        if (list != null) {
            try {
                size = list.size();
            } catch (Throwable th) {
                return "";
            }
        } else {
            size = 0;
        }
        int size2 = list2 != null ? list2.size() : 0;
        if (cVar == null || location == null) {
            return "";
        }
        if (size == 0 && size2 == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();
        StringBuilder sb4 = new StringBuilder();
        sb.append(0);
        sb.append(",");
        sb.append(String.format(Locale.ENGLISH, "%.6f", Double.valueOf(location.getLatitude())));
        sb.append(",");
        sb.append(String.format(Locale.ENGLISH, "%.6f", Double.valueOf(location.getLongitude())));
        sb.append(",");
        sb.append((int) location.getAltitude());
        sb.append(",");
        sb.append((int) location.getAccuracy());
        sb.append(",");
        sb.append((int) location.getBearing());
        sb.append(",");
        sb.append(String.format(Locale.ENGLISH, "%.1f", Float.valueOf(location.getSpeed())));
        sb.append(",");
        sb.append(location.getTime());
        if (!m3.a((Collection) list2)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= list2.size()) {
                    break;
                }
                d dVar = list2.get(i2);
                sb2.append(i2 == 0 ? "" : ";");
                sb2.append(dVar.f3781a);
                sb2.append(",");
                sb2.append(dVar.b);
                sb2.append(",");
                sb2.append(dVar.f3782c);
                sb2.append(",");
                sb2.append(dVar.e);
                sb2.append(",");
                sb2.append(dVar.d);
                sb2.append(",");
                sb2.append(i2 == 0 ? k3.a(z) : -1);
                sb2.append(",");
                sb2.append(dVar.f);
                i = i2 + 1;
            }
        }
        StringBuilder sb5 = sb2;
        StringBuilder sb6 = sb3;
        if (list != null) {
            sb5 = sb2;
            sb6 = sb3;
            if (list.size() > 0) {
                Object[] array = list.toArray();
                Arrays.sort(array, f3857c);
                long elapsedRealtime = SystemClock.elapsedRealtime() / 1000;
                int i3 = 0;
                while (true) {
                    sb5 = sb2;
                    sb6 = sb3;
                    if (i3 >= array.length) {
                        break;
                    }
                    ScanResult scanResult = (ScanResult) array[i3];
                    sb3.append(i3 == 0 ? "" : "&");
                    sb3.append(scanResult.BSSID.replaceAll(":", "").toLowerCase());
                    sb3.append("&");
                    sb3.append(scanResult.level);
                    if (Build.VERSION.SDK_INT >= 17) {
                        int i4 = scanResult.timestamp > 0 ? (int) (elapsedRealtime - ((scanResult.timestamp / 1000) / 1000)) : -1;
                        sb4.append(i3 == 0 ? "" : "&");
                        sb4.append(i4);
                    }
                    i3++;
                }
            }
        }
        StringBuilder sb7 = new StringBuilder();
        String a2 = n.a();
        if (a2 != null && a2.length() > 5) {
            JSONObject jSONObject = new JSONObject(a2);
            sb7.append(jSONObject.optString("mac").replaceAll(":", "").toLowerCase());
            sb7.append("&");
            sb7.append(jSONObject.optString("ssid"));
            sb7.append("&");
            sb7.append(jSONObject.optString("rssi"));
            if (sb7.length() < 5) {
                sb7.setLength(0);
            }
        }
        String str = cVar.b().replaceAll("[| _]", "") + BridgeUtil.UNDERLINE_STR + cVar.c();
        String str2 = cVar.d().replaceAll("[| _]", "") + BridgeUtil.UNDERLINE_STR + cVar.e().replaceAll("[| _]", "");
        StringBuilder sb8 = new StringBuilder();
        SimpleDateFormat b2 = t2.b("yyyy-MM-dd HH:mm:ss");
        sb8.append("[");
        sb8.append(b2.format(new Date()));
        sb8.append("]:");
        sb8.append(cVar.f());
        sb8.append("|");
        sb8.append(f3856a);
        sb8.append("|");
        sb8.append(cVar.a());
        sb8.append("|");
        sb8.append(j.d ? m.a() : "");
        sb8.append("|");
        sb8.append(j.d ? m.b() : "");
        sb8.append("|");
        sb8.append("");
        sb8.append("|");
        sb8.append("");
        sb8.append("|");
        sb8.append("");
        sb8.append("|");
        sb8.append("");
        sb8.append("|");
        sb8.append("");
        sb8.append("|");
        sb8.append("");
        sb8.append("|");
        sb8.append((CharSequence) sb);
        sb8.append("|");
        sb8.append("");
        sb8.append("|");
        sb8.append((CharSequence) sb5);
        sb8.append("|");
        sb8.append((CharSequence) sb6);
        sb8.append("|");
        sb8.append("");
        sb8.append("|");
        sb8.append("");
        sb8.append("|");
        sb8.append("");
        sb8.append("|");
        sb8.append("");
        sb8.append("|");
        sb8.append("");
        sb8.append("|");
        sb8.append("");
        sb8.append("|");
        sb8.append("");
        sb8.append("|");
        sb8.append("");
        sb8.append("|");
        sb8.append("");
        sb8.append("|");
        sb8.append("");
        sb8.append("|");
        sb8.append("");
        sb8.append("|");
        sb8.append("");
        sb8.append("|");
        sb8.append("");
        sb8.append("|");
        sb8.append("");
        sb8.append("|");
        sb8.append("");
        sb8.append("|");
        sb8.append(b);
        sb8.append("|");
        sb8.append("");
        sb8.append("|");
        sb8.append("");
        sb8.append("|");
        sb8.append("");
        sb8.append("|");
        sb8.append((CharSequence) sb7);
        sb8.append("|");
        sb8.append("");
        sb8.append("|");
        sb8.append(j.d ? m.c().replaceAll(":", "").toLowerCase() : "");
        sb8.append("|");
        sb8.append(str);
        sb8.append("|");
        sb8.append("");
        sb8.append("|");
        sb8.append("");
        sb8.append("|");
        sb8.append(str2);
        sb8.append("|");
        sb8.append("");
        sb8.append("|");
        sb8.append("");
        sb8.append("|");
        sb8.append("");
        sb8.append("|");
        sb8.append("");
        sb8.append("|");
        sb8.append("");
        sb8.append("|");
        sb8.append("");
        sb8.append("|");
        sb8.append("");
        sb8.append("|");
        sb8.append("");
        sb8.append("|");
        sb8.append("");
        sb8.append("|");
        sb8.append("");
        sb8.append("|");
        sb8.append("");
        sb8.append("|");
        sb8.append(sb4.toString());
        sb8.append("|");
        sb8.append("");
        return sb8.toString();
    }

    public static void a(String str) {
        b = str;
    }

    public static void b(String str) {
        f3856a = str;
    }
}
