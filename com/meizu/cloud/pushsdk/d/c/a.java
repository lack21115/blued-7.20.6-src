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
    private final List<com.meizu.cloud.pushsdk.d.a.b> f24101a;
    private final long b;

    /* renamed from: c  reason: collision with root package name */
    private final String f24102c;

    /* renamed from: com.meizu.cloud.pushsdk.d.c.a$a  reason: collision with other inner class name */
    /* loaded from: source-8303388-dex2jar.jar:com/meizu/cloud/pushsdk/d/c/a$a.class */
    public static abstract class AbstractC0609a<T extends AbstractC0609a<T>> {

        /* renamed from: a  reason: collision with root package name */
        private List<com.meizu.cloud.pushsdk.d.a.b> f24103a = new LinkedList();
        private long b = System.currentTimeMillis();

        /* renamed from: c  reason: collision with root package name */
        private String f24104c = e.b();

        /* JADX INFO: Access modifiers changed from: protected */
        public abstract T a();

        public T a(long j) {
            this.b = j;
            return a();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a(AbstractC0609a<?> abstractC0609a) {
        d.a(((AbstractC0609a) abstractC0609a).f24103a);
        d.a(((AbstractC0609a) abstractC0609a).f24104c);
        d.a(!((AbstractC0609a) abstractC0609a).f24104c.isEmpty(), "eventId cannot be empty");
        this.f24101a = ((AbstractC0609a) abstractC0609a).f24103a;
        this.b = ((AbstractC0609a) abstractC0609a).b;
        this.f24102c = ((AbstractC0609a) abstractC0609a).f24104c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public c a(c cVar) {
        cVar.a(NotificationStyle.EXPANDABLE_IMAGE_URL, c());
        cVar.a("ts", Long.toString(b()));
        return cVar;
    }

    public List<com.meizu.cloud.pushsdk.d.a.b> a() {
        return new ArrayList(this.f24101a);
    }

    public long b() {
        return this.b;
    }

    public String c() {
        return this.f24102c;
    }
}
