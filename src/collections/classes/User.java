package collections.classes;

import java.util.Objects;

public class User {
    private String name;
    private int old;
    private String phone;

    public enum HashCodeMode {
        NAME_ONLY,
        ALL_FIELDS
    }

    private HashCodeMode hashCodeMode;

    public User(String name, int old, String phone) {
        this.name = name;
        this.old = old;
        this.phone = phone;
        this.hashCodeMode = HashCodeMode.NAME_ONLY;
    }

    // Установка режима для hashCode
    public void setHashCodeMode(HashCodeMode mode) {
        this.hashCodeMode = mode;
    }

    // Переопределение метода hashCode в зависимости от установленного режима
    @Override
    public int hashCode() {
        switch (hashCodeMode) {
            case ALL_FIELDS:
                return Objects.hash(name, old, phone);
            case NAME_ONLY:
            default:
                return Objects.hash(name);
        }
    }

    // Переопределение метода equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return old == user.old && Objects.equals(name, user.name) && Objects.equals(phone, user.phone);
    }

    // Переопределение метода toString
    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", old=" + old +
                ", phone='" + phone + '\'' +
                '}';
    }
}
