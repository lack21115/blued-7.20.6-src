package cn.irisgw.live;

import cn.irisgw.live.LinkMultiInvite;
import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/LinkMultiInviteOrBuilder.class */
public interface LinkMultiInviteOrBuilder extends MessageOrBuilder {
    String getAvatar();

    ByteString getAvatarBytes();

    String getName();

    ByteString getNameBytes();

    int getTimeout();

    int getType();

    long getUid();

    LinkMultiInvite.LinkMultiInviteUser getUsers(int i);

    int getUsersCount();

    List<LinkMultiInvite.LinkMultiInviteUser> getUsersList();

    LinkMultiInvite.LinkMultiInviteUserOrBuilder getUsersOrBuilder(int i);

    List<? extends LinkMultiInvite.LinkMultiInviteUserOrBuilder> getUsersOrBuilderList();
}
