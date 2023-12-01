package cn.irisgw.live;

import cn.irisgw.live.LinkMultiUpdate;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/LinkMultiUpdateOrBuilder.class */
public interface LinkMultiUpdateOrBuilder extends MessageOrBuilder {
    LinkMultiUpdate.Action getAction();

    LinkMultiUpdate.ActionType getActionType();

    int getActionTypeValue();

    LinkMultiUpdate.LinkMultiUser getActionUsers();

    LinkMultiUpdate.LinkMultiUserOrBuilder getActionUsersOrBuilder();

    int getActionValue();

    LinkMultiUpdate.LinkMultiUser getUsers(int i);

    int getUsersCount();

    List<LinkMultiUpdate.LinkMultiUser> getUsersList();

    LinkMultiUpdate.LinkMultiUserOrBuilder getUsersOrBuilder(int i);

    List<? extends LinkMultiUpdate.LinkMultiUserOrBuilder> getUsersOrBuilderList();

    boolean hasActionUsers();
}
