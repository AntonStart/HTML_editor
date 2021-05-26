package com.javarush.task.task32.task3209;

import javax.swing.*;
import java.awt.event.ActionListener;
/*
статический метод ,
где parent - меню в которое мы добавляем пункт,
text - текст добавляемого пункта,
actionListener - слушатель действий добавляемого пункта меню.
 */
public class MenuHelper {
    public static JMenuItem addMenuItem(JMenu parent, String text, ActionListener actionListener) {
        JMenuItem jMenuItemText = new JMenuItem(text);
        jMenuItemText.addActionListener(actionListener);
        parent.add(jMenuItemText);
        return jMenuItemText;
    }

    public static JMenuItem addMenuItem(JMenu parent, Action action) {
        JMenuItem jMenuItemAction = new JMenuItem(action);
        parent.add(jMenuItemAction);
        return jMenuItemAction;
    }

    public static JMenuItem addMenuItem(JMenu parent, String text, Action action) {
        JMenuItem jMenuItemActionText = addMenuItem(parent, action);
        jMenuItemActionText.setText(text);
        parent.add(jMenuItemActionText);
        return jMenuItemActionText;
    }

    public static void initHelpMenu(View view, JMenuBar menuBar) {}
    public static void initFontMenu(View view, JMenuBar menuBar) {}
    public static void initColorMenu(View view, JMenuBar menuBar) {}
    public static void initAlignMenu(View view, JMenuBar menuBar) {}
    public static void initStyleMenu(View view, JMenuBar menuBar) {}
    public static void initEditMenu(View view, JMenuBar menuBar) {}
    public static void initFileMenu(View view, JMenuBar menuBar) {}
}
