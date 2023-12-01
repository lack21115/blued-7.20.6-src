package com.jeremyliao.liveeventbus.ipc.annotation;

import com.jeremyliao.liveeventbus.ipc.core.Processor;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: source-7994992-dex2jar.jar:com/jeremyliao/liveeventbus/ipc/annotation/IpcConfig.class */
public @interface IpcConfig {
    Class<? extends Processor> processor();
}
