package pl.autorun.library.bootstrap;



import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import pl.autorun.library.model.Author;
import pl.autorun.library.model.Book;
import pl.autorun.library.model.Genre;
import pl.autorun.library.model.User;
import pl.autorun.library.repositories.AuthorRepository;
import pl.autorun.library.repositories.BookRepository;
import pl.autorun.library.repositories.GenreRepository;
import pl.autorun.library.repositories.UserRepository;

@Slf4j
@Component
public class LibraryBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private GenreRepository genreRepository;
    private UserRepository userRepository;

    public LibraryBootstrap(AuthorRepository authorRepository,
                            BookRepository bookRepository, GenreRepository genreRepository,
                            UserRepository userRepository){
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.genreRepository = genreRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        System.out.println("onApplicationEvent");
        initData();
    }

    private void initData(){

        User user1 = new User("user1");
        User user2 = new User("user2");

        Author johnSmith = new Author("John", "Smith");
        Author joeDoe = new Author("Joe", "Doe");
        Author bobRoss = new Author("Bob", "Ross");
        Author jimBeam = new Author ("Jim", "Beam");



        Book book1 = new Book("book1", "1");
        Book book2 = new Book("book2", "2");
        Book book3 = new Book("book3", "3");

        Genre fantasy = new Genre("fantasy");
        Genre drama = new Genre ("drama");
        Genre romance = new Genre ("romance");


        johnSmith.getBooks().add(book1);
        johnSmith.getBooks().add(book2);
        joeDoe.getBooks().add(book1);
        bobRoss.getBooks().add(book3);
        bobRoss.getBooks().add(book2);
        jimBeam.getBooks().add(book1);
        jimBeam.getBooks().add(book2);

        book1.getAuthors().add(johnSmith);
        book1.getAuthors().add(joeDoe);
        book1.getAuthors().add(jimBeam);
        book1.getGenres().add(drama);
        book1.getGenres().add(romance);

        book2.getAuthors().add(johnSmith);
        book2.getAuthors().add(bobRoss);
        book2.getAuthors().add(jimBeam);
        book2.getGenres().add(fantasy);

        book3.getAuthors().add(bobRoss);
        book3.getGenres().add(romance);
        book3.getGenres().add(fantasy);

        fantasy.getBooks().add(book2);
        fantasy.getBooks().add(book3);


        drama.getBooks().add(book1);

        romance.getBooks().add(book1);
        romance.getBooks().add(book3);


        book1.setUser(user1);
        book2.setUser(user1);
        book3.setUser(user2);

        user1.getBooks().add(book1);
        user1.getBooks().add(book2);
        user2.getBooks().add(book3);



        userRepository.save(user1);
        userRepository.save(user2);

        authorRepository.save(johnSmith);
        authorRepository.save(joeDoe);
        authorRepository.save(bobRoss);
        authorRepository.save(jimBeam);



        bookRepository.save(book1);
        bookRepository.save(book2);
        bookRepository.save(book3);



        genreRepository.save(fantasy);
        genreRepository.save(drama);
        genreRepository.save(romance);


    }
}

