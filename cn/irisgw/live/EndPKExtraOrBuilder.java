package cn.irisgw.live;

import cn.irisgw.live.EndPKExtra;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/EndPKExtraOrBuilder.class */
public interface EndPKExtraOrBuilder extends MessageOrBuilder {
    long getCountdown();

    int getPkType();

    EndPKExtra.EndRecord getRecords(int i);

    int getRecordsCount();

    List<EndPKExtra.EndRecord> getRecordsList();

    EndPKExtra.EndRecordOrBuilder getRecordsOrBuilder(int i);

    List<? extends EndPKExtra.EndRecordOrBuilder> getRecordsOrBuilderList();

    int getType();

    int getWinner();
}
