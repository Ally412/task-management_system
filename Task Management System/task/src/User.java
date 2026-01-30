import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "email",  unique = true, nullable = false, length = 50)
    private String email;
    @Column(name = "password", nullable = false, length = 100)
    private String password;

    public User() {}
    public Long getId() {
        return id;
    }
    public void setUserId(Long id) {
        this.id = id;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
