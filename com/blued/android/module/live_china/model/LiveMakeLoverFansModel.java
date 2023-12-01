package com.blued.android.module.live_china.model;

import android.text.TextUtils;
import java.io.Serializable;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/LiveMakeLoverFansModel.class */
public class LiveMakeLoverFansModel implements Serializable {
    public String avatar;
    public String conference_id;
    public int index;
    public int lamp = 1;
    public String name;
    public String pic;
    public String stream;
    public String uid;
    public int voice;

    public boolean isEmpty() {
        return TextUtils.isEmpty(this.uid) || TextUtils.equals(this.uid, "0");
    }
}
