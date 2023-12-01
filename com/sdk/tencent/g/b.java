package com.sdk.tencent.g;

import android.content.Context;
import com.sdk.tencent.a.d;
import com.sdk.tencent.a.e;
import com.sdk.tencent.base.framework.bean.AInfo;
import com.sdk.tencent.base.framework.bean.DataInfo;
import com.sdk.tencent.base.framework.bean.KInfo;
import com.sdk.tencent.base.framework.bean.MobileKInfo;
import com.sdk.tencent.base.framework.bean.PInfo;
import com.sdk.tencent.base.framework.bean.SInfo;
import com.sdk.tencent.base.framework.utils.app.AppUtils;
import com.sdk.tencent.base.module.config.BaseConfig;
import com.sdk.tencent.d.g;
import com.sdk.tencent.f.c;
import com.tencent.cos.xml.crypto.JceEncryptionConstants;
import java.nio.charset.Charset;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.concurrent.Executor;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: source-8303388-dex2jar.jar:com/sdk/tencent/g/b.class */
public class b<T> {
    public static final String i = "com.sdk.tencent.g.b";
    public static final boolean j = c.b;

    /* renamed from: a  reason: collision with root package name */
    public PInfo f14366a;
    public AInfo b;

    /* renamed from: c  reason: collision with root package name */
    public SInfo f14367c;
    public ArrayList<KInfo> d;
    public com.sdk.tencent.e.a<T> e;
    public Context f;
    public String g;
    public com.sdk.tencent.f.b h;

    public b(Context context, com.sdk.tencent.e.a<T> aVar, com.sdk.tencent.f.b bVar) {
        this.f = context;
        this.e = aVar;
        this.h = bVar;
    }

