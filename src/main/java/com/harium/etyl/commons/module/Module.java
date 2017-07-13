package com.harium.etyl.commons.module;

import com.harium.etyl.commons.Drawable;
import com.harium.etyl.commons.Updatable;
import com.harium.etyl.commons.context.Context;
import com.harium.etyl.commons.event.GUIEvent;
import com.harium.etyl.commons.event.KeyEvent;
import com.harium.etyl.commons.event.PointerEvent;

public interface Module extends Drawable, Updatable {

    /**
     * Update pointer events
     *
     * @param event
     */
    void updateMouse(PointerEvent event);

    /**
     * Update keyboard events
     *
     * @param event
     */
    void updateKeyboard(KeyEvent event);

    void updateGuiEvent(GUIEvent event);

    /**
     * Handles the context
     *
     * @param context
     */
    void init(Context context);

    void dispose(Context context);

}
