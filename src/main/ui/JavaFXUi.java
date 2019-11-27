package ui;

import javafx.application.Application;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import placeholder.Main;
import racetrack.*;
import racetrack.exceptions.NegativeAmountException;

import javax.sound.sampled.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JavaFXUi extends Application {

    private Platform thisPlatform;
    private List<Bets> betsList;
    private TextField[] textFields;
    private TextField winner;

    public void start(Stage s) throws FileNotFoundException {
        initializeProgram();
        s.setTitle("Horse Race Betting Platform");
        HBox r = new HBox();
        r.getChildren().add(loadButton(s));
        r.setBackground(setBackgroundFrontPage());
        Scene sc = new Scene(r, 250, 250);
        s.setScene(sc);
        s.show();
    }


    public void initializeProgram() {
        thisPlatform = new Platform();
        betsList = new ArrayList<Bets>();
        textFields = new TextField[30];
        winner = new TextField();
    }

    public Button loadButton(Stage s) {
        Button b = new Button("Load race");
        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                thisPlatform.loadRace();
                try {
                    playSound("data/horse-gallop.wav");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                sceneNum2(s);
            }
        };
        b.setOnAction(event);
        setButton1(b);
        return b;
    }

    public Background setBackgroundFrontPage() throws FileNotFoundException {
        FileInputStream input = new FileInputStream("data/horserace.jpg");
        Image image = new Image(input);
        BackgroundImage backgroundimage = new BackgroundImage(image,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        Background background = new Background(backgroundimage);
        return background;
    }

    public void sceneNum2(Stage s) {
        VBox root = new VBox(5);

        Text horsesInRace = new Text();

        String stringOfHorsesInRace = thisPlatform.getHorsesInRace();
        horsesInRace.setText(stringOfHorsesInRace);
        horsesInRace.setTranslateX(90);
        horsesInRace.setY(10);

        generateTitleAndHorseList(root);

        root.getChildren().add(horsesInRace);

        generateTextFields(root);

        Scene sc2 = new Scene(root, 700, 250);
        s.setScene(sc2);
        s.show();
        root.getChildren().add(submitButton(s));
    }

    public void generateTitleAndHorseList(VBox root) {
        Text someT = new Text();
        someT.setText("Please enter customer names, bets and horses bet on: ");
        someT.setTranslateX(220);
        someT.setY(10);

        root.getChildren().add(someT);

    }

    public void generateTextFields(VBox root) {
        for (int i = 0; i <= 4; i++) {
            Label label = new Label("Name : ");
            TextField textfield = new TextField();
            textfield.setPrefColumnCount(10);
            textFields[i * 3] = textfield;

            Label label2 = new Label("Bet : ");
            TextField textfield2 = new TextField();
            textfield2.setPrefColumnCount(10);
            textFields[i * 3 + 1] = textfield2;

            Label label3 = new Label("Horse : ");
            TextField textfield3 = new TextField();
            textfield2.setPrefColumnCount(10);
            textFields[i * 3 + 2] = textfield3;

            HBox hbox = new HBox(label, textfield, label2, textfield2, label3, textfield3);
            hbox.setSpacing(10);
            hbox.setAlignment(Pos.CENTER);
            root.getChildren().add(hbox);
        }
    }

    public Button submitButton(Stage s) {
        Button b = new Button("Submit");
        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                try {
                    forLoopForGeneratingBets();
                } catch (NegativeAmountException ex) {
                    ex.printStackTrace();
                }
                tryCatch(s);
            }
        };
        b.setOnAction(event);
        b.setAlignment(Pos.CENTER);
        b.setTranslateX(340);
        return b;
    }

    public void forLoopForGeneratingBets() throws NegativeAmountException {
        Bets betToAdd;
        Customer someCust;
        Horse someHorse;

        for (int j = 0; j <= 4; j++) {
            someCust = new Customer(textFields[j * 3].getText());
            someCust.addMoney(1000);
            thisPlatform.getCustomers().add(someCust);
            someHorse = new ThoroughBred(textFields[(j * 3) + 2].getText());
            betToAdd = new Bets(Integer.parseInt(textFields[j * 3 + 1].getText()),
                    thisPlatform.getBookmaker(),
                    someCust,
                    someHorse);
            thisPlatform.getBookmaker().addBets(betToAdd);
            betsList.add(betToAdd);
        }
    }

    public void tryCatch(Stage s) {
        try {
            playSound("data/horse-neigh1.wav");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        try {
            sceneNum3(s);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public void sceneNum3(Stage s) throws FileNotFoundException {

        VBox root = new VBox(5);
        generateHeaderText(root);
        TextField textfield = new TextField();
        textfield.setPrefColumnCount(10);

        HBox hbox = new HBox(textfield);
        hbox.setSpacing(10);
        hbox.setAlignment(Pos.CENTER);
        root.getChildren().add(hbox);

        winner = textfield;
        root.getChildren().add(payWinnersButton());

        root.setBackground(setBackgroundFinishPage());

        Scene sc3 = new Scene(root, 250, 250);
        s.setScene(sc3);
        s.show();
    }

    public void generateHeaderText(VBox root) {
        Text someT = new Text();
        Text someT2 = new Text();

        someT.setText("Race is over!");
        someT2.setText("Please enter the winning horse.");
        someT.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        someT.setFill(Color.WHITE);

        someT2.setFont(Font.font("Arial", FontWeight.BOLD,12));
        someT2.setFill(Color.WHITE);

        HBox titleBox = new HBox(someT);
        titleBox.setSpacing(10);
        titleBox.setAlignment(Pos.CENTER);
        root.getChildren().add(titleBox);

        HBox titleBox2 = new HBox(someT2);
        titleBox2.setSpacing(10);
        titleBox2.setAlignment(Pos.CENTER);
        root.getChildren().add(titleBox2);
    }

    public Background setBackgroundFinishPage() throws FileNotFoundException {
        FileInputStream input = new FileInputStream("data/finish.jpg");
        Image image = new Image(input);
        BackgroundImage backgroundimage = new BackgroundImage(image,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        Background background = new Background(backgroundimage);
        return background;
    }

    public HBox payWinnersButton() {
        Button b = new Button("Pay out winners");
        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                try {
                    String winnerString = winner.getText();
                    payBets(winnerString);
                } catch (NegativeAmountException ex) {
                    ex.printStackTrace();
                }
            }
        };
        b.setOnAction(event);

        HBox hbox2 = new HBox(b);
        hbox2.setSpacing(10);
        hbox2.setAlignment(Pos.CENTER);

        return hbox2;
    }

    public void payBets(String someWinner) throws NegativeAmountException {
        for (Bets b : betsList) {
            if (b.getHorseBetOn().getName().equals(someWinner)) {
                b.getCustomer().addMoney(b.getBetAmount() * 2);
                System.out.println(b.getCustomer().getName() + " won " + b.getBetAmount() * 2 + " dollars.");
                System.out.println(b.getCustomer().getName() + " now has "
                        + b.getCustomer().getBalance() + " dollars total.");
            } else {
                System.out.println(b.getCustomer().getName() + " lost money.");
            }
        }
    }

    void playSound(String soundFile) throws IOException, LineUnavailableException, UnsupportedAudioFileException {
        File f = new File("./" + soundFile);
        AudioInputStream audioIn = AudioSystem.getAudioInputStream(f.toURI().toURL());
        Clip clip = AudioSystem.getClip();
        clip.open(audioIn);
        clip.start();
    }

    void setButton1(Button someButton) {
        someButton.setTranslateX(90);
        someButton.setTranslateY(10);
    }

    public static void main(String[] args) {
        Platform thisPlat = new Platform();
        thisPlat.platformInit();
        launch(args);
    }
}

