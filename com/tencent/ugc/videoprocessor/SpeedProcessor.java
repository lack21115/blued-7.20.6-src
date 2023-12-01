package com.tencent.ugc.videoprocessor;

import com.tencent.ugc.TXVideoEditConstants;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/videoprocessor/SpeedProcessor.class */
public class SpeedProcessor {
    private List<TXVideoEditConstants.TXSpeed> mSpeedList;

    public void clear() {
        List<TXVideoEditConstants.TXSpeed> list = this.mSpeedList;
        if (list != null) {
            list.clear();
        }
        this.mSpeedList = null;
    }

    public float findSpeedByLevel(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 3) {
                    return i != 4 ? 1.0f : 2.0f;
                }
                return 1.5f;
            }
            return 0.5f;
        }
        return 0.25f;
    }

    public float getSpeedLevel(long j) {
        List<TXVideoEditConstants.TXSpeed> list = this.mSpeedList;
        float f = 1.0f;
        if (list != null) {
            if (list.size() != 0) {
                Iterator<TXVideoEditConstants.TXSpeed> it = this.mSpeedList.iterator();
                while (true) {
                    f = 1.0f;
                    if (!it.hasNext()) {
                        break;
                    }
                    TXVideoEditConstants.TXSpeed next = it.next();
                    if (j > next.startTime * 1000 && j < next.endTime * 1000) {
                        f = findSpeedByLevel(next.speedLevel);
                        break;
                    }
                }
            } else {
                return 1.0f;
            }
        }
        return f;
    }

    public List<TXVideoEditConstants.TXSpeed> getSpeedList() {
        return this.mSpeedList;
    }

    public boolean isSpeedListExist() {
        if (com.tencent.liteav.videobase.utils.c.a(this.mSpeedList)) {
            return false;
        }
        for (TXVideoEditConstants.TXSpeed tXSpeed : this.mSpeedList) {
            if (tXSpeed.speedLevel != 2) {
                return true;
            }
        }
        return false;
    }

    public void setSpeedList(List<TXVideoEditConstants.TXSpeed> list) {
        this.mSpeedList = list;
    }
}
