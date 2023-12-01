package com.tencent.txcopyrightedmedia;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/txcopyrightedmedia/ITXSongScore.class */
public interface ITXSongScore {
    int calculateTotalScore();

    void destroy();

    void finish();

    TXSongScoreNoteItem[] getAllGrove();

    void prepare();

    void process(byte[] bArr, int i, float f);

    void seek(float f);

    void setKeyShift(int i);

    void setSongScoreCallback(ITXSongScoreCallback iTXSongScoreCallback);
}
