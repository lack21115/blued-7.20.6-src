package com.tencent.thumbplayer.b;

import android.text.TextUtils;
import com.tencent.thumbplayer.api.composition.ITPMediaTrackClip;
import java.io.Serializable;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/b/h.class */
public class h extends d implements ITPMediaTrackClip, Serializable {

    /* renamed from: a  reason: collision with root package name */
    private int f25537a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private long f25538c;
    private long d;
    private String e;
    private long f;
    private long g;

    private h() {
    }

    public h(String str, int i) {
        this(str, i, 0L, -1L);
    }

    public h(String str, int i, long j, long j2) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("TPMediaCompositionTrackClip : clipPath empty");
        }
        this.f25537a = i;
        this.e = str;
        this.f25538c = j;
        this.d = j2;
        if (j < 0) {
            this.f25538c = 0L;
        }
        if (this.d <= 0) {
            this.d = getOriginalDurationMs();
        }
        this.b = f.a(this.f25537a);
    }

    public void a(String str) {
        this.e = str;
    }

    @Override // com.tencent.thumbplayer.api.composition.ITPMediaTrackClip
    public ITPMediaTrackClip clone(int i) {
        if (i == 3 || i == 2 || i == 1) {
            h hVar = new h();
            hVar.f25537a = i;
            hVar.b = f.a(this.f25537a);
            hVar.f25538c = this.f25538c;
            hVar.d = this.d;
            hVar.e = this.e;
            return hVar;
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof h)) {
            h hVar = (h) obj;
            return this.b == hVar.getClipId() && this.f25537a == hVar.getMediaType();
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
        return this.e;
    }

    @Override // com.tencent.thumbplayer.b.d, com.tencent.thumbplayer.api.composition.ITPMediaAsset
    public int getMediaType() {
        return this.f25537a;
    }

    @Override // com.tencent.thumbplayer.api.composition.ITPMediaTrackClip
    public long getOriginalDurationMs() {
        return this.g;
    }

    @Override // com.tencent.thumbplayer.api.composition.ITPMediaTrackClip
    public long getStartPositionMs() {
        return this.f;
    }

    @Override // com.tencent.thumbplayer.api.composition.ITPMediaTrackClip
    public long getStartTimeMs() {
        return this.f25538c;
    }

    @Override // com.tencent.thumbplayer.b.d, com.tencent.thumbplayer.api.composition.ITPMediaAsset
    public String getUrl() {
        return this.e;
    }

    @Override // com.tencent.thumbplayer.api.composition.ITPMediaTrackClip
    public void setCutTimeRange(long j, long j2) {
        if (j >= getOriginalDurationMs()) {
            throw new IllegalArgumentException("setCutTimeRange: Start time is greater than duration");
        }
        if (j2 > getOriginalDurationMs()) {
            throw new IllegalArgumentException("setCutTimeRange: Start time is greater than duration");
        }
        long j3 = j;
        if (j < 0) {
            j3 = 0;
        }
        long j4 = j2;
        if (j2 <= 0) {
            j4 = getOriginalDurationMs();
        }
        if (j3 >= j4) {
            throw new IllegalArgumentException("setCutTimeRange: Start time is greater than end time");
        }
        this.f25538c = j3;
        this.d = j4;
    }

    @Override // com.tencent.thumbplayer.api.composition.ITPMediaTrackClip
    public void setOriginalDurationMs(long j) {
        this.g = j;
    }

    @Override // com.tencent.thumbplayer.api.composition.ITPMediaTrackClip
    public void setStartPositionMs(long j) {
        this.f = j;
    }
}
