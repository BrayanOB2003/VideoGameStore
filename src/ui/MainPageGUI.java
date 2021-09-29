package ui;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;

public class MainPageGUI{
	
	@FXML
    private TextField availableCashiers;

    @FXML
    private TextField shelfId;
    
    @FXML
    private TextField shelfNumber;
    
    @FXML
    private TextField shelfSize;

    @FXML
    private TextField gameId;

    @FXML
    private TextField gameQuantity;

    @FXML
    private TextField gamePrice;

    @FXML
    private TextField videogameCode;

    @FXML
    private TextField clientId;
    

    @FXML
    private TextField clientSize;

    @FXML
    private TextArea outputs;

    @FXML
    public void addGameToClient(ActionEvent event) {

    }

    @FXML
    public void addGameToPrice(ActionEvent event) {

    }
    
    @FXML
    public void createCase(ActionEvent event) {

    }
    
    @FXML
    public void shelfArranged(ActionEvent event) {

    }
    
	public void initialize() {
		
		shelfNumber.setOnKeyPressed( e -> {
			  if( e.getCode() == KeyCode.ENTER ) {
				  shelfNumber.setDisable(true);
			  }
			} );
		
		shelfId.setOnKeyPressed( e -> {
			  if( e.getCode() == KeyCode.ENTER ) {
				  shelfId.setDisable(true);
			  }
			} );
		
		shelfSize.setOnKeyPressed( e -> {
			  if( e.getCode() == KeyCode.ENTER ) {
				  shelfSize.setDisable(true);
			  }
			} );
		
		availableCashiers.setOnKeyPressed( e -> {
			  if( e.getCode() == KeyCode.ENTER ) {
				  availableCashiers.setDisable(true);
			  }
			} );
		
		clientSize.setOnKeyPressed( e -> {
			  if( e.getCode() == KeyCode.ENTER ) {
				  clientSize.setDisable(true);
			  }
			} );
		
	}

}
