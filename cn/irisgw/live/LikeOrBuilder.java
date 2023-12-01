package cn.irisgw.live;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/LikeOrBuilder.class */
public interface LikeOrBuilder extends MessageOrBuilder {
    int getFanClubLevel();

    String getFanClubName();

    ByteString getFanClubNameBytes();

    FanStatus getFansStatus();

    int getFansStatusValue();

    boolean getInFanClub();

    String getLiangId();

    ByteString getLiangIdBytes();

    LiangType getLiangType();

    int getLiangTypeValue();

    int getRechargeBadge();
}
