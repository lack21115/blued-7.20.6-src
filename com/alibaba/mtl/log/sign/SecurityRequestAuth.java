package com.alibaba.mtl.log.sign;

import com.alibaba.mtl.log.e.i;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;

/* loaded from: source-6737240-dex2jar.jar:com/alibaba/mtl/log/sign/SecurityRequestAuth.class */
public class SecurityRequestAuth implements IRequestAuth {
    private String Z;

    /* renamed from: b  reason: collision with other field name */
    private String f43b;
    private Object b = null;

    /* renamed from: c  reason: collision with root package name */
    private Object f4504c = null;

    /* renamed from: a  reason: collision with root package name */
    private Class f4503a = null;

    /* renamed from: a  reason: collision with other field name */
    private Field f41a = null;

    /* renamed from: b  reason: collision with other field name */
    private Field f44b = null;

    /* renamed from: c  reason: collision with other field name */
    private Field f45c = null;

    /* renamed from: a  reason: collision with other field name */
    private Method f42a = null;
    private int z = 1;
    private boolean D = false;

    public SecurityRequestAuth(String str, String str2) {
        this.f43b = null;
        this.f43b = str;
        this.Z = str2;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x006a A[Catch: all -> 0x010d, TRY_ENTER, TryCatch #5 {, blocks: (B:4:0x0002, B:37:0x0117, B:17:0x005d, B:20:0x006a, B:28:0x00b9, B:33:0x00e7, B:29:0x00cf, B:22:0x009d), top: B:57:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void F() {
        /*
            Method dump skipped, instructions count: 317
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.mtl.log.sign.SecurityRequestAuth.F():void");
    }

    @Override // com.alibaba.mtl.log.sign.IRequestAuth
    public String getAppkey() {
        return this.f43b;
    }

    @Override // com.alibaba.mtl.log.sign.IRequestAuth
    public String getSign(String str) {
        Class cls;
        if (!this.D) {
            F();
        }
        if (this.f43b == null) {
            i.a("SecurityRequestAuth", "There is no appkey,please check it!");
            return null;
        } else if (str == null || this.b == null || (cls = this.f4503a) == null || this.f41a == null || this.f44b == null || this.f45c == null || this.f42a == null || this.f4504c == null) {
            return null;
        } else {
            try {
                Object newInstance = cls.newInstance();
                this.f41a.set(newInstance, this.f43b);
                ((Map) this.f44b.get(newInstance)).put("INPUT", str);
                this.f45c.set(newInstance, Integer.valueOf(this.z));
                return (String) this.f42a.invoke(this.f4504c, newInstance, this.Z);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }
}
