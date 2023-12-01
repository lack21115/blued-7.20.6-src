package com.tencent.cloud.huiyansdkface.wehttp2;

import android.text.TextUtils;
import android.util.Log;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.tencent.cloud.huiyansdkface.okhttp3.MediaType;
import com.tencent.cloud.huiyansdkface.okhttp3.MultipartBody;
import com.tencent.cloud.huiyansdkface.okhttp3.RequestBody;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/wehttp2/BodyReq.class */
public class BodyReq extends BaseReq<BodyReq> {
    private RequestBody f;
    private File g;
    private List<MultiPart> h;
    private Map<String, String> i;
    private MediaType j;

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/wehttp2/BodyReq$MultiPart.class */
    public static class MultiPart {

        /* renamed from: a  reason: collision with root package name */
        public String f36077a;
        public String b;

        /* renamed from: c  reason: collision with root package name */
        public File f36078c;
        public byte[] d;
        public String e;
        public MediaType f;

        public MultiPart(String str, String str2, MediaType mediaType) {
            this.f36077a = str;
            this.e = str2;
            this.f = mediaType;
        }

        public MultiPart(String str, String str2, File file, MediaType mediaType) {
            this.f36077a = str;
            String str3 = str2;
            if (str2 != null) {
                try {
                    str3 = URLEncoder.encode(str2, "UTF8");
                } catch (UnsupportedEncodingException e) {
                    str3 = str2;
                }
            }
            this.b = str3;
            this.f36078c = file;
            this.f = mediaType;
        }

        public MultiPart(String str, byte[] bArr, MediaType mediaType) {
            this.f36077a = str;
            this.d = bArr;
            this.f = mediaType;
        }

        public static MultiPart create(String str, File file, MediaType mediaType) {
            return new MultiPart(str, null, file, mediaType);
        }

        public static MultiPart create(String str, String str2, MediaType mediaType) {
            return new MultiPart(str, str2, mediaType);
        }

        public static MultiPart create(String str, String str2, File file, MediaType mediaType) {
            return new MultiPart(str, str2, file, mediaType);
        }

        public static MultiPart create(String str, String str2, byte[] bArr, MediaType mediaType) {
            MultiPart multiPart = new MultiPart(str, bArr, mediaType);
            multiPart.b = str2;
            return multiPart;
        }

        public static MultiPart create(String str, byte[] bArr, MediaType mediaType) {
            return new MultiPart(str, bArr, mediaType);
        }
    }

    public BodyReq(WeOkHttp weOkHttp, String str, String str2) {
        super(weOkHttp, str, str2);
        this.h = new ArrayList();
        this.i = new HashMap();
    }

    private MediaType a(File file) {
        if (file != null) {
            String name = file.getName();
            return name.endsWith(".png") ? MediaType.f35863a : (name.endsWith(".jpg") || name.endsWith(".jpeg")) ? MediaType.b : name.endsWith(".gif") ? MediaType.f35864c : MediaType.j;
        }
        throw new IllegalArgumentException("file 不能为null");
    }

