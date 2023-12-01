package cn.irisgw.live;

import cn.irisgw.live.SyncTopAudienceExtra;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/SyncTopAudienceExtraOrBuilder.class */
public interface SyncTopAudienceExtraOrBuilder extends MessageOrBuilder {
    SyncTopAudienceExtra.TopAudience getTops(int i);

    int getTopsCount();

    List<SyncTopAudienceExtra.TopAudience> getTopsList();

    SyncTopAudienceExtra.TopAudienceOrBuilder getTopsOrBuilder(int i);

    List<? extends SyncTopAudienceExtra.TopAudienceOrBuilder> getTopsOrBuilderList();
}
