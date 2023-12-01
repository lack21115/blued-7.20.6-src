package cn.irisgw.live;

import cn.irisgw.live.NobleUpgrade;
import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/NobleUpgradeOrBuilder.class */
public interface NobleUpgradeOrBuilder extends MessageOrBuilder {
    String getAvatarFrameImg();

    ByteString getAvatarFrameImgBytes();

    String getBgUrl();

    ByteString getBgUrlBytes();

    String getContent();

    ByteString getContentBytes();

    NobleUpgrade.Noble getNoble();

    NobleUpgrade.NobleOrBuilder getNobleOrBuilder();

    String getNobleUrl();

    ByteString getNobleUrlBytes();

    long getPushMillisecond();

    int getScreenType();

    boolean getUpgradeComment();

    boolean getUpgradeStreamer();

    boolean hasNoble();
}
