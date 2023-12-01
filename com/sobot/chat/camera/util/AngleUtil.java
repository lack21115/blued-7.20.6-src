package com.sobot.chat.camera.util;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/camera/util/AngleUtil.class */
public class AngleUtil {
    public static int getSensorAngle(float f, float f2) {
        if (Math.abs(f) <= Math.abs(f2)) {
            return (f2 <= 7.0f && f2 < -7.0f) ? 180 : 0;
        } else if (f > 4.0f) {
            return 270;
        } else {
            return f < -4.0f ? 90 : 0;
        }
    }
}
