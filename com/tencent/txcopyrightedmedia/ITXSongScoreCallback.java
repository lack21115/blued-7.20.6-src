package com.tencent.txcopyrightedmedia;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/txcopyrightedmedia/ITXSongScoreCallback.class */
public interface ITXSongScoreCallback {
    void onMIDIGroveAndHint(boolean z, float f, float f2, int i);

    void onMIDISCoreUpdate(int i, int i2, int i3);

    void onMIDIScoreError(int i, String str);

    void onMIDIScoreFinish(int[] iArr, int i);

    void onMIDIScorePrepared();
}
