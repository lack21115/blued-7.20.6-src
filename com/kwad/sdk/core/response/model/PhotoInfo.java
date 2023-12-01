package com.kwad.sdk.core.response.model;

import android.text.TextUtils;
import com.kwad.sdk.utils.u;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/response/model/PhotoInfo.class */
public class PhotoInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
    private static final long serialVersionUID = -4483350806354759008L;
    public String mOriginJString;
    public BaseInfo baseInfo = new BaseInfo();
    public VideoInfo videoInfo = new VideoInfo();

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/response/model/PhotoInfo$BaseInfo.class */
    public static class BaseInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        private static final long serialVersionUID = 2257669583403371065L;
        public long commentCount;
        public int contentSourceType;
        public long createTime;
        public long likeCount;
        public long photoId;
        public long playTimes;
        public String recoExt;
        public String sdkExtraData;
        public String shareUrl;
        public String title;
        public String videoDesc;
        public long videoUrlCacheTime;
        public long viewCount;
        public int waterMarkPosition;
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/response/model/PhotoInfo$VideoInfo.class */
    public static class VideoInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        private static final long serialVersionUID = 1395696168725754442L;
        public long duration;
        public String firstFrame;
        public int height;
        public double heightRatio;
        public double leftRatio;
        public String manifest;
        public int size;
        public double topRatio;
        public String videoUrl;
        public int width;
        public double widthRatio;
    }

    @Override // com.kwad.sdk.core.response.kwai.a
    public void afterParseJson(JSONObject jSONObject) {
        super.afterParseJson(jSONObject);
        if (jSONObject == null || !TextUtils.isEmpty(this.mOriginJString)) {
            return;
        }
        this.mOriginJString = jSONObject.toString();
    }

    @Override // com.kwad.sdk.core.response.kwai.a
    public void beforeToJson(JSONObject jSONObject) {
        super.beforeToJson(jSONObject);
        if (TextUtils.isEmpty(this.mOriginJString)) {
            return;
        }
        try {
            u.merge(jSONObject, new JSONObject(this.mOriginJString));
        } catch (JSONException e) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e);
        }
    }
}
