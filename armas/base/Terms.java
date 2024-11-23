package armas.base;

import java.time.LocalDate;

public class Terms {
    private String id;
    private LocalDate termStart;
    private LocalDate termEnd;

    public Terms(String id, LocalDate termStart, LocalDate termEnd) {
        this.id = id;
        this.termStart = termStart;
        this.termEnd = termEnd;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getTermStart() {
        return termStart;
    }

    public void setTermStart(LocalDate termStart) {
        this.termStart = termStart;
    }

    public LocalDate getTermEnd() {
        return termEnd;
    }

    public void setTermEnd(LocalDate termEnd) {
        this.termEnd = termEnd;
    }
}
