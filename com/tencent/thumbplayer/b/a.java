package com.tencent.thumbplayer.b;

import com.tencent.thumbplayer.api.composition.ITPMediaTrackClip;
import java.io.Serializable;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/b/a.class */
public class a extends d implements ITPMediaTrackClip, Serializable {

    /* renamed from: a  reason: collision with root package name */
    private int f39217a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private long f39218c = 0;
    private long d = 0;
    private long e;

    public a(int i) {
        this.f39217a = i;
        this.b = f.a(i);
    }

    @Override // com.tencent.thumbplayer.api.composition.ITPMediaTrackClip
    public ITPMediaTrackClip clone(int i) {
        if (i == 3 || i == 2 || i == 1) {
            a aVar = new a(i);
            aVar.b = f.a(i);
            aVar.f39218c = this.f39218c;
            aVar.d = this.d;
            return aVar;
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof a)) {
            a aVar = (a) obj;
            return this.b == aVar.getClipId() && this.f39217a == aVar.getMediaType();
        }
        return false;
    }

    @Override // com.tencent.thumbplayer.api.composition.ITPMediaTrackClip
    public int getClipId() {
        return this.b;
    }

    @Override // com.tencent.thumbplayer.api.composition.ITPMediaTrackClip
    public long getEndTimeMs() {
        return this.d;
    }

    @Override // com.tencent.thumbplayer.api.composition.ITPMediaTrackClip
    public String getFilePath() {
        return null;
    }

    @Override // com.tencent.thumbplayer.b.d, com.tencent.thumbplayer.api.composition.ITPMediaAsset
    public int getMediaType() {
        return this.f39217a;
    }

    @Override // com.tencent.thumbplayer.api.composition.ITPMediaTrackClip
    public long getOriginalDurationMs() {
        return this.d - this.f39218c;
    }

    @Override // com.tencent.thumbplayer.api.composition.ITPMediaTrackClip
    public long getStartPositionMs() {
        return this.e;
    }

    @Override // com.tencent.thumbplayer.api.composition.ITPMediaTrackClip
    public long getStartTimeMs() {
        return this.f39218c;
    }

    @Override // com.tencent.thumbplayer.b.d, com.tencent.thumbplayer.api.composition.ITPMediaAsset
    public String getUrl() {
        return null;
    }

    @Override // com.tencent.thumbplayer.api.composition.ITPMediaTrackClip
    public void setCutTimeRange(long j, long j2) {
        long j3 = j;
        if (j < 0) {
            j3 = 0;
        }
        if (j3 >= j2) {
            throw new IllegalArgumentException("setCutTimeRange: Start time is greater than end time");
        }
        this.f39218c = j3;
        this.d = j2;
    }

    @Override // com.tencent.thumbplayer.api.composition.ITPMediaTrackClip
    public void setOriginalDurationMs(long j) {
    }

    @Override // com.tencent.thumbplayer.api.composition.ITPMediaTrackClip
    public void setStartPositionMs(long j) {
        this.e = j;
    }
}
