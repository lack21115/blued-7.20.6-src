package com.google.api;

import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* loaded from: source-8110460-dex2jar.jar:com/google/api/ProjectPropertiesOrBuilder.class */
public interface ProjectPropertiesOrBuilder extends MessageOrBuilder {
    Property getProperties(int i);

    int getPropertiesCount();

    List<Property> getPropertiesList();

    PropertyOrBuilder getPropertiesOrBuilder(int i);

    List<? extends PropertyOrBuilder> getPropertiesOrBuilderList();
}
