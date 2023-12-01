package cn.irisgw.live;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/BattlePassRewardNotifyOrBuilder.class */
public interface BattlePassRewardNotifyOrBuilder extends MessageOrBuilder {
    int getBonus();

    String getChatFrame();

    String getChatFrameBorderColor(int i);

    ByteString getChatFrameBorderColorBytes(int i);

    int getChatFrameBorderColorCount();

    /* renamed from: getChatFrameBorderColorList */
    List<String> mo522getChatFrameBorderColorList();

    ByteString getChatFrameBytes();

    int getChatFrameColorType();

    String getChatFrameFrameColor(int i);

    ByteString getChatFrameFrameColorBytes(int i);

    int getChatFrameFrameColorCount();

    /* renamed from: getChatFrameFrameColorList */
    List<String> mo523getChatFrameFrameColorList();

    int getChatFrameGradientType();

    String getChatFrameIcon();

    ByteString getChatFrameIconBytes();

    int getGoodsCount();

    String getGoodsIcon();

    ByteString getGoodsIconBytes();

    String getGoodsName();

    ByteString getGoodsNameBytes();

    boolean getHide();

    int getLevel();

    String getName();

    ByteString getNameBytes();

    int getUid();
}
