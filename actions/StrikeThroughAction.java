package com.javarush.task.task32.task3209.actions;

import javax.swing.text.StyledEditorKit;
import java.awt.event.ActionEvent;
//Класс StrikeThroughAction отвечает за стиль текста "Зачеркнутый"
public class StrikeThroughAction extends StyledEditorKit.StyledTextAction{

    private static final String nm = "1";

    /**
     * Creates a new StyledTextAction from a string action name.
     *
     */
    public StrikeThroughAction() {
        super(nm);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
