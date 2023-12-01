package com.meizu.cloud.pushsdk.a.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.tencent.cos.xml.crypto.JceEncryptionConstants;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/meizu/cloud/pushsdk/a/a/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static a f23948a;
    private static final Object b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private byte[] f23949c;
    private byte[] d;
    private byte[] e;
    private byte[] f;
    private byte[] g;
    private PublicKey h;
    private final SharedPreferences i;
    private final SharedPreferences j;
    private long k = 0;

    private a(Context context) {
        this.i = context.getSharedPreferences("com.x.y.1", 0);
        this.j = context.getSharedPreferences("com.x.y.2", 0);
        Integer.parseInt(this.i.getString("keyTimeout", "0"));
        this.i.getLong("createDate", 0L);
        e();
        byte[] bArr = this.f23949c;
        if (bArr != null && bArr.length != 0) {
            byte[] bArr2 = this.d;
            if (bArr2 == null || bArr2.length == 0) {
                PublicKey b2 = b(context);
                this.h = b2;
                if (b2 != null) {
                    h();
                    return;
                }
                return;
            }
            return;
        }
        PublicKey b3 = b(context);
        this.h = b3;
        if (b3 != null) {
            f();
            return;
        }
        this.i.edit().clear().apply();
        try {
            d();
            PublicKey b4 = b(context);
            this.h = b4;
            if (b4 != null) {
                f();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static a a() {
        a aVar = f23948a;
        if (aVar != null) {
            return aVar;
        }
        throw new IllegalStateException("KeyMgr is not initialised - invoke at least once with parameterised init/get");
    }

    private String a(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            try {
                int read = inputStream.read();
                if (read == -1) {
                    String byteArrayOutputStream2 = byteArrayOutputStream.toString();
                    try {
                        byteArrayOutputStream.close();
                        return byteArrayOutputStream2;
                    } catch (IOException e) {
                        return byteArrayOutputStream2;
                    }
                }
                byteArrayOutputStream.write(read);
            } catch (IOException e2) {
                try {
                    byteArrayOutputStream.close();
                    return null;
                } catch (IOException e3) {
                    return null;
                }
            } catch (Throwable th) {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e4) {
                }
                throw th;
            }
        }
    }

    public static void a(Context context) {
        if (f23948a == null) {
            synchronized (b) {
                if (f23948a == null) {
                    f23948a = new a(context);
                }
            }
        }
    }

    private PublicKey b(Context context) {
        b("load publicKey from preference");
        String string = this.j.getString("publicKey", "");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(string, 2)));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        } catch (InvalidKeySpecException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private void b(String str) {
        DebugLogger.d("HttpKeyMgr", str);
    }

    private void c(String str) {
        DebugLogger.e("HttpKeyMgr", str);
    }

    private void d() throws IOException {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(PushConstants.URL_DOWNLOAD_PUBLIC_KEY).openConnection();
            httpURLConnection.setDoInput(true);
            httpURLConnection.setUseCaches(false);
            try {
                httpURLConnection.setRequestMethod("GET");
            } catch (ProtocolException e) {
                e.printStackTrace();
            }
            httpURLConnection.setRequestProperty("Charset", "UTF-8");
            InputStream inputStream = null;
            try {
                int responseCode = httpURLConnection.getResponseCode();
                StringBuilder sb = new StringBuilder();
                sb.append("code = ");
                sb.append(responseCode);
                b(sb.toString());
                InputStream inputStream2 = httpURLConnection.getInputStream();
                if (inputStream2 != null) {
                    String a2 = a(inputStream2);
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("body = ");
                    sb2.append(a2);
                    b(sb2.toString());
                    if (!TextUtils.isEmpty(a2)) {
                        inputStream = inputStream2;
                        try {
                            JSONObject jSONObject = new JSONObject(a2);
                            if (jSONObject.getInt("code") == 200) {
                                String string = jSONObject.getString("value");
                                SharedPreferences.Editor edit = this.j.edit();
                                edit.putString("publicKey", string);
                                inputStream = inputStream2;
                                edit.apply();
                            }
                        } catch (Exception e2) {
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append("downloadPublicKey message error ");
                            sb3.append(e2.getMessage());
                            inputStream = inputStream2;
                            c(sb3.toString());
                        }
                    }
                }
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (IOException e3) {
                    }
                }
                httpURLConnection.disconnect();
            } catch (Throwable th) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e4) {
                    }
                }
                httpURLConnection.disconnect();
                throw th;
            }
        } catch (MalformedURLException e5) {
        }
    }

    private void e() {
        b("loadKeys");
        String string = this.i.getString("sKey64", "");
        b("saved sKey64: " + string);
        if (!TextUtils.isEmpty(string)) {
            this.g = string.getBytes();
        }
        String string2 = this.i.getString("aKey64", "");
        b("saved aKey64: " + string2);
        if (!TextUtils.isEmpty(string2)) {
            byte[] bytes = string2.getBytes();
            this.f = bytes;
            this.d = Base64.decode(bytes, 2);
        }
        String string3 = this.i.getString("rKey64", "");
        b("saved rKey64: " + string3);
        if (TextUtils.isEmpty(string3)) {
            return;
        }
        byte[] bytes2 = string3.getBytes();
        this.e = bytes2;
        this.f23949c = Base64.decode(bytes2, 2);
        b("saved rKey: " + new String(this.f23949c));
    }

    private void f() {
        g();
        h();
    }

    private void g() {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(128);
            byte[] encoded = keyGenerator.generateKey().getEncoded();
            this.f23949c = encoded;
            this.e = Base64.encode(encoded, 2);
            b("***** rKey64: " + new String(this.e));
            SharedPreferences.Editor edit = this.i.edit();
            edit.putString("rKey64", new String(this.e));
            edit.apply();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void h() {
        try {
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(1, this.h);
            byte[] doFinal = cipher.doFinal(this.f23949c);
            this.d = doFinal;
            this.f = Base64.encode(doFinal, 2);
            b("***** aKey64: " + new String(this.f));
            SharedPreferences.Editor edit = this.i.edit();
            edit.putString("aKey64", new String(this.f));
            edit.apply();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
        } catch (BadPaddingException e3) {
            e3.printStackTrace();
        } catch (IllegalBlockSizeException e4) {
            e4.printStackTrace();
        } catch (NoSuchPaddingException e5) {
            e5.printStackTrace();
        }
    }

    public void a(String str) {
        this.g = str.getBytes();
        SharedPreferences.Editor edit = this.i.edit();
        edit.putString("sKey64", new String(this.g));
        edit.apply();
    }

    public byte[] a(byte[] bArr) {
        String str;
        byte[] bArr2 = this.f23949c;
        if (bArr2 == null || bArr2.length == 0) {
            str = "rKey null!";
        } else if (bArr != null && bArr.length != 0) {
            b(">>>>>>>>>> encrypt input >>>>>>>>>>\n" + new String(Base64.encode(bArr, 2)));
            b("<<<<<<<<<< encrypt input <<<<<<<<<<");
            try {
                Cipher cipher = Cipher.getInstance(JceEncryptionConstants.SYMMETRIC_CIPHER_METHOD);
                cipher.init(1, new SecretKeySpec(this.f23949c, "AES"), new IvParameterSpec(this.f23949c));
                byte[] doFinal = cipher.doFinal(bArr);
                b(">>>>>>>>>> encrypt output >>>>>>>>>>\n" + new String(Base64.encode(doFinal, 2)));
                b("<<<<<<<<<< encrypt output <<<<<<<<<<");
                return doFinal;
            } catch (InvalidAlgorithmParameterException e) {
                e.printStackTrace();
                return null;
            } catch (InvalidKeyException e2) {
                e2.printStackTrace();
                return null;
            } catch (NoSuchAlgorithmException e3) {
                e3.printStackTrace();
                return null;
            } catch (BadPaddingException e4) {
                e4.printStackTrace();
                return null;
            } catch (IllegalBlockSizeException e5) {
                e5.printStackTrace();
                return null;
            } catch (NoSuchPaddingException e6) {
                e6.printStackTrace();
                return null;
            }
        } else {
            str = "input null!";
        }
        c(str);
        return null;
    }

    public byte[] b() {
        return this.f;
    }

    public byte[] c() {
        return this.g;
    }
}
