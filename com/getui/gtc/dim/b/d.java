package com.getui.gtc.dim.b;

import android.os.Build;
import android.text.TextUtils;
import com.android.internal.telephony.PhoneConstants;
import com.getui.gtc.dim.AppDataProvider;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/dim/b/d.class */
public class d {

    /* renamed from: a  reason: collision with root package name */
    static final List<String> f21939a = Arrays.asList("dim-2-1-21-5", "dim-2-1-21-3", "dim-2-1-21-1");
    private static final List<String> f = new ArrayList();
    protected AppDataProvider d;
    protected String e;
    final Map<String, Integer> b = new HashMap();
    private final Map<String, Integer> g = new HashMap();
    private final Map<String, Boolean> h = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    final List<String> f21940c = new ArrayList();
    private final Map<String, String> i = new HashMap();

    static {
        ArrayList<String[]> arrayList = new ArrayList();
        arrayList.add(new String[]{"gt", "com.igexin.sdk.PushManager"});
        arrayList.add(new String[]{"gy", "com.g.gysdk.GYManager"});
        arrayList.add(new String[]{"ido", "com.getui.gs.sdk.GsManager"});
        arrayList.add(new String[]{"wus", "com.sdk.plus.WusManager"});
        for (String[] strArr : arrayList) {
            if (d(strArr[1])) {
                f.add(strArr[0]);
            }
        }
    }

