package com.tencent.liteav.videoproducer.producer;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/producer/VideoProducerDef.class */
public interface VideoProducerDef {

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/producer/VideoProducerDef$GSensorMode.class */
    public enum GSensorMode {
        DISABLE(0),
        UI_AUTO_LAYOUT(1),
        UI_FIX_LAYOUT(2);
        
        private static final GSensorMode[] d = values();
        int mValue;

        GSensorMode(int i) {
            this.mValue = i;
        }

        public static GSensorMode a(int i) {
            GSensorMode[] gSensorModeArr = d;
            int length = gSensorModeArr.length;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= length) {
                    return UI_FIX_LAYOUT;
                }
                GSensorMode gSensorMode = gSensorModeArr[i3];
                if (gSensorMode.mValue == i) {
                    return gSensorMode;
                }
                i2 = i3 + 1;
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/producer/VideoProducerDef$HomeOrientation.class */
    public enum HomeOrientation {
        UNSET(-1),
        UP(0),
        LEFT(1),
        RIGHT(2),
        DOWN(3);
        
        private static final HomeOrientation[] f = values();
        int mValue;

        HomeOrientation(int i) {
            this.mValue = i;
        }

        public static HomeOrientation a(int i) {
            HomeOrientation[] homeOrientationArr = f;
            int length = homeOrientationArr.length;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= length) {
                    return DOWN;
                }
                HomeOrientation homeOrientation = homeOrientationArr[i3];
                if (homeOrientation.mValue == i) {
                    return homeOrientation;
                }
                i2 = i3 + 1;
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/producer/VideoProducerDef$ProducerMode.class */
    public enum ProducerMode {
        AUTO(0),
        PERFORMANCE(1),
        HIGH_QUALITY(2),
        MANUAL(3);
        
        private static final ProducerMode[] e = values();
        private int mValue;

        ProducerMode(int i) {
            this.mValue = i;
        }

        public static ProducerMode a(int i) {
            ProducerMode[] producerModeArr = e;
            int length = producerModeArr.length;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= length) {
                    return AUTO;
                }
                ProducerMode producerMode = producerModeArr[i3];
                if (producerMode.mValue == i) {
                    return producerMode;
                }
                i2 = i3 + 1;
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/producer/VideoProducerDef$StreamType.class */
    public enum StreamType {
        STREAM_TYPE_BIG_VIDEO(0),
        STREAM_TYPE_SMALL_VIDEO(1),
        STREAM_TYPE_SUB_VIDEO(2);
        
        private static final StreamType[] d = values();
        public final int mValue;

        StreamType(int i) {
            this.mValue = i;
        }

        public static StreamType a(int i) {
            StreamType[] streamTypeArr = d;
            int length = streamTypeArr.length;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= length) {
                    return STREAM_TYPE_BIG_VIDEO;
                }
                StreamType streamType = streamTypeArr[i3];
                if (streamType.mValue == i) {
                    return streamType;
                }
                i2 = i3 + 1;
            }
        }
    }
}
