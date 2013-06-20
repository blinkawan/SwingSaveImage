package com.agungsetiawan.saveimagedb.tablemodel;

import com.agungsetiawan.saveimagedb.domain.Book;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author awanlabs
 */
public class BookTableModel extends AbstractTableModel{
    List<Book> listOfBook=new ArrayList<Book>();
    
    private final String[] header={"Judul","Nama Gambar"};
    
    public BookTableModel(List<Book> listOfBook){
        this.listOfBook=listOfBook;
    }
    
    public void save(Book book){
        listOfBook.add(book);
        fireTableRowsInserted(getRowCount()-1, getRowCount()-1);
    }
    
    public Book findOne(int index){
        return listOfBook.get(index);
    }

    @Override
    public int getRowCount() {
        return listOfBook.size();
    }

    @Override
    public int getColumnCount() {
        return header.length;
    }
    
    @Override
    public String getColumnName(int column){
        return header[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Book book=listOfBook.get(rowIndex);
        
        switch(columnIndex){
            case 0:return book.getTitle();
            case 1:return book.getImage();
            default:return null;
        }
    }
    
}
