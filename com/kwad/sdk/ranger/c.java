package com.kwad.sdk.ranger;

import okhttp3.EventListener;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/ranger/c.class */
public class c implements EventListener.Factory {
    public static final String TAG = "Ranger_" + c.class.getSimpleName();
    EventListener axQ;
    a axR;

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/ranger/c$a.class */
    public interface a {
    }

    public c(Object obj, a aVar) {
        this.axQ = (EventListener) obj;
        this.axR = aVar;
    }
}
