package com.tencent.ugc;

import com.tencent.ugc.TXVideoEditConstants;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/Clip.class */
public class Clip {
    public long endInFileTime;
    public float fps;
    public String path;
    public List<TXVideoEditConstants.TXSpeed> speedList;
    public long startInClipsTimeline;
    public long startInFileTime;
    public long startInSourceListTimeline;
    public long startTimelineNoSpeed;
    public String videoMimeType;

    public Clip() {
    }

    public Clip(Clip clip) {
        this.startInFileTime = clip.startInFileTime;
        this.endInFileTime = clip.endInFileTime;
        this.startInClipsTimeline = clip.startInClipsTimeline;
        this.startTimelineNoSpeed = clip.startTimelineNoSpeed;
        this.startInSourceListTimeline = clip.startInSourceListTimeline;
        this.path = clip.path;
        this.speedList = clip.speedList;
        this.videoMimeType = clip.videoMimeType;
    }
}
