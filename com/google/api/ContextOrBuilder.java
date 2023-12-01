package com.google.api;

import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* loaded from: source-8110460-dex2jar.jar:com/google/api/ContextOrBuilder.class */
public interface ContextOrBuilder extends MessageOrBuilder {
    ContextRule getRules(int i);

    int getRulesCount();

    List<ContextRule> getRulesList();

    ContextRuleOrBuilder getRulesOrBuilder(int i);

    List<? extends ContextRuleOrBuilder> getRulesOrBuilderList();
}
