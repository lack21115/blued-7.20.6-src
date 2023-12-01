package cn.irisgw.live;

import cn.irisgw.live.GoodsLuckBag;
import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/GoodsLuckBagOrBuilder.class */
public interface GoodsLuckBagOrBuilder extends MessageOrBuilder {
    String getAnimCode();

    ByteString getAnimCodeBytes();

    int getAnimation();

    String getAvatarFrameUrl();

    ByteString getAvatarFrameUrlBytes();

    long getBeansCount();

    long getBeansCurrentCount();

    String getBgColor(int i);

    ByteString getBgColorBytes(int i);

    int getBgColorCount();

    List<String> getBgColorList();

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

    List<String> getChatFrameBorderColorList();

    ByteString getChatFrameBytes();

    int getChatFrameColorType();

    String getChatFrameFrameColor(int i);

    ByteString getChatFrameFrameColorBytes(int i);

    int getChatFrameFrameColorCount();

    List<String> getChatFrameFrameColorList();

    int getChatFrameGradientType();

    String getChatFrameIcon();

    ByteString getChatFrameIconBytes();

    int getFanClubLevel();

    String getFanClubName();

    ByteString getFanClubNameBytes();

    FanStatus getFansStatus();

    int getFansStatusValue();

    GoodsLuckBag.Goods getGoods(int i);

    int getGoodsCount();

    List<GoodsLuckBag.Goods> getGoodsList();

    GoodsLuckBag.GoodsOrBuilder getGoodsOrBuilder(int i);

    List<? extends GoodsLuckBag.GoodsOrBuilder> getGoodsOrBuilderList();

    int getHitBatch();

    int getHitCount();

    long getHitId();

    boolean getInFanClub();

    int getLanternId();

    GoodsLuckBag.lantern_resource getLanternImage(int i);

    int getLanternImageCount();

    List<GoodsLuckBag.lantern_resource> getLanternImageList();

    GoodsLuckBag.lantern_resourceOrBuilder getLanternImageOrBuilder(int i);

    List<? extends GoodsLuckBag.lantern_resourceOrBuilder> getLanternImageOrBuilderList();

    int getLanternPlayTimes();

    String getLiangId();

    ByteString getLiangIdBytes();

    LiangType getLiangType();

    int getLiangTypeValue();

    int getRechargeBadge();

    String getTypeName();

    ByteString getTypeNameBytes();
}
