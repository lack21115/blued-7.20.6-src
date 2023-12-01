package com.tencent.cloud.huiyansdkface.wehttp2;

import android.content.ClipDescription;
import com.huawei.openalliance.ad.constant.ax;
import com.tencent.cloud.huiyansdkface.okhttp3.MediaType;
import com.tencent.qcloud.core.http.HttpConstants;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/wehttp2/MediaTypes.class */
public class MediaTypes {

    /* renamed from: a  reason: collision with root package name */
    public static final MediaType f36091a = MediaType.parse(ax.Z);
    public static final MediaType b = MediaType.parse(ax.I);

    /* renamed from: c  reason: collision with root package name */
    public static final MediaType f36092c = MediaType.parse(ax.B);
    public static final MediaType d = MediaType.parse("text/plain");
    public static final MediaType e = MediaType.parse(ClipDescription.MIMETYPE_TEXT_HTML);
    public static final MediaType f = MediaType.parse("text/xml");
    public static final MediaType g = MediaType.parse("application/json");
    public static final MediaType h = MediaType.parse("application/x-www-form-urlencoded");
    public static final MediaType i = MediaType.parse(HttpConstants.ContentType.MULTIPART_FORM_DATA);
    public static final MediaType j = MediaType.parse("application/octet-stream");
}
