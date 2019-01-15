package old.Core.EventsOld;

import java.util.EventObject;

public class SceneEvent extends EventObject {

    private final String newScene;

    public SceneEvent(Object o, String newScene) {
        super(o);
        this.newScene = newScene;
    }

    public String getNewScene() {
        return newScene;
    }
}
