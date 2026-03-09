package taskmanagement.authhandling;

import jakarta.transaction.Transactional;

public interface UserRegistrationService {
    void register(RegistrationRequest registrationRequest);
}
