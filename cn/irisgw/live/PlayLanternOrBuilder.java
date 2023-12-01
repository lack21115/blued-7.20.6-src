package cn.irisgw.live;

import cn.irisgw.live.PlayLantern;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/PlayLanternOrBuilder.class */
public interface PlayLanternOrBuilder extends MessageOrBuilder {
    PlayLantern.resource getImage(int i);

    int getImageCount();

    List<PlayLantern.resource> getImageList();

    PlayLantern.resourceOrBuilder getImageOrBuilder(int i);

    List<? extends PlayLantern.resourceOrBuilder> getImageOrBuilderList();

    int getLanternId();

    int getPlayTimes();
}
