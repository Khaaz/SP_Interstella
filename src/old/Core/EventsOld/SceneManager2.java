package old.Core.EventsOld;

public class SceneManager2 {
    public SceneManager2() {
        SceneSensor sensor = new SceneSensor();

        sensor.addListener(new ASceneListener() {
            @Override
            public void sceneChanged(SceneEvent event) {
                System.out.printf(event.getNewScene());
            }
        });

    }
}
