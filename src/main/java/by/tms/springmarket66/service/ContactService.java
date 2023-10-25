package by.tms.springmarket66.service;

import by.tms.springmarket66.entity.Type;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class ContactService {
    public Set<String> getAllTypeOfContacts() {
        Set<String> typesOfContacts = new HashSet<>();
        for (Type type : Type.values()) {
            typesOfContacts.add(type.name());
        }
        return typesOfContacts;
    }
}
