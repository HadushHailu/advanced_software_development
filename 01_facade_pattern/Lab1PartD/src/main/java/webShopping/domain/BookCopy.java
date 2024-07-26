package webShopping.domain;

public class BookCopy {
    private Long id;
    private int copyNumber;

    public BookCopy(Long id, int copyNumber) {
        this.id = id;
        this.copyNumber = copyNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCopyNumber() {
        return copyNumber;
    }

    public void setCopyNumber(int copyNumber) {
        this.copyNumber = copyNumber;
    }
}
