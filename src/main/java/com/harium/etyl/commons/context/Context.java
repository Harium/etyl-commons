package com.harium.etyl.commons.context;

import com.harium.etyl.commons.Updatable;
import com.harium.etyl.commons.context.load.ApplicationLoadListener;
import com.harium.etyl.commons.context.load.DefaultLoadApplication;
import com.harium.etyl.commons.dnd.DropTarget;
import com.harium.etyl.commons.event.GUIEvent;
import com.harium.etyl.commons.layer.Layer;
import com.harium.etyl.commons.ui.UIComponent;
import com.harium.etyl.commons.ui.UIResizableComponent;
import com.harium.etyl.commons.graphics.Graphics;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Class to represent sessions of the Main Application like Mini-Applications.
 *
 */

public abstract class Context extends Layer implements UIResizableComponent, Updatable, DropTarget {

    private static final ApplicationLoadListener DUMMY_LOAD_LISTENER = new ApplicationLoadListener() {
        @Override
        public void onApplicationLoaded() {
        }
    };

    /**
     * The updateInterval between executions
     */
    private int updateInterval = 0;

    /**
     * Listener to be updated
     */
    private UpdateIntervalListener updated = null;

    /**
     * Load percentage unlock Application when reaches 100
     */
    protected float loading = 0;

    /**
     * Loading phrase while loading Application
     */
    protected String loadingInfo = "Loading...";

    /**
     * Application title (useful with windows)
     */
    protected String title = "Application";

    /**
     * Clear application before every draw call
     */
    protected boolean clearBeforeDraw = true;

    /**
     * Map shared between Applications
     */
    protected Session session;

    /**
     * Last time updated
     */

    protected long lastUpdate = 0;

    /**
     * Lock on update
     */
    private boolean locked = false;

    /**
     * Lock on load
     * Start as true
     */
    private boolean loaded = true;

    /**
     * Pause
     */
    protected boolean paused = false;

    /**
     * Active Center Mouse
     */
    protected boolean activeCenterMouse = false;

    /**
     * Application to be shown during loading
     */
    private ApplicationLoadListener loadListener = DUMMY_LOAD_LISTENER;

    /**
     * Returned Application (next Application to show up)
     */
    protected Context nextApplication = this;

    protected DefaultLoadApplication loadApplication;

    /**
     * Background color, white = -1
     */
    protected int backgroundColor = -1;

    private boolean drawCursor = true;

    protected List<UIComponent> components = new ArrayList<UIComponent>();
    protected boolean showingAd;

    /**
     * Constructor
     *
     * @param x coordinate to show Application (useful with multiple Applications)
     * @param y coordinate to show Application (useful with multiple Applications)
     * @param w Application width
     * @param h Application height
     */
    public Context(int x, int y, int w, int h) {
        super(x, y, w, h);

        this.loading = 0;
        //TODO Dictionary get "loading"+...
        this.loadingInfo = "Carregando...";
    }

    /**
     * Constructor for "fit Window" Applications
     *
     * @param w Application width
     * @param h Application height
     */
    public Context(int w, int h) {
        this(0, 0, w, h);
    }

    public void startLoad() {
        locked = true;
        this.loading = 0;
        load();
        locked = false;
        notifyListeners();
    }

    private void notifyListeners() {
        loadListener.onApplicationLoaded();
    }

    /**
     * Load method is the first method called before constructor.
     * Application gets lock while load() and unlocks when loading = 100;
     */
    public abstract void load();

    /**
     * Draw method
     */
    public abstract void draw(Graphics g);

    /**
     * Method to setup Graphics before the first draw call
     */
    public void initGraphics(Graphics g) {

    }

    /**
     * Method called when activity will be closed, useful to  dispose loaded resources
     */
    public void dispose() {

    }

    /**
     * Method to Update by GUI events
     */
    public void update(GUIEvent event) {
        // TODO Auto-generated method stub
    }

    public void update(long now) {
    }

    public float getLoading() {
        return loading;
    }

    public String getLoadingInfo() {
        return loadingInfo;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public Session getSession() {
        return session;
    }

    public void setSessionValue(String key, Object value) {
        session.put(key, value);
    }

    public Object getSessionValue(String key) {
        return session.get(key);
    }

    public boolean isClearBeforeDraw() {
        return clearBeforeDraw;
    }

    public void setClearBeforeDraw(boolean clearBeforeDraw) {
        this.clearBeforeDraw = clearBeforeDraw;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    protected void updateAtFixedRate(int interval, UpdateIntervalListener updated) {
        updateInterval = interval;
        this.updated = updated;
    }

    protected void stopTimeUpdate() {
        updateInterval = 0;
    }

    public int getUpdateInterval() {
        return updateInterval;
    }

    public long getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(long lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLoadListener(ApplicationLoadListener listener) {
        this.loadListener = listener;
    }

    public Context getNextApplication() {
        return nextApplication;
    }

    protected void setNextApplication(Context nextApplication) {
        this.nextApplication = nextApplication;
    }

    public DefaultLoadApplication getLoadApplication() {
        return loadApplication;
    }

    public UpdateIntervalListener getUpdated() {
        return updated;
    }

    public boolean isDrawCursor() {
        return drawCursor;
    }

    public void setDrawCursor(boolean drawCursor) {
        this.drawCursor = drawCursor;
    }

    public void hideCursor() {
        this.drawCursor = false;
    }

    public void showCursor() {
        this.drawCursor = true;
    }

    public boolean isActiveCenterMouse() {
        return activeCenterMouse;
    }

    public boolean isLoaded() {
        return loaded;
    }

    public void setLoaded(boolean loaded) {
        this.loaded = loaded;
    }

    public int getBackgroundColor() {
        return backgroundColor;
    }

    public void dragEnter() {

    }

    public void dragExit() {

    }

    public void dropFiles(int x, int y, List<File> files) {

    }

    public List<UIComponent> getComponents() {
        return components;
    }

    public boolean isShowingAd() {
        return showingAd;
    }

    public void setShowingAd(boolean showingAd) {
        this.showingAd = showingAd;
    }

}
