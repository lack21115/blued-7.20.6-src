package com.bykv.vk.openvk.api.proto;

/* loaded from: source-7206380-dex2jar.jar:com/bykv/vk/openvk/api/proto/Result.class */
public interface Result {
    int code();

    boolean isSuccess();

    String message();

    ValueSet values();
}
