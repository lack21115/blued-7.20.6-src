package com.blued.android.module.yy_china.lrc.model;

import java.util.ArrayList;
import java.util.List;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/lrc/model/LyricInfo.class */
public class LyricInfo {
    private String album;
    private String artist;
    private List<LineInfo> lines;
    private long offset;
    private String title;

    public String getAlbum() {
        return this.album;
    }

    public String getArtist() {
        return this.artist;
    }

    public List<LineInfo> getLines() {
        if (this.lines == null) {
            this.lines = new ArrayList();
        }
        return this.lines;
    }

    public long getOffset() {
        return this.offset;
    }

    public String getTitle() {
        return this.title;
    }

    public void setAlbum(String str) {
        this.album = str;
    }

    public void setArtist(String str) {
        this.artist = str;
    }

    public void setLines(List<LineInfo> list) {
        this.lines = list;
    }

    public void setOffset(long j) {
        this.offset = j;
    }

    public void setTitle(String str) {
        this.title = str;
    }
}
