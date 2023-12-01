package com.tencent.ugc.videoprocessor.videoeffect.data;

import java.util.LinkedList;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/videoprocessor/videoeffect/data/MotionFilterConfig.class */
public class MotionFilterConfig {
    private Motion mCurrentMotion;
    private final LinkedList<Motion> mMotionList = new LinkedList<>();

    public void addMotion(Motion motion) {
        this.mCurrentMotion = motion;
        this.mMotionList.add(motion);
    }

    public void clear() {
        this.mMotionList.clear();
    }

    public void deleteLastMotionEffect() {
        if (this.mMotionList.size() == 0) {
            return;
        }
        this.mMotionList.removeLast();
    }

    public Motion getCurrentMotion() {
        return this.mCurrentMotion;
    }

    public List<Motion> getMotionList() {
        return this.mMotionList;
    }
}
