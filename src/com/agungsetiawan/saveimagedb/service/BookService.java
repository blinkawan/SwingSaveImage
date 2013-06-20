package com.agungsetiawan.saveimagedb.service;

import com.agungsetiawan.saveimagedb.dao.BookDao;
import com.agungsetiawan.saveimagedb.domain.Book;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author awanlabs
 */
public class BookService {
    Connection connection;
    BookDao bookDao;
    
    public BookService(MysqlDataSource dataSource) throws SQLException{
        this.connection=dataSource.getConnection();
        bookDao=new BookDao();
        bookDao.setConnection(connection);
    }
    
    public void save(Book book){
        try{
            connection.setAutoCommit(false);
            bookDao.save(book);
            connection.commit();
            connection.setAutoCommit(true);
        } catch(SQLException exception){
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public List<Book> findAll(){
        try {
            return bookDao.findAll();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
