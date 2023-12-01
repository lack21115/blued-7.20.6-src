package cn.irisgw.live;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/LeftBottomCommonMsgOrBuilder.class */
public interface LeftBottomCommonMsgOrBuilder extends MessageOrBuilder {
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

    String getColor();

    ByteString getColorBytes();

    String getLink();

    ByteString getLinkBytes();

    int getLinkType();
}
