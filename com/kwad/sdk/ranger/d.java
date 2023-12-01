package com.kwad.sdk.ranger;

import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/ranger/d.class */
public class d extends com.kwad.sdk.core.response.kwai.a {
    public long axS;
    public List<String> axT;
    public List<a> axU;
    public long axV = 1000;
    public double axW = 1.0d;
    public List<com.kwad.sdk.ranger.kwai.a> axX;

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/ranger/d$a.class */
    public static class a extends com.kwad.sdk.core.response.kwai.a {
        public String axY;
        public String axZ;
    }

    private boolean cd(int i) {
        return (Cm() || (this.axS & ((long) i)) == 0) ? false : true;
    }

    public final boolean Cm() {
        return (this.axS & 1) == 0;
    }

    public final boolean Cn() {
        return cd(2);
    }

    public final boolean Co() {
        return cd(4);
    }

    public final boolean Cp() {
        return cd(16);
    }
}
