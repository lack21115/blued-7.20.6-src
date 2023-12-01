package com.qiniu.android.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/android/utils/StringMap.class */
public final class StringMap {
    private Map<String, Object> map;

    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/android/utils/StringMap$Consumer.class */
    public interface Consumer {
        void accept(String str, Object obj);
    }

    public StringMap() {
        this(new HashMap());
    }

    public StringMap(Map<String, Object> map) {
        this.map = map;
    }

    public void forEach(Consumer consumer) {
        for (Map.Entry<String, Object> entry : this.map.entrySet()) {
            consumer.accept(entry.getKey(), entry.getValue());
        }
    }

    public String formString() {
        final StringBuilder sb = new StringBuilder();
        forEach(new Consumer() { // from class: com.qiniu.android.utils.StringMap.1
            private boolean notStart = false;

            @Override // com.qiniu.android.utils.StringMap.Consumer
            public void accept(String str, Object obj) {
                if (this.notStart) {
                    sb.append("&");
                }
                try {
                    StringBuilder sb2 = sb;
                    sb2.append(URLEncoder.encode(str, "UTF-8"));
                    sb2.append('=');
                    sb2.append(URLEncoder.encode(obj.toString(), "UTF-8"));
                    this.notStart = true;
                } catch (UnsupportedEncodingException e) {
                    throw new AssertionError(e);
                }
            }
        });
        return sb.toString();
    }

    public Object get(String str) {
        return this.map.get(str);
    }

    public Map<String, Object> map() {
        return this.map;
    }

    public StringMap put(String str, Object obj) {
        this.map.put(str, obj);
        return this;
    }

    public StringMap putAll(StringMap stringMap) {
        this.map.putAll(stringMap.map);
        return this;
    }

    public StringMap putAll(Map<String, Object> map) {
        this.map.putAll(map);
        return this;
    }

    public StringMap putFileds(Map<String, String> map) {
        this.map.putAll(map);
        return this;
    }

    public StringMap putNotEmpty(String str, String str2) {
        if (!StringUtils.isNullOrEmpty(str2)) {
            this.map.put(str, str2);
        }
        return this;
    }

    public StringMap putNotNull(String str, Object obj) {
        if (obj != null) {
            this.map.put(str, obj);
        }
        return this;
    }

    public StringMap putWhen(String str, Object obj, boolean z) {
        if (z) {
            this.map.put(str, obj);
        }
        return this;
    }

    public int size() {
        return this.map.size();
    }
}
