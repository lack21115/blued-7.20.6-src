package com.kwad.sdk.crash.online.monitor.block.kwai;

import android.content.Context;
import com.kwad.sdk.core.report.c;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/crash/online/monitor/block/kwai/a.class */
public final class a extends c {
    private static String ajP = "CREATE TABLE IF NOT EXISTS ksad_block_actions (actionId varchar(60) primary key, aLog TEXT)";

    public a(Context context, int i) {
        super(context, "ksadBlock.db", i, ajP);
    }
}
