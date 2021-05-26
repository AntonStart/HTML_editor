package com.javarush.task.task32.task3209.actions;

import javax.swing.text.StyledEditorKit;
import java.awt.event.ActionEvent;
//Класс SuperscriptAction отвечает за стиль "Надстрочный знак"
public class SuperscriptAction extends StyledEditorKit.StyledTextAction{
    private static final String nm = "1";

    /**
     * Creates a new StyledTextAction from a string action name.
     *
     */
    public SuperscriptAction() {
        super(nm);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
