package Controllers;

import Core.Entities.AEntity;

import java.util.HashMap;

public class AssetsManager {
    public HashMap<String, AEntity> list;
    public AssetsManager() {
        this.list = new HashMap();
    }
}
