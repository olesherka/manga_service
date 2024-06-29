package alisher.mc.service;

import alisher.mc.model.Genre;
import alisher.mc.model.User;
import alisher.mc.repository.GenreRepository;
import alisher.mc.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Slf4j

public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers(){
        return userRepository.getAllUsers();
    }

    public User addUser(User user){
        if(userRepository.findById(user.getUser_id()) == null){
            return userRepository.save(user);
        }
        else{
            throw new IllegalStateException("User with id(" + user.getUser_id() + ") already exist");
        }
    }

    public User findUserById(int id){
        return userRepository.findById(id);
    }

    public void deleteUserById(int id){
        userRepository.deleteById(  id);
    }

    public User findUserByName(String name){
        return userRepository.findByName(name);
    }

    public User updateUser(int user_id, User user){
        if(userRepository.findById(user_id) != null){
            user.setUser_id(user_id);
            return userRepository.save(user);
        }
        else{
            throw new NoSuchElementException("User with id(" + user_id + ") not found");
        }
    }
}