package com.tencent.thumbplayer.b;

import com.tencent.thumbplayer.api.TPCommonEnum;
import com.tencent.thumbplayer.api.composition.ITPMediaDRMAsset;
import com.tencent.thumbplayer.utils.TPLogUtil;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/b/j.class */
public class j extends d implements ITPMediaDRMAsset {

    /* renamed from: a  reason: collision with root package name */
    private String f39230a;
    @TPCommonEnum.TP_DRM_TYPE
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private Map<String, String> f39231c = new HashMap();

    public j(@TPCommonEnum.TP_DRM_TYPE int i, String str) {
        this.f39230a = str;
        this.b = i;
    }

    @Override // com.tencent.thumbplayer.api.composition.ITPMediaDRMAsset
    public Map<String, String> getDrmAllProperties() {
        return this.f39231c;
    }

    @Override // com.tencent.thumbplayer.api.composition.ITPMediaDRMAsset
    public String getDrmPlayUrl() {
        return this.f39230a;
    }

    @Override // com.tencent.thumbplayer.api.composition.ITPMediaDRMAsset
    public String getDrmProperty(String str, String str2) {
        String str3;
        Map<String, String> map = this.f39231c;
        if (map != null && !map.isEmpty() && (str3 = this.f39231c.get(str)) != null) {
            return str3;
        }
        return str2;
    }

    @Override // com.tencent.thumbplayer.api.composition.ITPMediaDRMAsset
    @TPCommonEnum.TP_DRM_TYPE
    public int getDrmType() {
        return this.b;
    }

    @Override // com.tencent.thumbplayer.b.d, com.tencent.thumbplayer.api.composition.ITPMediaAsset
    public int getMediaType() {
        return 0;
    }

    @Override // com.tencent.thumbplayer.b.d, com.tencent.thumbplayer.api.composition.ITPMediaAsset
    public String getUrl() {
        try {
            return i.a(this);
        } catch (IOException e) {
            TPLogUtil.e("TPMediaDRMAsset", e);
            return "";
        }
    }

    @Override // com.tencent.thumbplayer.api.composition.ITPMediaDRMAsset
    public void setDrmPlayUrl(String str) {
        this.f39230a = str;
    }

    @Override // com.tencent.thumbplayer.api.composition.ITPMediaDRMAsset
    public void setDrmProperty(String str, String str2) {
        this.f39231c.put(str, str2);
    }

    @Override // com.tencent.thumbplayer.api.composition.ITPMediaDRMAsset
    public void setDrmType(@TPCommonEnum.TP_DRM_TYPE int i) {
        this.b = i;
    }
}
