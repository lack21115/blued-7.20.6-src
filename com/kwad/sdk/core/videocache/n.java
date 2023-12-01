package com.kwad.sdk.core.videocache;

import android.content.Context;
import com.kwad.sdk.utils.av;
import java.io.File;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/videocache/n.class */
public final class n {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static File aZ(Context context) {
        return new File(av.cA(context), "video-cache");
    }
}
