package com.tencent.ugc.videoprocessor.watermark.data;

import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/videoprocessor/watermark/data/AnimatedPasterJsonConfig.class */
public class AnimatedPasterJsonConfig {
    public static final String CONFIG_COUNT = "count";
    public static final String CONFIG_HEIGHT = "height";
    public static final String CONFIG_KEYFRAME = "keyframe";
    public static final String CONFIG_KEYFRAME_ARRAY = "frameArray";
    public static final String CONFIG_NAME = "name";
    public static final String CONFIG_PERIOD = "period";
    public static final String CONFIG_WIDTH = "width";
    public static final String FILE_NAME = "config.json";
    public int mCount;
    public List<PasterPicture> mFrameArray = new ArrayList();
    public int mHeight;
    public int mKeyframe;
    public String mName;
    public int mPeriod;
    public int mWidth;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/videoprocessor/watermark/data/AnimatedPasterJsonConfig$PasterPicture.class */
    public static class PasterPicture {
        public static final String PICTURE_NAME = "picture";
        public String mPictureName;
    }
}
