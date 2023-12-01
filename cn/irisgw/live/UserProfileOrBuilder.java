package cn.irisgw.live;

import cn.irisgw.live.UserProfile;
import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/UserProfileOrBuilder.class */
public interface UserProfileOrBuilder extends MessageOrBuilder {
    String getAvatar();

    ByteString getAvatarBytes();

    int getIsManager();

    String getName();

    ByteString getNameBytes();

    UserProfile.Noble getNoble();

    UserProfile.NobleOrBuilder getNobleOrBuilder();

    UserProfile.UserPrivilege getPrivilege(int i);

    int getPrivilegeCount();

    List<UserProfile.UserPrivilege> getPrivilegeList();

    UserProfile.UserPrivilegeOrBuilder getPrivilegeOrBuilder(int i);

    List<? extends UserProfile.UserPrivilegeOrBuilder> getPrivilegeOrBuilderList();

    int getRichLevel();

    VBadge getVbadge();

    int getVbadgeValue();

    String getVipFrame();

    ByteString getVipFrameBytes();

    int getVipLevel();

    boolean hasNoble();
}
