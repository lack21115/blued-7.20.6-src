package cn.irisgw.live;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/BluedChatContentOrBuilder.class */
public interface BluedChatContentOrBuilder extends MessageOrBuilder {
    String getContent();

    ByteString getContentBytes();

    String getLimitType();

    ByteString getLimitTypeBytes();

    String getLink();

    ByteString getLinkBytes();

    int getLinkType();
}
