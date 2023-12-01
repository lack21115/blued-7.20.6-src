package com.tencent.cloud.huiyansdkface.normal.thread;

import java.util.LinkedList;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/normal/thread/CascadeOperate.class */
public class CascadeOperate {
    private LinkedList<a> mStack = new LinkedList<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/normal/thread/CascadeOperate$a.class */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        final b f35795a;
        final Runnable b;

        a(b bVar, Runnable runnable) {
            this.f35795a = bVar;
            this.b = runnable;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/normal/thread/CascadeOperate$b.class */
    public enum b {
        UI,
        SUB
    }

    private CascadeOperate() {
    }

    public static CascadeOperate getInstance() {
        return new CascadeOperate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void start(final LinkedList<a> linkedList) {
        if (linkedList.isEmpty()) {
            return;
        }
        final a removeLast = linkedList.removeLast();
        if (b.UI.equals(removeLast.f35795a)) {
            ThreadOperate.runOnUiThread(new Runnable() { // from class: com.tencent.cloud.huiyansdkface.normal.thread.CascadeOperate.1
                @Override // java.lang.Runnable
                public void run() {
                    removeLast.b.run();
                    CascadeOperate.this.start(linkedList);
                }
            });
        }
        if (b.SUB.equals(removeLast.f35795a)) {
            ThreadOperate.runOnSubThread(new Runnable() { // from class: com.tencent.cloud.huiyansdkface.normal.thread.CascadeOperate.2
                @Override // java.lang.Runnable
                public void run() {
                    removeLast.b.run();
                    CascadeOperate.this.start(linkedList);
                }
            });
        }
    }

    public CascadeOperate runOnSubThread(Runnable runnable) {
        this.mStack.push(new a(b.SUB, runnable));
        return this;
    }

    public CascadeOperate runOnUiThread(Runnable runnable) {
        this.mStack.push(new a(b.UI, runnable));
        return this;
    }

    public void start() {
        start(this.mStack);
    }
}
