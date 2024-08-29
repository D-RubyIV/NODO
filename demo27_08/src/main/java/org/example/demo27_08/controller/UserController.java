package org.example.demo27_08.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.example.demo27_08.dto.UserDTO;
import org.example.demo27_08.entity.User;
import org.example.demo27_08.exception.CustomExceptions;
import org.example.demo27_08.exception.GlobalExceptionHandler;
import org.example.demo27_08.mapper.UserMapper;
import org.example.demo27_08.repository.UserRepository;
import org.example.demo27_08.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.List;

@RestController
@RequestMapping(value = "users")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private MessageSource messageSource;

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @GetMapping(value = "")
    public List<UserDTO> findAll() throws BindException {
        return userMapper.entityToDTOs(userRepository.findAll());
    }

    @PostMapping(value = "")
    public ResponseEntity<?> add(@Valid @RequestBody UserDTO dto) throws BindException {
        return ResponseEntity.ok(userService.save(dto));
    }

    @GetMapping(value = "{id}")
    public User findOne(@PathVariable Integer id) {
        String errorMessage = messageSource.getMessage("error.notfound", new Object[]{"John", "Hihi"}, LocaleContextHolder.getLocale());
        return userRepository.findById(id).orElseThrow(() -> new CustomExceptions.CustomResourceNotFoundException(errorMessage));
    }

//    @ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Lỗi rồi mày ơi")
//    @ExceptionHandler({CustomExceptions.CustomResourceNotFoundException.class})
//    public String handleCustomExceptions(CustomExceptions.CustomResourceNotFoundException ex) {
//        return ex.getMessage();
//    }

}


