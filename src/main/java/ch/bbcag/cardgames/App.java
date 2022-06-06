package ch.bbcag.cardgames;

import ch.bbcag.cardgames.common.scene.Navigator;
import ch.bbcag.cardgames.common.scene.SceneType;
import ch.bbcag.cardgames.gui.scenes.BlackjackScene;
import ch.bbcag.cardgames.gui.scenes.StartScene;

import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Navigator nav = new Navigator(stage);

        registerScenes(nav);

        nav.navigateTo(SceneType.TITLE);

        stage.show();
    }

    private void registerScenes(Navigator nav) {
        nav.registerScene(SceneType.BLACKJACK, new BlackjackScene(nav, this));
        nav.registerScene(SceneType.TITLE, new StartScene(nav));
    }
}