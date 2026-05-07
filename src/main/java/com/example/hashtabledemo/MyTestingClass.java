public class MyTestingClass {

    private int id;
    private String code;

    public MyTestingClass(int id, String code) {
        this.id = id;
        this.code = code;
    }

    // Custom hashCode()
    // Designed for good distribution
    @Override
    public int hashCode() {

        int hash = 17;

        hash = 31 * hash + id;

        for (int i = 0; i < code.length(); i++) {
            hash = 31 * hash + code.charAt(i);
        }

        return hash;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        MyTestingClass other = (MyTestingClass) obj;

        return id == other.id &&
                code.equals(other.code);
    }

    @Override
    public String toString() {
        return id + "-" + code;
    }
}