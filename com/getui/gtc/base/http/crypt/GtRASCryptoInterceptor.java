package com.getui.gtc.base.http.crypt;

import android.util.Base64;
import com.getui.gtc.base.crypt.CryptTools;
import com.getui.gtc.base.http.Interceptor;
import com.getui.gtc.base.http.Request;
import com.getui.gtc.base.http.RequestBody;
import com.getui.gtc.base.http.Response;
import com.getui.gtc.base.http.ResponseBody;
import com.getui.gtc.base.http.Util;
import com.youzan.androidsdk.tool.AppSigning;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.List;
import java.util.zip.GZIPOutputStream;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

/* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/base/http/crypt/GtRASCryptoInterceptor.class */
public class GtRASCryptoInterceptor implements Interceptor {
    private String keyId;
    private String publicKeyStr;

    public GtRASCryptoInterceptor(String str, String str2) {
        this.keyId = str;
        this.publicKeyStr = str2;
    }

    @Override // com.getui.gtc.base.http.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        Request.Builder newBuilder = request.newBuilder();
        RequestBody body = request.body();
        if (body != null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            body.writeTo(gZIPOutputStream);
            gZIPOutputStream.finish();
            Util.closeQuietly(gZIPOutputStream);
            Util.closeQuietly(byteArrayOutputStream);
            try {
                newBuilder.addHeader("GT_C_T", "1").addHeader("GT_C_K", this.keyId);
                String valueOf = String.valueOf(System.currentTimeMillis());
                newBuilder.addHeader("GT_T", valueOf);
                byte[] bArr = new byte[16];
                new SecureRandom().nextBytes(bArr);
                PublicKey parsePublicKey = CryptTools.parsePublicKey("RSA", this.publicKeyStr);
                SecretKey generateKey = CryptTools.generateKey("AES", 128);
                byte[] encrypt = CryptTools.encrypt("RSA/NONE/OAEPWithSHA1AndMGF1Padding", parsePublicKey, generateKey.getEncoded());
                byte[] bArr2 = new byte[encrypt.length + 16];
                System.arraycopy(bArr, 0, bArr2, 0, 16);
                System.arraycopy(encrypt, 0, bArr2, 16, encrypt.length);
                newBuilder.addHeader("GT_C_V", Base64.encodeToString(bArr2, 2));
                byte[] bytes = valueOf.getBytes();
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byte[] bArr3 = new byte[bytes.length + byteArray.length];
                System.arraycopy(bytes, 0, bArr3, 0, bytes.length);
                System.arraycopy(byteArray, 0, bArr3, bytes.length, byteArray.length);
                String encodeToString = Base64.encodeToString(CryptTools.digest(AppSigning.SHA1, bArr3), 2);
                newBuilder.addHeader("GT_C_S", encodeToString);
                newBuilder.body(RequestBody.create(body.contentType(), CryptTools.encrypt("AES/CFB/NoPadding", generateKey, new IvParameterSpec(CryptTools.digest("MD5", encodeToString.getBytes())), byteArray)));
                Response proceed = chain.proceed(newBuilder.build());
                if (proceed.code() != 200) {
                    return proceed;
                }
                Response.Builder request2 = proceed.newBuilder().request(request);
                List<String> list = proceed.getHeaders().get("GT_ERR");
                if (list != null && list.size() > 0 && "0".equals(list.get(0))) {
                    request2.removeHeader("GT_ERR");
                    List<String> list2 = proceed.getHeaders().get("GT_T");
                    if (list2 == null || list2.size() <= 0) {
                        throw new SecurityException("GT_T header not found");
                    }
                    byte[] bytes2 = list2.get(0).getBytes();
                    IvParameterSpec ivParameterSpec = new IvParameterSpec(CryptTools.digest("MD5", bytes2));
                    request2.removeHeader("GT_T");
                    List<String> list3 = proceed.getHeaders().get("GT_C_S");
                    if (list3 == null || list3.size() <= 0) {
                        throw new SecurityException("GT_C_S header not found");
                    }
                    byte[] decode = Base64.decode(list3.get(0), 2);
                    byte[] decrypt = CryptTools.decrypt("AES/CFB/NoPadding", generateKey, ivParameterSpec, proceed.body().bytes());
                    byte[] bArr4 = new byte[decrypt.length + bytes2.length];
                    System.arraycopy(bytes2, 0, bArr4, 0, bytes2.length);
                    System.arraycopy(decrypt, 0, bArr4, bytes2.length, decrypt.length);
                    if (Arrays.equals(CryptTools.digest(AppSigning.SHA1, bArr4), decode)) {
                        request2.removeHeader("GT_C_S");
                        request2.body(ResponseBody.create(proceed.body().contentType(), decrypt));
                        return request2.build();
                    }
                    throw new SecurityException("response body sign check failed");
                }
                if (list != null) {
                    throw new SecurityException("GT_ERR header is " + list.get(0));
                }
                throw new SecurityException("GT_ERR header not found");
            } catch (GeneralSecurityException e) {
                throw new RuntimeException("GtRASCryptoInterceptor Error", e);
            }
        }
        throw new RuntimeException("GtRASCryptoInterceptor Error: request body is null");
    }
}
