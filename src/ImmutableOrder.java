import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

public final class ImmutableOrder {
    private final long id;
    private final String customerName;
    private final List<String> items;

    public ImmutableOrder(long id, String customerName, List<String> items) {
        if (customerName == null || customerName.isBlank()) {
            throw new IllegalArgumentException("customerName must not be null or blank");
        }
        this.id = id;
        this.customerName = customerName;

        if (items == null) {
            this.items = Collections.emptyList();
        } else {
            ArrayList<String> copy = new ArrayList<>(items);
            this.items = Collections.unmodifiableList(copy);
        }
    }

    public long getId() {
        return id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public List<String> getItems() {
        return items;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ImmutableOrder)) return false;
        ImmutableOrder that = (ImmutableOrder) o;
        return id == that.id &&
                Objects.equals(customerName, that.customerName) &&
                items.equals(that.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customerName, items);
    }

    @Override
    public String toString() {
        return "ImmutableOrder{" +
                "id=" + id +
                ", customerName='" + customerName + '\'' +
                ", items=" + items +
                '}';
    }
}
