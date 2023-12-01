package com.youzan.spiderman.b;

import android.text.TextUtils;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;
import com.youzan.spiderman.utils.FileUtil;
import com.youzan.spiderman.utils.JsonUtil;
import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/spiderman/b/a.class */
final class a {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static Map<String, Long> a() {
        File file = new File(com.youzan.spiderman.cache.g.e(), "lru_cache_map_image");
        if (file.exists()) {
            try {
                String fileContent = FileUtil.getFileContent(file.getPath());
                if (TextUtils.isEmpty(fileContent)) {
                    return null;
                }
                return (Map) JsonUtil.fromJson(fileContent, new TypeToken<LinkedHashMap<String, Long>>() { // from class: com.youzan.spiderman.b.a.2
                }.getType());
            } catch (JsonParseException e) {
                e.printStackTrace();
                return null;
            } catch (IOException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(LinkedHashMap<String, Long> linkedHashMap) {
        try {
            FileUtil.writeContentToFile(new File(com.youzan.spiderman.cache.g.e(), "lru_cache_map_script").getPath(), JsonUtil.toJson(linkedHashMap, new TypeToken<LinkedHashMap<String, String>>() { // from class: com.youzan.spiderman.b.a.3
            }.getType()));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Map<String, Long> b() {
        File file = new File(com.youzan.spiderman.cache.g.e(), "lru_cache_map_script");
        if (file.exists()) {
            try {
                String fileContent = FileUtil.getFileContent(file.getPath());
                if (TextUtils.isEmpty(fileContent)) {
                    return null;
                }
                return (Map) JsonUtil.fromJson(fileContent, new TypeToken<LinkedHashMap<String, Long>>() { // from class: com.youzan.spiderman.b.a.4
                }.getType());
            } catch (JsonParseException e) {
                e.printStackTrace();
                return null;
            } catch (IOException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Map<String, Long> c() {
        File file = new File(com.youzan.spiderman.cache.g.e(), "lru_cache_map_html_data");
        if (file.exists()) {
            try {
                String fileContent = FileUtil.getFileContent(file.getPath());
                if (TextUtils.isEmpty(fileContent)) {
                    return null;
                }
                return (Map) JsonUtil.fromJson(fileContent, new TypeToken<LinkedHashMap<String, Long>>() { // from class: com.youzan.spiderman.b.a.6
                }.getType());
            } catch (JsonParseException e) {
                e.printStackTrace();
                return null;
            } catch (IOException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return null;
    }
}
