package com.harium.etyl.commons.context.load;

import com.harium.etyl.commons.context.Application;
import com.harium.etyl.commons.graphics.Graphics;
import org.junit.Assert;
import org.junit.Test;

public class ApplicationLoaderTest {

    private int w = 0, h = 0;

    @Test
    public void testLoading() {
        FakeLoaderListener listener = new FakeLoaderListener();

        ApplicationLoader loader = new ApplicationLoader(w, h);
        loader.reloadApplication(listener, new FakeApplication());
        loader.loadApplication();

        waitSeconds(1);
        Assert.assertEquals(1, listener.getCount());
    }

    private void waitSeconds(int seconds) {
        int i = 0;
        while (i < seconds) {
            i++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private class FakeApplication extends Application {

        public FakeApplication() {
            super(0, 0);
        }

        @Override
        public void load() {

        }

        @Override
        public void draw(Graphics g) {

        }
    }

    private class FakeLoaderListener implements LoaderListener {
        int count = 0;

        @Override
        public void onLoad(Object context) {
            count++;
        }

        public void reset() {
            count = 0;
        }

        public int getCount() {
            return count;
        }
    };

}
