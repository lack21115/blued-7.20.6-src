package cn.irisgw.live;

import com.google.protobuf.Any;
import com.google.protobuf.AnyOrBuilder;
import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/LiveMessageOrBuilder.class */
public interface LiveMessageOrBuilder extends MessageOrBuilder {
    String getContents();

    ByteString getContentsBytes();

    Any getExtra();

    AnyOrBuilder getExtraOrBuilder();

    int getFrom();

    String getLiveId();

    ByteString getLiveIdBytes();

    long getMsgId();

    UserProfile getProfile();

    UserProfileOrBuilder getProfileOrBuilder();

    long getTimestamp();

    LiveMsgType getType();

    int getTypeValue();

    boolean hasExtra();

    boolean hasProfile();
}
