package com.heytap.mcssdk.parser;

import android.content.Context;
import android.content.Intent;
import com.heytap.msp.push.mode.BaseMode;

/* loaded from: source-7994992-dex2jar.jar:com/heytap/mcssdk/parser/Parser.class */
public interface Parser<T> {
    BaseMode parse(Context context, int i, Intent intent);
}
