public class Bill {
    private int id;
    private String name;
    private long money;
    private String date; // format: yyyy-MM-dd

    @Override
    public String toString() {
        return "Bill{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", money=" + money +
                ", date='" + date + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getMoney() {
        return money;
    }

    public String getDate() {
        return date;
    }

    public Bill(int id, String name, long money, String date) {
        this.id = id;
        this.name = name;
        this.money = money;
        this.date = date;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Bill compareBill = (Bill) obj;
        return id == compareBill.getId() && name.equals(compareBill.getName());
    }
}
