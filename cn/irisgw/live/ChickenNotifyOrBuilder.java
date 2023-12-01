package cn.irisgw.live;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/ChickenNotifyOrBuilder.class */
public interface ChickenNotifyOrBuilder extends MessageOrBuilder {
    boolean getHide();

    boolean getLinkHalfOpen();

    String getLinkUrl();

    ByteString getLinkUrlBytes();

    String getMsg();

    ByteString getMsgBytes();

    String getName();

    ByteString getNameBytes();

    int getResult();

    int getUid();
}
