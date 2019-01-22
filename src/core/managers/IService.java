package core.managers;

import core.managers.instanceManager.InstanceManager;

public interface IService {
    void start();
    void pause();
    void resume();
    void reset(InstanceManager instanceManager);
}
