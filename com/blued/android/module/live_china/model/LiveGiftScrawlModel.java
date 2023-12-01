package com.blued.android.module.live_china.model;

import android.graphics.Point;
import com.blued.android.module.common.utils.ReflectionUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/LiveGiftScrawlModel.class */
public class LiveGiftScrawlModel extends LiveGiftModel {
    private List<Point> path;

    public LiveGiftScrawlModel() {
    }

    public LiveGiftScrawlModel(LiveGiftModel liveGiftModel) {
        ReflectionUtils.a(liveGiftModel, this);
    }

    public void addPath(Point point) {
        if (point == null) {
            return;
        }
        getPath().add(point);
    }

    public void clearPath() {
        this.path = new ArrayList();
    }

    public void copyValue(LiveGiftModel liveGiftModel) {
        ReflectionUtils.a(liveGiftModel, this);
    }

    public List<Point> getPath() {
        if (this.path == null) {
            this.path = new ArrayList();
        }
        return this.path;
    }

    public void setPath(List<Point> list) {
        this.path = list;
        if (list == null) {
            this.path = new ArrayList();
        }
    }
}
