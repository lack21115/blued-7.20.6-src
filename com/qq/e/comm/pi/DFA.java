package com.qq.e.comm.pi;

import android.content.Context;
import com.qq.e.ads.dfa.GDTApk;

/* loaded from: source-8303388-dex2jar.jar:com/qq/e/comm/pi/DFA.class */
public interface DFA {
    void loadGDTApk();

    void startInstall(Context context, GDTApk gDTApk);
}
