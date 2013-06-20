package saveimagedb;

import com.agungsetiawan.saveimagedb.service.BookService;
import com.agungsetiawan.saveimagedb.ui.UploadImageFrame;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.SQLException;

/**
 *
 * @author awanlabs
 */
public class SaveImageDB {
    
    private static BookService bookService;
    
    public static BookService getBookService(){
        return bookService;
    }

    public static void main(String[] args) throws SQLException {
         MysqlDataSource dataSource=new MysqlDataSource();
            dataSource.setUser("root");
            dataSource.setPassword("");
            dataSource.setServerName("localhost");
            dataSource.setDatabaseName("saveimagedb");
            
            bookService=new BookService(dataSource);
        
        new UploadImageFrame().setVisible(true);
    }
}
