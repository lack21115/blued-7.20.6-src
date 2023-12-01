package io.grpc;

/* loaded from: source-8829756-dex2jar.jar:io/grpc/ChannelLogger.class */
public abstract class ChannelLogger {

    /* loaded from: source-8829756-dex2jar.jar:io/grpc/ChannelLogger$ChannelLogLevel.class */
    public enum ChannelLogLevel {
        DEBUG,
        INFO,
        WARNING,
        ERROR
    }

    public abstract void log(ChannelLogLevel channelLogLevel, String str);

    public abstract void log(ChannelLogLevel channelLogLevel, String str, Object... objArr);
}
