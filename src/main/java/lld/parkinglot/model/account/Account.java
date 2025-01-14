package lld.parkinglot.model.account;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public abstract class Account {
    private String id;
    private String userName;
    private String password;
    private LocalDateTime lastAccessed;
    private Contact contact;
}