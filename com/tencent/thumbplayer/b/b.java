package com.tencent.thumbplayer.b;

import com.tencent.thumbplayer.api.composition.ITPMediaAssetExtraParam;
import com.tencent.thumbplayer.api.composition.ITPMediaAssetObjectParam;
import java.io.Serializable;
import java.util.HashMap;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/b/b.class */
public class b implements ITPMediaAssetExtraParam {

    /* renamed from: a  reason: collision with root package name */
    private HashMap<String, Serializable> f25528a = new HashMap<>();

    @Override // com.tencent.thumbplayer.api.composition.ITPMediaAssetExtraParam
    public int getExtraInt(String str) {
        if (this.f25528a.containsKey(str)) {
            return ((Integer) this.f25528a.get(str)).intValue();
        }
        return -1;
    }

    @Override // com.tencent.thumbplayer.api.composition.ITPMediaAssetExtraParam
    public ITPMediaAssetObjectParam getExtraObject(String str) {
        if (this.f25528a.get(str) instanceof ITPMediaAssetObjectParam) {
            return (ITPMediaAssetObjectParam) this.f25528a.get(str);
        }
        return null;
    }

    @Override // com.tencent.thumbplayer.api.composition.ITPMediaAssetExtraParam
    public String getExtraString(String str) {
        return this.f25528a.containsKey(str) ? (String) this.f25528a.get(str) : "";
    }

    @Override // com.tencent.thumbplayer.api.composition.ITPMediaAssetExtraParam
    public void setExtraInt(String str, int i) {
        this.f25528a.put(str, Integer.valueOf(i));
    }

    @Override // com.tencent.thumbplayer.api.composition.ITPMediaAssetExtraParam
    public void setExtraObject(String str, ITPMediaAssetObjectParam iTPMediaAssetObjectParam) {
        this.f25528a.put(str, iTPMediaAssetObjectParam);
    }

    @Override // com.tencent.thumbplayer.api.composition.ITPMediaAssetExtraParam
    public void setExtraString(String str, String str2) {
        this.f25528a.put(str, str2);
    }
}