    /* JADX WARN: Type inference failed for: r1v43, types: [Params[], java.lang.Object[]] */
    public com.sdk.tencent.a.c<T> a(String str, String str2, DataInfo dataInfo, com.sdk.tencent.e.b<T> bVar, int i2, d.b bVar2) {
        com.sdk.tencent.a.c<T> cVar;
        boolean z;
        if (com.sdk.tencent.n.b.a(str).booleanValue()) {
            a(1, 101008, "未检测到域名");
            return null;
        }
        try {
            TreeMap<String, Object> treeMap = new TreeMap<>();
            String a2 = com.sdk.tencent.q.a.a(16);
            String a3 = com.sdk.tencent.q.a.a(16);
            String apiKey = AppUtils.getApiKey(this.f, BaseConfig.apk);
            String str3 = com.sdk.tencent.t.a.b;
            if ("/st/api/v1.0/ses".equals(str2)) {
                str3 = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCgdQaZgBcrXGxxD6F1TVVXAzvbB3xpoyk2AFMNj4vOcDWZoH1b3Mx5aVcEd0BZPZR6Icb8yi8ecMUVChGCRe20O8EQWLh1aCwR8JazNL+koD3Tn6TIwVwjVEQWy9w6DeXxMtQuFBL/jAChJcU7aDwMsSD1jYpdET37aB4p8Lvn2QIDAQAB";
            }
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= 2) {
                    z = false;
                    break;
                }
                String str4 = new String[]{apiKey, str3}[i4];
                if ((str4 == null || str4.length() < 1) && com.sdk.tencent.n.b.a(str4).booleanValue()) {
                    z = true;
                    break;
                }
                i3 = i4 + 1;
            }
            if (z) {
                a(1, 101004, "ApiKey或PublicKey不能为空");
                return null;
            }
            String a4 = a(dataInfo, a2, a3);
            try {
                String str5 = a2 + a3;
                int i5 = com.sdk.tencent.p.b.f14382a;
                PublicKey a5 = com.sdk.tencent.p.a.a(str3);
                Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
                cipher.init(1, a5);
                String str6 = com.sdk.tencent.q.c.a(cipher.doFinal(str5.getBytes(Charset.defaultCharset()))).toString();
                treeMap.put("apiKey", apiKey);
                treeMap.put("params", a4);
                treeMap.put("paramsKey", str6);
                String a6 = com.sdk.tencent.r.a.a(apiKey, str2, treeMap);
                HashMap<String, Object> hashMap = new HashMap<>(16);
                if (com.sdk.tencent.n.b.b(a6).booleanValue()) {
                    treeMap.put(com.anythink.expressad.d.a.b.d, a6);
                    treeMap.put("sign_Type", "B");
                    hashMap.put(com.anythink.expressad.d.a.b.d, a6);
                    hashMap.put("api-protocol", "1.1");
                }
                e eVar = new e();
                String str7 = bVar2.f14323a;
                if (com.sdk.tencent.n.b.b(str7).booleanValue()) {
                    eVar.f14324a = str7;
                }
                eVar.b = str + str2;
                eVar.g = bVar;
                eVar.f = i2;
                eVar.f14325c = treeMap;
                eVar.d = null;
                eVar.e = hashMap;
                if (!"/dro/netm/v1.0/qc".equals(str2)) {
                    "/dro/ctc/v1.0/gctcbs".equals(str2);
                }
                d dVar = new d(this.f, eVar);
                cVar = new com.sdk.tencent.a.c<>(dVar);
                try {
                    Executor executor = com.sdk.tencent.d.c.h;
                    if (cVar.e) {
                        throw new IllegalStateException("Cannot execute task: the task is already executed.");
                    }
                    cVar.e = true;
                    cVar.f14343a.f14347a = new Object[]{dVar};
                    executor.execute(new g(null, cVar.b));
                    return cVar;
                } catch (Exception e) {
                    e = e;
                    com.sdk.tencent.n.c.b(e.toString());
                    a(1, 302002, "网络访问异常");
                    com.sdk.tencent.n.b.a(i, e.toString(), Boolean.valueOf(j));
                    return cVar;
                }
            } catch (Exception e2) {
                a(1, 101006, "公钥出错");
                com.sdk.tencent.n.b.a(i, "公钥出错：" + e2, Boolean.valueOf(j));
                return null;
            }
        } catch (Exception e3) {
            e = e3;
            cVar = null;
        }
    }

    public final String a(DataInfo dataInfo, String str, String str2) {
        String str3;
        String str4;
        boolean z;
        Object obj;
        try {
            if (this.b == null) {
                Context context = this.f;
                AInfo aInfo = new AInfo();
                aInfo.setN(AppUtils.getAppLable(context));
                aInfo.setC(AppUtils.getVersionCode(context));
                aInfo.setV(AppUtils.getVersionName(context));
                aInfo.setPk(AppUtils.getPackageName(context));
                aInfo.setMd5(AppUtils.getAppMd5(context));
                this.b = aInfo;
            }
            if (this.f14367c == null) {
                SInfo sInfo = new SInfo();
                sInfo.setN(BaseConfig.n);
                sInfo.setC(BaseConfig.f14337c);
                sInfo.setV(BaseConfig.v);
                sInfo.setCm(BaseConfig.cm);
                this.f14367c = sInfo;
            }
            if (this.d == null) {
                this.d = new ArrayList<>();
            }
            ArrayList arrayList = new ArrayList();
            Iterator<KInfo> it = this.d.iterator();
            while (it.hasNext()) {
                KInfo next = it.next();
                MobileKInfo mobileKInfo = new MobileKInfo();
                mobileKInfo.setIe(next.getIe());
                mobileKInfo.setIs(next.getIs());
                mobileKInfo.setM(next.getM());
                mobileKInfo.setIdfd(next.isIdfd());
                arrayList.add(mobileKInfo);
            }
            if (this.f14366a == null) {
                PInfo pInfo = new PInfo();
                pInfo.setOs("Android");
                this.f14366a = pInfo;
            }
            str3 = "{app:" + this.b + ",sdk:" + this.f14367c + ",device:" + this.f14366a + ",sim:" + arrayList + ",data:" + dataInfo + "}";
        } catch (Exception e) {
            com.sdk.tencent.n.b.a(i, e.toString(), Boolean.valueOf(j));
            str3 = null;
        }
        String str5 = com.sdk.tencent.q.a.f14383a;
        if (str3 != null) {
            try {
                if (str3.length() != 0 && str3.trim().length() != 0) {
                    if (str == null) {
                        str4 = com.sdk.tencent.q.a.f14383a;
                        z = com.sdk.tencent.q.a.b;
                        obj = "encrypt key is null";
                    } else if (str.length() != 16) {
                        str4 = com.sdk.tencent.q.a.f14383a;
                        z = com.sdk.tencent.q.a.b;
                        obj = "encrypt key length error";
                    } else if (str2.length() == 16) {
                        Cipher cipher = Cipher.getInstance(JceEncryptionConstants.SYMMETRIC_CIPHER_METHOD);
                        cipher.init(1, new SecretKeySpec(str.getBytes("utf-8"), "AES"), new IvParameterSpec(str2.getBytes("utf-8")));
                        return com.sdk.tencent.q.c.a(cipher.doFinal(str3.getBytes("utf-8")));
                    } else {
                        str4 = com.sdk.tencent.q.a.f14383a;
                        z = com.sdk.tencent.q.a.b;
                        obj = "ivStr length error";
                    }
                    com.sdk.tencent.i.a.logError(str4, "EncryptCbcIv", obj, z);
                    return null;
                }
            } catch (Exception e2) {
                com.sdk.tencent.i.a.logError(com.sdk.tencent.q.a.f14383a, "EncryptCbcIv", e2.getMessage(), com.sdk.tencent.q.a.b);
                return null;
            }
        }
        str4 = com.sdk.tencent.q.a.f14383a;
        z = com.sdk.tencent.q.a.b;
        obj = "encrypt content is null";
        com.sdk.tencent.i.a.logError(str4, "EncryptCbcIv", obj, z);
        return null;
    }

    public void a(int i2, int i3, String str) {
        com.sdk.tencent.e.a<T> aVar = this.e;
        if (aVar != null) {
            aVar.a(i2, i3, str);
            this.e = null;
        }
    }

    public void a(int i2, String str, int i3, T t, String str2) {
        com.sdk.tencent.e.a<T> aVar = this.e;
        if (aVar != null) {
            aVar.onSuccess(i2, str, i3, t, str2);
            this.e = null;
        }
    }
}
