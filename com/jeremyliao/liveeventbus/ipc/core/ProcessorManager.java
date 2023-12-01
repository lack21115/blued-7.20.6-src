package com.jeremyliao.liveeventbus.ipc.core;

import android.content.Intent;
import android.os.Bundle;
import com.jeremyliao.liveeventbus.ipc.annotation.IpcConfig;
import com.jeremyliao.liveeventbus.ipc.consts.IpcConst;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* loaded from: source-7994992-dex2jar.jar:com/jeremyliao/liveeventbus/ipc/core/ProcessorManager.class */
public class ProcessorManager {
    private final List<Processor> baseProcessors;
    private final Map<String, Processor> processorMap;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/jeremyliao/liveeventbus/ipc/core/ProcessorManager$SingletonHolder.class */
    public static class SingletonHolder {
        private static final ProcessorManager INSTANCE = new ProcessorManager();

        private SingletonHolder() {
        }
    }

    private ProcessorManager() {
        this.baseProcessors = new LinkedList(Arrays.asList(new StringProcessor(), new IntProcessor(), new BooleanProcessor(), new DoubleProcessor(), new FloatProcessor(), new LongProcessor(), new SerializableProcessor(), new ParcelableProcessor()));
        this.processorMap = new HashMap();
        for (Processor processor : this.baseProcessors) {
            this.processorMap.put(processor.getClass().getName(), processor);
        }
    }

    public static ProcessorManager getManager() {
        return SingletonHolder.INSTANCE;
    }

    public Object createFrom(Intent intent) {
        if (intent == null) {
            return null;
        }
        String stringExtra = intent.getStringExtra(IpcConst.KEY_PROCESSOR_NAME);
        Bundle bundleExtra = intent.getBundleExtra(IpcConst.KEY_BUNDLE);
        if (stringExtra == null || stringExtra.length() == 0 || bundleExtra == null) {
            return null;
        }
        if (!this.processorMap.containsKey(stringExtra)) {
            try {
                this.processorMap.put(stringExtra, (Processor) Class.forName(stringExtra).newInstance());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Processor processor = this.processorMap.get(stringExtra);
        if (processor == null) {
            return null;
        }
        try {
            return processor.createFromBundle(bundleExtra);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public boolean writeTo(Intent intent, Object obj) {
        boolean z = false;
        if (intent == null || obj == null) {
            return false;
        }
        Bundle bundle = new Bundle();
        IpcConfig ipcConfig = (IpcConfig) obj.getClass().getAnnotation(IpcConfig.class);
        if (ipcConfig != null) {
            Class<? extends Processor> processor = ipcConfig.processor();
            String name = processor.getName();
            if (!this.processorMap.containsKey(name)) {
                try {
                    this.processorMap.put(name, processor.newInstance());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            Processor processor2 = this.processorMap.get(name);
            boolean z2 = false;
            if (processor2 != null) {
                z2 = false;
                try {
                    if (processor2.writeToBundle(bundle, obj)) {
                        intent.putExtra(IpcConst.KEY_PROCESSOR_NAME, processor2.getClass().getName());
                        intent.putExtra(IpcConst.KEY_BUNDLE, bundle);
                        z2 = true;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                    z2 = false;
                }
            }
            z = z2;
            if (z2) {
                return true;
            }
        }
        for (Processor processor3 : this.baseProcessors) {
            try {
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            if (processor3.writeToBundle(bundle, obj)) {
                intent.putExtra(IpcConst.KEY_PROCESSOR_NAME, processor3.getClass().getName());
                intent.putExtra(IpcConst.KEY_BUNDLE, bundle);
                return true;
            }
            continue;
        }
        return z;
    }
}
