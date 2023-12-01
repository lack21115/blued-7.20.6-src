package cn.irisgw.live;

import cn.irisgw.live.PkTypeStart;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/PkTypeStartOrBuilder.class */
public interface PkTypeStartOrBuilder extends MessageOrBuilder {
    int getCount();

    int getCountdown();

    boolean getLast();

    boolean getPkStatus();

    PkTypeStart.PkRecord getRecords(int i);

    int getRecordsCount();

    List<PkTypeStart.PkRecord> getRecordsList();

    PkTypeStart.PkRecordOrBuilder getRecordsOrBuilder(int i);

    List<? extends PkTypeStart.PkRecordOrBuilder> getRecordsOrBuilderList();
}
