package Core.Events;

import Constants.SCENES;
import javafx.event.Event;
import javafx.event.EventType;

public class SceneEvent extends Event {

    private SCENES type;

    public SceneEvent(EventType<? extends Event> eventType, SCENES type) {
        super(eventType);
        this.type = type;
    }

    public SCENES getType() {
        return type;
    }
}
