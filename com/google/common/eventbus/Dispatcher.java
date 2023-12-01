package com.google.common.eventbus;

import com.google.common.base.Preconditions;
import com.google.common.collect.Queues;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8110460-dex2jar.jar:com/google/common/eventbus/Dispatcher.class */
public abstract class Dispatcher {

    /* loaded from: source-8110460-dex2jar.jar:com/google/common/eventbus/Dispatcher$ImmediateDispatcher.class */
    static final class ImmediateDispatcher extends Dispatcher {
        private static final ImmediateDispatcher INSTANCE = new ImmediateDispatcher();

        private ImmediateDispatcher() {
        }

        @Override // com.google.common.eventbus.Dispatcher
        void dispatch(Object obj, Iterator<Subscriber> it) {
            Preconditions.checkNotNull(obj);
            while (it.hasNext()) {
                it.next().dispatchEvent(obj);
            }
        }
    }

    /* loaded from: source-8110460-dex2jar.jar:com/google/common/eventbus/Dispatcher$LegacyAsyncDispatcher.class */
    static final class LegacyAsyncDispatcher extends Dispatcher {
        private final ConcurrentLinkedQueue<EventWithSubscriber> queue;

        /* loaded from: source-8110460-dex2jar.jar:com/google/common/eventbus/Dispatcher$LegacyAsyncDispatcher$EventWithSubscriber.class */
        static final class EventWithSubscriber {
            private final Object event;
            private final Subscriber subscriber;

            private EventWithSubscriber(Object obj, Subscriber subscriber) {
                this.event = obj;
                this.subscriber = subscriber;
            }
        }

        private LegacyAsyncDispatcher() {
            this.queue = Queues.newConcurrentLinkedQueue();
        }

