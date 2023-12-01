package cn.irisgw.live;

import cn.irisgw.live.DrawGoods;
import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/DrawGoodsOrBuilder.class */
public interface DrawGoodsOrBuilder extends MessageOrBuilder {
    String getAvatarFrameUrl();

    ByteString getAvatarFrameUrlBytes();

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

    int getDiscountId();

    int getFanClubLevel();

    String getFanClubName();

    ByteString getFanClubNameBytes();

    int getFansStatus();

    DrawGoods.Goods getGoods(int i);

    int getGoodsCount();

    List<DrawGoods.Goods> getGoodsList();

    DrawGoods.GoodsOrBuilder getGoodsOrBuilder(int i);

    List<? extends DrawGoods.GoodsOrBuilder> getGoodsOrBuilderList();

    int getHeight();

    int getInFanClub();

    int getLiangId();

    int getLiangType();

    int getLiveId();

    String getPayCode();

    ByteString getPayCodeBytes();

    String getPayToken();

    ByteString getPayTokenBytes();

    int getRememberMe();

    int getTargetUid();

    int getWidth();
}
