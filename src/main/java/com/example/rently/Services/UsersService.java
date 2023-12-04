package com.example.rently.Services;

import com.example.rently.Entities.UsersEntity;
import com.example.rently.Repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;

    public UsersEntity saveUser(UsersEntity user){
        return usersRepository.save(user);
    }

    public List<UsersEntity> getAllUsers() {
        return usersRepository.findAll();
    }

    public UsersEntity getUserById(int id) {
        Optional<UsersEntity> optionalUser = usersRepository.findById(id);
        return optionalUser.orElse(null);
    }

    public UsersEntity updateUser(int id, UsersEntity updatedUser) {
        if (usersRepository.existsById(id)) {
            updatedUser.setId(id);
            return usersRepository.save(updatedUser);
        } else {
            return null;
        }
    }
    public void deleteUser(int id) {
        usersRepository.deleteById(id);
    }
}
