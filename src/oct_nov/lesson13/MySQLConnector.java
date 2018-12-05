package oct_nov.lesson13;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLConnector { // Работает так же как и с другими базами данных
    String connectionUrl = "jdbc:mysql://localhost:3306/DBNAME";
    String user = "root";// имя пользователя
    String password = "tp7407101"; // Пароль

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS Example (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, firstColumn TEXT NOT NULL, secondColumn INTEGER NOT NULL);";


        Class.forName("com.mysql.jdbc.Driver");
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/DBNAME", "root", "tp7407101")) {

            Statement statement = connection.createStatement();
            int row = statement.executeUpdate(sql);
            System.out.println(row);

        }

    }

    /*
    CREATE TABLE IF NOT EXISTS `mydb`.`Couses` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(50) NOT NULL,
  `duration` INT NOT NULL,
  `price` INT NOT NULL,
  `Teachers_id` INT NOT NULL,
  PRIMARY KEY (`id`),


  INDEX `fk_Couses_Teachers_idx` (`Teachers_id` ASC) VISIBLE,
  CONSTRAINT `fk_Couses_Teachers`
    FOREIGN KEY (`Teachers_id`)
    REFERENCES `mydb`.`Teachers` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
     */


}
