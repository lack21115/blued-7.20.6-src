package com.ss.android.socialbase.appdownloader.u.mb;

import java.io.IOException;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/appdownloader/u/mb/ox.class */
public class ox {
    public static final void mb(hj hjVar, int i) throws IOException {
        int ox = hjVar.ox();
        if (ox == i) {
            return;
        }
        throw new IOException("Expected chunk of type 0x" + Integer.toHexString(i) + ", read 0x" + Integer.toHexString(ox) + ".");
    }
}
