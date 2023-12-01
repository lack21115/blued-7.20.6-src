package com.kwad.sdk.core.report;

import android.content.Context;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/report/s.class */
public final class s extends c {
    public static int HE = 1;
    private static String ajP = "CREATE TABLE IF NOT EXISTS ksad_actions (actionId varchar(60) primary key, aLog TEXT)";

    public s(Context context, int i) {
        super(context, "ksadrep.db", i, ajP);
    }
}
