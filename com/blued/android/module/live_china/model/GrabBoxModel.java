package com.blued.android.module.live_china.model;

import android.text.TextUtils;
import com.blued.android.chat.utils.MsgPackHelper;
import com.blued.android.framework.http.parser.BluedEntityBaseExtra;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/GrabBoxModel.class */
public class GrabBoxModel extends BluedEntityBaseExtra {
    public static final int BOX_STATE_CLOSE = 3;
    public static final int BOX_STATE_OPEN = 2;
    public static final int BOX_STATE_PROGRESS = 1;
    public static final int BOX_STATE_RECEIVE = 4;
    public String box_gif;
    public String box_id;
    public String box_image;
    public int duration;
    public int index;
    public boolean isPlayAnim;
    public int progress;
    public String progress_full_gif;
    public int type;

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/GrabBoxModel$GrabBoxModelComparator.class */
    public static class GrabBoxModelComparator implements Comparator<GrabBoxModel> {
        @Override // java.util.Comparator
        public int compare(GrabBoxModel grabBoxModel, GrabBoxModel grabBoxModel2) {
            if (grabBoxModel.index > grabBoxModel2.index) {
                return 1;
            }
            return grabBoxModel.index < grabBoxModel2.index ? -1 : 0;
        }

        @Override // java.util.Comparator
        public boolean equals(Object obj) {
            return false;
        }
    }

    public static List<GrabBoxModel> parseGrabBoxMap(List<Map<String, Object>> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Map<String, Object> map : list) {
            GrabBoxModel grabBoxModel = new GrabBoxModel();
            grabBoxModel.parseMsgPackData(map);
            arrayList.add(grabBoxModel);
        }
        return arrayList;
    }

    public boolean equals(Object obj) {
        return (obj instanceof GrabBoxModel) && TextUtils.equals(((GrabBoxModel) obj).box_id, this.box_id);
    }

    public void parseMsgPackData(Map<String, Object> map) {
        if (map == null) {
            return;
        }
        this.type = MsgPackHelper.getIntValue(map, "type");
        this.box_id = MsgPackHelper.getStringValue(map, "box_id");
        this.box_image = MsgPackHelper.getStringValue(map, "box_image");
        this.progress = MsgPackHelper.getIntValue(map, "progress");
        this.box_gif = MsgPackHelper.getStringValue(map, "box_gif");
        this.progress_full_gif = MsgPackHelper.getStringValue(map, "progress_full_gif");
        this.duration = MsgPackHelper.getIntValue(map, "duration");
        this.index = MsgPackHelper.getIntValue(map, "index");
    }

    public String toString() {
        return "GrabBoxModel{type=" + this.type + ", box_id='" + this.box_id + "', box_image='" + this.box_image + "', box_gif='" + this.box_gif + "', progress=" + this.progress + ", progress_full_gif='" + this.progress_full_gif + "', duration=" + this.duration + ", index=" + this.index + '}';
    }
}
