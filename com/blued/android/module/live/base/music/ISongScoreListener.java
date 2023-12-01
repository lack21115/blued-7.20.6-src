package com.blued.android.module.live.base.music;

import com.blued.android.module.live.base.music.model.YYTXSongScoreNoteItem;
import com.blued.android.module.live.base.music.model.YYUserSongScoreNoteItem;
import java.util.ArrayList;
import kotlin.Metadata;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/live/base/music/ISongScoreListener.class */
public interface ISongScoreListener {
    void a(int i);

    void a(int i, int i2, int i3);

    void a(YYUserSongScoreNoteItem yYUserSongScoreNoteItem);

    void a(ArrayList<YYTXSongScoreNoteItem> arrayList);
}
