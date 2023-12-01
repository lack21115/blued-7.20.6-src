package cn.irisgw.live;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/LineStartExtraOrBuilder.class */
public interface LineStartExtraOrBuilder extends MessageOrBuilder {
    String getConferenceId();

    ByteString getConferenceIdBytes();

    String getConferenceToken();

    ByteString getConferenceTokenBytes();

    String getName();

    ByteString getNameBytes();

    String getStream();

    ByteString getStreamBytes();

    String getTargetStream();

    ByteString getTargetStreamBytes();

    String getTargetToken();

    ByteString getTargetTokenBytes();

    int getType();

    int getUid();
}
