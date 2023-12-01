package cn.irisgw.live;

import cn.irisgw.live.PlayLanternUpdate;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/PlayLanternUpdateOrBuilder.class */
public interface PlayLanternUpdateOrBuilder extends MessageOrBuilder {
    PlayLanternUpdate.lantern getLanternResource(int i);

    int getLanternResourceCount();

    List<PlayLanternUpdate.lantern> getLanternResourceList();

    PlayLanternUpdate.lanternOrBuilder getLanternResourceOrBuilder(int i);

    List<? extends PlayLanternUpdate.lanternOrBuilder> getLanternResourceOrBuilderList();
}
