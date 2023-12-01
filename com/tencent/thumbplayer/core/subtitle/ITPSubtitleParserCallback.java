package com.tencent.thumbplayer.core.subtitle;

import com.tencent.thumbplayer.core.common.TPSubtitleFrame;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/core/subtitle/ITPSubtitleParserCallback.class */
public interface ITPSubtitleParserCallback {
    long onGetCurrentPlayPositionMs();

    void onLoadResult(int i);

    void onSelectResult(int i, long j);

    void onSubtitleError(int i, int i2);

    void onSubtitleFrame(TPSubtitleFrame tPSubtitleFrame);

    void onSubtitleNote(String str);
}
