package com.javarush.task.task32.task3209.actions;

import javax.swing.text.StyledEditorKit;
import java.awt.event.ActionEvent;
//Класс SubscriptAction отвечает за стиль текста "Подстрочный знак"
public class SubscriptAction extends StyledEditorKit.StyledTextAction{

    private static final String nm = "1";

    /**
     * Creates a new StyledTextAction from a string action name.
     *
     */
    public SubscriptAction() {
        super(nm);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
