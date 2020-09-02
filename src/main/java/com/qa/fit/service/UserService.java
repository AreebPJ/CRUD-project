package com.qa.fit.service;

import com.qa.fit.domain.Users;
import com.qa.fit.dto.UsersDTO;
import com.qa.fit.exceptions.UserNotFoundException;
import com.qa.fit.repo.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository urepo;
    private final ModelMapper mapper;

    private UsersDTO mapTODTO(Users users){
        return this.mapper.map(users, UsersDTO.class);
    }


    @Autowired
    public UserService(UserRepository urepo, ModelMapper mapper){
        this.urepo = urepo;
        this.mapper = mapper;
    }

    public List <UsersDTO> readAllUsers(){
        return this.urepo.findAll().stream().map(this::mapTODTO).collect(Collectors.toList());
    }
    public UsersDTO createUser(Users user){
        return this.mapTODTO( this.urepo.save(user));
    }
    public UsersDTO findUserById(Long id){
        return this.mapTODTO(this.urepo.findById(id).orElseThrow(UserNotFoundException::new));
    }
    public UsersDTO updateUser(Long id, Users user){
        Users update = this.urepo.findById(id).orElseThrow(UserNotFoundException::new);
        update.setfName(user.getfName());
        update.setlName(user.getlName());
        update.setGender(user.getGender());
        return this.mapTODTO(this.urepo.save(update));

    }
    public Boolean deleteUserById(Long id){
        if (!this.urepo.existsById(id)){
            throw new UserNotFoundException();
        }
        this.urepo.deleteById(id);
        return this.urepo.existsById(id);
    }


}
