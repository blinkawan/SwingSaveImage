package com.agungsetiawan.saveimagedb.dao;

import com.agungsetiawan.saveimagedb.domain.Book;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author awanlabs
 */
public class BookDao {
    Connection connection;
    PreparedStatement preparedStatement;
    
    public void setConnection(Connection connection){
        this.connection=connection;
    }
    
    public void save(Book book) throws SQLException{
            preparedStatement=connection.prepareStatement("insert into book(title,image) values(?,?)");
            preparedStatement.setString(1, book.getTitle());
            preparedStatement.setString(2, book.getImage());
            preparedStatement.executeUpdate();        
    }
    
    public Book findOne(Integer id) throws SQLException{
        Book book=new Book();
        
        preparedStatement=connection.prepareStatement("SELECT * from book where id=?");
        preparedStatement.setInt(1, id);
        ResultSet rs=preparedStatement.executeQuery();
                    
        while(rs.next()){
            book.setId(rs.getInt("id"));
            book.setTitle(rs.getString("title"));
            book.setImage(rs.getString("image"));
        }
        return book;
    }
    
    public List<Book> findAll() throws SQLException{
        List<Book> listOfBook=new ArrayList<Book>();
                     
        preparedStatement=connection.prepareStatement("select * from book");
        ResultSet rs=preparedStatement.executeQuery();
            
        while(rs.next()){
            Book book=new Book();
            book.setId(rs.getInt("id"));
            book.setTitle(rs.getString("title"));
            book.setImage(rs.getString("image"));
            listOfBook.add(book);
        }
        return listOfBook;
    }
}
