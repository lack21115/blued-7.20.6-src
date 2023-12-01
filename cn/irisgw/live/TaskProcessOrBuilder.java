package cn.irisgw.live;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/TaskProcessOrBuilder.class */
public interface TaskProcessOrBuilder extends MessageOrBuilder {
    String getTaskList(int i);

    ByteString getTaskListBytes(int i);

    int getTaskListCount();

    /* renamed from: getTaskListList */
    List<String> mo7589getTaskListList();
}
