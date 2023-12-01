package com.tencent.cloud.huiyansdkface.a.a;

import com.tencent.connect.share.QzonePublish;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/a/a/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private HashMap<EnumC0732a, Object> f21732a = new HashMap<>();
    private com.tencent.cloud.huiyansdkface.a.e.b b;

    /* renamed from: com.tencent.cloud.huiyansdkface.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/a/a/a$a.class */
    public enum EnumC0732a {
        PREVIEW_SIZE("previewSize"),
        PICTURE_SIZE("pictureSize"),
        ZOOM("zoom"),
        FLASH_MODE("flashMode"),
        FOCUS_MODE("focusMode"),
        FPS("fps"),
        VIDEO_SIZE(QzonePublish.PUBLISH_TO_QZONE_VIDEO_SIZE);
        
        private String h;

        EnumC0732a(String str) {
            this.h = str;
        }
    }

    public com.tencent.cloud.huiyansdkface.a.a.a.d a() {
        return (com.tencent.cloud.huiyansdkface.a.a.a.d) this.f21732a.get(EnumC0732a.PREVIEW_SIZE);
    }

    public a a(float f) {
        if (f >= 0.0f && f <= 1.0f) {
            this.f21732a.put(EnumC0732a.ZOOM, Float.valueOf(f));
        }
        return this;
    }

    public a a(com.tencent.cloud.huiyansdkface.a.a.a.b bVar) {
        if (bVar != null) {
            this.f21732a.put(EnumC0732a.FPS, bVar);
        }
        return this;
    }

    public a a(com.tencent.cloud.huiyansdkface.a.a.a.d dVar) {
        if (dVar != null) {
            this.f21732a.put(EnumC0732a.PREVIEW_SIZE, dVar);
        }
        return this;
    }

    public a a(com.tencent.cloud.huiyansdkface.a.e.b bVar) {
        this.b = bVar;
        return this;
    }

    public a a(String str) {
        if (str != null) {
            this.f21732a.put(EnumC0732a.FLASH_MODE, str);
        }
        return this;
    }

    public com.tencent.cloud.huiyansdkface.a.a.a.b b() {
        return (com.tencent.cloud.huiyansdkface.a.a.a.b) this.f21732a.get(EnumC0732a.FPS);
    }

    public a b(com.tencent.cloud.huiyansdkface.a.a.a.d dVar) {
        if (dVar != null) {
            this.f21732a.put(EnumC0732a.VIDEO_SIZE, dVar);
        }
        return this;
    }

    public a b(String str) {
        if (str != null) {
            this.f21732a.put(EnumC0732a.FOCUS_MODE, str);
        }
        return this;
    }

    public com.tencent.cloud.huiyansdkface.a.a.a.d c() {
        return (com.tencent.cloud.huiyansdkface.a.a.a.d) this.f21732a.get(EnumC0732a.PICTURE_SIZE);
    }

    public a c(com.tencent.cloud.huiyansdkface.a.a.a.d dVar) {
        if (dVar != null) {
            this.f21732a.put(EnumC0732a.PICTURE_SIZE, dVar);
        }
        return this;
    }

    public float d() {
        Object obj = this.f21732a.get(EnumC0732a.ZOOM);
        if (obj == null) {
            return -1.0f;
        }
        return ((Float) obj).floatValue();
    }

    public String e() {
        return (String) this.f21732a.get(EnumC0732a.FLASH_MODE);
    }

    public String f() {
        return (String) this.f21732a.get(EnumC0732a.FOCUS_MODE);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CameraConfig:\n--------------------------------------\n");
        for (Map.Entry<EnumC0732a, Object> entry : this.f21732a.entrySet()) {
            sb.append(entry.getKey());
            sb.append(":");
            Object value = entry.getValue();
            if (value != null) {
                if (!(value instanceof com.tencent.cloud.huiyansdkface.a.a.a.d) && (value instanceof String)) {
                    sb.append(value);
                } else {
                    sb.append(value.toString());
                }
                sb.append("\n");
            }
        }
        sb.append("--------------------------------------");
        return sb.toString();
    }
}
