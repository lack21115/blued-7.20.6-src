package com.google.api;

import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* loaded from: source-8110460-dex2jar.jar:com/google/api/SystemParametersOrBuilder.class */
public interface SystemParametersOrBuilder extends MessageOrBuilder {
    SystemParameterRule getRules(int i);

    int getRulesCount();

    List<SystemParameterRule> getRulesList();

    SystemParameterRuleOrBuilder getRulesOrBuilder(int i);

    List<? extends SystemParameterRuleOrBuilder> getRulesOrBuilderList();
}
