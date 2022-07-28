package com.j2ee.j2eetd4.Controller;

import com.j2ee.j2eetd4.Model.User;
import com.j2ee.j2eetd4.Repositories.UserRepository;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("users")
public class UserController {

    UserRepository userRepository;

    @Autowired
    public UserController(@NonNull UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping(value = "/", produces = "application/json")
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public @ResponseBody ResponseEntity<User> find(@PathVariable Integer id) {
        return ResponseEntity.of(userRepository.findById(id));
    }

    @PostMapping()
    public User create(@RequestBody User user) {
        return userRepository.save(user);
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<User> update(@PathVariable Integer id, @RequestBody User edit) {
        final var user = userRepository.findById(id);

        if (user.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        userRepository.save(edit);

        return ResponseEntity
                .created(URI.create("/users/" + id))
                .build();

    }
}
