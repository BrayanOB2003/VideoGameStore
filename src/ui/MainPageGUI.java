package ui;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyCode;
import model.Shelf;
import model.Store;

public class MainPageGUI{
	
	private Store gameStore;
	private int auxCountGame;
	private Shelf auxShelf;
	private int auxCountShelves;
	private int auxCountClients;
	
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
    	
    	if(auxCountClients>0) {
    		
    		String idString = clientId.getText();
        	String games = videogameCode.getText();
        	String[] partStrings = games.split(", ");
        	
        	Integer[] gameList = new Integer[partStrings.length];
        	
        	for (int i = 0; i < partStrings.length; i++) {
    			
        		gameList[i] =  Integer.parseInt(partStrings[i]);
    		}
        	
        	gameStore.addClient(idString, gameList, true);
        	auxCountClients--;
    		
    	}else {
    		
    		sendAlert("Informaci�n de clientes", "El n�mero total de clientes a�adidos se ha completado con �xito");
    		clientId.setDisable(true);
    		videogameCode.setDisable(true);
    		
    	}
    	
    	
    }
    
    @FXML
    public void baseDataCase(ActionEvent event) {
    	
    	shelfNumber.setDisable(true);
    	availableCashiers.setDisable(true);
    	clientSize.setDisable(true);
    	
    	int shelf = Integer.parseInt(shelfNumber.getText());
    	int client = Integer.parseInt(clientSize.getText());
    	int cashier = Integer.parseInt(availableCashiers.getText());
    	
    	gameStore = new Store(shelf, client, cashier);
    	auxCountShelves = shelf;
    	auxCountClients = client;

    }

    @FXML
    public void addGameToShelf(ActionEvent event) {
    	
    		if(auxCountGame>0) {
        		double aux = Double.parseDouble(gamePrice.getText());
        		int quantAux = Integer.parseInt(gameQuantity.getText());
        		int id = Integer.parseInt(gameId.getText());
        		auxShelf.addGames(aux, id, quantAux);
        		auxCountGame--;
        		if(auxCountGame==0) {
        			sendAlert("Estanter�a", "La estanter�a " + auxShelf.getIdentifier() + " est� completa");
        			auxShelf=null;
        			auxCountShelves--;
        			shelfId.setDisable(false);
        			shelfSize.setDisable(false);
        			shelfId.setText("");
        			shelfSize.setText("");
        		}
        		
        		gameId.setText("");
    			gamePrice.setText("");
    			gameQuantity.setText("");
        		
        	}
        		
        		if(auxCountShelves == 0) {
					  sendAlert("Informaci�n de tienda", "Las estanterias han sido completadas exitosamente");
					  shelfSize.setDisable(true);
					  shelfId.setDisable(true);
					  gameId.setDisable(true);
					  gameQuantity.setDisable(true);
					  gamePrice.setDisable(true);
					  
					   
				  }
        		
    }
    
    @FXML
    public void createCase(ActionEvent event) {

    }
    
    
    @FXML
    public void createShelf(ActionEvent event) {
    	
    	shelfSize.setDisable(true);
		  shelfId.setDisable(true);
		  
		  if (auxCountShelves>0) {
			  
			  auxShelf = gameStore.addShelf(shelfId.getText(), Integer.parseInt(shelfSize.getText()));
			  auxCountGame =  Integer.parseInt(shelfSize.getText());
			  
		  }

    }
    
    public void warningAlert(String title, String text) {
		
    	Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle(title);
		alert.setHeaderText(null);
		alert.setContentText(text);
		alert.showAndWait();
    	
	}
    
    public void sendAlert(String title, String text) {
		
    	Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle(title);
		alert.setHeaderText(null);
		alert.setContentText(text);
		alert.showAndWait();
    	
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
				  shelfId.setDisable(true);
				  
				  if (auxCountShelves>0) {
					  
					  auxShelf = gameStore.addShelf(shelfId.getText(), Integer.parseInt(shelfSize.getText()));
					  auxCountGame =  Integer.parseInt(shelfSize.getText());
					  
				  }
				  
				  
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
