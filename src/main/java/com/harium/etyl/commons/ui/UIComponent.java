package com.harium.etyl.commons.ui;


import com.harium.etyl.commons.Drawable;
import com.harium.etyl.commons.Updatable;
import com.harium.etyl.commons.event.KeyEvent;
import com.harium.etyl.commons.event.PointerEvent;

public interface UIComponent extends Drawable, Updatable {

    void updateMouse(PointerEvent event);

    void updateKeyboard(KeyEvent event);

}
