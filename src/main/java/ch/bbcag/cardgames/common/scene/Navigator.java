package ch.bbcag.cardgames.common.scene;

import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

public class Navigator {

    private final Stage STAGE;
    private final Map<SceneType, BaseScene> SCENE_MAP = new HashMap<>();

    private BaseScene currentScene;

    public Navigator(Stage stage) {
        this.STAGE = stage;
    }

    public void registerScene(SceneType sceneType, BaseScene scene) {
        SCENE_MAP.put(sceneType, scene);
    }

    public void navigateTo(SceneType sceneType) {
        if (currentScene != null) {
            currentScene = (BaseScene) STAGE.getScene();
            currentScene.onExit();
        }
        currentScene = SCENE_MAP.get(sceneType);
        currentScene.onEnter();
        STAGE.setScene(currentScene);
    }
}