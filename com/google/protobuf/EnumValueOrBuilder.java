package com.google.protobuf;

import java.util.List;

/* loaded from: source-8110460-dex2jar.jar:com/google/protobuf/EnumValueOrBuilder.class */
public interface EnumValueOrBuilder extends MessageOrBuilder {
    String getName();

    ByteString getNameBytes();

    int getNumber();

    Option getOptions(int i);

    int getOptionsCount();

    List<Option> getOptionsList();

    OptionOrBuilder getOptionsOrBuilder(int i);

    List<? extends OptionOrBuilder> getOptionsOrBuilderList();
}
