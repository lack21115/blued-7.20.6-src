package com.tencent.cos.xml.model.tag;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/MediaInfo.class */
public class MediaInfo {
    public Format format;
    public Stream stream;

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/MediaInfo$Audio.class */
    public static class Audio {
        public float bitrate;
        public int channel;
        public String channelLayout;
        public String codecLongName;
        public String codecName;
        public String codecTag;
        public String codecTagString;
        public String codecTimeBase;
        public float duration;
        public int index;
        public String language;
        public String sampleFmt;
        public float sampleRate;
        public float startTime;
        public String timebase;
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/MediaInfo$Format.class */
    public static class Format {
        public float bitrate;
        public float duration;
        public String formatLongName;
        public String formatName;
        public int numProgram;
        public int numStream;
        public float size;
        public float startTime;
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/MediaInfo$Stream.class */
    public static class Stream {
        public Audio audio;
        public Subtitle subtitle;
        public Video video;
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/MediaInfo$Subtitle.class */
    public static class Subtitle {
        public int index;
        public String language;
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/MediaInfo$Video.class */
    public static class Video {
        public String avgFps;
        public float bitrate;
        public String codecLongName;
        public String codecName;
        public String codecTag;
        public String codecTagString;
        public String codecTimeBase;
        public String dar;
        public float duration;
        public String fieldOrder;
        public float fps;
        public int hasBFrame;
        public int height;
        public int index;
        public String language;
        public int level;
        public int numFrames;
        public String pixFormat;
        public String profile;
        public int refFrames;
        public String sar;
        public float startTime;
        public String timebase;
        public int width;
    }
}
