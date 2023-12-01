package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.jni.Engine;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kuaishou/weapon/p0/aw.class */
public class aw {

    /* renamed from: a  reason: collision with root package name */
    private JSONObject f23735a;

    public aw(Context context) {
        if (Engine.loadSuccess) {
            try {
                String pqr = Engine.getInstance(context).pqr(Integer.valueOf(cj.g).intValue(), 1, 0, "");
                if (TextUtils.isEmpty(pqr)) {
                    return;
                }
                this.f23735a = new JSONObject(pqr);
            } catch (Throwable th) {
            }
        }
    }

    public String a(String str) {
        JSONObject jSONObject = this.f23735a;
        if (jSONObject != null) {
            try {
                return jSONObject.optString(str, null);
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }

    public Set a(int i) {
        HashSet hashSet = new HashSet();
        if (i == 1) {
            hashSet.add("HeapTaskDa");
            hashSet.add("queued-wor");
            hashSet.add("JDWP");
            hashSet.add("dTi");
            hashSet.add("MessageHan");
            hashSet.add("MediaPrefe");
            hashSet.add("CleanupRef");
            hashSet.add("GeoLocatio");
            hashSet.add("securityai");
            hashSet.add("Connectivi");
            hashSet.add("PatchManag");
            hashSet.add("CronetInte");
            hashSet.add("AegonLogge");
            hashSet.add("Countly");
            hashSet.add("DownloadSt");
            hashSet.add("GoogleApiH");
            hashSet.add("PlatformSe");
            hashSet.add("MemoryInfr");
            hashSet.add("CronetLibr");
            hashSet.add("Dex2OatIni");
            hashSet.add("EncodeApiH");
            hashSet.add("CookieMons");
        }
        return hashSet;
    }

    public Set a(Context context, String str, int i) {
        String str2;
        int i2;
        JSONObject jSONObject = this.f23735a;
        if (jSONObject != null) {
            try {
                String string = jSONObject.getString(str);
                Set a2 = a(i);
                if (TextUtils.isEmpty(string) || string.length() <= 3) {
                    return null;
                }
                JSONArray jSONArray = new JSONArray(string);
                HashSet hashSet = new HashSet();
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= jSONArray.length()) {
                        break;
                    }
                    String string2 = jSONArray.getString(i4);
                    if (!string2.contains("azeroth") && !string2.contains("OkHttp") && !string2.contains("retrofit")) {
                        int i5 = 0;
                        do {
                            str2 = string2;
                            if (!string2.contains(" ")) {
                                break;
                            }
                            str2 = string2.replace(" ", "");
                            i2 = i5 + 1;
                            string2 = str2;
                            i5 = i2;
                        } while (i2 <= 200);
                        String replace = str2.replace("\n", "").replace("\t", "").replace("\u200b", "");
                        String str3 = replace;
                        if (replace.startsWith(":")) {
                            str3 = replace.substring(1);
                        }
                        String substring = str3.length() > 10 ? str3.substring(0, 10) : str3;
                        if (str3.contains("ridge")) {
                            hashSet.add(str3);
                        }
                        String packageName = context.getPackageName();
                        if (!str3.contains(packageName) && !packageName.contains(str3) && !a2.contains(substring) && !b(i).contains(substring)) {
                            hashSet.add(str3);
                        }
                    }
                    i3 = i4 + 1;
                }
                if (hashSet.size() > 0) {
                    return hashSet;
                }
                return null;
            } catch (Throwable th) {
                return null;
            }
        }
        return null;
    }

    public Set b(int i) {
        HashSet hashSet = new HashSet();
        if (i == 1) {
            hashSet.add("AudioTrack");
            hashSet.add("processrea");
            hashSet.add("RemitDatab");
            hashSet.add("BrowserBlo");
            hashSet.add("game_push");
            hashSet.add("Godzilla:I");
            hashSet.add("IndexedDB");
            hashSet.add("ScopeRetry");
            hashSet.add("RobustPatc");
            hashSet.add("FrescoIoBo");
            hashSet.add("key_config");
        }
        return hashSet;
    }
}
