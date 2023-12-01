package com.blued.android.module.live_china.model;

import com.blued.android.module.external_sense_library.config.BluedBeautifyKey;
import com.blued.android.module.external_sense_library.config.BluedFilterType;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/BeautyModel.class */
public class BeautyModel {
    public static final int BEAUTY_TYPE_CLOSE = -1;
    public static final int BEAUTY_TYPE_DEFAULT = 0;
    public BluedBeautifyKey.KEY beautifyKey;
    public String customName;
    public String eventName;
    public BluedFilterType.FILER filer;
    public String id;
    public boolean isFilter;
    public boolean isSelect;
    public int progress;
    public int resource;
    public int type;

    public BeautyModel() {
    }

    public BeautyModel(BluedBeautifyKey.KEY key, String str, String str2, int i, boolean z, int i2) {
        this.beautifyKey = key;
        this.id = str;
        this.customName = str2;
        this.type = i;
        this.isSelect = z;
        this.progress = i2;
    }

    public BeautyModel(String str, String str2, int i, boolean z) {
        this.id = str;
        this.customName = str2;
        this.type = i;
        this.isSelect = z;
    }
}
