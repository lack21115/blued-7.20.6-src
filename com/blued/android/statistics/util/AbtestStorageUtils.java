package com.blued.android.statistics.util;

import android.provider.MediaStore;
import android.text.TextUtils;
import com.blued.android.statistics.StatConfig;
import com.blued.das.client.abtest.AbClientProtos;
import java.io.File;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/statistics/util/AbtestStorageUtils.class */
public class AbtestStorageUtils {
    public static ConcurrentHashMap<String, AbClientProtos.AbResult> a(String str) {
        ConcurrentHashMap<String, AbClientProtos.AbResult> concurrentHashMap;
        synchronized (AbtestStorageUtils.class) {
            try {
                concurrentHashMap = new ConcurrentHashMap<>();
                String a2 = FileUtils.a(b(str));
                if (!TextUtils.isEmpty(a2)) {
                    try {
                        JSONArray jSONArray = new JSONArray(a2);
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= jSONArray.length()) {
                                break;
                            }
                            JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                            concurrentHashMap.put(optJSONObject.optString("key"), AbClientProtos.AbResult.newBuilder().setGid(optJSONObject.optLong("gid")).setParamType(optJSONObject.optInt("type")).setParamValue(optJSONObject.optString("value")).setIsTrack(optJSONObject.optBoolean(MediaStore.Audio.AudioColumns.TRACK)).setIsGroupFreeze(optJSONObject.optBoolean("group_freeze")).setIsFreeze(optJSONObject.optBoolean("freeze")).build());
                            i = i2 + 1;
                        }
                    } catch (Exception e) {
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return concurrentHashMap;
    }

    public static void a(String str, ConcurrentHashMap<String, AbClientProtos.AbResult> concurrentHashMap) {
        synchronized (AbtestStorageUtils.class) {
            try {
                JSONArray jSONArray = new JSONArray();
                for (Map.Entry<String, AbClientProtos.AbResult> entry : concurrentHashMap.entrySet()) {
                    String key = entry.getKey();
                    AbClientProtos.AbResult value = entry.getValue();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("key", key);
                    jSONObject.put("gid", value.getGid());
                    jSONObject.put("type", value.getParamType());
                    jSONObject.put("value", value.getParamValue());
                    jSONObject.put(MediaStore.Audio.AudioColumns.TRACK, value.getIsTrack());
                    jSONObject.put("group_freeze", value.getIsGroupFreeze());
                    jSONObject.put("freeze", value.getIsFreeze());
                    jSONArray.put(jSONObject);
                }
                if (StatConfig.o()) {
                    StatConfig.b().a("ABTEST writeFreezeExpFile \n", jSONArray.toString());
                }
                FileUtils.a(b(str), jSONArray.toString());
            } catch (Exception e) {
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static File b(String str) {
        File filesDir = StatConfig.a().getFilesDir();
        return new File(filesDir, "abtest_freeze_exp_" + FileUtils.a(str));
    }
}
