package core.events;

import constants.SCENES;
import javafx.event.Event;
import javafx.event.EventType;

/**
 * Event fired to change the scene
 * The even type is an Enum to represent the scene to change
 */
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
