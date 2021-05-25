package com.javarush.task.task32.task3209;

import com.javarush.task.task32.task3209.listeners.FrameListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JFrame implements ActionListener {

    private Controller controller;
    //панель с двумя вкладками
    private JTabbedPane tabbedPane = new JTabbedPane();
    // компонент для визуального редактирования html
    private JTextPane htmlTextPane = new JTextPane();
    //компонент для редактирования html в виде текста, он будет отображать код html (теги и их содержимое)
    private JEditorPane plainTextPane = new JEditorPane();
    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public void init() {
        initGui();
        // создаём экземпляр слушателя нашего окна
        FrameListener frameListener = new FrameListener(this);
        //Добавляем слушателя событий нашего окна
        addWindowListener(frameListener);
        setVisible(true);
    }

    public void exit() {
        controller.exit();
    }
    //метод будет отвечать за инициализацию меню редактора
    public void initMenuBar() {

    }
    //метод будет отвечать за инициализацию панелей редактора
    public void initEditor() {

    }
    //метод будет инициализировать графический интерфейс
    public void initGui() {
        initMenuBar();
        initEditor();
        pack();
    }
}
