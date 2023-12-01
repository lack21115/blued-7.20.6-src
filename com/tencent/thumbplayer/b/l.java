package com.tencent.thumbplayer.b;

import com.tencent.thumbplayer.api.composition.ITPMediaUrlAsset;
import com.tencent.thumbplayer.utils.TPLogUtil;
import java.io.IOException;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/b/l.class */
public class l extends d implements ITPMediaUrlAsset {

    /* renamed from: a  reason: collision with root package name */
    private String f25543a;

    public l(String str) {
        this.f25543a = str;
    }

    @Override // com.tencent.thumbplayer.b.d, com.tencent.thumbplayer.api.composition.ITPMediaAsset
    public int getMediaType() {
        return 0;
    }

    @Override // com.tencent.thumbplayer.api.composition.ITPMediaUrlAsset
    public String getStreamUrl() {
        return this.f25543a;
    }

    @Override // com.tencent.thumbplayer.b.d, com.tencent.thumbplayer.api.composition.ITPMediaAsset
    public String getUrl() {
        try {
            return i.a(this);
        } catch (IOException e) {
            TPLogUtil.e("TPMediaUrlAsset", e);
            return "";
        }
    }

    @Override // com.tencent.thumbplayer.api.composition.ITPMediaUrlAsset
    public void setStreamUrl(String str) {
        this.f25543a = str;
    }
}