    private String a(Map<String, String> map) {
        if (map == null || map.size() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            sb.append(entry.getKey());
            sb.append("=");
            try {
                sb.append(URLEncoder.encode(entry.getValue(), "utf-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            sb.append('&');
        }
        String sb2 = sb.toString();
        String str = sb2;
        if (sb2.endsWith("&")) {
            str = sb2.substring(0, sb2.length() - 1);
        }
        return str;
    }

    private boolean d() {
        return this.j != null && MediaType.i.type().equals(this.j.type());
    }

    public BodyReq addBodyQuery(String str, String str2) {
        this.i.put(str, str2);
        return this;
    }

    public BodyReq addBodyQuery(Map<String, String> map) {
        if (map != null) {
            if (map.size() == 0) {
                return this;
            }
            this.i.putAll(map);
        }
        return this;
    }

    public BodyReq addPart(String str, File file) {
        addPart(str, file, a(file));
        return this;
    }

    public BodyReq addPart(String str, File file, MediaType mediaType) {
        return addPart(str, file != null ? file.getName() : null, file, mediaType);
    }

    public BodyReq addPart(String str, String str2, MediaType mediaType) {
        if (str2 != null && !TextUtils.isEmpty(str)) {
            this.h.add(MultiPart.create(str, str2, mediaType));
            return this;
        }
        return this;
    }

    public BodyReq addPart(String str, String str2, File file) {
        return addPart(str, str2, file, a(file));
    }

    public BodyReq addPart(String str, String str2, File file, MediaType mediaType) {
        if (file != null) {
            if (!d()) {
                multiPart();
            }
            this.h.add(MultiPart.create(str, str2, file, mediaType));
            return this;
        }
        throw new IllegalArgumentException("file cannot be null");
    }

    public BodyReq addPart(String str, String str2, byte[] bArr, MediaType mediaType) {
        if (!d()) {
            multiPart();
        }
        this.h.add(MultiPart.create(str, str2, bArr, mediaType));
        return this;
    }

    public BodyReq addPart(String str, byte[] bArr, MediaType mediaType) {
        if (bArr != null && !TextUtils.isEmpty(str)) {
            MediaType mediaType2 = mediaType;
            if (mediaType == null) {
                mediaType2 = MediaType.j;
            }
            this.h.add(MultiPart.create(str, bArr, mediaType2));
            return this;
        }
        return this;
    }

    @Deprecated
    public BodyReq body(Object obj) {
        boolean z;
        boolean z2;
        if (obj == null) {
            return bodyJson("");
        }
        Field[] declaredFields = obj.getClass().getDeclaredFields();
        Field[] declaredFields2 = obj.getClass().getSuperclass().getDeclaredFields();
        int length = declaredFields.length + declaredFields2.length;
        Field[] fieldArr = new Field[length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= declaredFields.length) {
                break;
            }
            fieldArr[i2] = declaredFields[i2];
            i = i2 + 1;
        }
        int length2 = declaredFields.length;
        while (true) {
            int i3 = length2;
            if (i3 >= length) {
                break;
            }
            fieldArr[i3] = declaredFields2[i3 - declaredFields.length];
            length2 = i3 + 1;
        }
        if (length == 0) {
            return bodyJson("");
        }
        HashMap hashMap = new HashMap();
        int i4 = 0;
        boolean z3 = false;
        while (true) {
            z = z3;
            if (i4 >= length) {
                break;
            }
            Field field = fieldArr[i4];
            try {
                int modifiers = field.getModifiers();
                if ((modifiers & 8) != 0) {
                    z2 = z;
                } else {
                    String name = field.getName();
                    if ((modifiers & 1) != 0) {
                        Object obj2 = field.get(obj);
                        z2 = z;
                        if (obj2 != null) {
                            hashMap.put(name, obj2);
                            z2 = z;
                            if (field.getType().equals(File.class)) {
                                z2 = true;
                            }
                        }
                    } else {
                        Class<?> cls = obj.getClass();
                        StringBuilder sb = new StringBuilder();
                        sb.append(MonitorConstants.CONNECT_TYPE_GET);
                        sb.append(name.substring(0, 1).toUpperCase());
                        sb.append(name.length() == 1 ? "" : name.substring(1));
                        Method method = cls.getMethod(sb.toString(), new Class[0]);
                        z2 = z;
                        if (method != null) {
                            Object invoke = method.invoke(obj, new Object[0]);
                            z2 = z;
                            if (invoke != null) {
                                hashMap.put(name, invoke);
                                z2 = z;
                                if (!field.getType().equals(File.class)) {
                                }
                                z2 = true;
                            }
                        }
                    }
                }
                i4++;
                z3 = z2;
            } catch (NoSuchMethodException e) {
            } catch (Exception e2) {
                Log.w("BodyReq", e2.getClass().getSimpleName() + ":" + e2.getMessage());
            }
        }
        if (z || !(this.j == null || MediaType.g.equals(this.j))) {
            for (Map.Entry entry : hashMap.entrySet()) {
                Object value = entry.getValue();
                boolean z4 = value instanceof File;
                String str = (String) entry.getKey();
                if (z4) {
                    addPart(str, (File) value);
                } else {
                    addBodyQuery(str, String.valueOf(value));
                }
            }
            return this;
        }
        return bodyJson(obj);
    }

    public BodyReq bodyFile(File file) {
        return bodyFile(file, a(file));
    }

    public BodyReq bodyFile(File file, MediaType mediaType) {
        if (file != null) {
            if (mediaType == null) {
                return bodyFile(file);
            }
            this.j = mediaType;
            this.g = file;
            return this;
        }
        throw new IllegalArgumentException("file cannot be null.");
    }

    public BodyReq bodyJson(Object obj) {
        String str;
        if (obj == null) {
            str = "";
        } else {
            TypeAdapter adapter = this.d.config().adapter();
            if (adapter == null) {
                return body(obj);
            }
            str = adapter.to(obj);
        }
        return bodyJson(str);
    }

    public BodyReq bodyJson(String str) {
        this.j = MediaType.g;
        this.f = RequestBody.create(MediaType.g, str);
        return this;
    }

    @Deprecated
    public BodyReq bodyJson(Map<String, Object> map) {
        JSONObject jSONObject = new JSONObject();
        if (map != null || map.size() > 0) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                try {
                    jSONObject.put(entry.getKey(), entry.getValue());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        return bodyJson(jSONObject.toString());
    }

    public BodyReq bodyJson(JSONArray jSONArray) {
        if (jSONArray != null) {
            return bodyJson(jSONArray.toString());
        }
        throw new IllegalArgumentException("array 不能为null");
    }

    public BodyReq bodyJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            return bodyJson(jSONObject.toString());
        }
        throw new IllegalArgumentException("object 不能为null");
    }

    public BodyReq bodyPart(Object obj) {
        multiPart();
        return body(obj);
    }

    public BodyReq bodyText(String str) {
        this.j = MediaType.d;
        this.f = RequestBody.create(MediaType.d, str);
        return this;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0154  */
    @Override // com.tencent.cloud.huiyansdkface.wehttp2.BaseReq
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected com.tencent.cloud.huiyansdkface.okhttp3.Call c() {
        /*
            Method dump skipped, instructions count: 410
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.cloud.huiyansdkface.wehttp2.BodyReq.c():com.tencent.cloud.huiyansdkface.okhttp3.Call");
    }

    public BodyReq formData() {
        this.j = MultipartBody.e;
        return this;
    }

    public BodyReq multiPart() {
        this.j = MultipartBody.f35865a;
        return this;
    }

    public BodyReq multiPart(String str) {
        this.j = MediaType.parse("multipart/" + str);
        return this;
    }
}
