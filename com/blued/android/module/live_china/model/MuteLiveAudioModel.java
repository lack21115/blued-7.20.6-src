package com.blued.android.module.live_china.model;

import android.text.TextUtils;
import java.io.Serializable;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/MuteLiveAudioModel.class */
public class MuteLiveAudioModel implements Serializable {
    public String source_lid;
    public String source_uid;
    public String stream;
    public String target_lid;
    public int target_status;
    public String target_stream;
    public String target_uid;

    public MuteLiveAudioModel() {
    }

    public MuteLiveAudioModel(String str, String str2, String str3, String str4, int i, String str5, String str6) {
        this.source_lid = str;
        this.source_uid = str2;
        this.target_lid = str3;
        this.target_uid = str4;
        this.target_status = i;
        this.stream = str5;
        this.target_stream = str6;
    }

    public boolean equals(MuteLiveAudioModel muteLiveAudioModel) {
        if (isEmpty() || muteLiveAudioModel == null || muteLiveAudioModel.isEmpty() || TextUtils.isEmpty(this.source_lid) || TextUtils.isEmpty(this.source_uid) || TextUtils.isEmpty(this.target_lid) || TextUtils.isEmpty(this.target_uid)) {
            return false;
        }
        if (this.source_lid.equals(muteLiveAudioModel.source_lid) && this.target_lid.equals(muteLiveAudioModel.target_lid)) {
            return true;
        }
        return this.source_uid.equals(muteLiveAudioModel.source_uid) && this.target_uid.equals(muteLiveAudioModel.target_uid);
    }

    public boolean isEmpty() {
        if ((TextUtils.isEmpty(this.source_lid) || this.source_lid.equals("0")) && (TextUtils.isEmpty(this.source_uid) || this.source_uid.equals("0"))) {
            return true;
        }
        if (TextUtils.isEmpty(this.target_lid) || this.target_lid.equals("0")) {
            return TextUtils.isEmpty(this.target_uid) || this.target_uid.equals("0");
        }
        return false;
    }
}
