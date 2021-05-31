package com.javarush.task.task32.task3209;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Document;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import java.io.File;

public class Controller {
    private View view;
    private HTMLDocument document;
    private File currentFile;

    public Controller(View view) {
        this.view = view;
    }

    public HTMLDocument getDocument() {
        return document;
    }

    public void init() {

    }

    public void resetDocument() {
        if (document != null)
        document.removeUndoableEditListener(view.getUndoListener());
        Document newDocument =new HTMLEditorKit().createDefaultDocument();
        this.document = (HTMLDocument) newDocument;
        this.document.addUndoableEditListener(view.getUndoListener());
        view.update();
    }

    public void exit(){
        System.exit(0);
    }

    public static void main(String[] args){
        View view = new View();
        Controller controller = new Controller(view);
        view.setController(controller);
        view.init();
        controller.init();
    }
}
