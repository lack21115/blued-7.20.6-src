package com.blued.android.module.live_china.model;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/LiveMusicModel.class */
public class LiveMusicModel implements MultiItemEntity {
    public static final int MUSIC_MODEL = 0;
    public static final int MUSIC_MODEL_NO_DATA = 1;
    public String artist;
    public String cover;
    public long curDuration;
    public long duration;
    public String expires;
    public String file_size;
    public String file_url;
    public String music_id;
    public String name;
    public int type = 0;

    public int getItemType() {
        return this.type;
    }
}
