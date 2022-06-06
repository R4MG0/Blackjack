package ch.bbcag.cardgames.gui.scenes;

import ch.bbcag.cardgames.common.scene.BaseScene;
import ch.bbcag.cardgames.common.scene.Navigator;
import ch.bbcag.cardgames.common.scene.SceneType;
import ch.bbcag.cardgames.gui.common.TextLayout;
import ch.bbcag.cardgames.gui.common.TitleLayout;

import javafx.geometry.Insets;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.transform.Rotate;

import java.util.Objects;

public class StartScene extends BackgroundScene {

    private static final String IMAGE_PATH_SPADES = "/pokerdeck/AS.png";
    private static final String IMAGE_PATH_CLUBS = "/pokerdeck/AC.png";
    private static final String IMAGE_PATH_HEARTS = "/pokerdeck/AH.png";
    private static final String IMAGE_PATH_DIAMONDS = "/pokerdeck/AD.png";
    private static final String IMAGE_PATH_ARROW = "/objects/arrow.png";

    private static final int POS_X_CLUBS = 250;
    private static final int POS_Y_CLUBS = 120;

    private static final int POS_X_SPADES = 210;
    private static final int POS_Y_SPADES = 290;

    private static final int POS_X_HEARTS = 100;
    private static final int POS_Y_HEARTS = 420;

    private static final int POS_X_DIAMONDS = 600;
    private static final int POS_Y_DIAMONDS = 580;

    private static final double WIDTH_CARD = 250;
    private static final double HEIGHT_CARD = 350;

    private static final int RIGHT_INSETS = 120;
    private static final int LEFT_INSETS = 50;

    private static final int POS_X_Y_ARROW = 60;

    private static final int ANGLE_AC = -30;
    private static final int ANGLE_AH = 30;

    private static final Image as = new Image(Objects.requireNonNull(BackgroundScene.class.getResourceAsStream(IMAGE_PATH_SPADES)));
    private static final Image ac = new Image(Objects.requireNonNull(BackgroundScene.class.getResourceAsStream(IMAGE_PATH_CLUBS)));
    private static final Image ah = new Image(Objects.requireNonNull(BackgroundScene.class.getResourceAsStream(IMAGE_PATH_HEARTS)));
    private static final Image ad = new Image(Objects.requireNonNull(BackgroundScene.class.getResourceAsStream(IMAGE_PATH_DIAMONDS)));
    private static final Image arrow = new Image(Objects.requireNonNull(BackgroundScene.class.getResourceAsStream(IMAGE_PATH_ARROW)));

    private static final TextLayout BLACKJACK = new TextLayout("Blackjack");
    private static final TitleLayout CARD_GAMES = new TitleLayout("Select Game: ");
    private static final BorderPane MAIN_BORDER_PANE = new BorderPane();

    private static final Button BTN_1_CARD = new Button("");

    public StartScene(Navigator navigator) {
        super(navigator);
    }

    @Override
    public void update(double deltaTime) {

    }

    @Override
    public void paint() {
        super.paint();
        setupButtonsAsPicture();
        drawImages();
    }

    private void drawImages() {
        drawRotatedImage(gc, ac, ANGLE_AC, POS_X_CLUBS, POS_Y_CLUBS);
        drawRotatedImage(gc, as, 0, POS_X_SPADES, POS_Y_SPADES);
        drawRotatedImage(gc, ah, ANGLE_AH, POS_X_HEARTS, POS_Y_HEARTS);

        gc.drawImage(arrow, POS_X_Y_ARROW, POS_X_Y_ARROW);
    }

    @Override
    public void onEnter() {
        super.onEnter();
        setupBorderPane();
        setupButtonsAsPicture();
    }

    private void setupButtonsAsPicture() {
        ImageView asForBlackJack = new ImageView(ad);
        asForBlackJack.setRotate(asForBlackJack.getRotate() + 45);
        asForBlackJack.setFitHeight(HEIGHT_CARD);
        asForBlackJack.setFitWidth(WIDTH_CARD);
        BTN_1_CARD.setGraphic(asForBlackJack);
        BTN_1_CARD.setLayoutX(POS_X_DIAMONDS);
        BTN_1_CARD.setLayoutY(POS_Y_DIAMONDS);
        BTN_1_CARD.setOnAction(e -> nav.navigateTo(SceneType.BLACKJACK));
    }

    private void setupBorderPane() {
        MAIN_BORDER_PANE.setPrefSize(BaseScene.SCREEN_WIDTH, BaseScene.SCREEN_HEIGHT);
        MAIN_BORDER_PANE.setPadding(new Insets(0, RIGHT_INSETS, 0, LEFT_INSETS));
        MAIN_BORDER_PANE.setRight(BLACKJACK);
        MAIN_BORDER_PANE.setTop(CARD_GAMES);


        MAIN_BORDER_PANE.getChildren().addAll(BTN_1_CARD);
        getStackPane().getChildren().add(MAIN_BORDER_PANE);
    }

    private void drawRotatedImage(GraphicsContext gc, Image image, double angle, double posX, double posY) {
        gc.save();
        rotate(gc, angle, posX + image.getWidth() / 2, posY + image.getHeight() / 2);
        gc.drawImage(image, posX, posY, WIDTH_CARD, HEIGHT_CARD);
        gc.restore();
    }

    private void rotate(GraphicsContext gc, double angle, double px, double py) {
        Rotate r = new Rotate(angle, px, py);
        gc.setTransform(r.getMxx(), r.getMyx(), r.getMxy(), r.getMyy(), r.getTx(), r.getTy());
    }
}