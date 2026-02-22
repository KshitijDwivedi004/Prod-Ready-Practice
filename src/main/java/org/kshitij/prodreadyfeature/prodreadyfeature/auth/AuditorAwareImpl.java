package org.kshitij.prodreadyfeature.prodreadyfeature.auth;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
//        get securityContext
//        get authentication
//        get principle
//        get username
        return Optional.of("Kshitij");
    }
}
