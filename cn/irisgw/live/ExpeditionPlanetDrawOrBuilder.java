package cn.irisgw.live;

import cn.irisgw.live.ExpeditionPlanetDraw;
import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/ExpeditionPlanetDrawOrBuilder.class */
public interface ExpeditionPlanetDrawOrBuilder extends MessageOrBuilder {
    int getBeans();

    ExpeditionPlanetDraw.Goods getGoodsInfo(int i);

    int getGoodsInfoCount();

    List<ExpeditionPlanetDraw.Goods> getGoodsInfoList();

    ExpeditionPlanetDraw.GoodsOrBuilder getGoodsInfoOrBuilder(int i);

    List<? extends ExpeditionPlanetDraw.GoodsOrBuilder> getGoodsInfoOrBuilderList();

    boolean getIsJoin();

    boolean getIsLucky();

    int getPlanetId();

    String getPlanetImage();

    ByteString getPlanetImageBytes();

    String getPlanetName();

    ByteString getPlanetNameBytes();

    String getPlanetNameImage();

    ByteString getPlanetNameImageBytes();

    int getRate();

    int getRemainTime();

    int getShipCount();
}
