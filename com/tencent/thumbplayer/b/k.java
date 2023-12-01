package com.tencent.thumbplayer.b;

import com.tencent.thumbplayer.api.composition.ITPMediaRTCAsset;
import com.tencent.thumbplayer.utils.TPLogUtil;
import java.io.IOException;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/b/k.class */
public class k extends d implements ITPMediaRTCAsset {

    /* renamed from: a  reason: collision with root package name */
    private String f25541a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private int f25542c;

    public k(String str, String str2) {
        this.f25542c = 0;
        this.f25541a = str;
        this.b = str2;
    }

    public k(String str, String str2, int i) {
        this.f25542c = 0;
        this.f25541a = str;
        this.b = str2;
        this.f25542c = i;
    }

    @Override // com.tencent.thumbplayer.b.d, com.tencent.thumbplayer.api.composition.ITPMediaAsset
    public int getMediaType() {
        return 0;
    }

    @Override // com.tencent.thumbplayer.api.composition.ITPMediaRTCAsset
    public int getRtcSdpExchangeType() {
        return this.f25542c;
    }

    @Override // com.tencent.thumbplayer.api.composition.ITPMediaRTCAsset
    public String getRtcServerUrl() {
        return this.b;
    }

    @Override // com.tencent.thumbplayer.api.composition.ITPMediaRTCAsset
    public String getRtcStreamUrl() {
        return this.f25541a;
    }

    @Override // com.tencent.thumbplayer.b.d, com.tencent.thumbplayer.api.composition.ITPMediaAsset
    public String getUrl() {
        try {
            return i.a(this);
        } catch (IOException e) {
            TPLogUtil.e("TPMediaWebrtcAsset", e);
            return "";
        }
    }
}
