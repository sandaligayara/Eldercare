package lk.ijse.Eldercare.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.dto.LoginDto;
import lk.ijse.model.loginModel;

import java.io.IOException;
import java.util.Objects;

public class LoginFormController {

    @FXML
    private JFXButton ForgotPassword;

    @FXML
    private JFXButton LoginButton;

    @FXML
    private PasswordField Passwordtxt;

    @FXML
    private TextField UserNameTxt;

    @FXML
    private AnchorPane rootPane;

    @FXML
    private ImageView imageimv;

    @FXML
    private JFXButton newAccount;

    @FXML
    void ForgotPasswordonAction(ActionEvent event) throws IOException {
            String username = UserNameTxt.getText();
            String password = Passwordtxt.getText();
    }

    @FXML
    void Loginbuttononaction(ActionEvent event) {
        LoginModel loginModel = new loginModel();
        boolean b = loginModel.checkUsername(new loginDto(UserNameTxt.getText(), Passwordtxt.getText()));

        if (b) {
            rootPane.getChildren().clear();
            try {
                rootPane.getChildren().add(FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("/view/dashboardForm.fxml"))));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("varadiy meka");
        }
    }

    @FXML
    void imageimvonMouseClicked(MouseEvent event) {

    }

    @FXML
    void newAccountOnAction(ActionEvent event) {

    }

}
