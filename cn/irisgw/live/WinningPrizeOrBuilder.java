package cn.irisgw.live;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/WinningPrizeOrBuilder.class */
public interface WinningPrizeOrBuilder extends MessageOrBuilder {
    String getChatFrameBorderColor(int i);

    ByteString getChatFrameBorderColorBytes(int i);

    int getChatFrameBorderColorCount();

    /* renamed from: getChatFrameBorderColorList */
    List<String> mo8159getChatFrameBorderColorList();

    String getChatFrameFrameColor(int i);

    ByteString getChatFrameFrameColorBytes(int i);

    int getChatFrameFrameColorCount();

    /* renamed from: getChatFrameFrameColorList */
    List<String> mo8160getChatFrameFrameColorList();

    String getChatFrameIcon();

    ByteString getChatFrameIconBytes();

    int getCount();

    String getEvent();

    ByteString getEventBytes();

    String getGoodsIcon();

    ByteString getGoodsIconBytes();

    int getGoodsId();

    String getGoodsName();

    ByteString getGoodsNameBytes();

    String getSource();

    ByteString getSourceBytes();

    int getUid();

    String getUserName();

    ByteString getUserNameBytes();
}
