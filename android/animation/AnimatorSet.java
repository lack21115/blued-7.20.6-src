package android.animation;

import android.animation.Animator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-9557208-dex2jar.jar:android/animation/AnimatorSet.class */
public final class AnimatorSet extends Animator {
    private ArrayList<Animator> mPlayingSet = new ArrayList<>();
    private HashMap<Animator, Node> mNodeMap = new HashMap<>();
    private ArrayList<Node> mNodes = new ArrayList<>();
    private ArrayList<Node> mSortedNodes = new ArrayList<>();
    private boolean mNeedsSort = true;
    private AnimatorSetListener mSetListener = null;
    boolean mTerminated = false;
    private boolean mStarted = false;
    private long mStartDelay = 0;
    private ValueAnimator mDelayAnim = null;
    private long mDuration = -1;
    private TimeInterpolator mInterpolator = null;
    private boolean mReversible = true;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/animation/AnimatorSet$AnimatorSetListener.class */
    public class AnimatorSetListener implements Animator.AnimatorListener {
        private AnimatorSet mAnimatorSet;

        AnimatorSetListener(AnimatorSet animatorSet) {
            this.mAnimatorSet = animatorSet;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            if (AnimatorSet.this.mTerminated || AnimatorSet.this.mPlayingSet.size() != 0 || AnimatorSet.this.mListeners == null) {
                return;
            }
            int size = AnimatorSet.this.mListeners.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    return;
                }
                AnimatorSet.this.mListeners.get(i2).onAnimationCancel(this.mAnimatorSet);
                i = i2 + 1;
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            boolean z;
            animator.removeListener(this);
            AnimatorSet.this.mPlayingSet.remove(animator);
            ((Node) this.mAnimatorSet.mNodeMap.get(animator)).done = true;
            if (AnimatorSet.this.mTerminated) {
                return;
            }
            ArrayList arrayList = this.mAnimatorSet.mSortedNodes;
            int size = arrayList.size();
            int i = 0;
            while (true) {
                int i2 = i;
                z = true;
                if (i2 >= size) {
                    break;
                } else if (!((Node) arrayList.get(i2)).done) {
                    z = false;
                    break;
                } else {
                    i = i2 + 1;
                }
            }
            if (z) {
                if (AnimatorSet.this.mListeners != null) {
                    ArrayList arrayList2 = (ArrayList) AnimatorSet.this.mListeners.clone();
                    int size2 = arrayList2.size();
                    int i3 = 0;
                    while (true) {
                        int i4 = i3;
                        if (i4 >= size2) {
                            break;
                        }
                        ((Animator.AnimatorListener) arrayList2.get(i4)).onAnimationEnd(this.mAnimatorSet);
                        i3 = i4 + 1;
                    }
                }
                this.mAnimatorSet.mStarted = false;
                this.mAnimatorSet.mPaused = false;
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/animation/AnimatorSet$Builder.class */
    public class Builder {
        private Node mCurrentNode;

        Builder(Animator animator) {
            this.mCurrentNode = (Node) AnimatorSet.this.mNodeMap.get(animator);
            if (this.mCurrentNode == null) {
                this.mCurrentNode = new Node(animator);
                AnimatorSet.this.mNodeMap.put(animator, this.mCurrentNode);
                AnimatorSet.this.mNodes.add(this.mCurrentNode);
            }
        }

        public Builder after(long j) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat.setDuration(j);
            after(ofFloat);
            return this;
        }

        public Builder after(Animator animator) {
            AnimatorSet.this.mReversible = false;
            Node node = (Node) AnimatorSet.this.mNodeMap.get(animator);
            Node node2 = node;
            if (node == null) {
                node2 = new Node(animator);
                AnimatorSet.this.mNodeMap.put(animator, node2);
                AnimatorSet.this.mNodes.add(node2);
            }
            this.mCurrentNode.addDependency(new Dependency(node2, 1));
            return this;
        }

        public Builder before(Animator animator) {
            AnimatorSet.this.mReversible = false;
            Node node = (Node) AnimatorSet.this.mNodeMap.get(animator);
            Node node2 = node;
            if (node == null) {
                node2 = new Node(animator);
                AnimatorSet.this.mNodeMap.put(animator, node2);
                AnimatorSet.this.mNodes.add(node2);
            }
            node2.addDependency(new Dependency(this.mCurrentNode, 1));
            return this;
        }

        public Builder with(Animator animator) {
            Node node = (Node) AnimatorSet.this.mNodeMap.get(animator);
            Node node2 = node;
            if (node == null) {
                node2 = new Node(animator);
                AnimatorSet.this.mNodeMap.put(animator, node2);
                AnimatorSet.this.mNodes.add(node2);
            }
            node2.addDependency(new Dependency(this.mCurrentNode, 0));
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/animation/AnimatorSet$Dependency.class */
    public static class Dependency {
        static final int AFTER = 1;
        static final int WITH = 0;
        public Node node;
        public int rule;

        public Dependency(Node node, int i) {
            this.node = node;
            this.rule = i;
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/animation/AnimatorSet$DependencyListener.class */
    private static class DependencyListener implements Animator.AnimatorListener {
        private AnimatorSet mAnimatorSet;
        private Node mNode;
        private int mRule;

        public DependencyListener(AnimatorSet animatorSet, Node node, int i) {
            this.mAnimatorSet = animatorSet;
            this.mNode = node;
            this.mRule = i;
        }

        private void startIfReady(Animator animator) {
            Dependency dependency;
            if (this.mAnimatorSet.mTerminated) {
                return;
            }
            int size = this.mNode.tmpDependencies.size();
            int i = 0;
            while (true) {
                int i2 = i;
                dependency = null;
                if (i2 >= size) {
                    break;
                }
                dependency = this.mNode.tmpDependencies.get(i2);
                if (dependency.rule == this.mRule && dependency.node.animation == animator) {
                    animator.removeListener(this);
                    break;
                }
                i = i2 + 1;
            }
            this.mNode.tmpDependencies.remove(dependency);
            if (this.mNode.tmpDependencies.size() == 0) {
                this.mNode.animation.start();
                this.mAnimatorSet.mPlayingSet.add(this.mNode.animation);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.mRule == 1) {
                startIfReady(animator);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (this.mRule == 0) {
                startIfReady(animator);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/animation/AnimatorSet$Node.class */
    public static class Node implements Cloneable {
        public Animator animation;
        public ArrayList<Dependency> dependencies = null;
        public ArrayList<Dependency> tmpDependencies = null;
        public ArrayList<Node> nodeDependencies = null;
        public ArrayList<Node> nodeDependents = null;
        public boolean done = false;
        private Node mTmpClone = null;

        public Node(Animator animator) {
            this.animation = animator;
        }

        public void addDependency(Dependency dependency) {
            if (this.dependencies == null) {
                this.dependencies = new ArrayList<>();
                this.nodeDependencies = new ArrayList<>();
            }
            this.dependencies.add(dependency);
            if (!this.nodeDependencies.contains(dependency.node)) {
                this.nodeDependencies.add(dependency.node);
            }
            Node node = dependency.node;
            if (node.nodeDependents == null) {
                node.nodeDependents = new ArrayList<>();
            }
            node.nodeDependents.add(this);
        }

        /* renamed from: clone */
        public Node m55clone() {
            try {
                Node node = (Node) super.clone();
                node.animation = this.animation.mo53clone();
                return node;
            } catch (CloneNotSupportedException e) {
                throw new AssertionError();
            }
        }
    }

    private void sortNodes() {
        if (this.mNeedsSort) {
            this.mSortedNodes.clear();
            ArrayList arrayList = new ArrayList();
            int size = this.mNodes.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    break;
                }
                Node node = this.mNodes.get(i2);
                if (node.dependencies == null || node.dependencies.size() == 0) {
                    arrayList.add(node);
                }
                i = i2 + 1;
            }
            ArrayList arrayList2 = new ArrayList();
            while (arrayList.size() > 0) {
                int size2 = arrayList.size();
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 < size2) {
                        Node node2 = (Node) arrayList.get(i4);
                        this.mSortedNodes.add(node2);
                        if (node2.nodeDependents != null) {
                            int size3 = node2.nodeDependents.size();
                            int i5 = 0;
                            while (true) {
                                int i6 = i5;
                                if (i6 < size3) {
                                    Node node3 = node2.nodeDependents.get(i6);
                                    node3.nodeDependencies.remove(node2);
                                    if (node3.nodeDependencies.size() == 0) {
                                        arrayList2.add(node3);
                                    }
                                    i5 = i6 + 1;
                                }
                            }
                        }
                        i3 = i4 + 1;
                    }
                }
                arrayList.clear();
                arrayList.addAll(arrayList2);
                arrayList2.clear();
            }
            this.mNeedsSort = false;
            if (this.mSortedNodes.size() != this.mNodes.size()) {
                throw new IllegalStateException("Circular dependencies cannot exist in AnimatorSet");
            }
            return;
        }
        int size4 = this.mNodes.size();
        int i7 = 0;
        while (true) {
            int i8 = i7;
            if (i8 >= size4) {
                return;
            }
            Node node4 = this.mNodes.get(i8);
            if (node4.dependencies != null && node4.dependencies.size() > 0) {
                int size5 = node4.dependencies.size();
                int i9 = 0;
                while (true) {
                    int i10 = i9;
                    if (i10 < size5) {
                        Dependency dependency = node4.dependencies.get(i10);
                        if (node4.nodeDependencies == null) {
                            node4.nodeDependencies = new ArrayList<>();
                        }
                        if (!node4.nodeDependencies.contains(dependency.node)) {
                            node4.nodeDependencies.add(dependency.node);
                        }
                        i9 = i10 + 1;
                    }
                }
            }
            node4.done = false;
            i7 = i8 + 1;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x001a  */
    @Override // android.animation.Animator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean canReverse() {
        /*
            r5 = this;
            r0 = r5
            boolean r0 = r0.mReversible
            if (r0 != 0) goto L9
        L7:
            r0 = 0
            return r0
        L9:
            r0 = r5
            java.util.ArrayList<android.animation.AnimatorSet$Node> r0 = r0.mNodes
            java.util.Iterator r0 = r0.iterator()
            r6 = r0
        L11:
            r0 = r6
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L3c
            r0 = r6
            java.lang.Object r0 = r0.next()
            android.animation.AnimatorSet$Node r0 = (android.animation.AnimatorSet.Node) r0
            r7 = r0
            r0 = r7
            android.animation.Animator r0 = r0.animation
            boolean r0 = r0.canReverse()
            if (r0 == 0) goto L7
            r0 = r7
            android.animation.Animator r0 = r0.animation
            long r0 = r0.getStartDelay()
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L11
            r0 = 0
            return r0
        L3c:
            r0 = 1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.animation.AnimatorSet.canReverse():boolean");
    }

    @Override // android.animation.Animator
    public void cancel() {
        this.mTerminated = true;
        if (isStarted()) {
            ArrayList arrayList = null;
            if (this.mListeners != null) {
                ArrayList arrayList2 = (ArrayList) this.mListeners.clone();
                Iterator it = arrayList2.iterator();
                while (true) {
                    arrayList = arrayList2;
                    if (!it.hasNext()) {
                        break;
                    }
                    ((Animator.AnimatorListener) it.next()).onAnimationCancel(this);
                }
            }
            if (this.mDelayAnim != null && this.mDelayAnim.isRunning()) {
                this.mDelayAnim.cancel();
            } else if (this.mSortedNodes.size() > 0) {
                Iterator<Node> it2 = this.mSortedNodes.iterator();
                while (it2.hasNext()) {
                    it2.next().animation.cancel();
                }
            }
            if (arrayList != null) {
                Iterator it3 = arrayList.iterator();
                while (it3.hasNext()) {
                    ((Animator.AnimatorListener) it3.next()).onAnimationEnd(this);
                }
            }
            this.mStarted = false;
        }
    }

    @Override // android.animation.Animator
    /* renamed from: clone */
    public AnimatorSet mo53clone() {
        AnimatorSet animatorSet = (AnimatorSet) super.mo53clone();
        int size = this.mNodes.size();
        animatorSet.mNeedsSort = true;
        animatorSet.mTerminated = false;
        animatorSet.mStarted = false;
        animatorSet.mPlayingSet = new ArrayList<>();
        animatorSet.mNodeMap = new HashMap<>();
        animatorSet.mNodes = new ArrayList<>(size);
        animatorSet.mSortedNodes = new ArrayList<>(size);
        animatorSet.mReversible = this.mReversible;
        animatorSet.mSetListener = null;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                break;
            }
            Node node = this.mNodes.get(i2);
            Node m55clone = node.m55clone();
            node.mTmpClone = m55clone;
            animatorSet.mNodes.add(m55clone);
            animatorSet.mNodeMap.put(m55clone.animation, m55clone);
            m55clone.dependencies = null;
            m55clone.tmpDependencies = null;
            m55clone.nodeDependents = null;
            m55clone.nodeDependencies = null;
            ArrayList<Animator.AnimatorListener> listeners = m55clone.animation.getListeners();
            if (listeners != null) {
                int size2 = listeners.size();
                while (true) {
                    int i3 = size2 - 1;
                    if (i3 >= 0) {
                        if (listeners.get(i3) instanceof AnimatorSetListener) {
                            listeners.remove(i3);
                        }
                        size2 = i3;
                    }
                }
            }
            i = i2 + 1;
        }
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= size) {
                break;
            }
            Node node2 = this.mNodes.get(i5);
            Node node3 = node2.mTmpClone;
            if (node2.dependencies != null) {
                node3.dependencies = new ArrayList<>(node2.dependencies.size());
                int size3 = node2.dependencies.size();
                int i6 = 0;
                while (true) {
                    int i7 = i6;
                    if (i7 >= size3) {
                        break;
                    }
                    Dependency dependency = node2.dependencies.get(i7);
                    node3.dependencies.add(new Dependency(dependency.node.mTmpClone, dependency.rule));
                    i6 = i7 + 1;
                }
            }
            if (node2.nodeDependents != null) {
                node3.nodeDependents = new ArrayList<>(node2.nodeDependents.size());
                Iterator<Node> it = node2.nodeDependents.iterator();
                while (it.hasNext()) {
                    node3.nodeDependents.add(it.next().mTmpClone);
                }
            }
            if (node2.nodeDependencies != null) {
                node3.nodeDependencies = new ArrayList<>(node2.nodeDependencies.size());
                Iterator<Node> it2 = node2.nodeDependencies.iterator();
                while (it2.hasNext()) {
                    node3.nodeDependencies.add(it2.next().mTmpClone);
                }
            }
            i4 = i5 + 1;
        }
        int i8 = 0;
        while (true) {
            int i9 = i8;
            if (i9 >= size) {
                return animatorSet;
            }
            this.mNodes.get(i9).mTmpClone = null;
            i8 = i9 + 1;
        }
    }

    @Override // android.animation.Animator
    public void end() {
        this.mTerminated = true;
        if (isStarted()) {
            if (this.mSortedNodes.size() != this.mNodes.size()) {
                sortNodes();
                Iterator<Node> it = this.mSortedNodes.iterator();
                while (it.hasNext()) {
                    Node next = it.next();
                    if (this.mSetListener == null) {
                        this.mSetListener = new AnimatorSetListener(this);
                    }
                    next.animation.addListener(this.mSetListener);
                }
            }
            if (this.mDelayAnim != null) {
                this.mDelayAnim.cancel();
            }
            if (this.mSortedNodes.size() > 0) {
                Iterator<Node> it2 = this.mSortedNodes.iterator();
                while (it2.hasNext()) {
                    it2.next().animation.end();
                }
            }
            if (this.mListeners != null) {
                Iterator it3 = ((ArrayList) this.mListeners.clone()).iterator();
                while (it3.hasNext()) {
                    ((Animator.AnimatorListener) it3.next()).onAnimationEnd(this);
                }
            }
            this.mStarted = false;
        }
    }

    @Override // android.animation.Animator
    public int getChangingConfigurations() {
        int changingConfigurations = super.getChangingConfigurations();
        int size = this.mNodes.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return changingConfigurations;
            }
            changingConfigurations |= this.mNodes.get(i2).animation.getChangingConfigurations();
            i = i2 + 1;
        }
    }

