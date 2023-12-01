package cn.irisgw.live;

import cn.irisgw.live.FriendModeVoiceExtra;
import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/FriendModeVoiceExtraOrBuilder.class */
public interface FriendModeVoiceExtraOrBuilder extends MessageOrBuilder {
    String getConferenceId();

    ByteString getConferenceIdBytes();

    String getConferenceToken();

    ByteString getConferenceTokenBytes();

    int getCount();

    FriendModeVoiceExtra.Fan getFans(int i);

    int getFansCount();

    List<FriendModeVoiceExtra.Fan> getFansList();

    FriendModeVoiceExtra.FanOrBuilder getFansOrBuilder(int i);

    List<? extends FriendModeVoiceExtra.FanOrBuilder> getFansOrBuilderList();

    int getIndex();

    String getName();

    ByteString getNameBytes();

    String getStream();

    ByteString getStreamBytes();

    int getUid();
}
