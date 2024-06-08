//package com.example.aasha.service;
//
//import com.example.aasha.entity.User;
//import com.example.aasha.repo.UserRepo;
//import org.springframework.beans.factory.annotation.Autowired;

//public class UserDetailsServiceImpl {
//    @Autowired
//    private UserRepo userRepo;

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//
//        User user = userRepo.findByUsername(username).orElse(null);
//
//        if (user == null) {
//            throw new UsernameNotFoundException("User no found with given username");
//        }
//
//        return org.springframework.security.core.userdetails.User.builder()
//                .username(user.getUsername())
//                .password(user.getPassword())
//                .build();
//    }


