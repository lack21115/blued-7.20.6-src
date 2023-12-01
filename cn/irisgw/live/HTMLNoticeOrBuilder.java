package cn.irisgw.live;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/HTMLNoticeOrBuilder.class */
public interface HTMLNoticeOrBuilder extends MessageOrBuilder {
    String getHtmlHref();

    ByteString getHtmlHrefBytes();

    String getHtmlMsg();

    ByteString getHtmlMsgBytes();

    long getPushMillisecond();

    int getPushTime();
}
