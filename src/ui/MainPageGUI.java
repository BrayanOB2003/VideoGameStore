package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyCode;
import model.Store;

public class MainPageGUI{
	
	private Store gameStore;
	private int auxCountGame;
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
        	
        	if(!gameStore.verifyList(gameList)) {
        		sendAlert("Problema de catálogo", "Uno de los códigos ingresados no está en el catálogo, por favor verifique");
        		videogameCode.setText("");
        	}else {
        		
        		gameStore.addClient(idString, gameList);
            	auxCountClients--;
            	clientId.setText("");
            	videogameCode.setText("");
        	}
        	
    	}
    	
    	if(auxCountClients==0) {
    		
    		sendAlert("Información de clientes", "El número total de clientes añadidos se ha completado con éxito");
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
    public void eraseData(ActionEvent event) {
    	
    	gameStore=null;
    	enableTextField(shelfNumber);
    	enableTextField(availableCashiers);
    	enableTextField(clientSize);
    	enableTextField(shelfId);
    	enableTextField(shelfNumber);
    	enableTextField(shelfSize);
    	enableTextField(gameId);
    	enableTextField(gamePrice);
    	enableTextField(gameQuantity);
    	enableTextField(gamePrice);
    	enableTextField(clientId);
    	enableTextField(videogameCode);
 

    }
    
    public void enableTextField(TextField text) {
    	text.setDisable(false);
    	text.setText(null);
    }

    @FXML
    public void addGameToShelf(ActionEvent event) {
    	
    	String shelfIdS = shelfId.getText();
    	
    		if(auxCountGame>0) {
        		double aux = Double.parseDouble(gamePrice.getText());
        		int quantAux = Integer.parseInt(gameQuantity.getText());
        		int id = Integer.parseInt(gameId.getText());
        		gameStore.addGamesToShelf(shelfIdS, aux, id, quantAux);
        		auxCountGame--;
        		if(auxCountGame==0) {
        			sendAlert("Estantería", "La estantería " + shelfIdS + " está completa");
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
					  sendAlert("Información de tienda", "Las estanterias han sido completadas exitosamente");
					  shelfSize.setDisable(true);
					  shelfId.setDisable(true);
					  gameId.setDisable(true);
					  gameQuantity.setDisable(true);
					  gamePrice.setDisable(true);
					  
					   
				  }
        		
    }
    
    @FXML
    public void createCase(ActionEvent event) {
    	
    	String finalS = "";
    	
    	for (int i = 0; i < gameStore.getClients().length; i++) {
			finalS+=gameStore.getClients()[i].outputsClient();
		}

    	outputs.setText(finalS);
    }
    
    
    @FXML
    public void createShelf(ActionEvent event) {
    	
    	shelfSize.setDisable(true);
		  shelfId.setDisable(true);
		  
		  if (auxCountShelves>0) {
			  
			  gameStore.createShelf(shelfId.getText(), Integer.parseInt(shelfSize.getText()));
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
					  
					  gameStore.createShelf(shelfId.getText(), Integer.parseInt(shelfSize.getText()));
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
