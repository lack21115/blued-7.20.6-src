package cn.irisgw.live;

import cn.irisgw.live.JoinLiveExtra;
import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/JoinLiveExtraOrBuilder.class */
public interface JoinLiveExtraOrBuilder extends MessageOrBuilder {
    int getAnchorPocketTrafficCard();

    String getAnchorPocketTrafficCardName();

    ByteString getAnchorPocketTrafficCardNameBytes();

    String getAvatarFrame();

    ByteString getAvatarFrameBytes();

    int getAvatarFrameType();

    int getChatBadgeHeight();

    int getChatBadgeLength();

    String getChatBadgeUrl();

    ByteString getChatBadgeUrlBytes();

    String getChatFrame();

    String getChatFrameBorderColor(int i);

    ByteString getChatFrameBorderColorBytes(int i);

    int getChatFrameBorderColorCount();

    /* renamed from: getChatFrameBorderColorList */
    List<String> mo3606getChatFrameBorderColorList();

    ByteString getChatFrameBytes();

    int getChatFrameColorType();

    String getChatFrameFrameColor(int i);

    ByteString getChatFrameFrameColorBytes(int i);

    int getChatFrameFrameColorCount();

    /* renamed from: getChatFrameFrameColorList */
    List<String> mo3607getChatFrameFrameColorList();

    int getChatFrameGradientType();

    String getChatFrameIcon();

    ByteString getChatFrameIconBytes();

    int getCount();

    JoinLiveExtra.JoinEffects getEffects();

    JoinLiveExtra.JoinEffectsOrBuilder getEffectsOrBuilder();

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

    String getNobleJoinText();

    ByteString getNobleJoinTextBytes();

    int getRealtimeCount();

    int getRechargeBadge();

    boolean hasEffects();
}
