package cn.irisgw.live;

import cn.irisgw.live.MultiPkRank;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/MultiPkRankOrBuilder.class */
public interface MultiPkRankOrBuilder extends MessageOrBuilder {
    MultiPkRank.StartRecord getUsers(int i);

    int getUsersCount();

    List<MultiPkRank.StartRecord> getUsersList();

    MultiPkRank.StartRecordOrBuilder getUsersOrBuilder(int i);

    List<? extends MultiPkRank.StartRecordOrBuilder> getUsersOrBuilderList();
}
