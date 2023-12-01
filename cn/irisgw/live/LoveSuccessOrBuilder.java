package cn.irisgw.live;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/LoveSuccessOrBuilder.class */
public interface LoveSuccessOrBuilder extends MessageOrBuilder {
    String getAnimeUrl();

    ByteString getAnimeUrlBytes();

    LoveFan getChooser();

    LoveFanOrBuilder getChooserOrBuilder();

    LoveFan getChosen();

    LoveFanOrBuilder getChosenOrBuilder();

    boolean hasChooser();

    boolean hasChosen();
}
