package domain;


import javax.persistence.Embeddable;
import java.time.LocalDateTime;

@Embeddable
public class Period {

    public Period() {
    }

    public Period(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    private LocalDateTime startDate;

    private LocalDateTime EndDate;

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public LocalDateTime getEndDate() {
        return EndDate;
    }

    @Override
    public boolean equals(Object obj) {

        Period period1 = (Period) obj;

        return period1.getStartDate().equals(this.getStartDate());
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
