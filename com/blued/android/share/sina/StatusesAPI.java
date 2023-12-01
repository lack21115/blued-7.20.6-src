package com.blued.android.share.sina;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.SparseArray;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.net.RequestListener;
import com.sina.weibo.sdk.net.WeiboParameters;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/share/sina/StatusesAPI.class */
public class StatusesAPI extends AbsOpenAPI {
    private static final String API_BASE_URL = "https://api.weibo.com/2/statuses";
    public static final int AUTHOR_FILTER_ALL = 0;
    public static final int AUTHOR_FILTER_ATTENTIONS = 1;
    public static final int AUTHOR_FILTER_STRANGER = 2;
    public static final int FEATURE_ALL = 0;
    public static final int FEATURE_MUSICE = 4;
    public static final int FEATURE_ORIGINAL = 1;
    public static final int FEATURE_PICTURE = 2;
    public static final int FEATURE_VIDEO = 3;
    private static final int READ_API_FRIENDS_TIMELINE = 0;
    private static final int READ_API_MENTIONS = 1;
    public static final int SRC_FILTER_ALL = 0;
    public static final int SRC_FILTER_WEIBO = 1;
    public static final int SRC_FILTER_WEIQUN = 2;
    public static final int TYPE_FILTER_ALL = 0;
    public static final int TYPE_FILTER_ORIGAL = 1;
    private static final int WRITE_API_REPOST = 3;
    private static final int WRITE_API_UPDATE = 2;
    private static final int WRITE_API_UPLOAD = 4;
    private static final int WRITE_API_UPLOAD_URL_TEXT = 5;
    private static final SparseArray<String> sAPIList;

    static {
        SparseArray<String> sparseArray = new SparseArray<>();
        sAPIList = sparseArray;
        sparseArray.put(0, "https://api.weibo.com/2/statuses/friends_timeline.json");
        sAPIList.put(1, "https://api.weibo.com/2/statuses/mentions.json");
        sAPIList.put(3, "https://api.weibo.com/2/statuses/repost.json");
        sAPIList.put(2, "https://api.weibo.com/2/statuses/update.json");
        sAPIList.put(4, "https://api.weibo.com/2/statuses/upload.json");
        sAPIList.put(5, "https://api.weibo.com/2/statuses/upload_url_text.json");
    }

    public StatusesAPI(Context context, String str, Oauth2AccessToken oauth2AccessToken) {
        super(context, str, oauth2AccessToken);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    private WeiboParameters buildMentionsParams(long j, long j2, int i, int i2, int i3, int i4, int i5, boolean z) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    private WeiboParameters buildTimeLineParamsBase(long j, long j2, int i, int i2, boolean z, boolean z2, int i3) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    private WeiboParameters buildUpdateParams(String str, String str2, String str3) {
        WeiboParameters weiboParameters = new WeiboParameters(this.mAppKey);
        weiboParameters.put("status", str);
        if (!TextUtils.isEmpty(str3)) {
            weiboParameters.put("long", str3);
        }
        if (!TextUtils.isEmpty(str2)) {
            weiboParameters.put("lat", str2);
        }
        return weiboParameters;
    }

    public void friendsTimeline(long j, long j2, int i, int i2, boolean z, int i3, boolean z2, RequestListener requestListener) {
        requestAsync(sAPIList.get(0), buildTimeLineParamsBase(j, j2, i, i2, z, z2, i3), "GET", requestListener);
    }

    public String friendsTimelineSync(long j, long j2, int i, int i2, boolean z, int i3, boolean z2) {
        return requestSync(sAPIList.get(0), buildTimeLineParamsBase(j, j2, i, i2, z, z2, i3), "GET");
    }

    public void mentions(long j, long j2, int i, int i2, int i3, int i4, int i5, boolean z, RequestListener requestListener) {
        requestAsync(sAPIList.get(1), buildMentionsParams(j, j2, i, i2, i3, i4, i5, z), "GET", requestListener);
    }

    public String mentionsSync(long j, long j2, int i, int i2, int i3, int i4, int i5, boolean z) {
        return requestSync(sAPIList.get(1), buildMentionsParams(j, j2, i, i2, i3, i4, i5, z), "GET");
    }

    public void update(String str, String str2, String str3, RequestListener requestListener) {
        requestAsync(sAPIList.get(2), buildUpdateParams(str, str2, str3), "POST", requestListener);
    }

    public String updateSync(String str, String str2, String str3) {
        return requestSync(sAPIList.get(2), buildUpdateParams(str, str2, str3), "POST");
    }

    public void upload(String str, Bitmap bitmap, String str2, String str3, RequestListener requestListener) {
        WeiboParameters buildUpdateParams = buildUpdateParams(str, str2, str3);
        buildUpdateParams.put("pic", bitmap);
        requestAsync(sAPIList.get(4), buildUpdateParams, "POST", requestListener);
    }

    public String uploadSync(String str, Bitmap bitmap, String str2, String str3) {
        WeiboParameters buildUpdateParams = buildUpdateParams(str, str2, str3);
        buildUpdateParams.put("pic", bitmap);
        return requestSync(sAPIList.get(4), buildUpdateParams, "POST");
    }

    public void uploadUrlText(String str, String str2, String str3, String str4, String str5, RequestListener requestListener) {
        WeiboParameters buildUpdateParams = buildUpdateParams(str, str4, str5);
        buildUpdateParams.put("url", str2);
        buildUpdateParams.put("pic_id", str3);
        requestAsync(sAPIList.get(5), buildUpdateParams, "POST", requestListener);
    }

    public String uploadUrlTextSync(String str, String str2, String str3, String str4, String str5) {
        WeiboParameters buildUpdateParams = buildUpdateParams(str, str4, str5);
        buildUpdateParams.put("url", str2);
        buildUpdateParams.put("pic_id", str3);
        return requestSync(sAPIList.get(5), buildUpdateParams, "POST");
    }
}
