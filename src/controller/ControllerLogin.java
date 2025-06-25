package controller;

import dao.LoginDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import util.Alerts;

public class ControllerLogin {

	@FXML
	private Button btLogin;

	@FXML
	private Label lblUsuario;

	@FXML
	private Label lblSenha;

	@FXML
	private TextField txfLogin;

	@FXML
	private TextField txfSenha;

	@FXML
	private PasswordField psfSenha;

	@FXML
	private CheckBox checkMostrarSenha;

	@FXML
	private void onCheckMostrarSenha() {
		if (checkMostrarSenha.isSelected()) {
			txfSenha.setText(psfSenha.getText());
			txfSenha.setVisible(true);
			psfSenha.setVisible(false);
		} else {
			psfSenha.setText(txfSenha.getText());
			txfSenha.setVisible(false);
			psfSenha.setVisible(true);
		}
	}

	@FXML
	void onBtLogin(ActionEvent event) {
		String login = txfLogin.getText();
		String senha = psfSenha.getText();

		if (LoginDAO.validarLogin(login, senha)) {
			try {
				Parent root = FXMLLoader.load(getClass().getResource("/view/Tela2.fxml"));
				Stage stage = (Stage) btLogin.getScene().getWindow();
				Scene scene = new Scene(root);
				stage.setScene(scene);
				stage.setTitle("Bem Vindo");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			Alerts.showAlert(null, "Login ou Senha Inválidos", null, AlertType.ERROR, true);
		}

	}

}
