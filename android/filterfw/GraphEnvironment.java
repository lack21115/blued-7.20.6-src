package android.filterfw;

import android.content.Context;
import android.filterfw.core.AsyncRunner;
import android.filterfw.core.FilterContext;
import android.filterfw.core.FilterGraph;
import android.filterfw.core.FrameManager;
import android.filterfw.core.GraphRunner;
import android.filterfw.core.RoundRobinScheduler;
import android.filterfw.core.SyncRunner;
import android.filterfw.io.GraphIOException;
import android.filterfw.io.GraphReader;
import android.filterfw.io.TextGraphReader;
import java.util.ArrayList;

/* loaded from: source-9557208-dex2jar.jar:android/filterfw/GraphEnvironment.class */
public class GraphEnvironment extends MffEnvironment {
    public static final int MODE_ASYNCHRONOUS = 1;
    public static final int MODE_SYNCHRONOUS = 2;
    private GraphReader mGraphReader;
    private ArrayList<GraphHandle> mGraphs;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/filterfw/GraphEnvironment$GraphHandle.class */
    public class GraphHandle {
        private AsyncRunner mAsyncRunner;
        private FilterGraph mGraph;
        private SyncRunner mSyncRunner;

        public GraphHandle(FilterGraph filterGraph) {
            this.mGraph = filterGraph;
        }

        public AsyncRunner getAsyncRunner(FilterContext filterContext) {
            if (this.mAsyncRunner == null) {
                this.mAsyncRunner = new AsyncRunner(filterContext, RoundRobinScheduler.class);
                this.mAsyncRunner.setGraph(this.mGraph);
            }
            return this.mAsyncRunner;
        }

        public FilterGraph getGraph() {
            return this.mGraph;
        }

        public GraphRunner getSyncRunner(FilterContext filterContext) {
            if (this.mSyncRunner == null) {
                this.mSyncRunner = new SyncRunner(filterContext, this.mGraph, RoundRobinScheduler.class);
            }
            return this.mSyncRunner;
        }
    }

    public GraphEnvironment() {
        super(null);
        this.mGraphs = new ArrayList<>();
    }

    public GraphEnvironment(FrameManager frameManager, GraphReader graphReader) {
        super(frameManager);
        this.mGraphs = new ArrayList<>();
        this.mGraphReader = graphReader;
    }

    public int addGraph(FilterGraph filterGraph) {
        this.mGraphs.add(new GraphHandle(filterGraph));
        return this.mGraphs.size() - 1;
    }

    public void addReferences(Object... objArr) {
        getGraphReader().addReferencesByKeysAndValues(objArr);
    }

    public FilterGraph getGraph(int i) {
        if (i < 0 || i >= this.mGraphs.size()) {
            throw new IllegalArgumentException("Invalid graph ID " + i + " specified in runGraph()!");
        }
        return this.mGraphs.get(i).getGraph();
    }

    public GraphReader getGraphReader() {
        if (this.mGraphReader == null) {
            this.mGraphReader = new TextGraphReader();
        }
        return this.mGraphReader;
    }

    public GraphRunner getRunner(int i, int i2) {
        switch (i2) {
            case 1:
                return this.mGraphs.get(i).getAsyncRunner(getContext());
            case 2:
                return this.mGraphs.get(i).getSyncRunner(getContext());
            default:
                throw new RuntimeException("Invalid execution mode " + i2 + " specified in getRunner()!");
        }
    }

    public int loadGraph(Context context, int i) {
        try {
            return addGraph(getGraphReader().readGraphResource(context, i));
        } catch (GraphIOException e) {
            throw new RuntimeException("Could not read graph: " + e.getMessage());
        }
    }
}
