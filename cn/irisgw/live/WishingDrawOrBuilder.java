package cn.irisgw.live;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/WishingDrawOrBuilder.class */
public interface WishingDrawOrBuilder extends MessageOrBuilder {
    int getCountdown();

    String getGoodsIcon();

    ByteString getGoodsIconBytes();

    int getGoodsId();

    String getGoodsName();

    ByteString getGoodsNameBytes();

    int getScore();

    int getStatus();

    int getTargetScore();

    float getTimes();

    int getType();

    String getUrl();

    ByteString getUrlBytes();
}
