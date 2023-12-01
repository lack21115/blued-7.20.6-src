package com.anythink.core.api;

import android.content.Context;
import com.anythink.core.common.e.i;
import com.anythink.core.common.e.j;
import java.io.Serializable;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/api/IOfferClickHandler.class */
public abstract class IOfferClickHandler implements Serializable {
    public abstract boolean startDownloadApp(Context context, i iVar, j jVar, String str);
}
