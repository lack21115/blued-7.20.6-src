package cn.irisgw.live;

import cn.irisgw.live.MultiPkStart;
import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/MultiPkStartOrBuilder.class */
public interface MultiPkStartOrBuilder extends MessageOrBuilder {
    String getFirstKillMessage();

    ByteString getFirstKillMessageBytes();

    MultiPkStart.StartRecord getUsers(int i);

    int getUsersCount();

    List<MultiPkStart.StartRecord> getUsersList();

    MultiPkStart.StartRecordOrBuilder getUsersOrBuilder(int i);

    List<? extends MultiPkStart.StartRecordOrBuilder> getUsersOrBuilderList();
}
