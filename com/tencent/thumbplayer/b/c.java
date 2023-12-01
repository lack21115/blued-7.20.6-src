package com.tencent.thumbplayer.b;

import com.tencent.thumbplayer.api.composition.ITPMediaAssetOrderedMap;
import com.tencent.thumbplayer.utils.TPLogUtil;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/b/c.class */
public class c implements ITPMediaAssetOrderedMap {

    /* renamed from: a  reason: collision with root package name */
    private StringBuilder f39220a = new StringBuilder();

    @Override // com.tencent.thumbplayer.api.composition.ITPMediaAssetOrderedMap
    public void addKeyValue(String str, String str2) {
        TPLogUtil.i("TPMediaAssetOrderedMap", "addKeyValue key:" + str + "=" + str2);
        StringBuilder sb = this.f39220a;
        sb.append(str);
        sb.append("=");
        sb.append(str2);
        sb.append(";");
    }

    @Override // com.tencent.thumbplayer.api.composition.ITPMediaAssetOrderedMap
    public String getKeyValueStr() {
        TPLogUtil.i("TPMediaAssetOrderedMap", "getKeyValueStr " + this.f39220a.toString());
        return this.f39220a.toString();
    }
}
