package cn.irisgw.live;

import cn.irisgw.live.BoxExtra;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/BoxExtraOrBuilder.class */
public interface BoxExtraOrBuilder extends MessageOrBuilder {
    BoxExtra.Box getBoxes(int i);

    int getBoxesCount();

    List<BoxExtra.Box> getBoxesList();

    BoxExtra.BoxOrBuilder getBoxesOrBuilder(int i);

    List<? extends BoxExtra.BoxOrBuilder> getBoxesOrBuilderList();
}
