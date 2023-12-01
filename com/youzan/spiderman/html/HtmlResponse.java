package com.youzan.spiderman.html;

import android.content.ClipDescription;
import com.youzan.spiderman.utils.JsonUtil;
import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/spiderman/html/HtmlResponse.class */
public class HtmlResponse {

    /* renamed from: a  reason: collision with root package name */
    private Map<String, List<String>> f41820a;
    private byte[] b;

    /* renamed from: c  reason: collision with root package name */
    private String f41821c;

    public HtmlResponse(Map<String, List<String>> map, byte[] bArr, String str) {
        this.f41820a = map;
        this.b = bArr;
        this.f41821c = str;
    }

    public ByteArrayInputStream getContentStream() {
        return new ByteArrayInputStream(this.b);
    }

    public String getEncoding() {
        return this.f41821c;
    }

    public Map<String, List<String>> getHeader() {
        return this.f41820a;
    }

    public String getMimeType() {
        return ClipDescription.MIMETYPE_TEXT_HTML;
    }

    public List<String> getResponseHeader(String str) {
        if (str != null) {
            return this.f41820a.get(str);
        }
        return null;
    }

    public Map<String, String> getTransferHeader() {
        return HtmlHeader.transferHeaderMapList(this.f41820a);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nheader:  ");
        sb.append(JsonUtil.toJson(this.f41820a));
        sb.append("\nencoding:  ");
        sb.append(this.f41821c);
        sb.append("\nhtml:  ");
        sb.append(this.b);
        sb.append(", size:" + this.b.length);
        return sb.toString();
    }
}
