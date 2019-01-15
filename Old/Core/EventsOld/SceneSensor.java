package old.Core.EventsOld;

import java.util.LinkedList;
import java.util.List;

public class SceneSensor {
    private List listeners;

    public SceneSensor() {
        this.listeners = new LinkedList();
    }

    public void addListener(ISceneListener listener) {
        if (listener == null) {
            return;
        }

        this.listeners.add(ISceneListener.class);
        this.listeners.add(listener);
    }

    public void removeTemperatureListener(ISceneListener listener) {
        if (listener == null) {
            return;
        }
        removeListener(ISceneListener.class, listener);
    }

    private void removeListener(Class listenerClass, Object listener) {

        for (int index = 0 ; index < this.listeners.size() ; index += 2) {
            if (this.listeners.get(index) == listenerClass && this.listeners.get(index + 1) == listener) {
                this.listeners.remove(index + 1);
                this.listeners.remove(index);
                break;
            }
        }
    }

    public void fireSceneChanged(String newScene) {
        SceneEvent event = null;
        int listSize = this.listeners.size();

        for (int index = listSize - 2 ; index >= 0 ; index -= 2) {

            if (this.listeners.get(index) == ASceneListener.class) {
                if (event == null) {
                    event = new SceneEvent(this, newScene);
                }
                ASceneListener listener = (ASceneListener)this.listeners.get(index + 1);

                listener.sceneChanged(event);
            }
        }
    }
}
