package it.polito.tdp.alien;

import java.util.*;
import java.net.URL;

import it.polito.tdp.alien.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

	private Model model;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private TextArea txtResult;

    @FXML
    void handleClear(ActionEvent event) {
    	model.clearDictionary();
    	txtResult.clear();
    }

    @FXML
    void handleTranslate(ActionEvent event) {
    	String parolaAl;
    	String parolaIt;
    	LinkedList <String> traduzioni= new LinkedList<String>();
    	
    	txtResult.clear();
    	
		String testo= txtParola.getText();
		txtParola.clear();

		if(!model.controlloCaratteri(testo))
			txtResult.setText("ERRORE! Inserisci solo lettere dell'alfabeto");
		
		String[] campi= testo.split(" ");
		if(campi.length==1) { //CERCA PAROLA	
			parolaAl=campi[0];
			traduzioni=(LinkedList<String>) model.findParola(parolaAl);
			
			String tot="";
			for(String s: traduzioni)
				tot=tot+s+"\n";
			txtResult.setText(tot);
		}else if(campi.length==2) { //AGGIUNGI A VOCABOLARIO
			parolaAl=campi[0];
			parolaIt=campi[1];
			model.addParola(parolaAl, parolaIt);
		}else
			txtResult.setText("ERRORE!");

    }

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";

    }

    public void setModel(Model model){
    	this.model=model;
    }
}