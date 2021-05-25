package com.javarush.task.task32.task3209;

import com.javarush.task.task32.task3209.listeners.FrameListener;
import com.javarush.task.task32.task3209.listeners.TabbedPaneChangeListener;
import javafx.scene.layout.BorderPane;

import javax.swing.*;
import javax.swing.border.Border;
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
        FrameListener frameListener = new FrameListener(this);
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
        //Устанавливаем значение "text/html" в качестве типа контента для компонента htmlTextPane
        htmlTextPane.setContentType("text/html");
        //Создаём новый локальный компонент JScrollPane на базе htmlTextPane
        JScrollPane jScrollHTMLTextPane = new JScrollPane(htmlTextPane);
        //Добавляем вкладку в панель tabbedPane с именем "HTML" и компонентом JScrollPane
        tabbedPane.add("HTML",jScrollHTMLTextPane);
        //Создаём новый локальный компонент JScrollPane на базе plainTextPane
        JScrollPane  jScrollPlainTextPane = new JScrollPane(plainTextPane);
        //Добавляем еще одну вкладку в tabbedPane с именем "Текст" и компонентом jScrollPlainTextPane
        tabbedPane.add("Текст",jScrollPlainTextPane);
        //Устанавливаем предпочтительный размер панели tabbedPane
        tabbedPane.setPreferredSize(new Dimension(800,600));
        //Создаём объект класса TabbedPaneChangeListener
        TabbedPaneChangeListener tabbedPaneChangeListener = new TabbedPaneChangeListener(this);
        //Устанавливаем TabbedPaneChangeListener в качестве слушателя изменений в tabbedPane
        tabbedPane.addChangeListener(tabbedPaneChangeListener);
        getContentPane().add(tabbedPane, BorderLayout.CENTER);
    }
    //метод будет инициализировать графический интерфейс
    public void initGui() {
        initMenuBar();
        initEditor();
        pack();
    }

    public void selectedTabChanged() {
    }
}
