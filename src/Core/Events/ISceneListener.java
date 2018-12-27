package Core.Events;

import java.util.EventListener;

public interface ISceneListener extends EventListener {
    void sceneChanged(SceneEvent scene);
}
