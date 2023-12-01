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
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

/* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/base/http/crypt/PtRASCryptoInterceptor.class */
public class PtRASCryptoInterceptor implements Interceptor {
    private SecretKey aesKey;
    private String encryptedAesKey;
    private String keyId;
    private String publicKeyStr;
    private PublicKey rsaPublicKey;

    public PtRASCryptoInterceptor(String str, String str2) {
        this.keyId = str;
        this.publicKeyStr = str2;
        try {
            this.rsaPublicKey = CryptTools.parsePublicKey("RSA", str2);
            SecretKey generateKey = CryptTools.generateKey("AES", 128);
            this.aesKey = generateKey;
            this.encryptedAesKey = Base64.encodeToString(CryptTools.encrypt("RSA/NONE/OAEPWithSHA1AndMGF1Padding", this.rsaPublicKey, generateKey.getEncoded()), 2);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.getui.gtc.base.http.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        Request.Builder newBuilder = request.newBuilder();
        RequestBody body = request.body();
        if (body != null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            body.writeTo(byteArrayOutputStream);
            Util.closeQuietly(byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            String str = new String(byteArray, body.contentType().charset());
            try {
                boolean startsWith = request.url().toString().toLowerCase().startsWith("https");
                newBuilder.addHeader("X-TP", startsWith ? "4" : "3").addHeader("X-KD", this.keyId).addHeader("X-V", "1.0.1.0");
                if (!startsWith) {
                    newBuilder.addHeader("X-TL", "10");
                    SecretKey generateKey = CryptTools.generateKey("AES", 128);
                    this.aesKey = generateKey;
                    this.encryptedAesKey = Base64.encodeToString(CryptTools.encrypt("RSA/NONE/OAEPWithSHA1AndMGF1Padding", this.rsaPublicKey, generateKey.getEncoded()), 2);
                }
                newBuilder.addHeader("X-AK", this.encryptedAesKey);
                String encodeToString = Base64.encodeToString(this.aesKey.getEncoded(), 2);
                String encodeToString2 = Base64.encodeToString(CryptTools.digest(AppSigning.SHA256, (this.keyId + encodeToString + str).getBytes()), 2);
                newBuilder.addHeader("X-SG", encodeToString2);
                IvParameterSpec ivParameterSpec = new IvParameterSpec(CryptTools.digest("md5", encodeToString2.getBytes()));
                newBuilder.body(RequestBody.create(body.contentType(), CryptTools.encrypt("AES/CFB/NoPadding", this.aesKey, ivParameterSpec, byteArray)));
                Response proceed = chain.proceed(newBuilder.build());
                if (proceed.code() != 200) {
                    return proceed;
                }
                Response.Builder request2 = proceed.newBuilder().request(request);
                request2.body(ResponseBody.create(proceed.body().contentType(), CryptTools.decrypt("AES/CFB/NoPadding", this.aesKey, ivParameterSpec, proceed.body().bytes())));
                return request2.build();
            } catch (GeneralSecurityException e) {
                throw new RuntimeException("PtRASCryptoInterceptor Error", e);
            }
        }
        throw new RuntimeException("PtRASCryptoInterceptor Error: request body is null");
    }
}
