package com.javarush.task.task32.task3209.listeners;

import com.javarush.task.task32.task3209.View;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

public class UndoMenuListener implements MenuListener {
    private View view;
    private JMenuItem undoMenuItem;
    private JMenuItem redoMenuItem;

    public UndoMenuListener(View view, JMenuItem undoItem, JMenuItem redoItem) {
        this.view = view;
        this.undoMenuItem = undoItem;
        this.redoMenuItem = redoItem;
    }

    @Override
    public void menuSelected(MenuEvent e) {
        boolean b = view.canUndo();
        undoMenuItem.setEnabled(b);
        boolean c = view.canRedo();
        redoMenuItem.setEnabled(c);
    }

    @Override
    public void menuDeselected(MenuEvent e) {

    }

    @Override
    public void menuCanceled(MenuEvent e) {

    }
}
