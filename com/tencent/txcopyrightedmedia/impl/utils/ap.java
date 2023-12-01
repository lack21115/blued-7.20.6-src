package com.tencent.txcopyrightedmedia.impl.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.cos.xml.crypto.JceEncryptionConstants;
import com.tencent.open.GameAppOperation;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.concurrent.CountDownLatch;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/txcopyrightedmedia/impl/utils/ap.class */
public final class ap {
    private static ap h;

    /* renamed from: a  reason: collision with root package name */
    public Context f40059a;
    private String f = "YTFaceSDK.licence";
    private String g = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAq4teqkW/TUruU89ElNVd\nKrpSL+HCITruyb6BS9mW6M4mqmxDhazDmQgMKNfsA0d2kxFucCsXTyesFNajaisk\nrAzVJpNGO75bQFap4jYzJYskIuas6fgIS7zSmGXgRcp6i0ZBH3pkVCXcgfLfsVCO\n+sN01jFhFgOC0LY2f1pJ+3jqktAlMIxy8Q9t7XwwL5/n8/Sledp7TwuRdnl2OPl3\nycCTRkXtOIoRNB9vgd9XooTKiEdCXC7W9ryvtwCiAB82vEfHWXXgzhsPC13URuFy\n1JqbWJtTCCcfsCVxuBplhVJAQ7JsF5SMntdJDkp7rJLhprgsaim2CRjcVseNmw97\nbwIDAQAB";
    public int b = -1;

    /* renamed from: c  reason: collision with root package name */
    final CountDownLatch f40060c = new CountDownLatch(1);
    private boolean i = false;
    public a d = new a();
    public b e = new b("TXCopyrightedMedia.licence");

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/txcopyrightedmedia/impl/utils/ap$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public String f40062a;
        public String b;

        /* renamed from: c  reason: collision with root package name */
        public String f40063c;
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/txcopyrightedmedia/impl/utils/ap$b.class */
    public final class b {

        /* renamed from: a  reason: collision with root package name */
        public String f40064a;
        String b;

        /* renamed from: c  reason: collision with root package name */
        public String f40065c = "";
        public String d = "";
        public String e = "";
        boolean f = false;
        boolean g = false;
        int h = -1;
        String i = "";

        public b(String str) {
            this.f40064a = str;
            this.b = str + ".tmp";
        }
    }

