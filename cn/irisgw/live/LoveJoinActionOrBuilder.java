package cn.irisgw.live;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/LoveJoinActionOrBuilder.class */
public interface LoveJoinActionOrBuilder extends MessageOrBuilder {
    String getConferenceId();

    ByteString getConferenceIdBytes();

    LoveFan getFans(int i);

    int getFansCount();

    List<LoveFan> getFansList();

    LoveFanOrBuilder getFansOrBuilder(int i);

    List<? extends LoveFanOrBuilder> getFansOrBuilderList();

    int getIndex();

    boolean getIsHideDistance();

    String getName();

    ByteString getNameBytes();

    String getStream();

    ByteString getStreamBytes();

    String getType();

    ByteString getTypeBytes();

    int getUid();
}
