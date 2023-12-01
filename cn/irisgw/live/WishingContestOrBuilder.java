package cn.irisgw.live;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/WishingContestOrBuilder.class */
public interface WishingContestOrBuilder extends MessageOrBuilder {
    int getCountdown();

    int getGoodsCount();

    String getGoodsIcon();

    ByteString getGoodsIconBytes();

    int getGoodsId();

    String getGoodsName();

    ByteString getGoodsNameBytes();

    String getHtmlHref();

    ByteString getHtmlHrefBytes();

    String getHtmlMsg();

    ByteString getHtmlMsgBytes();

    long getPushMillisecond();

    int getPushTime();

    int getStatus();

    String getToolsTitle();

    ByteString getToolsTitleBytes();

    String getUrl();

    ByteString getUrlBytes();
}
