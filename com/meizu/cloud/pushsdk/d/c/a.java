package com.meizu.cloud.pushsdk.d.c;

import com.meizu.cloud.pushsdk.d.a.c;
import com.meizu.cloud.pushsdk.d.f.d;
import com.meizu.cloud.pushsdk.d.f.e;
import com.meizu.cloud.pushsdk.notification.model.NotificationStyle;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/meizu/cloud/pushsdk/d/c/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private final List<com.meizu.cloud.pushsdk.d.a.b> f10486a;
    private final long b;

    /* renamed from: c  reason: collision with root package name */
    private final String f10487c;

    /* renamed from: com.meizu.cloud.pushsdk.d.c.a$a  reason: collision with other inner class name */
    /* loaded from: source-8303388-dex2jar.jar:com/meizu/cloud/pushsdk/d/c/a$a.class */
    public static abstract class AbstractC0439a<T extends AbstractC0439a<T>> {

        /* renamed from: a  reason: collision with root package name */
        private List<com.meizu.cloud.pushsdk.d.a.b> f10488a = new LinkedList();
        private long b = System.currentTimeMillis();

        /* renamed from: c  reason: collision with root package name */
        private String f10489c = e.b();

        /* JADX INFO: Access modifiers changed from: protected */
        public abstract T a();

        public T a(long j) {
            this.b = j;
            return a();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a(AbstractC0439a<?> abstractC0439a) {
        d.a(((AbstractC0439a) abstractC0439a).f10488a);
        d.a(((AbstractC0439a) abstractC0439a).f10489c);
        d.a(!((AbstractC0439a) abstractC0439a).f10489c.isEmpty(), "eventId cannot be empty");
        this.f10486a = ((AbstractC0439a) abstractC0439a).f10488a;
        this.b = ((AbstractC0439a) abstractC0439a).b;
        this.f10487c = ((AbstractC0439a) abstractC0439a).f10489c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public c a(c cVar) {
        cVar.a(NotificationStyle.EXPANDABLE_IMAGE_URL, c());
        cVar.a("ts", Long.toString(b()));
        return cVar;
    }

    public List<com.meizu.cloud.pushsdk.d.a.b> a() {
        return new ArrayList(this.f10486a);
    }

    public long b() {
        return this.b;
    }

    public String c() {
        return this.f10487c;
    }
}
