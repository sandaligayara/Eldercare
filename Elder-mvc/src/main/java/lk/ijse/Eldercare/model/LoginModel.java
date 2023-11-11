package lk.ijse.Eldercare.model;
import lk.ijse.Eldercare.dto.LoginDto;
import java.sql.SQLException;

public class LoginModel {
    public boolean checkUsername(LoginDto logindto) throws SQLException {

        String[][] details = DbConnection.getDetails("user", 3);

        for (int i = 0; i < details.length; i++) {
            if (details[i][0].equals(logindto.getUsername())) {
                return true;
            }
        }
        return false;
    }
}
