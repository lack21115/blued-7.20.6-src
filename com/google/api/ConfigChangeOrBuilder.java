package com.google.api;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* loaded from: source-8110460-dex2jar.jar:com/google/api/ConfigChangeOrBuilder.class */
public interface ConfigChangeOrBuilder extends MessageOrBuilder {
    Advice getAdvices(int i);

    int getAdvicesCount();

    List<Advice> getAdvicesList();

    AdviceOrBuilder getAdvicesOrBuilder(int i);

    List<? extends AdviceOrBuilder> getAdvicesOrBuilderList();

    ChangeType getChangeType();

    int getChangeTypeValue();

    String getElement();

    ByteString getElementBytes();

    String getNewValue();

    ByteString getNewValueBytes();

    String getOldValue();

    ByteString getOldValueBytes();
}
