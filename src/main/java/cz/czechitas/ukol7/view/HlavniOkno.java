package cz.czechitas.ukol7.view;

import cz.czechitas.ukol7.Aplikace;
import cz.czechitas.ukol7.controller.PreferenceController;
import cz.czechitas.ukol7.formbuilder.FormBuilder;
import cz.czechitas.ukol7.formbuilder.FormBuilderWithContainer;
import cz.czechitas.ukol7.model.Barva;
import cz.czechitas.ukol7.model.PreferenceBean;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

public class HlavniOkno extends JFrame {
    private final PreferenceController controller;

    public HlavniOkno(PreferenceController controller) throws HeadlessException {
        super("Výběr oblíbené barvy");
        this.controller = controller;
        this.init();
    }

    public void start() {
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setIconImage(new ImageIcon(Aplikace.class.getResource("czechitas-icon.png")).getImage());
        setLayout(new MigLayout("wrap 2", "[right, 100]rel[50:75:250,grow,fill]"));
        setMinimumSize(new Dimension(400, 200));

        FormBuilderWithContainer<PreferenceBean> formBuilder = FormBuilder.create(controller.getModel())
                .container(this);

        formBuilder
            .label("&Přezdívka")
            .textField("prezdivka")
            .add();

        formBuilder
            .radioButton("&Bílá", "oblibenaBarva", Barva.Bila)
            .add("span");

        formBuilder
            .radioButton("&Růžová", "oblibenaBarva", Barva.Ruzova)
            .add("span");

        formBuilder
            .radioButton("&Fialová", "oblibenaBarva", Barva.Fialova)
            .add("span");

        formBuilder
            .radioButton("&Vínová", "oblibenaBarva", Barva.Vinova)
            .add("span");

        formBuilder
            .radioButton("&Zelená", "oblibenaBarva", Barva.Zelena)
            .add("span");

        formBuilder
             .radioButton("&Modrá", "oblibenaBarva", Barva.Modra)
             .add("span");
        formBuilder
             .panel(panel -> {
              JButton ulozitButton = new JButton(controller.getUlozitAction());

              getRootPane().setDefaultButton(ulozitButton);

              panel.add(ulozitButton);
                })
             .add("right, span");

        pack();
    }
}