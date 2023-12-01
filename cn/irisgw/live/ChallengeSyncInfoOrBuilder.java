package cn.irisgw.live;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/ChallengeSyncInfoOrBuilder.class */
public interface ChallengeSyncInfoOrBuilder extends MessageOrBuilder {
    String getAvatar();

    ByteString getAvatarBytes();

    int getEggScore();

    String getLid();

    ByteString getLidBytes();

    String getName();

    ByteString getNameBytes();

    long getScore();

    int getUid();

    UserProp getUserProp(int i);

    int getUserPropCount();

    List<UserProp> getUserPropList();

    UserPropOrBuilder getUserPropOrBuilder(int i);

    List<? extends UserPropOrBuilder> getUserPropOrBuilderList();
}
