package com.kwai.filedownloader.event;

import com.kwai.filedownloader.e.d;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.concurrent.Executor;

/* loaded from: source-7994992-dex2jar.jar:com/kwai/filedownloader/event/a.class */
public class a {
    private final Executor aIg = com.kwai.filedownloader.e.b.n(10, "EventPool");
    private final HashMap<String, LinkedList<c>> aIh = new HashMap<>();

    private static void a(LinkedList<c> linkedList, b bVar) {
        Object[] array = linkedList.toArray();
        int length = array.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                break;
            }
            Object obj = array[i2];
            if (obj != null) {
                ((c) obj).a(bVar);
            }
            i = i2 + 1;
        }
        if (bVar.aIm != null) {
            bVar.aIm.run();
        }
    }

    public final boolean a(String str, c cVar) {
        boolean add;
        if (d.aJq) {
            d.i(this, "setListener %s", str);
        }
        if (cVar != null) {
            LinkedList<c> linkedList = this.aIh.get(str);
            LinkedList<c> linkedList2 = linkedList;
            if (linkedList == null) {
                synchronized (str.intern()) {
                    LinkedList<c> linkedList3 = this.aIh.get(str);
                    linkedList2 = linkedList3;
                    if (linkedList3 == null) {
                        HashMap<String, LinkedList<c>> hashMap = this.aIh;
                        linkedList2 = new LinkedList<>();
                        hashMap.put(str, linkedList2);
                    }
                }
            }
            synchronized (str.intern()) {
                add = linkedList2.add(cVar);
            }
            return add;
        }
        throw new IllegalArgumentException("listener must not be null!");
    }

    public final boolean b(b bVar) {
        if (d.aJq) {
            d.i(this, "publish %s", bVar.getId());
        }
        if (bVar != null) {
            String id = bVar.getId();
            LinkedList<c> linkedList = this.aIh.get(id);
            LinkedList<c> linkedList2 = linkedList;
            if (linkedList == null) {
                synchronized (id.intern()) {
                    linkedList2 = this.aIh.get(id);
                    if (linkedList2 == null) {
                        if (d.aJq) {
                            d.g(this, "No listener for this event %s", id);
                        }
                        return false;
                    }
                }
            }
            a(linkedList2, bVar);
            return true;
        }
        throw new IllegalArgumentException("event must not be null!");
    }

    public final void c(final b bVar) {
        if (d.aJq) {
            d.i(this, "asyncPublishInNewThread %s", bVar.getId());
        }
        this.aIg.execute(new Runnable() { // from class: com.kwai.filedownloader.event.a.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    a.this.b(bVar);
                } catch (Exception e) {
                }
            }
        });
    }
}
