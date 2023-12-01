package com.google.protobuf;

import java.util.List;

/* loaded from: source-8110460-dex2jar.jar:com/google/protobuf/ListValueOrBuilder.class */
public interface ListValueOrBuilder extends MessageOrBuilder {
    Value getValues(int i);

    int getValuesCount();

    List<Value> getValuesList();

    ValueOrBuilder getValuesOrBuilder(int i);

    List<? extends ValueOrBuilder> getValuesOrBuilderList();
}
