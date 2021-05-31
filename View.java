package com.javarush.task.task32.task3209;

import com.javarush.task.task32.task3209.listeners.FrameListener;
import com.javarush.task.task32.task3209.listeners.TabbedPaneChangeListener;
import com.javarush.task.task32.task3209.listeners.TextEditMenuListener;
import com.javarush.task.task32.task3209.listeners.UndoListener;
import javafx.scene.layout.BorderPane;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.MenuListener;
import javax.swing.text.Document;
import javax.swing.undo.UndoManager;
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
    //управляет списком отменяемых изменений
    private UndoManager undoManager = new UndoManager();

    private UndoListener undoListener = new UndoListener(undoManager);

    public UndoListener getUndoListener() {
        return undoListener;
    }

    public Controller getController() {
        return controller;
    }

    public void undo() {
        try {
            undoManager.undo();
        } catch (Exception e) {
            ExceptionHandler.log(e);
        }
    }

    public void redo() {
        try {
        undoManager.redo();
        } catch (Exception e) {
            ExceptionHandler.log(e);
        }
    }

    public void resetUndo() {
        undoManager.discardAllEdits();
    }
    //выбирает вкладку HTML и сбрасывает все правки
    public void selectHtmlTab() {
        tabbedPane.setSelectedIndex(0);
        resetUndo();
    }
    //получает документ у контроллера и устанавливает его в панель редактирования htmlTextPane
    public void update() {
        htmlTextPane.setDocument(controller.getDocument());
    }
    //показывает диалоговое окно с информацией о программе.
    public void showAbout() {
        JOptionPane.showMessageDialog(getContentPane(), "Version 1.0", "About", JOptionPane.INFORMATION_MESSAGE);
    }

    public boolean isHtmlTabSelected() {
        return tabbedPane.getSelectedIndex() == 0 ? true : false;
    }

    public View() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            ExceptionHandler.log(e);
        }

    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public boolean canUndo() {
       return undoManager.canUndo();
    }

    public boolean canRedo() {
        return undoManager.canRedo();
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
        //Создаём новый объект типа JMenuBar. Это и будет наша панель меню
        JMenuBar jMenuBar = new JMenuBar();
        //С помощью MenuHelper инициализируем меню в следующем порядке:
        // Файл, Редактировать, Стиль, Выравнивание, Цвет, Шрифт и Помощь
        MenuHelper.initFileMenu(this,jMenuBar);
        MenuHelper.initEditMenu(this,jMenuBar);
        MenuHelper.initStyleMenu(this,jMenuBar);
        MenuHelper.initAlignMenu(this,jMenuBar);
        MenuHelper.initColorMenu(this,jMenuBar);
        MenuHelper.initFontMenu(this,jMenuBar);
        MenuHelper.initHelpMenu(this,jMenuBar);
        getContentPane().add(jMenuBar, BorderLayout.NORTH);
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
