package cn.irisgw.live;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/TextOrBuilder.class */
public interface TextOrBuilder extends MessageOrBuilder {
    int getChatBadgeHeight();

    int getChatBadgeLength();

    String getChatBadgeUrl();

    ByteString getChatBadgeUrlBytes();

    String getChatFrame();

    String getChatFrameBorderColor(int i);

    ByteString getChatFrameBorderColorBytes(int i);

    int getChatFrameBorderColorCount();

    /* renamed from: getChatFrameBorderColorList */
    List<String> mo7635getChatFrameBorderColorList();

    ByteString getChatFrameBytes();

    int getChatFrameColorType();

    String getChatFrameFrameColor(int i);

    ByteString getChatFrameFrameColorBytes(int i);

    int getChatFrameFrameColorCount();

    /* renamed from: getChatFrameFrameColorList */
    List<String> mo7636getChatFrameFrameColorList();

    int getChatFrameGradientType();

    String getChatFrameIcon();

    ByteString getChatFrameIconBytes();

    int getEmojiH();

    int getEmojiId();

    String getEmojiUrl();

    ByteString getEmojiUrlBytes();

    int getEmojiW();

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
