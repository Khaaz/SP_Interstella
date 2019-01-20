package controllers;

import java.util.function.Supplier;

public interface IResetManager {
    void setResetGameManager(Supplier<Boolean> resetGameManager);
}
