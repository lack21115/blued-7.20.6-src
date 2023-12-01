package cn.irisgw.live;

import cn.irisgw.live.MultiPkEnd;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/MultiPkEndOrBuilder.class */
public interface MultiPkEndOrBuilder extends MessageOrBuilder {
    MultiPkEnd.StartRecord getUsers(int i);

    int getUsersCount();

    List<MultiPkEnd.StartRecord> getUsersList();

    MultiPkEnd.StartRecordOrBuilder getUsersOrBuilder(int i);

    List<? extends MultiPkEnd.StartRecordOrBuilder> getUsersOrBuilderList();
}
