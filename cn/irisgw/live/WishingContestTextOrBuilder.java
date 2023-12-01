package cn.irisgw.live;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/WishingContestTextOrBuilder.class */
public interface WishingContestTextOrBuilder extends MessageOrBuilder {
    int getAnchor();

    int getAnchorBeans();

    String getAnchorName();

    ByteString getAnchorNameBytes();

    String getChatFrameBorderColor(int i);

    ByteString getChatFrameBorderColorBytes(int i);

    int getChatFrameBorderColorCount();

    /* renamed from: getChatFrameBorderColorList */
    List<String> mo8255getChatFrameBorderColorList();

    String getChatFrameFrameColor(int i);

    ByteString getChatFrameFrameColorBytes(int i);

    int getChatFrameFrameColorCount();

    /* renamed from: getChatFrameFrameColorList */
    List<String> mo8256getChatFrameFrameColorList();

    String getChatFrameIcon();

    ByteString getChatFrameIconBytes();

    int getEvent();

    int getGoodsCount();

    int getGoodsId();

    String getGoodsName();

    ByteString getGoodsNameBytes();

    String getGoodsUrl();

    ByteString getGoodsUrlBytes();

    boolean getHide();

    int getLid();

    int getScreenType();

    int getType();

    int getUid();

    String getUrl();

    ByteString getUrlBytes();

    String getUserName();

    ByteString getUserNameBytes();
}
