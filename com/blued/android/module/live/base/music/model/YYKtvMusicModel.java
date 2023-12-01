package com.blued.android.module.live.base.music.model;

import android.text.TextUtils;
import com.chad.library.adapter.base.entity.MultiItemEntity;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/live/base/music/model/YYKtvMusicModel.class */
public class YYKtvMusicModel implements MultiItemEntity {
    public static final int MUSIC_MODEL = 0;
    public static final int MUSIC_MODEL_NO_DATA = 1;
    public String artist;
    public String bigCoverUrl;
    public YYChorusClipSet chorusClipSet;
    public String coverUrl;
    public long duration;
    public boolean fromSearchPage;
    public String musicId;
    public String musicName;
    public int playTime;
    public String recommendType;
    public String sheetId;
    public int type = 0;

    @Override // com.chad.library.adapter.base.entity.MultiItemEntity
    public int getItemType() {
        if (TextUtils.equals(this.sheetId, "wish-choosed")) {
            return 2;
        }
        return this.type;
    }
}
