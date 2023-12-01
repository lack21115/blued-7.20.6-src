package cn.irisgw.live;

import cn.irisgw.live.GiftExtra;
import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/GiftExtraOrBuilder.class */
public interface GiftExtraOrBuilder extends MessageOrBuilder {
    boolean getAlwaysShowAnimation();

    String getAnimCode();

    ByteString getAnimCodeBytes();

    int getAnimMany();

    int getAnimation();

    String getAvatarFrameUrl();

    ByteString getAvatarFrameUrlBytes();

    long getBeansCount();

    long getBeansCurrentCount();

    String getBgColor(int i);

    ByteString getBgColorBytes(int i);

    int getBgColorCount();

    /* renamed from: getBgColorList */
    List<String> mo2660getBgColorList();

    String getBgImg();

    ByteString getBgImgBytes();

    int getChatBadgeHeight();

    int getChatBadgeLength();

    String getChatBadgeUrl();

    ByteString getChatBadgeUrlBytes();

    String getChatFrame();

    String getChatFrameBorderColor(int i);

    ByteString getChatFrameBorderColorBytes(int i);

    int getChatFrameBorderColorCount();

    /* renamed from: getChatFrameBorderColorList */
    List<String> mo2661getChatFrameBorderColorList();

    ByteString getChatFrameBytes();

    int getChatFrameColorType();

    String getChatFrameFrameColor(int i);

    ByteString getChatFrameFrameColorBytes(int i);

    int getChatFrameFrameColorCount();

    /* renamed from: getChatFrameFrameColorList */
    List<String> mo2662getChatFrameFrameColorList();

    int getChatFrameGradientType();

    String getChatFrameIcon();

    ByteString getChatFrameIconBytes();

    int getFanClubLevel();

    String getFanClubName();

    ByteString getFanClubNameBytes();

    FanStatus getFansStatus();

    int getFansStatusValue();

    long getGiftBeansCount();

    int getGiftId();

    String getGiftName();

    ByteString getGiftNameBytes();

    String getGiftPicApng();

    ByteString getGiftPicApngBytes();

    String getGiftPicGif();

    ByteString getGiftPicGifBytes();

    String getGiftPicMp4();

    ByteString getGiftPicMp4Bytes();

    String getGiftPicUrl();

    ByteString getGiftPicUrlBytes();

    int getGiftType();

    int getHitBatch();

    int getHitCount();

    long getHitId();

    boolean getInFanClub();

    boolean getIsDrawGoods();

    boolean getIsHelpWishList();

    boolean getIsLuckBag();

    boolean getIsReward();

    boolean getIsVibrate();

    int getLanternId();

    GiftExtra.lantern_resource getLanternImage(int i);

    int getLanternImageCount();

    List<GiftExtra.lantern_resource> getLanternImageList();

    GiftExtra.lantern_resourceOrBuilder getLanternImageOrBuilder(int i);

    List<? extends GiftExtra.lantern_resourceOrBuilder> getLanternImageOrBuilderList();

    int getLanternPlayTimes();

    String getLiangId();

    ByteString getLiangIdBytes();

    LiangType getLiangType();

    int getLiangTypeValue();

    String getRandomName();

    ByteString getRandomNameBytes();

    String getRandomStatic();

    ByteString getRandomStaticBytes();

    int getRechargeBadge();

    String getResourceUrl();

    ByteString getResourceUrlBytes();

    String getTypeName();

    ByteString getTypeNameBytes();
}
