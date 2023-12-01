package com.getui.gtc.base.http;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

/* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/base/http/FormBody.class */
public class FormBody extends RequestBody {
    static final String CHARSET_NAME = "UTF-8";
    static final MediaType CONTENT_TYPE = MediaType.get("application/x-www-form-urlencoded");
    final ByteArrayOutputStream content = new ByteArrayOutputStream();

    public void addField(String str, String str2) {
        addField(str, true, str2, true);
    }

    public void addField(String str, boolean z, String str2, boolean z2) {
        if (str == null) {
            throw new NullPointerException("name");
        }
        if (str2 == null) {
            throw new NullPointerException("value");
        }
        if (this.content.size() > 0) {
            this.content.write(38);
        }
        String str3 = str;
        if (z) {
            try {
                str3 = URLEncoder.encode(str, "UTF-8");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        String str4 = str2;
        if (z2) {
            str4 = URLEncoder.encode(str2, "UTF-8");
        }
        this.content.write(str3.getBytes("UTF-8"));
        this.content.write(61);
        this.content.write(str4.getBytes("UTF-8"));
    }

    @Override // com.getui.gtc.base.http.RequestBody
    public long contentLength() {
        return this.content.size();
    }

    @Override // com.getui.gtc.base.http.RequestBody
    public MediaType contentType() {
        return CONTENT_TYPE;
    }

    @Override // com.getui.gtc.base.http.RequestBody
    public void writeTo(OutputStream outputStream) throws IOException {
        outputStream.write(this.content.toByteArray());
    }
}
