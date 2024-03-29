package com.harium.etyl.commons.context.load;

import com.harium.etyl.commons.context.Context;

import java.util.concurrent.*;

public class ApplicationLoader {

    private Loader loader = new Loader();
    private Updater updater = new Updater();

    private Context application;
    private LoaderListener listener;
    private DefaultLoadApplication loadApplication;

    private boolean called = false;
    private boolean finished = false;
    private ScheduledExecutorService loadExecutor;
    protected Future<?> future;

    private static final int UPDATE_INTERVAL = 50;

    private String lastText = "";
    private float lastLoading = 0;

    public ApplicationLoader(int w, int h) {
        super();

        loadApplication = new GenericLoadApplication(0, 0, w, h);
        loadApplication.load();
    }

    public void loadApplication() {
        lastText = "";
        lastLoading = 0;

        loadExecutor = Executors.newScheduledThreadPool(2);

        future = loadExecutor.submit(loader);
        loadExecutor.scheduleAtFixedRate(updater, UPDATE_INTERVAL, UPDATE_INTERVAL, TimeUnit.MILLISECONDS);
    }

    private class Loader implements Runnable {
        public void run() {
            finished = false;
            called = false;
            application.startLoad();
            called = true;
        }
    }

    private class Updater implements Runnable {
        public void run() {
            if (!called) {
                if (!application.isLoaded()) {
                    notifyTextChanged();
                    notifyLoadingChanged();

                    getError();
                }
            } else if (!finished) {
                // Notify the Listener
                finishLoading();
                finished = true;
                loadExecutor.shutdown();
            }
        }
    }

    private void notifyTextChanged() {
        String info = application.getLoadingInfo();

        if (!lastText.equals(info)) {
            lastText = info;
            loadApplication.onChangeText(info);
        }
    }

    private void notifyLoadingChanged() {
        float loading = application.getLoading();

        if (lastLoading != loading) {
            lastLoading = loading;
            loadApplication.onChangeLoad(loading);
        }
    }

    protected void getError() {
        try {
            future.get(UPDATE_INTERVAL / 2, TimeUnit.MILLISECONDS);
        } catch (ExecutionException e) {
            Throwable cause = e.getCause();
            cause.printStackTrace();
            finishLoading();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            //Ignore the Timeout Exception
            //e.printStackTrace();
        }
    }

    private void finishLoading() {
        listener.onLoad(application);
    }

    private void checkForCustomLoadApplication(Context context) {
        DefaultLoadApplication loadApp = context.getLoadApplication();

        if (loadApp != null) {
            this.loadApplication = loadApp;
        }
    }

    public DefaultLoadApplication reloadApplication(LoaderListener listener, Context context) {
        context.setLoaded(false);
        checkForCustomLoadApplication(context);

        this.listener = listener;
        this.application = context;

        loadApplication.load();
        loadApplication.setLoaded(true);
        loadApplication();
        return loadApplication;
    }

}