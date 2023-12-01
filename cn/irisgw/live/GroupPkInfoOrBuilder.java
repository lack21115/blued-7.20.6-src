package cn.irisgw.live;

import cn.irisgw.live.GroupPkInfo;
import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/GroupPkInfoOrBuilder.class */
public interface GroupPkInfoOrBuilder extends MessageOrBuilder {
    int getFromUid();

    GroupPkInfo.Group getGroupInfo(int i);

    int getGroupInfoCount();

    List<GroupPkInfo.Group> getGroupInfoList();

    GroupPkInfo.GroupOrBuilder getGroupInfoOrBuilder(int i);

    List<? extends GroupPkInfo.GroupOrBuilder> getGroupInfoOrBuilderList();

    String getText();

    ByteString getTextBytes();

    int getType();
}
