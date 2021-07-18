/**
 *
 * @author Razjel
 */
package application;
import logic.Combos;
import logic.Position;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import java.util.ArrayList;

public class TicTacToeApplication extends Application {    
    private int turn;
    private ArrayList<Position> positionListX;
    private ArrayList<Position> positionListO;
    
    @Override 
    public void init() {
         this.turn = 0;
         this.positionListX = new ArrayList<>();
         this.positionListO = new ArrayList<>();
    }
    
    @Override
    public void start(Stage window) {
       
        Combos combos = new Combos();  
        Label turnLabel = new Label("Turn: X");
        
        GridPane gamePanel = new GridPane();
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                Button button = new Button(" ");
                Position position = new Position(j, i);
                button.setFont(Font.font("Monospaced", 40));                
                button.setOnAction((event) -> {
                     
                    String player = "";   
                    if (button.getText().equals(" ") && !turnLabel.getText().contains("WINS") && !turnLabel.getText().equals("The end!")) {                         
                                                                                                                                
                        if (this.turn % 2 == 0) {
                            player = "X";                                                     
                            turnLabel.setText("Turn: O");                      
                        } else {
                            player = "O";                       
                            turnLabel.setText("Turn: X");
                        }
                        
                        button.setText(player);
                        
                        if (player.equals("X")) {
                            combos.addCombo(player, this.positionListX, position);
                        } else if (player.equals("O")) {
                            combos.addCombo(player, this.positionListO, position);
                        }                                         
                        if (combos.isComboCompleted(player) == true) {
                            turnLabel.setText(player + " WINS");
                        }        
                            
                        this.turn++;                                                                        
                        
                        if (!turnLabel.getText().contains("WINS") && this.turn == 9) {
                            turnLabel.setText("The end!");
                        }
                    } 
                });
                
                gamePanel.add(button, i, j);                           
            }
        }
                
        gamePanel.setAlignment(Pos.CENTER);
        gamePanel.setPadding(new Insets(10, 10, 10, 10));
        gamePanel.setVgap(10);
        gamePanel.setHgap(10);
                
        BorderPane layout = new BorderPane();
        layout.setTop(turnLabel);
        layout.setCenter(gamePanel);
        layout.setPrefSize(200, 100);
        layout.setPadding(new Insets(10, 10, 10, 10));
   
        Scene view = new Scene(layout);
        window.setScene(view);
        window.show();
    }  
   
    public static void main(String[] args) {
        launch(TicTacToeApplication.class);
        
    }

}