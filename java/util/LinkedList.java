package java.util;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;

/* loaded from: source-2895416-dex2jar.jar:java/util/LinkedList.class */
public class LinkedList<E> extends AbstractSequentialList<E> implements List<E>, Deque<E>, Queue<E>, Cloneable, Serializable {
    private static final long serialVersionUID = 876323262645176354L;
    transient int size;
    transient Link<E> voidLink;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-2895416-dex2jar.jar:java/util/LinkedList$Link.class */
    public static final class Link<ET> {
        ET data;
        Link<ET> next;
        Link<ET> previous;

        Link(ET et, Link<ET> link, Link<ET> link2) {
            this.data = et;
            this.previous = link;
            this.next = link2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-2895416-dex2jar.jar:java/util/LinkedList$LinkIterator.class */
    public static final class LinkIterator<ET> implements ListIterator<ET> {
        int expectedModCount;
        Link<ET> lastLink;
        Link<ET> link;
        final LinkedList<ET> list;
        int pos;

        LinkIterator(LinkedList<ET> linkedList, int i) {
            this.list = linkedList;
            this.expectedModCount = this.list.modCount;
            if (i < 0 || i > this.list.size) {
                throw new IndexOutOfBoundsException();
            }
            this.link = this.list.voidLink;
            if (i < this.list.size / 2) {
                this.pos = -1;
                while (this.pos + 1 < i) {
                    this.link = this.link.next;
                    this.pos++;
                }
                return;
            }
            this.pos = this.list.size;
            while (this.pos >= i) {
                this.link = this.link.previous;
                this.pos--;
            }
        }

        @Override // java.util.ListIterator
        public void add(ET et) {
            if (this.expectedModCount != this.list.modCount) {
                throw new ConcurrentModificationException();
            }
            Link<ET> link = this.link.next;
            Link<ET> link2 = new Link<>(et, this.link, link);
            this.link.next = link2;
            link.previous = link2;
            this.link = link2;
            this.lastLink = null;
            this.pos++;
            this.expectedModCount++;
            this.list.size++;
            this.list.modCount++;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.link.next != this.list.voidLink;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.link != this.list.voidLink;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public ET next() {
            if (this.expectedModCount == this.list.modCount) {
                Link<ET> link = this.link.next;
                if (link != this.list.voidLink) {
                    this.link = link;
                    this.lastLink = link;
                    this.pos++;
                    return this.link.data;
                }
                throw new NoSuchElementException();
            }
            throw new ConcurrentModificationException();
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.pos + 1;
        }

        @Override // java.util.ListIterator
        public ET previous() {
            if (this.expectedModCount == this.list.modCount) {
                if (this.link != this.list.voidLink) {
                    this.lastLink = this.link;
                    this.link = this.link.previous;
                    this.pos--;
                    return this.lastLink.data;
                }
                throw new NoSuchElementException();
            }
            throw new ConcurrentModificationException();
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.pos;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            if (this.expectedModCount != this.list.modCount) {
                throw new ConcurrentModificationException();
            }
            if (this.lastLink == null) {
                throw new IllegalStateException();
            }
            Link<ET> link = this.lastLink.next;
            Link<ET> link2 = this.lastLink.previous;
            link.previous = link2;
            link2.next = link;
            if (this.lastLink == this.link) {
                this.pos--;
            }
            this.link = link2;
            this.lastLink = null;
            this.expectedModCount++;
            this.list.size--;
            this.list.modCount++;
        }

        @Override // java.util.ListIterator
        public void set(ET et) {
            if (this.expectedModCount != this.list.modCount) {
                throw new ConcurrentModificationException();
            }
            if (this.lastLink == null) {
                throw new IllegalStateException();
            }
            this.lastLink.data = et;
        }
    }

    /* loaded from: source-2895416-dex2jar.jar:java/util/LinkedList$ReverseLinkIterator.class */
    private class ReverseLinkIterator<ET> implements Iterator<ET> {
        private boolean canRemove = false;
        private int expectedModCount;
        private Link<ET> link;
        private final LinkedList<ET> list;

        ReverseLinkIterator(LinkedList<ET> linkedList) {
            this.list = linkedList;
            this.expectedModCount = this.list.modCount;
            this.link = this.list.voidLink;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.link.previous != this.list.voidLink;
        }

        @Override // java.util.Iterator
        public ET next() {
            if (this.expectedModCount == this.list.modCount) {
                if (hasNext()) {
                    this.link = this.link.previous;
                    this.canRemove = true;
                    return this.link.data;
                }
                throw new NoSuchElementException();
            }
            throw new ConcurrentModificationException();
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.expectedModCount != this.list.modCount) {
                throw new ConcurrentModificationException();
            }
            if (!this.canRemove) {
                throw new IllegalStateException();
            }
            Link<ET> link = this.link.previous;
            Link<ET> link2 = this.link.next;
            link.next = link2;
            link2.previous = link;
            this.link = link2;
            this.list.size--;
            this.list.modCount++;
            this.expectedModCount++;
            this.canRemove = false;
        }
    }

    public LinkedList() {
        this.size = 0;
        this.voidLink = new Link<>(null, null, null);
        this.voidLink.previous = (Link<E>) this.voidLink;
        this.voidLink.next = (Link<E>) this.voidLink;
    }

    public LinkedList(Collection<? extends E> collection) {
        this();
        addAll(collection);
    }

    private boolean addFirstImpl(E e) {
        Link<E> link = this.voidLink.next;
        Link<ET> link2 = new Link<>(e, this.voidLink, link);
        this.voidLink.next = link2;
        link.previous = link2;
        this.size++;
        this.modCount++;
        return true;
    }

    private boolean addLastImpl(E e) {
        Link<E> link = this.voidLink.previous;
        Link<ET> link2 = new Link<>(e, link, this.voidLink);
        this.voidLink.previous = link2;
        link.next = link2;
        this.size++;
        this.modCount++;
        return true;
    }

    private E getFirstImpl() {
        Link<E> link = this.voidLink.next;
        if (link != this.voidLink) {
            return link.data;
        }
        throw new NoSuchElementException();
    }

    private E peekFirstImpl() {
        Link<E> link = this.voidLink.next;
        if (link == this.voidLink) {
            return null;
        }
        return link.data;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.size = objectInputStream.readInt();
        this.voidLink = new Link<>(null, null, null);
        Link link = this.voidLink;
        int i = this.size;
        while (true) {
            i--;
            if (i < 0) {
                link.next = (Link<E>) this.voidLink;
                this.voidLink.previous = link;
                return;
            }
            Link link2 = new Link(objectInputStream.readObject(), link, null);
            link.next = link2;
            link = link2;
        }
    }

    private E removeFirstImpl() {
        Link<E> link = this.voidLink.next;
        if (link != this.voidLink) {
            Link link2 = (Link<E>) link.next;
            this.voidLink.next = link2;
            link2.previous = (Link<E>) this.voidLink;
            this.size--;
            this.modCount++;
            return link.data;
        }
        throw new NoSuchElementException();
    }

    private boolean removeFirstOccurrenceImpl(Object obj) {
        return removeOneOccurrence(obj, new LinkIterator(this, 0));
    }

    private E removeLastImpl() {
        Link<E> link = this.voidLink.previous;
        if (link != this.voidLink) {
            Link link2 = (Link<E>) link.previous;
            this.voidLink.previous = link2;
            link2.next = (Link<E>) this.voidLink;
            this.size--;
            this.modCount++;
            return link.data;
        }
        throw new NoSuchElementException();
    }

    private boolean removeOneOccurrence(Object obj, Iterator<E> it) {
        while (it.hasNext()) {
            E next = it.next();
            if (obj == null) {
                if (next == null) {
                    it.remove();
                    return true;
                }
            } else if (obj.equals(next)) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(this.size);
        Iterator<E> it = iterator();
        while (it.hasNext()) {
            objectOutputStream.writeObject(it.next());
        }
    }

    @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
    public void add(int i, E e) {
        Link<E> link;
        if (i < 0 || i > this.size) {
            throw new IndexOutOfBoundsException();
        }
        Link<E> link2 = this.voidLink;
        if (i >= this.size / 2) {
            int i2 = this.size;
            while (true) {
                int i3 = i2;
                link = link2;
                if (i3 <= i) {
                    break;
                }
                link2 = link2.previous;
                i2 = i3 - 1;
            }
        } else {
            int i4 = 0;
            while (true) {
                int i5 = i4;
                link = link2;
                if (i5 > i) {
                    break;
                }
                link2 = link2.next;
                i4 = i5 + 1;
            }
        }
        Link<E> link3 = link.previous;
        Link<ET> link4 = new Link<>(e, link3, link);
        link3.next = link4;
        link.previous = link4;
        this.size++;
        this.modCount++;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection
    public boolean add(E e) {
        return addLastImpl(e);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
    public boolean addAll(int i, Collection<? extends E> collection) {
        Link link;
        if (i < 0 || i > this.size) {
            throw new IndexOutOfBoundsException();
        }
        int size = collection.size();
        if (size == 0) {
            return false;
        }
        ArrayList arrayList = collection == this ? new ArrayList(collection) : collection;
        Link link2 = this.voidLink;
        if (i >= this.size / 2) {
            int i2 = this.size;
            while (true) {
                int i3 = i2;
                link = link2;
                if (i3 < i) {
                    break;
                }
                link2 = link2.previous;
                i2 = i3 - 1;
            }
        } else {
            int i4 = 0;
            while (true) {
                int i5 = i4;
                link = link2;
                if (i5 >= i) {
                    break;
                }
                link2 = link2.next;
                i4 = i5 + 1;
            }
        }
        Link link3 = (Link<E>) link.next;
        for (E e : arrayList) {
            Link link4 = new Link(e, link, null);
            link.next = link4;
            link = link4;
        }
        link.next = link3;
        link3.previous = link;
        this.size += size;
        this.modCount++;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean addAll(Collection<? extends E> collection) {
        int size = collection.size();
        if (size == 0) {
            return false;
        }
        if (collection == this) {
            collection = new ArrayList((Collection<? extends Object>) collection);
        }
        Link link = this.voidLink.previous;
        Iterator<? extends E> it = collection.iterator();
        while (true) {
            Link link2 = link;
            if (!it.hasNext()) {
                link2.next = (Link<E>) this.voidLink;
                this.voidLink.previous = link2;
                this.size += size;
                this.modCount++;
                return true;
            }
            link = new Link(it.next(), link2, null);
            link2.next = link;
        }
    }

    @Override // java.util.Deque
    public void addFirst(E e) {
        addFirstImpl(e);
    }

    @Override // java.util.Deque
    public void addLast(E e) {
        addLastImpl(e);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        if (this.size > 0) {
            this.size = 0;
            this.voidLink.next = (Link<E>) this.voidLink;
            this.voidLink.previous = (Link<E>) this.voidLink;
            this.modCount++;
        }
    }

    public Object clone() {
        try {
            LinkedList linkedList = (LinkedList) super.clone();
            linkedList.size = 0;
            linkedList.voidLink = new Link<>(null, null, null);
            linkedList.voidLink.previous = (Link<E>) linkedList.voidLink;
            linkedList.voidLink.next = (Link<E>) linkedList.voidLink;
            linkedList.addAll(this);
            return linkedList;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        Link<E> link = this.voidLink.next;
        if (obj != null) {
            while (link != this.voidLink) {
                if (obj.equals(link.data)) {
                    return true;
                }
                link = link.next;
            }
            return false;
        }
        for (Link<E> link2 = link; link2 != this.voidLink; link2 = link2.next) {
            if (link2.data == null) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Deque
    public Iterator<E> descendingIterator() {
        return new ReverseLinkIterator(this);
    }

    @Override // java.util.Deque, java.util.Queue
    public E element() {
        return getFirstImpl();
    }

    @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
    public E get(int i) {
        Link<E> link;
        if (i < 0 || i >= this.size) {
            throw new IndexOutOfBoundsException();
        }
        Link<E> link2 = this.voidLink;
        if (i >= this.size / 2) {
            int i2 = this.size;
            while (true) {
                int i3 = i2;
                link = link2;
                if (i3 <= i) {
                    break;
                }
                link2 = link2.previous;
                i2 = i3 - 1;
            }
        } else {
            int i4 = 0;
            while (true) {
                int i5 = i4;
                link = link2;
                if (i5 > i) {
                    break;
                }
                link2 = link2.next;
                i4 = i5 + 1;
            }
        }
        return link.data;
    }

    @Override // java.util.Deque
    public E getFirst() {
        return getFirstImpl();
    }

    @Override // java.util.Deque
    public E getLast() {
        Link<E> link = this.voidLink.previous;
        if (link != this.voidLink) {
            return link.data;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        int i = 0;
        Link<E> link = this.voidLink.next;
        Link<E> link2 = link;
        if (obj == null) {
            while (link2 != this.voidLink) {
                if (link2.data == null) {
                    return i;
                }
                link2 = link2.next;
                i++;
            }
            return -1;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (link == this.voidLink) {
                return -1;
            }
            if (obj.equals(link.data)) {
                return i3;
            }
            link = link.next;
            i2 = i3 + 1;
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(Object obj) {
        int i = this.size;
        Link<E> link = this.voidLink.previous;
        int i2 = i;
        if (obj != null) {
            while (link != this.voidLink) {
                i--;
                if (obj.equals(link.data)) {
                    return i;
                }
                link = link.previous;
            }
            return -1;
        }
        for (Link<E> link2 = link; link2 != this.voidLink; link2 = link2.previous) {
            i2--;
            if (link2.data == null) {
                return i2;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
    public ListIterator<E> listIterator(int i) {
        return new LinkIterator(this, i);
    }

    @Override // java.util.Deque, java.util.Queue, java.util.concurrent.BlockingQueue
    public boolean offer(E e) {
        return addLastImpl(e);
    }

    @Override // java.util.Deque
    public boolean offerFirst(E e) {
        return addFirstImpl(e);
    }

    @Override // java.util.Deque
    public boolean offerLast(E e) {
        return addLastImpl(e);
    }

    @Override // java.util.Deque, java.util.Queue
    public E peek() {
        return peekFirstImpl();
    }

    @Override // java.util.Deque
    public E peekFirst() {
        return peekFirstImpl();
    }

    @Override // java.util.Deque
    public E peekLast() {
        Link<E> link = this.voidLink.previous;
        if (link == this.voidLink) {
            return null;
        }
        return link.data;
    }

    @Override // java.util.Deque, java.util.Queue
    public E poll() {
        if (this.size == 0) {
            return null;
        }
        return removeFirst();
    }

    @Override // java.util.Deque
    public E pollFirst() {
        if (this.size == 0) {
            return null;
        }
        return removeFirstImpl();
    }

    @Override // java.util.Deque
    public E pollLast() {
        if (this.size == 0) {
            return null;
        }
        return removeLastImpl();
    }

    @Override // java.util.Deque
    public E pop() {
        return removeFirstImpl();
    }

    @Override // java.util.Deque
    public void push(E e) {
        addFirstImpl(e);
    }

    @Override // java.util.Deque, java.util.Queue
    public E remove() {
        return removeFirstImpl();
    }

    @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
    public E remove(int i) {
        Link<E> link;
        if (i < 0 || i >= this.size) {
            throw new IndexOutOfBoundsException();
        }
        Link<E> link2 = this.voidLink;
        if (i >= this.size / 2) {
            int i2 = this.size;
            while (true) {
                int i3 = i2;
                link = link2;
                if (i3 <= i) {
                    break;
                }
                link2 = link2.previous;
                i2 = i3 - 1;
            }
        } else {
            int i4 = 0;
            while (true) {
                int i5 = i4;
                link = link2;
                if (i5 > i) {
                    break;
                }
                link2 = link2.next;
                i4 = i5 + 1;
            }
        }
        Link link3 = (Link<E>) link.previous;
        Link link4 = (Link<E>) link.next;
        link3.next = link4;
        link4.previous = link3;
        this.size--;
        this.modCount++;
        return link.data;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean remove(Object obj) {
        return removeFirstOccurrenceImpl(obj);
    }

    @Override // java.util.Deque
    public E removeFirst() {
        return removeFirstImpl();
    }

    @Override // java.util.Deque
    public boolean removeFirstOccurrence(Object obj) {
        return removeFirstOccurrenceImpl(obj);
    }

    @Override // java.util.Deque
    public E removeLast() {
        return removeLastImpl();
    }

    @Override // java.util.Deque
    public boolean removeLastOccurrence(Object obj) {
        return removeOneOccurrence(obj, new ReverseLinkIterator(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
    public E set(int i, E e) {
        Link<E> link;
        if (i < 0 || i >= this.size) {
            throw new IndexOutOfBoundsException();
        }
        Link<E> link2 = this.voidLink;
        if (i >= this.size / 2) {
            int i2 = this.size;
            while (true) {
                int i3 = i2;
                link = link2;
                if (i3 <= i) {
                    break;
                }
                link2 = link2.previous;
                i2 = i3 - 1;
            }
        } else {
            int i4 = 0;
            while (true) {
                int i5 = i4;
                link = link2;
                if (i5 > i) {
                    break;
                }
                link2 = link2.next;
                i4 = i5 + 1;
            }
        }
        E e2 = link.data;
        link.data = e;
        return e2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        return this.size;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public Object[] toArray() {
        int i = 0;
        Object[] objArr = new Object[this.size];
        Link<E> link = this.voidLink.next;
        while (link != this.voidLink) {
            objArr[i] = link.data;
            link = link.next;
            i++;
        }
        return objArr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v21, types: [java.lang.Object[]] */
    @Override // java.util.AbstractCollection, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        int i = 0;
        T[] tArr2 = tArr;
        if (this.size > tArr.length) {
            tArr2 = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.size);
        }
        Link<E> link = this.voidLink.next;
        while (link != this.voidLink) {
            tArr2[i] = link.data;
            link = link.next;
            i++;
        }
        if (i < tArr2.length) {
            tArr2[i] = null;
        }
        return tArr2;
    }
}
