package com.kwad.sdk.crash;

import android.speech.tts.TextToSpeech;
import java.util.regex.Pattern;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/crash/d.class */
public final class d {
    public static final double aqZ = Runtime.getRuntime().maxMemory();
    public static final Pattern ara = Pattern.compile("/data/user");
    public static final Pattern arb = Pattern.compile("/data");
    public static final Pattern arc = Pattern.compile("/data/data/(.*)/data/.*");
    public static final Pattern ard = Pattern.compile("/data/user/.*/(.*)/data/.*");
    public static int are = 20;
    public static String arf = TextToSpeech.Engine.KEY_PARAM_SESSION_ID;
}