    public ArrayList<Animator> getChildAnimations() {
        ArrayList<Animator> arrayList = new ArrayList<>();
        Iterator<Node> it = this.mNodes.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().animation);
        }
        return arrayList;
    }

    @Override // android.animation.Animator
    public long getDuration() {
        return this.mDuration;
    }

    @Override // android.animation.Animator
    public TimeInterpolator getInterpolator() {
        return this.mInterpolator;
    }

    @Override // android.animation.Animator
    public long getStartDelay() {
        return this.mStartDelay;
    }

    @Override // android.animation.Animator
    public boolean isRunning() {
        Iterator<Node> it = this.mNodes.iterator();
        while (it.hasNext()) {
            if (it.next().animation.isRunning()) {
                return true;
            }
        }
        return false;
    }

    @Override // android.animation.Animator
    public boolean isStarted() {
        return this.mStarted;
    }

    @Override // android.animation.Animator
    public void pause() {
        boolean z = this.mPaused;
        super.pause();
        if (z || !this.mPaused) {
            return;
        }
        if (this.mDelayAnim != null) {
            this.mDelayAnim.pause();
            return;
        }
        Iterator<Node> it = this.mNodes.iterator();
        while (it.hasNext()) {
            it.next().animation.pause();
        }
    }

    public Builder play(Animator animator) {
        if (animator != null) {
            this.mNeedsSort = true;
            return new Builder(animator);
        }
        return null;
    }

    public void playSequentially(List<Animator> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.mNeedsSort = true;
        if (list.size() == 1) {
            play(list.get(0));
            return;
        }
        this.mReversible = false;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size() - 1) {
                return;
            }
            play(list.get(i2)).before(list.get(i2 + 1));
            i = i2 + 1;
        }
    }

    public void playSequentially(Animator... animatorArr) {
        if (animatorArr == null) {
            return;
        }
        this.mNeedsSort = true;
        if (animatorArr.length == 1) {
            play(animatorArr[0]);
            return;
        }
        this.mReversible = false;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= animatorArr.length - 1) {
                return;
            }
            play(animatorArr[i2]).before(animatorArr[i2 + 1]);
            i = i2 + 1;
        }
    }

    public void playTogether(Collection<Animator> collection) {
        if (collection == null || collection.size() <= 0) {
            return;
        }
        this.mNeedsSort = true;
        Builder builder = null;
        for (Animator animator : collection) {
            if (builder == null) {
                builder = play(animator);
            } else {
                builder.with(animator);
            }
        }
    }

    public void playTogether(Animator... animatorArr) {
        if (animatorArr == null) {
            return;
        }
        this.mNeedsSort = true;
        Builder play = play(animatorArr[0]);
        int i = 1;
        while (true) {
            int i2 = i;
            if (i2 >= animatorArr.length) {
                return;
            }
            play.with(animatorArr[i2]);
            i = i2 + 1;
        }
    }

    @Override // android.animation.Animator
    public void resume() {
        boolean z = this.mPaused;
        super.resume();
        if (!z || this.mPaused) {
            return;
        }
        if (this.mDelayAnim != null) {
            this.mDelayAnim.resume();
            return;
        }
        Iterator<Node> it = this.mNodes.iterator();
        while (it.hasNext()) {
            it.next().animation.resume();
        }
    }

    @Override // android.animation.Animator
    public void reverse() {
        if (canReverse()) {
            Iterator<Node> it = this.mNodes.iterator();
            while (it.hasNext()) {
                it.next().animation.reverse();
            }
        }
    }

    @Override // android.animation.Animator
    public AnimatorSet setDuration(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("duration must be a value of zero or greater");
        }
        this.mDuration = j;
        return this;
    }

    @Override // android.animation.Animator
    public void setInterpolator(TimeInterpolator timeInterpolator) {
        this.mInterpolator = timeInterpolator;
    }

    @Override // android.animation.Animator
    public void setStartDelay(long j) {
        if (this.mStartDelay > 0) {
            this.mReversible = false;
        }
        this.mStartDelay = j;
    }

    @Override // android.animation.Animator
    public void setTarget(Object obj) {
        Iterator<Node> it = this.mNodes.iterator();
        while (it.hasNext()) {
            Animator animator = it.next().animation;
            if (animator instanceof AnimatorSet) {
                ((AnimatorSet) animator).setTarget(obj);
            } else if (animator instanceof ObjectAnimator) {
                ((ObjectAnimator) animator).setTarget(obj);
            }
        }
    }

    @Override // android.animation.Animator
    public void setupEndValues() {
        Iterator<Node> it = this.mNodes.iterator();
        while (it.hasNext()) {
            it.next().animation.setupEndValues();
        }
    }

    @Override // android.animation.Animator
    public void setupStartValues() {
        Iterator<Node> it = this.mNodes.iterator();
        while (it.hasNext()) {
            it.next().animation.setupStartValues();
        }
    }

    @Override // android.animation.Animator
    public void start() {
        this.mTerminated = false;
        this.mStarted = true;
        this.mPaused = false;
        Iterator<Node> it = this.mNodes.iterator();
        while (it.hasNext()) {
            it.next().animation.setAllowRunningAsynchronously(false);
        }
        if (this.mDuration >= 0) {
            Iterator<Node> it2 = this.mNodes.iterator();
            while (it2.hasNext()) {
                it2.next().animation.setDuration(this.mDuration);
            }
        }
        if (this.mInterpolator != null) {
            Iterator<Node> it3 = this.mNodes.iterator();
            while (it3.hasNext()) {
                it3.next().animation.setInterpolator(this.mInterpolator);
            }
        }
        sortNodes();
        int size = this.mSortedNodes.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                break;
            }
            Node node = this.mSortedNodes.get(i2);
            ArrayList<Animator.AnimatorListener> listeners = node.animation.getListeners();
            if (listeners != null && listeners.size() > 0) {
                Iterator it4 = new ArrayList(listeners).iterator();
                while (it4.hasNext()) {
                    Animator.AnimatorListener animatorListener = (Animator.AnimatorListener) it4.next();
                    if ((animatorListener instanceof DependencyListener) || (animatorListener instanceof AnimatorSetListener)) {
                        node.animation.removeListener(animatorListener);
                    }
                }
            }
            i = i2 + 1;
        }
        final ArrayList arrayList = new ArrayList();
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= size) {
                break;
            }
            Node node2 = this.mSortedNodes.get(i4);
            if (this.mSetListener == null) {
                this.mSetListener = new AnimatorSetListener(this);
            }
            if (node2.dependencies == null || node2.dependencies.size() == 0) {
                arrayList.add(node2);
            } else {
                int size2 = node2.dependencies.size();
                int i5 = 0;
                while (true) {
                    int i6 = i5;
                    if (i6 >= size2) {
                        break;
                    }
                    Dependency dependency = node2.dependencies.get(i6);
                    dependency.node.animation.addListener(new DependencyListener(this, node2, dependency.rule));
                    i5 = i6 + 1;
                }
                node2.tmpDependencies = (ArrayList) node2.dependencies.clone();
            }
            node2.animation.addListener(this.mSetListener);
            i3 = i4 + 1;
        }
        if (this.mStartDelay <= 0) {
            Iterator it5 = arrayList.iterator();
            while (it5.hasNext()) {
                Node node3 = (Node) it5.next();
                node3.animation.start();
                this.mPlayingSet.add(node3.animation);
            }
        } else {
            this.mDelayAnim = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.mDelayAnim.setDuration(this.mStartDelay);
            this.mDelayAnim.addListener(new AnimatorListenerAdapter() { // from class: android.animation.AnimatorSet.1
                boolean canceled = false;

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    this.canceled = true;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.canceled) {
                        int size3 = arrayList.size();
                        int i7 = 0;
                        while (true) {
                            int i8 = i7;
                            if (i8 >= size3) {
                                break;
                            }
                            Node node4 = (Node) arrayList.get(i8);
                            node4.animation.start();
                            AnimatorSet.this.mPlayingSet.add(node4.animation);
                            i7 = i8 + 1;
                        }
                    }
                    AnimatorSet.this.mDelayAnim = null;
                }
            });
            this.mDelayAnim.start();
        }
        if (this.mListeners != null) {
            ArrayList arrayList2 = (ArrayList) this.mListeners.clone();
            int size3 = arrayList2.size();
            int i7 = 0;
            while (true) {
                int i8 = i7;
                if (i8 >= size3) {
                    break;
                }
                ((Animator.AnimatorListener) arrayList2.get(i8)).onAnimationStart(this);
                i7 = i8 + 1;
            }
        }
        if (this.mNodes.size() != 0 || this.mStartDelay != 0) {
            return;
        }
        this.mStarted = false;
        if (this.mListeners == null) {
            return;
        }
        ArrayList arrayList3 = (ArrayList) this.mListeners.clone();
        int size4 = arrayList3.size();
        int i9 = 0;
        while (true) {
            int i10 = i9;
            if (i10 >= size4) {
                return;
            }
            ((Animator.AnimatorListener) arrayList3.get(i10)).onAnimationEnd(this);
            i9 = i10 + 1;
        }
    }
}
