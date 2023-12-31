package cn.irisgw.live;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/UserInfoUpgradeOrBuilder.class */
public interface UserInfoUpgradeOrBuilder extends MessageOrBuilder {
    String getAvatarFrameImg();

    ByteString getAvatarFrameImgBytes();

    int getCanEmoji();

    int getCanKick();

    int getCanMute();

    String getChatFrame();

    String getChatFrameBorderColor(int i);

    ByteString getChatFrameBorderColorBytes(int i);

    int getChatFrameBorderColorCount();

    /* renamed from: getChatFrameBorderColorList */
    List<String> mo7872getChatFrameBorderColorList();

    ByteString getChatFrameBytes();

    int getChatFrameColorType();

    String getChatFrameFrameColor(int i);

    ByteString getChatFrameFrameColorBytes(int i);

    int getChatFrameFrameColorCount();

    /* renamed from: getChatFrameFrameColorList */
    List<String> mo7873getChatFrameFrameColorList();

    int getChatFrameGradientType();

    String getChatFrameIcon();

    ByteString getChatFrameIconBytes();

    long getPushMillisecond();
}
