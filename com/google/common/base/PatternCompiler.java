package com.google.common.base;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8110460-dex2jar.jar:com/google/common/base/PatternCompiler.class */
public interface PatternCompiler {
    CommonPattern compile(String str);

    boolean isPcreLike();
}
