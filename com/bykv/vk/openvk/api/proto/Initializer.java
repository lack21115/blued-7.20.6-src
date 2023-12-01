package com.bykv.vk.openvk.api.proto;

import android.content.Context;

/* loaded from: source-7206380-dex2jar.jar:com/bykv/vk/openvk/api/proto/Initializer.class */
public interface Initializer {
    Manager getManager();

    void init(Context context, ValueSet valueSet);

    boolean isInitSuccess();
}
