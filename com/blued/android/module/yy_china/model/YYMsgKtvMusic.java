package com.blued.android.module.yy_china.model;

import com.blued.android.module.live.base.music.model.YYTXSongScoreNoteItem;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/YYMsgKtvMusic.class */
public class YYMsgKtvMusic extends YYMsgKtvSinger {
    public String accompanyUrl;
    public boolean completedLrc;
    public boolean completedMidi;
    public String coverUrl;
    public long currentTime;
    public String dynamicLyricUrl;
    public String musicName;
    public String musicUrl;
    private CopyOnWriteArrayList<YYTXSongScoreNoteItem> realData;
    public YyImSong1MlateTogiftModel songApplaud;
    public String staticLyricUrl;
    private CopyOnWriteArrayList<YYTXSongScoreNoteItem> userData;
    public String isOriginal = "0";
    public String playToken = "";
    public int PreludeInterval = 0;
    public boolean isSinging = false;
    public long duration = 0;
    public int lrcCount = 0;
    public int hitCount = 1;

    public CopyOnWriteArrayList<YYTXSongScoreNoteItem> getRealData() {
        if (this.realData == null) {
            this.realData = new CopyOnWriteArrayList<>();
        }
        return this.realData;
    }

    public CopyOnWriteArrayList<YYTXSongScoreNoteItem> getUserData() {
        if (this.userData == null) {
            this.userData = new CopyOnWriteArrayList<>();
        }
        return this.userData;
    }
}
