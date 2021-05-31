package com.javarush.task.task32.task3209;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Document;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

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

    public String getPlainText() {
        StringWriter writer = new StringWriter();
        try {
            new HTMLEditorKit().write(writer, document, 0,document.getLength());
        } catch (IOException | BadLocationException e) {
            ExceptionHandler.log(e);
        }
            return writer.toString();
    }

    public void setPlainText(String text) {
        resetDocument();
        ;
        try (StringReader reader = new StringReader(text)){
            new HTMLEditorKit().read(reader, document, 0);
        } catch (IOException | BadLocationException e) {
            ExceptionHandler.log(e);
        }
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
