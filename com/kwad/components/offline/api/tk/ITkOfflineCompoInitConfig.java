package com.kwad.components.offline.api.tk;

import android.content.Context;
import com.kwad.components.offline.api.IOfflineCompoInitConfig;
import com.kwad.components.offline.api.core.soloader.ISoLoader;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/offline/api/tk/ITkOfflineCompoInitConfig.class */
public interface ITkOfflineCompoInitConfig extends IOfflineCompoInitConfig {
    String getSpKeyTkSoLoadTimes();

    String getSpNameSoLoadTimes();

    String getTkJsFileDir(Context context, String str);

    String getTkJsRootDir(Context context);

    String getTkVersion();

    boolean isCanUseTk();

    boolean isLocalDebugEnable();

    ISoLoader soLoader();

    boolean useTkLite();
}
