package me.gleeming.gengine.screen.menu.text;

import lombok.Getter;
import lombok.Setter;
import me.gleeming.gengine.screen.menu.button.Button;
import me.gleeming.gengine.screen.menu.text.entry.TextEntry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TextController {
    @Getter private final List<TextEntry> entries = new ArrayList<>();

    @Getter private final Button submitButton;
    @Getter private final Listener listener;

    @Getter @Setter private TextEntry selectedEntry;
    public TextController(Button submitButton, Listener listener) {
        this.submitButton = submitButton;
        this.listener = listener;

        submitButton.addListener(new Button.Listener() {
            public void buttonClick() {
                HashMap<String, String> map = new HashMap<>();

                for(TextEntry entry : entries) map.put(entry.getName(), entry.getText());

                listener.submitted(map);
            }
        });
    }

    public TextController addEntry(TextEntry entry) {
        entries.add(entry);
        return this;
    }

    public interface Listener { void submitted(HashMap<String, String> values);}
}
