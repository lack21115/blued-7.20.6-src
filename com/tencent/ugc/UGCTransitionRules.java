package com.tencent.ugc;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/UGCTransitionRules.class */
public class UGCTransitionRules {
    public static final int DEFAULT_IMAGE_HEIGHT = 1280;
    public static final int DEFAULT_IMAGE_WIDTH = 720;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static long getMotionDurationMs(int i) {
        long j = 500;
        switch (i) {
            case 1:
            case 2:
                break;
            case 3:
                j = 1000;
                break;
            case 4:
            case 5:
                return 2500L;
            case 6:
                return com.igexin.push.config.c.j;
            default:
                return 500L;
        }
        return j;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static long getStayDurationMs(int i) {
        long j = 1000;
        switch (i) {
            case 1:
            case 2:
                break;
            case 3:
            case 6:
                j = 1500;
                break;
            case 4:
            case 5:
                return 100L;
            default:
                return 1000L;
        }
        return j;
    }
}
