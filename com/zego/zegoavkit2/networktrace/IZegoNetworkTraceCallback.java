package com.zego.zegoavkit2.networktrace;

/* loaded from: source-8829756-dex2jar.jar:com/zego/zegoavkit2/networktrace/IZegoNetworkTraceCallback.class */
public interface IZegoNetworkTraceCallback {
    void onNetworkTrace(long j, ZegoHttpTraceResult zegoHttpTraceResult, ZegoTcpTraceResult zegoTcpTraceResult, ZegoUdpTraceResult zegoUdpTraceResult, ZegoTracerouteResult zegoTracerouteResult);
}
