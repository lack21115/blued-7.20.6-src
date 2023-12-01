package com.tencent.thumbplayer.api;

import com.tencent.thumbplayer.adapter.strategy.utils.TPNativeKeyMap;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/api/TPSubtitleRenderModel.class */
public class TPSubtitleRenderModel {
    @TPNativeKeyMap.MapSubtitleFontStyle(1)
    public static final int TP_SUBTITLE_FONT_STYLE_BOLD = 1;
    @TPNativeKeyMap.MapSubtitleRenderParams(2)
    public static final long TP_SUBTITLE_PARAM_FLAG_CANVAS_HEIGHT = 2;
    @TPNativeKeyMap.MapSubtitleRenderParams(1)
    public static final long TP_SUBTITLE_PARAM_FLAG_CANVAS_WIDTH = 1;
    @TPNativeKeyMap.MapSubtitleRenderParams(256)
    public static final long TP_SUBTITLE_PARAM_FLAG_END_MARGIN = 256;
    @TPNativeKeyMap.MapSubtitleRenderParams(8)
    public static final long TP_SUBTITLE_PARAM_FLAG_FONT_COLOR = 8;
    @TPNativeKeyMap.MapSubtitleRenderParams(2048)
    public static final long TP_SUBTITLE_PARAM_FLAG_FONT_SCALE = 2048;
    @TPNativeKeyMap.MapSubtitleRenderParams(4)
    public static final long TP_SUBTITLE_PARAM_FLAG_FONT_SIZE = 4;
    @TPNativeKeyMap.MapSubtitleRenderParams(1024)
    public static final long TP_SUBTITLE_PARAM_FLAG_FONT_STYLE_BOLD = 1024;
    @TPNativeKeyMap.MapSubtitleRenderParams(64)
    public static final long TP_SUBTITLE_PARAM_FLAG_LINE_SPACE = 64;
    @TPNativeKeyMap.MapSubtitleRenderParams(32)
    public static final long TP_SUBTITLE_PARAM_FLAG_OUTLINE_COLOR = 32;
    @TPNativeKeyMap.MapSubtitleRenderParams(16)
    public static final long TP_SUBTITLE_PARAM_FLAG_OUTLINE_WIDTH = 16;
    @TPNativeKeyMap.MapSubtitleRenderParams(128)
    public static final long TP_SUBTITLE_PARAM_FLAG_START_MARGIN = 128;
    @TPNativeKeyMap.MapSubtitleRenderParams(512)
    public static final long TP_SUBTITLE_PARAM_FLAG_VERTICAL_MARGIN = 512;
    public int canvasHeight;
    public int canvasWidth;
    public float endMargin;
    public String familyName;
    public int fontColor;
    public float fontScale;
    public float fontSize;
    public int fontStyleFlags;
    public float lineSpace;
    public int outlineColor;
    public float outlineWidth;
    public long paramFlags;
    public long paramPriorityFlags;
    public float startMargin;
    public float verticalMargin;
}
