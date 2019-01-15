package old.Core.EventsOld;

import java.util.EventListener;

public interface ISceneListener extends EventListener {
    void sceneChanged(SceneEvent scene);
}
