package cn.irisgw.live;

import cn.irisgw.live.AnchorJoinFriendModeExtra;
import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/AnchorJoinFriendModeExtraOrBuilder.class */
public interface AnchorJoinFriendModeExtraOrBuilder extends MessageOrBuilder {
    int getCount();

    AnchorJoinFriendModeExtra.Fan getFans(int i);

    int getFansCount();

    List<AnchorJoinFriendModeExtra.Fan> getFansList();

    AnchorJoinFriendModeExtra.FanOrBuilder getFansOrBuilder(int i);

    List<? extends AnchorJoinFriendModeExtra.FanOrBuilder> getFansOrBuilderList();

    String getStream();

    ByteString getStreamBytes();
}
