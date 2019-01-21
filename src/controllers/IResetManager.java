package controllers;

import java.util.function.Supplier;

/**
 * Specify class that call resetGameManager
 * Reset gameManager
 */
public interface IResetManager {
    void setResetGameManager(Supplier<Boolean> resetGameManager);
}
