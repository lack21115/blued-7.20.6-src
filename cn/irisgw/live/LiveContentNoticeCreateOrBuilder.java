package cn.irisgw.live;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/LiveContentNoticeCreateOrBuilder.class */
public interface LiveContentNoticeCreateOrBuilder extends MessageOrBuilder {
    String getContent();

    ByteString getContentBytes();

    int getCount();

    int getCountdown();

    int getFrequency();

    int getId();

    String getPlatform();

    ByteString getPlatformBytes();

    int getShowType();

    int getStrategy();

    int getSubType();

    int getType();

    String getUrl();

    ByteString getUrlBytes();
}
