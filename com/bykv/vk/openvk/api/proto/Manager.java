package com.bykv.vk.openvk.api.proto;

import android.content.Context;

/* loaded from: source-7206380-dex2jar.jar:com/bykv/vk/openvk/api/proto/Manager.class */
public interface Manager {
    Loader createLoader(Context context);

    Bridge getBridge(int i);

    ValueSet values();
}
