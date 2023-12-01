package com.getui.gtc.base.log.b;

import android.util.Log;
import com.getui.gtc.base.log.ILogDestination;

/* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/base/log/b/b.class */
public final class b implements ILogDestination {
    @Override // com.getui.gtc.base.log.ILogDestination
    public final void log(int i, String str, String str2) {
        if (i == 1) {
            Log.v(str, str2);
        } else if (i == 2) {
            Log.d(str, str2);
        } else if (i == 3) {
            Log.i(str, str2);
        } else if (i == 4) {
            Log.w(str, str2);
        } else if (i != 5) {
        } else {
            Log.e(str, str2);
        }
    }
}
