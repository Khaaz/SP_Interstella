package Core.events;

import Constants.SCENES;
import javafx.event.Event;
import javafx.event.EventType;

public class SceneEvent extends Event {

    private final SCENES type;

    public SceneEvent(EventType<? extends Event> eventType, SCENES type) {
        super(eventType);
        this.type = type;
    }

    public SCENES getType() {
        return type;
    }
}
