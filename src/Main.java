import java.util.ArrayList;


enum Grouping {
    FICTION, POETRY, EDUCATION, MYSTERY, CHILDREN, ROMANCE, HISTORY
}

public class Main {
    public static void main(String[] args) {

    }

    class Library {
        StringBuilder libName;
        ArrayList<StringBuilder> libNames = new ArrayList<>();
        ArrayList<BookShelf> bookShelves = new ArrayList<>();
        ArrayList<Admin> admins = new ArrayList<>();
        ArrayList<StringBuilder> borrowingRequests = new ArrayList<>();
        ArrayList<StringBuilder> borrowed = new ArrayList<>();

        void allLibs() {
            libNames.add(libName);
        }

    }

    class Book {
        StringBuilder name, writer;
        Grouping genera;
        int year, page;
        boolean check;
        StringBuilder id;

        StringBuilder makeID() {
            id.append(genera.toString(), 0, 3).append(name, 0, 4).append(writer).append(year);
            return id;
        }
    }

    class BookShelf {
        Grouping genera;

        ArrayList<Book> bookInShelf = new ArrayList<>();

    }

    class User {
        StringBuilder username, password;
        ArrayList<StringBuilder> bookList = new ArrayList<>();
        ArrayList<StringBuilder> names = new ArrayList<>();

        void addNames() {
            names.add(username);
        }

        void showBorrowed() {
            for (StringBuilder str : bookList) {
                System.out.println(str);
            }
        }

        void borrow(StringBuilder id) {
            BookShelf bs = new BookShelf();
            Library library = new Library();
            for (Book bk : bs.bookInShelf) {
                if (id.compareTo(bk.id) == 0) {
                    if (!bk.check) {
                        library.borrowingRequests.add(username);
                        library.borrowingRequests.add(id);
                    }

                }
            }
        }

        void searchName(StringBuilder name) {
            BookShelf bs = new BookShelf();
            for (Book bk : bs.bookInShelf) {
                if (name.compareTo(bk.name) == 0) {
                    System.out.println("found");
                } else {
                    System.out.println("not found!");
                }
            }
        }

        void searchWriter(StringBuilder writer) {
            BookShelf bs = new BookShelf();
            for (Book bk : bs.bookInShelf) {
                if (writer.compareTo(bk.writer) == 0) {
                    System.out.println("found!");
                } else {
                    System.out.println("not found!");
                }
            }
        }

        void searchGenera(String genera) {
            BookShelf bs = new BookShelf();
            for (Book bk : bs.bookInShelf) {
                if (genera.equals(bk.genera.toString())) {
                    System.out.println("found!");
                } else {
                    System.out.println("not found!");
                }
            }
        }

        void showLibs() {
            Library library = new Library();
            for (StringBuilder lib : library.libNames) {
                System.out.println(lib);
                for (BookShelf bs : library.bookShelves) {
                    for (Book bk : bs.bookInShelf) {
                        System.out.println(bk.name);
                    }
                }
            }
        }
    }

    class Admin {
        StringBuilder username, password;
        ArrayList<Library> libraries = new ArrayList<>();

        void addBook(Grouping genera, StringBuilder nameBook, StringBuilder writer, int year, int page) {
            Library library = new Library();
            for (BookShelf bs : library.bookShelves) {
                if (genera.equals(bs.genera)) {
                    Book bk = new Book();
                    bk.genera = genera;
                    bk.name = nameBook;
                    bk.writer = writer;
                    bk.year = year;
                    bk.page = page;
                    bk.check = false;
                    bk.id = bk.makeID();
                }
            }
        }

        void requestsList() {
            Library library = new Library();
            for (StringBuilder user : library.borrowingRequests) {
                System.out.println(user);
            }
        }

        void Requests(boolean check, StringBuilder name) {
            Library library = new Library();
            int i;
            if (check) {
                for (StringBuilder user : library.borrowingRequests) {
                    if (user.compareTo(name) == 0) {
                        i = library.borrowingRequests.indexOf(name);
                        library.borrowingRequests.remove(name);
                        library.borrowed.add(name);
                        User user1 = new User();
                        if (user1.names.contains(name)) {
                            i = i + 1;
                            user1.bookList.add(library.borrowingRequests.get(i + 1));
                        }
                    }
                }
            } else {
                for (StringBuilder user : library.borrowingRequests) {
                    if (user.compareTo(name) == 0) {
                        library.borrowingRequests.remove(name);
                    }
                }
            }
        }

    }

    class SuperAdmin {
        void addLib(StringBuilder name) {
            Library lib = new Library();
            if (lib.libNames.contains(name)) {
                System.out.println("you cant add this library!");
            } else {
                lib.libName = name;
                BookShelf bs = new BookShelf();
                lib.bookShelves.add(bs);
            }
        }

        void showLibs() {
            Library lib = new Library();
            for (StringBuilder str : lib.libNames) {
                System.out.println(str);
            }
        }
    }
}