        @Override // com.google.common.eventbus.Dispatcher
        void dispatch(Object obj, Iterator<Subscriber> it) {
            Preconditions.checkNotNull(obj);
            while (it.hasNext()) {
                this.queue.add(new EventWithSubscriber(obj, it.next()));
            }
            while (true) {
                EventWithSubscriber poll = this.queue.poll();
                if (poll == null) {
                    return;
                }
                poll.subscriber.dispatchEvent(poll.event);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8110460-dex2jar.jar:com/google/common/eventbus/Dispatcher$PerThreadQueuedDispatcher.class */
    public static final class PerThreadQueuedDispatcher extends Dispatcher {
        private final ThreadLocal<Boolean> dispatching;
        private final ThreadLocal<Queue<Event>> queue;

        /* loaded from: source-8110460-dex2jar.jar:com/google/common/eventbus/Dispatcher$PerThreadQueuedDispatcher$Event.class */
        static final class Event {
            private final Object event;
            private final Iterator<Subscriber> subscribers;

            private Event(Object obj, Iterator<Subscriber> it) {
                this.event = obj;
                this.subscribers = it;
            }
        }

        private PerThreadQueuedDispatcher() {
            this.queue = new ThreadLocal<Queue<Event>>() { // from class: com.google.common.eventbus.Dispatcher.PerThreadQueuedDispatcher.1
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // java.lang.ThreadLocal
                public Queue<Event> initialValue() {
                    return Queues.newArrayDeque();
                }
            };
            this.dispatching = new ThreadLocal<Boolean>() { // from class: com.google.common.eventbus.Dispatcher.PerThreadQueuedDispatcher.2
                /* JADX INFO: Access modifiers changed from: protected */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.lang.ThreadLocal
                public Boolean initialValue() {
                    return false;
                }
            };
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0071 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:7:0x004f A[Catch: all -> 0x0080, LOOP:1: B:7:0x004f->B:9:0x005b, LOOP_START, TRY_ENTER, TryCatch #0 {all -> 0x0080, blocks: (B:5:0x0041, B:7:0x004f, B:9:0x005b), top: B:16:0x0041 }] */
        @Override // com.google.common.eventbus.Dispatcher
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void dispatch(java.lang.Object r8, java.util.Iterator<com.google.common.eventbus.Subscriber> r9) {
            /*
                r7 = this;
                r0 = r8
                java.lang.Object r0 = com.google.common.base.Preconditions.checkNotNull(r0)
                r0 = r9
                java.lang.Object r0 = com.google.common.base.Preconditions.checkNotNull(r0)
                r0 = r7
                java.lang.ThreadLocal<java.util.Queue<com.google.common.eventbus.Dispatcher$PerThreadQueuedDispatcher$Event>> r0 = r0.queue
                java.lang.Object r0 = r0.get()
                java.util.Queue r0 = (java.util.Queue) r0
                r10 = r0
                r0 = r10
                com.google.common.eventbus.Dispatcher$PerThreadQueuedDispatcher$Event r1 = new com.google.common.eventbus.Dispatcher$PerThreadQueuedDispatcher$Event
                r2 = r1
                r3 = r8
                r4 = r9
                r5 = 0
                r2.<init>(r3, r4)
                boolean r0 = r0.offer(r1)
                r0 = r7
                java.lang.ThreadLocal<java.lang.Boolean> r0 = r0.dispatching
                java.lang.Object r0 = r0.get()
                java.lang.Boolean r0 = (java.lang.Boolean) r0
                boolean r0 = r0.booleanValue()
                if (r0 != 0) goto L91
                r0 = r7
                java.lang.ThreadLocal<java.lang.Boolean> r0 = r0.dispatching
                r1 = 1
                java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
                r0.set(r1)
            L41:
                r0 = r10
                java.lang.Object r0 = r0.poll()     // Catch: java.lang.Throwable -> L80
                com.google.common.eventbus.Dispatcher$PerThreadQueuedDispatcher$Event r0 = (com.google.common.eventbus.Dispatcher.PerThreadQueuedDispatcher.Event) r0     // Catch: java.lang.Throwable -> L80
                r8 = r0
                r0 = r8
                if (r0 == 0) goto L71
            L4f:
                r0 = r8
                java.util.Iterator r0 = com.google.common.eventbus.Dispatcher.PerThreadQueuedDispatcher.Event.access$400(r0)     // Catch: java.lang.Throwable -> L80
                boolean r0 = r0.hasNext()     // Catch: java.lang.Throwable -> L80
                if (r0 == 0) goto L41
                r0 = r8
                java.util.Iterator r0 = com.google.common.eventbus.Dispatcher.PerThreadQueuedDispatcher.Event.access$400(r0)     // Catch: java.lang.Throwable -> L80
                java.lang.Object r0 = r0.next()     // Catch: java.lang.Throwable -> L80
                com.google.common.eventbus.Subscriber r0 = (com.google.common.eventbus.Subscriber) r0     // Catch: java.lang.Throwable -> L80
                r1 = r8
                java.lang.Object r1 = com.google.common.eventbus.Dispatcher.PerThreadQueuedDispatcher.Event.access$500(r1)     // Catch: java.lang.Throwable -> L80
                r0.dispatchEvent(r1)     // Catch: java.lang.Throwable -> L80
                goto L4f
            L71:
                r0 = r7
                java.lang.ThreadLocal<java.lang.Boolean> r0 = r0.dispatching
                r0.remove()
                r0 = r7
                java.lang.ThreadLocal<java.util.Queue<com.google.common.eventbus.Dispatcher$PerThreadQueuedDispatcher$Event>> r0 = r0.queue
                r0.remove()
                return
            L80:
                r8 = move-exception
                r0 = r7
                java.lang.ThreadLocal<java.lang.Boolean> r0 = r0.dispatching
                r0.remove()
                r0 = r7
                java.lang.ThreadLocal<java.util.Queue<com.google.common.eventbus.Dispatcher$PerThreadQueuedDispatcher$Event>> r0 = r0.queue
                r0.remove()
                r0 = r8
                throw r0
            L91:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.eventbus.Dispatcher.PerThreadQueuedDispatcher.dispatch(java.lang.Object, java.util.Iterator):void");
        }
    }

    Dispatcher() {
    }

    static Dispatcher immediate() {
        return ImmediateDispatcher.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Dispatcher legacyAsync() {
        return new LegacyAsyncDispatcher();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Dispatcher perThreadDispatchQueue() {
        return new PerThreadQueuedDispatcher();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void dispatch(Object obj, Iterator<Subscriber> it);
}
