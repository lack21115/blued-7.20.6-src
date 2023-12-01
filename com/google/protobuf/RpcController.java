package com.google.protobuf;

/* loaded from: source-8110460-dex2jar.jar:com/google/protobuf/RpcController.class */
public interface RpcController {
    String errorText();

    boolean failed();

    boolean isCanceled();

    void notifyOnCancel(RpcCallback<Object> rpcCallback);

    void reset();

    void setFailed(String str);

    void startCancel();
}
