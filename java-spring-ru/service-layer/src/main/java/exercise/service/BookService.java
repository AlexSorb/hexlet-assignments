package exercise.service;

import exercise.dto.BookCreateDTO;
import exercise.dto.BookDTO;
import exercise.dto.BookUpdateDTO;
import exercise.exception.ResourceNotFoundException;
import exercise.mapper.BookMapper;
import exercise.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    // BEGIN
    @Autowired
    BookRepository bookRepository;

    @Autowired
    BookMapper bookMapper;

    public List<BookDTO> getAllBooks() {
        var books = bookRepository.findAll();
        var result = books.stream()
                .map(bookMapper::map)
                .toList();
        return result;
    }

    public BookDTO getBook(Long id) {
        var book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found"));
        var result = bookMapper.map(book);
        return result;
    }

    public BookDTO createBook(BookCreateDTO data) {
        var book = bookMapper.map(data);
        bookRepository.save(book);
        return bookMapper.map(book);
    }

    public BookDTO updateBook(Long id, BookUpdateDTO data) {
        var book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found"));
        bookMapper.update(data, book);
        bookRepository.save(book);
        return bookMapper.map(book);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
    // END
}
