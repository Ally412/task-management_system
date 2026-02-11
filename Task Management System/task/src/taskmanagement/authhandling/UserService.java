package taskmanagement.authhandling;

import jakarta.transaction.Transactional;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
//TODO: UserService must implement custom UserRegistrationService with register() method
@CommonsLog
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(userEmail).orElseThrow(() ->
        {
            log.debug(String.format("User with email %s not found",  userEmail));
            return new UsernameNotFoundException(userEmail);
        });
        return new UserAdapter(user);
    }
    @Transactional
    public void registerUser(RegistrationRequest registrationRequest) {
        User user = new User();
        user.setEmail(registrationRequest.getEmail());
        user.setPassword(passwordEncoder.encode(registrationRequest.getPassword()));
        if(userRepository.existsByEmail(user.getEmail())) {
            throw new EmailAlreadyExists("Email " + user.getEmail() + " already exists");
        } else {
            userRepository.save(user);
        }
    }
}
