package cn.irisgw.live;

import cn.irisgw.live.LiveActivity;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/LiveActivityOrBuilder.class */
public interface LiveActivityOrBuilder extends MessageOrBuilder {
    LiveActivity.Activity getActivity(int i);

    int getActivityCount();

    List<LiveActivity.Activity> getActivityList();

    LiveActivity.ActivityOrBuilder getActivityOrBuilder(int i);

    List<? extends LiveActivity.ActivityOrBuilder> getActivityOrBuilderList();
}