    private static boolean d(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    private static boolean e(String str) {
        boolean z;
        try {
            String str2 = Build.BRAND;
            String str3 = Build.MODEL;
            int i = Build.VERSION.SDK_INT;
            com.getui.gtc.dim.e.b.a("isPhoneContainAt " + str + ", check brand = " + str2 + ", model = " + str3 + ", sdkInt = " + i);
            String[] split = str.split("&");
            if (!split[0].equals(PhoneConstants.APN_TYPE_ALL) && !split[0].equals(str2)) {
                return false;
            }
            String[] split2 = split[1].split("\\|");
            int length = split2.length;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= length) {
                    z = false;
                    break;
                }
                String str4 = split2[i3];
                if (!TextUtils.isEmpty(str4) && (str4.equals(str3) || str4.equals(PhoneConstants.APN_TYPE_ALL))) {
                    break;
                }
                i2 = i3 + 1;
            }
            z = true;
            if (!z) {
                return false;
            }
            String[] split3 = split[2].split("\\|");
            int length2 = split3.length;
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 >= length2) {
                    return false;
                }
                String str5 = split3[i5];
                if (!TextUtils.isEmpty(str5)) {
                    if (!str5.contains("-")) {
                        if (!str5.equals(String.valueOf(i)) && !str5.equals(PhoneConstants.APN_TYPE_ALL)) {
                        }
                        return true;
                    }
                    String[] split4 = str5.split("-");
                    if (split4.length == 2 && i >= Integer.parseInt(split4[0]) && i <= Integer.parseInt(split4[1])) {
                        return true;
                    }
                }
                i4 = i5 + 1;
            }
        } catch (Throwable th) {
            com.getui.gtc.dim.e.b.a("isPhoneContainAt error", th);
            return false;
        }
    }

    public void a(AppDataProvider appDataProvider) {
        this.d = appDataProvider;
        com.getui.gtc.dim.e.b.a("dim sys app data provider set: ".concat(String.valueOf(appDataProvider)));
    }

    public void a(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return;
        }
        boolean z = true;
        switch (str.hashCode()) {
            case 1673844572:
                if (str.equals("dim-2-2-3-1")) {
                    z = false;
                    break;
                }
                break;
            case 1673844573:
                if (str.equals("dim-2-2-3-2")) {
                    z = true;
                    break;
                }
                break;
            case 1673844574:
                if (str.equals("dim-2-2-3-3")) {
                    z = true;
                    break;
                }
                break;
            case 1673844575:
                if (str.equals("dim-2-2-3-4")) {
                    z = true;
                    break;
                }
                break;
            case 1673845533:
                if (str.equals("dim-2-2-4-1")) {
                    z = true;
                    break;
                }
                break;
            case 1673846494:
                if (str.equals("dim-2-2-5-1")) {
                    z = true;
                    break;
                }
                break;
            case 1673849377:
                if (str.equals("dim-2-2-8-1")) {
                    z = true;
                    break;
                }
                break;
            case 1673850338:
                if (str.equals("dim-2-2-9-1")) {
                    z = true;
                    break;
                }
                break;
        }
        switch (z) {
            case false:
                int parseInt = Integer.parseInt(str3);
                this.b.put(str2, Integer.valueOf(parseInt));
                com.getui.gtc.dim.e.b.a("dim sys globalAllow set: " + str2 + " : " + parseInt);
                return;
            case true:
                int parseInt2 = Integer.parseInt(str3);
                this.g.put(str2, Integer.valueOf(parseInt2));
                com.getui.gtc.dim.e.b.a("dim sys globalAllow policy set: " + str2 + " : " + parseInt2);
                return;
            case true:
                boolean parseBoolean = Boolean.parseBoolean(str3);
                this.h.put(str2, Boolean.valueOf(parseBoolean));
                com.getui.gtc.dim.e.b.a("dim sys app provider globalAllow set: " + str2 + " : " + parseBoolean);
                return;
            case true:
                try {
                    if (f.isEmpty()) {
                        com.getui.gtc.dim.e.b.a("dim sys sdk embed is empty");
                        return;
                    }
                    List asList = Arrays.asList(str3.trim().split("#"));
                    Iterator<String> it = f.iterator();
                    do {
                        if (!it.hasNext()) {
                            this.f21940c.add(str2);
                            com.getui.gtc.dim.e.b.a("dim disallow sys call set: ".concat(String.valueOf(str2)));
                            return;
                        }
                    } while (asList.contains(it.next()));
                    return;
                } catch (Throwable th) {
                    com.getui.gtc.dim.e.b.a("dim disallow sys call set: " + str2 + " error", th);
                    return;
                }
            case true:
                try {
                    JSONArray jSONArray = new JSONArray(str2);
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= jSONArray.length()) {
                            com.getui.gtc.dim.e.b.a("dim sys exclude phone set: " + str2 + " : " + str3);
                            return;
                        }
                        String string = jSONArray.getString(i2);
                        String str4 = this.i.get(string);
                        if (str4 == null) {
                            this.i.put(string, str3);
                        } else {
                            this.i.put(string, str4 + "#" + str3);
                        }
                        i = i2 + 1;
                    }
                } catch (Throwable th2) {
                    com.getui.gtc.dim.e.b.a("dim sys exclude phone set error, dimKeys:".concat(String.valueOf(str2)), th2);
                    return;
                }
            case true:
                this.e = str3;
                com.getui.gtc.dim.e.b.a("dim sys gtc dyc config set: " + str2 + " : " + str3);
                return;
            case true:
                String[] split = str3.toLowerCase().split(",");
                int length = split.length;
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= length) {
                        return;
                    }
                    String[] split2 = split[i4].trim().split(":");
                    if (split2.length >= 2) {
                        com.getui.gtc.dim.c.a.f21943a.put(split2[0].trim(), split2[1].trim());
                        com.getui.gtc.dim.e.b.a("dim sys rom map set: " + split2[0].trim() + ":" + split2[1].trim());
                    }
                    i3 = i4 + 1;
                }
            case true:
                String[] split3 = str3.split(",");
                int length2 = split3.length;
                int i5 = 0;
                while (true) {
                    int i6 = i5;
                    if (i6 >= length2) {
                        return;
                    }
                    String[] split4 = split3[i6].trim().split("#");
                    if (split4.length >= 2) {
                        com.getui.gtc.dim.c.a.b.put(split4[0].trim().toLowerCase(), split4[1].trim());
                        com.getui.gtc.dim.e.b.a("dim sys permission map set: " + split4[0].trim() + "#" + split4[1].trim());
                    }
                    i5 = i6 + 1;
                }
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean a(String str) {
        try {
            Boolean bool = this.h.get(str);
            if (bool != null) {
                return bool.booleanValue();
            }
            return false;
        } catch (Throwable th) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int b(String str) {
        Integer num = 0;
        if (!TextUtils.isEmpty(str)) {
            Integer num2 = this.g.get(str);
            num = num2;
            if (num2 == null) {
                num = this.g.get("dim-2-2-9-1");
            }
        }
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean c(String str) {
        try {
            String str2 = this.i.get(str);
            if (str2 == null) {
                return false;
            }
            if (!str2.contains("#")) {
                return e(str2);
            }
            String[] split = str2.split("#");
            int length = split.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return false;
                }
                if (e(split[i2])) {
                    return true;
                }
                i = i2 + 1;
            }
        } catch (Throwable th) {
            com.getui.gtc.dim.e.b.a("isSysCallExcludePhone error", th);
            return false;
        }
    }
}
