package com.tencent.txcopyrightedmedia;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/txcopyrightedmedia/TXSongScoreNoteItem.class */
public class TXSongScoreNoteItem {
    public static final int INVALID_GROVE_VALUE = -1;
    public static final int MAX_GROVE_VALUE = 100;
    public static final int MAX_VOICE_PITCH_VALUE = 90;
    public int duration;
    public int endTime;
    public int noteHeight;
    public int startTime;

    public int getEndTime() {
        return this.startTime + this.duration;
    }

    public boolean isSame(int i) {
        return Math.abs(this.noteHeight - i) < 11 && this.noteHeight > 0 && i > 0;
    }

    public String toString() {
        return String.format("startTime = %d ; endTime = %d ; duration = %d ; height = %d;", Integer.valueOf(this.startTime), Integer.valueOf(this.endTime), Integer.valueOf(this.duration), Integer.valueOf(this.noteHeight));
    }
}
