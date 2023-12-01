package com.tencent.cloud.huiyansdkface.wehttp2;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/wehttp2/WeConfigLoader.class */
public class WeConfigLoader implements ConfigLoader {

    /* renamed from: a  reason: collision with root package name */
    private Context f22430a;
    private SharedPreferences b;

    /* renamed from: c  reason: collision with root package name */
    private WeConfig f22431c;
    private boolean d = false;
    private boolean e = false;
    private boolean f = false;
    private boolean g = false;
    private ExtConfigLoader h = new ExtConfigLoader() { // from class: com.tencent.cloud.huiyansdkface.wehttp2.WeConfigLoader.1
        @Override // com.tencent.cloud.huiyansdkface.wehttp2.WeConfigLoader.ExtConfigLoader
        public void onLoad(String str, Object obj, WeConfig weConfig) {
        }

        @Override // com.tencent.cloud.huiyansdkface.wehttp2.WeConfigLoader.ExtConfigLoader
        public Map<String, Object> onSave(WeConfig weConfig) {
            return Collections.emptyMap();
        }
    };

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/wehttp2/WeConfigLoader$ExtConfigLoader.class */
    public interface ExtConfigLoader {
        void onLoad(String str, Object obj, WeConfig weConfig);

        Map<String, Object> onSave(WeConfig weConfig);
    }

    public WeConfigLoader(Context context, WeConfig weConfig, String str) {
        if (context == null) {
            throw new IllegalArgumentException("context must not be null");
        }
        if (weConfig == null) {
            throw new IllegalArgumentException("weConfig must not be null");
        }
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("saveConfigName is empty");
        }
        this.f22431c = weConfig;
        Context applicationContext = context.getApplicationContext();
        this.f22430a = applicationContext;
        this.b = applicationContext.getSharedPreferences("wehttp_config_save_" + str, 0);
    }

    protected Map<String, Object> a(WeConfig weConfig) {
        return this.h.onSave(weConfig);
    }

    protected void a(String str, Object obj, WeConfig weConfig) {
        this.h.onLoad(str, obj, weConfig);
    }

    @Override // com.tencent.cloud.huiyansdkface.wehttp2.ConfigLoader
    public void loadOnce() {
        Set<String> set;
        if (this.d) {
            return;
        }
        this.d = true;
        for (Map.Entry<String, ?> entry : this.b.getAll().entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (key != null && value != null) {
                if ("baseUrl".equals(key)) {
                    this.f22431c.baseUrl((String) value);
                } else if ("certVerify".equals(key)) {
                    if (this.e) {
                        this.f22431c.setCertVerify(((Boolean) value).booleanValue());
                    }
                } else if ("pinList".equals(key)) {
                    if (this.e && (set = (Set) value) != null && !set.isEmpty()) {
                        for (String str : set) {
                            if (str.contains(":::")) {
                                String[] split = str.split(":::");
                                this.f22431c.addPin4Host(split[0], split[1]);
                            }
                        }
                    }
                } else if (key.startsWith("_header_")) {
                    if (this.f) {
                        this.f22431c.header(key.substring(8), (String) value);
                    }
                } else if (!key.startsWith("_param_")) {
                    a(key, value, this.f22431c);
                } else if (this.g) {
                    this.f22431c.params(key.substring(7), (String) value);
                }
            }
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.wehttp2.ConfigLoader
    public void save() {
        int i;
        Map.Entry<String, String> next;
        Map.Entry<String, String> next2;
        SharedPreferences.Editor edit = this.b.edit();
        String baseUrl = this.f22431c.getBaseUrl();
        if (baseUrl != null) {
            edit.putString("baseUrl", baseUrl);
            i = 1;
        } else {
            i = 0;
        }
        int i2 = i;
        if (this.e) {
            boolean isCertVerify = this.f22431c.isCertVerify();
            int i3 = i;
            if (isCertVerify) {
                i3 = i + 1;
                edit.putBoolean("certVerify", isCertVerify);
            }
            List<Pin> pinList = this.f22431c.getPinList();
            i2 = i3;
            if (pinList != null) {
                i2 = i3;
                if (pinList.size() > 0) {
                    HashSet hashSet = new HashSet();
                    for (Pin pin : pinList) {
                        if (pin.getPattern() != null && pin.getPin() != null) {
                            hashSet.add(pin.getPattern() + ":::" + pin.getPin());
                        }
                    }
                    i2 = i3;
                    if (hashSet.size() > 0) {
                        i2 = i3 + 1;
                        edit.putStringSet("pinList", hashSet);
                    }
                }
            }
        }
        int i4 = i2;
        if (this.g) {
            Map<String, String> params = this.f22431c.getParams();
            i4 = i2;
            if (params != null) {
                i4 = i2;
                if (params.size() > 0) {
                    Iterator<Map.Entry<String, String>> it = params.entrySet().iterator();
                    while (true) {
                        i4 = i2;
                        if (!it.hasNext()) {
                            break;
                        }
                        i2++;
                        edit.putString("_param_" + next2.getKey(), it.next().getValue());
                    }
                }
            }
        }
        int i5 = i4;
        if (this.f) {
            Map<String, String> headers = this.f22431c.getHeaders();
            i5 = i4;
            if (headers != null) {
                i5 = i4;
                if (headers.size() > 0) {
                    Iterator<Map.Entry<String, String>> it2 = headers.entrySet().iterator();
                    while (true) {
                        i5 = i4;
                        if (!it2.hasNext()) {
                            break;
                        }
                        i4++;
                        edit.putString("_header_" + next.getKey(), it2.next().getValue());
                    }
                }
            }
        }
        Map<String, Object> a2 = a(this.f22431c);
        int i6 = i5;
        if (a2 != null) {
            i6 = i5;
            if (a2.size() > 0) {
                Iterator<Map.Entry<String, Object>> it3 = a2.entrySet().iterator();
                while (true) {
                    i6 = i5;
                    if (!it3.hasNext()) {
                        break;
                    }
                    Map.Entry<String, Object> next3 = it3.next();
                    String key = next3.getKey();
                    Object value = next3.getValue();
                    if (key != null && value != null) {
                        i5++;
                        if (value instanceof String) {
                            edit.putString(key, (String) value);
                        } else if (value instanceof Long) {
                            edit.putLong(key, ((Long) value).longValue());
                        } else if (value instanceof Integer) {
                            edit.putInt(key, ((Integer) value).intValue());
                        } else if (value instanceof Boolean) {
                            edit.putBoolean(key, ((Boolean) value).booleanValue());
                        } else if (value instanceof Float) {
                            edit.putFloat(key, ((Float) value).floatValue());
                        } else if (value instanceof Set) {
                            edit.putStringSet(key, (Set) value);
                        } else {
                            i5--;
                        }
                    }
                }
            }
        }
        if (i6 > 0) {
            edit.commit();
        }
    }

    public WeConfigLoader setExtConfigLoader(ExtConfigLoader extConfigLoader) {
        if (extConfigLoader != null) {
            this.h = extConfigLoader;
        }
        return this;
    }

    public WeConfigLoader setSaveHeader(boolean z) {
        this.f = z;
        return this;
    }

    public WeConfigLoader setSaveParam(boolean z) {
        this.g = z;
        return this;
    }

    public WeConfigLoader setSavePin(boolean z) {
        this.e = z;
        return this;
    }
}
