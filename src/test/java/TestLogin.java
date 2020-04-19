import lombok.val;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import java.sql.DriverManager;
import java.sql.SQLException;

import static com.codeborne.selenide.Selenide.open;

public class TestLogin {

    @AfterAll
    static void deleteData() throws SQLException {
        val deleteAuthCodes = "DELETE FROM auth_codes";
        val deleteCards = "DELETE FROM cards";
        val deleteUsers = "DELETE FROM users";
        val runner = new QueryRunner();
        try (
                val conn = DriverManager.getConnection("jdbc:mysql://192.168.99.100:3306/app", "app", "pass");
        ) {
            runner.execute(conn, deleteAuthCodes, new BeanHandler<>(User.class));
            runner.execute(conn, deleteCards, new BeanHandler<>(User.class));
            runner.execute(conn, deleteUsers, new BeanHandler<>(User.class));
        }
    }

    @Test
    public void TestLoginWithVerificationCode() throws SQLException {
        val loginPage = open("http://localhost:9999", LoginPage.class);
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCode();
        val dashboardPage = verificationPage.validVerify(verificationCode.getCode());
        dashboardPage.DashboardPageVisible();

    }
}
