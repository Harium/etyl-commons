package com.harium.etyl.commons.context.load;

import com.harium.etyl.commons.context.Application;


public abstract class DefaultLoadApplication extends Application implements LoadApplication {

    protected String phrase = "Loading...";

    protected String percent = "0%";

    public DefaultLoadApplication(int w, int h) {
        super(w, h);
    }

    public DefaultLoadApplication(int x, int y, int w, int h) {
        super(x, y, w, h);
    }

}