    private ap() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x010c, code lost:
        r0 = r0.optString("ext");
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0117, code lost:
        if (android.text.TextUtils.isEmpty(r0) != false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x011a, code lost:
        r0 = new org.json.JSONObject(r0);
        r5.d.b = r0.optString("AuthKey");
        r5.d.f40062a = r0.optString("Pid");
        r5.d.f40063c = r0.optString("AppName");
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x014b, code lost:
        r13 = true;
        r14 = true;
        r15 = true;
     */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ee A[Catch: JSONException -> 0x0199, TRY_ENTER, TRY_LEAVE, TryCatch #1 {JSONException -> 0x0199, blocks: (B:14:0x007d, B:19:0x009d, B:21:0x00a6, B:23:0x00b5, B:25:0x00c8, B:29:0x00dd, B:34:0x00ee, B:36:0x00fb, B:40:0x010c, B:42:0x011a), top: B:71:0x007d }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0163  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int a(com.tencent.txcopyrightedmedia.impl.utils.ap.b r6, java.lang.String r7, java.lang.String r8) {
        /*
            Method dump skipped, instructions count: 463
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.txcopyrightedmedia.impl.utils.ap.a(com.tencent.txcopyrightedmedia.impl.utils.ap$b, java.lang.String, java.lang.String):int");
    }

    private static long a(String str) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(str).getTime();
        } catch (Exception e) {
            return -1L;
        }
    }

    public static ap a() {
        if (h == null) {
            h = new ap();
        }
        return h;
    }

    private String b(b bVar) {
        Context context = this.f40059a;
        if (context == null) {
            return null;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences("LicenceCheck.lastModified", 0);
        return sharedPreferences.getString(bVar.f40064a + ".lastModified", null);
    }

    private int c(b bVar) {
        String str;
        String str2 = b() + File.separator + bVar.f40064a;
        if (ak.a(str2)) {
            try {
                str = ak.b(str2);
            } catch (Exception e) {
                str = "";
            }
            if (TextUtils.isEmpty(str)) {
                return -8;
            }
            return c(bVar, str);
        }
        return -7;
    }

    private int c(b bVar, String str) {
        try {
            new JSONObject(str);
            return b(bVar, str);
        } catch (JSONException e) {
            return -1;
        }
    }

    private static String d(b bVar, String str) {
        if (TextUtils.isEmpty(bVar.d)) {
            return "";
        }
        byte[] bytes = bVar.d.getBytes();
        SecretKeySpec secretKeySpec = new SecretKeySpec(bytes, "AES");
        byte[] bArr = new byte[16];
        System.arraycopy((Object) bytes, 0, (Object) bArr, 0, 16);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr);
        byte[] decode = Base64.decode(str, 0);
        try {
            Cipher cipher = Cipher.getInstance(JceEncryptionConstants.SYMMETRIC_CIPHER_METHOD);
            cipher.init(2, secretKeySpec, ivParameterSpec);
            return new String(cipher.doFinal(decode), "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x00e8, code lost:
        if (r6 == 0) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int a(android.content.Context r5) {
        /*
            Method dump skipped, instructions count: 263
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.txcopyrightedmedia.impl.utils.ap.a(android.content.Context):int");
    }

    public final void a(final b bVar) {
        if (TextUtils.isEmpty(bVar.e) || bVar.f) {
            return;
        }
        am amVar = new am() { // from class: com.tencent.txcopyrightedmedia.impl.utils.ap.1
            @Override // com.tencent.txcopyrightedmedia.impl.utils.am
            public final void a() {
                bVar.f = false;
                ap.this.f40060c.countDown();
            }

            @Override // com.tencent.txcopyrightedmedia.impl.utils.am
            public final void a(File file, String str) {
                bVar.f = false;
                if (file == null) {
                    return;
                }
                ap.this.a(bVar, str);
                b bVar2 = bVar;
                String b2 = ak.b(new File(bVar2.f40065c + File.separator + bVar2.b).getAbsolutePath());
                if (TextUtils.isEmpty(b2)) {
                    return;
                }
                if (ap.this.b(bVar, b2) == 0) {
                    ap apVar = ap.this;
                    b bVar3 = bVar;
                    File file2 = new File(apVar.b() + File.separator + bVar3.f40064a);
                    if (file2.exists()) {
                        file2.delete();
                    }
                    File file3 = new File(bVar3.f40065c + File.separator + bVar3.b);
                    if (file3.exists()) {
                        file3.renameTo(file2);
                    }
                    bVar3.g = true;
                }
                ap.this.f40060c.countDown();
            }

            @Override // com.tencent.txcopyrightedmedia.impl.utils.am
            public final void b() {
                bVar.f = false;
                ap.this.f40060c.countDown();
            }
        };
        if (this.f40059a == null) {
            return;
        }
        this.i = true;
        bVar.f40065c = b();
        new Thread(new an(this.f40059a, bVar.e, bVar.f40065c, bVar.b, amVar, b(bVar))).start();
        bVar.f = true;
    }

    public final void a(b bVar, String str) {
        Context context = this.f40059a;
        if (context == null) {
            return;
        }
        SharedPreferences.Editor edit = context.getSharedPreferences("LicenceCheck.lastModified", 0).edit();
        edit.putString(bVar.f40064a + ".lastModified", str);
        edit.apply();
    }

    final int b(b bVar, String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.b = jSONObject.optInt("appId");
            String string = jSONObject.getString("encryptedLicense");
            String string2 = jSONObject.getString(GameAppOperation.GAME_SIGNATURE);
            new StringBuilder("appid:").append(this.b);
            return a(bVar, string, string2);
        } catch (JSONException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public final String b() {
        File filesDir = this.f40059a.getFilesDir();
        File file = new File(filesDir + File.separator + "liteav/licence");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }
}
